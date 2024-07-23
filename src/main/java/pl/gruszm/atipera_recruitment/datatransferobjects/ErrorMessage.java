package pl.gruszm.atipera_recruitment.datatransferobjects;

public class ErrorMessage
{
    private String status;
    private String message;

    public ErrorMessage(int responseCode, String message)
    {
        this.status = String.format("${%d}", responseCode);
        this.message = String.format("${%s}", message);
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
