package com.pmtech.doctorcrudservice.repository;

import com.pmtech.doctorcrudservice.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepository extends MongoRepository<Doctor,String> , CustomDoctorRepository {

    //@Query("{name:'?0'}")
    //@Query(" '$expr': { '$regexMatch': { 'input': { '$concat': ['$first', ' '', '$last'] }, 'regex': '?0', 'options': 'i'}}")

    //@Aggregation(pipeline = {"{$match:{'timestamp' : { $gte: ?0, $lte: ?1 }}}","{$group:{ _id: '$series_id', average: { $avg: '$value' }}}"})
   // List<Doctor> findDoctorByName(String name);


}
