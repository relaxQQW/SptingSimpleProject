package relax.entity;

import jakarta.persistence.*;

@Entity
public class ToDoEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private  boolean complited;
    private String title;
    @ManyToOne
    @JoinColumn(name = "user_id")
   private UserEntity use;


    public ToDoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isComplited() {
        return complited;
    }

    public void setComplited(boolean complited) {
        this.complited = complited;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserEntity getUser() {
        return use;
    }

    public void setUser(UserEntity user) {
        this.use = user;
    }
}
