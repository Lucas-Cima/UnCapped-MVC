package com.uncapped.uncappedmvc.models;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Beer {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, max=20)
    private String name;

    @NotNull
    @Size(min=1, max=20)
    private String brewery;


    @NotNull
    @Size(min=1, message = "I know you have something to say about this...")
    private String description;




    public Beer(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Beer() { }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
