package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher hatier = new Publisher("Hatier", "addresseHatier", "cityHatier", "zipHatier", "stateHatier");
        publisherRepository.save(hatier);


        Author eric = new Author("Eric", "Dale");
        Book book1 = new Book("Maths for dummies", "24242029521");

        eric.getBooks().add(book1);
        authorRepository.save(eric);

        book1.getAuthors().add(eric);
        book1.setPublisher(hatier);
        bookRepository.save(book1);

        hatier.getBooks().add(book1);
        publisherRepository.save(hatier);

        Author james = new Author("James", "Rogue");
        Book book2 = new Book("History for dummies", "2424131221");

        james.getBooks().add(book2);
        authorRepository.save(james);

        book2.getAuthors().add(james);
        book2.setPublisher(hatier);
        bookRepository.save(book2);

        hatier.getBooks().add(book2);
        publisherRepository.save(hatier);


        System.out.println("Number of books:" + bookRepository.count());
        System.out.println("Éditeurs:" + hatier.getBooks().contains(book1));
    }
}
