package com.vaughn.roster_tracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "soldiers")
public class Soldier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "soldier_rank", nullable = false)
    private String rank;

    @Column(nullable = false)
    private String mos;

    // Field for the platoon
    @ManyToOne
    @JoinColumn(name = "platoon_id")
    private Platoon platoon;

    // no-arg constructor required by some spring/JSON tools
    public Soldier() {

    }

    public Soldier(Long id, String firstName, String lastName, String rank, String mos) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rank = rank;
        this.mos = mos;
    }

    // Getters and setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getRank() {return rank;}
    public void setRank(String rank) {this.rank = rank;}

    public String getMos() {return mos;}
    public void setMos(String mos) {this.mos = mos;}

    // Getter and setter for platoon
    public Platoon getPlatoon() {return platoon;}
    public void setPlatoon(Platoon platoon) {this.platoon = platoon;}
}