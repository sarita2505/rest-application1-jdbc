package com.spring.controller;

import com.spring.model.Employee;
import com.spring.repository.EmployeeJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeJdbcRepository employeeJdbcRepository;
    @GetMapping("/employees")
    public List<Employee> getEmployeeList() {
        return employeeJdbcRepository.selectAll() ;
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
        Employee employee = new Employee();

        employee=employeeJdbcRepository.selectById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
       // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employee);
    }

    @PostMapping("/employees")
    public ResponseEntity<Boolean> addEmployee(@RequestBody Employee employee) {
        employeeJdbcRepository.insert(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Boolean> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        employeeJdbcRepository.update(id,employee.getName());
        return ResponseEntity.status(HttpStatus.OK).body(true);

    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Integer id){

        employeeJdbcRepository.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handleEmptyDataException(EmptyResultDataAccessException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no record found");
    }
}