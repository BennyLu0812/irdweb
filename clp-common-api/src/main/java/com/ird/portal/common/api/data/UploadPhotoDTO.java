package com.ird.portal.common.api.data;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2021/11/8 18:26<br/>
 *
 * @author Zack
 * @version 1.0
 */
public class UploadPhotoDTO {

    private Integer checkInId;

    private String photo;

    public Integer getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(Integer checkInId) {
        this.checkInId = checkInId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "UploadPhotoDTO{" +
                "checkInId=" + checkInId +
                ", photo='" + photo + '\'' +
                '}';
    }
}
