package com.ird.portal.util;

import com.ird.portal.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2021/11/2 11:34<br/>
 *
 * @author Zack
 * @version 1.0
 */
public class CheckResultUtil {
    private static final Logger logger = LoggerFactory.getLogger(CheckResultUtil.class);

    public static Object setResult(Object object, String code, String msg) {
        Field result = null;
        Field resultMsg = null;
        try {
            //得到属性
            Class<?> aClass = object.getClass();
            result = aClass.getDeclaredField("result");
            resultMsg = aClass.getDeclaredField("resultMsg");
            //打开私有访问
            result.setAccessible(true);
            resultMsg.setAccessible(true);
            //获取属性值
            result.set(object, code);
            resultMsg.set(object, msg);
        } catch (NoSuchFieldException e) {
            logger.debug("[CheckResultUtil] setResult NoSuchFieldException:{}", e.getMessage());
        } catch (IllegalAccessException e) {
            logger.debug("[CheckResultUtil] setResult IllegalAccessException:{}", e.getMessage());
        }
        return object;
    }

    public static void tryCatch(Object object, Exception e, String plateNo, String vatCat, String centerCode){
        logger.debug("[CheckResultUtil] tryCatch Exception : " + e.getMessage(), e);
        String result = null;
        String resultMsg = null;
        if(e instanceof ParameterIsEmptyException){
            //F-0015=參數為空 \: {0}
            result = "F-0015";
            resultMsg = ErrorMessageHelper.getErrorMessageWithCode(result, ((ParameterIsEmptyException) e).getArguments()[0]);
        } else if(e instanceof DatabaseException) {
            //T-9001=數據庫異常
            result = "T-9001";
            resultMsg = ErrorMessageHelper.getErrorMessageWithCode(result);
        }else if(e instanceof RecordNotFoundException) {
            //F-0003=沒有找到對應的記錄\!{0}
            result = "F-0003";
            resultMsg = ErrorMessageHelper.getErrorMessageWithCode(result, ((RecordNotFoundException) e).getArguments()[0]);
        }else if(e instanceof RecordExistException) {
            //F-0013=記錄已在系統中存在\!{0}
            result = "F-0013";
            resultMsg = ErrorMessageHelper.getErrorMessageWithCode(result, ((RecordExistException) e).getArguments()[0]);
        }else if(e instanceof NotCheckInException) {
            //F-9104=該車輛尚未進行報到(車牌編號:{0})
            result = "F-9104";
            resultMsg = ErrorMessageHelper.getErrorMessageWithCode(result, plateNo);
        }else if(e instanceof BookingTimeBeforeException) {
            //F-9105=當前時間尚未到驗車中心允許的進入時間
            logger.debug(String.valueOf(((BookingTimeBeforeException) e).getArguments()[0]));
            result = "F-9105";
            resultMsg = String.valueOf(((BookingTimeBeforeException) e).getArguments()[0]);
        }else if(e instanceof NotBookingException) {
            //F-9106=當前車輛尚未預約({0})
            result = "F-9106";
            resultMsg = ErrorMessageHelper.getErrorMessageWithCode(result, plateNo);
        }else if(e instanceof AllotParkingAreaException) {
            //F-9107=分配停車區域異常\:{0}
            result = "F-9107";
            resultMsg = ErrorMessageHelper.getErrorMessageWithCode(result, ((AllotParkingAreaException) e).getArguments()[0]);
        }else if(e instanceof CenterNotCheckInException) {
            //F-9108=當前驗車中心沒有啟動報到
            result = "F-9108";
            resultMsg = ErrorMessageHelper.getErrorMessageWithCode(result);
        }else if(e instanceof NotEntryException) {
            //F-9109=當前車輛尚未進場({0})
            result = "F-9109";
            resultMsg = ErrorMessageHelper.getErrorMessageWithCode(result, plateNo);
        }else if(e instanceof BookingTypeErrorException) {
            //F-9116=預約方式異常：({0})
            result = "F-9116";
            resultMsg = ErrorMessageHelper.getErrorMessageWithCode(result, ((BookingTypeErrorException) e).getArguments()[0]);
        } else if(e instanceof NoCenterException) {
            //F-9117=找不到對應的驗車中心(驗車中心編號:{0})
            result = "F-9117";
            resultMsg = ErrorMessageHelper.getErrorMessageWithCode(result, centerCode);
        }  else if(e instanceof BookingTimeAfterException) {
            //F-9123=當前時間已超出驗車中心允許的延後時間
            logger.debug(String.valueOf(((BookingTimeAfterException) e).getArguments()[0]));
            result = "F-9123";
            resultMsg = String.valueOf(((BookingTimeAfterException) e).getArguments()[0]);
        } else if(e instanceof ProcessFinishedException) {
            //F-9125=該車輛服務已完成
            result = "F-9125";
            resultMsg = ErrorMessageHelper.getErrorMessageWithCode(result, plateNo);
        } else if(e instanceof ProcessCancelException) {
            //F-9126=該車輛服務已取消
            result = "F-9126";
            resultMsg = ErrorMessageHelper.getErrorMessageWithCode(result, plateNo);
        } else {
            //F-9115=系統異常，請聯係管理員！
            result = "F-9115";
            resultMsg = ErrorMessageHelper.getErrorMessageWithCode(result, plateNo);
        }

        setResult(object, result, resultMsg);
    }
}
