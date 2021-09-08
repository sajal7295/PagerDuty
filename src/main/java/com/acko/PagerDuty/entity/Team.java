package com.acko.PagerDuty.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    List<Developer> developerList;

    public Team(String name, List<Developer> developerList) {
        this.name = name;
        this.developerList = developerList;
    }

    public Long getId() {
        return id;
    }

    public List<Developer> getDeveloperList() {
        return developerList;
    }
}