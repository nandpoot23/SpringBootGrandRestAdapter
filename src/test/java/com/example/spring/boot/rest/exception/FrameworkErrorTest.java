package com.example.spring.boot.rest.exception;

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
public class FrameworkErrorTest {

    @InjectMocks
    private FrameworkError frameworkError;

    @Test
    public void testErrorMessage() {

        Message errorMessage = new Message("SERVICE-2016");
        frameworkError.setErrorMessage(errorMessage);
        assertEquals(errorMessage, frameworkError.getErrorMessage());
    }

}
