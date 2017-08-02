package com.example.spring.boot.rest.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.example.spring.boot.rest.service.MyServiceInterface;
import com.example.spring.boot.rest.types.EmpConfigIdentifier;
import com.example.spring.boot.rest.types.EmpDetails;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

@RunWith(MockitoJUnitRunner.class)
public class SpringBootGrandRestAdapterControllerTest {

    @InjectMocks
    private SpringBootGrandRestAdapterController myRestServiceController;

    @Mock
    private MyServiceInterface dmService;

    @Test
    public void testManu() {
        String response = myRestServiceController.hello();
        assertNotNull(response);
        assertEquals("Hello World, Welcome!", response);
    }

    @Test
    public void testGetEmpConfiguration() {

        EmpConfigIdentifier id = new EmpConfigIdentifier();
        id.setId(1);
        EmpDetails valueEmp = getEmpDetails();
        Mockito.when(dmService.queryEmpConfigs(id)).thenReturn(valueEmp);
        ResponseEntity<EmpDetails> response = myRestServiceController.getEmpConfiguration(id);
        assertNotNull("ResponseEntity<EmpDetails> is Not Null", response);
        assertEquals("200", response.getStatusCode().toString());
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
