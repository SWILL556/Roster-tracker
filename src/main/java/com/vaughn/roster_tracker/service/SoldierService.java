package com.vaughn.roster_tracker.service;

import com.vaughn.roster_tracker.model.Soldier;
import org.springframework.stereotype.Service;

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

    public Soldier getSoldierById(Long id) {
        for (Soldier s : soldiers) {
            if(s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public Soldier addSoldier(Soldier soldier) {
        long maxId = 0;
        for (Soldier s : soldiers) {
            if (s.getId() > maxId) {
                maxId = s.getId();
            }
        }
        long nextId = maxId + 1;
        soldier.setId(nextId);
        soldiers.add(soldier);
        return soldier;
    }

    public Soldier updateSoldier(Long id, Soldier updated) {
        Soldier existing = getSoldierById(id);
        if (existing == null) {
            return null;
        }
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setRank(updated.getRank());
        existing.setMos(updated.getMos());

        return existing;
    }

    public boolean deleteSoldier(Long id) {
        Soldier existing = getSoldierById(id);

        if (existing == null) {
            return false;
        }
        soldiers.remove(existing);
        return true;
    }
}
