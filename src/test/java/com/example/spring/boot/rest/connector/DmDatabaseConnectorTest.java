package com.example.spring.boot.rest.connector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcOperations;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

@RunWith(MockitoJUnitRunner.class)
public class DmDatabaseConnectorTest {

    @InjectMocks
    private DmDatabaseConnector dmDatabaseConnector;

    @Mock
    private JdbcOperations jdbcTemplate;

    @Test
    public void testSetJdbcTemplate() {
        dmDatabaseConnector.setJdbcTemplate(jdbcTemplate);
    }

    @Test
    public void testGetJdbcTemplate() {

        JdbcOperations jdbcTemplate = dmDatabaseConnector.getJdbcTemplate();
        assertNotNull(jdbcTemplate);
    }

    @Test
    public void testJdbcOperations() {
        dmDatabaseConnector.setJdbcTemplate(jdbcTemplate);
        assertEquals(jdbcTemplate, dmDatabaseConnector.getJdbcTemplate());
    }

}
