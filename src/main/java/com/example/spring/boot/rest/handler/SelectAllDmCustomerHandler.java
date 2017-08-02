package com.example.spring.boot.rest.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spring.boot.rest.dao.MathsDbService;
import com.example.spring.boot.rest.types.EmpAddress;
import com.example.spring.boot.rest.types.EmpDetails;

/**
 * @author mlahariya
 * @version 1.0, Nov 2016
 */

@Component
public class SelectAllDmCustomerHandler {

    @Autowired
    private MathsDbService mathsDbService;

    public MathsDbService getMathsDbService() {
        return mathsDbService;
    }

    public void setMathsDbService(MathsDbService mathsDbService) {
        this.mathsDbService = mathsDbService;
    }

    public List<EmpDetails> selectAllEmpAllData(EmpAddress empAddr) {

        List<EmpDetails> empDetailsList = null;

        if (empAddr.getAddress() != null) {
            empDetailsList = getMathsDbService().selectAllEmpAllData(empAddr);
        }
        return empDetailsList;
    }

}
