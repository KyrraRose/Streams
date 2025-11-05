package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class Person implements Comparable<Person> {
    private String firstName, lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person that) {
        if (this.age > that.age){
            return -1;
        }else if (this.age > that.age){
            return 1;
        }else{
            return 0;
        }
    }
}
