package server.client_model;

public class RoadShatal {
    private String road_name;

    private String road_code;

    public String getRoad_name ()
    {
        return road_name;
    }

    public void setRoad_name (String road_name)
    {
        this.road_name = road_name;
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
        return "ClassPojo [road_name = "+road_name+", road_code = "+road_code+"]";
    }
}
