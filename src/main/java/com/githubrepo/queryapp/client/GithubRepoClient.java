package com.githubrepo.queryapp.client;

import com.githubrepo.queryapp.exceptions.ServerException;
import com.githubrepo.queryapp.models.githubresponsemodels.GitRepositoryResponse;

public interface GithubRepoClient {
    GitRepositoryResponse getPopularRepositories(String query, String sort, String order, int count) throws ServerException;
}
