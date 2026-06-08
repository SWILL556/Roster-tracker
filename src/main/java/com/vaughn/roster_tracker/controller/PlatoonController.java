package com.vaughn.roster_tracker.controller;

import com.vaughn.roster_tracker.model.Platoon;
import com.vaughn.roster_tracker.service.PlatoonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlatoonController {

    private final PlatoonService service;

    public PlatoonController(PlatoonService service) {
        this.service = service;
    }

    @GetMapping("/platoons")
    public List<Platoon> getAllPlatoons() {
        return service.getAllPlatoons();
    }

    @GetMapping("/platoons/{id}")
    public ResponseEntity<Platoon> getPlatoon(@PathVariable Long id) {
        Platoon p = service.getPlatoonById(id);
        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    @PostMapping("/platoons")
    public ResponseEntity<Platoon> addPlatoon(@RequestBody Platoon platoon) {
        Platoon saved = service.addPlatoon(platoon);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
