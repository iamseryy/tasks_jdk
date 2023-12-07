package model;

public record Person(String name, int age, double height) {
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        var person = (Person) obj;

        return name.equals(person.name) && age == person.age && height == person.height;
    }
}
