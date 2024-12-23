package org.example.onetoone.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    @OneToOne(mappedBy = "address")
    private Customer customer;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

}
