package com.ird.portal.common.sys.data;

import java.util.Date;

/**
 * @author Tim
 * @version 1.0
 * @date 21/10/2021 15:29
 */
public class SpDateprofileDTO {

    /**
     * ID
     */
    private Long id;

    /**
     * 假期日期
     */
    private Date dateValue;

    /**
     * 描述
     */
    private String description;

    /**
     * 期间
     */
    private String duration;

    /**
     * 假期类型
     */
    private String datetype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDatetype() {
        return datetype;
    }

    public void setDatetype(String datetype) {
        this.datetype = datetype;
    }

    @Override
    public String toString() {
        return "SpDateprofileDTO{" +
                "id=" + id +
                ", dateValue=" + dateValue +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", datetype='" + datetype + '\'' +
                '}';
    }
}
