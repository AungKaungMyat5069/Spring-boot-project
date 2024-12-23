package org.example.hateoasdemo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hateoasdemo.entity.Customer;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Integer id;
    private String street;
    private String city;
    private String state;
    private String zip;

    private List<Customer> customers = new ArrayList<Customer>();
}
