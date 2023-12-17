package ru.task4;


import ru.task4.model.Employee;
import ru.task4.service.Employees;


public class EmployeesApp {
    public static void main( String[] args ) {
        var employees = new Employees();
        employees.add(new Employee(1, "111", "user1", 5));
        employees.add(new Employee(2, "222", "user2", 2));
        employees.add(new Employee(3, "333", "user3", 1));
        employees.add(new Employee(4, "444", "user4", 5));
        employees.add(new Employee(5, "555", "user5", 3));
        employees.add(new Employee(6, "666", "user4", 1));

        System.out.println(employees.findEmployeeByExperience(5));
        System.out.println(employees.findPhoneNumberByName("user4"));
        System.out.println(employees.findEmployeeById(3));
    }
}
