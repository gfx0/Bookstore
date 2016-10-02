package fi.haagahelia.jani;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.jani.domain.Book;
import fi.haagahelia.jani.domain.BookRepository;
import fi.haagahelia.jani.domain.Category;
import fi.haagahelia.jani.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log= LoggerFactory.getLogger(BookstoreApplication.class);
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(){
		return(args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Romance"));
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Maps"));
			
			repository.save(new Book("Captain Kirk", "Love ball", 321321111, 1234, 100, crepository.findByCName("Romance").get(0)));
			repository.save(new Book("James Bone", "Papas Skotch", 123232321, 1999, 100, crepository.findByCName("Romance").get(0)));
			repository.save(new Book("Conan Crapster", "Monkey Land", 22123435, 2006, 50, crepository.findByCName("Scifi").get(0)));	
			
			log.info("fetch all students");
			for (Book book: repository.findAll()) {
				log.info(book.toString());
		};
	
		};
	}
}
