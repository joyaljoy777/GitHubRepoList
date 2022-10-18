package com.githubrepo.queryapp.controller;

import com.githubrepo.queryapp.exceptions.InvalidDateException;
import com.githubrepo.queryapp.exceptions.ServerException;
import com.githubrepo.queryapp.models.GithubResponseDto;
import com.githubrepo.queryapp.services.GithubRepoService;
import com.githubrepo.queryapp.util.GithubRepoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/github")
public class GithubRepoController {

    @Autowired
    GithubRepoService githubRepoService;

    /**
     * Will return a list of popular github repositories
     *
     * @param count The number of results to be fetched in single query
     * @param createdDate The repo creation date filter
     * @param programmingLanguage The programming language of the code base in the repo
     *
     * @return List<GithubResponseDto>
     */
    @GetMapping("/popularRepositories")
    public ResponseEntity<List<GithubResponseDto>> getGithubPublicRepos(
            @RequestParam(defaultValue = "10") @Min(value = 1, message = "The count should be valid number greater than 0") int count,
            @RequestParam(defaultValue = "2019-01-10") @NotBlank String createdDate,
            @RequestParam(required = false) String programmingLanguage) throws InvalidDateException, ServerException {

        var githubRepo = githubRepoService.getPopularRepositories(count, createdDate, programmingLanguage);
        return ResponseEntity.status(HttpStatus.OK).body(GithubRepoUtils.getGithubRepoDto(githubRepo));
    }
}
