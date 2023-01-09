package com.ird.portal.exception;

/**
 * 
 * Title: 操作SQL异常.<br/>
 * Description: <br/>
 * Date: 2017年8月30日 下午4:01:24<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public class DatabaseException extends BaseException {

    /** 
     *
     */
    private static final long serialVersionUID = 8744656119764792049L;
    /**
     * 操作数据库错误代码.
     */
    public static final String ERROR_DATABASE 			= "T-9001";
    public static final String ERROR_INSERT 			= "T-9005";
    public static final String ERROR_UPDATE 			= "T-9006";
    public static final String ERROR_DELETE 			= "T-9007";
    public static final String ERROR_GET_SINGLE 		= "T-9008";
    public static final String ERROR_GET_LIST 			= "T-9009";
    public static final String ERROR_EXECUTE 			= "T-9010";
    public static final String ERROR_FLUSH 				= "T-9011";
    public static final String ERROR_UNKOWN_QUERY_TYPE	= "T-9012";

    public DatabaseException() {
        super();
    }

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Exception cause) {
        super(message, cause);
    }

    @Override
    public String getErrorCode() {
        return ERROR_DATABASE;
    }
}
