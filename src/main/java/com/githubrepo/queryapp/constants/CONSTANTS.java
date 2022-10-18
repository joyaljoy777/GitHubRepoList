package com.githubrepo.queryapp.constants;

public class CONSTANTS {

	CONSTANTS() {}
	
    public static final String GITHUB_BASE_URL = "https://api.github.com/search/repositories";
    public static final String CONTENT_GITHUB_VND_JSON =  "application/vnd.github+json";
    public static final String ACCEPT_APPLICATION_VND_JSON =  "Accept: " + CONTENT_GITHUB_VND_JSON;
    public static final String DEFAULT_SORT = "stars";
    public static final String DEFAULT_ORDER = "desc";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
}
