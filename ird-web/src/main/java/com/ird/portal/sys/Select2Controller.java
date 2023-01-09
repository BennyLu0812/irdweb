package com.ird.portal.sys;

import com.ird.portal.common.sys.data.Select2DTO;
import com.ird.portal.select2.Select2Page;
import com.ird.portal.sys.service.Select2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * sys code的下拉菜單的Controller
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 19/04/2018 14:36:23<br/>
 * @author Jim
 * @version 1.0
 */
@Controller
@RequestMapping("/select2")
public class Select2Controller {
    
    @Autowired
    private Select2Service select2Service;
    
    
    @GetMapping("/data")
    public HttpEntity<List<Select2DTO>> select2Data(String codeType, String queryString) {
        List<Select2DTO> list = select2Service.selectSysCodeData(codeType, queryString);
        return new HttpEntity<List<Select2DTO>>(list);
    }
    
    @GetMapping("/data4show")
    public HttpEntity<List<Select2DTO>> data4show(String codeType, String queryString) {
        List<Select2DTO> list = select2Service.selectSysCodeData4show(codeType, queryString);
        return new HttpEntity<List<Select2DTO>>(list);
    }
    
    /**
     * 根據spNo獲取外國駕照編號下拉菜單值.
     * @param spNo
     * @param queryString
     * @return
     */
    @GetMapping("/getForeignLicNo")
    public HttpEntity<List<Select2DTO>> getForeignLicNoBySpNo(String spNo, String keyword) {
        List<Select2DTO> list = select2Service.getForeignLicNoBySpNo(spNo, keyword);
        return new HttpEntity<List<Select2DTO>>(list);
    }
    
    /**
     * 查詢licNo集.
     * @param keyword
     * @return
     */
    @GetMapping("/getLicNoList")
    public HttpEntity<Select2Page> getLicNoList(String licType, String licStatus, String keyword, int pageSize, int pageNumber) {
        Select2Page list = select2Service.getLicNoList(licType, licStatus, keyword, pageSize, pageNumber);
        return new HttpEntity<Select2Page>(list);
    }
    
    @GetMapping("/page")
    public HttpEntity<Select2Page> select2Data(@RequestParam Map<String, Object> params, int pageSize, int pageNumber) {
        Select2Page page = (Select2Page)select2Service.selectSysCodeData(params, pageSize, pageNumber);
        return new HttpEntity<Select2Page>(page);
    }
    
    //
    @GetMapping("/page/filter")
    public HttpEntity<Select2Page> select2DataFilter(@RequestParam Map<String, Object> params, int pageSize, int pageNumber) {
        Select2Page page = (Select2Page)select2Service.selectSysCodeData(params, pageSize, pageNumber);
        ArrayList<Select2DTO> tempSelect2DTO = (ArrayList<Select2DTO>)page.getData();
        String tcsValidIdentity = params.get("tcsValidIdentity").toString();
        List<Select2DTO> tempSelect2DTOAfter = tempSelect2DTO.stream().filter(s->s.getId().equals(tcsValidIdentity)).collect(Collectors.toList());
        page.setTotal(tempSelect2DTOAfter.size());
        page.setData(tempSelect2DTOAfter);
        return new HttpEntity<Select2Page>(page);
    }

    @GetMapping("/selectLocation")
    public HttpEntity<Select2Page> selectLocation(@RequestParam Map<String, Object> params, int pageSize, int pageNumber) {
        Select2Page page = (Select2Page)select2Service.selectLocation(params, pageSize, pageNumber);
        return new HttpEntity<Select2Page>(page);
    }
    
    @GetMapping("/selectStreet")
    public HttpEntity<Select2Page> selectStreet(@RequestParam Map<String, Object> params, int pageSize, int pageNumber) {
        Select2Page page = (Select2Page)select2Service.selectStreet(params, pageSize, pageNumber);
        return new HttpEntity<Select2Page>(page);
    }
    
    @GetMapping("/selectBuilding")
    public HttpEntity<Select2Page> selectBuilding(@RequestParam Map<String, Object> params, int pageSize, int pageNumber) {
        Select2Page page = (Select2Page)select2Service.selectBuilding(params, pageSize, pageNumber);
        return new HttpEntity<Select2Page>(page);
    }

    @GetMapping("/selectForeignLicType")
    public HttpEntity<Select2Page> selectForeignLicType(@RequestParam Map<String, Object> params, int pageSize, int pageNumber) {
        Select2Page page = (Select2Page)select2Service.selectForeignLicType(params, pageSize, pageNumber);
        return new HttpEntity<Select2Page>(page);
    }
}
