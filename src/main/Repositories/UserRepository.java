package main.Repositories;

import main.Model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by andywaz on 2017-04-22.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
