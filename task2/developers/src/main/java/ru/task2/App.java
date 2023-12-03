package ru.task2;

import ru.task2.model.*;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        var developers = Arrays.asList(new Backender("Ivan"), new Frontender("Olga"), new Fullstack("Alex"));
        ((Fullstack) developers.get(2)).backendDevelop();
        ((Fullstack) developers.get(2)).frontendDevelop();
        System.out.println();
        startFrontendDevelop(developers);

    }

    public static void startFrontendDevelop(List<Developer> developers){
        developers.stream().filter(developer -> developer instanceof Frontend).forEach(developer -> ((Frontend) developer).frontendDevelop());
    }
}
