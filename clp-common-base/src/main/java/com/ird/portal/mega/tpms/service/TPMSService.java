package com.ird.portal.mega.tpms.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.16
 * 2021-02-25T09:49:25.753+08:00
 * Generated source version: 3.0.16
 * 
 */
@WebService(targetNamespace = "http://service.tpms.dsat.mega.com/", name = "TPMSService")
@XmlSeeAlso({ObjectFactory.class})
public interface TPMSService {

    @WebMethod
    @RequestWrapper(localName = "queryDocId", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "QueryDocId")
    @ResponseWrapper(localName = "queryDocIdResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "QueryDocIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public Long queryDocId(
            @WebParam(name = "taxiCertNo", targetNamespace = "")
                    Long taxiCertNo,
            @WebParam(name = "actionParam", targetNamespace = "")
                    ActionParam actionParam
    );

    @WebMethod
    @RequestWrapper(localName = "getTPMSSendDate", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSSendDate")
    @ResponseWrapper(localName = "getTPMSSendDateResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSSendDateResponse")
    @WebResult(name = "return", targetNamespace = "")
    public TPMSSendDate getTPMSSendDate(
            @WebParam(name = "taxiProCertNo", targetNamespace = "")
                    Long taxiProCertNo,
            @WebParam(name = "docId", targetNamespace = "")
                    Long docId
    );

    @WebMethod
    @RequestWrapper(localName = "reprintTaxiProCert", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "ReprintTaxiProCert")
    @ResponseWrapper(localName = "reprintTaxiProCertResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "ReprintTaxiProCertResponse")
    public void reprintTaxiProCert(
            @WebParam(name = "reprintTaxiProCertDto", targetNamespace = "")
                    ReprintTaxiProCertDto reprintTaxiProCertDto,
            @WebParam(name = "actionParam", targetNamespace = "")
                    ActionParam actionParam
    );

    @WebMethod
    @RequestWrapper(localName = "checkProofInfo", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "CheckProofInfo")
    @ResponseWrapper(localName = "checkProofInfoResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "CheckProofInfoResponse")
    @WebResult(name = "return", targetNamespace = "")
    public TPMSProofFileData checkProofInfo(
            @WebParam(name = "tpmsProofFile", targetNamespace = "")
                    TPMSProofFile tpmsProofFile
    );

    @WebMethod
    @RequestWrapper(localName = "updateTPMSCustomer", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "UpdateTPMSCustomer")
    @ResponseWrapper(localName = "updateTPMSCustomerResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "UpdateTPMSCustomerResponse")
    public void updateTPMSCustomer(
            @WebParam(name = "customer", targetNamespace = "")
                    TPMSCustomer customer,
            @WebParam(name = "actionParam", targetNamespace = "")
                    ActionParam actionParam
    );

    @WebMethod
    @RequestWrapper(localName = "renewTaxiProCert", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "RenewTaxiProCert")
    @ResponseWrapper(localName = "renewTaxiProCertResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "RenewTaxiProCertResponse")
    public void renewTaxiProCert(
            @WebParam(name = "tpmsProCertReq", targetNamespace = "")
                    TPMSProCertReq tpmsProCertReq,
            @WebParam(name = "modifiedCodes", targetNamespace = "")
                    java.util.List<String> modifiedCodes,
            @WebParam(name = "actionParam", targetNamespace = "")
                    ActionParam actionParam
    );

    @WebMethod
    @RequestWrapper(localName = "getTPMSDataFine", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSDataFine")
    @ResponseWrapper(localName = "getTPMSDataFineResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSDataFineResponse")
    @WebResult(name = "return", targetNamespace = "")
    public TPMSData getTPMSDataFine(
            @WebParam(name = "docId", targetNamespace = "")
                    Long docId,
            @WebParam(name = "actionParam", targetNamespace = "")
                    ActionParam actionParam,
            @WebParam(name = "taxiCertNo", targetNamespace = "")
                    String taxiCertNo
    );

    @WebMethod
    @RequestWrapper(localName = "issueTPMSProCert", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "IssueTPMSProCert")
    @ResponseWrapper(localName = "issueTPMSProCertResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "IssueTPMSProCertResponse")
    @WebResult(name = "return", targetNamespace = "")
    public TPMSProCert issueTPMSProCert(
            @WebParam(name = "customer", targetNamespace = "")
                    TPMSCustomer customer,
            @WebParam(name = "actionParam", targetNamespace = "")
                    ActionParam actionParam
    );

    @WebMethod
    @RequestWrapper(localName = "getTaxiProCertPrintNo", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTaxiProCertPrintNo")
    @ResponseWrapper(localName = "getTaxiProCertPrintNoResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTaxiProCertPrintNoResponse")
    @WebResult(name = "return", targetNamespace = "")
    public String getTaxiProCertPrintNo(
            @WebParam(name = "taxiProCertNo", targetNamespace = "")
                    Long taxiProCertNo,
            @WebParam(name = "modifiedCodes", targetNamespace = "")
                    java.util.List<String> modifiedCodes,
            @WebParam(name = "actionParam", targetNamespace = "")
                    ActionParam actionParam,
            @WebParam(name = "spTxnno", targetNamespace = "")
                    String spTxnno
    );

    @WebMethod
    @RequestWrapper(localName = "backendCompleteIssue", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "BackendCompleteIssue")
    @ResponseWrapper(localName = "backendCompleteIssueResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "BackendCompleteIssueResponse")
    @WebResult(name = "return", targetNamespace = "")
    public String backendCompleteIssue(
            @WebParam(name = "tpmsProCertReq", targetNamespace = "")
                    TPMSProCertReq tpmsProCertReq,
            @WebParam(name = "actionParam", targetNamespace = "")
                    ActionParam actionParam
    );

    @WebMethod
    @RequestWrapper(localName = "isExistTaxiCert", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "IsExistTaxiCert")
    @ResponseWrapper(localName = "isExistTaxiCertResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "IsExistTaxiCertResponse")
    @WebResult(name = "return", targetNamespace = "")
    public TPMSCertExistsResult isExistTaxiCert(
            @WebParam(name = "docId", targetNamespace = "")
                    Long docId
    );

    @WebMethod
    @RequestWrapper(localName = "tpmsAction", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "TpmsAction")
    @ResponseWrapper(localName = "tpmsActionResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "TpmsActionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public String tpmsAction(
            @WebParam(name = "action", targetNamespace = "")
                    String action,
            @WebParam(name = "param", targetNamespace = "")
                    String param
    );

    @WebMethod
    @RequestWrapper(localName = "queryProofFiles", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "QueryProofFiles")
    @ResponseWrapper(localName = "queryProofFilesResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "QueryProofFilesResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<TPMSProofFile> queryProofFiles(
            @WebParam(name = "tpmsProofFile", targetNamespace = "")
                    TPMSProofFile tpmsProofFile
    );

    @WebMethod
    @RequestWrapper(localName = "getTPMSData", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSData")
    @ResponseWrapper(localName = "getTPMSDataResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSDataResponse")
    @WebResult(name = "return", targetNamespace = "")
    public TPMSData getTPMSData(
            @WebParam(name = "docId", targetNamespace = "")
                    Long docId,
            @WebParam(name = "actionParam", targetNamespace = "")
                    ActionParam actionParam
    );

    @WebMethod
    @RequestWrapper(localName = "rollbackPayFine", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "RollbackPayFine")
    @ResponseWrapper(localName = "rollbackPayFineResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "RollbackPayFineResponse")
    public void rollbackPayFine(
            @WebParam(name = "actionParam", targetNamespace = "")
                    ActionParam actionParam,
            @WebParam(name = "tpmsProCertFines", targetNamespace = "")
                    java.util.List<TPMSProCertFine> tpmsProCertFines
    );

    @WebMethod
    @RequestWrapper(localName = "deleteCandidateInfo", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "DeleteCandidateInfo")
    @ResponseWrapper(localName = "deleteCandidateInfoResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "DeleteCandidateInfoResponse")
    public void deleteCandidateInfo(
            @WebParam(name = "tpmsDeleteParam", targetNamespace = "")
                    TPMSDeleteParam tpmsDeleteParam,
            @WebParam(name = "actionParam", targetNamespace = "")
                    ActionParam actionParam
    );

    @WebMethod
    @RequestWrapper(localName = "validateCertLabelNo", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "ValidateCertLabelNo")
    @ResponseWrapper(localName = "validateCertLabelNoResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "ValidateCertLabelNoResponse")
    public void validateCertLabelNo(
            @WebParam(name = "certLabelNo", targetNamespace = "")
                    Long certLabelNo,
            @WebParam(name = "spTxnno", targetNamespace = "")
                    String spTxnno,
            @WebParam(name = "isReprint", targetNamespace = "")
                    boolean isReprint
    ) throws TPMSServiceException_Exception;

    @WebMethod
    @RequestWrapper(localName = "updateDocID", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "UpdateDocID")
    @ResponseWrapper(localName = "updateDocIDResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "UpdateDocIDResponse")
    public void updateDocID(
            @WebParam(name = "oldDocId", targetNamespace = "")
                    Long oldDocId,
            @WebParam(name = "newDocId", targetNamespace = "")
                    Long newDocId,
            @WebParam(name = "actionParam", targetNamespace = "")
                    ActionParam actionParam
    );

    @WebMethod
    @RequestWrapper(localName = "getTPMSCertInfoList", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSCertInfoList")
    @ResponseWrapper(localName = "getTPMSCertInfoListResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSCertInfoListResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<TaxiDrivingLicense> getTPMSCertInfoList(
            @WebParam(name = "arg0", targetNamespace = "")
                    java.util.List<Long> arg0,
            @WebParam(name = "arg1", targetNamespace = "")
                    String arg1
    );

    @WebMethod
    @RequestWrapper(localName = "cancelTPMSProCert", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "CancelTPMSProCert")
    @ResponseWrapper(localName = "cancelTPMSProCertResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "CancelTPMSProCertResponse")
    public void cancelTPMSProCert(
            @WebParam(name = "txnNo", targetNamespace = "")
                    String txnNo,
            @WebParam(name = "docId", targetNamespace = "")
                    Long docId,
            @WebParam(name = "taxiProCertNo", targetNamespace = "")
                    Long taxiProCertNo,
            @WebParam(name = "applicationType", targetNamespace = "")
                    int applicationType,
            @WebParam(name = "actionParam", targetNamespace = "")
                    ActionParam actionParam
    );

    @WebMethod
    @RequestWrapper(localName = "getExamTime", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetExamTime")
    @ResponseWrapper(localName = "getExamTimeResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetExamTimeResponse")
    @WebResult(name = "return", targetNamespace = "")
    public TPMSExamTime getExamTime(
            @WebParam(name = "txn", targetNamespace = "")
                    TPMSTransaction txn,
            @WebParam(name = "actionParam", targetNamespace = "")
                    ActionParam actionParam
    ) throws TPMSServiceException_Exception;

    @WebMethod
    @RequestWrapper(localName = "getTPMSCertInfo", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSCertInfo")
    @ResponseWrapper(localName = "getTPMSCertInfoResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSCertInfoResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<TaxiDrivingLicense> getTPMSCertInfo(
            @WebParam(name = "docId", targetNamespace = "")
                    Long docId,
            @WebParam(name = "status", targetNamespace = "")
                    String status
    );

    @WebMethod
    @RequestWrapper(localName = "payFine", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "PayFine")
    @ResponseWrapper(localName = "payFineResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "PayFineResponse")
    @WebResult(name = "return", targetNamespace = "")
    public Integer payFine(
            @WebParam(name = "txnNo", targetNamespace = "")
                    String txnNo,
            @WebParam(name = "tpmsProCertFines", targetNamespace = "")
                    java.util.List<TPMSProCertFine> tpmsProCertFines,
            @WebParam(name = "actionParam", targetNamespace = "")
                    ActionParam actionParam
    );

    @WebMethod
    @RequestWrapper(localName = "rollbackRenewalAndExpiryDate", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "RollbackRenewalAndExpiryDate")
    @ResponseWrapper(localName = "rollbackRenewalAndExpiryDateResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "RollbackRenewalAndExpiryDateResponse")
    public void rollbackRenewalAndExpiryDate(
            @WebParam(name = "txnno", targetNamespace = "")
                    String txnno,
            @WebParam(name = "taxiCertNo", targetNamespace = "")
                    Long taxiCertNo
    );

    @WebMethod
    @RequestWrapper(localName = "getTPMSUntreatedFineCount", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSUntreatedFineCount")
    @ResponseWrapper(localName = "getTPMSUntreatedFineCountResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSUntreatedFineCountResponse")
    @WebResult(name = "return", targetNamespace = "")
    public Integer getTPMSUntreatedFineCount(
            @WebParam(name = "certNo", targetNamespace = "")
                    Long certNo
    );

    @WebMethod
    @RequestWrapper(localName = "getExamArrangements", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetExamArrangements")
    @ResponseWrapper(localName = "getExamArrangementsResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetExamArrangementsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ExamSchedules> getExamArrangements();

    @WebMethod
    @RequestWrapper(localName = "getTPMSCertDocIdAndDocSeq", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSCertDocIdAndDocSeq")
    @ResponseWrapper(localName = "getTPMSCertDocIdAndDocSeqResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSCertDocIdAndDocSeqResponse")
    @WebResult(name = "return", targetNamespace = "")
    public TPMSCustomer getTPMSCertDocIdAndDocSeq(
            @WebParam(name = "certNo", targetNamespace = "")
                    Long certNo
    );

    @WebMethod
    @RequestWrapper(localName = "getTPMSSysParam", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSSysParam")
    @ResponseWrapper(localName = "getTPMSSysParamResponse", targetNamespace = "http://service.tpms.dsat.mega.com/", className = "GetTPMSSysParamResponse")
    @WebResult(name = "return", targetNamespace = "")
    public TPMSSysParam getTPMSSysParam();
}
