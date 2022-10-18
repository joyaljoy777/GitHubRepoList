
package com.githubrepo.queryapp.models.githubresponsemodels;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Permissions {

    @JsonProperty("admin")
    public Boolean admin;

    @JsonProperty("maintain")
    public Boolean maintain;

    @JsonProperty("push")
    public Boolean push;

    @JsonProperty("triage")
    public Boolean triage;


    @JsonProperty("pull")
    public Boolean pull;
}
