package com.example.spring.boot.rest.Extractor;

import static org.junit.Assert.assertNotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;

import com.example.spring.boot.rest.types.EmpDetails;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

@RunWith(MockitoJUnitRunner.class)
public class EmpConfigResultSetExtractorTest {

    @InjectMocks
    private EmpConfigResultSetExtractor empConfigResultSetExtractor;

    @Mock
    private ResultSet resultSet;

    @Test
    public void testExtractData() throws DataAccessException, SQLException {

        Mockito.when(resultSet.next()).thenReturn(true, false);
        Mockito.when(resultSet.getInt("ID")).thenReturn(12);
        Mockito.when(resultSet.getString("FirstName")).thenReturn("Manu");
        Mockito.when(resultSet.getString("LastName")).thenReturn("L");
        Mockito.when(resultSet.getString("Address")).thenReturn("Sec49");
        Mockito.when(resultSet.getString("City")).thenReturn("BNDA");
        Mockito.when(resultSet.getString("Email")).thenReturn("manu@yahoo.com");
        Mockito.when(resultSet.getString("Mobile")).thenReturn("1254681519");
        List<EmpDetails> response = empConfigResultSetExtractor.extractData(resultSet);
        assertNotNull(response);
    }

}
