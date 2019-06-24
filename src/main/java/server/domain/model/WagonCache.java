package server.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import server.client_model.Vagon_info;
import server.web.Utils.DateParser;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "wagon_cache")
public class  WagonCache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "wagonCacheId")
    private List<Position> positions;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "wagonId")
    private List<Repair> repairs;


    //TODO read one-to-one reference IMPORTANT
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wagonCacheId")
    private UserWagon userWagonId;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;

    @Column
    private String vagon_no;
    @Column
    private String client_id;
    @Column
    private String from_name;
    @Column
    private String from_code;
    @Column
    private String from_road_code;
    @Column
    private String from_road_name;
    @Column
    private double from_latitude;
    @Column
    private double from_longitude;
    @Column
    private String to_name;
    @Column
    private String to_code;
    @Column
    private String user_to_code;
    @Column
    private String to_road_code;
    @Column
    private String to_road_name;
    @Column
    private double to_latitude;
    @Column
    private double to_longitude;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date send_date;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date send_date_time;
    @Column
    private long send_date_timestamp;
    @Column
    private long departure_timestamp;
    @Column
    private long departure_date_error;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date time_added;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrive_date;
    @Column
    private String processed;
    @Column
    private long groud_id;
    @Column
    private String group_name;
    @Column
    private String arrived;
    @Column
    private String round_vagon;
    @Column
    private long arrive_by_destination;
    @Column
    private double days_wo_movement;
    @Column
    private double days_wo_operation;
    @Column
    private String vagon_comment;
    @Column
    private Date eta;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrive_date_real;
    @Column
    private long arrive_date_real_timestamp;
    @Column
    private long vagon_spec_no;
    @Column
    private double vagon_spec_tare;
    @Column
    private long vagon_spec_capacity;
    @Column
    private long vagon_spec_type;
    @Column
    private String vagon_spec_desc;
    @Column
    private long vagon_spec_common_type_code;
    @Column
    private String vagon_spec_common_type_name;
    @Column
    private String vagon_spec_model;
    @Column
    private long vagon_spec_model_no;
    @Column
    private String vagon_spec_model_cypher;
    @Column
    private long vagon_spec_model_kind;
    @Column
    private long vagon_spec_model_charact;
    @Column
    private long vagon_spec_uch_specializ;
    @Column
    private long vagon_spec_material_body;
    @Column
    private long vagon_spec_carriage_works;
    @Column
    private long vagon_spec_carrying_capacity;
    @Column
    private double vagon_spec_tare_min;
    @Column
    private double vagon_spec_tare_max;
    @Column
    private long vagon_spec_autocoupl_len;
    @Column
    private long vagon_spec_vagon_axis;
    @Column
    private double vagon_spec_axial_load;
    @Column
    private long vagon_spec_adapter_plate;
    @Column
    private double vagon_spec_body_space;
    @Column
    private long vagon_spec_delivery_year;
    @Column
    private long vagon_spec_obsolete_year;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date vagon_spec_registration_date;
    @Column
    private String vagon_spec_registration_name;
    @Column
    private long vagon_spec_next_repair_type;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date vagon_spec_next_repair_date;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date vagon_spec_date_last_dep_repair;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date vagon_spec_date_last_kap_repair;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date vagon_spec_max_service_date;
    @Column
    private long vagon_spec_mileage_current;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date vagon_spec_mileage_current_date;
    @Column
    private long vagon_spec_mileage_left;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date vagon_spec_mileage_left_date;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date vagon_spec_build_date;

    public WagonCache(List<Position> positions, Date lastUpdatedAt, UserWagon userWagonId, Vagon_info vagonInfo, List<Repair> repairs) {
        System.out.println("got in constructor");
        this.positions = positions;
        this.lastUpdatedAt = lastUpdatedAt;
        this.userWagonId = userWagonId;
        this.vagon_no = vagonInfo.getVagon_no();
        this.client_id = vagonInfo.getClient_id();
        this.from_name = vagonInfo.getFrom_name();
        System.out.println("first 5");
        this.from_code = vagonInfo.getFrom_code();
        this.from_road_code = vagonInfo.getFrom_road_code();
        this.from_road_name = vagonInfo.getFrom_name();
        this.from_latitude = Double.valueOf(vagonInfo.getFrom_longitude());
        this.from_longitude = Double.valueOf(vagonInfo.getFrom_longitude());
        System.out.println("second 5");
        this.to_name = vagonInfo.getTo_name();
        this.to_code = vagonInfo.getTo_code();
        this.user_to_code = vagonInfo.getUser_to_code();
        this.to_road_code = vagonInfo.getTo_road_code();
        this.to_road_name = vagonInfo.getTo_road().getRoad().getName().get(0);
        System.out.println("first 15");
        this.to_latitude = Double.valueOf(vagonInfo.getTo_latitude());
        this.to_longitude = Double.valueOf(vagonInfo.getTo_longitude());
        this.send_date = DateParser.parseFromStringToDate(vagonInfo.getSend_date(), "dd.MM.yyyy");
        this.send_date_time = DateParser.parseFromStringToDate(vagonInfo.getSend_date_time(), "dd.MM.yyyy, HH:mm");
        this.send_date_timestamp = Long.valueOf(vagonInfo.getSend_date_timestamp()) * 1000;
        System.out.println("first 20");
        if (!vagonInfo.getDeparture_timestamp().equals("") && vagonInfo.getDeparture_timestamp() != null)
            this.departure_timestamp = Long.valueOf(vagonInfo.getDeparture_timestamp()) * 1000;

        this.departure_date_error = Long.valueOf(vagonInfo.getDeparture_date_error());
        this.time_added = DateParser.parseFromStringToDate(vagonInfo.getTime_added(), "dd.MM.yyyy, HH:mm:ss");
        this.arrive_date = DateParser.parseFromStringToDate(vagonInfo.getArrive_date(), "dd.MM.yyyy, HH:mm"); // often null
        this.processed = vagonInfo.getProcessed();
        System.out.println("first 25");
        this.groud_id = Long.valueOf(vagonInfo.getGroup_id());
        this.group_name = vagonInfo.getGroup_name();
        this.arrived = vagonInfo.getArrived();
        this.round_vagon = vagonInfo.getRound_vagon();
        this.arrive_by_destination = Long.valueOf(vagonInfo.getArrive_by_destination());
        System.out.println("first 30");
        this.days_wo_movement = Double.valueOf(vagonInfo.getDays_wo_movement());
        this.days_wo_operation = Double.valueOf(vagonInfo.getDays_wo_operation());
        this.vagon_comment = vagonInfo.getVagon_comment();
        this.eta = DateParser.parseFromStringToDate(vagonInfo.getEta(), "dd.MM.yyyy");
        this.arrive_date_real = DateParser.parseFromStringToDate(vagonInfo.getArrive_date_real(), "dd.MM.yyyy, HH:mm");
        System.out.println("first 30");
        if (vagonInfo.getArrive_date_real_timestamp() != null && !vagonInfo.getArrive_date_real_timestamp().equals(""))
            this.arrive_date_real_timestamp = Long.valueOf(vagonInfo.getArrive_date_real_timestamp()) * 1000;

        if (vagonInfo.getVagon_specifications().getVagon_no() != null && vagonInfo.getVagon_specifications().getVagon_no().equals(""))
            this.vagon_spec_no = Long.valueOf(vagonInfo.getVagon_specifications().getVagon_no());

        if (vagonInfo.getVagon_specifications().getTare() != null && vagonInfo.getVagon_specifications().getTare().equals(""))
            this.vagon_spec_tare = Double.valueOf(vagonInfo.getVagon_specifications().getTare());

        if (vagonInfo.getVagon_specifications().getCapacity() != null && vagonInfo.getVagon_specifications().getCapacity().equals(""))
            this.vagon_spec_capacity = Long.valueOf(vagonInfo.getVagon_specifications().getCapacity());

        if (vagonInfo.getVagon_specifications().getVagon_type() != null && vagonInfo.getVagon_specifications().getVagon_type().equals(""))
            this.vagon_spec_type = Long.valueOf(vagonInfo.getVagon_specifications().getVagon_type());

        System.out.println("first 35");
        this.vagon_spec_desc = vagonInfo.getVagon_specifications().getVagon_type_desc().getName().get(0);
        if (vagonInfo.getVagon_specifications().getVagon_type_desc().getCommon_type().getId() != null)
            this.vagon_spec_common_type_code = Long.valueOf(vagonInfo.getVagon_specifications().getVagon_type_desc().getCommon_type().getId());

        this.vagon_spec_common_type_name = vagonInfo.getVagon_specifications().getVagon_type_desc().getCommon_type().getName().get(0);
        this.vagon_spec_model = vagonInfo.getVagon_specifications().getModel();
        if (vagonInfo.getVagon_specifications().getVagon_model().getModel_no() != null)
            this.vagon_spec_model_no = Long.valueOf(vagonInfo.getVagon_specifications().getVagon_model().getModel_no());

        System.out.println("first 40");
        this.vagon_spec_model_cypher = vagonInfo.getVagon_specifications().getVagon_model().getModel_cypher();
        if (vagonInfo.getVagon_specifications().getVagon_model().getMod_kind() != null)
            this.vagon_spec_model_kind = Long.valueOf(vagonInfo.getVagon_specifications().getVagon_model().getMod_kind());
        if (vagonInfo.getVagon_specifications().getVagon_model().getModel_charact() != null)
            this.vagon_spec_model_charact = Long.valueOf(vagonInfo.getVagon_specifications().getVagon_model().getModel_charact());
        if (vagonInfo.getVagon_specifications().getVagon_model().getUch_specializ() != null)
            this.vagon_spec_uch_specializ = Long.valueOf(vagonInfo.getVagon_specifications().getVagon_model().getUch_specializ());
        if (vagonInfo.getVagon_specifications().getVagon_model().getMaterial_body() != null)
            this.vagon_spec_material_body = Long.valueOf(vagonInfo.getVagon_specifications().getVagon_model().getMaterial_body());
        System.out.println("first 45");
        if (vagonInfo.getVagon_specifications().getVagon_model().getCarriage_works() != null)
            this.vagon_spec_carriage_works = Long.valueOf(vagonInfo.getVagon_specifications().getVagon_model().getCarriage_works());
        if (vagonInfo.getVagon_specifications().getVagon_model().getCarrying_capacity() != null)
            this.vagon_spec_carrying_capacity = Long.valueOf(vagonInfo.getVagon_specifications().getCapacity());
        if (vagonInfo.getVagon_specifications().getVagon_model().getTare_min() != null)
            this.vagon_spec_tare_min = Double.valueOf(vagonInfo.getVagon_specifications().getVagon_model().getTare_min());
        if (vagonInfo.getVagon_specifications().getVagon_model().getTare_max() != null)
            this.vagon_spec_tare_max = Double.valueOf(vagonInfo.getVagon_specifications().getVagon_model().getTare_max());
        if (vagonInfo.getVagon_specifications().getVagon_model().getAutocoupl_len() != null)
            this.vagon_spec_autocoupl_len = Long.valueOf(vagonInfo.getVagon_specifications().getVagon_model().getAutocoupl_len());
        System.out.println("first 50");
        if (vagonInfo.getVagon_specifications().getVagon_model().getVagon_axis() != null)
            this.vagon_spec_vagon_axis = Long.valueOf(vagonInfo.getVagon_specifications().getVagon_model().getVagon_axis());
        if (vagonInfo.getVagon_specifications().getVagon_model().getAxial_load() != null)
            this.vagon_spec_axial_load = Double.valueOf(vagonInfo.getVagon_specifications().getVagon_model().getAxial_load());
        if (vagonInfo.getVagon_specifications().getVagon_model().getAdapter_plate() != null)
            this.vagon_spec_adapter_plate = Long.valueOf(vagonInfo.getVagon_specifications().getVagon_model().getAdapter_plate());
        if (vagonInfo.getVagon_specifications().getVagon_model().getBody_space() != null)
            this.vagon_spec_body_space = Double.valueOf(vagonInfo.getVagon_specifications().getVagon_model().getBody_space());
        if (vagonInfo.getVagon_specifications().getVagon_model().getDelivery_year() != null)
            this.vagon_spec_delivery_year = Long.valueOf(vagonInfo.getVagon_specifications().getVagon_model().getDelivery_year());
        System.out.println("first 55");
        if (vagonInfo.getVagon_specifications().getVagon_model().getObsolete_year() != null)
            this.vagon_spec_obsolete_year = Long.valueOf(vagonInfo.getVagon_specifications().getVagon_model().getObsolete_year());
        this.vagon_spec_registration_date = DateParser.parseFromStringToDate(vagonInfo.getVagon_specifications().getRegistration_date(), "dd.MM.yyyy");
        this.vagon_spec_registration_name = vagonInfo.getVagon_specifications().getRegistration_reason().getName().get(0);
        if (vagonInfo.getVagon_specifications().getNext_repair_type() != null)
            this.vagon_spec_next_repair_type = Long.valueOf(vagonInfo.getVagon_specifications().getNext_repair_type());
        this.vagon_spec_next_repair_date = DateParser.parseFromStringToDate(vagonInfo.getVagon_specifications().getNext_repair_date(), "dd.MM.yyyy");
        System.out.println("first 60");
        this.vagon_spec_date_last_dep_repair = DateParser.parseFromStringToDate(vagonInfo.getVagon_specifications().getDate_last_dep_repair(), "dd.MM.yyyy");
        this.vagon_spec_date_last_kap_repair = DateParser.parseFromStringToDate(vagonInfo.getVagon_specifications().getDate_last_kap_repair(), "dd.MM.yyyy"); // often null
        this.vagon_spec_max_service_date = DateParser.parseFromStringToDate(vagonInfo.getVagon_specifications().getMax_service_date(), "dd.MM.yyyy");
        if (vagonInfo.getVagon_specifications().getMileage_current() != null)
            this.vagon_spec_mileage_current = Long.valueOf(vagonInfo.getVagon_specifications().getMileage_current());
        this.vagon_spec_mileage_current_date = DateParser.parseFromStringToDate(vagonInfo.getVagon_specifications().getMileage_current_date(), "dd.MM.yyyy");
        if (vagonInfo.getVagon_specifications().getMileage_left() != null)
            this.vagon_spec_mileage_left = Long.valueOf(vagonInfo.getVagon_specifications().getMileage_left());
        this.vagon_spec_mileage_left_date = DateParser.parseFromStringToDate(vagonInfo.getVagon_specifications().getMileage_left_date(), "dd.MM.yyyy");
        this.vagon_spec_build_date = DateParser.parseFromStringToDate(vagonInfo.getVagon_specifications().getBuild_date(), "dd.MM.yyyy");
        this.repairs = repairs;
    }


    public WagonCache() {

    }

    public WagonCache(List<Position> positions, List<Repair> repairs, UserWagon userWagonId, Date lastUpdatedAt, String vagon_no, String client_id, String from_name, String from_code, String from_road_code, String from_road_name, double from_latitude, double from_longitude, String to_name, String to_code, String user_to_code, String to_road_code, String to_road_name, double to_latitude, double to_longitude, Date send_date, Date send_date_time, long send_date_timestamp, long departure_timestamp, long departure_date_error, Date time_added, Date arrive_date, String processed, long groud_id, String group_name, String arrived, String round_vagon, long arrive_by_destination, double days_wo_movement, double days_wo_operation, String vagon_comment, Date eta, Date arrive_date_real, long arrive_date_real_timestamp, long vagon_spec_no, double vagon_spec_tare, long vagon_spec_capacity, long vagon_spec_type, String vagon_spec_desc, long vagon_spec_common_type_code, String vagon_spec_common_type_name, String vagon_spec_model, long vagon_spec_model_no, String vagon_spec_model_cypher, long vagon_spec_model_kind, long vagon_spec_model_charact, long vagon_spec_uch_specializ, long vagon_spec_material_body, long vagon_spec_carriage_works, long vagon_spec_carrying_capacity, double vagon_spec_tare_min, double vagon_spec_tare_max, long vagon_spec_autocoupl_len, long vagon_spec_vagon_axis, double vagon_spec_axial_load, long vagon_spec_adapter_plate, double vagon_spec_body_space, long vagon_spec_delivery_year, long vagon_spec_obsolete_year, Date vagon_spec_registration_date, String vagon_spec_registration_name, long vagon_spec_next_repair_type, Date vagon_spec_next_repair_date, Date vagon_spec_date_last_dep_repair, Date vagon_spec_date_last_kap_repair, Date vagon_spec_max_service_date, long vagon_spec_mileage_current, Date vagon_spec_mileage_current_date, long vagon_spec_mileage_left, Date vagon_spec_mileage_left_date, Date vagon_spec_build_date) {
        this.positions = positions;
        this.repairs = repairs;
        this.userWagonId = userWagonId;
        this.lastUpdatedAt = lastUpdatedAt;
        this.vagon_no = vagon_no;
        this.client_id = client_id;
        this.from_name = from_name;
        this.from_code = from_code;
        this.from_road_code = from_road_code;
        this.from_road_name = from_road_name;
        this.from_latitude = from_latitude;
        this.from_longitude = from_longitude;
        this.to_name = to_name;
        this.to_code = to_code;
        this.user_to_code = user_to_code;
        this.to_road_code = to_road_code;
        this.to_road_name = to_road_name;
        this.to_latitude = to_latitude;
        this.to_longitude = to_longitude;
        this.send_date = send_date;
        this.send_date_time = send_date_time;
        this.send_date_timestamp = send_date_timestamp;
        this.departure_timestamp = departure_timestamp;
        this.departure_date_error = departure_date_error;
        this.time_added = time_added;
        this.arrive_date = arrive_date;
        this.processed = processed;
        this.groud_id = groud_id;
        this.group_name = group_name;
        this.arrived = arrived;
        this.round_vagon = round_vagon;
        this.arrive_by_destination = arrive_by_destination;
        this.days_wo_movement = days_wo_movement;
        this.days_wo_operation = days_wo_operation;
        this.vagon_comment = vagon_comment;
        this.eta = eta;
        this.arrive_date_real = arrive_date_real;
        this.arrive_date_real_timestamp = arrive_date_real_timestamp;
        this.vagon_spec_no = vagon_spec_no;
        this.vagon_spec_tare = vagon_spec_tare;
        this.vagon_spec_capacity = vagon_spec_capacity;
        this.vagon_spec_type = vagon_spec_type;
        this.vagon_spec_desc = vagon_spec_desc;
        this.vagon_spec_common_type_code = vagon_spec_common_type_code;
        this.vagon_spec_common_type_name = vagon_spec_common_type_name;
        this.vagon_spec_model = vagon_spec_model;
        this.vagon_spec_model_no = vagon_spec_model_no;
        this.vagon_spec_model_cypher = vagon_spec_model_cypher;
        this.vagon_spec_model_kind = vagon_spec_model_kind;
        this.vagon_spec_model_charact = vagon_spec_model_charact;
        this.vagon_spec_uch_specializ = vagon_spec_uch_specializ;
        this.vagon_spec_material_body = vagon_spec_material_body;
        this.vagon_spec_carriage_works = vagon_spec_carriage_works;
        this.vagon_spec_carrying_capacity = vagon_spec_carrying_capacity;
        this.vagon_spec_tare_min = vagon_spec_tare_min;
        this.vagon_spec_tare_max = vagon_spec_tare_max;
        this.vagon_spec_autocoupl_len = vagon_spec_autocoupl_len;
        this.vagon_spec_vagon_axis = vagon_spec_vagon_axis;
        this.vagon_spec_axial_load = vagon_spec_axial_load;
        this.vagon_spec_adapter_plate = vagon_spec_adapter_plate;
        this.vagon_spec_body_space = vagon_spec_body_space;
        this.vagon_spec_delivery_year = vagon_spec_delivery_year;
        this.vagon_spec_obsolete_year = vagon_spec_obsolete_year;
        this.vagon_spec_registration_date = vagon_spec_registration_date;
        this.vagon_spec_registration_name = vagon_spec_registration_name;
        this.vagon_spec_next_repair_type = vagon_spec_next_repair_type;
        this.vagon_spec_next_repair_date = vagon_spec_next_repair_date;
        this.vagon_spec_date_last_dep_repair = vagon_spec_date_last_dep_repair;
        this.vagon_spec_date_last_kap_repair = vagon_spec_date_last_kap_repair;
        this.vagon_spec_max_service_date = vagon_spec_max_service_date;
        this.vagon_spec_mileage_current = vagon_spec_mileage_current;
        this.vagon_spec_mileage_current_date = vagon_spec_mileage_current_date;
        this.vagon_spec_mileage_left = vagon_spec_mileage_left;
        this.vagon_spec_mileage_left_date = vagon_spec_mileage_left_date;
        this.vagon_spec_build_date = vagon_spec_build_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    public UserWagon getUserWagonId() {
        return userWagonId;
    }

    public void setUserWagonId(UserWagon userWagonId) {
        this.userWagonId = userWagonId;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getVagon_no() {
        return vagon_no;
    }

    public void setVagon_no(String vagon_no) {
        this.vagon_no = vagon_no;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getFrom_name() {
        return from_name;
    }

    public void setFrom_name(String from_name) {
        this.from_name = from_name;
    }

    public String getFrom_code() {
        return from_code;
    }

    public void setFrom_code(String from_code) {
        this.from_code = from_code;
    }

    public String getFrom_road_code() {
        return from_road_code;
    }

    public void setFrom_road_code(String from_road_code) {
        this.from_road_code = from_road_code;
    }

    public String getFrom_road_name() {
        return from_road_name;
    }

    public void setFrom_road_name(String from_road_name) {
        this.from_road_name = from_road_name;
    }

    public double getFrom_latitude() {
        return from_latitude;
    }

    public void setFrom_latitude(double from_latitude) {
        this.from_latitude = from_latitude;
    }

    public double getFrom_longitude() {
        return from_longitude;
    }

    public void setFrom_longitude(double from_longitude) {
        this.from_longitude = from_longitude;
    }

    public String getTo_name() {
        return to_name;
    }

    public void setTo_name(String to_name) {
        this.to_name = to_name;
    }

    public String getTo_code() {
        return to_code;
    }

    public void setTo_code(String to_code) {
        this.to_code = to_code;
    }

    public String getUser_to_code() {
        return user_to_code;
    }

    public void setUser_to_code(String user_to_code) {
        this.user_to_code = user_to_code;
    }

    public String getTo_road_code() {
        return to_road_code;
    }

    public void setTo_road_code(String to_road_code) {
        this.to_road_code = to_road_code;
    }

    public String getTo_road_name() {
        return to_road_name;
    }

    public void setTo_road_name(String to_road_name) {
        this.to_road_name = to_road_name;
    }

    public double getTo_latitude() {
        return to_latitude;
    }

    public void setTo_latitude(double to_latitude) {
        this.to_latitude = to_latitude;
    }

    public double getTo_longitude() {
        return to_longitude;
    }

    public void setTo_longitude(double to_longitude) {
        this.to_longitude = to_longitude;
    }

    public Date getSend_date() {
        return send_date;
    }

    public void setSend_date(Date send_date) {
        this.send_date = send_date;
    }

    public Date getSend_date_time() {
        return send_date_time;
    }

    public void setSend_date_time(Date send_date_time) {
        this.send_date_time = send_date_time;
    }

    public long getSend_date_timestamp() {
        return send_date_timestamp;
    }

    public void setSend_date_timestamp(long send_date_timestamp) {
        this.send_date_timestamp = send_date_timestamp;
    }

    public long getDeparture_timestamp() {
        return departure_timestamp;
    }

    public void setDeparture_timestamp(long departure_timestamp) {
        this.departure_timestamp = departure_timestamp;
    }

    public long getDeparture_date_error() {
        return departure_date_error;
    }

    public void setDeparture_date_error(long departure_date_error) {
        this.departure_date_error = departure_date_error;
    }

    public Date getTime_added() {
        return time_added;
    }

    public void setTime_added(Date time_added) {
        this.time_added = time_added;
    }

    public Date getArrive_date() {
        return arrive_date;
    }

    public void setArrive_date(Date arrive_date) {
        this.arrive_date = arrive_date;
    }

    public String getProcessed() {
        return processed;
    }

    public void setProcessed(String processed) {
        this.processed = processed;
    }

    public long getGroud_id() {
        return groud_id;
    }

    public void setGroud_id(long groud_id) {
        this.groud_id = groud_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getArrived() {
        return arrived;
    }

    public void setArrived(String arrived) {
        this.arrived = arrived;
    }

    public String getRound_vagon() {
        return round_vagon;
    }

    public void setRound_vagon(String round_vagon) {
        this.round_vagon = round_vagon;
    }

    public long getArrive_by_destination() {
        return arrive_by_destination;
    }

    public void setArrive_by_destination(long arrive_by_destination) {
        this.arrive_by_destination = arrive_by_destination;
    }

    public double getDays_wo_movement() {
        return days_wo_movement;
    }

    public void setDays_wo_movement(double days_wo_movement) {
        this.days_wo_movement = days_wo_movement;
    }

    public double getDays_wo_operation() {
        return days_wo_operation;
    }

    public void setDays_wo_operation(double days_wo_operation) {
        this.days_wo_operation = days_wo_operation;
    }

    public String getVagon_comment() {
        return vagon_comment;
    }

    public void setVagon_comment(String vagon_comment) {
        this.vagon_comment = vagon_comment;
    }

    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public Date getArrive_date_real() {
        return arrive_date_real;
    }

    public void setArrive_date_real(Date arrive_date_real) {
        this.arrive_date_real = arrive_date_real;
    }

    public long getArrive_date_real_timestamp() {
        return arrive_date_real_timestamp;
    }

    public void setArrive_date_real_timestamp(long arrive_date_real_timestamp) {
        this.arrive_date_real_timestamp = arrive_date_real_timestamp;
    }

    public long getVagon_spec_no() {
        return vagon_spec_no;
    }

    public void setVagon_spec_no(long vagon_spec_no) {
        this.vagon_spec_no = vagon_spec_no;
    }

    public double getVagon_spec_tare() {
        return vagon_spec_tare;
    }

    public void setVagon_spec_tare(double vagon_spec_tare) {
        this.vagon_spec_tare = vagon_spec_tare;
    }

    public long getVagon_spec_capacity() {
        return vagon_spec_capacity;
    }

    public void setVagon_spec_capacity(long vagon_spec_capacity) {
        this.vagon_spec_capacity = vagon_spec_capacity;
    }

    public long getVagon_spec_type() {
        return vagon_spec_type;
    }

    public void setVagon_spec_type(long vagon_spec_type) {
        this.vagon_spec_type = vagon_spec_type;
    }

    public String getVagon_spec_desc() {
        return vagon_spec_desc;
    }

    public void setVagon_spec_desc(String vagon_spec_desc) {
        this.vagon_spec_desc = vagon_spec_desc;
    }

    public long getVagon_spec_common_type_code() {
        return vagon_spec_common_type_code;
    }

    public void setVagon_spec_common_type_code(long vagon_spec_common_type_code) {
        this.vagon_spec_common_type_code = vagon_spec_common_type_code;
    }

    public String getVagon_spec_common_type_name() {
        return vagon_spec_common_type_name;
    }

    public void setVagon_spec_common_type_name(String vagon_spec_common_type_name) {
        this.vagon_spec_common_type_name = vagon_spec_common_type_name;
    }

    public String getVagon_spec_model() {
        return vagon_spec_model;
    }

    public void setVagon_spec_model(String vagon_spec_model) {
        this.vagon_spec_model = vagon_spec_model;
    }

    public long getVagon_spec_model_no() {
        return vagon_spec_model_no;
    }

    public void setVagon_spec_model_no(long vagon_spec_model_no) {
        this.vagon_spec_model_no = vagon_spec_model_no;
    }

    public String getVagon_spec_model_cypher() {
        return vagon_spec_model_cypher;
    }

    public void setVagon_spec_model_cypher(String vagon_spec_model_cypher) {
        this.vagon_spec_model_cypher = vagon_spec_model_cypher;
    }

    public long getVagon_spec_model_kind() {
        return vagon_spec_model_kind;
    }

    public void setVagon_spec_model_kind(long vagon_spec_model_kind) {
        this.vagon_spec_model_kind = vagon_spec_model_kind;
    }

    public long getVagon_spec_model_charact() {
        return vagon_spec_model_charact;
    }

    public void setVagon_spec_model_charact(long vagon_spec_model_charact) {
        this.vagon_spec_model_charact = vagon_spec_model_charact;
    }

    public long getVagon_spec_uch_specializ() {
        return vagon_spec_uch_specializ;
    }

    public void setVagon_spec_uch_specializ(long vagon_spec_uch_specializ) {
        this.vagon_spec_uch_specializ = vagon_spec_uch_specializ;
    }

    public long getVagon_spec_material_body() {
        return vagon_spec_material_body;
    }

    public void setVagon_spec_material_body(long vagon_spec_material_body) {
        this.vagon_spec_material_body = vagon_spec_material_body;
    }

    public long getVagon_spec_carriage_works() {
        return vagon_spec_carriage_works;
    }

    public void setVagon_spec_carriage_works(long vagon_spec_carriage_works) {
        this.vagon_spec_carriage_works = vagon_spec_carriage_works;
    }

    public long getVagon_spec_carrying_capacity() {
        return vagon_spec_carrying_capacity;
    }

    public void setVagon_spec_carrying_capacity(long vagon_spec_carrying_capacity) {
        this.vagon_spec_carrying_capacity = vagon_spec_carrying_capacity;
    }

    public double getVagon_spec_tare_min() {
        return vagon_spec_tare_min;
    }

    public void setVagon_spec_tare_min(double vagon_spec_tare_min) {
        this.vagon_spec_tare_min = vagon_spec_tare_min;
    }

    public double getVagon_spec_tare_max() {
        return vagon_spec_tare_max;
    }

    public void setVagon_spec_tare_max(double vagon_spec_tare_max) {
        this.vagon_spec_tare_max = vagon_spec_tare_max;
    }

    public long getVagon_spec_autocoupl_len() {
        return vagon_spec_autocoupl_len;
    }

    public void setVagon_spec_autocoupl_len(long vagon_spec_autocoupl_len) {
        this.vagon_spec_autocoupl_len = vagon_spec_autocoupl_len;
    }

    public long getVagon_spec_vagon_axis() {
        return vagon_spec_vagon_axis;
    }

    public void setVagon_spec_vagon_axis(long vagon_spec_vagon_axis) {
        this.vagon_spec_vagon_axis = vagon_spec_vagon_axis;
    }

    public double getVagon_spec_axial_load() {
        return vagon_spec_axial_load;
    }

    public void setVagon_spec_axial_load(double vagon_spec_axial_load) {
        this.vagon_spec_axial_load = vagon_spec_axial_load;
    }

    public long getVagon_spec_adapter_plate() {
        return vagon_spec_adapter_plate;
    }

    public void setVagon_spec_adapter_plate(long vagon_spec_adapter_plate) {
        this.vagon_spec_adapter_plate = vagon_spec_adapter_plate;
    }

    public double getVagon_spec_body_space() {
        return vagon_spec_body_space;
    }

    public void setVagon_spec_body_space(double vagon_spec_body_space) {
        this.vagon_spec_body_space = vagon_spec_body_space;
    }

    public long getVagon_spec_delivery_year() {
        return vagon_spec_delivery_year;
    }

    public void setVagon_spec_delivery_year(long vagon_spec_delivery_year) {
        this.vagon_spec_delivery_year = vagon_spec_delivery_year;
    }

    public long getVagon_spec_obsolete_year() {
        return vagon_spec_obsolete_year;
    }

    public void setVagon_spec_obsolete_year(long vagon_spec_obsolete_year) {
        this.vagon_spec_obsolete_year = vagon_spec_obsolete_year;
    }

    public Date getVagon_spec_registration_date() {
        return vagon_spec_registration_date;
    }

    public void setVagon_spec_registration_date(Date vagon_spec_registration_date) {
        this.vagon_spec_registration_date = vagon_spec_registration_date;
    }

    public String getVagon_spec_registration_name() {
        return vagon_spec_registration_name;
    }

    public void setVagon_spec_registration_name(String vagon_spec_registration_name) {
        this.vagon_spec_registration_name = vagon_spec_registration_name;
    }

    public long getVagon_spec_next_repair_type() {
        return vagon_spec_next_repair_type;
    }

    public void setVagon_spec_next_repair_type(long vagon_spec_next_repair_type) {
        this.vagon_spec_next_repair_type = vagon_spec_next_repair_type;
    }

    public Date getVagon_spec_next_repair_date() {
        return vagon_spec_next_repair_date;
    }

    public void setVagon_spec_next_repair_date(Date vagon_spec_next_repair_date) {
        this.vagon_spec_next_repair_date = vagon_spec_next_repair_date;
    }

    public Date getVagon_spec_date_last_dep_repair() {
        return vagon_spec_date_last_dep_repair;
    }

    public void setVagon_spec_date_last_dep_repair(Date vagon_spec_date_last_dep_repair) {
        this.vagon_spec_date_last_dep_repair = vagon_spec_date_last_dep_repair;
    }

    public Date getVagon_spec_date_last_kap_repair() {
        return vagon_spec_date_last_kap_repair;
    }

    public void setVagon_spec_date_last_kap_repair(Date vagon_spec_date_last_kap_repair) {
        this.vagon_spec_date_last_kap_repair = vagon_spec_date_last_kap_repair;
    }

    public Date getVagon_spec_max_service_date() {
        return vagon_spec_max_service_date;
    }

    public void setVagon_spec_max_service_date(Date vagon_spec_max_service_date) {
        this.vagon_spec_max_service_date = vagon_spec_max_service_date;
    }

    public long getVagon_spec_mileage_current() {
        return vagon_spec_mileage_current;
    }

    public void setVagon_spec_mileage_current(long vagon_spec_mileage_current) {
        this.vagon_spec_mileage_current = vagon_spec_mileage_current;
    }

    public Date getVagon_spec_mileage_current_date() {
        return vagon_spec_mileage_current_date;
    }

    public void setVagon_spec_mileage_current_date(Date vagon_spec_mileage_current_date) {
        this.vagon_spec_mileage_current_date = vagon_spec_mileage_current_date;
    }

    public long getVagon_spec_mileage_left() {
        return vagon_spec_mileage_left;
    }

    public void setVagon_spec_mileage_left(long vagon_spec_mileage_left) {
        this.vagon_spec_mileage_left = vagon_spec_mileage_left;
    }

    public Date getVagon_spec_mileage_left_date() {
        return vagon_spec_mileage_left_date;
    }

    public void setVagon_spec_mileage_left_date(Date vagon_spec_mileage_left_date) {
        this.vagon_spec_mileage_left_date = vagon_spec_mileage_left_date;
    }

    public Date getVagon_spec_build_date() {
        return vagon_spec_build_date;
    }

    public void setVagon_spec_build_date(Date vagon_spec_build_date) {
        this.vagon_spec_build_date = vagon_spec_build_date;
    }
}
