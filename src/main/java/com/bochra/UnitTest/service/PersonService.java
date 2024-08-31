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

    public Optional<Person> getPersonById( Integer id){
        return personRepository.findById(id);
    }

    public  Person savePerson(Person person){
        return  personRepository.save(person);

    }

    public void deletePerson( Integer id){
        personRepository.deleteById(id);
    }

    public Person updatePerson(Integer id, Person personDetails){
        Person person = personRepository.findById(id).orElseThrow();
        person.setFirstName(personDetails.getFirstName());
        person.setLastName(personDetails.getLastName());
        person.setEmail(personDetails.getEmail());
        person.setAge(personDetails.getAge());
        return personRepository.save(person);
    }
}
