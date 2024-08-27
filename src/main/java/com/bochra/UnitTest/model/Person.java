package com.bochra.UnitTest.model;

import com.bochra.UnitTest.exception.InvalidPersonException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    public Person(String name, int age) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidPersonException("Name cannot be null or empty");
        }
        this.name = name;
        this.age = age;
    }
}
