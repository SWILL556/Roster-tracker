package com.vaughn.roster_tracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "platoons")
public class Platoon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String designator;

    public Platoon(){}

    public Platoon(String name, String designator){
        this.name = name;
        this.designator = designator;
    }

    // Getters and Setters

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDesignator() {return designator;}
    public void setDesignator(String designator) {this.designator = designator;}
}
