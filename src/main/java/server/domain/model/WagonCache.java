package server.domain.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity(name = "wagon_cache")
public class WagonCache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "wagonCacheId")
    private List<Position> positions;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wagonCacheId", optional = false)
    @JoinColumn(name = "user_wagon_id")
    private UserWagon userWagonId;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;

    @Column
    private long vagon_no;
    @Column
    private String client_id;
    @Column
    private String from_name;
    @Column
    private long from_code;
    @Column
    private long from_road_code;
    @Column
    private String from_road_name;
    @Column
    private double from_latitude;
    @Column
    private double from_longitude;
    @Column
    private String to_name;
    @Column
    private long to_code;
    @Column
    private long user_to_code;
    @Column
    private long to_road_code;
    @Column
    private double to_road_name;
    @Column
    private double to_latitude;
    @Column
    private double to_longitude;
    @Column
    private String send_date;
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
    private String eta;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrive_date_real;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrive_date_real_timestamp;
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
    private long vagon_spec_common_type_name;
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "wagonId")
    private List<Repair> repairs;


    public WagonCache(List<Position> positions, UserWagon userWagonId, Date lastUpdatedAt, long vagon_no, String client_id, String from_name, long from_code, long from_road_code, String from_road_name, double from_latitude, double from_longitude, String to_name, long to_code, long user_to_code, long to_road_code, double to_road_name, double to_latitude, double to_longitude, String send_date, Date send_date_time, long send_date_timestamp, long departure_timestamp, long departure_date_error, Date time_added, Date arrive_date, String processed, long groud_id, String group_name, String arrived, String round_vagon, long arrive_by_destination, double days_wo_movement, double days_wo_operation, String vagon_comment, String eta, Date arrive_date_real, Date arrive_date_real_timestamp, long vagon_spec_no, double vagon_spec_tare, long vagon_spec_capacity, long vagon_spec_type, String vagon_spec_desc, long vagon_spec_common_type_code, long vagon_spec_common_type_name, String vagon_spec_model, long vagon_spec_model_no, String vagon_spec_model_cypher, long vagon_spec_model_kind, long vagon_spec_model_charact, long vagon_spec_uch_specializ, long vagon_spec_material_body, long vagon_spec_carriage_works, long vagon_spec_carrying_capacity, double vagon_spec_tare_min, double vagon_spec_tare_max, long vagon_spec_autocoupl_len, long vagon_spec_vagon_axis, double vagon_spec_axial_load, long vagon_spec_adapter_plate, double vagon_spec_body_space, long vagon_spec_delivery_year, long vagon_spec_obsolete_year, Date vagon_spec_registration_date, String vagon_spec_registration_name, long vagon_spec_next_repair_type, Date vagon_spec_next_repair_date, Date vagon_spec_date_last_dep_repair, Date vagon_spec_date_last_kap_repair, Date vagon_spec_max_service_date, long vagon_spec_mileage_current, Date vagon_spec_mileage_current_date, long vagon_spec_mileage_left, Date vagon_spec_mileage_left_date, Date vagon_spec_build_date, List<Repair> repairs) {
        this.positions = positions;
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
        this.repairs = repairs;
    }

    public WagonCache() {

    }



    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
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

    public UserWagon getUserWagonId() {
        return userWagonId;
    }

    public void setUserWagonId(UserWagon userWagonId) {
        this.userWagonId = userWagonId;
    }


    public long getVagon_no() {
        return vagon_no;
    }

    public void setVagon_no(long vagon_no) {
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

    public long getFrom_code() {
        return from_code;
    }

    public void setFrom_code(long from_code) {
        this.from_code = from_code;
    }

    public long getFrom_road_code() {
        return from_road_code;
    }

    public void setFrom_road_code(long from_road_code) {
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

    public long getTo_code() {
        return to_code;
    }

    public void setTo_code(long to_code) {
        this.to_code = to_code;
    }

    public long getUser_to_code() {
        return user_to_code;
    }

    public void setUser_to_code(long user_to_code) {
        this.user_to_code = user_to_code;
    }

    public long getTo_road_code() {
        return to_road_code;
    }

    public void setTo_road_code(long to_road_code) {
        this.to_road_code = to_road_code;
    }

    public double getTo_road_name() {
        return to_road_name;
    }

    public void setTo_road_name(double to_road_name) {
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

    public String getSend_date() {
        return send_date;
    }

    public void setSend_date(String send_date) {
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

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public Date getArrive_date_real() {
        return arrive_date_real;
    }

    public void setArrive_date_real(Date arrive_date_real) {
        this.arrive_date_real = arrive_date_real;
    }

    public Date getArrive_date_real_timestamp() {
        return arrive_date_real_timestamp;
    }

    public void setArrive_date_real_timestamp(Date arrive_date_real_timestamp) {
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

    public long getVagon_spec_common_type_name() {
        return vagon_spec_common_type_name;
    }

    public void setVagon_spec_common_type_name(long vagon_spec_common_type_name) {
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

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }
}
