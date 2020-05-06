package com.spring.repository;

import com.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Repository
public class EmployeeJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insert(Employee employee)
    {
        return jdbcTemplate.update("INSERT INTO EMPLOYEES(NAME,ID) VALUES(?,?)",
        new Object[]{employee.getName(),employee.getId()});
    }
    public int update(int id,String name)
    {
        return jdbcTemplate.update("UPDATE EMPLOYEES SET NAME=? WHERE ID=?",
                new Object[]{name,id});
    }
    public List<Employee> selectAll()
    {
        return jdbcTemplate.query("SELECT * FROM EMPLOYEES",new EmployeeRowMapper());
    }
    public Employee selectById(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEES WHERE ID=?",new Object[]{id},new EmployeeRowMapper());
    }
    public void delete(int id){
        String sql="DELETE FROM EMPLOYEES WHERE ID=?";
        jdbcTemplate.update(sql,new Object[]{id});
    }
}
