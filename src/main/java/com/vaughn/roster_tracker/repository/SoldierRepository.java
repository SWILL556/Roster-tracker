package com.vaughn.roster_tracker.repository;

import com.vaughn.roster_tracker.model.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoldierRepository extends JpaRepository<Soldier, Long> {

    List<Soldier> findByMos(String mos);
    List<Soldier> findByRankOrderByLastNameAsc(String rank);
    long countByMos(String mos);
}
