package com.teksystems;

import com.teksystems.database.dao.UserDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDAOTest {

    @Autowired
    private static UserDAO userDAO;

    @Test
    public void findUserByEmail(){

    }
}
