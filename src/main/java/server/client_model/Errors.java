package server.client_model;

public class Errors {
    private String error;

    public String getError ()
    {
        return error;
    }

    public void setError (String error)
    {
        this.error = error;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [error = "+error+"]";
    }
}
