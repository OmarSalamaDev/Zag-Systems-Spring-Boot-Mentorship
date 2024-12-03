package org.example.tired.FrontEndLayer.IMPL;

import org.example.tired.Employee;
import org.example.tired.EmployeeDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final JdbcTemplate jdbcTemplate;
    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setDepartment(rs.getString("department"));
            emp.setSalary(rs.getDouble("salary"));
            return emp;
        });
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary());
    }
}
