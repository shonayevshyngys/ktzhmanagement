package server.client_model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

public class Upgrades {
    @JacksonXmlElementWrapper(useWrapping=false)
    private List<Upgrade> upgrade;

    public List<Upgrade> getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(List<Upgrade> upgrade) {
        this.upgrade = upgrade;
    }

    @Override
    public String toString() {
        return "ClassPojo [upgrade = " + upgrade + "]";
    }
}
