package com.githubrepo.queryapp.client.impl;

import com.githubrepo.queryapp.client.GithubRepoClient;
import com.githubrepo.queryapp.exceptions.ServerException;
import com.githubrepo.queryapp.models.githubresponsemodels.GitRepositoryResponse;
import com.githubrepo.queryapp.util.GithubRepoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.githubrepo.queryapp.constants.CONSTANTS.GITHUB_BASE_URL;

@Component
@Primary
@Slf4j
public class GithubRepoRestTemplateClientImpl implements GithubRepoClient {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public GitRepositoryResponse getPopularRepositories(String query, String sort, String order, int count) throws ServerException {
        try {
            String githubRepoRequestQuery = GithubRepoUtils.getGithubRepoRequestQuery(query, sort, order, count);
            log.info("Calling external github api");
            return restTemplate
                    .getForEntity(GITHUB_BASE_URL + githubRepoRequestQuery, GitRepositoryResponse.class)
                    .getBody();
        } catch (Exception ex) {
            throw new ServerException();
        }
    }
}
