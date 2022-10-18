
package com.githubrepo.queryapp.models;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * DTO for simplified github repositories response
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@Generated("jsonschema2pojo")
public class GithubResponseDto {

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("gitrepo_name")
    public String githubRepoName;

    @JsonProperty("gitrepo_url")
    public String gitrepoUrl;

    @JsonProperty("owner_name")
    public String ownerName;

    @JsonProperty("owner_git_account_url")
    public String ownerGitAccountUrl;

    @JsonProperty("created_at")
    public Date createdAt;

    @JsonProperty("size")
    public Integer size;

    @JsonProperty("language")
    public String language;

    @JsonProperty("default_branch")
    public String defaultBranch;

    @JsonProperty("forks")
    public Integer forks;

    @JsonProperty("stars")
    public Integer stars;

    @JsonProperty("open_issues")
    public Integer openIssues;

}
