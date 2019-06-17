package server.client;

import java.lang.reflect.Array;
import java.util.Arrays;

public class URLbuilder {
    private String username = "name=petroleumApi";
    private String password = "&password=h7BdQFbdk92d3s";
    private String requestType = "";
    private String wagonNo = "";
    private String from = "";
    private String to = "";
    private String sendDay = "";
    private String roundWagon = "";
    private String clientId = "";
    private String takeOffDay = "";
    private String allOperations = "";

    /*
     USAGE EXAMPLE:

     String url = URLbuilder.newBuilder()
                .addUserName("apiuser")
                .addPassword("password")
                .addRequestType("get_vagon")
                .addWagonNo(123)
                .set()
                .build();
        System.out.println(url);`
     */
    public URLbuilder() {

    }

    public static Builder newBuilder() {
        return new URLbuilder().new Builder();
    }

    public String build() {
        String url = "";
        String start = "xml/export.php?";
        url = start + url + username + password + requestType + wagonNo + from + to + sendDay +
                roundWagon + clientId + takeOffDay + allOperations;
        return url;
    }

    public class Builder {

        private Builder() {

        }

        public Builder addRequestType(String s) {
            URLbuilder.this.requestType = "&request_type=" + s;
            return this;
        }

        public Builder addWagonNo(int s) {
            URLbuilder.this.wagonNo = "&vagon_no=" + s;
            return this;
        }

        public Builder addFrom(int s) {
            URLbuilder.this.from = "&from=" + s;
            return this;
        }

        public Builder addTo(int s) {
            URLbuilder.this.to = "&to=" + s;
            return this;
        }

        public Builder addSendDay(String s) {
            URLbuilder.this.sendDay = "&send_day=" + s;
            return this;
        }

        public Builder addRoundWagon(String s) {
            URLbuilder.this.roundWagon = "&round_vagon=" + s;
            return this;
        }

        public Builder addClientId(String s) {
            URLbuilder.this.clientId = "&client_id=" + s;
            return this;
        }

        public Builder addClientIds(String... s) {
            URLbuilder.this.clientId = "&client_ids=";
            for (int i = 0; i < s.length; i++) {
                URLbuilder.this.clientId += s[i] + ";";
            }
            return this;
        }

        public Builder addTakeOffDay(String s) {
            URLbuilder.this.takeOffDay = "&take_off_day=" + s;
            return this;
        }

        public Builder addAllOperations(String s) {
            URLbuilder.this.allOperations = "&all_operations=" + s;
            return this;
        }

        public URLbuilder set() {
            return URLbuilder.this;
        }

    }


}
