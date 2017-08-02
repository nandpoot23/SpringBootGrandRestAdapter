package com.example.spring.boot.rest.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

@RunWith(MockitoJUnitRunner.class)
public class DataEncryptorTest {

    @InjectMocks
    private DataEncryptor dataEncryptor;

    @SuppressWarnings("static-access")
    @Test
    public void testEncode() {

        String response = dataEncryptor.encode("sedgfahjewrg");
        assertNotNull(response);

    }

}
