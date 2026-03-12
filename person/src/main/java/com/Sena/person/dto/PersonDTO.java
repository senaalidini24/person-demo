package com.Sena.person.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String nationality;
    private String email;
    private String phoneNumber;
    private String street;
    private String streetNumber;
    private String city;
}

