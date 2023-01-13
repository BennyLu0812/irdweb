<template>
    <form class="form-horizontal row-sm margin-top-10" id="fm-ident">
        <div class="form-group">
            <label class="control-label col-sm-1_5 required" v-text="pdmI18NList.personalIdentType">證件類型-t </label>
            <div class="col-sm-4">
                <select class="form-control select2" id="personalIdentType" name="personalIdentType" data-codeType="31001"></select>
            </div>
            <label class="control-label col-sm-1_5 required" v-text="pdmI18NList.personalIdentNo">證件編號-t </label>
            <div class="col-sm-4">
                <input v-model="pdmCautionCertInfoList.personalIdentNo" id="personalIdentNo" class="form-control" type="text" :placeholder="pdmI18NList.personalIdentNo" name="personalIdentNo">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.identLastNameCnOrFirstNameCn">證件中文姓/名-t </label>
            <div class="col-sm-4">
                <div class="input-group">
                    <input @blur="nameBlur('identLastNameCn')" data-bv-stringlength="false" v-model="pdmCautionCertInfoList.identLastNameCn" v-bind:maxlength="pdmnameparammap['dlsPdmIdLastNameCnLen']" name="identName" id="identLastNameCn" class="form-control" type="text"  :placeholder="pdmI18NList.identLastNameCn">
                    <span class="input-group-addon">/</span>
                    <input @blur="nameBlur('identFirstNameCn')" style="border-top-right-radius:4px;border-bottom-right-radius:4px" data-bv-stringlength="false" v-model="pdmCautionCertInfoList.identFirstNameCn" v-bind:maxlength="pdmnameparammap['dlsPdmIdFirstNameCnLen']" name="identName" id="identFirstNameCn" class="form-control" type="text" :placeholder="pdmI18NList.identFirstNameCn">
                </div>
            </div>

            <label class="control-label col-sm-1_5" v-text="pdmI18NList.identFullNameCn">證件中文全名-t </label>
            <div class="col-sm-4">
                <input @blur="nameBlur('identFullNameCn')" data-bv-stringlength="false" v-model="pdmCautionCertInfoList.identFullNameCn" v-bind:maxlength="pdmnameparammap['dlsPdmIdFullNameCnLen']" id="identFullNameCn" class="form-control" type="text" name="identName" :placeholder="pdmI18NList.identFullNameCn">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.identLastNameEnAndFirstNameEn">證件葡文姓/名 </label>
            <div class="col-sm-4">
                <div class="input-group">
                    <input @blur="nameBlur('identLastNameEn')" data-bv-stringlength="false" v-model="pdmCautionCertInfoList.identLastNameEn" v-bind:maxlength="pdmnameparammap['dlsPdmIdLastNameEnLen']" class="form-control" type="text" :placeholder="pdmI18NList.identLastNameEn" name="identName" id="identLastNameEn">
                    <span class="input-group-addon">/</span>
                    <input @blur="nameBlur('identFirstNameEn')" style="border-top-right-radius:4px;border-bottom-right-radius:4px" data-bv-stringlength="false" v-model="pdmCautionCertInfoList.identFirstNameEn" v-bind:maxlength="pdmnameparammap['dlsPdmIdFirstNameEnLen']" class="form-control" type="text" :placeholder="pdmI18NList.identFirstNameEn" name="identName" id="identFirstNameEn">
                </div>
            </div>
            <label class="control-label col-sm-1_5" th:text="#{pdm.identfullNameEn}">證件葡文全名 </label>
            <div class="col-sm-4">
                <input @blur="nameBlur('identfullNameEn')" data-bv-stringlength="false" v-model="pdmCautionCertInfoList.identfullNameEn" v-bind:maxlength="pdmnameparammap['dlsPdmIdfullNameEnLen']" id="identfullNameEn" class="form-control" type="text" name="identName" :placeholder="pdmI18NList.identfullNameEn">
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
            <label class="control-label col-sm-1_5 required" v-text="pdmI18NList.issueAuthority">發出機構 </label>
            <div class="col-sm-4">
                <select class="form-control select2" id="issueAuthority" name="issueAuthority" data-codeType="31002"></select>
            </div>
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.issueDate">簽發日期 </label>
            <div class="col-sm-4">
                <input v-model="pdmCautionCertInfoList.issueDate" class="form-control  form-date" type="text" placeholder="dd/MM/yyyy" id="issueDate" name="issueDate">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.validDate">有效日期 </label>
            <div class="col-sm-4">
                <input v-model="pdmCautionCertInfoList.validDate" class="form-control  form-date" type="text" placeholder="dd/MM/yyyy" id="validDate" name="validDate">
            </div>
            <label class="control-label col-sm-1_5 " v-text="pdmI18NList.firstIssueDate">首次簽發日期 </label>
            <div class="col-sm-4">
                <input v-model="pdmCautionCertInfoList.firstIssueDate" class="form-control  form-date" type="text" id="firstIssueDate" placeholder="dd/MM/yyyy">
            </div>
        </div>


    </form>
</template>
<script>
define(['jquery','Vue','atosUtil','vueloader','select2','select2.config','datetimepicker.config'],function($,Vue,atosUtil){
	var pdmTemporaryCertInfo = Vue.extend({
        template:template,
        props:{
            usevalidator: {
	            type: Boolean,
	            default: false
            },
            ishideprint:{
                type:Boolean,
                default:true
            },
            pdmnameparammap:{
                type:Object
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
                    identFirstNameEn:''
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
                    //alert(nameId)
                var useValidator = this.usevalidator;//是否使用校驗
                var dlsPdmIdColorChangeCn = this.pdmnameparammap['dlsPdmIdColorChangeCn'];//中文顏色改變的長度
                var dlsPdmIdColorChangePt = this.pdmnameparammap['dlsPdmIdColorChangePt'];//葡文顏色改變的長度
                var dlsPdmIdFullNameCnLen = this.pdmnameparammap['dlsPdmIdFullNameCnLen'];//中文全名的最大長度
                var dlsPdmIdfullNameEnLen = this.pdmnameparammap['dlsPdmIdfullNameEnLen'];//葡文全名的最大長度
                var dlsPdmPrFullNameCnLen = this.pdmnameparammap['dlsPdmPrFullNameCnLen'];//列印中文全名的最大長度
                var dlsPdmPrfullNameEnLen = this.pdmnameparammap['dlsPdmPrfullNameEnLen'];//列印葡文全名的最大長度

                // console.log(useValidator)
                // console.log(dlsPdmIdColorChangeCn)
                // console.log(dlsPdmIdColorChangePt)
                // console.log(dlsPdmIdFullNameCnLen)
                // console.log(dlsPdmIdfullNameEnLen)
                // console.log(dlsPdmPrFullNameCnLen)
                // console.log(dlsPdmPrfullNameEnLen)

                var cnNamePatt = /^.*\s.*$/;

                var enNamePatt = /^.*\s\s.*$/;



                //中文姓事件
                if(nameId=='identLastNameCn'){
                    //console.log(this.pdmCautionCertInfoList.identLastNameCn.trim())
                    this.pdmCautionCertInfoList.identLastNameCn = this.pdmCautionCertInfoList.identLastNameCn.trim();
                    $('#identLastNameCn').val(this.pdmCautionCertInfoList.identLastNameCn);//用于触发校验
                    let length = this.pdmCautionCertInfoList.identLastNameCn.length;
                    if(useValidator){
                        if(length>=dlsPdmIdColorChangeCn){
                            $('#identLastNameCn').css('border-color','orange');
                        }else{
                            $('#identLastNameCn').css('border-color','');
                        }
                    }

                    if(!useValidator){
                        if(length>=dlsPdmIdColorChangeCn){
                            $('#identLastNameCn').css('border-color','orange');
                        }else{
                            $('#identLastNameCn').css('border-color','#ccc');
                        }
                    }

                    if(cnNamePatt.test(this.pdmCautionCertInfoList.identLastNameCn)){
                        $.alert({
                            text: '中文姓含有空格！'
                        });
                    }
                }

                //中文名事件
                if(nameId=='identFirstNameCn'){
                    this.pdmCautionCertInfoList.identFirstNameCn = this.pdmCautionCertInfoList.identFirstNameCn.trim();
                    $('#identFirstNameCn').val(this.pdmCautionCertInfoList.identFirstNameCn);//用于触发校验
                    let length = this.pdmCautionCertInfoList.identFirstNameCn.length;
                    if(useValidator){
                        if(length>=dlsPdmIdColorChangeCn){
                            $('#identFirstNameCn').css('border-color','orange');
                        }else{
                            $('#identFirstNameCn').css('border-color','');
                        }
                    }

                    if(!useValidator){
                        if(length>=dlsPdmIdColorChangeCn){
                            $('#identFirstNameCn').css('border-color','orange');
                        }else{
                            $('#identFirstNameCn').css('border-color','#ccc');
                        }
                    }

                    if(cnNamePatt.test(this.pdmCautionCertInfoList.identFirstNameCn)){
                        $.alert({
                            text: '中文名含有空格！'
                        });
                    }


                }

                //中文姓/名改变
                if(nameId=='identLastNameCn'||nameId=='identFirstNameCn'){
                    let length = 0;
                    if(atosUtil.isNotEmpty(this.pdmCautionCertInfoList.identLastNameCn)){
                        length += this.pdmCautionCertInfoList.identLastNameCn.trim().length;
                    }
                    if(atosUtil.isNotEmpty(this.pdmCautionCertInfoList.identFirstNameCn)){
                        length += this.pdmCautionCertInfoList.identFirstNameCn.trim().length;
                    }
                    if(length<=dlsPdmIdFullNameCnLen){
                        this.pdmCautionCertInfoList.identFullNameCn = '';
                        if(atosUtil.isNotEmpty(this.pdmCautionCertInfoList.identLastNameCn)){
                            this.pdmCautionCertInfoList.identFullNameCn += this.pdmCautionCertInfoList.identLastNameCn.trim();
                        }
                        if(atosUtil.isNotEmpty(this.pdmCautionCertInfoList.identFirstNameCn)){
                            this.pdmCautionCertInfoList.identFullNameCn += this.pdmCautionCertInfoList.identFirstNameCn;
                        }
                        $('#identFullNameCn').val(this.pdmCautionCertInfoList.identFullNameCn);//用于触发校验
                    }
                    if(useValidator){
                        if(length>=dlsPdmIdColorChangeCn){
                            $('#identFullNameCn').css('border-color','orange');
                        }else{
                            $('#identFullNameCn').css('border-color','');
                        }
                    }
                    if(!useValidator){
                        if(length>=dlsPdmIdColorChangeCn){
                            $('#identFullNameCn').css('border-color','orange');
                        }else{
                            $('#identFullNameCn').css('border-color','#ccc');
                        }
                    }
                }

                //中文全名改变事件
                if(nameId=='identFullNameCn'){
                    this.pdmCautionCertInfoList.identFullNameCn = this.pdmCautionCertInfoList.identFullNameCn.trim();
                    $('#identFullNameCn').val(this.pdmCautionCertInfoList.identFullNameCn);//用于触发校验
                    let length = this.pdmCautionCertInfoList.identFullNameCn.length;
                    if(useValidator){
                        if(length>=dlsPdmIdColorChangeCn){
                            $('#identFullNameCn').css('border-color','orange');
                        }else{
                            $('#identFullNameCn').css('border-color','');
                        }
                    }

                    if(!useValidator){
                        if(length>=dlsPdmIdColorChangeCn){
                            $('#identFullNameCn').css('border-color','orange');
                        }else{
                            $('#identFullNameCn').css('border-color','#ccc');
                        }
                    }

                    if(cnNamePatt.test(this.pdmCautionCertInfoList.identFullNameCn)){
                        $.alert({
                            text: '中文全名含有空格！'
                        });
                    }
                }


                //葡文姓事件
                if(nameId=='identLastNameEn'){
                    this.pdmCautionCertInfoList.identLastNameEn = this.pdmCautionCertInfoList.identLastNameEn.trim();
                    $('#identLastNameEn').val(this.pdmCautionCertInfoList.identLastNameEn);//用于触发校验
                    let length = this.pdmCautionCertInfoList.identLastNameEn.length;
                    if(useValidator){
                        if(length>=dlsPdmIdColorChangePt){
                            $('#identLastNameEn').css('border-color','orange');
                        }else{
                            $('#identLastNameEn').css('border-color','');
                        }
                    }

                    if(!useValidator){
                        if(length>=dlsPdmIdColorChangePt){
                            $('#identLastNameEn').css('border-color','orange');
                        }else{
                            $('#identLastNameEn').css('border-color','#ccc');
                        }
                    }

                    if(enNamePatt.test(this.pdmCautionCertInfoList.identLastNameEn)){
                        $.alert({
                            text: '英文姓含有空格！'
                        });
                    }
                }

                //葡文名改变事件
                if(nameId=='identFirstNameEn'){
                    this.pdmCautionCertInfoList.identFirstNameEn = this.pdmCautionCertInfoList.identFirstNameEn.trim();
                    $('#identFirstNameEn').val(this.pdmCautionCertInfoList.identFirstNameEn);//用于触发校验
                    let length = this.pdmCautionCertInfoList.identFirstNameEn.length;
                    if(useValidator){
                        if(length>=dlsPdmIdColorChangePt){
                            $('#identFirstNameEn').css('border-color','orange');
                        }else{
                            $('#identFirstNameEn').css('border-color','');
                        }
                    }

                    if(!useValidator){
                        if(length>=dlsPdmIdColorChangePt){
                            $('#identFirstNameEn').css('border-color','orange');
                        }else{
                            $('#identFirstNameEn').css('border-color','#ccc');
                        }
                    }

                    if(enNamePatt.test(this.pdmCautionCertInfoList.identFirstNameEn)){
                        $.alert({
                            text: '英文名含有空格！'
                        });
                    }
                }

                //葡文姓、名改变事件
                if(nameId=='identLastNameEn'||nameId=='identFirstNameEn'){

                    let length = 0;

                    let lastNameLength = 0;
                    let firstNameLength = 0;

                    if(atosUtil.isNotEmpty(this.pdmCautionCertInfoList.identLastNameEn)){
                        lastNameLength = this.pdmCautionCertInfoList.identLastNameEn.trim().length;
                        length += this.pdmCautionCertInfoList.identLastNameEn.trim().length;
                    }

                    if(atosUtil.isNotEmpty(this.pdmCautionCertInfoList.identFirstNameEn)){
                        firstNameLength = this.pdmCautionCertInfoList.identFirstNameEn.trim().length;
                        length += this.pdmCautionCertInfoList.identFirstNameEn.trim().length;
                    }

                    console.log(length)

                    //let length = this.pdmCautionCertInfoList.identLastNameEn.trim().length + this.pdmCautionCertInfoList.identFirstNameEn.trim().length;





                    if(length>0&&length<=dlsPdmIdfullNameEnLen){

                        if(lastNameLength>0&&firstNameLength>0){
                            this.pdmCautionCertInfoList.identfullNameEn = this.pdmCautionCertInfoList.identLastNameEn.trim() +" "+ this.pdmCautionCertInfoList.identFirstNameEn.trim();
                        }

                        if(lastNameLength>0&&firstNameLength==0){
                            this.pdmCautionCertInfoList.identfullNameEn = this.pdmCautionCertInfoList.identLastNameEn.trim();
                        }

                        if(lastNameLength==0&&firstNameLength>0){
                            this.pdmCautionCertInfoList.identfullNameEn = this.pdmCautionCertInfoList.identFirstNameEn.trim();
                        }

                    }

                    if(length==0){
                        this.pdmCautionCertInfoList.identfullNameEn = "";
                    }

                    $('#identfullNameEn').val(this.pdmCautionCertInfoList.identfullNameEn);//用于触发校验

                    if(useValidator){
                        if(length>=dlsPdmIdColorChangePt){
                            $('#identfullNameEn').css('border-color','orange');
                        }else{
                            $('#identfullNameEn').css('border-color','');
                        }
                    }

                    if(!useValidator){
                        if(length>=dlsPdmIdColorChangePt){
                            $('#identfullNameEn').css('border-color','orange');
                        }else{
                            $('#identfullNameEn').css('border-color','#ccc');
                        }
                    }
                }

                //葡文全名改变事件
                if(nameId=='identfullNameEn'){
                    this.pdmCautionCertInfoList.identfullNameEn = this.pdmCautionCertInfoList.identfullNameEn.trim();
                    $('#identfullNameEn').val(this.pdmCautionCertInfoList.identfullNameEn);//用于触发校验
                    let length = this.pdmCautionCertInfoList.identfullNameEn.length;
                    if(useValidator){
                        if(length>=dlsPdmIdColorChangePt){
                            $('#identfullNameEn').css('border-color','orange');
                        }else{
                            $('#identfullNameEn').css('border-color','');
                        }
                    }

                    if(!useValidator){
                        if(length>=dlsPdmIdColorChangePt){
                            $('#identfullNameEn').css('border-color','orange');
                        }else{
                            $('#identfullNameEn').css('border-color','#ccc');
                        }
                    }

                    if(enNamePatt.test(this.pdmCautionCertInfoList.identFullNameEn)){
                        $.alert({
                            text: '英文全名含有空格！'
                        });
                    }
                }

                if(useValidator){
                    if($('#fm-ident').data('bootstrapValidator')!=undefined) {
                        $('#fm-ident').data('bootstrapValidator')
                            .updateStatus('identName', 'NOT_VALIDATED',null)
                            .validateField('identName');
                    }

                }
            },
    		initEvent:function(){
                var self = this;
                var useValidator = this.usevalidator;//是否使用校驗
                var dlsPdmIdColorChangeCn = this.pdmnameparammap['dlsPdmIdColorChangeCn'];//中文顏色改變的長度
                var dlsPdmIdColorChangePt = this.pdmnameparammap['dlsPdmIdColorChangePt'];//葡文顏色改變的長度
                var dlsPdmIdFullNameCnLen = this.pdmnameparammap['dlsPdmIdFullNameCnLen'];//中文全名的最大長度
                var dlsPdmIdfullNameEnLen = this.pdmnameparammap['dlsPdmIdfullNameEnLen'];//葡文全名的最大長度
                var dlsPdmPrFullNameCnLen = this.pdmnameparammap['dlsPdmPrFullNameCnLen'];//列印中文全名的最大長度
                var dlsPdmPrfullNameEnLen = this.pdmnameparammap['dlsPdmPrfullNameEnLen'];//列印葡文全名的最大長度


                $("#personalIdentType").select2Remote({
                    url: basePath + '/select2/page'
                });

                $("#personalIdentType").on('change', function () {
                    if(useValidator){
                        if($('#fm-ident').data('bootstrapValidator')!=undefined){
                            $('#fm-ident').data('bootstrapValidator').updateStatus("personalIdentNo","NOT_VALIDATED",null);
                            if($('#personalIdentNo').val()!=''){
                                $('#fm-ident').data('bootstrapValidator').validateField('personalIdentNo');
                            }
                        }
                    }
                    self.pdmCautionCertInfoList.personalIdentType = $(this).val();
                });


                //中文姓名改變
                $('#identLastNameCn,#identFirstNameCn').on('input',function(){
                    var id = $(this).attr('id');
                    var length = $(this).val().length;

                    var identFullNameLength = $('#identLastNameCn').val().length + $('#identFirstNameCn').val().length;
                    if(identFullNameLength<=dlsPdmIdFullNameCnLen){
                        $('#identFullNameCn').val($("#identLastNameCn").val()+""+$("#identFirstNameCn").val()).trigger("input");
                        self.pdmCautionCertInfoList.identFullNameCn = $("#identLastNameCn").val()+""+$("#identFirstNameCn").val();
                    }

                    if(useValidator){
                        if($('#fm-ident').data('bootstrapValidator')!=undefined) {
                            $('#fm-ident').data('bootstrapValidator')
                            .updateStatus('identName', 'NOT_VALIDATED',null)
                            .validateField('identName');
                        }

                    }

                    if(id=='identLastNameCn'){
                        if(useValidator){
                            if(length>=dlsPdmIdColorChangeCn){
                                $('#identLastNameCn').css('border-color','orange');
                            }else{
                                $('#identLastNameCn').css('border-color','');
                            }
                        }

                        if(!useValidator){
                            if(length>=dlsPdmIdColorChangeCn){
                                $('#identLastNameCn').css('border-color','orange');
                            }else{
                                $('#identLastNameCn').css('border-color','#ccc');
                            }
                        }
                    }

                    if(id=='identFirstNameCn'){
                        if(useValidator){
                            if(length>=dlsPdmIdColorChangeCn){
                                $('#identFirstNameCn').css('border-color','orange');
                            }else{
                                $('#identFirstNameCn').css('border-color','');
                            }
                        }

                        if(!useValidator){
                            if(length>=dlsPdmIdColorChangeCn){
                                $('#identFirstNameCn').css('border-color','orange');
                            }else{
                                $('#identFirstNameCn').css('border-color','#ccc');
                            }
                        }
                    }
                })

                $('#identFullNameCn').on('input',function(){
                    var length = $(this).val().length;
                    if(useValidator){
                        if($('#fm-ident').data('bootstrapValidator')!=undefined) {
                            $('#fm-ident').data('bootstrapValidator')
                            .updateStatus('identName', 'NOT_VALIDATED',null)
                            .validateField('identName');
                        }

                    }

                    if(useValidator){
                        if(length>=dlsPdmIdColorChangeCn){
                            $('#identFullNameCn').css('border-color','orange');
                        }else{
                            $('#identFullNameCn').css('border-color','');
                        }
                    }

                    if(!useValidator){
                        if(length>=dlsPdmIdColorChangeCn){
                            $('#identFullNameCn').css('border-color','orange');
                        }else{
                            $('#identFullNameCn').css('border-color','#ccc');
                        }
                    }

                });

                //葡文姓名改變
                $('#identLastNameEn,#identFirstNameEn').on('input',function(){
                    var id = $(this).attr('id');
                    var length = $(this).val().length;

                    var identFullNameLength = $('#identLastNameEn').val().length + $('#identFirstNameEn').val().length;
                    if(identFullNameLength<=dlsPdmIdfullNameEnLen){
                        if($('#identLastNameEn').val().length == 0){
                            $('#identfullNameEn').val($("#identLastNameEn").val()+""+$("#identFirstNameEn").val()).trigger('input');
                            self.pdmCautionCertInfoList.identfullNameEn = $("#identLastNameEn").val()+""+$("#identFirstNameEn").val();
                        }else{
                            $('#identfullNameEn').val($("#identLastNameEn").val()+" "+$("#identFirstNameEn").val()).trigger('input');
                            self.pdmCautionCertInfoList.identfullNameEn = $("#identLastNameEn").val()+" "+$("#identFirstNameEn").val();
                        }
                        //$('#identfullNameEn').val($("#identLastNameEn").val()+" "+$("#identFirstNameEn").val());
                        //self.pdmCertInfoList.identfullNameEn = $("#identLastNameEn").val()+" "+$("#identFirstNameEn").val();
                    }

                    if(useValidator){
                        if($('#fm-ident').data('bootstrapValidator')!=undefined) {
                            $('#fm-ident').data('bootstrapValidator')
                            .updateStatus('identName', 'NOT_VALIDATED',null)
                            .validateField('identName');
                        }

                    }

                    if(id=='identLastNameEn'){
                        if(useValidator){
                            if(length>=dlsPdmIdColorChangePt){
                                $('#identLastNameEn').css('border-color','orange');
                            }else{
                                $('#identLastNameEn').css('border-color','');
                            }
                        }

                        if(!useValidator){
                            if(length>=dlsPdmIdColorChangePt){
                                $('#identLastNameEn').css('border-color','orange');
                            }else{
                                $('#identLastNameEn').css('border-color','#ccc');
                            }
                        }
                    }
                    if(id=='identFirstNameEn'){
                        if(useValidator){
                            if(length>=dlsPdmIdColorChangePt){
                                $('#identFirstNameEn').css('border-color','orange');
                            }else{
                                $('#identFirstNameEn').css('border-color','');
                            }
                        }

                        if(!useValidator){
                            if(length>=dlsPdmIdColorChangePt){
                                $('#identFirstNameEn').css('border-color','orange');
                            }else{
                                $('#identFirstNameEn').css('border-color','#ccc');
                            }
                        }
                    }
                });


                $('#identfullNameEn').on('input',function(){
                    var length = $(this).val().length;
                    if(useValidator){
                        if($('#fm-ident').data('bootstrapValidator')!=undefined) {
                            $('#fm-ident').data('bootstrapValidator')
                            .updateStatus('identName', 'NOT_VALIDATED',null)
                            .validateField('identName');
                        }

                    }

                    if(useValidator){
                        if(length>=dlsPdmIdColorChangePt){
                            $('#identfullNameEn').css('border-color','orange');
                        }else{
                            $('#identfullNameEn').css('border-color','');
                        }
                    }

                    if(!useValidator){
                        if(length>=dlsPdmIdColorChangePt){
                            $('#identfullNameEn').css('border-color','orange');
                        }else{
                            $('#identfullNameEn').css('border-color','#ccc');
                        }
                    }
                });

                //列印中文姓名改变
                $('#printLastNameCn,#printFirstNameCn').on('input',function(){
                    $('#printFullNameCn').val($("#printLastNameCn").val()+""+$("#printFirstNameCn").val());
                    self.pdmCautionCertInfoList.printFullNameCn = $("#printLastNameCn").val()+""+$("#printFirstNameCn").val();
                })

                //列印葡文姓名改变
                $('#printLastNameEn,#printFirstNameEn').on('input',function(){
                    if($('#printLastNameEn').val().length == 0){
                        $('#printfullNameEn').val($("#printLastNameEn").val()+""+$("#printFirstNameEn").val());
                        self.pdmCautionCertInfoList.printfullNameEn = $("#printLastNameEn").val()+""+$("#printFirstNameEn").val();
                    }else{
                        $('#printfullNameEn').val($("#printLastNameEn").val()+" "+$("#printFirstNameEn").val());
                        self.pdmCautionCertInfoList.printfullNameEn = $("#printLastNameEn").val()+" "+$("#printFirstNameEn").val();
                    }
                })

                //發出機構
                 $("#issueAuthority").on('change', function () {
                    self.pdmCautionCertInfoList.issueAuthority = $(this).val();
                });

                //簽發日期
                $('#issueDate').datetimepicker({
                    trigger:'change'
                }).on('changeDate', function(ev) {
                    self.pdmCautionCertInfoList.issueDate = ev.date.format("dd/MM/yyyy");
                });

                 $('#validDate').datetimepicker({//有效日期
                    trigger:'change'
                }).on('changeDate', function(ev) {
                    self.pdmCautionCertInfoList.validDate = ev.date.format("dd/MM/yyyy");
                });

                $('#firstIssueDate').datetimepicker({//首次簽發日期
                    trigger:'change'
                }).on('changeDate', function(ev) {
                    self.pdmCautionCertInfoList.firstIssueDate = ev.date.format("dd/MM/yyyy");
                });






                $("#issueAuthority").select2Remote({
                    url: basePath + '/select2/page'
                });

                $('#issueDate').datetimepicker({
                    trigger:'change'
                }).on('changeDate', function(ev) {
                });

                $('#validDate').datetimepicker({
                    trigger:'change'
                }).on('changeDate', function(ev) {

                });

                $('#firstIssueDate').datetimepicker({
                    trigger:'change'
                }).on('changeDate', function(ev) {

                });


                function dateCompare(currentDate1,currentDate2,currentMonth1,currentMonth2,currentYear1,currentYear2){//兩個日期比較大小
                    if(currentYear1>currentYear2){
                        return "1";
                    }else if(currentYear1<currentYear2){
                        return "-1";
                    }else if(currentYear1==currentYear2){
                        if(currentMonth1>currentMonth2){
                            return "1";
                        }else if(currentMonth1<currentMonth2){
                            return "-1";
                        }else if(currentMonth1==currentMonth2){
                            if(currentDate1>currentDate2){
                                return "1";
                            }else if(currentDate1<currentDate2){
                                return "-1";
                            }else if(currentDate1==currentDate2){
                                return "0";
                            }
                        }
                    }
                }




                var useValidator = this.usevalidator;
                Vue.nextTick(function(){
                    if(useValidator){
                        $('#fm-ident').bootstrapValidator({
                            fields: {

                                identName: {
                                    validators: {
                                        callback:{
                                            callback:function(value,validator){
                                                var lastNameCnValidator = atosUtil.isNotEmpty($('#identLastNameCn').val());
                                                var firstNameCnValidator = atosUtil.isNotEmpty($('#identFirstNameCn').val());
                                                var fullNameCnValidator = atosUtil.isNotEmpty($('#identFullNameCn').val());
                                                var lastNameEnValidator = atosUtil.isNotEmpty($('#identLastNameEn').val());
                                                var firstNameEnValidator = atosUtil.isNotEmpty($('#identFirstNameEn').val());
                                                var fullNameEnValidator = atosUtil.isNotEmpty($('#identfullNameEn').val());
                                                if(lastNameCnValidator||firstNameCnValidator||fullNameCnValidator||lastNameEnValidator||firstNameEnValidator||fullNameEnValidator){
                                                    return true;
                                                }else{
                                                    message="請填寫必填欄位";
                                                    return false;
                                                }
                                            }
                                        }
                                    }
                                },
                                personalIdentType: {
                                    validators: {
                                        notEmpty: {
                                            //message: '不能為空'
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
                                                }else {
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
                                issueAuthority: {
                                    validators: {
                                        notEmpty: {}
                                    }
                                },
                                issueDate: {
                                    validators: {
                                        date : {
                                            format : 'DD/MM/YYYY',
                                            message : '日期格式不合法'
                                        },
                                        callback:{
                                            callback:function(value,validator){
                                                var patt = /^(((0[1-9]|1[0-9]|2[0-8])\/(0[1-9]|1[0-2])|(29|30)\/(0[13-9]|1[0-2])|(31\/0[13578]|1[02]))\/(?!0000)[0-9]{4})|((29\/02\/[0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00))$/;
                                                if(patt.test(value)){//校驗日期
                                                    var today = new Date();
                                                    var todayDate = today.getDate();
                                                    var todayMonth = today.getMonth()+1;
                                                    var todayYear = today.getFullYear(); //获取完整的年份(4位,1970)
                                                    var array = value.split('/');
                                                    issueCurrentDate = array[0];
                                                    issueCurrentMonth = array[1];
                                                    issueCurrentYear = array[2];
                                                    var isDateValidator = dateCompare(issueCurrentDate,todayDate,issueCurrentMonth,todayMonth,issueCurrentYear,todayYear);
                                                    if(isDateValidator==-1||isDateValidator==0){
                                                        return true;
                                                    }else{
                                                        validator.updateMessage('issueDate', 'callback',atosUtil.getI18nMessage('pdm.issueDate.greaterThanToday'));
                                                    }
                                                }
                                                return false;//日期不正確
                                            }
                                        }
                                    }
                                },
                                validDate: {
                                    validators: {
                                        date : {
                                            format : 'DD/MM/YYYY',
                                            message : '日期格式不合法'
                                        },
                                        callback:{
                                            callback:function(value,validator){
                                                var patt = /^(((0[1-9]|1[0-9]|2[0-8])\/(0[1-9]|1[0-2])|(29|30)\/(0[13-9]|1[0-2])|(31\/0[13578]|1[02]))\/(?!0000)[0-9]{4})|((29\/02\/[0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00))$/;
                                                if(patt.test(value)){
                                                    var today = new Date();
                                                    var todayDate = today.getDate();
                                                    var todayMonth = today.getMonth()+1;
                                                    var todayYear = today.getFullYear(); //获取完整的年份(4位,1970)
                                                    var array = value.split('/');
                                                    var validCurrentDate = array[0];
                                                    var validCurrentMonth = array[1];
                                                    var validCurrentYear = array[2];
                                                    var isDateValidator = dateCompare(validCurrentDate,todayDate,validCurrentMonth,todayMonth,validCurrentYear,todayYear);
                                                    if(isDateValidator==1||isDateValidator==0){
                                                        return true;
                                                    }else{
                                                    //有效期不能小於今天
                                                        validator.updateMessage('validDate', 'callback',atosUtil.getI18nMessage('pdm.validDate.lessThanToday'));
                                                    }
                                                }
                                                if(atosUtil.isEmpty(value)){
                                                    return true;
                                                }
                                                return false;
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
            this.initEvent();
		}
	})
    Vue.component('pdm-temporary-cert-info',pdmTemporaryCertInfo);
});

</script>

