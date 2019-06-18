package server.web.request_models;

public class CreateWagon {
    String no_wagon;
    String send_day;
    String takeoff_day;
    String from;
    String to;

    public CreateWagon(String no_wagon, String send_day, String takeoff_day, String from, String to) {
        this.no_wagon = no_wagon;
        this.send_day = send_day;
        this.takeoff_day = takeoff_day;
        this.from = from;
        this.to = to;
    }

    public CreateWagon() {
    }

    public String getNo_wagon() {
        return no_wagon;
    }

    public void setNo_wagon(String no_wagon) {
        this.no_wagon = no_wagon;
    }

    public String getSend_day() {
        return send_day;
    }

    public void setSend_day(String send_day) {
        this.send_day = send_day;
    }

    public String getTakeoff_day() {
        return takeoff_day;
    }

    public void setTakeoff_day(String takeoff_day) {
        this.takeoff_day = takeoff_day;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
