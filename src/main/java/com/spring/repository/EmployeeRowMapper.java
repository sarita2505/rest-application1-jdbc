package com.spring.repository;

import com.spring.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee emp = new Employee();
        emp.setName(resultSet.getString("name"));
        emp.setId(resultSet.getInt("id"));

        return emp;
    }
}
