package com.pmtech.doctorcrudservice.model;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true) // Includes superclass fields
@AllArgsConstructor
@NoArgsConstructor
public class Professional extends Auditable {

    private String initial;

    @NotEmpty(message = "Please enter a valid firstName")
    @Size(max = 50,message = "firstName should not be more than 50 characters")
    private String firstName;

    @Size(max = 50,message = "middleName should not be more than 50 characters")
    private String middleName;

    @NotEmpty(message = "Please enter a valid lastName")
    @Size(max = 50,message = "lastName should not be more than 50 characters")
    private String lastName;

    @Valid
    private List<Speciality> specialities;

    @Valid
    private List<Qualification> qualifications;

    @Valid
    private List<Expreriance> expreriances;

    @Valid
    private Address address;

    @Valid
    private List<EmailAddress> emailAddresses;

    private List<Phone> phoneNumbers;
}
