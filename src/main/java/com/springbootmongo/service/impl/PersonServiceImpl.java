package com.springbootmongo.service.impl;

import com.springbootmongo.collection.Person;
import com.springbootmongo.repository.PersonRepository;
import com.springbootmongo.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public String save(Person person) {
        return personRepository.save(person).getPersonId();
    }

    @Override
    public Optional<Person> getPersonById(String id) {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> getPersonByAge(Integer minAge, Integer maxAge) {
        return personRepository.findPersonByAgeBetween(minAge,maxAge);
    }
}
