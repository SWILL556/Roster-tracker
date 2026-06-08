package com.vaughn.roster_tracker.service;

import com.vaughn.roster_tracker.model.Platoon;
import com.vaughn.roster_tracker.repository.PlatoonRepository;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.List;

@Service
public class PlatoonService {
    private final PlatoonRepository repository;

    public PlatoonService(PlatoonRepository repository) {
        this.repository = repository;
    }

    public List<Platoon> getAllPlatoons() {
        return repository.findAll();
    }

    public Platoon getPlatoonById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Platoon addPlatoon(Platoon platoon) {
        return repository.save(platoon);
    }
}
