package relax.model;

import relax.entity.ToDoEntity;

public class ToDo {
    private long id;
    private String title;
    private Boolean completed;
    public static ToDo toModel(ToDoEntity entity){
        ToDo model = new ToDo();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setCompleted(entity.isComplited());
        return model;
    }

    public ToDo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
