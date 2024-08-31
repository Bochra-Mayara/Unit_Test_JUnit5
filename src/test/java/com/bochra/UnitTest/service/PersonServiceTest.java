package com.bochra.UnitTest.service;
import com.bochra.UnitTest.model.Person;
import com.bochra.UnitTest.repository.PersonRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonServiceTest {
    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public  void should_successfully_save_a_person(){
        //Given
         Person person = new Person("hedia", "mayara", "hediamayara@gmail.com", 19);

        // Mock the calls
         when(personRepository.save(person)).thenReturn(person);
        //When
        Person savedPerson = personService.savePerson(person);

        //then
        assertNotNull(savedPerson);
        assertEquals(person.getFirstName(), savedPerson.getFirstName());
        assertEquals(person.getLastName(), savedPerson.getLastName());
        assertEquals(person.getEmail(), savedPerson.getEmail());
        assertEquals(person.getAge(), savedPerson.getAge());

        //Make sure that only save the person one time in database
        verify(personRepository,times(1)).save(person);
    }

    @Test
    public void testGetAllPerson(){
        //Given
        Person person1 = new Person("ali", "mayara", "alimayara@gmail.com", 20);
        Person person2 = new Person("sana", "mayara", "sanamayara@gmail.com", 24);
        List<Person> personList = Arrays.asList(person1,person2);

        // Mock the calls
        when(personRepository.findAll()).thenReturn(personList);

        // When

        List<Person> result = personService.getAllPerson();

        //then
       assertEquals(personList.size(),result.size());
       assertEquals(person1.getFirstName(),result.get(0).getFirstName());
       assertEquals(person2.getFirstName(),result.get(1).getFirstName());

        //Make sure that getAllPerson one time in database
        verify(personRepository,times(1)).findAll();




    }


    @Test
    public void should_return_person_by_id(){
        //Given
        Integer personId = 1;
        Person person = new Person("hedi", "mayara", "hedimayara@gmail.com", 30);

        // Mock the calls
        when(personRepository.findById(personId)).thenReturn(Optional.of(person));

        //when
        Optional<Person> resultGetByID = personService.getPersonById(personId);

        //then
        assertEquals(person, resultGetByID.get());

        //Make sure that getAllPerson one time in database
        verify(personRepository,times(1)).findById(personId);

    }

    @Test

    public void testUpdatePerson(){
        //Given
        Integer personId = 10;
        Person existingPerson = new Person("John", "Doe", "john.doe@example.com", 30);
        existingPerson.setId(personId);
        Person updatedPersonDetails = new Person("Jane", "Doe", "jane.doe@example.com", 28);


       // Mock the calls
        when(personRepository.findById(personId)).thenReturn(Optional.of(existingPerson));
        when(personRepository.save(existingPerson)).thenReturn(existingPerson);

        //When
        Person result = personService.updatePerson(personId,updatedPersonDetails);

        //then
        assertNotNull(result);
        assertEquals("Jane", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        assertEquals("jane.doe@example.com", result.getEmail());
        assertEquals(28, result.getAge());

        // Verify
        verify(personRepository,times(1)).findById(personId);
        verify(personRepository,times(1)).save(existingPerson);

    }


    @Test
    public void testDeletePerson(){
        //Given
        Integer personId = 10;

        //Mock the calls

        //When
        personService.deletePerson(personId);
        //then

        //Verify
        verify(personRepository,times(1)).deleteById(personId);
    }
}