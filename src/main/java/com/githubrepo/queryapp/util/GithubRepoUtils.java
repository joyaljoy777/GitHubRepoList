package com.githubrepo.queryapp.util;

import com.githubrepo.queryapp.models.GithubResponseDto;
import com.githubrepo.queryapp.models.githubresponsemodels.GitRepositoryResponse;
import com.githubrepo.queryapp.models.githubresponsemodels.Item;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import static com.githubrepo.queryapp.constants.CONSTANTS.DATE_FORMAT;

public class GithubRepoUtils {
	
	GithubRepoUtils() {}

    /**
     * Will return the query string for searching github repo
     *
     * @param date The creation date criteria
     * @param programmingLanguage Language of the github code base
     *
     * @return String the github query string
     */
    public static String getQueryString(String date, String programmingLanguage) {
        StringBuilder query = new StringBuilder();
        if (!isNullOrEmpty(date)) {
            query.append("created:>").append(date);
        }
        if (!isNullOrEmpty(programmingLanguage)) {
            query.append("+").append("language:").append(programmingLanguage);
        }
        return query.toString();
    }

    /**
     * Will return the full string of the github repo search request
     *
     * @param query Query string containing values for date and language
     * @param sort The sort criteria for which result should be sorted. Eg:- stars | forks
     * @param order The order criteria for which result should be ordered. Eg:- asc | desc
     * @param count The number of request to be fetched in response
     *
     * @return String the github query string
     */
    public static String getGithubRepoRequestQuery(String query, String sort, String order, int count) {
        StringBuilder urlBuilder = new StringBuilder();
        return urlBuilder.append("?q=").append(query)
                .append("&sort=").append(sort)
                .append("&order=").append(order)
                .append("&per_page=").append(count).toString();
    }

    /**
     * Check whether the given string is null or empty
     *
     * @param value The string to be checked whether null or empty
     *
     * @return boolen
     */
    public static boolean isNullOrEmpty(String value) {
        if (value == null) {
            return true;
        }
        return value.isEmpty();
    }

    /**
     * Check whether the given string date is valid date of format yyyy-MM-dd
     *
     * @param dateStr The date sting to be checked whether valid or not
     *
     * @return boolen
     */
    public static boolean isValidDate(String dateStr) {
        try {
            DateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            sdf.setLenient(false);
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Will transform the github response model into custom GithubResponseDto model
     *
     * @param githubRepo The response of github search request containing list of repo items
     *
     * @return List<GithubResponseDto>
     */
    public static List<GithubResponseDto> getGithubRepoDto(GitRepositoryResponse githubRepo) {
        return githubRepo.getItems().stream()
                .map(GithubRepoUtils::getGitRepoItem)
                .collect(Collectors.toList());
    }

    private static GithubResponseDto getGitRepoItem(Item item) {
        return GithubResponseDto.builder()
                .id(item.getId()).githubRepoName(item.getName())
                .gitrepoUrl(item.getUrl().toString()).ownerName(item.getOwner().getLogin())
                .ownerGitAccountUrl(item.getOwner().getHtmlUrl())
                .createdAt(item.getCreatedAt()).size(item.getSize())
                .language(item.getLanguage()).defaultBranch(item.getDefaultBranch())
                .forks(item.getForks()).stars(item.getWatchers())
                .openIssues(item.getOpenIssues()).build();
    }
}
