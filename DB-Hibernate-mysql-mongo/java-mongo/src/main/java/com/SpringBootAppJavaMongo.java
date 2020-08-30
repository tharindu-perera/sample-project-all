package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;

@SpringBootApplication
@Component
public class SpringBootAppJavaMongo implements ApplicationRunner {

    @Value("${customer}") private String cus;

    @Autowired
     private CustomerRepository repository;
    @Autowired
    private MongoTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppJavaMongo.class, args);
    }

    @Override public void run(ApplicationArguments  args)  {
        repository.deleteById("5b6426ef8fcaba6c04bdd3a0");
        repository.save(new Customer("A", "A", true, cons.A));
        repository.save(new Customer("AA", "C", true, cons.A));
        repository.save(new Customer("B", "D", true, cons.B));
//        repository.save(new Customer("Bob", "Smith", false));
        for (Customer customer : repository.findAll()) {
//            System.out.println(customer);
        }
//        repository.deleteAll();
//        System.out.println(repository.findByFirstName("Bob"));
//        System.out.println(repository.findById(1));


        Query query = new Query();
        Criteria criteria = new Criteria();
        Criteria regex = Criteria.where("firstName").is("AA") ;
        Criteria regex2 = Criteria.where("lastName").is("C") ;
        criteria.andOperator(regex,regex2);
        System.out.println(criteria.getKey().length());
        Criteria criteria2 = new Criteria();

        query.addCriteria(criteria2.orOperator( criteria,Criteria.where("firstName").is("B").and("lastName").is("D")));
//        query.addCriteria(Criteria.where("firstName").regex("^A").and("lastName").regex("C"));
//        query.addCriteria(Criteria.where("firstName").regex("^B") );//.orOperator(Criteria.where("firstName").regex("^B")
        List<Customer> users = template.find(query,Customer.class);
        System.out.println(users);
    }


}