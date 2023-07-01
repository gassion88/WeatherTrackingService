package com.gassion88.weathertrackingservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "measurment")
@Getter
@Setter
@NoArgsConstructor
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "value")
    private double value;

    @Column(name = "raining")
    private boolean raining;

    @Column(name = "measurement_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date measurementDateTime;

    @OneToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensorID;
}
