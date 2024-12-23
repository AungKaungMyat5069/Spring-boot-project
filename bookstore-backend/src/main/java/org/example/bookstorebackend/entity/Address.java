package org.example.bookstorebackend.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter

@NoArgsConstructor
public class Address {

    private String streetName;
    private String city;
    private String zipCode;

    public Address(String streetName, String city, String zipCode) {

        this.streetName = streetName;
        this.city = city;
        this.zipCode = zipCode;
    }
}
