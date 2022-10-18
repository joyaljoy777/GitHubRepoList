package com.githubrepo.queryapp.services.impl;

import com.githubrepo.queryapp.client.GithubRepoClient;
import com.githubrepo.queryapp.exceptions.InvalidDateException;
import com.githubrepo.queryapp.exceptions.ServerException;
import com.githubrepo.queryapp.models.githubresponsemodels.GitRepositoryResponse;
import com.githubrepo.queryapp.services.GithubRepoService;
import com.githubrepo.queryapp.util.GithubRepoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.githubrepo.queryapp.constants.CONSTANTS.*;

@Service
@Slf4j
public class GithubRepoServiceImpl implements GithubRepoService {

    @Autowired
    GithubRepoClient githubRepoClient;

    /**
     * Return a list of popular github repositories sorted based on starts in desc order
     *
     * @param count The number of results to be fetched
     * @param createdDate The repo creation date
     * @param programmingLanguage The programming language of the code base in the repo
     * @return GitRepositoryResponse
     */
    @Override
    public GitRepositoryResponse getPopularRepositories(int count, String createdDate,
                                                        String programmingLanguage) throws InvalidDateException, ServerException {
        if(!GithubRepoUtils.isValidDate(createdDate))
            throw new InvalidDateException();
        String query = GithubRepoUtils.getQueryString(createdDate, programmingLanguage);
        return githubRepoClient.getPopularRepositories(query, DEFAULT_SORT, DEFAULT_ORDER, count);
    }
}
