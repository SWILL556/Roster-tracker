package com.vaughn.roster_tracker.service;

import com.vaughn.roster_tracker.model.Platoon;
import com.vaughn.roster_tracker.model.Soldier;
import com.vaughn.roster_tracker.repository.PlatoonRepository;
import com.vaughn.roster_tracker.repository.SoldierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldierService {

    private final SoldierRepository repository;
    private final PlatoonRepository platoonRepository;

    public SoldierService(SoldierRepository repository, PlatoonRepository platoon) {
        this.repository = repository;
        this.platoonRepository = platoon;
    }

    public List<Soldier> getAllSoldiers() {
        return repository.findAll();
    }

    public Soldier getSoldierById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Soldier addSoldier(Soldier soldier) {
        return repository.save(soldier);
    }

    public Soldier updateSoldier(Long id, Soldier updated) {
        Soldier existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setRank(updated.getRank());
        existing.setMos(updated.getMos());

        return repository.save(existing);
    }

    public boolean deleteSoldier(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    public List<Soldier> getSoldierByMos(String mos) {
        return repository.findByMos(mos);
    }

    public Soldier assignToPlatoon(Long soldierId, Long platoonId) {
        Soldier soldier = repository.findById(soldierId).orElse(null);
        if (soldier == null) {
            return null;
        }
        Platoon platoon = platoonRepository.findById(platoonId).orElse(null);
        if (platoon == null) {
            return null;
        }
        soldier.setPlatoon(platoon);
        return repository.save(soldier);
    }
}
