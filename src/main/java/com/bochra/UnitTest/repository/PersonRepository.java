package com.bochra.UnitTest.repository;

import com.bochra.UnitTest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
