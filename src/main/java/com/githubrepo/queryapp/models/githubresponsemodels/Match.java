
package com.githubrepo.queryapp.models.githubresponsemodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Match {

    @JsonProperty("text")
    public String text;

    @JsonProperty("indices")
    public List<Integer> indices = null;
}
