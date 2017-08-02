package com.example.spring.boot.rest.types;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

@RunWith(MockitoJUnitRunner.class)
public class EmpDetailsTest {

    @InjectMocks
    private EmpDetails empDetails;

    @Test
    public void testSetGet() {

        empDetails.setId(1);
        assertEquals(1, empDetails.getId());

        empDetails.setFirstName("firstName001");
        assertEquals("firstName001", empDetails.getFirstName());

        empDetails.setLastName("L001");
        assertEquals("L001", empDetails.getLastName());

        empDetails.setAddress("Sec49");
        assertEquals("Sec49", empDetails.getAddress());

        empDetails.setCity("BNDA");
        assertEquals("BNDA", empDetails.getCity());

        empDetails.setEmail("m@yahoo.com");
        assertEquals("m@yahoo.com", empDetails.getEmail());

        empDetails.setMobile("4653826989");
        assertEquals("4653826989", empDetails.getMobile());
    }

}
