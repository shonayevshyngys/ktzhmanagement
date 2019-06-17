package server.client_model;

public class Corrected_etsng {
    private String code;

    private String name;

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [code = "+code+", name = "+name+"]";
    }
}
