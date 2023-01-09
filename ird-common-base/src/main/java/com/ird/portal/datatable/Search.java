package com.ird.portal.datatable;

/**
 * 
 * Title: <br/>
 * Description: <br/>
 * Date: 2017年10月26日 下午3:11:16<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public class Search {

    private String value;
    private boolean regex = false;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isRegex() {
        return regex;
    }

    public void setRegex(boolean regex) {
        this.regex = regex;
    }
}
