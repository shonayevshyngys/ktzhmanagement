package server.client_model;

public class Repair_call_road {
    private Road road;

    public Road getRoad()
    {
        return road;
    }

    public void setRoad(Road road)
    {
        this.road = road;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [road = "+ road +"]";
    }
}
