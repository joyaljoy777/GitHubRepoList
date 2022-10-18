package com.githubrepo.queryapp.client.impl;

import com.githubrepo.queryapp.client.GithubRepoClient;
import com.githubrepo.queryapp.models.githubresponsemodels.GitRepositoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static com.githubrepo.queryapp.constants.CONSTANTS.*;

@FeignClient(name = "githubRepositories", url = GITHUB_BASE_URL, primary = false)
public interface GithubRepoFeignClientImpl extends GithubRepoClient {

    @RequestMapping(method=RequestMethod.GET)
//    @Headers(ACCEPT_APPLICATION_VND_JSON)
    GitRepositoryResponse getPopularRepositories(@RequestParam(value="q") String query,
                                                 @RequestParam(value="sort") String sort,
                                                 @RequestParam(value="order") String order,
                                                 @RequestParam(value="per_page") int count);
}
