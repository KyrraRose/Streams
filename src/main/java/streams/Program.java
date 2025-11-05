package streams;

import com.pluralsight.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = loadList();


        double ages = 0;

        System.out.println("Welcome to Hawkins Indiana Look-Up ----");

        System.out.println("Full Directory:");
        people.stream()
                .forEach(person ->System.out.println(String.format("%-5s %s | Age: %2d", person.getFirstName(), person.getLastName(),person.getAge())));

        System.out.print("\nWhat is the name of the person? (first or last): ");
        String name = scanner.nextLine().trim().toLowerCase();

        System.out.println("\nResults...\n---------------");
        List<String> matches = people.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(name) || person.getLastName().equalsIgnoreCase(name))
                .map(person -> String.format("%-5s %s | Age: %2d", person.getFirstName(), person.getLastName(),person.getAge()))
                .peek(System.out::println)
                .toList();
        System.out.println("---------------");




        double avgAge = people.stream()
                .mapToInt(Person::getAge).average()
                .orElse(0);

        int oldest = people.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElse(0);
        int youngest = people.stream()
                .mapToInt(Person::getAge)
                .min()
                .orElse(0);


        //Transformation 2
        System.out.println();
        System.out.printf("Average Age of all Citizens in Hawkins: %.1f\n", avgAge);
        System.out.println();
        System.out.println("Oldest Citizen: " + oldest);
        System.out.println("Youngest Citizen: " + youngest);


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
