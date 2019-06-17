package server.client_model;

public class Repair_station {
    private Station station;

    public Station getStation ()
    {
        return station;
    }

    public void setStation (Station station)
    {
        this.station = station;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [station = "+station+"]";
    }
}
