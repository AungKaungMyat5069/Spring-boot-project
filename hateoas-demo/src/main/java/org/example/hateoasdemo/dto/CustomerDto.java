package org.example.hateoasdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hateoasdemo.entity.Address;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Integer id;
    private String name;
    private String phone;
    private String email;
    private Address address;

}
