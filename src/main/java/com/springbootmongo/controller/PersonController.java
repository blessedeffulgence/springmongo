package com.springbootmongo.controller;

import com.springbootmongo.collection.Person;
import com.springbootmongo.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public String save(@RequestBody Person person)
    {
        return personService.save(person);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getPersonById(@RequestParam String id)
    {
        Optional<Person> result = personService.getPersonById(id);
        if (result.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id: "+ id + " Not found" );
        }
        else
           return ResponseEntity.status(HttpStatus.OK).body(result.stream().toList().toString());


    }
       @GetMapping("/age")
      public List<Person> getPersonByAge(@RequestParam Integer minAge, @RequestParam Integer maxAge)
      {
          return personService.getPersonByAge(minAge , maxAge);

      }
}
