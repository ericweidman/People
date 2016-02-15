import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class People {
    public static void main(String[] args) throws IOException {
        HashMap<String, ArrayList<Person>> personMap = new HashMap<>();
        ArrayList<Person> allPeople = new ArrayList<>();

        File f = new File("people.csv");
        Scanner fileScanner = new Scanner(f);
        fileScanner.nextLine();
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split(",");
            Person person = new Person(Integer.parseInt(columns[0]), columns[1], columns[2], columns[3], columns[4], columns[5]);
            allPeople.add(person);
        }
        for (Person person : allPeople) {
            String country = person.country;
            personMap.put(country, new ArrayList<>());
        }
        for (Person person : allPeople) {
            String country = person.country;
            personMap.get(country).add(person);
        }

        String fileName = "Person.json";
        for (ArrayList<Person> people : personMap.values()) {
            Collections.sort(people);
        }
        System.out.println(personMap.toString());
        jsonSave(fileName, personMap);


    }

    static void jsonSave(String fileName, HashMap<String, ArrayList<Person>> personMap) throws IOException {
        JsonSerializer s = new JsonSerializer();
        String json = s.include("*").serialize(personMap);
        FileWriter fw = new FileWriter(fileName);
        fw.write(json);
        fw.close();
    }
}











        /*Create a Person class to store all the columns in the csv file.

        +Create a HashMap<String, ArrayList<Person>> that maps country name to a list of people from that country.

        +Loop over the HashMap and sort each list by last name.

        +Override toString in the Person class to print out a nicely-formatted string
        for that person (something like "Martha Jenkins from France").

        +Print out the entire HashMap at the end.

        +Break your code into separate methods.

        +Write the resulting HashMap to a file called "people.json" formatted as JSON.


        Optional:
        Write tests for your methods.
        Modify your compareTo method so it sorts by first name if the last names are the same.*/