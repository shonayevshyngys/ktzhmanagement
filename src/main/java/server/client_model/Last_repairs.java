package server.client_model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

public class Last_repairs {
    @JacksonXmlElementWrapper(useWrapping=false)
    private List<Repair> repair;

    public List<Repair> getRepair() {
        return repair;
    }

    public void setRepair(List<Repair> repair) {
        this.repair = repair;
    }

    @Override
    public String toString() {
        return "ClassPojo [repair = " + repair + "]";
    }
}
