package com.Sena.person.service;

import com.Sena.person.dto.PersonDTO;
import com.Sena.person.model.Person;
import com.Sena.person.model.Address;
import com.Sena.person.repository.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository repository;
    public PersonService(PersonRepository repository){
        this.repository = repository;
    }

    public PersonDTO savePerson(PersonDTO dto){
        Person person = new Person();
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setBirthDate(dto.getBirthDate());
        person.setNationality(dto.getNationality());
        person.setEmail(dto.getEmail());
        person.setPhoneNumber(dto.getPhoneNumber());

        Address address = new Address(dto.getStreet(), dto.getStreetNumber(), dto.getCity());
        person.setAddress(address);

        repository.save(person);
        return dto;
    }

    public List<PersonDTO> getAll(){
        return repository.findAll().stream()
                .map(p -> new PersonDTO(
                        p.getFirstName(), p.getLastName(), p.getBirthDate(), p.getNationality(), p.getEmail(), p.getPhoneNumber(),
                        p.getAddress().getStreet(), p.getAddress().getStreetNumber(), p.getAddress().getCity()
                )).collect(Collectors.toList());

    }

}
