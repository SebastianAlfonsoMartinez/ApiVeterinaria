package com.veterinaria.apiveterinaria.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    String name;
    String type;
    int age;

}
