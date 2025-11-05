package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {


    }
    public ArrayList<Person> loadList(){
        try {
            ArrayList<Person> people = new ArrayList<>();
            BufferedReader buffReader = new BufferedReader(new FileReader("src/main/resources/people.csv"));

            String input,first,last;
            int age;
            while ((input = buffReader.readLine())!=null){
                String [] token = input.split("\\|");

                first = token[0];
                last = token[1];
                age = Integer.parseInt(token[2]);

                people.add(first,last,age);

            }
            return people;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
