package com.car.showrooms.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_CARS")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 25)
    private String vin;
    @Column(nullable = false, length = 25)
    private String maker;
    @Column(nullable = false, length = 25)
    private String model;
    @Column(nullable = false, length = 4)
    private Integer modelYear;
    @Column(nullable = false)
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "showroom_id")
    private Showroom showroom;

}
