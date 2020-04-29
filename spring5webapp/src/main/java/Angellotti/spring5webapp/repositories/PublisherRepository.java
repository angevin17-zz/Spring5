package Angellotti.spring5webapp.repositories;

import Angellotti.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
