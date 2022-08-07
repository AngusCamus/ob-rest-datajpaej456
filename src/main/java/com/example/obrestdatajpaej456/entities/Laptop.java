package com.example.obrestdatajpaej456.entities;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
    private String color;
    private Integer screenSize;


    public Laptop() {
    }

    public Laptop(Long id, String manufacturer,  String color, Integer screenSize) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.color = color;
        this.screenSize = screenSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Integer screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", color='" + color + '\'' +
                ", screenSize=" + screenSize +
                '}';
    }
}
