package com.ekart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EkartApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkartApplication.class, args);
		
		System.out.println("from the master branch");
		System.out.println("added the commment");
		System.out.println("rennamed the master branch to the aman");
		System.out.println("adedd from the newBranch branch");
	}

}
