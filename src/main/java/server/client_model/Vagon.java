package server.client_model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

public class Vagon {
    private Vagon_info vagon_info;
    @JacksonXmlElementWrapper(useWrapping=false)
    private List<Position> position;
//    private String status;
    private String vagon_no;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Vagon() {}

    public String getVagon_no() {
        return vagon_no;
    }

    public void setVagon_no(String vagon_no) {
        this.vagon_no = vagon_no;
    }

//    public String getStatus() {
//        return status;
//    }

//    public void setStatus(String status) {
//        this.status = status;
//    }

    public Vagon_info getVagon_info() {
        return vagon_info;
    }

    public void setVagon_info(Vagon_info vagon_info) {
        this.vagon_info = vagon_info;
    }

    public List<Position> getPosition() {
        return position;
    }

    public void setPosition(List<Position> position) {
        this.position = position;
    }
}
