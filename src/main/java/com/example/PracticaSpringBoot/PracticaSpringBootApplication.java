package com.example.PracticaSpringBoot;

import com.example.PracticaSpringBoot.Entities.Books;
import com.example.PracticaSpringBoot.Respositories.BooksRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class PracticaSpringBootApplication {

	public static void main(String[] args) {

	ApplicationContext context = SpringApplication.run(PracticaSpringBootApplication.class, args);
    BooksRepository repository=context.getBean(BooksRepository.class);

		//CRUD
		Books library=new Books (null,"Metro","Author", 400, 19.99, "Historia de Artyon en la rusia post Apocaliptica", LocalDate.of(1990,12,23));
		Books library2=new Books (null,"Sniper Elite","Quien sabe xD", 200, 19.99, "Historia de Karl", LocalDate.of(1990,12,23));

		repository.save(library);
		repository.save(library2);





	}


}
