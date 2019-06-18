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
    private LocalDate current_position_date;
    @Column
    private long current_position_date_unix_timestamp;
    @Column
    private long utc_timestamp;
    @Column
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
    private Date waybill_send_date;


}