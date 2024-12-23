package org.example.callbackboot.service;

import lombok.RequiredArgsConstructor;
import org.example.callbackboot.dao.EmployeeDao;
import org.example.callbackboot.ds.Employee;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public void findAllEmployee() {
        System.out.println("find All Employee");
        //Row Mapper
        employeeDao.findAll().forEach(System.out::println);
        // Row Callback Handler
        System.out.println("Avg Salary:" + employeeDao.avgRowCallbackHandler());
        // Result Set
        System.out.println("Avg Salary : " + employeeDao.avgResultSetExtractor());
        // Native way
        System.out.println("Avg salary:" + employeeDao.avgNativeRow());
        // Model way
        System.out.println("Avg salary:" + employeeDao.avgModelWay());
        // Highest Salary
        System.out.println("Highest salary:" + employeeDao.hightestSalaryEmployee());
        // firstName and LastName (query, row<Mapper>, new Object() {...}
        System.out.println("Find By First Name And Last Name " + employeeDao.findByEmployeeFirstNameAndLastName("John", "Doe"));
        //create Employee
        System.out.println("Create Employee");
        employeeDao.createEmployee(new Employee(6, "Aung", "Myat", "aungmyat@gmail.com",
                "999-999-99", Date.valueOf("2024-03-03"), 200.2));
        System.out.println("find All Employee");
        //Row Mapper
        employeeDao.findAll().forEach(System.out::println);

        //update Employee aungmyatEmail to aungkaungmyat@gmail.com
        System.out.println("Update Employee");
        employeeDao.updateEmployeeEmail(6, "aungkaungmyat@gmail.com");

        //find By Id
        System.out.println("Find By Id");
        System.out.println("Aung Myat'email is now " + employeeDao.findById(6) );

        //delete by ID
        employeeDao.deleteEmployee(3);
        System.out.println("delete All Employee");
        employeeDao.findAll().forEach(System.out::println);

        // find by email V2
        System.out.println("Find By Email V2");
        System.out.println("Aung Myat'email is now " + employeeDao.findByEmailV2("aungkaungmyat@gmail.com") );

    }
}
