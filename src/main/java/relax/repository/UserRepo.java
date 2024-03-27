package relax.repository;

import relax.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<UserEntity, Long> {

    UserEntity findByUserName(String userName);




}
