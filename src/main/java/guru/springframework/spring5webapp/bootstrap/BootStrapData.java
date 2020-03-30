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
        Author eric = new Author("Eric", "Dale");
        Book book1 = new Book("Maths for dummies", "24242029521");
        Publisher hatier = new Publisher("Hatier", "addresseHatier", "cityHatier", "zipHatier", "stateHatier");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(book1);
        publisherRepository.save(hatier);

        Author james = new Author("James", "Rogue");
        Book book2 = new Book("History for dummies", "2424131221");
        james.getBooks().add(book2);
        book2.getAuthors().add(james);
        authorRepository.save(james);
        bookRepository.save(book2);

        System.out.println("Number of books:" + bookRepository.count());
        System.out.println("Éditeurs:" + publisherRepository.findAll());
    }
}
