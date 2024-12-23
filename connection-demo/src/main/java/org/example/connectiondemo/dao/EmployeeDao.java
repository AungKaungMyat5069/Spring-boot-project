package org.example.connectiondemo.dao;

import lombok.SneakyThrows;
import org.example.connectiondemo.ds.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public EmployeeDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }



    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employee", this::mapToEmployee);
    }

    public Employee findById(int id) {
        return jdbcTemplate.queryForObject("select * from employee where id=?", this::mapToEmployee, id);
    }

    @SneakyThrows
    public Employee mapToEmployee(ResultSet rs, int rowNum)  {
        return new Employee(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("phone_number"),
                rs.getDate("hired_date"),
                rs.getDouble("salary")
        );
    }

    public void deleteAllEmployee() {
        jdbcTemplate.update("delete from employee");
    }

    public void createEmployee(Employee employee) {
        if(employee.getId() <= 0) {
            throw new IllegalArgumentException("Employee id must be greater than 0");
        }
        jdbcTemplate.update("insert into employee(first_name, last_name, email, phone_number, hired_date, salary)" +
                " values(?, ?, ?, ?, ?, ?)", employee.getFirstName(), employee.getLastName(), employee.getEmail(),
                employee.getPhoneNumber(), employee.getHiredDate());
    }
}
