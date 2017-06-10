package dvoraka.prototype.storage;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Neo4j configuration.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("dvoraka.prototype.storage")
@EnableNeo4jRepositories("dvoraka.prototype.storage")
public class Config {

    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), "dvoraka.prototype.storage");
    }


    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        return new org.neo4j.ogm.config.Configuration.Builder()
                .uri("bolt://localhost")
                .credentials("user", "user")
                .build();
    }
}
