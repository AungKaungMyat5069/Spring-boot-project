package org.example.callbackboot.service;

import lombok.RequiredArgsConstructor;
import org.example.callbackboot.dao.EmployeeClientDao;
import org.example.callbackboot.dao.EmployeeDao;
import org.example.callbackboot.ds.Employee;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientService {

    private final EmployeeClientDao employeeClientDao;

    public void doAction(){
        // All Employee
        employeeClientDao.listAllEmployee().forEach(System.out::println);
      // find By ID
        System.out.println(employeeClientDao.getEmployeeById(3));
        //first Name and Last Name
        System.out.println(employeeClientDao.getEmployeeByFirstNameAndLastName("John", "Doe"));
        //create Employee
        employeeClientDao.createEmployee(new Employee(100, "aung", "myat",
                "aungmyat@gmail.com", "9898-989", Date.valueOf("2020-06-06"), 499));
        //All Employee
        employeeClientDao.listAllEmployee().forEach(System.out::println);
    }

}
