package com.pmtech.doctorcrudservice.repository;

import com.pmtech.doctorcrudservice.model.Doctor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.util.StringUtils.hasText;

import java.util.List;

public class DoctorRepositoryImpl implements CustomDoctorRepository {

    private final MongoTemplate mongoTemplate;

    public DoctorRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Doctor> findDoctorByFirstNameOrLastName(String searchValue) {

        if(!hasText(searchValue)){
            return  null;
        }

        String[] parts = searchValue.trim().split(" ");

        Criteria criteria;

        if(parts.length >= 2 && hasText(parts[0]) && hasText(parts[1])){

            criteria = new Criteria().orOperator(
                    Criteria.where("firstName").is(parts[0].trim()).andOperator(Criteria.where("lastName").regex(parts[1].trim())),
                    Criteria.where("lastName").is(parts[0]).andOperator(Criteria.where("firstName").regex(parts[1])));
        }
        else{
            criteria =  new Criteria().orOperator(Criteria.where("firstName").regex(searchValue.trim()), Criteria.where("lastName").regex(searchValue.trim()));
        }

        Query query = new Query();
        query.addCriteria(criteria);

        return  mongoTemplate.find(query,Doctor.class);
    }
}
