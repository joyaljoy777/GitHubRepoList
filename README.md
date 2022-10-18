# Popular repositories on GitHub.


### Problem Statement
The idea of this project is to implement a backend application for discovering popular
repositories on GitHub.
#### Service Specification
The service should be able to provide:
- A list of the most popular repositories, sorted by number of stars.
- An option to be able to view the top 10, 50, 100 repositories should be available.
- Given a date, the most popular repositories created from this date onwards should be
returned.
- A filter for the programming language would be a great addition to have.

#### Thing used for the implementation
- Java 11
- Spring boot 2.7.4
- Junit 4
- Swagger OpenAPI
- Models auto generated from jsonschema2pojo.org using github response schema
- Deployed in GKE using GitActions

#### API Structure
![API Structure](https://github.com/joyaljoy777/GitHubRepoList/blob/develop/GitRepositoryApi.PNG)


Sample Request:- http://localhost:8080/github/popularRepositories?count=10&createdDate=2019-01-11&programmingLanguage=java

#### Test Reprt
![Test Rerport](https://github.com/joyaljoy777/GitHubRepoList/blob/develop/Test_Report.PNG)

#### Live Demo of the Applicaion
- A live version of the application is deployed using Google Kubernetes Engine (GKE) and GitActions in Google Cloud Platform (GCP).
- Please use the url:- 201.159.193.35.bc.googleusercontent.com/swagger-ui/index.html for checking out the API using swagger documentation. (The link is generated using Reverse IP lookup).
