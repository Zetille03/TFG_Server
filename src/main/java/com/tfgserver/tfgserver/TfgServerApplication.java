package com.tfgserver.tfgserver;

import com.tfgserver.tfgserver.dao.ConsumidorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.tfgserver.tfgserver")
public class TfgServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TfgServerApplication.class, args);
	}


	}

