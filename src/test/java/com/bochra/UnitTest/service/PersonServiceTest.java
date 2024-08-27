package com.bochra.UnitTest.service;

import com.bochra.UnitTest.exception.InvalidPersonException;
import com.bochra.UnitTest.model.Person;
import org.junit.jupiter.api.*;
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


    /*before class method */
    @BeforeAll
    static void beforeAll() {
        System.out.println("Inside the before all methods");

    }

    @AfterAll
    static void afterAll() {
        System.out.println("Inside the after all methods");

    }

    @BeforeEach
    void setUp() {
        System.out.println("Inside the before each method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Inside the after each method");
    }

    @Test
    public void testMethod1(){
        System.out.println("My first test method");
    }

    @Test
    public void testMethod2(){
        System.out.println("My second test method");
    }
    @Test
    public void shouldSavaPerson() {
        Person personToSave = new Person("bochra", "mayara", "bochramayara@gmail.com", 23);
        Person savedPerson = personService.savePerson(personToSave);
        assertNotNull(savedPerson);
        assertEquals(savedPerson.getFirstName(), personToSave.getFirstName());
        assertEquals(savedPerson.getLastName(), personToSave.getLastName());
        assertEquals(savedPerson.getEmail(), personToSave.getEmail());
        assertEquals(savedPerson.getAge(), personToSave.getAge());


    }



    @Test
    public void shouldThrowInvalidPersonExceptionWhenNameIsMissing() {



        // Act & Assert
        var exp = assertThrows(InvalidPersonException.class, () ->
            new Person("aicha", null,null, 21));
        assertEquals("Fields should not be null", exp.getMessage());


    }




}