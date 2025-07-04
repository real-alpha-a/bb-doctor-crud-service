package com.pmtech.doctorcrudservice.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Qualification {

    private String degree;
    private String institution;
    private Date startYear;
    private Date endYear;

}
