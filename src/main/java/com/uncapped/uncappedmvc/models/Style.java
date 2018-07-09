package com.uncapped.uncappedmvc.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Style {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=20)
    private String name;

    @OneToMany
    @JoinColumn( name = "style_id")
    private List<Beer> beers = new ArrayList<>();


    public Style() {}

    public Style(String name) {this.name = name;}

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Beer> getBeers() { return beers; }

    public void setBeers(List<Beer> beers) { this.beers = beers; }
}
