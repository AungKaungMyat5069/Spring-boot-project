package org.example.hateoasdemo;

import lombok.RequiredArgsConstructor;
import org.example.hateoasdemo.dao.AddressDao;
import org.example.hateoasdemo.dao.CustomerDao;
import org.example.hateoasdemo.entity.Address;
import org.example.hateoasdemo.entity.Customer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class HateoasDemoApplication {

    private final CustomerDao customerDao;
    private final AddressDao addressDao;

    @Bean
    @Profile("dev")
    @Transactional
    public ApplicationRunner init() {
        return args -> {
            Customer john = new Customer("john","999-99-99", "john@example.com");
            Customer mary = new Customer("mary","999-99-91", "mary@example.com");
            Customer jack = new Customer("jack","999-99-92", "jack@example.com");
            Customer marlin = new Customer("marlin","999-99-93", "marlin@example.com");
            Customer uu = new Customer("uu","999-99-94", "uu@example.com");
            Customer akito = new Customer("akito","999-99-95", "akito@example.com");

            Address st46th = new Address("46th", "Botahtaung","Yangon" , "001");
            Address st47th = new Address("47th", "Botahtaung","Yangon" , "002");
            Address st48th = new Address("48th", "Botahtaung","Yangon" , "003");

            st47th.addCustomer(jack);
            st47th.addCustomer(john);
            st46th.addCustomer(mary);
            st48th.addCustomer(uu);
            st48th.addCustomer(akito);
            st46th.addCustomer(marlin);

            addressDao.save(st46th);
            addressDao.save(st47th);
            addressDao.save(st48th);

//            customerDao.save(john);
//            customerDao.save(marlin);
//            customerDao.save(akito);
//            customerDao.save(uu);
//            customerDao.save(mary);
//            customerDao.save(jack);


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(HateoasDemoApplication.class, args);
    }

}
