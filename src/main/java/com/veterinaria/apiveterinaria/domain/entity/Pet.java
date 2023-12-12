package com.veterinaria.apiveterinaria.domain.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pet")
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String type;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && Objects.equals(name, pet.name) && Objects.equals(type, pet.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, age);
    }
}
