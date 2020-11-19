package com.exercise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordTest {
    @Test
    public void doTest() {
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
        System.out.println(new BCryptPasswordEncoder().encode("1111"));
    }
}
