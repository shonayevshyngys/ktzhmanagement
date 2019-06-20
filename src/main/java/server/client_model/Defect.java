package server.client_model;

public class Defect {
    private long code;

    private String description;

    public Long getCode() {
        return code;
    }

    public void setCode(long code) {
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
