package pl.gruszm.atipera_recruitment.dataTransferObjects;

public class GithubRepository
{
    private String name;
    private Owner owner;
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

    public Owner getOwner()
    {
        return owner;
    }

    public GithubBranch[] getBranches()
    {
        return branches;
    }

    public void setBranches(GithubBranch[] branches)
    {
        this.branches = branches;
    }

    public static class Owner
    {
        private String login;

        public String getLogin()
        {
            return login;
        }
    }
}
