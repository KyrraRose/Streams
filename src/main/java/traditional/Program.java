package traditional;

import com.pluralsight.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = loadList();


        double ages = 0;

        System.out.println("Welcome to Hawkins Indiana ----");

        System.out.print("What is the name of the person? (first or last): ");
        String name = scanner.nextLine().trim().toLowerCase();
        List<Person> matches = new ArrayList<>();

        for (Person person : people){
            if (person.getFirstName().equalsIgnoreCase(name)){
                matches.add(person);
            } else if (person.getLastName().equalsIgnoreCase(name)) {
                matches.add(person);
            }
            ages += person.getAge();
        }

        for(Person person : matches){
            System.out.printf("%s|%s|%d",person.getFirstName(),person.getLastName(),person.getAge());
            System.out.println();
        }

        int avgAge = 0;
        int oldest = -1;
        int youngest = 1000;

        for (Person person: people) {
            avgAge += person.getAge(); //transformation 1

            if (person.getAge() > oldest) {
                oldest = person.getAge();
            }

            if (person.getAge() < youngest) {
                youngest = person.getAge();
            }
        }

        //Transformation 2
        System.out.println("Average Age of all People: " + avgAge / people.size());

        System.out.println("Oldest Age of all People: " + oldest);
        System.out.println("Youngest Age of all People: " + youngest);


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
