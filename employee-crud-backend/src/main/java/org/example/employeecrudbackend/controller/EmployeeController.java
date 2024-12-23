package org.example.employeecrudbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.employeecrudbackend.dto.EmployeeDto;
import org.example.employeecrudbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/all")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/all")
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable Integer id) {
        return employeeService.findEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(employeeDto, id);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteEmployee(@RequestParam Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Employee Delete");
    }
}
