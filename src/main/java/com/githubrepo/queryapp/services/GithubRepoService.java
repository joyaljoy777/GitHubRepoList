package com.githubrepo.queryapp.services;

import com.githubrepo.queryapp.exceptions.InvalidDateException;
import com.githubrepo.queryapp.exceptions.ServerException;
import com.githubrepo.queryapp.models.githubresponsemodels.GitRepositoryResponse;

public interface GithubRepoService {

    /**
     * Return a list of popular github repositories sorted based on starts in desc order
     *
     * @param count The number of results to be fetched
     * @param createdDate The repo creation date
     * @param programmingLanguage The programming language of the code base in the repo
     *
     * @return GitRepositoryResponse
     */
    GitRepositoryResponse getPopularRepositories(int count, String createdDate, String programmingLanguage)
            throws InvalidDateException, ServerException;
}
