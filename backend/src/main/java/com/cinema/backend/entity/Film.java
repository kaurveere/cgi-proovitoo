package com.cinema.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_id")
    private int roomId;

    @Column(name = "name")
    private String name;
    @Column(name = "rating")
    private double rating;
    @Column(name = "timestamp")
    private Timestamp timestamp;
    @Column(name = "genre")
    private String genre;
    @Column(name = "age_restriction")
    private String ageRestriction;
}
