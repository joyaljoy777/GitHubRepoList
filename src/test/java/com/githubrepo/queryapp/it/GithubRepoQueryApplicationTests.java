package com.githubrepo.queryapp.it;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.githubrepo.queryapp.GithubRepoQueryApplication;
import com.githubrepo.queryapp.models.GithubResponseDto;
import com.githubrepo.queryapp.util.GithubRepoUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = GithubRepoQueryApplication.class)
@AutoConfigureMockMvc
class GithubRepoQueryApplicationTests {

	private static int count = 10;
	private static String createdDate = "2019-01-10";
	private static String programmingLanguage = "java";
	private static final String BASE_URL = "/github/popularRepositories";

	@Autowired
	private MockMvc mvc;

	@Test
	void testGithubRepoApi() throws Exception {
		//	Checking for count=10
		MvcResult result = invokeGitHubApiCall(getGithubRepoQueryUrl(count, createdDate, programmingLanguage));
		var gitHubRepResponse = getTransformedResponse(result.getResponse().getContentAsString());
		assertNotNull(gitHubRepResponse);
		assertTrue(gitHubRepResponse.size() > 0);
		assertEquals(count, gitHubRepResponse.size());
	}

	@Test
	void testGithubRepoApiForDifferentCount() throws Exception {
		// Checking for a different count
		count = 40;
		MvcResult result = invokeGitHubApiCall(getGithubRepoQueryUrl(count, createdDate, programmingLanguage));
		var gitHubRepResponse = getTransformedResponse(result.getResponse().getContentAsString());
		assertNotNull(gitHubRepResponse);
		assertTrue(gitHubRepResponse.size() > 0);
		assertEquals(count, gitHubRepResponse.size());

	}

	@Test
	void testGithubRepoApiWithNoLanguage() throws Exception {
		// Checking for a different count
		count = 20;
		MvcResult result = invokeGitHubApiCall(getGithubRepoQueryUrl(count, createdDate, null));
		var gitHubRepResponse = getTransformedResponse(result.getResponse().getContentAsString());
		assertNotNull(gitHubRepResponse);
		assertTrue(gitHubRepResponse.size() > 0);
		assertEquals(count, gitHubRepResponse.size());

	}

	@Test
	void testGithubRepoApiForInvalidCount() throws Exception {
		// Checking for invalid count
		mvc.perform(get(BASE_URL + getGithubRepoQueryUrl(0, createdDate, programmingLanguage))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	void testGithubRepoApiForInvalidDate() throws Exception {
		// Checking for invalid createdDate
		mvc.perform(get(BASE_URL + getGithubRepoQueryUrl(count, "12-12-2021", programmingLanguage))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

	}

	private MvcResult invokeGitHubApiCall(String query) throws Exception {
		return mvc.perform(get(BASE_URL + query)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	private List<GithubResponseDto> getTransformedResponse(String jsonResponse) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<GithubResponseDto>> typeReference = new TypeReference<List<GithubResponseDto>>() {};
		return mapper.readValue(jsonResponse, typeReference);
	}

	private String getGithubRepoQueryUrl(int count, String date, String language) {
		String query = "?count=" + count + "&createdDate=" + date;
		if(GithubRepoUtils.isNullOrEmpty(language))
			query += "&programmingLanguage=" + language;
		return query;
	}
}
