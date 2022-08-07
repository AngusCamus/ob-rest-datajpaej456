package com.example.obrestdatajpaej456;

import com.example.obrestdatajpaej456.entities.Laptop;
import com.example.obrestdatajpaej456.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObRestDatajpaej456Application {

	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(ObRestDatajpaej456Application.class, args);

		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop lap1 = new Laptop(null, "HP", "White", 17);
		Laptop lap2 = new Laptop(null, "Acer", "Black", 15);

		repository.save(lap1);
		repository.save(lap2);
		System.out.println("Cantiad de laptops: " + repository.count());
	}

}
