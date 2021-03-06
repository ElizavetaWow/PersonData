package com.krylova.controller;

import com.krylova.entity.Person;
import com.krylova.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestApiController {

    private final PersonService personService;

    @Autowired
    public RestApiController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping("/api/persons")
    public ResponseEntity<?> create(@RequestBody Person person){
        personService.create(person);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/persons")
    public ResponseEntity<List<Person>> findAll(){
        final List<Person> personList = personService.findAll();
        return personList != null && !personList.isEmpty()
                ? new ResponseEntity<>(personList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/persons/{id}")
    public ResponseEntity<Optional<Person>> find(@PathVariable(name = "id") Long id){
        final Optional<Person> person = personService.find(id);
        return person != null
                ? new ResponseEntity<>(person, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/api/persons/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable(name = "id") Long id, @RequestBody Person personUpdate) {
        return personService.find(id).map(person -> {
            person.setFirstName(personUpdate.getFirstName());
            person.setLastName(personUpdate.getLastName());
            person.setCity(personUpdate.getCity());
            person.setStreet(personUpdate.getStreet());
            person.setBirthday(personUpdate.getBirthday());
            person.setPostalCode(personUpdate.getPostalCode());
            personService.update(person);
            return new ResponseEntity<>(person, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());

    }

    @DeleteMapping("/api/persons/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable(name = "id") Long id) {
        return personService.find(id).map(person -> {
            personService.delete(person);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new IllegalArgumentException());
    }





}
