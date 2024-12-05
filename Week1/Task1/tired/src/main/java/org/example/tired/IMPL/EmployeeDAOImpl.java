package org.example.tired.IMPL;

import org.example.tired.Employee;
import org.example.tired.EmployeeDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of the EmployeeDAO interface using JdbcTemplate for database operations.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructor to initialize JdbcTemplate.
     *
     * @param jdbcTemplate the JdbcTemplate to be used for database operations
     */
    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Retrieves all employees from the database.
     *
     * @return a list of all employees
     */
    private final RowMapper<Employee> rowMapper = (rs, rowNum) -> new Employee(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("department"),
            rs.getDouble("salary")
    );

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, rowMapper);
    }

    /**
     * Adds a new employee to the database.
     *
     * @param employee the employee to be added
     */
    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary());
    }

    /**
     * Removes an employee from the database by their ID.
     *
     * @param id the ID of the employee to be removed
     */
    @Override
    public void removeEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET name = ?, department = ? , salary = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary() , employee.getId());
    }
}