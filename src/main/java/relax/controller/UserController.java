package relax.controller;

import relax.entity.UserEntity;
import relax.exeption.UserAlreadyExist;
import relax.exeption.UserNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import relax.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {

        try {
            userService.registration(user);

            return ResponseEntity.ok("User is register!");
        } catch (UserAlreadyExist exist) {
            return ResponseEntity.badRequest().body(exist.getMessage());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("We have problem!");
        }

    }


    @GetMapping("/{id}")

   public ResponseEntity getOneUser(@PathVariable("id")Long id) {

    try {
           return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundExeption e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("We have problem!");
        }
   }
@GetMapping("/status")
    public ResponseEntity getStatus() {

        try {
            return ResponseEntity.ok().body("Server is stable");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Server is broke");
        }
    }
    @DeleteMapping("/delete{id}")
    public ResponseEntity deleteUsers(@PathVariable("id") Long id){

        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("We have problem!");
        }
    }



}
