package com.vaughn.roster_tracker.service;

import com.vaughn.roster_tracker.model.Soldier;
import com.vaughn.roster_tracker.repository.SoldierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldierService {

    private final SoldierRepository repository;

    public SoldierService(SoldierRepository repository) {
        this.repository = repository;
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
}
