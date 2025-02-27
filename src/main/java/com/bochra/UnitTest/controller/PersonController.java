package com.bochra.UnitTest.controller;

import com.bochra.UnitTest.model.Person;
import com.bochra.UnitTest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/list")
    public List<Person> getAllPersons(){
        return personService.getAllPerson();
    }
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id){
        return  personService.getPersonById(id).orElseThrow();
    }

    @PostMapping("/save")
    public Person createPerson(@RequestBody Person person){
        return personService.savePerson(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person personDetails){
        return personService.updatePerson(id, personDetails);
    }

    @DeleteMapping("/{id}")
    public void  deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }
}
