package pl.gruszm.atipera_recruitment.datatransferobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubBranch
{
    private String name;
    private Commit commit;

    public String getName()
    {
        return name;
    }

    public Commit getCommit()
    {
        return commit;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCommit(Commit commit)
    {
        this.commit = commit;
    }
}
