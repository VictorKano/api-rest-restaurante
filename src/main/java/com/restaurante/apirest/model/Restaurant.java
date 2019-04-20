package com.restaurante.apirest.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Restaurant extends AbstractEntity{
    @NotEmpty
    private String name;

    public Restaurant(@NotEmpty String name) {
        this.name = name;
    }

    public Restaurant(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
