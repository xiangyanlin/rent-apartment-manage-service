package com.xyl.rental;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
@MapperScan("com.xyl.rental.dao")
public class RentApartmentManageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentApartmentManageServiceApplication.class, args);
    }

}
