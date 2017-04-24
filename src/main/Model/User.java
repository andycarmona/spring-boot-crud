package main.Model;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

/**
 * Created by andywaz on 2017-04-22.
 */
@Entity
public class User {

    @Id
    @Column(name = "USER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String name;

    private String address;

    @OneToMany(targetEntity = Todo.class, cascade = ALL, mappedBy = "user")
    private Collection todos;

    protected User() {

    }

    public User(String name, String address, List<Todo> allResults){
        this.name=name;
        this.address = address;
        this.todos = allResults;
    }

}
