package com.example.spring.boot.rest.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spring.boot.rest.handler.AddDmCustomerHandler;
import com.example.spring.boot.rest.handler.ModifyDmCustomerHandler;
import com.example.spring.boot.rest.handler.SelectAllDmCustomerHandler;
import com.example.spring.boot.rest.handler.SingleSelectDmCustomerHandler;
import com.example.spring.boot.rest.handler.UpdateDmCustomerHandler;
import com.example.spring.boot.rest.types.EmpAddress;
import com.example.spring.boot.rest.types.EmpAppVO;
import com.example.spring.boot.rest.types.EmpConfigIdentifier;
import com.example.spring.boot.rest.types.EmpDetails;

/**
 * @author mlahariya
 * @version 1.0, Nov 2016
 */

@Component("MyServiceImpl")
public class MyServiceImpl implements MyServiceInterface {

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(MyServiceImpl.class);

    @Autowired
    private SingleSelectDmCustomerHandler singleSelectDmCustomerHandler;

    @Autowired
    private SelectAllDmCustomerHandler selectAllDmCustomerHandler;

    @Autowired
    private AddDmCustomerHandler addDmCustomerHandler;

    @Autowired
    private ModifyDmCustomerHandler modifyDmCustomerHandler;

    @Autowired
    private UpdateDmCustomerHandler updateDmCustomerHandler;

    @Override
    public EmpDetails queryEmpConfigs(EmpConfigIdentifier id) {

        if (id != null) {
            LOG.debug("MyServiceImpl::queryEmpConfigs  id : " + id.getId());
        }
        return singleSelectDmCustomerHandler.queryEmpConfigs(id);
    }

    @Override
    public List<EmpDetails> selectAllEmpAllData(EmpAddress empAddr) {

        if (empAddr.getAddress() != null) {
            LOG.debug("MyServiceImpl::selectAllEmpAllData  address of your sector : " + empAddr.getAddress());
        }
        return selectAllDmCustomerHandler.selectAllEmpAllData(empAddr);
    }

    @Override
    public Boolean insertNewEmpConfig(EmpAppVO empAppVO) {

        if (empAppVO != null) {
            LOG.debug("MyServiceImpl::insertNewEmpConfig  inserting new records : " + empAppVO);
        }
        return addDmCustomerHandler.insertNewEmpConfig(empAppVO);
    }

    @Override
    public Boolean modifyEmpConfigDetails(EmpAppVO empAppVO) {

        if (empAppVO != null) {
            LOG.debug("MyServiceImpl::modifyEmpConfigDetails  modify the records : " + empAppVO);
        }
        return modifyDmCustomerHandler.modifyEmpConfigDetails(empAppVO);
    }

    @Override
    public Boolean deleteEmpConfigDetails(EmpConfigIdentifier id) {

        if (id != null) {
            LOG.debug("MyServiceImpl::deleteEmpConfigDetails deleting the records : " + id);
        }

        return updateDmCustomerHandler.deleteEmpConfigDetails(id);
    }
}
