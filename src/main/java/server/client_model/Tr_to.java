package server.client_model;

public class Tr_to {
    private String country_code;

    private String name_ru;

    private String name_de;

    private String station_code;

    private String road_code;

    private String name_lv;

    private String country_code_iso;

    private String name_cn;

    private String name_en;

    public String getCountry_code ()
    {
        return country_code;
    }

    public void setCountry_code (String country_code)
    {
        this.country_code = country_code;
    }

    public String getName_ru ()
    {
        return name_ru;
    }

    public void setName_ru (String name_ru)
    {
        this.name_ru = name_ru;
    }

    public String getName_de ()
    {
        return name_de;
    }

    public void setName_de (String name_de)
    {
        this.name_de = name_de;
    }

    public String getStation_code ()
    {
        return station_code;
    }

    public void setStation_code (String station_code)
    {
        this.station_code = station_code;
    }

    public String getRoad_code ()
    {
        return road_code;
    }

    public void setRoad_code (String road_code)
    {
        this.road_code = road_code;
    }

    public String getName_lv ()
    {
        return name_lv;
    }

    public void setName_lv (String name_lv)
    {
        this.name_lv = name_lv;
    }

    public String getCountry_code_iso ()
    {
        return country_code_iso;
    }

    public void setCountry_code_iso (String country_code_iso)
    {
        this.country_code_iso = country_code_iso;
    }

    public String getName_cn ()
    {
        return name_cn;
    }

    public void setName_cn (String name_cn)
    {
        this.name_cn = name_cn;
    }

    public String getName_en ()
    {
        return name_en;
    }

    public void setName_en (String name_en)
    {
        this.name_en = name_en;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [country_code = "+country_code+", name_ru = "+name_ru+", name_de = "+name_de+", station_code = "+station_code+", road_code = "+road_code+", name_lv = "+name_lv+", country_code_iso = "+country_code_iso+", name_cn = "+name_cn+", name_en = "+name_en+"]";
    }
}
