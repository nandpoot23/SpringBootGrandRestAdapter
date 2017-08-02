package com.example.spring.boot.rest.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spring.boot.rest.types.EmpAppVO;

/**
 * @author mlahariya
 * @version 1.0, Nov 2016
 */

@Component
public class AddDmCustomerHandler {

    @Autowired
    private com.example.spring.boot.rest.dao.MathsDbService mathsDbService;

    public com.example.spring.boot.rest.dao.MathsDbService getMathsDbService() {
        return mathsDbService;
    }

    public void setMathsDbService(com.example.spring.boot.rest.dao.MathsDbService mathsDbService) {
        this.mathsDbService = mathsDbService;
    }

    public Boolean insertNewEmpConfig(EmpAppVO empAppVO) {

        Boolean status = false;
        if (empAppVO.getFirstName() != null) {
            int dbresponse = getMathsDbService().insertNewEmpConfig(empAppVO);
            if (dbresponse > 0) {
                return Boolean.TRUE;
            }
        }
        return status;
    }

}
