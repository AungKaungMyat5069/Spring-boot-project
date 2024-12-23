package org.example.zoodb;

import lombok.RequiredArgsConstructor;
import org.example.zoodb.service.ZooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ZooDbApplication implements CommandLineRunner {

    private final ZooService zooService;

    @Override
    public void run(String... args) throws Exception {
        zooService.creation();
        JPAUtil.checkData("select * from category");
        JPAUtil.checkData("select * from animal");
        JPAUtil.checkData("select * from cage");
        JPAUtil.checkData("select * from food_item");
        JPAUtil.checkData("select * from supplier");
        JPAUtil.checkData("select * from animal_food_items");
    }

    public static void main(String[] args) {
        SpringApplication.run(ZooDbApplication.class, args);
    }

}
