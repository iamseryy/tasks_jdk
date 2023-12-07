import collection.MyList;
import collection.impl.MyArrayList;
import model.Person;

public class GenericCollectionApp {
    public static void main(String[] args) {
        MyList<Person> people = new MyArrayList<>();
        people.add(new Person("Ivan", 33, 180.5));
        people.add(new Person("Max", 44, 175.5));
        people.add(new Person("Olga", 30, 170.5));

        people.forEach(System.out::println);


        /*
            Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые,
            и false в противном случае. Массивы могут быть любого типа данных, но должны иметь одинаковую длину
            и содержать элементы одного типа.
         */
        MyList<Person> otherPeople = new MyArrayList<>();
        otherPeople.add(new Person("Ivan", 33, 180.5));
        otherPeople.add(new Person("Max", 44, 175.5));
        otherPeople.add(new Person("Olga", 31, 170.5));
        System.out.println();
        System.out.println(people);
        System.out.println(otherPeople);
        System.out.println("Is equal?: " + people.compareList(otherPeople));


    }
}
