package com.example.spring.boot.rest.service;

import java.util.List;

import com.example.spring.boot.rest.types.EmpAddress;
import com.example.spring.boot.rest.types.EmpAppVO;
import com.example.spring.boot.rest.types.EmpConfigIdentifier;
import com.example.spring.boot.rest.types.EmpDetails;

/**
 * @author mlahariya
 * @version 1.0, Nov 2016
 */

public abstract interface MyServiceInterface {

    public EmpDetails queryEmpConfigs(EmpConfigIdentifier id);

    public List<EmpDetails> selectAllEmpAllData(EmpAddress empAddr);

    public Boolean insertNewEmpConfig(EmpAppVO empAppVO);

    public Boolean modifyEmpConfigDetails(EmpAppVO empAppVO);

    public Boolean deleteEmpConfigDetails(EmpConfigIdentifier id);

}
