package server.client_model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "data")
public class Data {

    private String current_time;
    private String time_zone;
    private List<Vagon> vagon;
    private Result result;
    private User user;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Vagon> getVagon() {
        return vagon;
    }

    public void setVagon(List<Vagon> vagon) {
        this.vagon = vagon;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

//    public List<Vagon> getVagon() {
//        return vagon;
//    }
//
//    public void setVagon(List<Vagon> vagon) {
//        this.vagon = vagon;
//    }
}
