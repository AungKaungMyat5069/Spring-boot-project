package org.example.onetoone;

import lombok.RequiredArgsConstructor;
import org.example.onetoone.service.CustomersService;
import org.example.onetoone.service.JPAUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class OneToOneApplication implements CommandLineRunner {

	private final CustomersService customerService;

	@Override
	public void run(String... args) throws Exception {
		customerService.create();
		JPAUtil.checkData("select * from Customer");
		JPAUtil.checkData("select * from Address");
	}

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

}
