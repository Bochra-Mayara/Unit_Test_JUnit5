package com.bochra.UnitTest.service;

import com.bochra.UnitTest.exception.InvalidPersonException;
import com.bochra.UnitTest.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonServiceTest {
    @Autowired
    private PersonService personService;


    @Test
    public void shouldSavaPerson() {
        Person personToSave = new Person("John Doe", 30);
        Person savedPerson = personService.savePerson(personToSave);
        assertNotNull(savedPerson);
        assertNotNull(savedPerson.getName(), personToSave.getName());


    }



    @Test
    public void shouldThrowInvalidPersonExceptionWhenNameIsMissing() {



        // Act & Assert
        assertThrows(InvalidPersonException.class, () -> {
            new Person(null, 30);
        }, "Name cannot be null or empty");


    }




}