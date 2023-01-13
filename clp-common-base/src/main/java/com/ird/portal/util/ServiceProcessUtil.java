package com.ird.portal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 操作相關的幫助類
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 17/08/2018 16:48:51<br/>
 * @author Crystal Zhao
 * @version 1.0
 */ 
public class ServiceProcessUtil {
    public final static Integer MAC_LIC_SERVICE_ID = 1007;
    public final static Integer LCE_SERVICE_ID = 1002;
    public final static Integer PEC_SERVICE_ID = 1017;
    public final static Integer HZMB_SERVICE_ID = 1059;
    public final static Integer ACE_SERVICE_ID = 9006;

    protected final static List<Integer> licenseServiceList = new ArrayList<Integer>(
            Arrays.asList(MAC_LIC_SERVICE_ID, LCE_SERVICE_ID, PEC_SERVICE_ID, HZMB_SERVICE_ID, ACE_SERVICE_ID));
    
    
    public static void main(String[] arg) {
        boolean included = licenseServiceList.contains(1117);
        System.out.println(included);
    }
}
