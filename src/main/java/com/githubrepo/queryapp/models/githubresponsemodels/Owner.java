
package com.githubrepo.queryapp.models.githubresponsemodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("login")
    public String login;

    @JsonProperty("node_id")
    public String nodeId;

    @JsonProperty("avatar_url")
    public String avatarUrl;

    @JsonProperty("gravatar_id")
    public String gravatarId;

    @JsonProperty("url")
    public String url;

    @JsonProperty("html_url")
    public String htmlUrl;

    @JsonProperty("followers_url")
    public String followersUrl;

    @JsonProperty("following_url")
    public String followingUrl;

    @JsonProperty("gists_url")
    public String gistsUrl;

    @JsonProperty("starredUrl")
    public String starred_url;

    @JsonProperty("subscriptionsUrl")
    public String subscriptions_url;

    @JsonProperty("organizationsUrl")
    public String organizations_url;

    @JsonProperty("repos_url")
    public String reposUrl;

    @JsonProperty("events_url")
    public String eventsUrl;

    @JsonProperty("received_events_url")
    public String receivedEventsUrl;

    @JsonProperty("type")
    public String type;

    @JsonProperty("site_admin")
    public String siteSdmin;

}
