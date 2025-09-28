package com.car.showrooms.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_SHOWROOM")
public class Showroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 10, unique = true)
    private Integer cmr;
    @Column(length = 100)
    private String mangerName;
    @Column(nullable = false, length = 15)
    private Integer contactNumber;
    @Column(length = 255)
    private String address;
    private boolean deleted;

}
