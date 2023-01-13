<template>
     <form class="form-horizontal row-sm margin-top-10" id="fm-ident">
        <auth-dialog :show="isShow" @ok="ok"  @cancel="cancel" :authParams="authParams" ref="authDialog"></auth-dialog>
        <div class="form-group">
            <label class="control-label col-sm-1_5 required" v-text="pdmI18NList.personalIdentType">證件類型-t </label>
            <div class="col-sm-4 atosFocus">
                <select class="form-control select2" id="personalIdentType" name="personalIdentType" data-codeType="31001"></select>
            </div>
            <label class="control-label col-sm-1_5 required" v-text="pdmI18NList.personalIdentNo">證件編號 -t</label>
            <div class="col-sm-2_5 atosFocus" id="personalIdentNoDiv">
                <input v-model="pdmCertInfoList.personalIdentNo" id="personalIdentNo" class="form-control" type="text" :placeholder="pdmI18NList.personalIdentNo" name="personalIdentNo">
            </div>

            <div class="col-sm-2">
                <button type="button" id="paste" class="btn btn-primary" v-text="pdmI18NList.readIDCard" >讀取智能身份證-t </button>
            </div>
        </div>


        <div class="form-group">
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.identLastNameCnOrFirstNameCn" >證件中文姓/名 -t</label>
            <div class="col-sm-4 atosFocus">
                <div class="input-group">
                    <input @blur="nameBlur('identLastNameCn')" data-bv-stringlength="false" name="identName" v-bind:maxlength="pdmnameparammap['dlsPdmIdLastNameCnLen']" v-model="pdmCertInfoList.identLastNameCn" id="identLastNameCn" class="form-control" type="text"  :placeholder="pdmI18NList.identLastNameCn">
                    <span class="input-group-addon">/</span>
                    <input @blur="nameBlur('identFirstNameCn')" style="border-top-right-radius:4px;border-bottom-right-radius:4px" data-bv-stringlength="false" name="identName" v-bind:maxlength="pdmnameparammap['dlsPdmIdFirstNameCnLen']" v-model="pdmCertInfoList.identFirstNameCn" id="identFirstNameCn" class="form-control" type="text" :placeholder="pdmI18NList.identFirstNameCn">
                </div>
            </div>

            <label class="control-label col-sm-1_5" v-text="pdmI18NList.identFullNameCn">證件中文全名-t </label>
            <div class="col-sm-2_5">
                <input @blur="nameBlur('identFullNameCn')" data-bv-stringlength="false" name="identName" v-bind:maxlength="pdmnameparammap['dlsPdmIdFullNameCnLen']" v-model="pdmCertInfoList.identFullNameCn" id="identFullNameCn" class="form-control" type="text" :placeholder="pdmI18NList.identFullNameCn">
            </div>

            <div class="col-sm-2">
                <button @click="authRevisePrintName" id="printBtn" type="button" class="btn btn-primary" v-text="pdmI18NList.authRevisePrintName">授權更改列印名-t </button>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.identLastNameEnAndFirstNameEn">證件葡文姓/名 -t</label>
            <div class="col-sm-4">
                <div class="input-group">
                    <input @input="nameBlur('identLastNameEn')" @blur="nameBlur('identLastNameEn',true)" data-bv-stringlength="false" name="identName" v-bind:maxlength="pdmnameparammap['dlsPdmIdLastNameEnLen']" v-model="pdmCertInfoList.identLastNameEn" class="form-control" type="text" :placeholder="pdmI18NList.identLastNameEn" id="identLastNameEn">
                    <span class="input-group-addon">/</span>
                    <input @input="nameBlur('identFirstNameEn')" @blur="nameBlur('identFirstNameEn',true)" style="border-top-right-radius:4px;border-bottom-right-radius:4px" data-bv-stringlength="false" name="identName" v-bind:maxlength="pdmnameparammap['dlsPdmIdFirstNameEnLen']" v-model="pdmCertInfoList.identFirstNameEn" class="form-control" type="text" :placeholder="pdmI18NList.identFirstNameEn" id="identFirstNameEn">
                </div>
            </div>
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.identfullNameEn">證件葡文全名-t </label>
            <div class="col-sm-4">
                <input @input="nameBlur('identfullNameEn')" @blur="nameBlur('identfullNameEn',true)" data-bv-stringlength="false" name="identName" v-bind:maxlength="pdmnameparammap['dlsPdmIdfullNameEnLen']" v-model="pdmCertInfoList.identfullNameEn" id="identfullNameEn" class="form-control" type="text" :placeholder="pdmI18NList.identfullNameEn">
            </div>
        </div>

        <div class="form-group" v-bind:class="{ hide: isHidePrint }">
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.printLastNameCnOrFirstNameCn">列印中文姓/名-t </label>
            <div class="col-sm-4">
                <div class="input-group">
                    <input v-bind:maxlength="pdmnameparammap['dlsPdmPrLastNameCnLen']" v-model="pdmCertInfoList.printLastNameCn" class="form-control" type="text" id="printLastNameCn" :placeholder="pdmI18NList.printLastNameCn" style="background-color: #fff;" >
                    <span class="input-group-addon">/</span>
                    <input v-bind:maxlength="pdmnameparammap['dlsPdmPrFirstNameCnLen']" class="form-control" type="text" id="printFirstNameCn" :placeholder="pdmI18NList.printFirstNameCn" style="background-color: #fff;" v-model="pdmCertInfoList.printFirstNameCn">
                </div>
            </div>

            <label class="control-label col-sm-1_5" v-text="pdmI18NList.printFullNameCn">列印中文全名-t </label>
            <div class="col-sm-4">
                <input v-bind:maxlength="pdmnameparammap['dlsPdmPrFullNameCnLen']" class="form-control" type="text" id="printFullNameCn" :placeholder="pdmI18NList.printFullNameCn" style="background-color: #fff;" v-model="pdmCertInfoList.printFullNameCn">
            </div>
        </div>

        <div class="form-group" v-bind:class="{ hide: isHidePrint }">
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.printLastNameEnAndFirstNameEn">列印葡文姓/名 -t</label>
            <div class="col-sm-4">
                <div class="input-group">
                    <input @input="printEnNameBlur('printLastNameEn')" @blur="printEnNameBlur('printLastNameEn',true)" v-bind:maxlength="pdmnameparammap['dlsPdmPrLastNameEnLen']" class="form-control" type="text" id="printLastNameEn" :placeholder="pdmI18NList.printLastNameEn" style="background-color: #fff;" v-model="pdmCertInfoList.printLastNameEn">
                    <span class="input-group-addon">/</span>
                    <input @input="printEnNameBlur('printFirstNameEn')" @blur="printEnNameBlur('printFirstNameEn',true)" v-bind:maxlength="pdmnameparammap['dlsPdmPrFirstNameEnLen']" class="form-control" type="text" id="printFirstNameEn" :placeholder="pdmI18NList.printFirstNameEn" style="background-color: #fff;" v-model="pdmCertInfoList.printFirstNameEn">
                </div>
            </div>
            <label class="control-label col-sm-1_5" v-text="pdmI18NList.printfullNameEn">列印英文全名 -t</label>
            <div class="col-sm-4">
                <input @input="printEnNameBlur('printfullNameEn')" @blur="printEnNameBlur('printfullNameEn',true)" v-bind:maxlength="pdmnameparammap['dlsPdmPrfullNameEnLen']" class="form-control" id="printfullNameEn" type="text" :placeholder="pdmI18NList.printfullNameEn" style="background-color: #fff;" v-model="pdmCertInfoList.printfullNameEn">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-1_5 required" v-text="pdmI18NList.issueAuthority">發出機構 -t</label>
            <div class="col-sm-4 atosFocus">
                <select class="form-control select2" id="issueAuthority" name="issueAuthority" data-codeType="31002"></select>
            </div>
            <label class="control-label col-sm-1_5 " v-text="pdmI18NList.issueDate">簽發日期-t </label>
            <div class="col-sm-4 atosFocus">
                <input v-model="pdmCertInfoList.issueDate" class="form-control  form-date" type="text" placeholder="dd/MM/yyyy" id="issueDate" name="issueDate">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-1_5 " v-text="pdmI18NList.validDate">有效日期-t </label>
            <div class="col-sm-4 atosFocus">
                <input v-model="pdmCertInfoList.validDate" class="form-control  form-date" type="text" placeholder="dd/MM/yyyy" id="validDate" name="validDate">
            </div>
            <label class="control-label col-sm-1_5 " v-text="pdmI18NList.firstIssueDate">首次簽發日期 </label>
            <div class="col-sm-4">
                <input name="firstIssueDate" v-model="pdmCertInfoList.firstIssueDate" class="form-control  form-date" type="text" id="firstIssueDate" placeholder="dd/MM/yyyy">
            </div>
        </div>
    </form>
</template>
<script>
define(['jquery','Vue','axios','atosUtil','vueloader','select2','select2.config','datetimepicker.config','axios.config','vueloader!vue/componets/authDialog'],function($,Vue,axios,atosUtil){
    var pdmCertInfo = Vue.extend({
        template:template,
        props:{
            fsmvalidator:{
                type: Boolean,
                default: false
            },
            isdocidexist: {
                type: Boolean,
                default: false
            },
            usevalidator: {
                type: Boolean,
                default: false
            },
            pdmnameparammap:{
                type:Object
            }


        },
        data:function(){
            return {
                pdmCertInfoList:{
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
                    readIDCard:atosUtil.getI18nMessage('pdm.readIDCard'),
                    identLastNameCnOrFirstNameCn:atosUtil.getI18nMessage('pdm.identLastNameCnOrFirstNameCn'),
                    authRevisePrintName:atosUtil.getI18nMessage('pdm.authRevisePrintName'),
                    identLastNameEnAndFirstNameEn:atosUtil.getI18nMessage('pdm.identLastNameEnAndFirstNameEn'),
                    printLastNameCnOrFirstNameCn:atosUtil.getI18nMessage('pdm.printLastNameCnOrFirstNameCn'),
                    printLastNameEnAndFirstNameEn:atosUtil.getI18nMessage('pdm.printLastNameEnAndFirstNameEn'),
                    issueAuthority:atosUtil.getI18nMessage('pdm.issueAuthority'),
                    issueDate:atosUtil.getI18nMessage('pdm.issueDate'),
                    validDate:atosUtil.getI18nMessage('pdm.validDate'),
                    firstIssueDate:atosUtil.getI18nMessage('pdm.firstIssueDate')
                },
                authParams:{
                    authItem:'PRINT_NAME_UPDATE'
                },
                isShow:false,
                isHidePrint:true
            }
        },
        methods:{
            nameBlur : function(nameId,blur){
                var useValidator = this.usevalidator;//是否使用校驗
                var dlsPdmIdColorChangeCn = this.pdmnameparammap['dlsPdmIdColorChangeCn'];//中文顏色改變的長度
                var dlsPdmIdColorChangePt = this.pdmnameparammap['dlsPdmIdColorChangePt'];//葡文顏色改變的長度
                var dlsPdmIdFullNameCnLen = this.pdmnameparammap['dlsPdmIdFullNameCnLen'];//中文全名的最大長度
                var dlsPdmIdfullNameEnLen = this.pdmnameparammap['dlsPdmIdfullNameEnLen'];//葡文全名的最大長度
                var dlsPdmPrFullNameCnLen = this.pdmnameparammap['dlsPdmPrFullNameCnLen'];//列印中文全名的最大長度
                var dlsPdmPrfullNameEnLen = this.pdmnameparammap['dlsPdmPrfullNameEnLen'];//列印葡文全名的最大長度

                var cnNamePatt = /^.*\s.*$/;

                var enNamePatt = /^.*\s\s.*$/;

                //中文姓事件
                if(nameId=='identLastNameCn'){
                    this.pdmCertInfoList.identLastNameCn = this.pdmCertInfoList.identLastNameCn.trim();
                    $('#identLastNameCn').val(this.pdmCertInfoList.identLastNameCn);//用于触发校验
                    var length = this.pdmCertInfoList.identLastNameCn.length;
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

                    if(cnNamePatt.test(this.pdmCertInfoList.identLastNameCn)){
                        $.alert({
                            text: '中文姓含有空格！'
                        });
                    }
                }

                //中文名事件
                if(nameId=='identFirstNameCn'){
                    this.pdmCertInfoList.identFirstNameCn = this.pdmCertInfoList.identFirstNameCn.trim();
                    $('#identFirstNameCn').val(this.pdmCertInfoList.identFirstNameCn);//用于触发校验
                    var length = this.pdmCertInfoList.identFirstNameCn.length;
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

                    if(cnNamePatt.test(this.pdmCertInfoList.identFirstNameCn)){
                        $.alert({
                            text: '中文名含有空格！'
                        });
                    }
                }

                //中文姓/名改变
                if(nameId=='identLastNameCn'||nameId=='identFirstNameCn'){
                    var length = this.pdmCertInfoList.identLastNameCn.trim().length + this.pdmCertInfoList.identFirstNameCn.trim().length;
                    if(length<=dlsPdmIdFullNameCnLen){
                        this.pdmCertInfoList.identFullNameCn = this.pdmCertInfoList.identLastNameCn.trim() + this.pdmCertInfoList.identFirstNameCn.trim();
                        $('#identFullNameCn').val(this.pdmCertInfoList.identFullNameCn);//用于触发校验
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
                    this.pdmCertInfoList.identFullNameCn = this.pdmCertInfoList.identFullNameCn.trim();
                    $('#identFullNameCn').val(this.pdmCertInfoList.identFullNameCn);//用于触发校验
                    var length = this.pdmCertInfoList.identFullNameCn.length;
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

                    if(cnNamePatt.test(this.pdmCertInfoList.identFullNameCn)){
                        $.alert({
                            text: '中文全名含有空格！'
                        });
                    }

                }


                //葡文姓事件
                if(nameId=='identLastNameEn'){
                    //this.pdmCertInfoList.identLastNameEn = this.pdmCertInfoList.identLastNameEn.trim();
                    //debugger;

                    var str = "";
                    str = this.pdmCertInfoList.identLastNameEn;

                    if(blur===true){
                        str = this.pdmCertInfoList.identLastNameEn.trim();
                    }

                    //var str = this.pdmCertInfoList.identLastNameEn.trim();
                    var temp = '';
                    for (var i = 0; i < str.length; i++) {
                        if (!str[i].match(/[\uff00-\uffff]/)) {
                            temp+=str[i];
                        }
                    }

                    this.pdmCertInfoList.identLastNameEn = temp.toUpperCase();




                    $('#identLastNameEn').val(this.pdmCertInfoList.identLastNameEn);//用于触发校验
                    var length = this.pdmCertInfoList.identLastNameEn.length;
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

                    if(enNamePatt.test(this.pdmCertInfoList.identLastNameEn)){
                        $.alert({
                            text: '英文姓含有空格！'
                        });
                    }
                }

                //葡文名改变事件
                if(nameId=='identFirstNameEn'){

                    var str = "";
                    str = this.pdmCertInfoList.identFirstNameEn;

                    if(blur===true){
                        str = this.pdmCertInfoList.identFirstNameEn.trim();
                    }


                    var temp = '';
                    for (var i = 0; i < str.length; i++) {
                        if (!str[i].match(/[\uff00-\uffff]/)) {
                            temp+=str[i];
                        }
                    }

                    this.pdmCertInfoList.identFirstNameEn = temp.toUpperCase();



                    $('#identFirstNameEn').val(this.pdmCertInfoList.identFirstNameEn);//用于触发校验
                    var length = this.pdmCertInfoList.identFirstNameEn.length;
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

                    if(enNamePatt.test(this.pdmCertInfoList.identFirstNameEn)){
                        $.alert({
                            text: '英文名含有空格！'
                        });
                    }

                }

                //葡文姓、名改变事件
                if(nameId=='identLastNameEn'||nameId=='identFirstNameEn'){
                    var length = this.pdmCertInfoList.identLastNameEn.trim().length + this.pdmCertInfoList.identFirstNameEn.trim().length;
                    if(length>0&&length<=dlsPdmIdfullNameEnLen){
                        if(this.pdmCertInfoList.identLastNameEn.trim().length>0&&this.pdmCertInfoList.identFirstNameEn.trim().length>0){
                            this.pdmCertInfoList.identfullNameEn = this.pdmCertInfoList.identLastNameEn.trim() +" "+ this.pdmCertInfoList.identFirstNameEn.trim();
                        }else{
                            this.pdmCertInfoList.identfullNameEn = this.pdmCertInfoList.identLastNameEn.trim() + this.pdmCertInfoList.identFirstNameEn.trim();
                        }

                    }

                    if(length==0){
                        this.pdmCertInfoList.identfullNameEn = "";
                    }

                     $('#identfullNameEn').val(this.pdmCertInfoList.identfullNameEn);//用于触发校验

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
                    //this.pdmCertInfoList.identfullNameEn = this.pdmCertInfoList.identfullNameEn.trim();
                    var str = "";
                    str = this.pdmCertInfoList.identfullNameEn;

                    if(blur===true){
                        str = this.pdmCertInfoList.identfullNameEn.trim();
                    }



                    var temp = '';
                    for (var i = 0; i < str.length; i++) {
                        if (!str[i].match(/[\uff00-\uffff]/)) {
                            temp+=str[i];
                        }
                    }

                    this.pdmCertInfoList.identfullNameEn = temp.toUpperCase();



                    $('#identfullNameEn').val(this.pdmCertInfoList.identfullNameEn);//用于触发校验
                    var length = this.pdmCertInfoList.identfullNameEn.length;
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

                    if(enNamePatt.test(this.pdmCertInfoList.identfullNameEn)){
                        $.alert({
                            text: '英文全名含有空格！'
                        });
                    }
                }





                if(useValidator){

                    //console.log($('#fm-ident').data('bootstrapValidator'));
                    if($('#fm-ident').data('bootstrapValidator')!=undefined){
                        $('#fm-ident').data('bootstrapValidator').updateStatus('identName', 'NOT_VALIDATED',null).validateField('identName');
                    }

                }



            },
            printEnNameBlur : function(nameId,blur){
                //列印英文姓
                if(nameId=='printLastNameEn'){
                    var str = "";
                    str = this.pdmCertInfoList.printLastNameEn;

                    if(blur===true){
                        str = this.pdmCertInfoList.printLastNameEn.trim();
                    }

                    var temp = '';
                    for (var i = 0; i < str.length; i++) {
                        if (!str[i].match(/[\uff00-\uffff]/)) {
                            temp+=str[i];
                        }
                    }
                    this.pdmCertInfoList.printLastNameEn = temp.toUpperCase();
                    $('#printLastNameEn').val(this.pdmCertInfoList.printLastNameEn).trigger('change');
                }

                //列印葡文名

                 if(nameId=='printFirstNameEn'){
                    var str = "";
                    str = this.pdmCertInfoList.printFirstNameEn;

                    if(blur===true){
                        str = this.pdmCertInfoList.printFirstNameEn.trim();
                    }
                    var temp = '';
                    for (var i = 0; i < str.length; i++) {
                        if (!str[i].match(/[\uff00-\uffff]/)) {
                            temp+=str[i];
                        }
                    }
                    this.pdmCertInfoList.printFirstNameEn = temp.toUpperCase();
                    $('#printFirstNameEn').val(this.pdmCertInfoList.printFirstNameEn).trigger('change');
                }


                //列印葡文全名
                if(nameId=='printfullNameEn'){
                    var str = "";
                    str = this.pdmCertInfoList.printfullNameEn;

                    if(blur===true){
                        str = this.pdmCertInfoList.printfullNameEn.trim();
                    }


                    var temp = '';
                    for (var i = 0; i < str.length; i++) {
                        if (!str[i].match(/[\uff00-\uffff]/)) {
                            temp+=str[i];
                        }
                    }
                    this.pdmCertInfoList.printfullNameEn = temp.toUpperCase();
                    $('#printfullNameEn').val(this.pdmCertInfoList.printfullNameEn).trigger('change');
                }
            },
            //授權修改列印名
            authRevisePrintName: function(){
                this.isShow = false;
                this.isShow = true;
            },
            ok : function(){
                this.isHidePrint = false;
                this.isShow = false;

                var dlsPdmPrLastNameCnLen = this.pdmnameparammap['dlsPdmPrLastNameCnLen'];//列印中文姓的最大長度
                var dlsPdmPrFirstNameCnLen = this.pdmnameparammap['dlsPdmPrFirstNameCnLen'];//列印中文名的最大長度
                var dlsPdmPrFullNameCnLen = this.pdmnameparammap['dlsPdmPrFullNameCnLen'];//列印中文全名的最大長度

                var dlsPdmPrLastNameEnLen = this.pdmnameparammap['dlsPdmPrLastNameEnLen'];//列印葡文姓的最大长度
                var dlsPdmPrFirstNameEnLen = this.pdmnameparammap['dlsPdmPrFirstNameEnLen'];//列印葡文名的最大长度
                var dlsPdmPrfullNameEnLen = this.pdmnameparammap['dlsPdmPrfullNameEnLen'];//列印葡文全名的最大長度

                //中文姓
                if(atosUtil.isNotEmpty(this.pdmCertInfoList.identLastNameCn)){
                    if(this.pdmCertInfoList.identLastNameCn.length<=dlsPdmPrLastNameCnLen){
                        this.pdmCertInfoList.printLastNameCn  = this.pdmCertInfoList.identLastNameCn;
                    }else{
                        this.pdmCertInfoList.printLastNameCn  = new String(this.pdmCertInfoList.identLastNameCn).substring(0,dlsPdmPrLastNameCnLen);
                    }
                }

                //中文名
                if(atosUtil.isNotEmpty(this.pdmCertInfoList.identFirstNameCn)){
                    if(this.pdmCertInfoList.identFirstNameCn.length<=dlsPdmPrFirstNameCnLen){
                        this.pdmCertInfoList.printFirstNameCn  = this.pdmCertInfoList.identFirstNameCn;
                    }else{
                        this.pdmCertInfoList.printFirstNameCn  = new String(this.pdmCertInfoList.identFirstNameCn).substring(0,dlsPdmPrFirstNameCnLen);
                    }
                }

                this.pdmCertInfoList.printFullNameCn = "";

                if(atosUtil.isNotEmpty(this.pdmCertInfoList.printLastNameCn)){
                    this.pdmCertInfoList.printFullNameCn += this.pdmCertInfoList.printLastNameCn;
                }

                if(atosUtil.isNotEmpty(this.pdmCertInfoList.printFirstNameCn)){
                    this.pdmCertInfoList.printFullNameCn += this.pdmCertInfoList.printFirstNameCn;
                }

                //葡文姓
                if(atosUtil.isNotEmpty(this.pdmCertInfoList.identLastNameEn)){
                    if(this.pdmCertInfoList.identLastNameEn.length<=dlsPdmPrLastNameEnLen){
                        this.pdmCertInfoList.printLastNameEn  = this.pdmCertInfoList.identLastNameEn;
                    }else{
                        this.pdmCertInfoList.printLastNameEn  = new String(this.pdmCertInfoList.identLastNameEn).substring(0,dlsPdmPrLastNameEnLen);
                    }
                }

                //葡文名
                if(atosUtil.isNotEmpty(this.pdmCertInfoList.identFirstNameEn)){
                    if(this.pdmCertInfoList.identFirstNameEn.length<=dlsPdmPrFirstNameEnLen){
                        this.pdmCertInfoList.printFirstNameEn  = this.pdmCertInfoList.identFirstNameEn;
                    }else{
                        this.pdmCertInfoList.printFirstNameEn  = new String(this.pdmCertInfoList.identFirstNameEn).substring(0,dlsPdmPrFirstNameEnLen);
                    }
                }

                this.pdmCertInfoList.printfullNameEn = "";
                if(atosUtil.isNotEmpty(this.pdmCertInfoList.printLastNameEn)){
                    this.pdmCertInfoList.printfullNameEn += this.pdmCertInfoList.printLastNameEn;
                }

                if(atosUtil.isNotEmpty(this.pdmCertInfoList.printFirstNameEn)){
                    if(atosUtil.isNotEmpty(this.pdmCertInfoList.printfullNameEn)){
                        this.pdmCertInfoList.printfullNameEn += " "+this.pdmCertInfoList.printFirstNameEn;
                    }else{
                        this.pdmCertInfoList.printfullNameEn += this.pdmCertInfoList.printFirstNameEn;
                    }
                }
                $('#printBtn').attr('disabled','disabled');
            },
            cancel:function(){
                this.isShow = false;
            },
            initDatatimepicker:function(){
                var self = this;

                var sysDateText = atosUtil.getSysDate(); // 獲取系統時間字符串
                var sysDate = atosUtil.dateToDate(sysDateText); // 變成date類型


                var issueDateStart = atosUtil.getDate19000101();
                //簽發日期
                $('#issueDate').datetimepicker({
                    startDate:issueDateStart,
                    endDate: sysDate
                }).on('changeDate', function(ev) {
                    self.pdmCertInfoList.issueDate = ev.date.format("dd/MM/yyyy");
                }).on('hide',function(){
                    $('#fm-ident').data('bootstrapValidator')
                    .updateStatus('issueDate', 'NOT_VALIDATED',null)
                    .validateField('issueDate');
                });

                var validDateEnd = atosUtil.getDate99991231();

                 $('#validDate').datetimepicker({
                    startDate: sysDate,
                    endDate:validDateEnd
                 }).on('changeDate', function(ev) {
                    self.pdmCertInfoList.validDate = ev.date.format("dd/MM/yyyy");
                }).on('hide',function(){
                    $('#fm-ident').data('bootstrapValidator')
                    .updateStatus('validDate', 'NOT_VALIDATED',null)
                    .validateField('validDate');
                });

                var firstIssueDateStart = atosUtil.getDate19000101();

                $('#firstIssueDate').datetimepicker({
                    startDate:firstIssueDateStart,
                    endDate: sysDate
                }).on('changeDate', function(ev) {
                    self.pdmCertInfoList.firstIssueDate = ev.date.format("dd/MM/yyyy");
                }).on('hide',function(){
                    $('#fm-ident').data('bootstrapValidator')
                    .updateStatus('firstIssueDate', 'NOT_VALIDATED',null)
                    .validateField('firstIssueDate');
                });
            },
            initEvent:function(){
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
                var self = this;


                var idDocIdExist = this.isdocidexist;//docId是否存在
                var useValidator = this.usevalidator;//是否使用校驗
                var fsmValidator = this.fsmvalidator;//是否啟用用於主檔的fsm警示的提示
                var dlsPdmIdColorChangeCn = this.pdmnameparammap['dlsPdmIdColorChangeCn'];//中文顏色改變的長度
                var dlsPdmIdColorChangePt = this.pdmnameparammap['dlsPdmIdColorChangePt'];//葡文顏色改變的長度
                var dlsPdmIdFullNameCnLen = this.pdmnameparammap['dlsPdmIdFullNameCnLen'];//中文全名的最大長度
                var dlsPdmIdfullNameEnLen = this.pdmnameparammap['dlsPdmIdfullNameEnLen'];//葡文全名的最大長度
                var dlsPdmPrFullNameCnLen = this.pdmnameparammap['dlsPdmPrFullNameCnLen'];//列印中文全名的最大長度
                var dlsPdmPrfullNameEnLen = this.pdmnameparammap['dlsPdmPrfullNameEnLen'];//列印葡文全名的最大長度


                $("#personalIdentType").select2Remote({
                    url: basePath + '/select2/page'
                });

                var serviceId = vModel.serviceId;

                if(atosUtil.isNotEmpty(serviceId) && Number(serviceId) === Number('1064')){
                     var tcsValidIdentity = vModel.tcsValidIdentity;
                    $("#personalIdentType").select2Remote({
                        url: basePath + '/select2/page/filter?tcsValidIdentity='+vModel.tcsValidIdentity
                    });
                }

                $("#personalIdentType").on('change', function () {

                    self.pdmCertInfoList.personalIdentType = $(this).val();


                    /**
                     * 如果使用了校验规则，且docId存在,对应PDM-005新增证件以及PDM-008根据docId新增临时主档
                     */
                    if(useValidator&&isDocIdExist){
                        $appendData.remove();
                        //校验规则有效
                            //证件类型和证件編號不为空
                            if($('#personalIdentType').val()!=''&&$('#personalIdentNo').val()!=''){

                                var personalIdentType = $('#personalIdentType').val();
                                var personalIdentNo = $('#personalIdentNo').val();
                                //更新证件編號的校验状态为未校验
                                $('#fm-ident').data('bootstrapValidator').updateStatus("personalIdentNo","NOT_VALIDATED",null);
                                //校验证件編號
                                $('#fm-ident').data('bootstrapValidator').validateField('personalIdentNo');
                                axios.post(basePath + '/pdm/driver/checkIdentExistOrNotByDocIdAndIdentTypeAndIdentNo',{'docId':vModel.docId,'personalIdentNo':personalIdentNo,'personalIdentType':personalIdentType}).then(function(resultDTO){
                                    console.log(resultDTO)
                                    if(resultDTO.isIdentInfoExist==false){
                                        //证件不存在，允许新增
                                        //可以新增证件
                                        if(fsmValidator){
                                            //獲取證件類型和證件編號的校驗狀態,通過的話才進行fsmValidator校驗
                                            //console.log($('#fm-ident').data('bootstrapValidator').isValidField('personalIdentNo'))
                                            if($('#fm-ident').data('bootstrapValidator').isValidField('personalIdentType')&&$('#fm-ident').data('bootstrapValidator').isValidField('personalIdentNo')){
                                                axios.post(basePath + '/pdm/driver/checkFSMValidator',{'personalIdentNo':self.pdmCertInfoList.personalIdentNo,'personalIdentType':self.pdmCertInfoList.personalIdentType}).then(function(pdaResponse){
                                                    if(pdaResponse==true){
                                                        $.alert({
                                                            text: '存在有效的FSM警示'
                                                        });
                                                    }
                                                });
                                            }
                                        }
                                        $('#fm-ident').data('bootstrapValidator').validateField('personalIdentNo');

                                    }

                                    //证件存在，且属于当前docId
                                    if(resultDTO.isIdentInfoExist==true&&resultDTO.isIdentInfoBelongsToCurrentId){
                                        $('#fm-ident').data('bootstrapValidator').validateField('personalIdentNo');
                                        $('#personalIdentNoDiv').append($appendData);
                                    }

                                    //证件存在，但不属于当前docId
                                    if(resultDTO.isIdentInfoExist==true&&!resultDTO.isIdentInfoBelongsToCurrentId){
                                        $('#fm-ident').data('bootstrapValidator').updateMessage('personalIdentNo', 'callback',atosUtil.getI18nMessage('pdm.certIsExistDiff'));
                                        $('#fm-ident').data('bootstrapValidator').updateStatus("personalIdentNo","INVALID",null);
                                    }
                                });

                            }

                        //}
                    }


                    /**
                     * 使用了校验规则，且docId不存在，对应PDM-002新增主档以及PDM-007新增临时主档
                     */
                    if(useValidator&&!isDocIdExist){
                        $appendData.remove();
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
                                        //校驗FSM警示信息
                                        if(fsmValidator){
                                            //獲取證件類型和證件編號的校驗狀態,通過的話才進行fsmValidator校驗
                                            if($('#fm-ident').data('bootstrapValidator').isValidField('personalIdentType')&&$('#fm-ident').data('bootstrapValidator').isValidField('personalIdentNo')){
                                                axios.post(basePath + '/pdm/driver/checkFSMValidator',{'personalIdentNo':self.pdmCertInfoList.personalIdentNo,'personalIdentType':self.pdmCertInfoList.personalIdentType}).then(function(pdaResponse){
                                                    if(pdaResponse==true){
                                                        $.alert({
                                                            text: '存在有效的FSM警示'
                                                        });
                                                    }
                                                });
                                            }
                                        }
                                    }


                                });
                            }

                    }

                    if(self.pdmCertInfoList.personalIdentType=='BM'){
                        axios.get(basePath + '/select2/data4show',{params: {codeType:31002, queryString:'SIM'}}).then(function(pdaResponse){
                            $("#issueAuthority").append("<option selected value='"+pdaResponse[0].id+"'>"+pdaResponse[0].description+"</option>").trigger("change");
                        });
                    }
                });

                if(useValidator){
                    var $appendData = $('<span class="orange-highlight">'+atosUtil.getI18nMessage('pdm.certIsExistSame')+'</span>');
                    $('#personalIdentNo').on('input',function(){
                        $appendData.remove();
                    })
                }


                $('#personalIdentNo').on('blur',function(){//驗證證件編號是否已經存在，且屬於當前docId
                    /**
                     * 如果使用了校验规则，且docId存在,对应PDM-005新增证件以及PDM-008根据docId新增临时主档
                     */
                    if(useValidator&&isDocIdExist){

                        //
                        //校验规则有效
                            //证件类型和证件編號不为空
                            if($('#personalIdentType').val()!=''&&$('#personalIdentNo').val()!=''){

                                var personalIdentType = $('#personalIdentType').val();
                                var personalIdentNo = $('#personalIdentNo').val();
                                //更新证件編號的校验状态为未校验
                                $('#fm-ident').data('bootstrapValidator').updateStatus("personalIdentNo","NOT_VALIDATED",null);
                                //校验证件編號
                                $('#fm-ident').data('bootstrapValidator').validateField('personalIdentNo');
                                axios.post(basePath + '/pdm/driver/checkIdentExistOrNotByDocIdAndIdentTypeAndIdentNo',{'docId':vModel.docId,'personalIdentNo':personalIdentNo,'personalIdentType':personalIdentType}).then(function(resultDTO){
                                    console.log(resultDTO)
                                    if(resultDTO.isIdentInfoExist==false){
                                        //证件不存在，允许新增
                                        //可以新增证件
                                        if(fsmValidator){
                                            //獲取證件類型和證件編號的校驗狀態,通過的話才進行fsmValidator校驗
                                            //console.log($('#fm-ident').data('bootstrapValidator').isValidField('personalIdentNo'))
                                            if($('#fm-ident').data('bootstrapValidator').isValidField('personalIdentType')&&$('#fm-ident').data('bootstrapValidator').isValidField('personalIdentNo')){
                                                axios.post(basePath + '/pdm/driver/checkFSMValidator',{'personalIdentNo':self.pdmCertInfoList.personalIdentNo,'personalIdentType':self.pdmCertInfoList.personalIdentType}).then(function(pdaResponse){
                                                    if(pdaResponse==true){
                                                        $.alert({
                                                            text: '存在有效的FSM警示'
                                                        });
                                                    }
                                                });
                                            }
                                        }
                                        $('#fm-ident').data('bootstrapValidator').validateField('personalIdentNo');

                                    }

                                    //证件存在，且属于当前docId
                                    if(resultDTO.isIdentInfoExist==true&&resultDTO.isIdentInfoBelongsToCurrentId){
                                        $('#fm-ident').data('bootstrapValidator').validateField('personalIdentNo');
                                        $('#personalIdentNoDiv').append($appendData);
                                    }

                                    //证件存在，但不属于当前docId
                                    if(resultDTO.isIdentInfoExist==true&&!resultDTO.isIdentInfoBelongsToCurrentId){
                                        $('#fm-ident').data('bootstrapValidator').updateMessage('personalIdentNo', 'callback',atosUtil.getI18nMessage('pdm.certIsExistDiff'));
                                        $('#fm-ident').data('bootstrapValidator').updateStatus("personalIdentNo","INVALID",null);
                                    }
                                });

                            }

                    }

                    /**
                     * 使用了校验规则，且docId不存在，对应PDM-002新增主档以及PDM-007新增临时主档
                     */
                    if(useValidator&&!isDocIdExist){
                        //证件类型和证件編號不为空
                        if($('#personalIdentType').val()!=''&&$('#personalIdentNo').val()!=''){
                            var personalIdentType = $('#personalIdentType').val();
                            var personalIdentNo = $('#personalIdentNo').val();
                            //更新证件編號的校验状态为未校验
                            if($('#fm-ident').data('bootstrapValidator')!=undefined){
                                $('#fm-ident').data('bootstrapValidator').updateStatus("personalIdentNo","NOT_VALIDATED",null);
                                //校验证件編號
                                $('#fm-ident').data('bootstrapValidator').validateField('personalIdentNo');
                            }
                            axios.post(basePath + '/pdm/driver/checkIdentExistOrNotByIdentTypeAndIdentNo',{'personalIdentNo':personalIdentNo,'personalIdentType':personalIdentType}).then(function(isIdentInfoExist){
                                if(isIdentInfoExist==true){
                                    $('#fm-ident').data('bootstrapValidator').updateMessage('personalIdentNo', 'callback',atosUtil.getI18nMessage('pdm.certIsExistDiff'));
                                    $('#fm-ident').data('bootstrapValidator').updateStatus("personalIdentNo","INVALID",null);
                                }

                                if(isIdentInfoExist.data==false){
                                    //可以新增证件
                                    if(fsmValidator){
                                        //獲取證件類型和證件編號的校驗狀態,通過的話才進行fsmValidator校驗
                                        //console.log($('#fm-ident').data('bootstrapValidator').isValidField('personalIdentNo'))
                                        if($('#fm-ident').data('bootstrapValidator').isValidField('personalIdentType')&&$('#fm-ident').data('bootstrapValidator').isValidField('personalIdentNo')){
                                            axios.post(basePath + '/pdm/driver/checkFSMValidator',{'personalIdentNo':self.pdmCertInfoList.personalIdentNo,'personalIdentType':self.pdmCertInfoList.personalIdentType}).then(function(pdaResponse){
                                                if(pdaResponse==true){
                                                    $.alert({
                                                        text: '存在有效的FSM警示'
                                                    });
                                                }
                                            });
                                        }
                                    }
                                    $('#fm-ident').data('bootstrapValidator').validateField('personalIdentNo');
                                }


                            });


                        }


                    }
                })





                //中文姓名改變
                $('#identLastNameCn,#identFirstNameCn').on('input',function(){
                    var id = $(this).attr('id');
                    var length = $(this).val().length;

                    var identFullNameLength = $('#identLastNameCn').val().length + $('#identFirstNameCn').val().length;
                    if(identFullNameLength<=dlsPdmIdFullNameCnLen){
                        $('#identFullNameCn').val($("#identLastNameCn").val()+""+$("#identFirstNameCn").val()).trigger("input");
                        self.pdmCertInfoList.identFullNameCn = $("#identLastNameCn").val()+""+$("#identFirstNameCn").val();
                    }

                    if(useValidator){
                        if($('#fm-ident').data('bootstrapValidator')!=undefined){
                            $('#fm-ident').data('bootstrapValidator').updateStatus('identName', 'NOT_VALIDATED',null).validateField('identName');
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
                        if($('#fm-ident').data('bootstrapValidator')!=undefined){
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
                            self.pdmCertInfoList.identfullNameEn = $("#identLastNameEn").val()+""+$("#identFirstNameEn").val();
                        }else{
                            $('#identfullNameEn').val($("#identLastNameEn").val()+" "+$("#identFirstNameEn").val()).trigger('input');
                            self.pdmCertInfoList.identfullNameEn = $("#identLastNameEn").val()+" "+$("#identFirstNameEn").val();
                        }
                        //$('#identfullNameEn').val($("#identLastNameEn").val()+" "+$("#identFirstNameEn").val());
                        //self.pdmCertInfoList.identfullNameEn = $("#identLastNameEn").val()+" "+$("#identFirstNameEn").val();
                    }

                    if(useValidator){
                        if($('#fm-ident').data('bootstrapValidator')!=undefined){
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
                        if($('#fm-ident').data('bootstrapValidator')!=undefined){
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



                $('#printLastNameCn,#printFirstNameCn').on('input',function(){//列印中文姓名改變
                    var identFullNameLength = $('#printLastNameCn').val().length + $('#printFirstNameCn').val().length;
                    if(identFullNameLength<=dlsPdmPrFullNameCnLen){
                        $('#printFullNameCn').val($("#printLastNameCn").val()+""+$("#printFirstNameCn").val());
                        self.pdmCertInfoList.printFullNameCn = $("#printLastNameCn").val()+""+$("#printFirstNameCn").val();
                    }
                })

                $('#printLastNameEn,#printFirstNameEn').on('input',function(){//葡文姓名改變
                    var identFullNameLength = $('#printLastNameEn').val().length + $('#printFirstNameEn').val().length + 1;
                    if($('#printLastNameEn').val()!=''){
                        if(identFullNameLength<=dlsPdmPrfullNameEnLen){
                            $('#printfullNameEn').val($("#printLastNameEn").val().toUpperCase()+" "+$("#printFirstNameEn").val().toUpperCase());
                            self.pdmCertInfoList.printfullNameEn = $("#printLastNameEn").val().toUpperCase()+" "+$("#printFirstNameEn").val().toUpperCase();
                        }
                    }else{
                        if(identFullNameLength<=dlsPdmPrfullNameEnLen){
                            $('#printfullNameEn').val($("#printLastNameEn").val().toUpperCase()+""+$("#printFirstNameEn").val().toUpperCase());
                            self.pdmCertInfoList.printfullNameEn = $("#printLastNameEn").val().toUpperCase()+""+$("#printFirstNameEn").val().toUpperCase();
                        }
                    }
                })

                //發出機構
                 $("#issueAuthority").on('change', function () {
                    self.pdmCertInfoList.issueAuthority = $(this).val();
                });



                $("#issueAuthority").select2Remote({
                    url: basePath + '/select2/page'
                });
            },
            readIDCard:function(){
                var self = this;
                //console.log();
                //this.$refs.refName.$el.click();
                $("#paste").click(function(){//讀取智能身份證
                    try {
                        var smartcard = $.parseJSON(''+window.clipboardData.getData("Text")+'');
                        if(smartcard == null || undefined == smartcard) {

                        $.alert({
                            text: atosUtil.getI18nMessage('pdm.canNotReadIDCard')
                        });
                        return false;
                            }
                        //讀取智能身份證
                        var identyType = smartcard.identyType;
                            if(identyType=="I"){
                                identyType="BM";
                                self.pdmCertInfoList.personalIdentType = identyType;
                                axios.get(basePath + '/select2/data4show',{params: {codeType:31001, queryString:identyType}}).then(function(response) {
                                    $("#personalIdentType").append("<option selected value='"+response[0].id+"'>"
                                            +response[0].description+"</option>").trigger('change');
                                });
                            }
                            if(identyType=="P"){
                                var nationalCode =smartcard.nationality;
                                axios.get(basePath+'/idcard/getSpIDType',{params:{nationalCode:nationalCode}}).then(function(response){
                                    axios.get(basePath + '/select2/data4show',{params:{codeType:31001,queryString:response}}).then(function(response) {
                                        $("#personalIdentType").append("<option selected value='"+response[0].id+"'>"
                                                +response[0].description+"</option>").trigger("change");
                                        self.pdmCertInfoList.personalIdentType = response[0].id;
                                    });
                                })
                            }
                        self.pdmCertInfoList.personalIdentNo = smartcard.clientIdNo;//證件編號
                        $('#personalIdentNo').val(smartcard.clientIdNo).trigger('blur');
                        //$('#personalIdentNo').val(smartcard.clientIdNo).change();
                        self.pdmCertInfoList.validDate = smartcard.validitydateformat;
                        $('#validDate').val(smartcard.validitydateformat).trigger('change');
                        self.pdmCertInfoList.firstIssueDate = smartcard.firstissuedateformat;
                        self.pdmCertInfoList.issueDate = smartcard.issuedateformat;
                        $('#issueDate').val(smartcard.issuedateformat).trigger('change');

                        /**
                         *讀取證件信息的數據源里firstCnName表示姓，我們這邊identLastNameCn表示姓
                         *這裡對應的關係
                        */
                        self.pdmCertInfoList.identLastNameCn = smartcard.firstCnName;
                        self.nameBlur('identLastNameCn');
                        self.pdmCertInfoList.identFirstNameCn = smartcard.lastCnName;
                        self.nameBlur('identFirstNameCn');
                        if(atosUtil.isNotEmpty(smartcard.clientName_zh)){
                            var afterTrim = smartcard.clientName_zh.trim();
                            if(afterTrim.length>0){
                                self.pdmCertInfoList.identFullNameCn = smartcard. clientName_zh;
                                self.nameBlur('identFullNameCn');
                            }
                        }


                        /**
                         *讀取證件信息的數據源里firstEnName表示姓，我們這邊identLastNameEn表示姓
                         *這裡對應的關係
                        */
                        self.pdmCertInfoList.identLastNameEn = smartcard.firstEnName;
                        self.nameBlur('identLastNameEn');
                        self.pdmCertInfoList.identFirstNameEn = smartcard.lastEnName;
                        self.nameBlur('identFirstNameEn');


                        if(atosUtil.isNotEmpty(smartcard.clientName_pt)){
                            var afterTrim = smartcard.clientName_pt.trim();
                            if(afterTrim.length>0){
                                self.pdmCertInfoList.identfullNameEn = smartcard. clientName_pt;
                                self.nameBlur('identfullNameEn');
                            }
                        }

                        Vue.nextTick(function(){
                            $('#birthDate').val(smartcard.birthdateformat).trigger('change');
                        });
                        $('#birthDate').val(smartcard.birthdateformat).trigger('change');
                        //self.pdmCertInfoList.birthDate = smartcard.birthdateformat//生日



                        //$('#birthDate').val(smartcard.birthdateformat)
                        // //設置年齡
                        // var dateString = smartcard.birthdateformat;
                        // var array = dateString.split('/');
                        // var dateString = array[2]+"-"+array[1]+"-"+array[0];
                        // controller.variables.vue.driver.age = controller.jsGetAge(new Date(dateString));
                        //controller.variables.vue.driver.gender = smartcard.sex;


                        if(atosUtil.isNotEmpty(smartcard.sex)){
                            if(smartcard.sex=='M'){
                                $('#isSexM').click();
                            }

                            if(smartcard.sex=='F'){
                                $('#isSexF').click();
                            }
                        }



                        //設置出生地
                        if(atosUtil.isNotEmpty(smartcard.birthplace)){
                            axios.get(basePath + '/select2/data?codeType=31004&queryString='+smartcard.birthplace).then(function(response) {
                                if(response!=null&&response[0]!=null){
                                    $("#placeOfBirth").append("<option selected value='"+response[0].id+"'>"
                                        +response[0].description+"</option>").trigger("change");
                                }
                            });
                        }




                        window.clipboardData.setData("Text", "");
                    } catch (err){
                        $.alert({
                            text: atosUtil.getI18nMessage('pdm.canNotReadIDCard')
                        });

                        return false;
                    }

                });
            }
        },
        mounted:function(){
            var self = this;
            self.initDatatimepicker();
            this.initEvent();
            this.readIDCard();
            var useValidator = this.usevalidator;
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
                                    notEmpty: { }
                                }
                            },
                            personalIdentNo: {
                                validators: {
                                    callback: {
                                        message: atosUtil.getI18nMessage('pdm.personalIdentNo.BM'),
                                        callback : function(value, validator) {
                                            if(self.pdmCertInfoList.personalIdentType=='BM') {//澳門身份證
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
                            issueAuthority: {
                                validators: {
                                    notEmpty: {}
                                }
                            },
                            firstIssueDate:{

                                validators:{
                                    date : {
                                        format : 'DD/MM/YYYY',
                                        message :atosUtil.getI18nMessage('pdm.notIllegalDate')
                                    },
                                    // regexp: {
                                    //     regexp:/^(((0[1-9]|1[0-9]|2[0-8])\/(0[1-9]|1[0-2])|(29|30)\/(0[13-9]|1[0-2])|(31\/(0[13578]|1[02])))\/(?!0000)[0-9]{4})|((29\/02\/[0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00))$/,
                                    //     message:atosUtil.getI18nMessage('pdm.notIllegalDate')
                                    // },
                                    callback:{
                                        callback:function(value,validator){
                                            var patt = /^(((0[1-9]|1[0-9]|2[0-8])\/(0[1-9]|1[0-2])|(29|30)\/(0[13-9]|1[0-2])|(31\/(0[13578]|1[02])))\/(?!0000)[0-9]{4})|((29\/02\/[0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00))$/;
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
                                                    if(issueCurrentYear>=1900){
                                                        return true;
                                                    }else{
                                                        validator.updateMessage('firstIssueDate', 'callback','日期不能小於01/01/1900!');
                                                        return false;
                                                    }
                                                    //return true;
                                                }else{
                                                    validator.updateMessage('firstIssueDate', 'callback',atosUtil.getI18nMessage('pdm.issueDate.greaterThanToday'));
                                                    return false;
                                                }
                                            }else{
                                                if(atosUtil.isEmpty(value)){
                                                    return true;
                                                }else{
                                                    validator.updateMessage('firstIssueDate', 'callback',atosUtil.getI18nMessage('pdm.notIllegalDate'));
                                                    return false;//日期不正確
                                                }
                                            }
                                        }
                                    }

                                }
                            },
                            issueDate: {
                                validators: {
                                    //notEmpty: {},
                                    date : {
                                        format : 'DD/MM/YYYY',
                                        message :atosUtil.getI18nMessage('pdm.notIllegalDate')
                                    },
                                    callback:{
                                        callback:function(value,validator){
                                            var patt = /^(((0[1-9]|1[0-9]|2[0-8])\/(0[1-9]|1[0-2])|(29|30)\/(0[13-9]|1[0-2])|(31\/(0[13578]|1[02])))\/(?!0000)[0-9]{4})|((29\/02\/[0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00))$/;
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
                                                    if(issueCurrentYear>=1900){
                                                        return true;
                                                    }else{
                                                        validator.updateMessage('issueDate', 'callback','日期不能小於01/01/1900!');
                                                        return false;
                                                    }
                                                    //return true;
                                                }else{
                                                    validator.updateMessage('issueDate', 'callback',atosUtil.getI18nMessage('pdm.issueDate.greaterThanToday'));
                                                    return false;
                                                }
                                            }else{
                                                if(atosUtil.isEmpty(value)){
                                                    return true;
                                                }else{
                                                    validator.updateMessage('issueDate', 'callback',atosUtil.getI18nMessage('pdm.notIllegalDate'));
                                                    return false;//日期不正確
                                                }
                                            }

                                        }
                                    }
                                }
                            },
                            validDate: {
                                validators: {
                                    date : {
                                        format : 'DD/MM/YYYY',
                                        message :atosUtil.getI18nMessage('pdm.notIllegalDate')
                                    },
                                    callback:{
                                        callback:function(value,validator){
                                            var patt = /^(((0[1-9]|1[0-9]|2[0-8])\/(0[1-9]|1[0-2])|(29|30)\/(0[13-9]|1[0-2])|(31\/(0[13578]|1[02])))\/(?!0000)[0-9]{4})|((29\/02\/[0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00))$/;
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
                                                    return false;
                                                }
                                            }else{
                                                if(atosUtil.isEmpty(value)){
                                                    return true;
                                                }else{
                                                    validator.updateMessage('validDate', 'callback',atosUtil.getI18nMessage('pdm.notIllegalDate'));
                                                    return false;
                                                }
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
        }
    })
    Vue.component('pdm-cert-info',pdmCertInfo);
});

</script>