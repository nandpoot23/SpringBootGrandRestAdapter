package com.example.spring.boot.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.boot.rest.service.MyServiceInterface;
import com.example.spring.boot.rest.types.EmpAddress;
import com.example.spring.boot.rest.types.EmpAppVO;
import com.example.spring.boot.rest.types.EmpConfigIdentifier;
import com.example.spring.boot.rest.types.EmpDetails;

/**
 * @author mlahariya
 * @version 1.0, Nov 2016
 */

@RestController
@RequestMapping(value = "/dmCustomer/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class SpringBootGrandRestAdapterController {

    @Autowired
    @Qualifier("MyServiceImpl")
    private MyServiceInterface dmService;

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootGrandRestAdapterController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String hello() {
        System.out.println(" ****** Hello World, Welcome! ******* ");
        return "Hello World, Welcome!";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/empConfig", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EmpDetails> getEmpConfiguration(@RequestBody EmpConfigIdentifier id) {
        LOG.info("starting .........");
        EmpDetails response = dmService.queryEmpConfigs(id);
        return new ResponseEntity<EmpDetails>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/empConfigAddress", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EmpDetails>> getAllEmpByAddress(@RequestBody EmpAddress empAddr) {
        LOG.info("starting .........");
        List<EmpDetails> response = dmService.selectAllEmpAllData(empAddr);
        return new ResponseEntity<List<EmpDetails>>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/empInsertConfig", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> insertNewEmpConfig(@RequestBody EmpAppVO empAppVO) {
        LOG.info("starting .........");
        Boolean response = dmService.insertNewEmpConfig(empAppVO);
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/empUpdateConfig", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> updateNewEmpConfig(@RequestBody EmpAppVO empAppVO) {
        LOG.info("starting .........");
        Boolean response = dmService.modifyEmpConfigDetails(empAppVO);
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/empDeleteConfig", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> removeNewEmpConfig(@RequestBody EmpConfigIdentifier id) {
        LOG.info("starting .........");
        Boolean response = dmService.deleteEmpConfigDetails(id);
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }

}
