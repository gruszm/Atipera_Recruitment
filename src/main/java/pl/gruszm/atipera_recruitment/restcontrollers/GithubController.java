package pl.gruszm.atipera_recruitment.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gruszm.atipera_recruitment.dataTransferObjects.GithubBranch;
import pl.gruszm.atipera_recruitment.dataTransferObjects.GithubRepository;
import pl.gruszm.atipera_recruitment.services.GithubService;

@RestController
@RequestMapping("/api")
public class GithubController
{
    @Autowired
    private GithubService githubService;

    @GetMapping("/repos/{username}")
    public ResponseEntity<?> getRepos(@PathVariable("username") String username, @RequestHeader HttpHeaders httpHeaders)
    {
        ResponseEntity<?> nonForkRepositoriesResponse = githubService.getNonForkRepositories(username, httpHeaders);

        if (!nonForkRepositoriesResponse.getStatusCode().is2xxSuccessful())
        {
            return nonForkRepositoriesResponse;
        }

        GithubRepository[] repositories = (GithubRepository[]) nonForkRepositoriesResponse.getBody();

        for (GithubRepository repo : repositories)
        {
            ResponseEntity<?> branchesResponse = githubService.getBranches(repo.getOwner().getLogin(), repo.getName(), httpHeaders);
            GithubBranch[] branches;

            if (!branchesResponse.getStatusCode().is2xxSuccessful())
            {
                return branchesResponse;
            }

            branches = (GithubBranch[]) branchesResponse.getBody();

            repo.setBranches(branches);
        }

        return ResponseEntity.ok(repositories);
    }
}
