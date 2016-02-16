import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileNotFoundException;
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

        openFile(allPeople);

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

    static void openFile(ArrayList<Person> allPeople) throws FileNotFoundException {
        File f = new File("people.csv");
        Scanner fileScanner = new Scanner(f);
        fileScanner.nextLine();
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split(",");
            Person person = new Person(Integer.parseInt(columns[0]), columns[1], columns[2], columns[3], columns[4], columns[5]);
            allPeople.add(person);
        }
    }
}
