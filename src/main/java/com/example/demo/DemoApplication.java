package com.example.demo;

import com.example.demo.Entities.Coche;
import com.example.demo.Repository.CocheRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		CocheRepository repository = context.getBean(CocheRepository.class);

		System.out.println("El num de coches en base de datos es: " + repository.count());

		// crear y almacenar un coche en base de datos
		Coche toyota = new Coche(null, "Prius", "Toyota",2002);
		Coche audi = new Coche(null, "Prius", "Toyota",2002);
		Coche papas = new Coche(null, "Prius", "Toyota",2002);
		repository.save(toyota);
		repository.save(audi);
		repository.save(papas);

		System.out.println("El num de coches en base de datos es: " + repository.count());

		// recuperar todos
		System.out.println(repository.findAll());
	}


}
