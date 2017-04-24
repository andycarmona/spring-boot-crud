package main.Repositories;

import main.Model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Created by andywaz on 2017-04-09.
 */
public interface TodoRepository extends CrudRepository<Todo, Long> {

    List<Todo> findByTitle(String title);
}
