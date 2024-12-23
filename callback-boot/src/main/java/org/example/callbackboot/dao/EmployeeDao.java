package org.example.callbackboot.dao;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.callbackboot.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository

public class EmployeeDao {

    private  JdbcTemplate jdbcTemplate;

    public EmployeeDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employee",this::mapToEmployee);
    }


    @SneakyThrows // work like Exception, import from Lombok
    public Employee mapToEmployee(ResultSet resultSet, int rowNum) {
        return new Employee(
                resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getString("phone_number"),
                resultSet.getDate("hired_date"),
                resultSet.getDouble("salary")
        );
    }

    public double avgRowCallbackHandler() {
        CustomRowCallbackHandler customRowCallbackHandler = new CustomRowCallbackHandler();
        jdbcTemplate.query("select salary from employee",customRowCallbackHandler);
        return customRowCallbackHandler.getAvg();
    }

    public double avgResultSetExtractor() {
        return jdbcTemplate.query("select salary from employee",new CustomResultSetExtractor());
    }

    public double avgNativeRow() {
        return jdbcTemplate.queryForObject("select avg(salary) from employee",Double.class);
    }

    public double avgModelWay() {
        return jdbcTemplate.queryForList("select salary from employee",Double.class).stream().mapToDouble(Double::doubleValue).average().getAsDouble();
    }

    public Employee hightestSalaryEmployee() {
        return jdbcTemplate.queryForObject("select * from employee order by salary desc limit 1",this::mapToEmployee);
    }

    public Employee findByEmployeeFirstNameAndLastName(String firstName, String lastName) {
        return jdbcTemplate.queryForObject("select * from employee where first_name=? and last_name=?",this::mapToEmployee,new Object[]{firstName,lastName});
    }

    public Integer createEmployee(Employee employee) {
        return jdbcTemplate.update("insert into " +
                "employee(id, first_name, last_name, email, phone_number, hired_date, salary) " +
                "values (?,?,?,?,?,?,?);", employee.getId(),employee.getFirst_name(), employee.getLast_name(),
                employee.getEmail(), employee.getPhone_number(), employee.getHired_date(), employee.getSalary());
    }

    public int updateEmployeeEmail(int id, String email) {
        return jdbcTemplate.update("update employee set email=? where id=?",email,id);
    }

    public Employee findById(int id) {
        return jdbcTemplate.queryForObject("select * from employee where id=?",this::mapToEmployee, id);
    }

    public int deleteEmployee(int id) {
        return jdbcTemplate.update("delete from employee where id=?",id);
    }

    public Employee findByEmailV2(String email) {
        return jdbcTemplate.query(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        return con.prepareStatement("select * from employee where email=?");
                    }
                }, new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, email);
                    }
                }, new ResultSetExtractor<Employee>() {

                    @Override
                    public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
                        if (rs.next()) {
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
                        return null;
                    }
                }
        );
    }


    public class  CustomRowCallbackHandler implements RowCallbackHandler {

        private double sum;
        private int count;

        @Override
        public void processRow(ResultSet rs) throws SQLException {
            sum += rs.getDouble("salary");
            count++;
        }

        public double getAvg(){
            return sum/(double) count;
        }
    }

    public class CustomResultSetExtractor implements ResultSetExtractor<Double> {

        @Override
        public Double extractData(ResultSet rs) throws SQLException, DataAccessException {
            double sum = 0;
            int count = 0;
            while (rs.next()) {
                sum += rs.getDouble("salary");
                count ++;
            }

            return sum/(double) count;
        }
    }
}
