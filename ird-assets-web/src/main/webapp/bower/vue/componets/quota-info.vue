<template>
<div v-show="show">
    <div v-if="isExamSubTypeT">
         <table id="exl-exam-examDate-vehRegDateQuotaTable" class="table table-bordered table-condensed dataTable no-footer text-center" role="grid" style="width: 100%;" width="100%" cellspacing="0">
             <thead>
                <tr role="row">
                     <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 30%;"></th>
                     <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.mName"></span></th>
                     <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.m1Name"></span></th>
                     <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.m2Name"></span></th>
                     <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.m3Name"></span></th>
                     <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.tName"></span></th>
                     <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.t1Name"></span></th>
                     <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.t2Name"></span></th>
                 </tr>
              </thead>
         </table>
         <div v-show = "isExamServiceApply">
             <br/>
             <table id="exl-exam-examDate-assign-vehRegDateQuotaTable" class="table table-bordered table-condensed dataTable no-footer text-center" role="grid" style="width: 100%;" width="100%" cellspacing="0">
                 <thead>
                    <tr role="row">
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 30%;"></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.assignMName"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.assignM1Name"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.assignM2Name"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.assignM3Name"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.assignTName"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.assignT1Name"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.assignT2Name"></span></th>
                     </tr>
                  </thead>
             </table>
             <br/>
         </div>
    </div>
  
    <div  v-else>
         <table id="exl-exam-examDate-vehRegDateQuotaTable" class="table table-bordered table-conshendensed dataTable no-footer  text-center" role="grid" style="width: 100%;" width="100%" cellspacing="0">
              <thead>
                    <tr role="row">
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 40%;"></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.mName"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.m1Name"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.m2Name"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.tName"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.t1Name"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.t2Name"></span></th>
                     </tr>
              </thead>
         </table>
         <div v-show= "isExamServiceApply">
             <br/>
             <table id="exl-exam-examDate-assign-vehRegDateQuotaTable" class="table table-bordered table-condensed dataTable no-footer text-center" role="grid" style="width: 100%;" width="100%" cellspacing="0">
                 <thead>
                    <tr role="row">
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 40%;"></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.assignMName"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.assignM1Name"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.assignM2Name"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.assignTName"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.assignT1Name"></span></th>
                         <th class="dataTables_empty sorting_disabled dt-nowrap" rowspan="1" colspan="1" style="width: 0px;"><span v-text="label.assignT2Name"></span></th>
                     </tr>
                  </thead>
             </table>
             <br/>
         </div>
    </div>     
    
     <table id="exl-exam-examDate-reschedule-QuotaTable" class="table table-bordered table-condensed dataTable no-footer" role="grid" style="width: 100%;" width="100%" cellspacing="0">
         <thead>
              <tr role="row">
                 <th class="dataTables_empty sorting_disabled" rowspan="1" colspan="1" style="width:40%"></th>
                 <th class="dataTables_empty sorting_disabled" rowspan="1" colspan="1" style="width: 0px;">{{label.applying}} </th>
                 <th class="dataTables_empty sorting_disabled" rowspan="1" colspan="1" style="width: 0px;">{{label.examQueueText}} </th>
                 <th class="dataTables_empty sorting_disabled" rowspan="1" colspan="1" style="width: 0px;">{{label.reserved}} </th>
               </tr>
          </thead>
          <tbody>
             <tr role="row">
                 <td class="dataTables_empty sorting_disabled" rowspan="1" colspan="1" style="width: 40%;line-height:2rem;">
                     <div class="group" style="width:240px;" v-if ="currQueueList!== undefined && currQueueList!== null && currQueueList.length > 1">
                        <br/>
                        {{label.applyRescheduledQuota}}
                     </div>
                     <p style="width:240px;" v-else>{{label.applyRescheduledQuota}}</p>
                 </td>
                 <td class="dataTables_empty sorting_disabled" rowspan="1" colspan="1" style="widtd: 0px;line-height:2rem;">
                    <div class="group" v-if ="currQueueList!== undefined && currQueueList!== null && currQueueList.length > 1">
                        <br/>
                        {{applyingCount}}
                    </div>
                    <div v-else  v-text ="applyingCount"></div>
                 </td>
                 <td class="dataTables_empty sorting_disabled" rowspan="1" colspan="1" style="widtd: 0px;line-height:2rem;">
                       <div v-for = "(queue, index) in currQueueList" style="line-height:2rem;">
                            {{queue}}
                            <hr v-if="currQueueList!== undefined && currQueueList!== null && currQueueList.length > 1 && index%2 != 1"/>
                       </div>     
                 </td>
                 <td class="dataTables_empty sorting_disabled" rowspan="1" colspan="1" style="widtd: 0px;line-height:2rem;">
                       <div v-for = "(reserved, index) in currReservedList" style="line-height:2rem;">
                            {{reserved}}
                            <hr v-if="currReservedList!== undefined && currReservedList!== null && currReservedList.length > 1 && index%2 != 1"/>
                       </div>
                    </table>
                 </td>
             </tr>
          </tbody>
      </table>
</div>
</template>

<script>
define(['jquery', "atosUtil", 'Vue', 'vueloader', 'bootstrap'],function($, atosUtil, Vue){
    var quotaInfo = Vue.extend({
        template:template,
        props:{
            value:{
                type:Object
            },
            show:{
                type:Boolean,
                default:false
            },
            quotaParams:{
                type:Object
            },
            examsubtype:{
                type: Object,
                default:""
            }
        },
        created:function(){
            this.initData();
            this.loadData();
        },
        data:function(){
            return {
                label:{
                        mName:'',
                        m1Name:'',
                        m2Name:'',
                        m3Name:'',
                        tName:'',
                        t1Name:'',
                        t2Name:'',
                        assignMName:'',
                        assignM1Name:'',
                        assignM2Name:'',
                        assignM3Name:'',
                        assignTName:'',
                        assignT1Name:'',
                        assignT2Name:'',
                        applyRescheduledQuota:"",
                        examQueueText: "",
                        applying:"",
                        reserved:""
                 },
                 applyingCount:"",
                 sessionQuota:null,
                 rescheduleDTOS: [],
                 currQueueList: [],
                 currReservedList:[],
                 isExamServiceApply : false,
                 isExamSubTypeT: false
            }
        },
        methods:{
            //國際化表格標題
            initData:function(){
                    var self = this;
                    self.label.mName = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.examSessionM');
                    self.label.m1Name = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.examSessionM1');
                    self.label.m2Name = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.examSessionM2');
                    self.label.m3Name = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.examSessionM3');
                    self.label.tName = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.examSessionT');
                    self.label.t1Name = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.examSessionT1');
                    self.label.t2Name = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.examSessionT2');
                    
                    self.label.assignMName = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.examSessionM');
                    self.label.assignM1Name = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.examSessionM1');
                    self.label.assignM2Name = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.examSessionM2');
                    self.label.assignM3Name = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.examSessionM3');
                    self.label.assignTName = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.examSessionT');
                    self.label.assignT1Name = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.examSessionT1');
                    self.label.assignT2Name = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.examSessionT2');
                    
                    self.label.examQueueText = atosUtil.getI18nMessage('exam.msg.vehRegDateQuota.currentRescheduleQueue');
                    self.label.applying = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.applying');
                    self.label.reserved = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.reserved');
                    self.label.applyRescheduledQuota = atosUtil.getI18nMessage('exam.vehRegDateQuota.field.applyRescheduledQuota')
            },
            //加載數據
            loadData:function(){
                var self = this;
                if (self.examsubtype != null && self.examsubtype == "T") {
                        self.isExamSubTypeT = true;
                }
                if (typeof(self.quotaParams) != "undefined") {
                    //獲取改期申請和預留情況
                   if (typeof(self.quotaParams.examDate) != "undefined" && self.quotaParams.examDate != "") {
                        $.ajax({
                            url:basePath + '/exl/reschedule/get_proportion_quota_info',
                            data:{
                                    "examType" : self.quotaParams.examType,
                                    "quotaDate" : self.quotaParams.examDate,
                                    "isDSALBus" : self.quotaParams.isDSALBus,
                                    "examSubType" : self.quotaParams.examSubType
                                },
                            type:"GET",
                            async:false, 
                            dataType:"json",
                            success: function (response) {
                                if (typeof(response) != "undefined") {
                                    self.applyingCount = response.applyingCount == null ? 0 :response.applyingCount;
                                    if (response.currQueueList.length >0) {
                                      self.currQueueList = response.currQueueList;
                                    }
                                    if (response.currReservedList.length >0) {
                                      self.currReservedList = response.currReservedList;
                                    }
                                }
                            },
                            error: function (e) {
                                console.log(e);
                            }
                        });
                       
                        
                       if (typeof(self.quotaParams.examDetailId) != "undefined" && self.quotaParams.examDetailId != "" && self.quotaParams.examDetailId != null
                                 && typeof(self.quotaParams.operationType) != "undefined" && self.quotaParams.operationType == "M") {
                            //獲取當天正常 、改期的配額情況
                           $.getJSON(basePath + '/exl/reschedule/get_quota_info',
                           {'approvedExamDate':self.quotaParams.examDate, 'examDetailId': self.quotaParams.examDetailId, 'spNo': self.quotaParams.spNo},function(response) {
                                self.quotaParams.sessionQuota = response;
                                $('#exl-exam-examDate-vehRegDateQuotaTable').dataTable()._fnClearTable();
                                $('#exl-exam-examDate-vehRegDateQuotaTable').dataTable().fnAddData(response);
                           });
                           self.isExamServiceApply = false;
                       } else {//申請與重考，需要用到考試日曆
                       self.isExamServiceApply = true;
                         var params =  {
                                    "desireExamDate" : self.quotaParams.examDate,
                                    "examSubType" : self.quotaParams.examSubType,
                                    "examType" : self.quotaParams.examType,
                                    "quotaType" : self.quotaParams.quotaType,
                                    "isDSALBus" : self.quotaParams.isDSALBus,
                                    "operationType":"applyService"
                                };
                         if (typeof(self.quotaParams.operationType) != "undefined" && self.quotaParams.operationType == "M") {
                            params =  {
                                    "desireExamDate" : self.quotaParams.examDate,
                                    "examSubType" : self.quotaParams.examSubType,
                                    "examType" : self.quotaParams.examType,
                                    "quotaType" : self.quotaParams.quotaType,
                                    "isDSALBus" : self.quotaParams.isDSALBus
                             };
                         }
                         $.getJSON(basePath + '/exl/reschedule/get_exam_calendar_proportion_situation_info', params, function(response) {
                             $('#exl-exam-examDate-vehRegDateQuotaTable').dataTable()._fnClearTable();
                             $('#exl-exam-examDate-vehRegDateQuotaTable').dataTable().fnAddData(response);
                         });
                         var assignParams =  {
                                    "desireExamDate" : self.quotaParams.examDate,
                                    "examSubType" : self.quotaParams.examSubType,
                                    "examType" : self.quotaParams.examType,
                                    "quotaType" : self.quotaParams.quotaType,
                                    "isDSALBus" : self.quotaParams.isDSALBus
                          };
                          //考試申請指定日期配額情況
                          $.getJSON(basePath + '/exl/reschedule/get_assign_exam_date_proportion_situation_info', assignParams, function(response) {
                                $('#exl-exam-examDate-assign-vehRegDateQuotaTable').dataTable()._fnClearTable();
                                $('#exl-exam-examDate-assign-vehRegDateQuotaTable').dataTable().fnAddData(response);
                          });
                       }
                   }
                }
            },
            //配額數據格式轉換
            getQuotaData:function(value){
                if(value ==null || value =='/'){
                   return '-/-';
                }else{
                   return value;
                }
            },
            //列表
            initDatatables: function() {
                var self = this;
                if (self.isExamSubTypeT) {
                    var datatable = $('#exl-exam-examDate-vehRegDateQuotaTable').DataTable({
                        paging: false, //禁止分页
                        info: false, //去掉底部文字
                        select: false,
                        columns: [
                            {"data": "column1", "width": "30%"}, 
                            {"data": "column2", "width": "10%"}, 
                            {"data": "column3", "width": "10%"},
                            {"data": "column4", "width": "10%"},
                            {"data": "column5", "width": "10%"},
                            {"data": "column6", "width": "10%"},
                            {"data": "column7","width": "10%"},
                            {"data": "column8", "width": "10%"}
                        ],
                        columnDefs: [
                            {
                                render: function(data, type, row) {
                                     var str = '';
                                     if (row.type == 'N') { 
                                         str = '<p style = "width:240px">' + atosUtil.getI18nMessage('exam.vehRegDateQuota.field.dailyNormalNQuota') + '</p>';
                                     } else if (row.type == 'R') { 
                                         str = '<p style = "width:240px">' + atosUtil.getI18nMessage('exam.vehRegDateQuota.field.dailyNormalRQuota') + '</p>';
                                     } else if (row.type == 'M') {
                                         str = '<p style = "width:240px">' + atosUtil.getI18nMessage('exam.vehRegDateQuota.field.rescheduledQuota') + '</p>';
                                     }
                                     return str;
                                 },
                                 targets: 0
                            }, 
                            {
                                 render: function(data, type, row) {
                                       return self.getQuotaData(row.m);
                                 },
                                 targets :1 
                            }, 
                            {
                                 render: function(data, type, row) {
                                       return  self.getQuotaData(row.m1);
                                 },
                                 targets :2 
                            }, 
                            {
                                 render: function(data, type, row) {
                                       return  self.getQuotaData(row.m2);
                                 },
                                 targets :3
                            }, 
                            {
                                render: function(data, type, row) {
                                      return  self.getQuotaData(row.m3);
                                },
                                targets :4
                           },
                            {
                                 render: function(data, type, row) {
                                       return  self.getQuotaData(row.t);
                                 },
                                 targets :5
                            }, 
                            {
                                 render: function(data, type, row) {
                                        return  self.getQuotaData(row.t1);
                                 },
                                 targets :6
                            }, 
                            {
                                 render: function(data, type, row) {
                                        return  self.getQuotaData(row.t2);
                                 },
                                 targets :7
                            }]
                    });
                    var assignExamDatedatatable = $('#exl-exam-examDate-assign-vehRegDateQuotaTable').DataTable({
                        paging: false, //禁止分页
                        info: false, //去掉底部文字
                        select: false,
                        columns: [
                            {"data": "column1", "width": "30%"}, 
                            {"data": "column2", "width": "10%"}, 
                            {"data": "column3", "width": "10%"},
                            {"data": "column4", "width": "10%"},
                            {"data": "column5", "width": "10%"},
                            {"data": "column6", "width": "10%"},
                            {"data": "column7","width": "10%"},
                            {"data": "column8", "width": "10%"}
                        ],
                        columnDefs: [
                            {
                                render: function(data, type, row) {
                                     var str = '';
                                     if (row.type == 'N') { 
                                         str = '<p style = "width:240px">' + atosUtil.getI18nMessage('exam.vehRegDateQuota.field.dailyAssignNormalNQuota') + '</p>';
                                     } else if (row.type == 'R') { 
                                         str = '<p style = "width:240px">' + atosUtil.getI18nMessage('exam.vehRegDateQuota.field.dailyAssignNormalRQuota') + '</p>';
                                     } 
                                     return str;
                                 },
                                 targets: 0
                            }, 
                            {
                                 render: function(data, type, row) {
                                       return self.getAssignQuotaInfo(row.m, row.type, row.assignExamDateList, 'M');
                                 },
                                 targets :1 
                            }, 
                            {
                                 render: function(data, type, row) {
                                       return  self.getAssignQuotaInfo(row.m1, row.type, row.assignExamDateList, 'M1');
                                 },
                                 targets :2 
                            }, 
                            {
                                 render: function(data, type, row) {
                                       return  self.getAssignQuotaInfo(row.m2, row.type, row.assignExamDateList, 'M2');
                                 },
                                 targets :3
                            }, 
                            {
                                render: function(data, type, row) {
                                      return  self.getAssignQuotaInfo(row.m3, row.type, row.assignExamDateList, 'M3');
                                },
                                targets :4
                           },
                            {
                                 render: function(data, type, row) {
                                       return  self.getAssignQuotaInfo(row.t, row.type, row.assignExamDateList, 'T');
                                 },
                                 targets :5
                            }, 
                            {
                                 render: function(data, type, row) {
                                        return  self.getAssignQuotaInfo(row.t1, row.type, row.assignExamDateList, 'T1');
                                 },
                                 targets :6
                            }, 
                            {
                                 render: function(data, type, row) {
                                       return self.getAssignQuotaInfo(row.t2, row.type, row.assignExamDateList, 'T2');
                                 },
                                 targets :7
                            }]
                    });
                } else {
                    var datatable = $('#exl-exam-examDate-vehRegDateQuotaTable').DataTable({
                        paging: false, //禁止分页
                        info: false, //去掉底部文字
                        select: false,
                        columns: [
                            {"data": "column1", "width": "40%"}, 
                            {"data": "column2", "width": "10%"}, 
                            {"data": "column3", "width": "10%"},
                            {"data": "column4", "width": "10%"},
                            {"data": "column5", "width": "10%"},
                            {"data": "column6", "width": "10%"},
                            {"data": "column7","width": "10%"}
                        ],
                        columnDefs: [
                            {
                                render: function(data, type, row) {
                                     var str = '';
                                     if (row.type == 'N') { 
                                         str = '<p style = "width:240px">' + atosUtil.getI18nMessage('exam.vehRegDateQuota.field.dailyNormalNQuota') + '</p>';
                                     } else if (row.type == 'R') { 
                                         str = '<p style = "width:240px">' + atosUtil.getI18nMessage('exam.vehRegDateQuota.field.dailyNormalRQuota') + '</p>';
                                     } else if (row.type == 'M') {
                                         str = '<p style = "width:240px">' + atosUtil.getI18nMessage('exam.vehRegDateQuota.field.rescheduledQuota') + '</p>';
                                     }
                                     return str;
                                 },
                                 targets: 0
                            }, 
                            {
                                 render: function(data, type, row) {
                                       return self.getQuotaData(row.m);
                                 },
                                 targets :1 
                            }, 
                            {
                                 render: function(data, type, row) {
                                       return  self.getQuotaData(row.m1);
                                 },
                                 targets :2 
                            }, 
                            {
                                 render: function(data, type, row) {
                                       return  self.getQuotaData(row.m2);
                                 },
                                 targets :3
                            }, 
                            {
                                 render: function(data, type, row) {
                                       return  self.getQuotaData(row.t);
                                 },
                                 targets :4
                            }, 
                            {
                                 render: function(data, type, row) {
                                        return  self.getQuotaData(row.t1);
                                 },
                                 targets :5 
                            }, 
                            {
                                 render: function(data, type, row) {
                                        return  self.getQuotaData(row.t2);
                                 },
                                 targets :6
                            }]
                    });
                    
                    var assignExamDatedatatable = $('#exl-exam-examDate-assign-vehRegDateQuotaTable').DataTable({
                        paging: false, //禁止分页
                        info: false, //去掉底部文字
                        select: false,
                        columns: [
                            {"data": "column1", "width": "40%"}, 
                            {"data": "column2", "width": "10%"}, 
                            {"data": "column3", "width": "10%"},
                            {"data": "column4", "width": "10%"},
                            {"data": "column5", "width": "10%"},
                            {"data": "column6", "width": "10%"},
                            {"data": "column7","width": "10%"},
                        ],
                        columnDefs: [
                            {
                                render: function(data, type, row) {
                                     var str = '';
                                     if (row.type == 'N') { 
                                         str = '<p style = "width:240px">' + atosUtil.getI18nMessage('exam.vehRegDateQuota.field.dailyAssignNormalNQuota') + '</p>';
                                     } else if (row.type == 'R') { 
                                         str = '<p style = "width:240px">' + atosUtil.getI18nMessage('exam.vehRegDateQuota.field.dailyAssignNormalRQuota') + '</p>';
                                     }
                                     return str;
                                 },
                                 targets: 0
                            }, 
                            {
                                 render: function(data, type, row) {
                                       return self.getAssignQuotaInfo(row.m, row.type, row.assignExamDateList, 'M');
                                 },
                                 targets :1 
                            }, 
                            {
                                 render: function(data, type, row) {
                                       return self.getAssignQuotaInfo(row.m1, row.type, row.assignExamDateList, 'M1');
                                 },
                                 targets :2 
                            }, 
                            {
                                 render: function(data, type, row) {
                                        return self.getAssignQuotaInfo(row.m2, row.type, row.assignExamDateList, 'M2');
                                 },
                                 targets :3
                            }, 
                            {
                                 render: function(data, type, row) {
                                       return self.getAssignQuotaInfo(row.t, row.type, row.assignExamDateList, 'T');
                                 },
                                 targets :4
                            }, 
                            {
                                 render: function(data, type, row) {
                                        return self.getAssignQuotaInfo(row.t1, row.type, row.assignExamDateList, 'T1');
                                 },
                                 targets :5
                            }, 
                            {
                                 render: function(data, type, row) {
                                        return self.getAssignQuotaInfo(row.t2, row.type, row.assignExamDateList, 'T2');
                                 },
                                 targets :6
                            }]
                    });
                }
                $('#identifier').tooltip();
            },
            getAssignQuotaInfo : function (examSessionQuota, type, assignExamDateList, examSession) {
                var self = this;
                var pdaResponse = "";
                var str = "";
                 $.each(assignExamDateList, function (i, item) {
                    var repeatStatus = item.repeatStatus =="Y" ? "R" : "N";
                    if (typeof(item.examNo) != "undefined" && typeof(item.examYear) != "undefined" && typeof(item.schoolName) != "undefined"
                         && item.examSession == examSession && repeatStatus == type) {
                         str += item.examNo + "/" + item.examYear + "    " + item.schoolName + "&#10;&#10;";
                    }
                 });
                pdaResponse ='<span data-toggle="tooltip" style="cursor:pointer;" title="'+str+'">'  + self.getQuotaData(examSessionQuota) + '</span>';
                return pdaResponse;
            }   
        },
        watch:{
           "quotaParams.examDate":function(val, oldVal){
                if (val != null && val!= oldVal && val!= "") {
                     this.loadData();
                }
           },
           "quotaParams.examSubType":function(val, oldVal){
                if (val != null && val!= oldVal && val!= "") {
                    this.loadData();
                }
           }
        },
        mounted: function () {
            this.initDatatables();
        }
    });
    Vue.component('quota-info', quotaInfo);
});

</script>