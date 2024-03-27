package relax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relax.entity.UserEntity;
import relax.exeption.UserAlreadyExist;
import relax.exeption.UserNotFoundExeption;
import relax.model.User;
import relax.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public UserEntity registration(UserEntity user) throws UserAlreadyExist {
        if (userRepo.findByUserName(user.getUserName()) !=null ){
            throw  new UserAlreadyExist("Invalid name");
        }
        userRepo.save(user);

        return user;
    }

    public User getOne(Long id) throws UserNotFoundExeption {
        UserEntity users = userRepo.findById(id).get();
        if (users == null){
            throw new UserNotFoundExeption("User not found");
        }
        return User.toModel(users);
    }
    public Long deleteUser(Long id){

        userRepo.deleteById(id);
        return id;

    }
}
