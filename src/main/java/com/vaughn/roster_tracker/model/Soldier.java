package com.vaughn.roster_tracker.model;

public class Soldier {
    private Long id;
    private String firstName;
    private String lastName;
    private String rank;
    private String mos;

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
    public void setFirstName(String firstName) {this.firstName = this.firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = this.lastName;}

    public String getRank() {return rank;}
    public void setRank(String rank) {this.rank = rank;}

    public String getMos() {return mos;}
    public void setMos(String mos) {this.mos = this.mos;}
}