package com.example.spring.boot.rest.exception;

/**
 * @author mlahariya
 * @version 1.0, Nov 2016
 */

public enum ErrorCode implements java.io.Serializable {

    CS_1001("CUSTOMER-1001"), 
    CS_1002("CUSTOMER-1002"), 
    CS_1003("CUSTOMER-1003"), 
    CS_1004("CUSTOMER-1004"), 
    CS_1005("CUSTOMER-1005"), 
    CS_1006("CUSTOMER-1006"); 
            
    private String property = null;

    /**
     * Enum constructor
     */
    private ErrorCode(String property) {
        this.property = property;
    }

    /**
     * Return the enumeration from the String
     *
     * @link ErrorCode
     */
    public static ErrorCode fromValue(String value) {
        return valueOf(value);

    }

    /**
     * Return the value of enumeration
     *
     * @return enumerationValue {@link String}
     */
    public String getValue() {
        return property;
    }

}
