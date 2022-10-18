
package com.githubrepo.queryapp.models.githubresponsemodels;

import java.net.URI;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import lombok.Data;


/**
 * Repo Search Result Item
 * <p>
 * Repo Search Result Item
 *
 */
@Data
public class Item {


    @JsonProperty("id")
    public Integer id;

    @JsonProperty("node_id")
    public String nodeId;

    @JsonProperty("name")
    public String name;

    @JsonProperty("full_name")
    public String fullName;

    @JsonProperty("owner")
    public Owner owner;

    @JsonProperty("private")
    public Boolean _private;

    @JsonProperty("html_url")
    public URI htmlUrl;

    @JsonProperty("description")
    public String description;

    @JsonProperty("fork")
    public Boolean fork;

    @JsonProperty("url")
    public URI url;

    @JsonProperty("created_at")
    public Date createdAt;

    @JsonProperty("updated_at")
    public Date updatedAt;

    @JsonProperty("pushed_at")
    public Date pushedAt;

    @JsonProperty("homepage")
    public URI homepage;

    @JsonProperty("size")
    public Integer size;

    @JsonProperty("stargazers_count")
    public Integer stargazersCount;

    @JsonProperty("watchers_count")
    public Integer watchersCount;

    @JsonProperty("language")
    public String language;

    @JsonProperty("forks_count")
    public Integer forksCount;

    @JsonProperty("open_issues_count")
    public Integer openIssuesCount;
    @JsonProperty("master_branch")
    public String masterBranch;

    @JsonProperty("default_branch")
    public String defaultBranch;

    @JsonProperty("score")
    public Double score;

    @JsonProperty("forks_url")
    public URI forksUrl;

    @JsonProperty("keys_url")
    public String keysUrl;

    @JsonProperty("collaborators_url")
    public String collaboratorsUrl;

    @JsonProperty("teams_url")
    public URI teamsUrl;

    @JsonProperty("hooks_url")
    public URI hooksUrl;

    @JsonProperty("issue_events_url")
    public String issueEventsUrl;

    @JsonProperty("events_url")
    public URI eventsUrl;

    @JsonProperty("assignees_url")
    public String assigneesUrl;

    @JsonProperty("branches_url")
    public String branchesUrl;

    @JsonProperty("tags_url")
    public URI tagsUrl;

    @JsonProperty("blobs_url")
    public String blobsUrl;

    @JsonProperty("git_tags_url")
    public String gitTagsUrl;

    @JsonProperty("git_refs_url")
    public String gitRefsUrl;

    @JsonProperty("trees_url")
    public String treesUrl;

    @JsonProperty("statuses_url")
    public String statusesUrl;

    @JsonProperty("languages_url")
    public URI languagesUrl;

    @JsonProperty("stargazers_url")
    public URI stargazersUrl;

    @JsonProperty("contributors_url")
    public URI contributorsUrl;

    @JsonProperty("subscribers_url")
    public URI subscribersUrl;

    @JsonProperty("subscription_url")
    public URI subscriptionUrl;

    @JsonProperty("commits_url")
    public String commitsUrl;

    @JsonProperty("git_commits_url")
    public String gitCommitsUrl;

    @JsonProperty("comments_url")
    public String commentsUrl;

    @JsonProperty("issue_comment_url")
    public String issueCommentUrl;

    @JsonProperty("contents_url")
    public String contentsUrl;

    @JsonProperty("compare_url")
    public String compareUrl;

    @JsonProperty("merges_url")
    public URI mergesUrl;

    @JsonProperty("archive_url")
    public String archiveUrl;

    @JsonProperty("downloads_url")
    public URI downloadsUrl;

    @JsonProperty("issues_url")
    public String issuesUrl;

    @JsonProperty("pulls_url")
    public String pullsUrl;

    @JsonProperty("milestones_url")
    public String milestonesUrl;

    @JsonProperty("notifications_url")
    public String notificationsUrl;

    @JsonProperty("labels_url")
    public String labelsUrl;

    @JsonProperty("releases_url")
    public String releasesUrl;

    @JsonProperty("deployments_url")
    public URI deploymentsUrl;

    @JsonProperty("git_url")
    public String gitUrl;

    @JsonProperty("ssh_url")
    public String sshUrl;

    @JsonProperty("clone_url")
    public String cloneUrl;

    @JsonProperty("svn_url")
    public URI svnUrl;

    @JsonProperty("forks")
    public Integer forks;

    @JsonProperty("open_issues")
    public Integer openIssues;

    @JsonProperty("watchers")
    public Integer watchers;
    @JsonProperty("topics")
    public List<String> topics = null;

    @JsonProperty("mirror_url")
    public URI mirrorUrl;

    @JsonProperty("has_issues")
    public Boolean hasIssues;

    @JsonProperty("has_projects")
    public Boolean hasProjects;

    @JsonProperty("has_pages")
    public Boolean hasPages;

    @JsonProperty("has_wiki")
    public Boolean hasWiki;

    @JsonProperty("has_downloads")
    public Boolean hasDownloads;

    @JsonProperty("archived")
    public Boolean archived;

    @JsonProperty("disabled")
    @JsonPropertyDescription("Returns whether or not this repository disabled.")
    public Boolean disabled;

    @JsonProperty("visibility")
    @JsonPropertyDescription("The repository visibility: public, private, or internal.")
    public String visibility;

    @JsonProperty("license")
    public Object license;

    @JsonProperty("permissions")
    public Permissions permissions;

    @JsonProperty("text_matches")
    public List<TextMatch> textMatches = null;

    @JsonProperty("temp_clone_token")
    public String tempCloneToken;

    @JsonProperty("allow_merge_commit")
    public Boolean allowMergeCommit;

    @JsonProperty("allow_squash_merge")
    public Boolean allowSquashMerge;

    @JsonProperty("allow_rebase_merge")
    public Boolean allowRebaseMerge;

    @JsonProperty("allow_auto_merge")
    public Boolean allowAutoMerge;

    @JsonProperty("delete_branch_on_merge")
    public Boolean deleteBranchOnMerge;

    @JsonProperty("allow_forking")
    public Boolean allowForking;

    @JsonProperty("is_template")
    public Boolean isTemplate;

    @JsonProperty("web_commit_signoff_required")
    public Boolean webCommitSignoffRequired;
}
