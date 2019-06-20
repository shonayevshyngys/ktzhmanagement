package server.client_model;

public class Repair {

    private long broken;

    private Repair_call_road repair_call_road;

    private long vu36_number;

    private Depot_start depot_start;

    private Repair_station repair_station;

    private Upgrades upgrades;

    private String repair_end_datetime;

    private long loaded;

    private Repair_end_station repair_end_station;

    private Depot_end depot_end;

    private long vu23_number;

    private Repair_type repair_type;

    private Defects defects;

    private String repair_call_datetime;

    private String repair_start_datetime;

    private long vagon_no;

    public long getBroken() {
        return broken;
    }

    public void setBroken(long broken) {
        this.broken = broken;
    }

    public Repair_call_road getRepair_call_road() {
        return repair_call_road;
    }

    public void setRepair_call_road(Repair_call_road repair_call_road) {
        this.repair_call_road = repair_call_road;
    }

    public Depot_start getDepot_start() {
        return depot_start;
    }

    public void setDepot_start(Depot_start depot_start) {
        this.depot_start = depot_start;
    }

    public Repair_station getRepair_station() {
        return repair_station;
    }

    public void setRepair_station(Repair_station repair_station) {
        this.repair_station = repair_station;
    }

    public Upgrades getUpgrades() {
        return upgrades;
    }

    public void setUpgrades(Upgrades upgrades) {
        this.upgrades = upgrades;
    }

    public String getRepair_end_datetime() {
        return repair_end_datetime;
    }

    public void setRepair_end_datetime(String repair_end_datetime) {
        this.repair_end_datetime = repair_end_datetime;
    }

    public long getLoaded() {
        return loaded;
    }

    public void setLoaded(long loaded) {
        this.loaded = loaded;
    }

    public Repair_end_station getRepair_end_station() {
        return repair_end_station;
    }

    public void setRepair_end_station(Repair_end_station repair_end_station) {
        this.repair_end_station = repair_end_station;
    }

    public Depot_end getDepot_end() {
        return depot_end;
    }

    public void setDepot_end(Depot_end depot_end) {
        this.depot_end = depot_end;
    }

    public Repair_type getRepair_type() {
        return repair_type;
    }

    public void setRepair_type(Repair_type repair_type) {
        this.repair_type = repair_type;
    }

    public Defects getDefects() {
        return defects;
    }

    public void setDefects(Defects defects) {
        this.defects = defects;
    }

    public String getRepair_call_datetime() {
        return repair_call_datetime;
    }

    public void setRepair_call_datetime(String repair_call_datetime) {
        this.repair_call_datetime = repair_call_datetime;
    }

    public String getRepair_start_datetime() {
        return repair_start_datetime;
    }

    public void setRepair_start_datetime(String repair_start_datetime) {
        this.repair_start_datetime = repair_start_datetime;
    }

    public long getVu36_number() {
        return vu36_number;
    }

    public void setVu36_number(long vu36_number) {
        this.vu36_number = vu36_number;
    }

    public long getVu23_number() {
        return vu23_number;
    }

    public void setVu23_number(long vu23_number) {
        this.vu23_number = vu23_number;
    }

    public long getVagon_no() {
        return vagon_no;
    }

    public void setVagon_no(long vagon_no) {
        this.vagon_no = vagon_no;
    }

    @Override
    public String toString() {
        return "ClassPojo [broken = " + broken + ", repair_call_road = " + repair_call_road + ", vu36_number = " + vu36_number + ", depot_start = " + depot_start + ", repair_station = " + repair_station + ", upgrades = " + upgrades + ", repair_end_datetime = " + repair_end_datetime + ", loaded = " + loaded + ", repair_end_station = " + repair_end_station + ", depot_end = " + depot_end + ", vu23_number = " + vu23_number + ", repair_type = " + repair_type + ", defects = " + defects + ", repair_call_datetime = " + repair_call_datetime + ", repair_start_datetime = " + repair_start_datetime + ", vagon_no = " + vagon_no + "]";
    }
}
