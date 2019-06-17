package server.client_model;

public class Depot_start {
    private Depot depot;

    public Depot getDepot ()
    {
        return depot;
    }

    public void setDepot (Depot depot)
    {
        this.depot = depot;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [depot = "+depot+"]";
    }
}
