package com.myjoshua.jelly.client;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jeremy on 7/9/2016.
 */
public class RegistrationDataTest {
    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testInvalidEmail() {
        RegistrationData data = new RegistrationData();
        data.setEmail("1234");
        data.setPassword("this is a valid password");

        Set<ConstraintViolation<RegistrationData>> violations = validator.validate(data);
        assertEquals(1, violations.size());
    }

    @Test
    public void testValidEmail() {
        RegistrationData data = new RegistrationData();
        data.setEmail("Hillary.Clinton@Homebrewed.gov");
        data.setPassword("this is a valid password");

        Set<ConstraintViolation<RegistrationData>> violations = validator.validate(data);
        assertEquals(0, violations.size());
    }

    @Test
    public void testShortPassword() {
        RegistrationData data = new RegistrationData();
        data.setEmail("Hillary.Clinton@Homebrewed.gov");
        data.setPassword("1234");

        Set<ConstraintViolation<RegistrationData>> violations = validator.validate(data);
        assertEquals(1, violations.size());
    }

    @Test
    public void testLongPassword() {
        RegistrationData data = new RegistrationData();
        data.setEmail("Hillary.Clinton@Homebrewed.gov");
        byte[] bytes = new byte[190];
        new Random().nextBytes(bytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(Byte.toString(b));
        }
        String password = sb.toString();
        assertTrue(password.length() > 120);
        data.setPassword(password);
        Set<ConstraintViolation<RegistrationData>> violations = validator.validate(data);
        assertEquals(1, violations.size());
    }
}
