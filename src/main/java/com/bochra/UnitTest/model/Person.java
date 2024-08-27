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

    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public Person(String firstName, String lastName, String email,  int age) {
        if (firstName == null || lastName == null || email == null ) {
            throw new InvalidPersonException("Fields should not be null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
}
