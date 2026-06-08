package com.vaughn.roster_tracker.repository;

import com.vaughn.roster_tracker.model.Platoon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlatoonRepository extends JpaRepository<Platoon, Long> {
    Optional<Platoon> findByDesignator(String designator);
}
