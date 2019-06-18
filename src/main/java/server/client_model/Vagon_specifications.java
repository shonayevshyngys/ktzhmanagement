package server.client_model;

public class Vagon_specifications {
    private String next_repair_date;

    private Vagon_model vagon_model;

    private String mileage_current_date;

    private String vagon_type;

    private String type;

    private Vagon_type_desc vagon_type_desc;

    private String capacity;

    private String date_last_kap_repair;

    private String max_service_date;

    private String mileage_left_date;

    private String build_date;

    private String registration_date;

    private String mileage_current;

    private String tare;

    private String model;

    private String mileage_left;

    private String next_repair_type;

    private String vagon_no;

    private Registration_reason registration_reason;

    private String date_last_dep_repair;

    public String getNext_repair_date ()
    {
        return next_repair_date;
    }

    public void setNext_repair_date (String next_repair_date)
    {
        this.next_repair_date = next_repair_date;
    }

    public Vagon_model getVagon_model ()
    {
        return vagon_model;
    }

    public void setVagon_model (Vagon_model vagon_model)
    {
        this.vagon_model = vagon_model;
    }

    public String getMileage_current_date ()
    {
        return mileage_current_date;
    }

    public void setMileage_current_date (String mileage_current_date)
    {
        this.mileage_current_date = mileage_current_date;
    }

    public String getVagon_type ()
    {
        return vagon_type;
    }

    public void setVagon_type (String vagon_type)
    {
        this.vagon_type = vagon_type;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public Vagon_type_desc getVagon_type_desc ()
    {
        return vagon_type_desc;
    }

    public void setVagon_type_desc (Vagon_type_desc vagon_type_desc)
    {
        this.vagon_type_desc = vagon_type_desc;
    }

    public String getCapacity ()
    {
        return capacity;
    }

    public void setCapacity (String capacity)
    {
        this.capacity = capacity;
    }

    public String getDate_last_kap_repair ()
    {
        return date_last_kap_repair;
    }

    public void setDate_last_kap_repair (String date_last_kap_repair)
    {
        this.date_last_kap_repair = date_last_kap_repair;
    }

    public String getMax_service_date ()
    {
        return max_service_date;
    }

    public void setMax_service_date (String max_service_date)
    {
        this.max_service_date = max_service_date;
    }

    public String getMileage_left_date ()
    {
        return mileage_left_date;
    }

    public void setMileage_left_date (String mileage_left_date)
    {
        this.mileage_left_date = mileage_left_date;
    }

    public String getBuild_date ()
    {
        return build_date;
    }

    public void setBuild_date (String build_date)
    {
        this.build_date = build_date;
    }

    public String getRegistration_date ()
    {
        return registration_date;
    }

    public void setRegistration_date (String registration_date)
    {
        this.registration_date = registration_date;
    }

    public String getMileage_current ()
    {
        return mileage_current;
    }

    public void setMileage_current (String mileage_current)
    {
        this.mileage_current = mileage_current;
    }

    public String getTare ()
    {
        return tare;
    }

    public void setTare (String tare)
    {
        this.tare = tare;
    }

    public String getModel ()
    {
        return model;
    }

    public void setModel (String model)
    {
        this.model = model;
    }

    public String getMileage_left ()
    {
        return mileage_left;
    }

    public void setMileage_left (String mileage_left)
    {
        this.mileage_left = mileage_left;
    }

    public String getNext_repair_type ()
    {
        return next_repair_type;
    }

    public void setNext_repair_type (String next_repair_type)
    {
        this.next_repair_type = next_repair_type;
    }

    public String getVagon_no ()
    {
        return vagon_no;
    }

    public void setVagon_no (String vagon_no)
    {
        this.vagon_no = vagon_no;
    }

    public Registration_reason getRegistration_reason ()
    {
        return registration_reason;
    }

    public void setRegistration_reason (Registration_reason registration_reason)
    {
        this.registration_reason = registration_reason;
    }

    public String getDate_last_dep_repair ()
    {
        return date_last_dep_repair;
    }

    public void setDate_last_dep_repair (String date_last_dep_repair)
    {
        this.date_last_dep_repair = date_last_dep_repair;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [next_repair_date = "+next_repair_date+", vagon_model = "+vagon_model+", mileage_current_date = "+mileage_current_date+", vagon_type = "+vagon_type+", type = "+type+", vagon_type_desc = "+vagon_type_desc+", capacity = "+capacity+", date_last_kap_repair = "+date_last_kap_repair+", max_service_date = "+max_service_date+", mileage_left_date = "+mileage_left_date+", build_date = "+build_date+", registration_date = "+registration_date+", mileage_current = "+mileage_current+", tare = "+tare+", server.client_model = "+model+", mileage_left = "+mileage_left+", next_repair_type = "+next_repair_type+", vagon_no = "+vagon_no+", registration_reason = "+registration_reason+", date_last_dep_repair = "+date_last_dep_repair+"]";
    }
}
