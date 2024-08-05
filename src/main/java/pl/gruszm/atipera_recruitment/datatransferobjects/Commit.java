package pl.gruszm.atipera_recruitment.datatransferobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Commit
{
    private String sha;

    public void setSha(String sha)
    {
        this.sha = sha;
    }

    public String getSha()
    {
        return sha;
    }
}