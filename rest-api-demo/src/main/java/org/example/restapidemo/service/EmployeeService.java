package org.example.restapidemo.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.restapidemo.dao.EmployeeDao;
import org.example.restapidemo.dao.Employees;
import org.example.restapidemo.dto.EmployeeDto;
import org.example.restapidemo.entity.Employee;
import org.example.restapidemo.util.EntityUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public List<EmployeeDto> getAllEmployees() {
        return employeeDao.findAll().stream().map(EntityUtil::toEmployeeDto).toList();
    }

    public EmployeeDto getEmployeeById(Integer id) {
        return employeeDao.findById(id).map(EntityUtil::toEmployeeDto).orElseThrow(EntityNotFoundException::new);
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return EntityUtil.toEmployeeDto(employeeDao.save(EntityUtil.toEmployeeEntity(employeeDto)));
    }

    public EmployeeDto updateEmployee(Integer id,EmployeeDto employeeDto) {
        employeeDto.setId(id);
        return EntityUtil.toEmployeeDto(employeeDao.save(EntityUtil.toEmployeeEntity(employeeDto)));
    }

    public void deleteEmployee(Integer id) {
        if (employeeDao.existsById(id)) {
            employeeDao.deleteById(id);
        }
        else
            throw new EntityNotFoundException();
    }

    public EmployeeDto changeEmployeeEmail(Integer id, String email) {
        if (employeeDao.existsById(id)) {
            Employee employee = employeeDao.findById(id).get();
            employee.setEmail(email);

            return EntityUtil.toEmployeeDto(employee);
        }
        else
            throw new EntityNotFoundException();
    }

    public Employees findEmployeeByXml() {
        return new Employees(employeeDao.findAll());
    }
}
