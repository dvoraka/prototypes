package dvoraka.prototype.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Main app.
 */
@SpringBootApplication
public class App {

    private final AuthorService service;


    @Autowired
    public App(AuthorService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {

            System.out.println("App");

            service.save(new Author());

            for (Author author : service.findAll()) {
                System.out.println(author);
            }
        };
    }
}
