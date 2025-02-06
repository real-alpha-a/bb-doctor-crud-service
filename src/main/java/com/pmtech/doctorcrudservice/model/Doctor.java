package com.pmtech.doctorcrudservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document("doctors")
public class Doctor extends Professional {

    @Id
    private String doctorId;

    @Valid
    List<Registration> registrations;
}
