package ru.kata.spring.boot_security.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;
import java.util.List;
import java.util.Optional;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u from User u JOIN FETCH u.roles where u.username=:username")
    Optional<User> findByUsername(@Param("username") String username);



    @Query("SELECT u FROM User u join fetch u.roles")
    List<User> findAll();
}
