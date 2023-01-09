
package com.ird.portal.mega.tpms.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>deleteCandidateInfo complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="deleteCandidateInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpmsDeleteParam" type="{http://service.tpms.dsat.mega.com/}TPMSDeleteParam" minOccurs="0"/&gt;
 *         &lt;element name="actionParam" type="{http://service.tpms.dsat.mega.com/}ActionParam" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteCandidateInfo", propOrder = {
    "tpmsDeleteParam",
    "actionParam"
})
public class DeleteCandidateInfo {

    protected TPMSDeleteParam tpmsDeleteParam;
    protected ActionParam actionParam;

    /**
     * \u83b7\u53d6tpmsDeleteParam\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link TPMSDeleteParam }
     *     
     */
    public TPMSDeleteParam getTpmsDeleteParam() {
        return tpmsDeleteParam;
    }

    /**
     * \u8bbe\u7f6etpmsDeleteParam\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link TPMSDeleteParam }
     *     
     */
    public void setTpmsDeleteParam(TPMSDeleteParam value) {
        this.tpmsDeleteParam = value;
    }

    /**
     * \u83b7\u53d6actionParam\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link ActionParam }
     *     
     */
    public ActionParam getActionParam() {
        return actionParam;
    }

    /**
     * \u8bbe\u7f6eactionParam\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link ActionParam }
     *     
     */
    public void setActionParam(ActionParam value) {
        this.actionParam = value;
    }

}
