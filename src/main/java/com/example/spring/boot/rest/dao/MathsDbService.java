package com.example.spring.boot.rest.dao;

import java.util.List;

import com.example.spring.boot.rest.types.EmpAddress;
import com.example.spring.boot.rest.types.EmpAppVO;
import com.example.spring.boot.rest.types.EmpConfigIdentifier;
import com.example.spring.boot.rest.types.EmpDetails;

/**
 * @author mlahariya
 * @version 1.0, Nov 2016
 */

public interface MathsDbService {

    public EmpDetails queryEmpConfigs(EmpConfigIdentifier id);

    public List<EmpDetails> selectAllEmpAllData(EmpAddress empAddr);

    public int insertNewEmpConfig(EmpAppVO empAppVO);

    public int modifyEmpConfigDetails(EmpAppVO empAppVO);

    public int deleteEmpConfigDetails(EmpConfigIdentifier id);

}
