package server.client_model;

public class Depot {
    private String code;

    private String description_long;

    private String description;

    private String road_code;

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public String getDescription_long ()
    {
        return description_long;
    }

    public void setDescription_long (String description_long)
    {
        this.description_long = description_long;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getRoad_code ()
    {
        return road_code;
    }

    public void setRoad_code (String road_code)
    {
        this.road_code = road_code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [code = "+code+", description_long = "+description_long+", description = "+description+", road_code = "+road_code+"]";
    }
}
