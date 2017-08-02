package com.example.spring.boot.rest.handler;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.spring.boot.rest.dao.MathsDbService;
import com.example.spring.boot.rest.types.EmpAddress;
import com.example.spring.boot.rest.types.EmpDetails;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

@RunWith(MockitoJUnitRunner.class)
public class SelectAllDmCustomerHandlerTest {

    @InjectMocks
    private SelectAllDmCustomerHandler selectAllDmCustomerHandler;

    @Mock
    private MathsDbService mathsDbService;

    @Test
    public void testSelectAllEmpAllData() {

        EmpAddress empAddr = new EmpAddress();
        empAddr.setAddress("Sec49");
        List<EmpDetails> empDetailsList = new ArrayList<EmpDetails>();
        EmpDetails valueEmp = getEmpDetails();
        empDetailsList.add(valueEmp);
        Mockito.when(mathsDbService.selectAllEmpAllData(empAddr)).thenReturn(empDetailsList);
        List<EmpDetails> response = selectAllDmCustomerHandler.selectAllEmpAllData(empAddr);
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
