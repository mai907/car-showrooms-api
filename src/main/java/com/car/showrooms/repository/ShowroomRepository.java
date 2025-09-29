package com.car.showrooms.repository;

import com.car.showrooms.entity.Showroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowroomRepository extends JpaRepository<Showroom, Long> {

    List<Showroom> findByDeletedIsFalse();

    Optional<Showroom> findByIdAndDeletedIsFalse(Long id);

    Optional<Showroom> findByCmr(Long cmr);

}
