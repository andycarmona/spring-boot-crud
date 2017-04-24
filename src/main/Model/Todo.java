package main.Model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Created by andywaz on 2017-04-09.
 */

@Entity
public class Todo {

    @Id
    @Column(name = "TODO_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long todoId;


    @Column(name = "USER_ID")
    private Long userId;

    private ZonedDateTime creationTime;


    private String title;


    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID", nullable = false, updatable = false, insertable = false, referencedColumnName = "USER_ID")
    private User user;

    protected Todo() {

    }

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public Long getId() {
        return todoId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return todoId + " - " + title + "--" + description;
    }

}
