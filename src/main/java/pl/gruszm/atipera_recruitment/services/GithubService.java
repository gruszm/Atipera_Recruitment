package pl.gruszm.atipera_recruitment.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClient;
import pl.gruszm.atipera_recruitment.dataTransferObjects.ErrorMessage;
import pl.gruszm.atipera_recruitment.dataTransferObjects.GithubBranch;
import pl.gruszm.atipera_recruitment.dataTransferObjects.GithubRepository;

import java.util.Arrays;

@Service
public class GithubService
{
    private RestClient restClient = RestClient.create();
    private static final String PATH_BASE = "https://api.github.com/";

    public ResponseEntity<?> getNonForkRepositories(String username, HttpHeaders httpHeaders)
    {
        try
        {
            ResponseEntity<GithubRepository[]> response = restClient.get()
                    .uri(PATH_BASE + "/users/" + username + "/repos")
                    .accept(httpHeaders.getAccept().toArray(new MediaType[0]))
                    .retrieve()
                    .toEntity(GithubRepository[].class);

            GithubRepository[] repositories = Arrays.asList(response.getBody())
                    .stream()
                    .filter(repo -> !repo.isFork())
                    .toList()
                    .toArray(new GithubRepository[0]);

            return ResponseEntity.ok(repositories);
        }
        catch (HttpClientErrorException | HttpServerErrorException e)
        {
            return createErrorMessage(e);
        }
    }

    public ResponseEntity<?> getBranches(String owner, String repositoryName, HttpHeaders httpHeaders)
    {
        try
        {
            ResponseEntity<GithubBranch[]> response = restClient
                    .get()
                    .uri(PATH_BASE + "repos/" + owner + "/" + repositoryName + "/" + "branches")
                    .accept(httpHeaders.getAccept().toArray(new MediaType[0]))
                    .retrieve()
                    .toEntity(GithubBranch[].class);

            return ResponseEntity.ok(response.getBody());
        }
        catch (HttpClientErrorException | HttpServerErrorException e)
        {
            return createErrorMessage(e);
        }
    }

    private ResponseEntity<?> createErrorMessage(HttpStatusCodeException e)
    {
        ErrorMessage errorMessage = new ErrorMessage(e.getStatusCode().value(), e.getMessage());

        return ResponseEntity
                .status(e.getStatusCode())
                .body(errorMessage);
    }
}