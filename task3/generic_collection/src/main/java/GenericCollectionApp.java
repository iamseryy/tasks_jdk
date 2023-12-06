import collection.MyList;
import collection.impl.MyArrayList;
import model.Person;

import java.util.ArrayList;

public class GenericCollectionApp {
    public static void main(String[] args) {
        MyList<Person> people = new MyArrayList<>();
        people.add(new Person("Ivan", 33, 180.5));
        people.add(new Person("Max", 44, 175.5));
        people.add(new Person("Olga", 30, 170.5));

        System.out.println(people);

        System.out.println("The youngest : " + people.max((it1, it2) -> it1.age() - it2.age()).get());

        people.forEach(System.out::println);
    }
}
