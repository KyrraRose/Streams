package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class Person {
    private String firstName, lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    public ArrayList<Person> loadList(){
        try {
            ArrayList<Person> people = new ArrayList<>();
            BufferedReader buffReader = new BufferedReader(new FileReader("src/main/resources/people.csv"));

            String input;
            while ((input = buffReader.readLine())!=null){
                String [] variable = input.split("\\|");

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
