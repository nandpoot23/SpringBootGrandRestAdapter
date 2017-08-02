package com.example.spring.boot.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.spring.boot.rest.Extractor.EmpConfigResultSetExtractor;
import com.example.spring.boot.rest.connector.DmDatabaseConnector;
import com.example.spring.boot.rest.exception.ErrorCode;
import com.example.spring.boot.rest.exception.FrameworkError;
import com.example.spring.boot.rest.types.EmpAddress;
import com.example.spring.boot.rest.types.EmpAppVO;
import com.example.spring.boot.rest.types.EmpConfigIdentifier;
import com.example.spring.boot.rest.types.EmpDetails;

/**
 * @author mlahariya
 * @version 1.0, Nov 2016
 */

@Repository("MathsDbServiceImpl")
public class MathsDbServiceImpl implements MathsDbService {

    private static final Logger LOG = LoggerFactory.getLogger(MathsDbServiceImpl.class);

    @Autowired
    private DmDatabaseConnector dmDatabaseConnector;

    public DmDatabaseConnector getDmDatabaseConnector() {
        return dmDatabaseConnector;
    }

    public void setDmDatabaseConnector(DmDatabaseConnector dmDatabaseConnector) {
        this.dmDatabaseConnector = dmDatabaseConnector;
    }

    public EmpDetails queryEmpConfigs(EmpConfigIdentifier id) {

        List<EmpDetails> configList = new ArrayList<EmpDetails>();
        List<Integer> args = new ArrayList<Integer>();
        args.add(id.getId());

        String query = "select * from employee where id = ?";

        try {
            configList = dmDatabaseConnector.getJdbcTemplate().query(query, args.toArray(),
                    new EmpConfigResultSetExtractor());
            LOG.debug(" Query for queryEmpConfigs : " + query);
        } catch (Exception e) {
            LOG.error("Exception while getting emp configurations  ", e);
        }
        if (org.apache.commons.collections.CollectionUtils.isEmpty(configList)) {
            throw new FrameworkError(ErrorCode.CS_1001.getValue());
        }

        if (!configList.isEmpty()) {

            return configList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<EmpDetails> selectAllEmpAllData(EmpAddress empAddr) {

        List<EmpDetails> configList = new ArrayList<EmpDetails>();
        List<String> args = new ArrayList<String>();
        args.add(empAddr.getAddress());

        String query = "select * from employee where address = ?";

        try {
            configList = dmDatabaseConnector.getJdbcTemplate().query(query, args.toArray(),
                    new EmpConfigResultSetExtractor());
            LOG.debug(" Query for selectAllEmpAllData : " + query);
        } catch (Exception e) {
            LOG.error("Exception while getting emp configurations  ", e);
        }

        if (org.apache.commons.collections.CollectionUtils.isEmpty(configList)) {
            throw new FrameworkError(ErrorCode.CS_1002.getValue());
        }

        if (!configList.isEmpty()) {

            return configList;
        } else {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.example.spring.boot.rest.dao.MathsDbService#insertNewEmpConfig(com
     * .example.spring.boot.rest.types.EmpAppVO)
     * 
     * Since mobile no is int type in db, that's why it is allowing us to store
     * only 9 digits as string. To overcome this take varchar or long in db,
     * then take string in your program to access it.
     */

    @Override
    public int insertNewEmpConfig(EmpAppVO empAppVO) {

        String query = "insert into employee(firstname, lastname, address, city, email, mobile) values(?,?,?,?,?,?)";
        Object[] args = new Object[] { empAppVO.getFirstName(), empAppVO.getLastName(), empAppVO.getAddress(),
                empAppVO.getCity(), empAppVO.getEmail(), empAppVO.getMobile() };
        try {
            int rowAdded = dmDatabaseConnector.getJdbcTemplate().update(query, args);
            if (rowAdded > 0) {
                LOG.debug(" Query for insertNewEmpConfig : Employee inserted" + query);
                return rowAdded;
            }
        } catch (DataAccessException e) {
            System.out.println(e);
            throw new FrameworkError(ErrorCode.CS_1003.getValue());
        }
        throw new FrameworkError(ErrorCode.CS_1006.getValue());

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.example.spring.boot.rest.dao.MathsDbService#modifyEmpConfigDetails
     * (com.example.spring.boot.rest.types.EmpAppVO)
     * 
     * Since in our db we have put the unique constraint on email column, so if
     * we update this then we need to give the different value, if given same
     * value then exception will be rise.
     */

    @Override
    public int modifyEmpConfigDetails(EmpAppVO empAppVO) {

        // TODO : need to check for unique constraints
        String query = "update employee set firstname=?, email=?, mobile=? where id=?";
        Object[] args = new Object[] { empAppVO.getFirstName(), empAppVO.getEmail(), empAppVO.getMobile(),
                empAppVO.getId() };

        try {
            int rowUpdated = dmDatabaseConnector.getJdbcTemplate().update(query, args);
            if (rowUpdated > 0) {
                LOG.debug(" Query for modifyNewEmpConfig : Employee updated" + query);
                return rowUpdated;
            }
        } catch (DataAccessException e) {
            System.out.println(e);
            throw new FrameworkError(ErrorCode.CS_1004.getValue());
        }

        throw new FrameworkError(ErrorCode.CS_1006.getValue());

    }

    @Override
    public int deleteEmpConfigDetails(EmpConfigIdentifier id) {

        String query = "delete from employee where id=?";

        try {
            int rowDeleted = dmDatabaseConnector.getJdbcTemplate().update(query, id.getId());
            if (rowDeleted > 0) {
                LOG.debug(" Query for deleteEmpConfigDetails : Employee deleted" + query);
                return rowDeleted;
            }
        } catch (DataAccessException e) {
            System.out.println(e);
            throw new FrameworkError(ErrorCode.CS_1005.getValue());
        }
        throw new FrameworkError(ErrorCode.CS_1006.getValue());

    }

}
