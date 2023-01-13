<template>
    <form class="form-horizontal row-sm margin-top-10" id="fm-ident">
        <div class="form-group">
            <label class="control-label col-sm-1_5 required" v-text="pdmI18NList.personalIdentType">證件類型-t </label>
            <div class="col-sm-4 atosFocus">
                <select class="form-control select2" id="personalIdentType" name="personalIdentType" data-codeType="31001"></select>
            </div>
            <label class="control-label col-sm-1_5 required" v-text="pdmI18NList.personalIdentNo">證件編號-t </label>
            <div class="col-sm-4 atosFocus">
                <input v-model="pdmCautionCertInfoList.personalIdentNo" id="personalIdentNo" class="form-control" type="text" :placeholder="pdmI18NList.personalIdentNo" name="personalIdentNo">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.identLastNameCnOrFirstNameCn">證件中文姓/名-t </label>
            <div class="col-sm-4">
                <div class="input-group">
                    <input @blur="nameBlur('identLastNameCn')" v-model="pdmCautionCertInfoList.identLastNameCn" name="identLastNameCn" id="identLastNameCn" class="form-control" type="text"  :placeholder="pdmI18NList.identLastNameCn">
                    <span class="input-group-addon">/</span>
                    <input @blur="nameBlur('identFirstNameCn')" v-model="pdmCautionCertInfoList.identFirstNameCn" name="identFirstNameCn" id="identFirstNameCn" class="form-control" type="text" :placeholder="pdmI18NList.identFirstNameCn">
                </div>
            </div>

            <label class="control-label col-sm-1_5" v-text="pdmI18NList.identFullNameCn">證件中文全名-t </label>
            <div class="col-sm-4">
                <input @blur="nameBlur('identFullNameCn')" v-model="pdmCautionCertInfoList.identFullNameCn" id="identFullNameCn" class="form-control" type="text" name="identFullNameCn" :placeholder="pdmI18NList.identFullNameCn">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.identLastNameEnAndFirstNameEn">證件葡文姓/名 </label>
            <div class="col-sm-4">
                <div class="input-group">
                    <input @blur="nameBlur('identLastNameEn')" v-model="pdmCautionCertInfoList.identLastNameEn" class="form-control" type="text" :placeholder="pdmI18NList.identLastNameEn" name="identLastNameEn" id="identLastNameEn">
                    <span class="input-group-addon">/</span>
                    <input @blur="nameBlur('identFirstNameEn')" v-model="pdmCautionCertInfoList.identFirstNameEn" class="form-control" type="text" :placeholder="pdmI18NList.identFirstNameEn" name="identFirstNameEn" id="identFirstNameEn">
                </div>
            </div>
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.identfullNameEn">證件葡文全名 </label>
            <div class="col-sm-4">
                <input @blur="nameBlur('identfullNameEn')" v-model="pdmCautionCertInfoList.identfullNameEn" id="identfullNameEn" class="form-control" type="text" name="identfullNameEn" :placeholder="pdmI18NList.identfullNameEn">
            </div>
        </div>

        <div class="form-group" v-bind:class="{ hide: ishideprint }">
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.printLastNameCnOrFirstNameCn">列印中文姓/名 </label>
            <div class="col-sm-4">
                <div class="input-group">
                    <input maxlength="8" class="form-control" type="text" id="printLastNameCn" :placeholder="pdmI18NList.printLastNameCn" style="background-color: #fff;" v-model="pdmCautionCertInfoList.printLastNameCn">
                    <span class="input-group-addon">/</span>
                    <input maxlength="8" class="form-control" type="text" id="printFirstNameCn" :placeholder="pdmI18NList.printFirstNameCn" style="background-color: #fff;" v-model="pdmCautionCertInfoList.printFirstNameCn">
                </div>
            </div>

            <label class="control-label col-sm-1_5" v-text="pdmI18NList.printFullNameCn">列印中文全名 </label>
            <div class="col-sm-4">
                <input class="form-control" type="text" id="printFullNameCn" :placeholder="pdmI18NList.printFullNameCn" style="background-color: #fff;" v-model="pdmCautionCertInfoList.printFullNameCn">
            </div>
        </div>

        <div class="form-group" v-bind:class="{ hide: ishideprint }">
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.printLastNameEnAndFirstNameEn">列印葡文姓/名 </label>
            <div class="col-sm-4">
                <div class="input-group">
                    <input maxlength="20" class="form-control" type="text" id="printLastNameEn" :placeholder="pdmI18NList.printLastNameEn" style="background-color: #fff;" v-model="pdmCautionCertInfoList.printLastNameEn">
                    <span class="input-group-addon">/</span>
                    <input maxlength="20" class="form-control" type="text" id="printFirstNameEn" :placeholder="pdmI18NList.printFirstNameEn" style="background-color: #fff;" v-model="pdmCautionCertInfoList.printFirstNameEn">
                </div>
            </div>
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.printfullNameEn">列印葡文全名 </label>
            <div class="col-sm-4">
                <input class="form-control" id="printfullNameEn" type="text" :placeholder="pdmI18NList.printfullNameEn" style="background-color: #fff;" v-model="pdmCautionCertInfoList.printfullNameEn">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.issueAuthority">發出機構 </label>
            <div class="col-sm-4">
                <select class="form-control select2" id="issueAuthority" name="issueAuthority" data-codeType="31002"></select>
            </div>
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.issueDate">簽發日期 </label>
            <div class="col-sm-4 atosFocus">
                <input v-model="pdmCautionCertInfoList.issueDate" class="form-control  form-date" type="text" placeholder="dd/MM/yyyy" id="issueDate" name="issueDate">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.validDate">有效日期 </label>
            <div class="col-sm-4 atosFocus">
                <input v-model="pdmCautionCertInfoList.validDate" class="form-control  form-date" type="text" placeholder="dd/MM/yyyy" id="validDate" name="validDate">
            </div>
            <label class="control-label col-sm-1_5 " v-text="pdmI18NList.firstIssueDate">首次簽發日期 </label>
            <div class="col-sm-4 atosFocus">
                <input v-model="pdmCautionCertInfoList.firstIssueDate" class="form-control  form-date" type="text" id="firstIssueDate" placeholder="dd/MM/yyyy" name="firstIssueDate">
            </div>
        </div>


    </form>
</template>
<script>
define(['jquery','Vue','atosUtil','axios','vueloader','select2','select2.config','datetimepicker.config'],function($,Vue,atosUtil,axios){
	var pdmCautionCertInfo = Vue.extend({
        template:template,
        props:{
            usevalidator: {
	            type: Boolean,
	            default: false
            },
            ishideprint:{
                type:Boolean,
                default:true
            }
        },
        data:function(){
            return {
                pdmCautionCertInfoList:{
                    personalIdentType:'',
                    personalIdentNo:'',
                    identLastNameCn:'',
                    identFirstNameCn:'',
                    identFullNameCn:'',
                    identLastNameEn:'',
                    identFirstNameEn:'',
                    identfullNameEn:''
                },
                pdmI18NList:{
                    personalIdentNo:atosUtil.getI18nMessage('pdm.personalIdentNo'),
                    identLastNameCn:atosUtil.getI18nMessage('pdm.identLastNameCn'),
                    identFirstNameCn:atosUtil.getI18nMessage('pdm.identFirstNameCn'),
                    identFullNameCn:atosUtil.getI18nMessage('pdm.identFullNameCn'),
                    identLastNameEn:atosUtil.getI18nMessage('pdm.identLastNameEn'),
                    identFirstNameEn:atosUtil.getI18nMessage('pdm.identFirstNameEn'),
                    identfullNameEn:atosUtil.getI18nMessage('pdm.identfullNameEn'),
                    printLastNameCn:atosUtil.getI18nMessage('pdm.printLastNameCn'),
                    printFirstNameCn:atosUtil.getI18nMessage('pdm.printFirstNameCn'),
                    printFullNameCn:atosUtil.getI18nMessage('pdm.printFullNameCn'),
                    printLastNameEn:atosUtil.getI18nMessage('pdm.printLastNameEn'),
                    printFirstNameEn:atosUtil.getI18nMessage('pdm.printFirstNameEn'),
                    printfullNameEn:atosUtil.getI18nMessage('pdm.printfullNameEn'),
                    personalIdentType:atosUtil.getI18nMessage('pdm.personalIdentType'),
                    identLastNameCnOrFirstNameCn:atosUtil.getI18nMessage('pdm.identLastNameCnOrFirstNameCn'),
                    identLastNameEnAndFirstNameEn:atosUtil.getI18nMessage('pdm.identLastNameEnAndFirstNameEn'),
                    printLastNameCnOrFirstNameCn:atosUtil.getI18nMessage('pdm.printLastNameCnOrFirstNameCn'),
                    printLastNameEnAndFirstNameEn:atosUtil.getI18nMessage('pdm.printLastNameEnAndFirstNameEn'),
                    issueAuthority:atosUtil.getI18nMessage('pdm.issueAuthority'),
                    issueDate:atosUtil.getI18nMessage('pdm.issueDate'),
                    validDate:atosUtil.getI18nMessage('pdm.validDate'),
                    firstIssueDate:atosUtil.getI18nMessage('pdm.firstIssueDate')
                }
            }
        },
		methods:{
            nameBlur : function(nameId){

                var cnNamePatt = /^.*\s.*$/;

                var enNamePatt = /^.*\s\s.*$/;

                //中文姓事件
                if(nameId=='identLastNameCn'){
                    this.pdmCautionCertInfoList.identLastNameCn = this.pdmCautionCertInfoList.identLastNameCn.trim();

                    if(cnNamePatt.test(this.pdmCautionCertInfoList.identLastNameCn)){
                        $.alert({
                            text: '中文姓含有空格！'
                        });
                    }

                }

                //中文名事件
                if(nameId=='identFirstNameCn'){
                    this.pdmCautionCertInfoList.identFirstNameCn = this.pdmCautionCertInfoList.identFirstNameCn.trim();

                    if(cnNamePatt.test(this.pdmCautionCertInfoList.identFirstNameCn)){
                        $.alert({
                            text: '中文名含有空格！'
                        });
                    }
                }

                //中文姓/名改变
                if(nameId=='identLastNameCn'||nameId=='identFirstNameCn'){
                    this.pdmCautionCertInfoList.identFullNameCn = this.pdmCautionCertInfoList.identLastNameCn.trim() + this.pdmCautionCertInfoList.identFirstNameCn.trim();
                }

                //中文全名改变事件
                if(nameId=='identFullNameCn'){
                    this.pdmCautionCertInfoList.identFullNameCn = this.pdmCautionCertInfoList.identFullNameCn.trim();

                    if(cnNamePatt.test(this.pdmCautionCertInfoList.identFullNameCn)){
                        $.alert({
                            text: '中文全名含有空格！'
                        });
                    }
                }


                //葡文姓事件
                if(nameId=='identLastNameEn'){
                    //this.pdmCautionCertInfoList.identLastNameEn = this.pdmCautionCertInfoList.identLastNameEn.trim();
                    var str = this.pdmCautionCertInfoList.identLastNameEn.trim();
                    var temp = '';
                    for (var i = 0; i < str.length; i++) {
                        if (!str[i].match(/[\uff00-\uffff]/)) {
                            temp+=str[i];
                        }
                    }

                    this.pdmCautionCertInfoList.identLastNameEn = temp.toUpperCase();


                    if(enNamePatt.test(this.pdmCautionCertInfoList.identLastNameEn)){
                        $.alert({
                            text: '英文姓含有空格！'
                        });
                    }
                }

                //葡文名改变事件
                if(nameId=='identFirstNameEn'){
                    //debugger;
                    //this.pdmCautionCertInfoList.identFirstNameEn = this.pdmCautionCertInfoList.identFirstNameEn.trim();
                    var str = this.pdmCautionCertInfoList.identFirstNameEn.trim();
                    var temp = '';
                    for (var i = 0; i < str.length; i++) {
                        if (!str[i].match(/[\uff00-\uffff]/)) {
                            temp+=str[i];
                        }
                    }

                    this.pdmCautionCertInfoList.identFirstNameEn = temp.toUpperCase();




                    if(enNamePatt.test(this.pdmCautionCertInfoList.identFirstNameEn)){
                        $.alert({
                            text: '英文名含有空格！'
                        });
                    }
                }

                //葡文姓、名改变事件
                if(nameId=='identLastNameEn'||nameId=='identFirstNameEn'){
                    let length = this.pdmCautionCertInfoList.identLastNameEn.trim().length + this.pdmCautionCertInfoList.identFirstNameEn.trim().length;
                    if(length>0){
                        if(this.pdmCautionCertInfoList.identLastNameEn.trim().length>0&&this.pdmCautionCertInfoList.identFirstNameEn.trim().length>0){
                            this.pdmCautionCertInfoList.identfullNameEn = this.pdmCautionCertInfoList.identLastNameEn.trim() +" "+ this.pdmCautionCertInfoList.identFirstNameEn.trim();
                        }else{
                            this.pdmCautionCertInfoList.identfullNameEn = this.pdmCautionCertInfoList.identLastNameEn.trim() + this.pdmCautionCertInfoList.identFirstNameEn.trim();
                        }

                    }

                    if(length==0){
                        this.pdmCautionCertInfoList.identfullNameEn = "";
                    }
                }

                //葡文全名改变事件
                if(nameId=='identfullNameEn'){
                    //this.pdmCautionCertInfoList.identfullNameEn = this.pdmCautionCertInfoList.identfullNameEn.trim();
                    var str = this.pdmCautionCertInfoList.identfullNameEn.trim();
                    var temp = '';
                    for (var i = 0; i < str.length; i++) {
                        if (!str[i].match(/[\uff00-\uffff]/)) {
                            temp+=str[i];
                        }
                    }

                    this.pdmCautionCertInfoList.identfullNameEn = temp.toUpperCase();



                    if(enNamePatt.test(this.pdmCautionCertInfoList.identfullNameEn)){
                        $.alert({
                            text: '英文全名含有空格！'
                        });
                    }
                }

            },
		    initDatetimepicker:function(){
		        var self = this;
		        var sysDateText = atosUtil.getSysDate(); // 獲取系統時間字符串
                var sysDate = atosUtil.dateToDate(sysDateText); // 變成date類型
		        //簽發日期
                $('#issueDate').datetimepicker({
                    trigger:'change',
                    endDate: sysDate
                }).on('changeDate', function(ev) {
                    self.pdmCautionCertInfoList.issueDate = ev.date.format("dd/MM/yyyy");
                }).on('hide',function(){
                    $('#fm-ident').data('bootstrapValidator')
                    .updateStatus('issueDate', 'NOT_VALIDATED',null)
                    .validateField('issueDate');
                });;

                 $('#validDate').datetimepicker({//有效日期
                    trigger:'change',
                    startDate: sysDate
                }).on('changeDate', function(ev) {
                    self.pdmCautionCertInfoList.validDate = ev.date.format("dd/MM/yyyy");
                }).on('hide',function(){
                    $('#fm-ident').data('bootstrapValidator')
                    .updateStatus('validDate', 'NOT_VALIDATED',null)
                    .validateField('validDate');
                });;

                $('#firstIssueDate').datetimepicker({//首次簽發日期
                    trigger:'change',
                    endDate: sysDate
                }).on('changeDate', function(ev) {
                    self.pdmCautionCertInfoList.firstIssueDate = ev.date.format("dd/MM/yyyy");
                }).on('hide',function(){
                    $('#fm-ident').data('bootstrapValidator')
                    .updateStatus('firstIssueDate', 'NOT_VALIDATED',null)
                    .validateField('firstIssueDate');
                });;
		    },
    		initEvent:function(){
                var self = this;
                var useValidator = this.usevalidator;//是否使用校驗
                $("#personalIdentType").select2Remote({
                    url: basePath + '/select2/page'
                });



                $("#personalIdentType").on('change', function () {
                    self.pdmCautionCertInfoList.personalIdentType = $(this).val();
                    if(useValidator){
                        $('#fm-ident').data('bootstrapValidator').updateStatus("personalIdentNo","NOT_VALIDATED",null);
                        if($('#personalIdentNo').val()!=''){
                            var personalIdentType = $('#personalIdentType').val();
                            var personalIdentNo = $('#personalIdentNo').val();
                            axios.post(basePath + '/pdm/driver/checkIdentExistOrNotByIdentTypeAndIdentNo',{'personalIdentNo':personalIdentNo,'personalIdentType':personalIdentType}).then(function(isIdentInfoExist){
                                if(isIdentInfoExist==true){
                                    $('#fm-ident').data('bootstrapValidator').updateMessage('personalIdentNo', 'callback',atosUtil.getI18nMessage('pdm.certIsExistDiff'));
                                    $('#fm-ident').data('bootstrapValidator').updateStatus("personalIdentNo","INVALID",null);
                                }

                                if(isIdentInfoExist.data==false){
                                    $('#fm-ident').data('bootstrapValidator').validateField('personalIdentNo');
                                }
                            });

                        }
                    }


                    if(self.pdmCautionCertInfoList.personalIdentType=='BM'){
                        axios.get(basePath + '/select2/data4show',{params: {codeType:31002, queryString:'SIM'}}).then(function(pdaResponse){
                            $("#issueAuthority").append("<option selected value='"+pdaResponse[0].id+"'>"+pdaResponse[0].description+"</option>").trigger("change");
                        });

                    }
                });

                $('#personalIdentNo').on('blur',function(){
                   if(useValidator){
                        if($('#personalIdentType').val()!=null&&$('#personalIdentNo').val()!=''){
                            $('#fm-ident').data('bootstrapValidator').updateStatus("personalIdentNo","NOT_VALIDATED",null);
                            var personalIdentType = $('#personalIdentType').val();
                            var personalIdentNo = $('#personalIdentNo').val();

                            axios.post(basePath + '/pdm/driver/checkIdentExistOrNotByIdentTypeAndIdentNo',{'personalIdentNo':personalIdentNo,'personalIdentType':personalIdentType}).then(function(isIdentInfoExist){
                                if(isIdentInfoExist==true){
                                    $('#fm-ident').data('bootstrapValidator').updateMessage('personalIdentNo', 'callback',atosUtil.getI18nMessage('pdm.certIsExistDiff'));
                                    $('#fm-ident').data('bootstrapValidator').updateStatus("personalIdentNo","INVALID",null);
                                }

                                if(isIdentInfoExist.data==false){
                                    $('#fm-ident').data('bootstrapValidator').validateField('personalIdentNo');
                                }
                            });
                        }
                    }
                })

                //中文姓名改變
                $('#identLastNameCn,#identFirstNameCn').on('input',function(){
                    $('#identFullNameCn').val($("#identLastNameCn").val()+""+$("#identFirstNameCn").val());
                    self.pdmCautionCertInfoList.identFullNameCn = $("#identLastNameCn").val()+""+$("#identFirstNameCn").val();
                })

                //葡文姓名改變
                $('#identLastNameEn,#identFirstNameEn').on('input',function(){
                    if($('#identLastNameEn').val()!=''){
                        $('#identfullNameEn').val($("#identLastNameEn").val()+" "+$("#identFirstNameEn").val()).trigger('input');
                        self.pdmCautionCertInfoList.identfullNameEn = $("#identLastNameEn").val()+" "+$("#identFirstNameEn").val();
                    }else{
                        $('#identfullNameEn').val($("#identLastNameEn").val()+""+$("#identFirstNameEn").val()).trigger('input');
                        self.pdmCautionCertInfoList.identfullNameEn = $("#identLastNameEn").val()+""+$("#identFirstNameEn").val();
                        }
                })

                //發出機構
                 $("#issueAuthority").on('change', function () {
                    self.pdmCautionCertInfoList.issueAuthority = $(this).val();
                });








                $("#issueAuthority").select2Remote({
                    url: basePath + '/select2/page'
                });







                var useValidator = this.usevalidator;
                Vue.nextTick(function(){
                    if(useValidator){
                        $('#fm-ident').bootstrapValidator({
                            fields: {
                                personalIdentType: {
                                    validators: {
                                        notEmpty: {
                                            //message: '不能為空'
                                        }
                                    }
                                },
                                issueDate: {
                                    validators: {
                                        date : {
                                            format : 'DD/MM/YYYY',
                                            message : '日期格式不合法'
                                        }
                                    }
                                },
                                validDate: {
                                    validators: {
                                        date : {
                                            format : 'DD/MM/YYYY',
                                            message : '日期格式不合法'
                                        }
                                    }
                                },
                                firstIssueDate: {
                                    validators: {
                                        date : {
                                            format : 'DD/MM/YYYY',
                                            message : '日期格式不合法'
                                        }
                                    }
                                },
                                personalIdentNo: {
                                                                    validators: {
                                    callback: {
                                        message: atosUtil.getI18nMessage('pdm.personalIdentNo.BM'),
                                        callback : function(value, validator) {
                                            if(self.pdmCautionCertInfoList.personalIdentType=='BM') {//澳門身份證
                                                //8位數字
                                                var patt = /^(\d{8})?$/;
                                                if(!patt.test(value)){
                                                    validator.updateMessage('personalIdentNo', 'callback', atosUtil.getI18nMessage('pdm.personalIdentNo.BM'));
                                                    return false;
                                                }else if(value==''){
                                                    return false;
                                                }else{
                                                    return true;
                                                }
                                            }else{
                                                var patt = /^[0-9A-Za-z]{1,50}$/;
                                                if(!patt.test(value)){
                                                    return {
                                                        valid: false,
                                                        message: atosUtil.getI18nMessage('pdm.personalIdentNo.validChar')
                                                    }
                                                }else {
                                                    return true;
                                                }
                                                return true;
                                            }
                                        }
                                    }

                                }
                                },
                            }
                        });

                        $('#fm-ident :input.form-control').closest('.form-group, [class*="col-"]').addClass('form-validator has-feedback');

                    }
                })






            },
		},
		mounted:function(){
		    this.initDatetimepicker();
            this.initEvent();
		}
	})
    Vue.component('pdm-caution-cert-info',pdmCautionCertInfo);
});

</script>

