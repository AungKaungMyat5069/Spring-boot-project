package org.example.connectiondemo.service;

import lombok.RequiredArgsConstructor;
import org.example.connectiondemo.dao.EmployeeDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public void withoutTransaction() {
        EmployeeById();
    }

    @Transactional
    public void withTransaction() {
        EmployeeById();
    }



// when you two call above transactional and below transactional
//    @Transactional  this is not working cuz aop only provide self invocation and only work in withTransaction()
    public void EmployeeById() {
        System.out.println(employeeDao.findById(1));
        System.out.println(employeeDao.findById(2));
        System.out.println(employeeDao.findById(3));
        System.out.println(employeeDao.findById(4));
    }
}
