package pl.gruszm.atipera_recruitment.dataTransferObjects;

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

    private static class Commit
    {
        private String sha;

        public String getSha()
        {
            return sha;
        }
    }
}
