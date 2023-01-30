package com.ird.portal.api;

import com.ird.portal.common.api.data.APIRequestDTO;
import com.ird.portal.common.api.data.CLPApiHistoryDTO;
import com.ird.portal.common.api.data.UploadFileDTO;
import com.ird.portal.core.service.CLPApiHistoryService;
import com.ird.portal.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

/**
 * @author Benny
 * @description:
 * @date 2023/1/16
 */
@Controller
@RequestMapping("/triggerApi")
public class TriggerApiController {

    /**
     * 1024常量.
     */
    private static final int BYTESTREAM = 1024;

    @Autowired
    private CLPApiHistoryService clpApiHistoryService;

    @GetMapping("/alertBlackoutCreate.html")
    public String alertBlackoutCreateRequest() {
        return "triggerApi/alertBlackoutCreate";
    }

    @GetMapping("/alertBlackoutUpdate.html")
    public String alertBlackoutUpdateRequest() {
        return "triggerApi/alertBlackoutUpdate";
    }

    @GetMapping("/alertBlackoutQuery.html")
    public String alertBlackoutAPIQueryRequest() {
        return "triggerApi/alertBlackoutQuery";
    }

    @GetMapping("/alertBlackoutOutput.html")
    public String alertBlackoutRequestOutput() {
        return "triggerApi/alertBlackoutOutput";
    }

    @GetMapping("/alertBlackoutCancel.html")
    public String alertBlackoutAPICancelRequest() {
        return "triggerApi/alertBlackoutCancel";
    }

    @GetMapping("/serviceFailureEvent.html")
    public String serviceFailureEventAPIRequest() {
        return "triggerApi/serviceFailureEvent";
    }

    @GetMapping("/securityEvent.html")
    public String securityEventAPIRequest() {
        return "triggerApi/securityEvent";
    }

    @GetMapping("/renewCert.html")
    public String renewCertResponse() {
        return "triggerApi/renewCert";
    }

    @GetMapping("/heartBeat.html")
    public String heartBeatAPIRequest() {
        return "triggerApi/heartBeat";
    }

    @GetMapping("/history.html")
    public String showHistory() {
        return "triggerApi/history";
    }

    @PostMapping(path = "/uploadX509CertFile")
    @ResponseBody
    public HttpEntity<UploadFileDTO> uploadX509CertFile(HttpServletRequest request, HttpServletResponse response) throws Exception {

        /*String foreignLicenseId = request.getParameter("foreignLicenseId");*/

        request.setCharacterEncoding("UTF-8");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> fileList = multipartRequest.getFiles("uploadCer");//uploadCer為input標籤的name屬性。
        Iterator<MultipartFile> iterator = fileList.iterator();
        UploadFileDTO uploadFileDTO = new UploadFileDTO();
        while (iterator.hasNext()) {
            MultipartFile multipartFile = iterator.next();
            byte[] bytes = multipartFile.getBytes();//二進制流

            double size = (multipartFile.getSize() * 1.0) / (BYTESTREAM * 1.0);
            BigDecimal bg = new BigDecimal(size);
            BigDecimal f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP);
            uploadFileDTO.setFileBytes(bytes);
            uploadFileDTO.setFileValue(new String(bytes,"utf-8"));
            uploadFileDTO.setSize(f1);
            uploadFileDTO.setFileName(multipartFile.getName());
            System.out.println(uploadFileDTO.toString());
        }
        return new HttpEntity<UploadFileDTO>(uploadFileDTO);
    }

    /**
     *
     * 分頁查詢.
     *
     * @param dto dto對象
     * @return 返回http對象
     */
    /*@PreAuthorize("hasPermission('DLS-EXL-EXM-QUERY')")*/
    @PostMapping("/apiHistory/list")
    @ResponseBody
    public HttpEntity<Page> getApiHistoryList(@RequestBody APIRequestDTO dto) {
        Page list = clpApiHistoryService.getPage(dto);
        return new HttpEntity<Page>(list);
    }


    @GetMapping("/historyDetail.html")
    public String showHistoryDetail(@RequestParam(value = "apiHistoryId") String apiHistoryId, Model model) {
        model.addAttribute("apiHistoryId", apiHistoryId);
        return "triggerApi/historyDetail";
    }

    @GetMapping("/apiHistory/detail")
    public HttpEntity<CLPApiHistoryDTO> getApiHistorydetail(@RequestParam(value = "apiHistoryId") String apiHistoryId) {
        CLPApiHistoryDTO dto = clpApiHistoryService.getApiHistoryDTOById(apiHistoryId);
        return new HttpEntity<CLPApiHistoryDTO>(dto);
    }


}
