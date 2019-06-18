package server.web.response_models;

public class SuccessMessage {
    String success;

    public SuccessMessage(String success) {
        this.success = success;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
