package com.example.desafiohospital;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioHospitalApplication implements CommandLineRunner {

	private final static Logger LOG = LoggerFactory.getLogger(DesafioHospitalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DesafioHospitalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
