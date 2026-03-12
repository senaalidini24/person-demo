package com.Sena.person.controller;

import com.Sena.person.dto.PersonDTO;
import com.Sena.person.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service){
        this.service = service;
    }

    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO dto){
        return service.savePerson(dto);
    }

    @GetMapping
    public List<PersonDTO> getAll() {
        return service.getAll();
}
