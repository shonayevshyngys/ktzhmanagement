package server.domain.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "positions")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wagon_cache_id")
    private WagonCache wagonCacheId;


    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date current_position_date;
    @Column
    private long current_position_date_unix_timestamp;
    @Column
    private long utc_timestamp;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date utc_datetime;
    @Column
    private String current_position;
    @Column
    private long current_position_code;
    @Column
    private long current_position_road_code;
    @Column
    private long current_position_country_iso;

    @Column
    private double current_position_latitude;

    @Column
    private double current_position_longitude;

    @Column
    private long operation_id;

    @Column
    private String operation;

    @Column
    private String operation_code;

    @Column
    private long operation_asoup_code;

    @Column
    private String operation_type;

    @Column
    private String train_index;

    @Column
    private long train_number;

    @Column
    private long cont_train;

    @Column
    private String tr_from_name;

    @Column
    private long tr_from_station_code;

    @Column
    private long tr_from_road_code;

    @Column
    private long tr_from_country_code;

    @Column
    private long tr_from_country_code_iso;
    @Column
    private String tr_to_name_ru;
    @Column
    private long tr_tostation_code;
    @Column
    private long tr_to_road_code;
    @Column
    private long tr_to_country_code;
    @Column
    private long tr_to_country_code_iso;
    @Column
    private String state;
    @Column
    private String country_code;
    @Column
    private double weight;
    @Column
    private String loaded;

    @Column
    private long corrected_etsng_name;

    @Column
    private long previos_etsng_name;

    @Column
    private String days_end;

    @Column
    private long distance_end;
    @Column
    private long distance_end_geo;
    @Column
    private long full_distance;
    @Column
    private String additional;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date update_time;
    @Column
    private String nomer_nakladnoi;
    @Column
    private long gruz_sender;
    @Column
    private long gruz_sender_okpo;
    @Column
    private String gruz_sender_name;
    @Column
    private long gruz_receiver;
    @Column
    private long gruz_receiver_okpo;
    @Column
    private String gruz_receiver_name;
    @Column
    private String broken;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date send_date_railway;
    @Column
    private double trade_union_duration;
    @Column
    private String from_station_name;
    @Column
    private long from_station_station_code;
    @Column
    private long from_station_road_code;
    @Column
    private long road_code_country_code;
    @Column
    private long country_code_country_code_iso;
    @Column
    private String to_station_name;
    @Column
    private long to_station_station_code;
    @Column
    private long to_station_country_code;
    @Column
    private long to_station_country_code_iso;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date waybill_send_date;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WagonCache getWagonCacheId() {
        return wagonCacheId;
    }

    public void setWagonCacheId(WagonCache wagonCacheId) {
        this.wagonCacheId = wagonCacheId;
    }

    public Date getCurrent_position_date() {
        return current_position_date;
    }

    public void setCurrent_position_date(Date current_position_date) {
        this.current_position_date = current_position_date;
    }

    public long getCurrent_position_date_unix_timestamp() {
        return current_position_date_unix_timestamp;
    }

    public void setCurrent_position_date_unix_timestamp(long current_position_date_unix_timestamp) {
        this.current_position_date_unix_timestamp = current_position_date_unix_timestamp;
    }

    public long getUtc_timestamp() {
        return utc_timestamp;
    }

    public void setUtc_timestamp(long utc_timestamp) {
        this.utc_timestamp = utc_timestamp;
    }

    public Date getUtc_datetime() {
        return utc_datetime;
    }

    public void setUtc_datetime(Date utc_datetime) {
        this.utc_datetime = utc_datetime;
    }

    public String getCurrent_position() {
        return current_position;
    }

    public void setCurrent_position(String current_position) {
        this.current_position = current_position;
    }

    public long getCurrent_position_code() {
        return current_position_code;
    }

    public void setCurrent_position_code(long current_position_code) {
        this.current_position_code = current_position_code;
    }

    public long getCurrent_position_road_code() {
        return current_position_road_code;
    }

    public void setCurrent_position_road_code(long current_position_road_code) {
        this.current_position_road_code = current_position_road_code;
    }

    public long getCurrent_position_country_iso() {
        return current_position_country_iso;
    }

    public void setCurrent_position_country_iso(long current_position_country_iso) {
        this.current_position_country_iso = current_position_country_iso;
    }

    public double getCurrent_position_latitude() {
        return current_position_latitude;
    }

    public void setCurrent_position_latitude(double current_position_latitude) {
        this.current_position_latitude = current_position_latitude;
    }

    public double getCurrent_position_longitude() {
        return current_position_longitude;
    }

    public void setCurrent_position_longitude(double current_position_longitude) {
        this.current_position_longitude = current_position_longitude;
    }

    public long getOperation_id() {
        return operation_id;
    }

    public void setOperation_id(long operation_id) {
        this.operation_id = operation_id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation_code() {
        return operation_code;
    }

    public void setOperation_code(String operation_code) {
        this.operation_code = operation_code;
    }

    public long getOperation_asoup_code() {
        return operation_asoup_code;
    }

    public void setOperation_asoup_code(long operation_asoup_code) {
        this.operation_asoup_code = operation_asoup_code;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }

    public String getTrain_index() {
        return train_index;
    }

    public void setTrain_index(String train_index) {
        this.train_index = train_index;
    }

    public long getTrain_number() {
        return train_number;
    }

    public void setTrain_number(long train_number) {
        this.train_number = train_number;
    }

    public long getCont_train() {
        return cont_train;
    }

    public void setCont_train(long cont_train) {
        this.cont_train = cont_train;
    }

    public String getTr_from_name() {
        return tr_from_name;
    }

    public void setTr_from_name(String tr_from_name) {
        this.tr_from_name = tr_from_name;
    }

    public long getTr_from_station_code() {
        return tr_from_station_code;
    }

    public void setTr_from_station_code(long tr_from_station_code) {
        this.tr_from_station_code = tr_from_station_code;
    }

    public long getTr_from_road_code() {
        return tr_from_road_code;
    }

    public void setTr_from_road_code(long tr_from_road_code) {
        this.tr_from_road_code = tr_from_road_code;
    }

    public long getTr_from_country_code() {
        return tr_from_country_code;
    }

    public void setTr_from_country_code(long tr_from_country_code) {
        this.tr_from_country_code = tr_from_country_code;
    }

    public long getTr_from_country_code_iso() {
        return tr_from_country_code_iso;
    }

    public void setTr_from_country_code_iso(long tr_from_country_code_iso) {
        this.tr_from_country_code_iso = tr_from_country_code_iso;
    }

    public String getTr_to_name_ru() {
        return tr_to_name_ru;
    }

    public void setTr_to_name_ru(String tr_to_name_ru) {
        this.tr_to_name_ru = tr_to_name_ru;
    }

    public long getTr_tostation_code() {
        return tr_tostation_code;
    }

    public void setTr_tostation_code(long tr_tostation_code) {
        this.tr_tostation_code = tr_tostation_code;
    }

    public long getTr_to_road_code() {
        return tr_to_road_code;
    }

    public void setTr_to_road_code(long tr_to_road_code) {
        this.tr_to_road_code = tr_to_road_code;
    }

    public long getTr_to_country_code() {
        return tr_to_country_code;
    }

    public void setTr_to_country_code(long tr_to_country_code) {
        this.tr_to_country_code = tr_to_country_code;
    }

    public long getTr_to_country_code_iso() {
        return tr_to_country_code_iso;
    }

    public void setTr_to_country_code_iso(long tr_to_country_code_iso) {
        this.tr_to_country_code_iso = tr_to_country_code_iso;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLoaded() {
        return loaded;
    }

    public void setLoaded(String loaded) {
        this.loaded = loaded;
    }

    public long getCorrected_etsng_name() {
        return corrected_etsng_name;
    }

    public void setCorrected_etsng_name(long corrected_etsng_name) {
        this.corrected_etsng_name = corrected_etsng_name;
    }

    public long getPrevios_etsng_name() {
        return previos_etsng_name;
    }

    public void setPrevios_etsng_name(long previos_etsng_name) {
        this.previos_etsng_name = previos_etsng_name;
    }

    public String getDays_end() {
        return days_end;
    }

    public void setDays_end(String days_end) {
        this.days_end = days_end;
    }

    public long getDistance_end() {
        return distance_end;
    }

    public void setDistance_end(long distance_end) {
        this.distance_end = distance_end;
    }

    public long getDistance_end_geo() {
        return distance_end_geo;
    }

    public void setDistance_end_geo(long distance_end_geo) {
        this.distance_end_geo = distance_end_geo;
    }

    public long getFull_distance() {
        return full_distance;
    }

    public void setFull_distance(long full_distance) {
        this.full_distance = full_distance;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getNomer_nakladnoi() {
        return nomer_nakladnoi;
    }

    public void setNomer_nakladnoi(String nomer_nakladnoi) {
        this.nomer_nakladnoi = nomer_nakladnoi;
    }

    public long getGruz_sender() {
        return gruz_sender;
    }

    public void setGruz_sender(long gruz_sender) {
        this.gruz_sender = gruz_sender;
    }

    public long getGruz_sender_okpo() {
        return gruz_sender_okpo;
    }

    public void setGruz_sender_okpo(long gruz_sender_okpo) {
        this.gruz_sender_okpo = gruz_sender_okpo;
    }

    public String getGruz_sender_name() {
        return gruz_sender_name;
    }

    public void setGruz_sender_name(String gruz_sender_name) {
        this.gruz_sender_name = gruz_sender_name;
    }

    public long getGruz_receiver() {
        return gruz_receiver;
    }

    public void setGruz_receiver(long gruz_receiver) {
        this.gruz_receiver = gruz_receiver;
    }

    public long getGruz_receiver_okpo() {
        return gruz_receiver_okpo;
    }

    public void setGruz_receiver_okpo(long gruz_receiver_okpo) {
        this.gruz_receiver_okpo = gruz_receiver_okpo;
    }

    public String getGruz_receiver_name() {
        return gruz_receiver_name;
    }

    public void setGruz_receiver_name(String gruz_receiver_name) {
        this.gruz_receiver_name = gruz_receiver_name;
    }

    public String getBroken() {
        return broken;
    }

    public void setBroken(String broken) {
        this.broken = broken;
    }

    public Date getSend_date_railway() {
        return send_date_railway;
    }

    public void setSend_date_railway(Date send_date_railway) {
        this.send_date_railway = send_date_railway;
    }

    public double getTrade_union_duration() {
        return trade_union_duration;
    }

    public void setTrade_union_duration(double trade_union_duration) {
        this.trade_union_duration = trade_union_duration;
    }

    public String getFrom_station_name() {
        return from_station_name;
    }

    public void setFrom_station_name(String from_station_name) {
        this.from_station_name = from_station_name;
    }

    public long getFrom_station_station_code() {
        return from_station_station_code;
    }

    public void setFrom_station_station_code(long from_station_station_code) {
        this.from_station_station_code = from_station_station_code;
    }

    public long getFrom_station_road_code() {
        return from_station_road_code;
    }

    public void setFrom_station_road_code(long from_station_road_code) {
        this.from_station_road_code = from_station_road_code;
    }

    public long getRoad_code_country_code() {
        return road_code_country_code;
    }

    public void setRoad_code_country_code(long road_code_country_code) {
        this.road_code_country_code = road_code_country_code;
    }

    public long getCountry_code_country_code_iso() {
        return country_code_country_code_iso;
    }

    public void setCountry_code_country_code_iso(long country_code_country_code_iso) {
        this.country_code_country_code_iso = country_code_country_code_iso;
    }

    public String getTo_station_name() {
        return to_station_name;
    }

    public void setTo_station_name(String to_station_name) {
        this.to_station_name = to_station_name;
    }

    public long getTo_station_station_code() {
        return to_station_station_code;
    }

    public void setTo_station_station_code(long to_station_station_code) {
        this.to_station_station_code = to_station_station_code;
    }

    public long getTo_station_country_code() {
        return to_station_country_code;
    }

    public void setTo_station_country_code(long to_station_country_code) {
        this.to_station_country_code = to_station_country_code;
    }

    public long getTo_station_country_code_iso() {
        return to_station_country_code_iso;
    }

    public void setTo_station_country_code_iso(long to_station_country_code_iso) {
        this.to_station_country_code_iso = to_station_country_code_iso;
    }

    public Date getWaybill_send_date() {
        return waybill_send_date;
    }

    public void setWaybill_send_date(Date waybill_send_date) {
        this.waybill_send_date = waybill_send_date;
    }
}