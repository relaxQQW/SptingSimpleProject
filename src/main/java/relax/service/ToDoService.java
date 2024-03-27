package relax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relax.entity.ToDoEntity;
import relax.entity.UserEntity;
import relax.model.ToDo;
import relax.repository.ToDoRepo;
import relax.repository.UserRepo;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepo toDoRepo;
    @Autowired
    private UserRepo userRepo;
    public ToDo createTodo(ToDoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return ToDo.toModel(toDoRepo.save(todo));

    }
    public ToDo completeTodo(Long userId){
ToDoEntity todo = toDoRepo.findById(userId).get();
todo.setComplited(!todo.isComplited());
return ToDo.toModel( toDoRepo.save(todo));

    }
}
