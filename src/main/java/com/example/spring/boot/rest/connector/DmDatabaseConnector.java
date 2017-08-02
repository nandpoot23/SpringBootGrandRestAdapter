package com.example.spring.boot.rest.connector;

import org.springframework.jdbc.core.JdbcOperations;

/**
 * @author mlahariya
 * @version 1.0, Nov 2016
 */

public class DmDatabaseConnector {

    private JdbcOperations jdbcTemplate;

    public JdbcOperations getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
