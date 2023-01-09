<template>
  <div v-show="show">
    <div class="form-group">
        <div class="col-sm-12">
            <h4>{{i18n["healthCert"]}}</h4>
        </div>
    </div>
      <form id="healthCertForm">
        <div class="form-group " >
            <label class="control-label col-sm-1">{{i18n["healthCert.issueDate"]}}</label>
            <div class="col-sm-1_5 validClass">
                <input type="text" name="healthCertIssueDate" id="healthCertIssueDate"  class="form-control datepicker" value="" v-model="spTxn.hcIssueDate">
            </div>
            <label class="control-label col-sm-1"><strong>{{i18n["healthCert.duration"]}}</strong><br></label>
            <div class="col-sm-2_5">
                <div class="input-group">
                   <!-- <input class="form-control text-right " type="text" value="" id="hcRecheckDuration"
                        v-model="spTxn.hcRecheckDuration" v-on:blur="doCalHealthCertValidDate()">-->
                     <input class="form-control text-right " type="text" value="" id="hcRecheckDuration"
                        v-model="spTxn.hcRecheckDuration">
                    <span class="input-group-addon">{{i18n["healthCert.month"]}}</span>
                </div>
            </div>
            <label class="control-label col-sm-1">{{i18n["healthCert.validDate"]}}</label>
            <div class="col-sm-2 validClass">
                <input id="healthCertValidDate" name="healthCertValidDate" class="form-control datepicker "
                    type="text" v-model="spTxn.hcValidDate" value="">
            </div>
            <label class="control-label col-sm-1"></label>
        </div>
      </form>
  </div>
</template>

<script>


define(['jquery',"atosUtil","moment.config",'Vue','vueloader','bootstrapValidator','bootstrapValidator.config','datetimepicker.config'],function($,atosUtil,momentConfig,Vue){
    var licHealthCert = Vue.extend({
        template:template,
         props: {
                show: {
                    type: Boolean,
                    default: false
                },
                value:{type:Object},
            },
          created:function(){
            var self = this;
            atosUtil.getLocalI18nByModules("comps",function (pdaResponse) {
                self.i18n = pdaResponse;
            });
            this.initData();
          },
          data:function(){
                return {
                    i18n:null,
                    spTxn: {
                        spNo: '',
                        caseNo: '',
                        hcIssueDate: '',
                        hcRecheckDuration: '',
                        hcValidDate: ''
                    },
                }
            },
            methods:{
                initData:function(){
                },
                loadData:function(){
                    var self = this;
                    if(self.value){
                        self.spTxn = self.value;
                    }
                },
                doCalHealthCertValidDate: function(){
                    var self = this;
                    var issueDate = self.spTxn.hcIssueDate;
                    var recheckDuration = self.spTxn.hcRecheckDuration;
                    if(recheckDuration && issueDate){
                        var validDate = atosUtil.addMonth(issueDate, recheckDuration);
                        validDate = atosUtil.addDay(validDate,-1);
                        $('#healthCertValidDate').val(validDate);
                        self.spTxn.hcValidDate = validDate;
                        $("#healthCertValidDate").trigger("change");
                    }

                },

                doValidForm :function(){
                    // 當前最近的form元素 存在
                    if (!$.formValidator('#healthCertForm')) {
                        return false;
                    }else
                        return true;
                },
                initFormValidate:function() {
                    var self = this;
                       $("#healthCertForm").bootstrapValidator({
                            fields:{
                                healthCertValidDate:{
                                    trigger: 'change',
                                    validators:{
                                        callback:{
                                            callback:function (value, validator) {
                                                // if (self.spTxn.hcIssueDate && self.spTxn.hcRecheckDuration && !self.spTxn.hcValidDate) {
                                                //     validator.updateMessage("healthCertValidDate","callback",self.i18n["healthCert.msg.validDateIsNull"]);
                                                //     return false;
                                                // }
                                                return true;
                                            },
                                            message: self.i18n["not.validated"]
                                        }
                                    }
                                },
                                healthCertIssueDate:{
                                    validators : {
                                        date : {
                                            format : 'DD/MM/YYYY',
                                            message : atosUtil.getI18nMessage("license.dateFormat")
                                        },
                                        callback : {
                                            callback : function(value, validator){
                                            
                                                var arr = new Date(momentConfig.dateTimeFormat(value, "DD/MM/YYYY", "YYYY/MM/DD")).getTime();
                                                if(arr < new Date("1900/01/01").getTime() || arr > new Date().getTime() ){
                                                    return false;
                                                }
                                                return true;
                                            },
                                            message : atosUtil.getI18nMessage("license.dateToday")
                                        }
                                    }
                                },
                                healthCertValidDate:{
                                    validators : {
                                        date: {
                                            format: 'DD/MM/YYYY',
                                            message: atosUtil.getI18nMessage("license.dateFormat")
                                        },
                                        callback: {
                                            callback: function (value, validator) {
                                                var arr = value.split("/");
                                                if (parseInt(arr[2]) < 1900 || parseInt(arr[2]) > 9999) {
                                                    return false;
                                                }
                                                return true;
                                            },
                                            message: atosUtil.getI18nMessage("license.dateRange")
                                        }
                                    }
                                }
                            }
                        })
                },
                initDatePicker:function(){
                  var self = this;
                  
                  $('#healthCertIssueDate').datetimepicker({
                      endDate:atosUtil.dateToDate(self.spTxn.hcIssueDate),
                  }).on('change',function(ev){
                      self.spTxn.hcIssueDate = $(this).val();
                  }).on('hide',function(){
                      $('#healthCertForm').data('bootstrapValidator')
                      .updateStatus('healthCertIssueDate', 'NOT_VALIDATED',null)  
                      .validateField('healthCertIssueDate'); 
                  });
                  
                  $('#healthCertValidDate').datetimepicker({
                      startDate:atosUtil.dateToDate(self.spTxn.hcIssueDate),
                  }).on('change',function(ev){
                      self.spTxn.hcValidDate = $(this).val();
                  }).on('hide',function(){
                      $('#healthCertForm').data('bootstrapValidator')
                      .updateStatus('healthCertValidDate', 'NOT_VALIDATED',null)  
                      .validateField('healthCertValidDate'); 
                  });
                }

            },
            watch:{
                value:function(val){
                    if (val){
                        this.loadData();
                    }
                }
            },
            mounted: function () {
                var self = this;
                self.loadData();
                // 日期組件需要在組件渲染完成後再初始化
                self.initDatePicker();
                self.initFormValidate();
                $(".validClass").addClass("form-validator has-feedback");

            }
    })
    Vue.component('lic-health-cert', licHealthCert);
});

</script>
