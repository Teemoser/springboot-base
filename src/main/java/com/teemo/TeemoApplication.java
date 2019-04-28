package com.teemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages ="com.teemo.mapper.**")
//@NacosPropertySource(dataId = "application-dev.properties", groupId = "DEFAULT_GROUP",autoRefreshed = true)
public class TeemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TeemoApplication.class, args);
	}

}
