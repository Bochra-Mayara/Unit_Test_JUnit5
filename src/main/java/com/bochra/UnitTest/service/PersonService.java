package com.bochra.UnitTest.service;

import com.bochra.UnitTest.model.Person;
import com.bochra.UnitTest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById( Long id){
        return personRepository.findById(id);
    }

    public  Person savePerson(Person person){
        return  personRepository.save(person);
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }

    public Person updatePerson(Long id, Person personDetails){
        Person person = personRepository.findById(id).orElseThrow();
        person.setName(personDetails.getName());
        person.setAge(personDetails.getAge());
        return personRepository.save(person);
    }
}
