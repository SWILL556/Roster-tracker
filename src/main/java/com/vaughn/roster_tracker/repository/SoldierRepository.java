package com.vaughn.roster_tracker.repository;

import com.vaughn.roster_tracker.model.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldierRepository extends JpaRepository<Soldier, Long> {

}
