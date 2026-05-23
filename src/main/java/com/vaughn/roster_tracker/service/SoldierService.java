package com.vaughn.roster_tracker.service;

import com.vaughn.roster_tracker.model.Soldier;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class SoldierService {

    // Hard-coded database just for testing right now
    private final List<Soldier> soldiers = new ArrayList<>(List.of(
            new Soldier(1L, "Shay", "Butler", "SGT", "13F"),
            new Soldier(2L, "Ann", "Williams", "PFC", "13B"),
            new Soldier(3L, "Peach", "Cups", "PV2", "25B")
    ));

    public List<Soldier> getAllSoldiers() {
        return soldiers;
    }

}
