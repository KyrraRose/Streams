package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = loadList();

        System.out.print("Welcome to the people book!\nWhat is the name of the person? (first or last): ");
        String name = scanner.nextLine().trim().toLowerCase();


        for (Person person : people){
            if (person.getFirstName().contains(name)){
                System.out.println("fname matches");
            } else if (person.getLastName().contains(name)) {
                
            }

        }


    }
    public static  ArrayList<Person> loadList(){
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

                people.add(new Person(first,last,age));

            }
            return people;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
