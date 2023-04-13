package springexamples.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springexamples.database.entity.User;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Query("From User u where u.id = :id")
    User findById(Integer id);

}
