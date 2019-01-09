package com;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.core.query.Query;


public interface CustomerRepository extends MongoRepository<CustomerIndustryReference, String> {

    List<CustomerIndustryReference> findBynameOrderByCreateddateDesc (String stfr );
//    public List<Customer> findByLastName(String lastName);

}
//abstract class CustomRule15RepositoryImpl implements CustomerRepository  {
//@Autowired
//    MongoTemplate  mongoTemplate;
////    @Override
////    public List<CustomerIndustryReference> findByName(String firstName) {
////        Query query
////                =new Query();
////        List animals = mongoTemplate.find(query, CustomerIndustryReference.class);
////        return null;
////    }
//}
