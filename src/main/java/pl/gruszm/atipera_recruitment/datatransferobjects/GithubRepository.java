package pl.gruszm.atipera_recruitment.datatransferobjects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepository
{
    private String name;
    private Owner owner;
    @JsonIgnore
    private boolean fork;
    private GithubBranch[] branches;

    public boolean isFork()
    {
        return fork;
    }

    public String getName()
    {
        return name;
    }

    public GithubBranch[] getBranches()
    {
        return branches;
    }

    public Owner getOwner()
    {
        return owner;
    }

    public void setBranches(GithubBranch[] branches)
    {
        this.branches = branches;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setOwner(Owner owner)
    {
        this.owner = owner;
    }

    public void setFork(boolean fork)
    {
        this.fork = fork;
    }
}
