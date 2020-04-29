package Angellotti.spring5webapp.repositories;

import Angellotti.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
