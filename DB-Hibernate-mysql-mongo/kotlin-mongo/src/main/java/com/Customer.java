package com;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public class Customer {
    private static int counter;
    @Id public int id;

    public String firstName;
    @NotNull public Boolean deleted;
    public String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName, Boolean deleted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deleted = deleted;
                this.id = ++counter;
    }

    @Override public String toString() {
        return String.format("Customer[id=%s, firstName='%s', lastName='%s', deleted='%s']", id, firstName, lastName, deleted);
    }

}