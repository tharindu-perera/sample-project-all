package com;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
@Document
public class Customer {
    private static int counter;
    @Id public String id;
    public String firstName;
    @NotNull public Boolean deleted;
    public String lastName;
    public   cons cons;

    public Customer() {
    }

    public Customer(String firstName, String lastName, Boolean deleted,cons cons) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deleted = deleted;
        this.id = firstName;
        this.cons = cons;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", deleted=" + deleted +
                ", lastName='" + lastName + '\'' +
                '}';
    }



}
