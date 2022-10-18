
package com.githubrepo.queryapp.models.githubresponsemodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GitRepositoryResponse {


    @JsonProperty("total_count")
    public Integer totalCount;

    @JsonProperty("incomplete_results")
    public Boolean incompleteResults;

    @JsonProperty("items")
    public List<Item> items = null;

}
