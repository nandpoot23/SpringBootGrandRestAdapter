package com.example.spring.boot.rest.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.spring.boot.rest.Extractor.EmpConfigResultSetExtractor;
import com.example.spring.boot.rest.connector.DmDatabaseConnector;
import com.example.spring.boot.rest.exception.FrameworkError;
import com.example.spring.boot.rest.types.EmpConfigIdentifier;
import com.example.spring.boot.rest.types.EmpDetails;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

@RunWith(MockitoJUnitRunner.class)
public class MathsDbServiceImplTest {

    @InjectMocks
    private MathsDbServiceImpl mathsDbServiceImpl;

    @Mock
    private DmDatabaseConnector dmDatabaseConnector;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        Mockito.when(dmDatabaseConnector.getJdbcTemplate()).thenReturn(jdbcTemplate);
        mathsDbServiceImpl.setDmDatabaseConnector(dmDatabaseConnector);
    }

    @Test
    public void testQueryEmpConfigs() {

        EmpConfigIdentifier id = new EmpConfigIdentifier();
        id.setId(1);

        List<EmpDetails> valueList = new ArrayList<EmpDetails>();
        EmpDetails valueEmp = getEmpDetails();
        valueList.add(valueEmp);

        Mockito.when(
                jdbcTemplate.query(Mockito.anyString(), Mockito.any(Object[].class),
                        Mockito.any(EmpConfigResultSetExtractor.class))).thenReturn(valueList);

        EmpDetails response = mathsDbServiceImpl.queryEmpConfigs(id);
        assertNotNull(response);
    }

    @Test
    public void testQueryEmpConfigsException() {

        EmpConfigIdentifier id = new EmpConfigIdentifier();
        id.setId(1);

        Mockito.when(
                jdbcTemplate.query(Mockito.anyString(), Mockito.any(Object[].class),
                        Mockito.any(EmpConfigResultSetExtractor.class))).thenThrow(
                new RuntimeException("Error Occured!"));

        try {
            mathsDbServiceImpl.queryEmpConfigs(id);
        } catch (FrameworkError e) {

            assertEquals("CUSTOMER-1001", e.getErrorMessage().getCode());
        }

    }

    private EmpDetails getEmpDetails() {
        EmpDetails valueEmp = new EmpDetails();
        valueEmp.setId(1);
        valueEmp.setFirstName("Manu");
        valueEmp.setLastName("L");
        valueEmp.setAddress("Sec49");
        valueEmp.setCity("Noida");
        valueEmp.setEmail("manu@yahoo.com");
        valueEmp.setMobile("358648699");
        return valueEmp;
    }

}
