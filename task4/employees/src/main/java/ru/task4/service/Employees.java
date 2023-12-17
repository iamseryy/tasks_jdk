package ru.task4.service;

import ru.task4.model.Employee;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Employees implements EmployeeService {
    private HashSet<Employee> employees;

    public Employees() {
        this.employees = new HashSet<>();
    }

    @Override
    public HashSet<Employee> findEmployeeByExperience(int experience) {
        return (HashSet<Employee>) employees.stream()
                .filter(it -> it.experience() == experience)
                .collect(Collectors.toSet());
    }

    @Override
    public List<String> findPhoneNumberByName(String name) {
        return employees.stream().filter(it -> it.name().equals(name)).map(it -> it.phoneNumber()).toList();
    }

    @Override
    public Optional<Employee> findEmployeeById(int id) {
        return employees.stream().filter(it -> it.id() == id).findAny();
    }

    @Override
    public boolean add(Employee employee) {
        return employees.add(employee);
    }

}
