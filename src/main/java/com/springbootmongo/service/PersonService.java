package com.springbootmongo.service;

import com.springbootmongo.collection.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    String save(Person person);

    Optional<Person> getPersonById(String id);

    List<Person> getPersonByAge(Integer minAge, Integer maxAge);
}
