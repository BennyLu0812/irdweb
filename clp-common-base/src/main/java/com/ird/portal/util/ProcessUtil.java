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
public class ProcessUtil {
    public final static Integer MAC_LIC_EXCHANGE_SERVICE_ID = 1001;
    public final static Integer MAC_LIC_SERVICE_ID = 1007;
    public final static Integer MAC_LIC_OLD_SERVICE_ID = 1008;
    public final static Integer MAC_LIC_CERT_SERVICE_ID = 1013;
    public final static Integer LCE_SERVICE_ID = 1002;
    public final static Integer PEC_SERVICE_ID = 1016;
    public final static Integer HZMB_SERVICE_ID = 1059;
    public final static Integer AEC_SERVICE_ID = 9006;
    
    public final static Integer AEC_EXTEND_PROCESS_ID = 900601;
    public final static Integer AEC_APPLY_PROCESS_ID = 900602;
    public final static Integer LCE_APPLY_PROCESS_ID = 100201;

    public final static Integer LIC_MAC_EXTEND_PROCESS_ID = 100702;
    public final static Integer LIC_PEC_EXTEND_PROCESS_ID = 101601;
    public final static Integer LIC_AEC_EXTEND_PROCESS_ID = 100202;
    public final static Integer LIC_HZMB_EXTEND_PROCESS_ID = 105901;
    public final static Integer MAC_LIC_OLD_APPLY_PROCESS_ID = 100801;
    public final static Integer MAC_LIC_OLD_LOST_PROCESS_ID = 100802;
    public final static Integer MAC_LIC_DIPLOMACY_PROCESS_ID = 100725;//申請(外交人員)


    protected final static List<Integer> licenseServiceList = new ArrayList<Integer>(
            Arrays.asList(MAC_LIC_SERVICE_ID, LCE_SERVICE_ID, PEC_SERVICE_ID, HZMB_SERVICE_ID, AEC_SERVICE_ID));

    protected final static List<Integer> examServiceList = new ArrayList<Integer>(
            Arrays.asList(1006, 9003, 9017));

    protected final static List<Integer> licValidDateCalList = new ArrayList<Integer>(
            Arrays.asList(LIC_MAC_EXTEND_PROCESS_ID, LIC_PEC_EXTEND_PROCESS_ID, LIC_AEC_EXTEND_PROCESS_ID, LIC_HZMB_EXTEND_PROCESS_ID,
                MAC_LIC_OLD_APPLY_PROCESS_ID, MAC_LIC_OLD_LOST_PROCESS_ID));
    
    
    public static void main(String[] arg) {
        boolean included = licenseServiceList.contains(1117);
        System.out.println(included);
    }
}
