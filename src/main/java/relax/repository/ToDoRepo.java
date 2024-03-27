package relax.repository;

import org.springframework.data.repository.CrudRepository;
import relax.entity.ToDoEntity;

public interface ToDoRepo extends CrudRepository<ToDoEntity, Long> {

}
