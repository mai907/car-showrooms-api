package com.car.showrooms.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_SHOWROOMS")
public class Showroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 10, unique = true)
    private Long cmr;
    @Column(length = 100)
    private String mangerName;
    @Column(nullable = false, length = 15)
    private Long contactNumber;
    @Column(length = 255)
    private String address;
    private boolean deleted;

    @OneToMany(mappedBy = "showroom")
    private List<Car> cars;

}
