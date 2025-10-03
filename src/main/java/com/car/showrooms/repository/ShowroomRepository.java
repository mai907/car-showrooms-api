package com.car.showrooms.repository;

import com.car.showrooms.entity.Showroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowroomRepository extends JpaRepository<Showroom, Long> {

    Page<Showroom> findByDeletedIsFalse(Pageable pageable);

    Optional<Showroom> findByIdAndDeletedIsFalse(Long id);

    Optional<Showroom> findByCmr(Long cmr);

}
