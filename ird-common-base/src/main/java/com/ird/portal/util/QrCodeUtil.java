package com.ird.portal.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2021/10/23 11:46<br/>
 *
 * @author Zack
 * @version 1.0
 */
public class QrCodeUtil {
    private static final Logger logger = LoggerFactory.getLogger(QrCodeUtil.class);

    /**
     * 构建QR Code的url
     * @param qrCodeUrl qrCode Url
     * @param plateNo 車牌編號
     * @param vehType 車輛類別
     * @param centerCode 預約中心
     * @param bookingType 預約方式
     * @param vin 車身編號
     * @return
     */
    public static String makeQrCodeUrl(String qrCodeUrl, String plateNo, String vehType, String centerCode, String bookingType, String vin, Long vehId){
        String date = DateUtil.format(new Date(), "yyyyMMdd");
        String currentData = date + "_" + vehType + "_" + plateNo + "_" + centerCode + "_" + bookingType;

        //位移加密
        currentData = encryptionQrCode(currentData, plateNo, vin);

        BASE64Encoder encoder = new BASE64Encoder();
        String qrCodeUrlStr = null;
        try {
            qrCodeUrlStr = qrCodeUrl + encoder.encode(currentData.getBytes("UTF-8")) + "&v=" + bookingType + "_" + vehId;
        } catch (UnsupportedEncodingException e) {
            logger.debug("[makeQrCodeUrl] UnsupportedEncodingException : " + e.getMessage(), e);
        }

        logger.info("[makeQrCodeUrl] qrCodeUrlStr:{}", qrCodeUrlStr);
        return qrCodeUrlStr;
    }

    public static String decryptQrCodeUrl(String qrCodeSource, String plateNo, String vin){
        BASE64Decoder decoder = new BASE64Decoder();
        String result = "";
        try{
            result = new String(decoder.decodeBuffer(qrCodeSource), "UTF-8");

            result = decryptQrCode(result, plateNo, vin);
            logger.info("[decryptQrCodeUrl] result:{}", result);
        }catch (IOException e){
            logger.debug("[decryptQrCodeUrl] UnsupportedEncodingException : " + e.getMessage(), e);
        }
        return result;
    }

    public static void main(String[] args) {
//        String source = "20211228_L_MA-50-50_CIVA_D";
//        source = encryptionQrCode(source, "M8-K53");
//
//        decryptQrCode(source, "M8-K53");

        String s = makeQrCodeUrl("", "CM-80545", "C", "CIMM", "N", "SA39J-790387", Long.valueOf(357406));
//
        decryptQrCodeUrl(s, "CM-80545","SA39J-790387");
    }

    public static String encryptionQrCode(String source, String plateNo, String vin) {
        char[] result = source.toCharArray();
        int last = getLastLetterForVin(plateNo, vin);
        int value = result.length - last;

        for(int i = 0; i < result.length; i++){
            if(i < value){
                result[i] += last;
            }else{
                result[i] -= value;
            }
        }

        logger.info("[encryptionQrCode] source:{}, result:{}", source, String.valueOf(result));
        return String.valueOf(result);
    }

    public static String decryptQrCode(String source, String plateNo, String vin){
        char[] result = source.toCharArray();
        int last = getLastLetterForVin(plateNo, vin);
        int value = result.length - last;

        for(int i = 0; i < result.length; i++){
            if(i < value){
                result[i] -= last;
            }else{
                result[i] += value;
            }
        }

        logger.info("[decryptQrCode] source:{}, result:{}", source, String.valueOf(result));
        return String.valueOf(result);
    }
    
    public static char getLastLetterForVin(String plateNo, String vin){
        char letter = 0;
        //型號認可二維碼加密，遷移位數就用型號認可編號的最後一位
        if(StringUtils.isNotBlank(plateNo) && plateNo.indexOf("/") > 0){
            logger.info("[getLastForVin] plateNo:{}", plateNo);
            String vtaNo = plateNo.split("/")[0];

            vtaNo = vtaNo.substring(vtaNo.length() - 1);

            //0就當做1
            if(StringUtils.equals(vtaNo, "0")){
                vtaNo = "1";
            }

            letter = vtaNo.charAt(0);
        }else{
            logger.info("[getLastForVin] vin:{}", vin);
            if(StringUtils.isBlank(vin)){
                return 0;
            }

            char[] chars = vin.toCharArray();
            for (int i = chars.length-1; i >=0 ; i--) {
                if ((chars[i]+"").getBytes().length==1 && ('A'<=chars[i]&&chars[i]<='Z' || 'a'<=chars[i]&&chars[i]<='z')){
                    letter = chars[i];
                    break;
                }
            }

            if(letter == 0){
                for (int i = chars.length-1; i >=0 ; i--) {
                    if ((chars[i]+"").getBytes().length==1 && '0'<=chars[i]&&chars[i]<='9'){
                        letter = chars[i];
                        break;
                    }
                }
            }
        }
        logger.info("[getLastForVin] last letter:{}", letter);
        return letter;
    }
}
