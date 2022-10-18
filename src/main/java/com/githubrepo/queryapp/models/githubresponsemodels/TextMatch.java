
package com.githubrepo.queryapp.models.githubresponsemodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TextMatch {

    @JsonProperty("object_url")
    public String objectUrl;

    @JsonProperty("object_type")
    public String objectType;

    @JsonProperty("property")
    public String property;

    @JsonProperty("fragment")
    public String fragment;

    @JsonProperty("matches")
    public List<Match> matches = null;

}
