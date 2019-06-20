package server.client_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class Road {
    @JsonIgnoreProperties(ignoreUnknown = true)
    private List<String> name;
    private long road_code;
    private String road_name;

    public String getRoad_name() {
        return road_name;
    }

    public void setRoad_name(String road_name) {
        this.road_name = road_name;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public long getRoad_code() {
        return road_code;
    }

    public void setRoad_code(long road_code) {
        this.road_code = road_code;
    }

    @Override
    public String toString() {
        return "ClassPojo [name = " + name + ", road_code = " + road_code + "]";
    }
}
