package org.example.callbackboot.dao;

import org.example.callbackboot.ds.Employee;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeClientDao {

    private  JdbcClient jdbcClient;

    public EmployeeClientDao(DataSource dataSource) {
        jdbcClient = JdbcClient.create(dataSource);

    }

    public List<Employee> listAllEmployee() {
        return jdbcClient.sql("select * from employee").query(Employee.class).list();
    }

    // param is for single , params are for many
    public Employee getEmployeeById(int id) {
        return jdbcClient.sql("select * from employee where id = ?")
                .param(1, id).query(Employee.class).single();
    }


    public Employee getEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        return  jdbcClient.sql("select * from employee where first_name = ? and last_name = ?")
                .params(List.of(firstName, lastName)).query(Employee.class).single();
    }

    public void createEmployee(Employee employee) {
        jdbcClient.sql("insert into employee (id, first_name, last_name, email, " +
                "phone_number, hired_date, salary) " +
                "values (?, ?, ?, ?, ?, ?, ?)")
                .params(List.of(
                        employee.getId(),
                        employee.getFirst_name(),
                        employee.getLast_name(),
                        employee.getEmail(),
                        employee.getPhone_number(),
                        employee.getHired_date(),
                        employee.getSalary()
                        )
                ).update();
    }
}
