package com.example.spring.boot.rest.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.spring.boot.rest.handler.AddDmCustomerHandler;
import com.example.spring.boot.rest.handler.ModifyDmCustomerHandler;
import com.example.spring.boot.rest.handler.SelectAllDmCustomerHandler;
import com.example.spring.boot.rest.handler.SingleSelectDmCustomerHandler;
import com.example.spring.boot.rest.handler.UpdateDmCustomerHandler;
import com.example.spring.boot.rest.types.EmpConfigIdentifier;
import com.example.spring.boot.rest.types.EmpDetails;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

@RunWith(MockitoJUnitRunner.class)
public class MyServiceImplTest {

    @InjectMocks
    private MyServiceImpl myServiceImpl;

    @Mock
    private SingleSelectDmCustomerHandler singleSelectDmCustomerHandler;

    @Mock
    private SelectAllDmCustomerHandler selectAllDmCustomerHandler;

    @Mock
    private AddDmCustomerHandler addDmCustomerHandler;

    @Mock
    private ModifyDmCustomerHandler modifyDmCustomerHandler;

    @Mock
    private UpdateDmCustomerHandler updateDmCustomerHandler;

    @Test
    public void testQueryEmpConfigs() {

        EmpConfigIdentifier id = new EmpConfigIdentifier();
        id.setId(1);
        EmpDetails valueEmp = getEmpDetails();
        Mockito.when(singleSelectDmCustomerHandler.queryEmpConfigs(id)).thenReturn(valueEmp);
        EmpDetails response = myServiceImpl.queryEmpConfigs(id);
        assertNotNull(response);
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
