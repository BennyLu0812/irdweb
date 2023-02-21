package com.ird.portal.api;

import com.ird.portal.common.api.data.APIRequestDTO;
import com.ird.portal.common.api.data.APIResponseDTO;
import com.ird.portal.common.api.data.CLPApiHistoryDTO;
import com.ird.portal.common.api.data.UploadFileDTO;
import com.ird.portal.core.service.CLPApiHistoryService;
import com.ird.portal.exception.ErrorMessageHelper;
import com.ird.portal.exception.SysException;
import com.ird.portal.model.Page;
import com.ird.portal.select2.Select2Page;
import com.ird.portal.util.DateUtil;
import com.ird.portal.util.SysParamsConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.util.Date;
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
    public String renewCert() {
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
            uploadFileDTO.setFileName(multipartFile.getOriginalFilename());
        }
        // 保存creFile
        StringBuffer savePath = new StringBuffer();
        savePath.append(SysParamsConstant.getParamValue("CER_FILE_SAVE_PATH"));
        savePath.append("\\" + DateUtil.format(new Date(), DateUtil.DATE_PATTERN_1));
        File fileDir = new File(savePath.toString());
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        savePath.append("\\" + uploadFileDTO.getFileName().substring(0, uploadFileDTO.getFileName().lastIndexOf(".")));
        savePath.append("_" + DateUtil.format(new Date(), DateUtil.DATE_TIME_SYSTEM_PATTERN));
        savePath.append(uploadFileDTO.getFileName().substring(uploadFileDTO.getFileName().lastIndexOf(".")));
        File cerFile = new File(savePath.toString());
        if (!cerFile.exists()) {
            // 保存cerfile
            try (InputStream inputStream = new ByteArrayInputStream(uploadFileDTO.getFileBytes());
                 OutputStream outputStream = new FileOutputStream(savePath.toString())
            ) {
                byte[] bytes = new byte[1024];
                int n;
                while ( (n=inputStream.read(bytes)) != -1){
                    outputStream.write(bytes, 0, n);
                }
            } catch (Exception e) {
                throw new SysException(ErrorMessageHelper.getErrorMessageWithCode("F-0103", "IO exception in X509CertFile"));
            }
        }
        uploadFileDTO.setFilePath(savePath.toString());

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

    /**
     * 下載cer文件
     * @param apiHistoryId
     * @param response
     * @param request
     * @throws Exception
     */

    @GetMapping("/downloadFile/{apiHistoryId}")
    public void doDownloadFile(@PathVariable("apiHistoryId") String apiHistoryId, HttpServletResponse response,HttpServletRequest request) throws Exception {

        CLPApiHistoryDTO dto = clpApiHistoryService.getApiHistoryDTOById(apiHistoryId);
        if (dto != null && StringUtils.isNotBlank(dto.getApiFilePath()) && StringUtils.isNotBlank(dto.getApiFileName())) {
            // String fileName = dto.getApiFilePath().substring(dto.getApiFilePath().lastIndexOf(File.separator));
            // String name_prefix = dto.getApiFileName().substring(0, dto.getApiFileName().lastIndexOf("."));
            String fileName = dto.getApiFileName();
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/force-download");
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Content-Disposition","attachment; filename=" + fileName);
            File file = new File(dto.getApiFilePath());
            if (!file.exists()){
                throw new SysException(ErrorMessageHelper.getErrorMessageWithCode("F-0103",
                        "Failed to find file from " + dto.getApiFilePath()));
            }
            try (InputStream inputStream = new FileInputStream(file);
                 OutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
                byte[] bytes = new byte[1024];
                int n;
                while ( (n=inputStream.read(bytes)) != -1){
                    outputStream.write(bytes, 0, n);
                }
            } catch (Exception e) {
                throw new SysException(ErrorMessageHelper.getErrorMessageWithCode("F-0103", "IO exception in X509CertFile"));
            }
        } else {
            throw new SysException(ErrorMessageHelper.getErrorMessageWithCode("F-0103", "Could not find X509CertFile"));
        }
    }

    @PostMapping("/doTriggerAPI")
    @ResponseBody
    public HttpEntity<APIResponseDTO> doTriggerAPI(@RequestBody APIRequestDTO apiRequestDTO) {
        APIResponseDTO apiResponseDTO = clpApiHistoryService.doTriggerAPI(apiRequestDTO);
        return new HttpEntity<APIResponseDTO>(apiResponseDTO);
    }

    @GetMapping("/getSystemParamSelectPage")
    @ResponseBody
    public HttpEntity<Select2Page> getSystemParamSelectPage(String keyword,
        @RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
        @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {

        Select2Page page = clpApiHistoryService.getSystemParamSelectPage(keyword, pageSize, pageNumber);
        return new HttpEntity<Select2Page>(page);
    }

    /**
     * test trigger API
     * @param requestDTO requestDTO
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/testTriggerAPI", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public HttpEntity<APIResponseDTO> testTriggerAPI(@RequestBody APIRequestDTO requestDTO) throws Exception {

        APIResponseDTO result = new APIResponseDTO();
        result.setCode("200");
        result.setMessage("successfully");
        return new HttpEntity<APIResponseDTO>(result);

    }

}
