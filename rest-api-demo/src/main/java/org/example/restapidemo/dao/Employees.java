package org.example.restapidemo.dao;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;
import org.example.restapidemo.entity.Employee;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JacksonXmlRootElement(localName = "employees")
public class Employees {

    @JacksonXmlProperty(localName = "employee")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Employee> employees = new ArrayList<Employee>();

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employees=" + employees +
                '}';
    }
}
