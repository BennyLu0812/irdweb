/**
 * @Project Name: dls-common
 * @File Name: StatusValidationException.java
 * @Date: Apr 17, 201612:12:13 PM
 * @Copyright: 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.exception;

/**
 * Title: Status Validation Exception Description: when the status is not valid to be updated to another status. Date:
 * Apr 17, 2016 12:12:13 PM
 *
 * @author: Crystal Zhao
 * @version 1.0
 * @Create Time: 12:12:13 PM
 */
public class StatusValidationException extends BaseException {
    
    private static final long serialVersionUID = 6126871746041996748L;
    
    private static final String ERROR_CODE = "F-0016";
    
    public StatusValidationException(Object... arguments) {
        super(arguments);
    }
    
    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
