package server.client_model;

public class Repair_type {
    private long code;

    private String description;

    public long getCode ()
    {
        return code;
    }

    public void setCode (long code)
    {
        this.code = code;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [code = "+code+", description = "+description+"]";
    }
}
