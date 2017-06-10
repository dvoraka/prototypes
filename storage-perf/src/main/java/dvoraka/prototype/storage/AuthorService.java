package dvoraka.prototype.storage;

import org.springframework.stereotype.Component;

/**
 * Author service.
 */
@Component
public class AuthorService {

    private final AuthorRepository repository;


    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public Iterable<Author> findAll() {
        return repository.findAll();
    }
}
