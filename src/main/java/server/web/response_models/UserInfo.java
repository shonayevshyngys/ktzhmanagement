package server.web.response_models;

import java.util.Date;

public class UserInfo {
    private long id;
    private Date lastLoginTime;
    private String ip;
    private int numberOfLogins;
    private int numberOfWagonsNow;
    private int numberOfUpdateCalls;
    private int numberOfAddedWagons;
    private int numberOfTakeOffs;

    public UserInfo(long id, Date lastLoginTime, String ip, int numberOfLogins, int numberOfWagonsNow, int numberOfUpdateCalls, int numberOfAddedWagons, int numberOfTakeOffs) {
        this.id = id;
        this.lastLoginTime = lastLoginTime;
        this.ip = ip;
        this.numberOfLogins = numberOfLogins;
        this.numberOfWagonsNow = numberOfWagonsNow;
        this.numberOfUpdateCalls = numberOfUpdateCalls;
        this.numberOfAddedWagons = numberOfAddedWagons;
        this.numberOfTakeOffs = numberOfTakeOffs;
    }

    public UserInfo() {
    }

    public int getNumberOfAddedWagons() {
        return numberOfAddedWagons;
    }

    public void setNumberOfAddedWagons(int numberOfAddedWagons) {
        this.numberOfAddedWagons = numberOfAddedWagons;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getNumberOfLogins() {
        return numberOfLogins;
    }

    public void setNumberOfLogins(int numberOfLogins) {
        this.numberOfLogins = numberOfLogins;
    }

    public int getNumberOfWagonsNow() {
        return numberOfWagonsNow;
    }

    public void setNumberOfWagonsNow(int numberOfWagonsNow) {
        this.numberOfWagonsNow = numberOfWagonsNow;
    }

    public int getNumberOfUpdateCalls() {
        return numberOfUpdateCalls;
    }

    public void setNumberOfUpdateCalls(int numberOfUpdateCalls) {
        this.numberOfUpdateCalls = numberOfUpdateCalls;
    }

    public int getNumberOfTakeOffs() {
        return numberOfTakeOffs;
    }

    public void setNumberOfTakeOffs(int numberOfTakeOffs) {
        this.numberOfTakeOffs = numberOfTakeOffs;
    }
}
