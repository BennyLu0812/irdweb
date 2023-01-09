package com.ird.portal.common.api.data;


/**
 * @Description
 * @Author Aaron
 * @Date 2021/11/2 16:16
 * @Version 1.0
 */

public class RealTimeInspectorResponseDTO {


    private String inspectorCName;

    private String inspectorPName;

    private String profilePhoto;

    private String displayNo;


    public String getInspectorCName() {
        return inspectorCName;
    }

    public void setInspectorCName(String inspectorCName) {
        this.inspectorCName = inspectorCName;
    }

    public String getInspectorPName() {
        return inspectorPName;
    }

    public void setInspectorPName(String inspectorPName) {
        this.inspectorPName = inspectorPName;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getDisplayNo() {
        return displayNo;
    }

    public void setDisplayNo(String displayNo) {
        this.displayNo = displayNo;
    }
}
