package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void EveryBranch() {
        List<User> allUsers = new ArrayList<>();
        //Test Case 1
        User first_case_user = new User("Sebastijan", "pass", "sebastijan32@hotmail.com");
        allUsers.add(first_case_user);
        assertFalse(SILab2.function(first_case_user, allUsers));

        //Test Case 2
        User second_case_user = new User("Sebastijan", null, "sebastijan32@hotmail.com");
        allUsers.add(second_case_user);
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(second_case_user, allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //Test Case 3
        User third_case_user = new User("Sebastijan", "passwrod", "sebastijan32@hotmail.com");
        allUsers.add(third_case_user);
        assertFalse(SILab2.function(third_case_user, allUsers));

        //Test Case 4
        User fourth_case_user = new User("Sebastijan", "pass123", "sebastijan32@hotmail.com");
        allUsers.add(fourth_case_user);
        assertFalse(SILab2.function(fourth_case_user, allUsers));

        //Test Case 5
        User fifth_case_user = new User(null, "pass123", "sebastijan32@hotmail.com");
        assertFalse(SILab2.function(fifth_case_user, allUsers));
    }

    @Test
    void MultipleConditions(){
        List<User> allUsers = new ArrayList<>();

        //Test Case 1
        User null_user_test = null;
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null_user_test, allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //Test Case 2
        User null_password_user = new User("Sebastijan", null, "sebastijan32@hotmail.com");
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null_password_user, allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //Test Case 3
        User null_email_user = new User("Sebastijan", "password", null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null_email_user, allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //Test Case 4
        User user = new User("Sebastijan", "password", "sebastijan32@hotmail.com");
        assertTrue(SILab2.function(user, allUsers));
    }
}