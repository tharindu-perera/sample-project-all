package com;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;


  interface CustomerRepository extends MongoRepository<CustomerIndustryReference, String> {

    List<CustomerIndustryReference> findBynameOrderByCreateddateDesc(String stfr);
}



interface   RWCRepository extends MongoRepository<RWC, String>{
    List<RWC> findAllBy( );
        }




//  class RWCRepositoryw implements RWCRepository  {
//@Autowired
//    MongoTemplate  mongoTemplate;
//    @Override
//    public List<RWC>findByname(String firstName) {
//        Query query
//                =new Query();
//        List animals = mongoTemplate.find(query, RWC.class);
//        return null;
//    }
//}
