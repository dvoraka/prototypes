package dvoraka.prototype.storage;

import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Author repository.
 */
public interface AuthorRepository extends Neo4jRepository<Author, Long> {

    Author findByName(String name);
}
