package server.domain.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity(name = "Repairs")
public class
Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long last_repairs_vagon_no;

    @Column
    private long last_repairs_repair_code;

    @Column
    private String last_repairs_repair_desc;

    @Column
    private long depot_start_code;

    @Column
    private long depot_start_road_code;

    @Column
    private String depot_start_desc;

    @Column
    private String depot_start_desc_long;

    @Column
    private long depot_end_code;

    @Column
    private long depot_end_road_code;

    @Column
    private String depot_end_desc;

    @Column
    private String depot_end_desc_long;

    @Column
    private long repair_call_road_code;

    @Column
    private String repair_call_road_name;

    @Column
    private long vu23_number;

    @Column
    private long vu36_number;

    @Column
    private String repair_station_name;

    @Column
    private long repair_station_code;

    @Column
    private long repair_station_road_code;

    @Column
    private long repair_station_country_code;

    @Column
    private long repair_station_country_code_iso;

    @Column
    private String repair_end_station_name;

    @Column
    private long repair_end_station_code;

    @Column
    private long repair_end_station_road_code;

    @Column
    private long repair_end_station_country_code;

    @Column
    private long repair_end_station_country_code_iso;

    @Column
    private Calendar repair_call_datetime;

    @Column
    private Calendar repair_start_datetime;

    @Column
    private Calendar repair_end_datetime;

    @Column
    private long broken;

    @Column
    private long loaded;

    @Column
    private long defect_code;

    @Column
    private long defecr_desc;

    @Column
    private long upgrades;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wagonId")
    private WagonCache wagonId;

    public Repair() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLast_repairs_vagon_no() {
        return last_repairs_vagon_no;
    }

    public void setLast_repairs_vagon_no(long last_repairs_vagon_no) {
        this.last_repairs_vagon_no = last_repairs_vagon_no;
    }

    public long getLast_repairs_repair_code() {
        return last_repairs_repair_code;
    }

    public void setLast_repairs_repair_code(long last_repairs_repair_code) {
        this.last_repairs_repair_code = last_repairs_repair_code;
    }

    public String getLast_repairs_repair_desc() {
        return last_repairs_repair_desc;
    }

    public void setLast_repairs_repair_desc(String last_repairs_repair_desc) {
        this.last_repairs_repair_desc = last_repairs_repair_desc;
    }

    public long getDepot_start_code() {
        return depot_start_code;
    }

    public void setDepot_start_code(long depot_start_code) {
        this.depot_start_code = depot_start_code;
    }

    public long getDepot_start_road_code() {
        return depot_start_road_code;
    }

    public void setDepot_start_road_code(long depot_start_road_code) {
        this.depot_start_road_code = depot_start_road_code;
    }

    public String getDepot_start_desc() {
        return depot_start_desc;
    }

    public void setDepot_start_desc(String depot_start_desc) {
        this.depot_start_desc = depot_start_desc;
    }

    public String getDepot_start_desc_long() {
        return depot_start_desc_long;
    }

    public void setDepot_start_desc_long(String depot_start_desc_long) {
        this.depot_start_desc_long = depot_start_desc_long;
    }

    public long getDepot_end_code() {
        return depot_end_code;
    }

    public void setDepot_end_code(long depot_end_code) {
        this.depot_end_code = depot_end_code;
    }

    public long getDepot_end_road_code() {
        return depot_end_road_code;
    }

    public void setDepot_end_road_code(long depot_end_road_code) {
        this.depot_end_road_code = depot_end_road_code;
    }

    public String getDepot_end_desc() {
        return depot_end_desc;
    }

    public void setDepot_end_desc(String depot_end_desc) {
        this.depot_end_desc = depot_end_desc;
    }

    public String getDepot_end_desc_long() {
        return depot_end_desc_long;
    }

    public void setDepot_end_desc_long(String depot_end_desc_long) {
        this.depot_end_desc_long = depot_end_desc_long;
    }

    public long getRepair_call_road_code() {
        return repair_call_road_code;
    }

    public void setRepair_call_road_code(long repair_call_road_code) {
        this.repair_call_road_code = repair_call_road_code;
    }

    public String getRepair_call_road_name() {
        return repair_call_road_name;
    }

    public void setRepair_call_road_name(String repair_call_road_name) {
        this.repair_call_road_name = repair_call_road_name;
    }

    public long getVu23_number() {
        return vu23_number;
    }

    public void setVu23_number(long vu23_number) {
        this.vu23_number = vu23_number;
    }

    public long getVu36_number() {
        return vu36_number;
    }

    public void setVu36_number(long vu36_number) {
        this.vu36_number = vu36_number;
    }

    public String getRepair_station_name() {
        return repair_station_name;
    }

    public void setRepair_station_name(String repair_station_name) {
        this.repair_station_name = repair_station_name;
    }

    public long getRepair_station_code() {
        return repair_station_code;
    }

    public void setRepair_station_code(long repair_station_code) {
        this.repair_station_code = repair_station_code;
    }

    public long getRepair_station_road_code() {
        return repair_station_road_code;
    }

    public void setRepair_station_road_code(long repair_station_road_code) {
        this.repair_station_road_code = repair_station_road_code;
    }

    public long getRepair_station_country_code() {
        return repair_station_country_code;
    }

    public void setRepair_station_country_code(long repair_station_country_code) {
        this.repair_station_country_code = repair_station_country_code;
    }

    public long getRepair_station_country_code_iso() {
        return repair_station_country_code_iso;
    }

    public void setRepair_station_country_code_iso(long repair_station_country_code_iso) {
        this.repair_station_country_code_iso = repair_station_country_code_iso;
    }

    public String getRepair_end_station_name() {
        return repair_end_station_name;
    }

    public void setRepair_end_station_name(String repair_end_station_name) {
        this.repair_end_station_name = repair_end_station_name;
    }

    public long getRepair_end_station_code() {
        return repair_end_station_code;
    }

    public void setRepair_end_station_code(long repair_end_station_code) {
        this.repair_end_station_code = repair_end_station_code;
    }

    public long getRepair_end_station_road_code() {
        return repair_end_station_road_code;
    }

    public void setRepair_end_station_road_code(long repair_end_station_road_code) {
        this.repair_end_station_road_code = repair_end_station_road_code;
    }

    public long getRepair_end_station_country_code() {
        return repair_end_station_country_code;
    }

    public void setRepair_end_station_country_code(long repair_end_station_country_code) {
        this.repair_end_station_country_code = repair_end_station_country_code;
    }

    public long getRepair_end_station_country_code_iso() {
        return repair_end_station_country_code_iso;
    }

    public void setRepair_end_station_country_code_iso(long repair_end_station_country_code_iso) {
        this.repair_end_station_country_code_iso = repair_end_station_country_code_iso;
    }

    public Calendar getRepair_call_datetime() {
        return repair_call_datetime;
    }

    public void setRepair_call_datetime(Calendar repair_call_datetime) {
        this.repair_call_datetime = repair_call_datetime;
    }

    public Calendar getRepair_start_datetime() {
        return repair_start_datetime;
    }

    public void setRepair_start_datetime(Calendar repair_start_datetime) {
        this.repair_start_datetime = repair_start_datetime;
    }

    public Calendar getRepair_end_datetime() {
        return repair_end_datetime;
    }

    public void setRepair_end_datetime(Calendar repair_end_datetime) {
        this.repair_end_datetime = repair_end_datetime;
    }

    public long getBroken() {
        return broken;
    }

    public void setBroken(long broken) {
        this.broken = broken;
    }

    public long getLoaded() {
        return loaded;
    }

    public void setLoaded(long loaded) {
        this.loaded = loaded;
    }

    public long getDefect_code() {
        return defect_code;
    }

    public void setDefect_code(long defect_code) {
        this.defect_code = defect_code;
    }

    public long getDefecr_desc() {
        return defecr_desc;
    }

    public void setDefecr_desc(long defecr_desc) {
        this.defecr_desc = defecr_desc;
    }

    public long getUpgrades() {
        return upgrades;
    }

    public WagonCache getWagonId() {
        return wagonId;
    }

    public void setWagonId(WagonCache wagonId) {
        this.wagonId = wagonId;
    }

    public void setUpgrades(long upgrades) {
        this.upgrades = upgrades;
    }
}
