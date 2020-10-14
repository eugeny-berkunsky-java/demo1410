package main;

import beans.Person;
import beans.Person2;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    @SneakyThrows
    private void run() {
        Properties props = new Properties();
        props.load(new BufferedReader(new FileReader("props.txt")));
        List<Person2> people = readFromFile(props.getProperty("filename"));
        printPeople(people);
        printToJSON(people);
    }

    @SneakyThrows
    private void printToJSON(List<Person2> people) {
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(people);
        System.out.println(string);
        List<Person> personList = mapper.readValue(string, new TypeReference<>() {
        });
        personList.forEach(System.out::println);
    }

    private void printPeople(List<Person2> people) {
        System.out.println(people);
    }

    private List<Person2> readFromFile(String filename) throws IOException {
        return Files.newBufferedReader(Paths.get(filename))
                .lines()
                .map(Person2::new)
                .collect(Collectors.toList());
    }
}

