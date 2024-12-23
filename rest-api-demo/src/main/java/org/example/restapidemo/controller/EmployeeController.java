package org.example.restapidemo.controller;

import lombok.RequiredArgsConstructor;
import org.example.restapidemo.dao.Employees;
import org.example.restapidemo.dto.EmployeeDto;
import org.example.restapidemo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



//Put -is the whole data update
// Patch - is variable data update

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employee-list")
    public List<EmployeeDto> listEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee")
    public EmployeeDto getEmployee(@RequestParam("id") Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/employee-create")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeDto);
    }

    @PutMapping("/employee-update/{id}")
    public EmployeeDto updateEmployee(@PathVariable("id") Integer id,@RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(id, employeeDto);
    }

    @DeleteMapping("/employee-delete")
    public ResponseEntity<Integer> deleteEmployee(Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping(value = "/change-email", consumes = MediaType.TEXT_PLAIN_VALUE)
    public EmployeeDto changeEmail(@RequestParam("id") Integer id,@RequestBody String email) {
        return employeeService.changeEmployeeEmail(id, email);
    }

    // use for this cuz spring is optimized
    @GetMapping(value = "/v2/employee-list", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<EmployeeDto> listEmployeeWithXmlOrJason() {
        return employeeService.getAllEmployees();
    }

    //use for the url need to type
    @GetMapping("/v3/employee-list/{type}")
    public ResponseEntity<Employees> listEmployeeWithJason(@PathVariable("type") String type) {

        if("json".equalsIgnoreCase(type)) {
            return ResponseEntity.status(200)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(employeeService.findEmployeeByXml());
        } else if("xml".equalsIgnoreCase(type)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_XML)
                    .body(employeeService.findEmployeeByXml());

        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
