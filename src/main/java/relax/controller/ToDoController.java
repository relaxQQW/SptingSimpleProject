package relax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import relax.entity.ToDoEntity;
import relax.service.ToDoService;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;
    @PostMapping("/{id}")
    public ResponseEntity createtoDo(@RequestBody ToDoEntity todo,
                                     @PathVariable("id") Long userId){
        try {
            return ResponseEntity.ok(toDoService.createTodo(todo,userId));

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Fail");

        }
    }
    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long userId){
        try {
            return ResponseEntity.ok(toDoService.completeTodo(userId));

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Fail");

        }
    }

}
