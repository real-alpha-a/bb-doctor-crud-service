package com.pmtech.doctorcrudservice.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expreriance {
    private String degree;
    private String employer;
    private Date starDate;
    private Date endDate;
}
