package server.client_model;

import java.util.List;

public class Registration_reason {
    private String code;

    private List<String> name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassPojo [code = " + code + ", name = " + name + "]";
    }
}
