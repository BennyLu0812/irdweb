package com.ird.portal.util;

import java.util.regex.Pattern;

/**
 *
 * Title: SPUtil <br>
 * Description:  SP系統相關的幫助類 <br>
 *
 * @author: Crystal Zhao
 * @version 1.0
 * @CreateTime: 2017年10月24日 下午12:29:44
 */
public class SPUtil {
    private static final String sp_seq_pattern = "\\d{9}";

    /**
     * 判斷是否僅輸入了查詢編號的流水號部分；若是，則自動添加"SP001-"
     * @param spNo
     * @return
     */
    public static String correctSPNoPattern(String spNo){
        if(Pattern.matches(sp_seq_pattern, spNo))
            spNo = "SP001-" + spNo;

        return spNo;
    }


    public static boolean isSPNoSEQ(String spNo){
        return  spNo != null && Pattern.matches(sp_seq_pattern, spNo);
    }
    
    /**
     * 根據SPNO，獲取CASENO
     */
    public static String getCaseNo(String spNo) {
    	String caseNo = spNo.substring(spNo.indexOf("-") + 1);
    	return caseNo;
    }
}
