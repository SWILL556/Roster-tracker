package com.vaughn.roster_tracker.controller;

import com.vaughn.roster_tracker.model.Soldier;
import com.vaughn.roster_tracker.service.SoldierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Soldier> getSoldier(@PathVariable Long id) {
        Soldier soldier = service.getSoldierById(id);
        if (soldier == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(soldier);
    }

    @PostMapping("/soldiers")
    public ResponseEntity<Soldier> addSoldier(@RequestBody Soldier soldier) {
        soldier = service.addSoldier(soldier);
        return ResponseEntity.status(HttpStatus.CREATED).body(soldier);
    }

    @PutMapping("/soldiers/{id}")
    public ResponseEntity<Soldier> updateSoldier(@PathVariable Long id, @RequestBody Soldier soldier) {
        soldier = service.updateSoldier(id, soldier);
        if (soldier == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(soldier);
    }

    @DeleteMapping("/soldiers/{id}")
    public ResponseEntity<Void> deleteSoldier(@PathVariable Long id) {
        boolean removed = service.deleteSoldier(id);

        if (!removed) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
