package com.ird.portal.enums;

import java.util.Locale;

/**
 * <br/> 分配狀態ENUM
 * <br/>
 * <b>Date:</b> 2021/10/2 17:29<br/>
 *
 * @author Zack
 * @version 1.0
 */
public enum AllocationStatusEnum implements BaseEnum<String> {
    UNASSIGNED("A", "Unassigned-未分配"),
    ASSIGNED("B", "Assigned-已分配")
    ;

    private String code;
    private String text;

    AllocationStatusEnum(){

    }

    AllocationStatusEnum(String code, String text){
        this.code = code;
        this.text = text;
    }


    public String getText() {
        return text;
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getText(Locale locale) {
        return null;
    }
}
