package com.teksystems.database.dao;

import org.junit.jupiter.api.Assertions;

import com.teksystems.database.entity.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void findUserByEmail(){
        userDAO.getAllUsers();
    }

    @Test
    public void findById(){
        User u = userDAO.findById(7);
        Assertions.assertEquals(u.getFirstName(), "Jonah");
        Assertions.assertEquals(u.getLastName(), "Saywonson");
        Assertions.assertEquals(u.getEmail(), "JonahSaywonson@Temple.edu");
    }
}
