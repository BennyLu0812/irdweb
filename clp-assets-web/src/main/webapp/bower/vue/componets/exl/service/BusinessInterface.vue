<template>
    <div>
        <div id = "contentTitle">
            <fragment-layout :func-name = "contentTitle.tilte" :screen-id = "contentTitle.screenId"></fragment-layout>
        </div>
        <div id = "pdmInfo">
            <!-- 個人資料信息 -->
            <pdm-info v-show="pdmParam.moduleShow" v-model="pdmParam.docId" :docseq="pdmParam.docSeq" :titleshow="pdmParam.titleshow"></pdm-info>
        </div>
        <hr />
        <!-- 业务界面展示 -->
        <div id = "businessShow">
            <label class="h3" v-text="businessTitle"></label>
            <table id="table-exam0006Yservice" class="table table-bordered table-hover table-condensed dataTable no-footer" role="grid" style="width: 100%;"
                    width="100%" cellspacing="0" ref = "businessTable">
                    <thead>
                        <tr role="row">
                            <th class="dataTables_empty sorting_disabled" style="width: 1px;" rowspan="1" colspan="1" th-type="single" row-data-width="2%"
                                row-data-style="radioInput"></th>
                            <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;" row-data-width="13%"
                                row-data-style="lineMoreParamStyle">
                                <div v-text = "label.examNo">考試申請編號</div>
                                <div v-text = "label.applyDate" class="text text-muted">申請日期</div>
                            </th>
                            <th class="dataTables_empty sorting_disabled dt-nowrap" style="width: 0px;" row-data-width="10%"
                                row-data-style="lineSingleParamStyle">
                                <div v-text = "label.examDate">考試日期</div>
                                <div v-text = "label.examDateText" class="text text-muted">考試日期-改期</div>
                            </th>
                            <th v-text = "label.licCat" class="dataTables_empty sorting_disabled dt-nowrap" style="line-height: 45px; width: 0px;"
                                rowspan="1" colspan="1" row-data-width="6%" row-data-style="normalTitleStyle">駕駛類別</th>
                            <th v-text = "label.gearboxType" class="dataTables_empty sorting_disabled" style="line-height: 45px; width: 0px;" rowspan="1"
                                colspan="1" row-data-width="10%">變速箱類別</th>
                            <th v-text = "label.initCylinderVol" class="dataTables_empty sorting_disabled" style="line-height: 45px; width: 0px;"
                                rowspan="1" colspan="1" row-data-width="9%">汽缸容量 (C.C.)</th>
                            <th class="dataTables_empty sorting_disabled" style="width: 0px;" rowspan="1" colspan="1" row-data-width="13%"
                                row-data-style="lineMoreParamPromptStyle">
                                <div v-text = "label.examType">考試類別</div>
                            </th>
                            <th v-text = "label.examResult" class="dataTables_empty sorting_disabled" style="line-height: 45px; width: 0px;"
                                row-data-width="5%" row-data-style="normalTitleStyle">考試結果</th>
                            <th v-text = "label.licNo" class="dataTables_empty sorting_disabled" style="line-height: 45px; width: 0px;"
                                row-data-width="10%">學習駕照</th>
                            <th class="dataTables_empty sorting_disabled" style="width: 0px;" rowspan="1" colspan="1" row-data-width="10%"
                                row-data-style="lineSingleParamStyle">
                                <div v-text = "label.lastUpdDate">最後更新日期</div>
                                <div v-text = "label.lastUpdUser" class="text text-muted">最後更新用戶</div>
                            </th>
                        </tr>
                    </thead>
                </table>
                <div v-show = "isSelectedRecord">
                    <slot name="businessOperate"></slot>
                </div>
        </div>
        <!-- 其他信息 -->
        <div id = "otherInfo">
            <!-- 其他信息模塊Tab標籤 -->
            <exl-other-show-tabs v-model="pdmParam.docId" :docSeq="pdmParam.docSeq" :tabs="tabs"></exl-other-show-tabs>
        </div>
        <!-- 备注栏位 -->
        <div id = "remarkField" class="col-sm-12">
            <span class="h4 pull-left" v-cloak v-text="label.examRemark">備註</span>
            <div class="form-group">
                <div class="col-sm-10">
                    <textarea :placeholder="label.remarkPlaceholder" class="form-control" v-model = "dataRemark"></textarea>
                </div>
            </div>
        </div>
        <!-- 操作欄位 -->
        <div id = "operateField" class="form-group">
            &nbsp;&nbsp;
            <button type="button" @click="$emit('previous-view')" class="btn btn-default" v-text = "label.previous">上一步</button>
            &nbsp;&nbsp;
            <button type="button" @click="nextViewMethod" class="btn btn-default" v-text = "label.next">下一步</button>
        </div>
    </div>
</template>

<script>
    define(['jquery', 'Vue', 'atosUtil', 'axios', 'vueloader!vue/componets/pdm-info', 'vueloader!vue/componets/exl/service/FragmentLayout'],function($, Vue, atosUtil, axios){
        var BusinessInterface = Vue.extend({
            template:template,
            props:{
                // 主檔個人信息
                pdmParam : { type : Object },
                // 國際化文件
                i18nArr : { type : Object},
                // 業務界面標題
                businessTitle : { type : String },
                // 業務數據
                businessParam : { type : Object },
                // 標題
                contentTitle : { type : Object },
                // 其他信息
                tabs : { type : Object },
                // 備註
                dataRemark : { type : String }
            },
            data : function() {
                return {
                    label : {},
                    isSelectedRecord : false,
                    selectedRecordIndex : null,
                    datatableParams: [
                        [{ field: "examDetailId" }],
                        [{ field: "examNo" }, { field: "examYear" }, { field: "applyDate" }],
                        [{ field: "examDate" }, { field: "specifiedDate" }],
                        [{ field:"licCatText" }, { field: "licCat" }],
                        [{ field: "gearboxTypeText" }],
                        [{ field: "initCylinderVol" }],
                        [{ field: "examTypeText" }, { field: "repeatStatus", prefix: "RepeatStatusEnum", filterReg : /^Y$/ }],
                        [{ field: "examResult", prefix: "ExamResultEnum" }, { field: "examResult" }],
                        [{ field: "licNo" }],
                        [{ field: "lastUpdDate" }, { field: "lastUpdUser" }]
                    ]
                };
            },
            // 初始化页面
            created: function () { 
                this.initPageLabel();
            },
            mounted : function(){
                var self = this;
                var businessTable = this.$refs.businessTable;
                this.getDataAndShow(businessTable);
                this.initDatatables(businessTable);
                // 單擊單選按鈕所在行時觸發事件
                $(businessTable).on('click', 'tr', function () {
                    if (!$(this).find('input[name="btn-details"]').is(":checked")) { // 如果沒選中，讓它選中
                        $(this).find('input[name="btn-details"]').prop("checked", "checked");
                        self.selectedRecordIndex = $(this).context._DT_RowIndex;;
                    }                
                });
                
                // 單擊單選按鈕時觸發事件
                $(document).on('click', 'input[name="btn-details"]', function () {
                    self.selectedRecordIndex = $(this).parent().parent().get(0)._DT_RowIndex;;
                });
            },
            watch : {
                'selectedRecordIndex' : function(val, oldVal){
                    var self = this;
                    if (val !=null && val != oldVal){
                        self.isSelectedRecord = true;
                        var row = $(self.$refs.businessTable).DataTable().row(val).data();
                        if (typeof (row) != "undefined" && row.examDetailId != null) {
                            self.$emit("show-business-ope",$.extend({},row));
                        }
                    }
                }
            },
            methods : {
                // 單擊'下一步'按鈕時觸發
                nextViewMethod : function(){
                    var selectedIndex = this.selectedRecordIndex;
                    var row = selectedIndex != null ? $.extend({}, $(this.$refs.businessTable).DataTable().row(selectedIndex).data()) : null;
                    if (row){
                        row.remark = this.dataRemark ? this.dataRemark : '';
                    }
                    this.$emit("next-view",row);
                },
                // 获取数据展示
                getDataAndShow : function (ele) {
                    var self = this;
                    var dataUrl = self.businessParam.dataUrl;
                    var bindId = self.businessParam.bindAttrId;
                    // 获取数据
                    axios.get(dataUrl).then(function (response) {
                        $(ele).dataTable().fnClearTable();
                        // 渲染数据
                        if (response.length > 0) {
                            $(ele).dataTable().fnAddData(response);
                        }
                        if (bindId && bindId != ""){
                            $("#" + bindId).prop("checked", "checked");
                            self.selectedRecordIndex = $('#' + bindId).parent().parent().get(0)._DT_RowIndex;
                        }
                    }).catch(function (error) {
                        console.log(error);
                    });
                },
                // 初始化dataTable
                initDatatables : function (ele) {
                    var self = this;
                    var dataFields = atosUtil.DTFormColmunInfo($(self.$refs.businessTable).attr('id'), self.datatableParams);
                    var dataColumns = atosUtil.DTFormColmuns(dataFields);
                    var dataColumnDefs = atosUtil.DTFormColmunDefsI18n(dataFields, self.i18nArr);
    
                    $(ele).DataTable({
                       paging: false, //禁止分页
                        info: false, //去掉底部文字
                        select: {
                            style: 'single',
                            selector: 'td'
                        },
                        columns: [
                            {"data": "column1", "width": "8%"}, 
                            {"data": "column2", "width": "10%"}, 
                            {"data": "column3", "width": "10%"},
                            {"data": "column4", "width": "10%"},
                            {"data": "column5", "width": "10%"},
                            {"data": "column6", "width": "10%"},
                            {"data": "column7","width": "10%"},
                            {"data": "column8", "width": "10%"},
                            {"data": "column9", "width": "10%"},
                            {"data": "column10", "width": "10%"}
                        ],
                        columnDefs: [
                            {
                                    render : function (data,type,row){
                                        return '<input type="radio" name="btn-details" id="' + row.examDetailId + '"/>';
                                    },
                                    targets : 0
                            },
                            {
                                render: function(data, type, row) {
                                     var str = "";
                                    if (row.examNo != null && row.examYear !=null) {
                                        str ="<span>"+row.examNo + "/" + row.examYear +"</span><br/>";
                                    }
                                    if (row.applyDate != null ) {
                                        str += "<span class='text text-muted'> "+row.applyDate+"</span>";
                                    }
                                    return str;
                                 },
                                 targets: 1
                            }, 
                            {
                                 render: function(data, type, row) {
                                    var examDate = row.examDate != null ? row.examDate : "";
                                    var origExamDate = row.origExamDate != null ? row.origExamDate : "";
                                    var examSession = row.examSession != null ? row.examSession : "";
                                    var origExamSession = row.origExamSession != null ? row.origExamSession : "";
                                    var sessionStartTime = row.sessionStartTime != null ? row.sessionStartTime : "";
                                    var origSsessionStartTime = row.origSsessionStartTime != null ? row.origSsessionStartTime : "";
                                    
                                    var str = " <text> " + examDate + "&nbsp;" + examSession + "&nbsp;" + sessionStartTime + "</text>";
                                    str += "<br/><span class='text text-muted'> " + origExamDate + "&nbsp;" + origExamSession + "&nbsp;" + origSsessionStartTime + "</span>";
                                    return str;
                                 },
                                 targets :2 
                            }, 
                            {
                                 render: function(data, type, row) {
                                    var str = "";
                                    var licCat = "";
                                    var licCatText = "";
                                    if (row.licCat != null) {
                                        licCat = row.licCat;
                                        licCatText = row.licCatText;
                                    }
                                    str = "<span title = '" + licCatText + "'>" + licCat + "</span>"
                                    return str; 
                                 },
                                 targets :3 
                            }, 
                            {
                                 render: function(data, type, row) {
                                    var str = "";
                                    var gearboxType = "";
                                    if (row.examResult != null && row.examResult =="A" || row.examResult != null && row.examResult =="R") {
                                        if (row.gearboxType != null && row.gearboxType == "A") {
                                            gearboxType = atosUtil.getI18nMessage('GearBoxTypeEnum.' + row.gearboxType);
                                        }
                                    } else {
                                        if (row.initGearboxType != null && row.initGearboxType == "A") {
                                            gearboxType = atosUtil.getI18nMessage('GearBoxTypeEnum.' + row.initGearboxType);
                                        }
                                        
                                    }
                                    str = "<span>" + gearboxType + "</span>"
                                    return str; 
                                 },
                                 targets :4
                            }, 
                            {
                                render: function(data, type, row) {
                                    var str = "";
                                    if (row.examResult != null && row.examResult =="A" || row.examResult != null && row.examResult =="R") {
                                        if (row.cylinderVol != null) {
                                            str = "<span class='text text-muted'> " + row.cylinderVol + "</span>";
                                        }
                                    } else {
                                        if (row.initCylinderVol != null) {
                                            str = "<span class='text text-muted'> " + row.initCylinderVol + "</span>";
                                        }
                                    }
                                    return str; 
                                },
                                targets :5
                           },
                            {
                                 render: function(data, type, row) {
                                     var str = "";
                                    if (row.examType != null) {
                                        str = "<span>" + row.examTypeText + "</span>";
                                    }
                                    if (row.repeatStatus != null && row.repeatStatus == 'Y') {
                                        str += "<br><font style=\"color:#ED9B04; font-weight: bold\">" + atosUtil.getI18nMessage('QuotaTypeEnum.R') + "</font>"
                                    }
                                    str +="<br/><font style=\"color:#ED9B04; font-weight: bold\">";
                                    if (row.examRescheduleStatus != null) {
                                        if (row.examRescheduleStatus != null && row.examRescheduleStatus =="ADVDELAY") {
                                            str += atosUtil.getI18nMessage('exam.msg.reschedule.ADVOrDELAY');
                                        } else {
                                            str += atosUtil.getI18nMessage('ExamRescheduleStatusEnum.' + row.examRescheduleStatus );
                                        }
                                        if (row.examRescheduleApprovalStatus != null) {
                                            str +="(" + atosUtil.getI18nMessage('ExamServiceApprovalStatus.' + row.examRescheduleApprovalStatus ) + ")";
                                        }
                                    }
                                    str += "</font>";
                                    str +="<br/><font style=\"color:#ED9B04; font-weight: bold\">";
                                    if (row.changeSchoolType != null) {
                                        str += atosUtil.getI18nMessage("exam.msg.changeSchool");
                                        if (row.changeSchoolApprovalStatus != null) {
                                            str +="(" +  atosUtil.getI18nMessage('ExamServiceApprovalStatus.' + row.changeSchoolApprovalStatus ) + ")";
                                        }
                                    }
                                    str += "</font>";
                                    return str;
                                 },
                                 targets :6
                            }, 
                            {
                                 render: function(data, type, row) {
                                    var str = "";
                                    if (row.examResult != null) {
                                        str = atosUtil.getI18nMessage('ExamResultEnum.' + row.examResult);
                                    }
                                    return str;
                                 },
                                 targets :7
                            }, 
                             {
                            render : function (data,type,row){
                                    var str ="";
                                    if (row.licNo != null) {
                                        str = row.licNo;
                                    }
                                    return str;
                                },
                                targets : 8
                            },{
                                render : function (data,type,row){
                                    return row.lastUpdDate+"<br/><span class='text text-muted'> "+row.lastUpdUser+"</span>";
                                },
                                targets : 9
                            }]
                    });
                },
                initPageLabel : function() {
                    // 业务表格中使用到的 标签
                    this.label.examNo = atosUtil.getI18nMessage('exam.field.examNo');
                    this.label.applyDate = atosUtil.getI18nMessage('exam.field.applyDate');
                    this.label.examDate = atosUtil.getI18nMessage('exam.field.examDate');
                    this.label.examDateText = atosUtil.getI18nMessage('exam.field.examDateText');
                    this.label.licCat = atosUtil.getI18nMessage('exam.field.licCat');
                    this.label.gearboxType = atosUtil.getI18nMessage('exam.field.gearboxType');
                    this.label.initCylinderVol = atosUtil.getI18nMessage('exam.field.initCylinderVol');
                    this.label.examType = atosUtil.getI18nMessage('exam.field.examType');
                    this.label.repeatStatus = atosUtil.getI18nMessage('exam.field.repeatStatus');
                    this.label.examResult = atosUtil.getI18nMessage('exam.field.examResult');
                    this.label.licNo = atosUtil.getI18nMessage('exam.field.licNo');
                    this.label.lastUpdDate = atosUtil.getI18nMessage('exam.field.lastUpdDate');
                    this.label.lastUpdUser = atosUtil.getI18nMessage('exam.field.lastUpdUser');
                    
                    // 操作按钮使用到的标签
                    this.label.previous = atosUtil.getI18nMessage('global.previous');
                    this.label.next = atosUtil.getI18nMessage('global.next');
                    this.label.examRemark = atosUtil.getI18nMessage('exam.field.examRemark');
                    this.label.remarkPlaceholder = atosUtil.getI18nMessage('examiner.field.remark');
                }
            }
        });
        
        Vue.component('business-interface',BusinessInterface);
    });
</script>