package org.example;

import org.example.info.Address;
import org.example.info.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    // explicit injection
//    @Bean
//    public Person person() {
//        Person person = new Person();
//        person.setName("Tom");
//        person.setAddress(address());
//        return person;
//
//    }
//
//    @Bean
//    public Address address() {
//        Address address = new Address();
//        address.setStreet("46th Street");
//        return address;
//    }

    //Implicit Injection
    @Bean
    public Person person(Address address) {
        Person person = new Person();
        person.setName("Tom");
        person.setAddress(address);
        return person;

    }

    @Bean
    public Address address() {
        Address address = new Address();
        address.setStreet("46th Street");
        return address;
    }
}
