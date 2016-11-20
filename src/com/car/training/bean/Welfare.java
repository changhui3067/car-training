package com.car.training.bean;

import javax.persistence.*;

/**
 * Created by bill on 11/13/16.
 */

@Entity
@Table
public class Welfare {
    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String name;

    @Column
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
