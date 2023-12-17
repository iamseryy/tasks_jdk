package ru.task4.service;

import ru.task4.model.Employee;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    HashSet<Employee> findEmployeeByExperience(int experience);
    List<String> findPhoneNumberByName(String name);
    Optional<Employee> findEmployeeById(int id);
    boolean add(Employee employee);
}
