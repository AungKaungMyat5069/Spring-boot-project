package org.example.employeecrudbackend.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.employeecrudbackend.dao.EmployeeDao;
import org.example.employeecrudbackend.dto.EmployeeDto;
import org.example.employeecrudbackend.util.EntityUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public List<EmployeeDto> getAllEmployees() {
        return employeeDao.findAll().stream().map(EntityUtil::toDto).toList();
    }

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        return EntityUtil.toDto(employeeDao.save(EntityUtil.toEntity(employeeDto)));
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer id) {
        if (employeeDao.existsById(id)) {
            employeeDto.setId(id);
            return EntityUtil.toDto(employeeDao.save(EntityUtil.toEntity(employeeDto)));
        }
        else
            throw new EntityNotFoundException("Employee with id " + id + " not found");
    }

    public EmployeeDto findEmployeeById(Integer id) {
        return EntityUtil.toDto(employeeDao.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public void deleteEmployee(Integer id) {
       employeeDao.deleteById(id);
    }
}
