package main;

import main.Model.Todo;
import main.Model.User;
import main.Repositories.TodoRepository;
import main.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ApplicationLoader {

    private static final Logger log = LoggerFactory.getLogger(ApplicationLoader.class);

    public static void main(String[] args) {
        SpringApplication.run(ApplicationLoader.class);
    }

    @Bean
    public CommandLineRunner demo(TodoRepository repo, UserRepository userRepo) {
        return (String... args) -> {
            log.info("Initialisizing...");
            repo.save(new Todo( "Andres blog","carmona Wants to know"));
            repo.save(new Todo("John blog","Desvgraciado"));
            repo.save(new Todo("Katar blog","Erase una vez" ));
            List<Todo> allResults = (List<Todo>) repo.findAll();

            userRepo.save( new User("Andres","Strandvagen 11",allResults) );
            User aUser = userRepo.findOne( 1L );

        /*    Todo result = repo.findOne( 1L );
            List<Todo> res2 = repo.findByTitle( "Andres blog" );
            log.info("Get Todo..."+ result.toString());


            List<Todo> todo = allResults.stream()
                    .filter( s -> s.getTitle().startsWith( "K" ) )
                    .collect( Collectors.toList() );

            log.info("<<<Title starts with A"+ todo.get(0).getDescription());
            log.info("<<<Get description by title..."+ res2.get(0).getDescription());
            allResults.stream().
                    forEach(x->log.info("<<<Element" + x));*/
        };
    }

}