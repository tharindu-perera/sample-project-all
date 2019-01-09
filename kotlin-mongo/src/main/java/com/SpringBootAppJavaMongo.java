package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootApplication @Component public class SpringBootAppJavaMongo implements CommandLineRunner {

    @Value("${customer}") private String cus;

    @Autowired
     private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppJavaMongo.class, args);
    }

    @Override public void run(String... args) throws Exception {

        Date date = new Date();
//        repository.deleteAll();
        repository.save(new CustomerIndustryReference("abcd22","lastname2", date));
//        repository.save(new Customer("Bob", "Smith", false));
         List<CustomerIndustryReference> all = repository.findBynameOrderByCreateddateDesc("lastname2");
        for (CustomerIndustryReference customer : all) {
            System.out.println(customer);
        }
//        System.out.println(repository.findById("abc"));


        System.out.println(repository.count());
     }

}