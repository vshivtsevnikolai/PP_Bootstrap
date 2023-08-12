package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


public interface UserDao {

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    User getUserByUsername(String username);

    User getUserById(long id);
}
