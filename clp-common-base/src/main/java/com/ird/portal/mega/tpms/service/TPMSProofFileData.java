
package com.ird.portal.mega.tpms.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TPMSProofFileData complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="TPMSProofFileData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="existedFileNo" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="proofFileList" type="{http://service.tpms.dsat.mega.com/}TPMSProofFile" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usedFileNo" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPMSProofFileData", propOrder = {
    "existedFileNo",
    "proofFileList",
    "usedFileNo"
})
public class TPMSProofFileData {

    protected boolean existedFileNo;
    @XmlElement(nillable = true)
    protected List<TPMSProofFile> proofFileList;
    protected boolean usedFileNo;

    /**
     * \u83b7\u53d6existedFileNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isExistedFileNo() {
        return existedFileNo;
    }

    /**
     * \u8bbe\u7f6eexistedFileNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setExistedFileNo(boolean value) {
        this.existedFileNo = value;
    }

    /**
     * Gets the value of the proofFileList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proofFileList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProofFileList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TPMSProofFile }
     * 
     * 
     */
    public List<TPMSProofFile> getProofFileList() {
        if (proofFileList == null) {
            proofFileList = new ArrayList<TPMSProofFile>();
        }
        return this.proofFileList;
    }

    /**
     * \u83b7\u53d6usedFileNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isUsedFileNo() {
        return usedFileNo;
    }

    /**
     * \u8bbe\u7f6eusedFileNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setUsedFileNo(boolean value) {
        this.usedFileNo = value;
    }

}
