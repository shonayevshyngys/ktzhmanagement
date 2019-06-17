package server.client_model;

public class Waybill {
    private String send_date;

    public String getSend_date ()
    {
        return send_date;
    }

    public void setSend_date (String send_date)
    {
        this.send_date = send_date;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [send_date = "+send_date+"]";
    }
}
