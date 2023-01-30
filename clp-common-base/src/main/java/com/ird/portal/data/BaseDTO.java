/**
 * @Project Name: dls-common-base
 * @File Name: BaseDTO.java
 * @Date: 2017年10月31日 下午12:08:07
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.data;

import com.ird.portal.datatable.AbstractDatatableDTO;

import java.util.Date;

/**
 * Title: 公共的DTO.<br/>
 * Description: <br/>
 * Date: 2017年10月31日 下午12:08:07<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public class BaseDTO extends AbstractDatatableDTO {

    private static final long serialVersionUID = 1958450066631590714L;

    private String createUser;

    private Date createDate;
    private String lastUpdUser;

    private Date lastUpdDate;

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdUser() {
        return lastUpdUser;
    }

    public void setLastUpdUser(String lastUpdUser) {
        this.lastUpdUser = lastUpdUser;
    }

    public Date getLastUpdDate() {
        return lastUpdDate;
    }

    public void setLastUpdDate(Date lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }


}
