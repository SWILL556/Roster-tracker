package com.vaughn.roster_tracker.controller;

import com.vaughn.roster_tracker.model.Soldier;
import com.vaughn.roster_tracker.service.SoldierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SoldierController {

    private final SoldierService service;

    public SoldierController(SoldierService service) {
        this.service = service;
    }

    @GetMapping("/soldiers")
    public List<Soldier> getAllSoldiers() {
        return service.getAllSoldiers();
    }

    @GetMapping("/soldiers/{id}")
    public Soldier getSoldier(@PathVariable Long id) {
        return service.getSoldierById(id);
    }

    @PostMapping("/soldiers")
    public Soldier addSoldier(@RequestBody Soldier soldier) {
        return service.addSoldier(soldier);
    }

    @PutMapping("/soldiers/{id}")
    public Soldier updateSoldier(@PathVariable Long id, @RequestBody Soldier soldier) {
        return service.updateSoldier(id, soldier);
    }

    @DeleteMapping("/soldiers/{id}")
    public void deleteSoldier(@PathVariable Long id) {
        service.deleteSoldier(id);
    }
}
