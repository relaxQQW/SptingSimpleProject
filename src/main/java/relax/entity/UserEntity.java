package relax.entity;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Entity

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String pass;
    private String userName;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "use")
    private List<ToDoEntity> todos;



    public UserEntity() {
    }

    public List<ToDoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<ToDoEntity> todos) {
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
