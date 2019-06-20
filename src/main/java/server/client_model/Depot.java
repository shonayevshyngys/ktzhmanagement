package server.client_model;

public class Depot {
    private long code;

    private String description_long;

    private String description;

    private long road_code;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getRoad_code() {
        return road_code;
    }

    public void setRoad_code(long road_code) {
        this.road_code = road_code;
    }

    public String getDescription_long() {
        return description_long;
    }

    public void setDescription_long(String description_long) {
        this.description_long = description_long;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "ClassPojo [code = " + code + ", description_long = " + description_long + ", description = " + description + ", road_code = " + road_code + "]";
    }
}
