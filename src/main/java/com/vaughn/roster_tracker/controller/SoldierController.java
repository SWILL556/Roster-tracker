package com.vaughn.roster_tracker.controller;

import com.vaughn.roster_tracker.model.Soldier;
import com.vaughn.roster_tracker.service.SoldierService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
