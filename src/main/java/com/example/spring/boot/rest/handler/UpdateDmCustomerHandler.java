package com.example.spring.boot.rest.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spring.boot.rest.types.EmpConfigIdentifier;

/**
 * @author mlahariya
 * @version 1.0, Nov 2016
 */

@Component
public class UpdateDmCustomerHandler {

    @Autowired
    private com.example.spring.boot.rest.dao.MathsDbService mathsDbService;

    public com.example.spring.boot.rest.dao.MathsDbService getMathsDbService() {
        return mathsDbService;
    }

    public void setMathsDbService(com.example.spring.boot.rest.dao.MathsDbService mathsDbService) {
        this.mathsDbService = mathsDbService;
    }

    public Boolean deleteEmpConfigDetails(EmpConfigIdentifier empConfigId) {

        Boolean status = false;
        if (empConfigId != null) {
            int dbresponse = getMathsDbService().deleteEmpConfigDetails(empConfigId);
            if (dbresponse > 0) {
                return Boolean.TRUE;
            }
        }
        return status;
    }

}
