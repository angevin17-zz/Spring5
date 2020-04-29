package Angellotti.spring5webapp.bootstrap;

import Angellotti.spring5webapp.domain.Author;
import Angellotti.spring5webapp.domain.Book;
import Angellotti.spring5webapp.domain.Publisher;
import Angellotti.spring5webapp.repositories.AuthorRepository;
import Angellotti.spring5webapp.repositories.BookRepository;
import Angellotti.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");

        Publisher nerd = new Publisher("Nerd", "123 Oaklawn St.");
        Publisher vinnie = new Publisher("Vinnie", "35 N Mills");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(nerd);
        publisherRepository.save(vinnie);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());

    }
}
