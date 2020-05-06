package com.spring;

import com.spring.model.Employee;
import com.spring.repository.EmployeeJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class RestApplication1JdbcApplication implements CommandLineRunner {

    @Autowired
    private EmployeeJdbcRepository employeeJdbcRepository;


    public static void main(String[] args) {
        SpringApplication.run(RestApplication1JdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee e = new Employee();
        e.setName("name1");
        e.setId(10);
        //employeeJdbcRepository.insert(e);
        //employeeJdbcRepository.insert(new Employee("name2", 2));
       // employeeJdbcRepository.insert(new Employee("name3", 3));
       employeeJdbcRepository.update(3,"hari");
        //System.out.println(employeeJdbcRepository.selectAll());;
        //employeeJdbcRepository.delete(2);
        //System.out.println( employeeJdbcRepository.selectById(3));
    }
}
