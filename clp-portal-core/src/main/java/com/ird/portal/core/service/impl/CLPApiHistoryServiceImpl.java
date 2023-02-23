package com.ird.portal.core.service.impl;

import com.ird.portal.common.api.data.APIRequestDTO;
import com.ird.portal.common.api.data.APIResponseDTO;
import com.ird.portal.common.api.data.CLPApiHistoryDTO;
import com.ird.portal.core.entity.CLPApiHistoryEntity;
import com.ird.portal.core.mapper.CLPApiHistoryMapper;
import com.ird.portal.core.service.CLPApiHistoryService;
import com.ird.portal.model.Page;
import com.ird.portal.select2.Select2Page;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import com.ird.portal.util.BeanMapper;
import com.ird.portal.util.DateUtil;
import com.ird.portal.util.JsonUtil;
import com.ird.portal.util.SysParamsConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Benny
 * @description:
 * @date 2023/1/30
 */
@Service
@Transactional
public class CLPApiHistoryServiceImpl implements CLPApiHistoryService {

    private static final Logger LOG = LoggerFactory.getLogger(CLPApiHistoryServiceImpl.class);

    @Autowired
    private CLPApiHistoryMapper clpApiHistoryMapper;

    @Autowired
    private BeanMapper beanMapper;

    @Value("${apiUrl.alertBlackoutAPICreateRequest}")
    private String alertBlackoutAPICreateRequest;

    @Value("${apiUrl.alertBlackoutAPIUpdateRequest}")
    private String alertBlackoutAPIUpdateRequest;

    @Value("${apiUrl.alertBlackoutAPIQueryRequest}")
    private String alertBlackoutAPIQueryRequest;

    @Value("${apiUrl.alertBlackoutRequestOutput}")
    private String alertBlackoutRequestOutput;

    @Value("${apiUrl.alertBlackoutAPICancelRequest}")
    private String alertBlackoutAPICancelRequest;

    @Value("${apiUrl.serviceFailureEventAPIRequest}")
    private String serviceFailureEventAPIRequest;

    @Value("${apiUrl.securityEventAPIRequest}")
    private String securityEventAPIRequest;

    @Value("${apiUrl.renewCert}")
    private String renewCert;

    @Value("${apiUrl.heartBeatAPIRequest}")
    private String heartBeatAPIRequest;

    @Resource
    private RestTemplate restTemplate;

    private static Map<String,String> apiUrlMap;

    @PostConstruct
    public void onCreate() {
        apiUrlMap = new HashMap<String,String>();
        apiUrlMap.put("alertBlackoutAPICreateRequest", alertBlackoutAPICreateRequest);
        apiUrlMap.put("alertBlackoutAPIUpdateRequest", alertBlackoutAPIUpdateRequest);
        apiUrlMap.put("alertBlackoutAPIQueryRequest", alertBlackoutAPIQueryRequest);
        apiUrlMap.put("alertBlackoutRequestOutput", alertBlackoutRequestOutput);
        apiUrlMap.put("alertBlackoutAPICancelRequest", alertBlackoutAPICancelRequest);
        apiUrlMap.put("serviceFailureEventAPIRequest", serviceFailureEventAPIRequest);
        apiUrlMap.put("securityEventAPIRequest", securityEventAPIRequest);
        apiUrlMap.put("renewCert", renewCert);
        apiUrlMap.put("heartBeatAPIRequest", heartBeatAPIRequest);
    }


    @Override
    public Page getPage(APIRequestDTO dto) {
        return clpApiHistoryMapper.getPage(dto);
    }

    @Override
    public CLPApiHistoryDTO getApiHistoryDTOById(String apiHistoryId) {
        Integer id=0;
        if (StringUtils.isNotBlank(apiHistoryId)) {
            id = Integer.parseInt(apiHistoryId);
        }
        CLPApiHistoryEntity entity = clpApiHistoryMapper.getSingle(id);
        if(entity != null) {
            return beanMapper.map(entity, CLPApiHistoryDTO.class); // 轉換為DTO返回
        }
        return new CLPApiHistoryDTO();
    }

    @Override
    public CLPApiHistoryDTO doSave(CLPApiHistoryDTO clpApiHistoryDTO) {
        if (clpApiHistoryDTO != null) {
            CLPApiHistoryEntity clpApiHistoryEntity = beanMapper.mapTo(clpApiHistoryDTO, CLPApiHistoryEntity.class);
            CLPApiHistoryEntity clpApiHistoryEntity1 =(CLPApiHistoryEntity) clpApiHistoryMapper.insert(clpApiHistoryEntity);
            return beanMapper.mapTo(clpApiHistoryEntity1, CLPApiHistoryDTO.class);
        }
        return clpApiHistoryDTO;
    }

    @Override
    public APIResponseDTO doTriggerAPI(APIRequestDTO apiRequestDTO) {
        LOG.info(apiRequestDTO.toString());
        APIResponseDTO resultDTO = new APIResponseDTO();
        String timeStampSent = DateUtil.format(new Date(), DateUtil.DATE_FORMAT_2);
        apiRequestDTO.setTimeStampSent(timeStampSent);
        if (apiRequestDTO != null && StringUtils.isNotBlank(apiRequestDTO.getApiName())) {
            String domainName = SysParamsConstant.getParamValue("API_DOMAIN_NAME");
            String url = domainName + apiUrlMap.get(apiRequestDTO.getApiName());
            CLPApiHistoryDTO clpApiHistoryDTO = new CLPApiHistoryDTO();
            clpApiHistoryDTO.setApiName(apiRequestDTO.getApiName());


            // 配置請求參數
            Map<String, String> params = new HashMap<String, String>();
            params.put("dataCentreId", apiRequestDTO.getDataCentreId());
            params.put("timeStampSent", timeStampSent);
            String jsonValue = "";
            switch (apiRequestDTO.getApiName()) {
                case "alertBlackoutAPICreateRequest":
                    // 格式化BlackoutWindowDate
                    doFormatDate(apiRequestDTO, params);
                    params.put("description", apiRequestDTO.getDescription());
                    clpApiHistoryDTO.setApiMediaType(MediaType.APPLICATION_JSON_VALUE);
                    break;
                case "alertBlackoutAPIUpdateRequest":
                    // 格式化BlackoutWindowDate
                    doFormatDate(apiRequestDTO, params);
                    params.put("description", apiRequestDTO.getDescription());
                    params.put("eventUid", apiRequestDTO.getEventUid());
                    clpApiHistoryDTO.setApiMediaType(MediaType.APPLICATION_JSON_VALUE);
                    break;
                case "alertBlackoutAPIQueryRequest":
                    clpApiHistoryDTO.setApiMediaType(MediaType.APPLICATION_JSON_VALUE);
                    break;
                case "alertBlackoutRequestOutput":
                    params.put("eventUid", apiRequestDTO.getEventUid());
                    // 格式化BlackoutWindowDate
                    doFormatDate(apiRequestDTO, params);
                    params.put("description", apiRequestDTO.getDescription());
                    clpApiHistoryDTO.setApiMediaType(MediaType.APPLICATION_JSON_VALUE);
                    break;
                case "alertBlackoutAPICancelRequest":
                    // 格式化BlackoutWindowDate
                    doFormatDate(apiRequestDTO, params);
                    params.put("cancelReason", apiRequestDTO.getCancleReason());
                    params.put("eventUid", apiRequestDTO.getEventUid());
                    clpApiHistoryDTO.setApiMediaType(MediaType.APPLICATION_JSON_VALUE);
                    break;
                case "serviceFailureEventAPIRequest":
                    params.put("severity", apiRequestDTO.getSeverity());
                    params.put("failure", apiRequestDTO.getFailure());
                    params.put("servicesAffected", apiRequestDTO.getServicesAffected());
                    // 格式化timeStampEvent
                    doFormatDate(apiRequestDTO, params);
                    clpApiHistoryDTO.setApiMediaType(MediaType.APPLICATION_JSON_VALUE);
                    break;
                case "securityEventAPIRequest":
                    params.put("eventType", apiRequestDTO.getEventType());
                    params.put("severity", apiRequestDTO.getSeverity());
                    User user = UserContext.getUser();

                    // securityAlertId should auto-generated by system. Rule: timestamp + login Id.
                    String userId ="";
                    if (user != null) {
                        userId = user.getUserId();
                    }
                    params.put("securityAlertId", apiRequestDTO.getTimeStampSent() + userId);
                    apiRequestDTO.setSecurityAlertId(apiRequestDTO.getTimeStampSent() + userId);
                    params.put("servicesAffected", apiRequestDTO.getServicesAffected());
                    // 格式化timeStampEvent
                    doFormatDate(apiRequestDTO, params);
                    clpApiHistoryDTO.setApiMediaType(MediaType.APPLICATION_JSON_VALUE);
                    break;
                case "renewCert":
                    // 存入參
                    APIRequestDTO inputParams = new APIRequestDTO();
                    beanMapper.map(apiRequestDTO, inputParams);
                    inputParams.setFileName(null);
                    inputParams.setFilePath(null);
                    inputParams.setX509CertFile(apiRequestDTO.getFileName());
                    clpApiHistoryDTO.setApiRequestParams(inputParams.getRequestInputParams());

                    params.put("x509CertFile", apiRequestDTO.getX509CertFile());
                    clpApiHistoryDTO.setApiMediaType(MediaType.MULTIPART_FORM_DATA_VALUE);
                    clpApiHistoryDTO.setApiFileName(apiRequestDTO.getFileName());
                    clpApiHistoryDTO.setApiFilePath(apiRequestDTO.getFilePath());
                    break;
                case "heartBeatAPIRequest":
                    clpApiHistoryDTO.setApiMediaType(MediaType.APPLICATION_JSON_VALUE);
                    break;
                default:
                    clpApiHistoryDTO.setApiMediaType(MediaType.APPLICATION_JSON_VALUE);
                    break;
            }
            // 訪問接口
            try {
                jsonValue = restTemplate.postForObject(url, params, String.class);
                if (StringUtils.isNotBlank(jsonValue)) {
                    clpApiHistoryDTO.setApiResponseValues(jsonValue);
                    resultDTO = JsonUtil.parse(jsonValue, APIResponseDTO.class);
                    clpApiHistoryDTO.setApiResponseStatus(resultDTO.getCode());
                } else {
                    clpApiHistoryDTO.setApiResponseStatus("404");
                }
            } catch (Exception e) {
                jsonValue = StringUtils.substring(e.getMessage(), 0, 500);
                clpApiHistoryDTO.setApiResponseValues(jsonValue);
                clpApiHistoryDTO.setApiResponseStatus("404");
            }
            clpApiHistoryDTO.setApiRequestParams(apiRequestDTO.getRequestInputParams());
            // 保存歷史記錄
            doSave(clpApiHistoryDTO);
        }
        return resultDTO;
    }

    /**
     * 將系統參數值作為下拉框（用逗號當分隔符）。
     * @param keyword 查詢值
     * @param pageSize pageSize
     * @param pageNumber pageNumber
     * @return
     */
    @Override
    public Select2Page getSystemParamSelectPage(String keyword, int pageSize, int pageNumber) {
        return clpApiHistoryMapper.getSystemParamSelectPage(keyword, pageSize, pageNumber);
    }


    // 格式化BlackoutWindowDate 和 timeStampEvent
    private void doFormatDate(APIRequestDTO apiRequestDTO, Map<String, String> params) {
        if (StringUtils.isNotBlank(apiRequestDTO.getBlackoutWindowBegin())) {
            Date blackoutWindowBeginDate = DateUtil.parse(apiRequestDTO.getBlackoutWindowBegin(), DateUtil.DATE_FORMAT);
            String blackoutWindowBeginText = DateUtil.format(blackoutWindowBeginDate, DateUtil.DATE_FORMAT_2);
            params.put("blackoutWindowBegin", blackoutWindowBeginText);
            apiRequestDTO.setBlackoutWindowBegin(blackoutWindowBeginText);
        }

        if (StringUtils.isNotBlank(apiRequestDTO.getBlackoutWindowEnd())) {
            Date blackoutWindowEndDate = DateUtil.parse(apiRequestDTO.getBlackoutWindowEnd(), DateUtil.DATE_FORMAT);
            String blackoutWindowEndText = DateUtil.format(blackoutWindowEndDate, DateUtil.DATE_FORMAT_2);
            params.put("blackoutWindowEnd", blackoutWindowEndText);
            apiRequestDTO.setBlackoutWindowEnd(blackoutWindowEndText);
        }

        if (StringUtils.isNotBlank(apiRequestDTO.getTimeStampEvent())) {
            Date timeStampEventDate = DateUtil.parse(apiRequestDTO.getTimeStampEvent(), DateUtil.DATE_FORMAT);
            String timeStampEventDateText = DateUtil.format(timeStampEventDate, DateUtil.DATE_FORMAT_2);
            params.put("timeStampEvent", timeStampEventDateText);
            apiRequestDTO.setTimeStampEvent(timeStampEventDateText);
        }
    }

}
