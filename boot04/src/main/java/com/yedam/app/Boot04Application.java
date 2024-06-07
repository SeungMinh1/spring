package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.yedam.app.**.mapper")
public class Boot04Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot04Application.class, args);
	}

}
