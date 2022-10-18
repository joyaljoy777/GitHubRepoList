package com.githubrepo.queryapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.githubrepo.queryapp.client.GithubRepoClient;
import com.githubrepo.queryapp.exceptions.InvalidDateException;
import com.githubrepo.queryapp.exceptions.ServerException;
import com.githubrepo.queryapp.models.githubresponsemodels.GitRepositoryResponse;
import com.githubrepo.queryapp.services.impl.GithubRepoServiceImpl;
import com.githubrepo.queryapp.util.GithubRepoUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static com.githubrepo.queryapp.constants.CONSTANTS.DEFAULT_ORDER;
import static com.githubrepo.queryapp.constants.CONSTANTS.DEFAULT_SORT;

@RunWith(MockitoJUnitRunner.class)
public class GithubRepoServiceTest {

    private static int count;
    private static String createdDate;
    private static String programmingLanguage;
    private static GitRepositoryResponse sampleResponse;

    @Mock
    private GithubRepoClient githubRepoClient;

    @InjectMocks
    private GithubRepoServiceImpl githubRepoService;

    @Before
    public void setUp() throws IOException {
        count = 20;
        createdDate = "2019-01-10";
        programmingLanguage = "java";
        ObjectMapper objectMapper = new ObjectMapper();
        sampleResponse = objectMapper.readValue(
                new File("src/test/resources/sample_github_response.json"), GitRepositoryResponse.class);
    }

    @Test
    public void testGetRepositories() throws ServerException, InvalidDateException {

        String query = GithubRepoUtils.getQueryString(createdDate, programmingLanguage);
        Mockito.when(githubRepoClient.getPopularRepositories(query, DEFAULT_SORT, DEFAULT_ORDER, count)).thenReturn(sampleResponse);
        GitRepositoryResponse response = githubRepoService.getPopularRepositories(count, createdDate, programmingLanguage);

        assertNotNull(response);
        assertNotNull(response.getItems());
        assertEquals(20, response.getItems().size());

    }
}