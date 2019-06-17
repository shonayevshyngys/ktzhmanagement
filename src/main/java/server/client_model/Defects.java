package server.client_model;

public class Defects {
    private Defect defect;

    public Defect getDefect ()
    {
        return defect;
    }

    public void setDefect (Defect defect)
    {
        this.defect = defect;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [defect = "+defect+"]";
    }
}
