<template>
    <form id="fm-master" class="form-horizontal row-sm margin-top-10">
        <div class="form-group">
            <label :class="isRequired" v-text="pdmI18NList.birthDate">出生日期-t </label>
            <div class="col-sm-4">
                <div class="input-group" style="width:100%">
                    <div class="rowGroup atosFocus col-sm-7" style="padding-left:0px;padding-right:0px;">
                        <input id="birthDate" name="birthDate" class="form-control form-date" type="text" placeholder="dd/MM/yyyy" v-model="pdmMasterInfoList.birthDate">
                    </div>
                    <div class="input-group-addon col-sm-1_5" style="padding-left:0px;padding-right:0px;height:34px;">
                        <span v-text="pdmI18NList.age">年齡-t</span>
                    </div>
                    <div class="rowGroup col-sm-3_5" style="padding-left:0px;padding-right:0px;">
                        <input name="age" id="age" v-model="pdmMasterInfoList.age" class="form-control" type="text" readonly unselectable="on" :placeholder="pdmI18NList.age" style="background-color:#fff;border-top-left-radius:0px;border-bottom-left-radius:0px;border-top-right-radius:4px;border-bottom-right-radius:4px">
                    </div>
                </div>
                <div style="margin-left:200px;display:none" id="birthDateValidator" class="help-block"></div>
                <div style="margin-left:200px;display:none" id="ageValidator" class="help-block"></div>
            </div>
            <label :class="isRequired" v-text="pdmI18NList.gender">性別-t</label>    
            <div class="col-sm-2">
                <div class="rowGroup atosFocus">
                    <input id="isSexM" value="M" name="gender" type="radio" v-model="pdmMasterInfoList.gender">
                    <label class="control-label" for="isSexM" v-text="pdmI18NList.male">男-t</label>
                    <input id="isSexF" value="F" name="gender" type="radio" style="margin-left:20px;" v-model="pdmMasterInfoList.gender">
                    <label class="control-label" for="isSexF" v-text="pdmI18NList.female">女-t</label>
                </div>
            </div>
            <div class="col-sm-2_5" style="margin-left:-15px">
                <label class="control-label col-sm-5" v-text="pdmI18NList.disabled">傷健人士-t</label>
                <div class="col-sm-3 margin-top-5" >
                    <input id="pdmDisabled" type="checkbox" disabled> 
                </div>
            </div>             
        </div>
        
        <div class="form-group">
            <label :class="isRequired" v-text="pdmI18NList.birthPlace">出生地-t</label>
            <div class="col-sm-4">
                <div class="rowGroup atosFocus">
                    <select class="form-control select2" id="placeOfBirth" name="placeOfBirth" data-codeType="31004"></select>
                </div>
            </div>
            <label :class="isRequired" v-text="pdmI18NList.language">語言-t</label>
            <div class="col-sm-4">
                <div class="rowGroup atosFocus">
                    <select class="form-control select2" id="language" name="language" data-codeType="60102"></select>
                </div>
            </div>
        </div>

        <div class="form-group" id="otherPlaceOfBirth" :class="{ hide:isHideOtherPlaceOfBirth}">
            <label class="control-label col-sm-1_5 " v-text="pdmI18NList.birthPlaceManual">手動出生地名稱-t</label>
            <div class="col-sm-9_5">
                <input v-model="pdmMasterInfoList.birthPlaceManual" class="form-control" type="text" :placeholder="pdmI18NList.birthPlaceManual"  >
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-1_5 " v-text="pdmI18NList.mobile" >本澳流動電話-t</label>
            <div class="col-sm-4">
                <div class="rowGroup atosFocus">
                    <input v-model="pdmMasterInfoList.mobile" class="form-control" name="mobile" type="text" :placeholder="pdmI18NList.mobile">
                </div>
            </div>
            <label class="control-label col-sm-1_5 " v-text="pdmI18NList.tel">其他電話-t</label>
            <div class="col-sm-4">
                <input v-model="pdmMasterInfoList.tel" maxlength="30" class="form-control" type="text" :placeholder="pdmI18NList.tel" >
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-1_5 " v-text="pdmI18NList.fax" >傳真號碼-t</label>
            <div class="col-sm-4">
                <input v-model="pdmMasterInfoList.fax" maxlength="30" class="form-control" type="text" :placeholder="pdmI18NList.fax"  >
            </div>
            <label class="control-label col-sm-1_5 " v-text="pdmI18NList.email">電郵地址-t</label>
            <div class="col-sm-4">
                <div class="rowGroup atosFocus">
                    <input v-model="pdmMasterInfoList.email" maxlength="30" class="form-control" name="email" type="text" :placeholder="pdmI18NList.email" >
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-1_5 " v-text="pdmI18NList.remark">備注-t</label>
            <div class="col-sm-9_5">
                <textarea v-model="pdmMasterInfoList.remark" class="form-control" rows="3"></textarea>
            </div>
        </div>

    </form>
</template>
<script>
define(['jquery','atosUtil','Vue','vueloader','select2','select2.config','datetimepicker.config'],function($,atosUtil,Vue){
	var pdmMasterInfo = Vue.extend({
        template:template,
        props:{
            isHideOtherPlaceOfBirth:{
				type:Boolean,
				default:true
            },
            usevalidator:{
                type:Boolean,
				default:false
            },
            dlspdmagelimit:{
                type:String,
                defalut:'18'
            },
            isRequired:{
                type:String,
				default:'control-label col-sm-1_5'
            },
            
        },
        
        data:function(){
            return {
                pdmMasterInfoList:{
                    age:'',
                    birthDate:'',
                    gender:'',
                    remark:''
                },
                pdmI18NList:{
                    email:atosUtil.getI18nMessage('pdm.email'),
                    mobile:atosUtil.getI18nMessage('pdm.mobile'),
                    birthDate:atosUtil.getI18nMessage('pdm.birthDate'),
                    age:atosUtil.getI18nMessage('pdm.age'),
                    gender:atosUtil.getI18nMessage('pdm.gender'),
                    male:atosUtil.getI18nMessage('pdm.male'),
                    female:atosUtil.getI18nMessage('pdm.female'),
                    disabled:atosUtil.getI18nMessage('pdm.disabled'),
                    birthPlace:atosUtil.getI18nMessage('pdm.birthPlace'),
                    language:atosUtil.getI18nMessage('pdm.language'),
                    birthPlaceManual:atosUtil.getI18nMessage('pdm.birthPlaceManual'),
                    tel:atosUtil.getI18nMessage('pdm.tel'),
                    fax:atosUtil.getI18nMessage('pdm.fax'),
                    remark:atosUtil.getI18nMessage('pdm.remark')
                }   
            }
        },
		methods:{
    		initEvent:function(){
                var self = this;
                var useValidator = this.usevalidator;//是否使用校驗的標誌,為true則使用校驗，為false則不使用校驗
                var dlsPdmAgeLimit = this.dlspdmagelimit;//年齡限制，為18
                
                var sysDateText = atosUtil.getSysDate(); // 獲取系統時間字符串
                var sysDate = atosUtil.dateToDate(sysDateText); // 變成date類型
                
                var birthDateStart = atosUtil.getDate19000101();

                $('#birthDate').datetimepicker({
                    trigger:'change',
                    startDate:birthDateStart,
                    endDate: sysDate
                }).on('changeDate', function(ev) {
                    self.pdmMasterInfoList.birthDate = ev.date.format("dd/MM/yyyy");
                    self.pdmMasterInfoList.age = jsGetAge(ev.date);
                });

                $('#birthDate').on('change',function() {
                    var patt = /^(((0[1-9]|1[0-9]|2[0-8])\/(0[1-9]|1[0-2])|(29|30)\/(0[13-9]|1[0-2])|(31\/(0[13578]|1[02])))\/(?!0000)[0-9]{4})|((29\/02\/[0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00))$/;
                    if(patt.test($(this).val())){
                        self.pdmMasterInfoList.birthDate = $(this).val();
                        var date = $(this).val();
                        var array = date.split('/');
                        var dateString = array[2]+"-"+array[1]+"-"+array[0];
                        self.pdmMasterInfoList.age = jsGetAge(new Date(dateString));
                        self.pdmMasterInfoList.birthDate = $(this).val();
                        $('#age').val(self.pdmMasterInfoList.age).trigger('change');
                    }else{
                        self.pdmMasterInfoList.age = -1;
                        $('#age').val(self.pdmMasterInfoList.age).trigger('change');
                    }
                    
                })
                
                /*
                * dsat的ie11在使用日期組件的情況下輸入日期，
                * 會導致無法獲取age的bug。所以使用birthDate的blur事件，
                * 在blur事件中模擬change事件來觸發birthDate的change事件。
                */
                $('#birthDate').on('blur',function() {
                    $('#birthDate').trigger('change');
                })

                $('#age').on('change',function(){
                    if(useValidator){
                        if($('#fm-master').data('bootstrapValidator')!=undefined) {//清除校驗
                            $('#fm-master').data('bootstrapValidator').updateStatus("age","NOT_VALIDATED",null);
                            $('#fm-master').data('bootstrapValidator').validateField('age'); 
                        }
                       
                    }
                })

                $("#placeOfBirth").select2Remote({
                    url: basePath + '/select2/page'
                });

                $("#language").select2Remote({
                    url: basePath + '/select2/page'
                });


                $("#placeOfBirth").on('change', function () {
                    var data =  $(this).val();
                    self.pdmMasterInfoList.birthPlaceCode = data;
                    if(data=='X') {
                        self.isHideOtherPlaceOfBirth = false;
                    } else {
                         self.isHideOtherPlaceOfBirth = true;
                         self.pdmMasterInfoList.birthPlaceManual ='';
                    } 
                });

                $("#language").on('change', function () {
                    self.pdmMasterInfoList.language = $(this).val();
                });




                function jsGetAge(birthDate) {
                    var returnAge;
                    if(birthDate!=null){
                        var birthYear = 1900 + birthDate.getYear();
                        var birthMonth = birthDate.getMonth() + 1;
                        var birthDate = birthDate.getDate();
                    }
                    var d = new Date();
                    var nowYear = 1900 + d.getYear();
                    var nowMonth = d.getMonth() + 1;
                    var nowDay = d.getDate();

                    if (nowYear == birthYear) {
                        returnAge = 0;//同年 则为0岁  
                    } else {
                        var ageDiff = nowYear - birthYear; //年之差  
                        if (ageDiff > 0) {
                            if (nowMonth == birthMonth) {
                                var dayDiff = nowDay - birthDate;//日之差  
                                if (dayDiff < 0) {
                                    returnAge = ageDiff - 1;
                                }else {
                                    returnAge = ageDiff;
                                }
                            } else {
                                var monthDiff = nowMonth - birthMonth;//月之差  
                                if (monthDiff < 0) {
                                    returnAge = ageDiff - 1;
                                } else {
                                    returnAge = ageDiff;
                                }
                            }
                        } else {
                            returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天  
                            }
                        }
                    return returnAge;//返回周岁年龄  
                }


            

                if(useValidator){
                    this.isRequired = 'control-label col-sm-1_5 required';
                }
                Vue.nextTick(function(){
                    if(useValidator){
                        $('#fm-master').bootstrapValidator({
                            group: '.rowGroup',
                            fields: {
                                birthDate: {
                                    container: "#birthDateValidator",
                                    trigger: 'change',
                                    validators: {
                                        notEmpty: { },
                                        callback :{
                                            callback :function(value,validator){ 
                                                var patt = /^(((0[1-9]|1[0-9]|2[0-8])\/(0[1-9]|1[0-2])|(29|30)\/(0[13-9]|1[0-2])|(31\/(0[13578]|1[02])))\/(?!0000)[0-9]{4})|((29\/02\/[0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00))$/;
                                                if(patt.test(value)){
                                                    //如果通過正則表達式
                                                    var dateString = value;
                                                    var array = dateString.split('/');
                                                    var dateString = array[2]+"-"+array[1]+"-"+array[0];
                                                    var birth = new Date(dateString);
                                                    var age = jsGetAge(birth);
                                                    if(value!='' && age<dlsPdmAgeLimit){
                                                        $('#birthDateValidator').css('display','');
                                                        $('#ageValidator').css('display','none');
                                                        validator.updateMessage('birthDate', 'callback',atosUtil.getI18nMessage('pdm.birthDate.age18'));
                                                        return false;
                                                    }

                                                    if(array[2]<1900){
                                                        $('#birthDateValidator').css('display','');
                                                        $('#ageValidator').css('display','none');
                                                        validator.updateMessage('birthDate','callback','出生日期必須大於01/01/1900!');
                                                        return false;
                                                    }
                                                }else{
                                                    $('#birthDateValidator').css('display','');
                                                    $('#ageValidator').css('display','none');
                                                    validator.updateMessage('birthDate', 'callback',atosUtil.getI18nMessage('pdm.notIllegalDate'));
                                                    return false;
                                                }
                                                return true;
                                            }
                                        }
                                    }
                                },
                                age: {
                                    container: "#ageValidator",
                                    validators: {
                                        notEmpty: {},
                                        callback:{
                                            callback:function(value,validator){
                                                var date19000101obj = atosUtil.getDate19000101();
                                                var age1900 = jsGetAge(date19000101obj);
                                                if(value>age1900){
                                                    validator.updateMessage('age', 'callback','出生日期信息異常!');
                                                    $('#birthDateValidator').css('display','none');
                                                    $('#ageValidator').css('display','');
                                                    return false;
                                                }

                                                if(value!=''&&value>=dlsPdmAgeLimit)
                                                    return true;
                                                validator.updateMessage('age', 'callback',atosUtil.getI18nMessage('pdm.birthDate.age18'));
                                                $('#birthDateValidator').css('display','none');
                                                $('#ageValidator').css('display','');
                                                return false;
                                            }
                                        }
                                    }
                                },
                                mobile: {
                                    validators: {
                                        regexp: {
                                            regexp: /^6[0-9]{7}$/,
                                            message: atosUtil.getI18nMessage('pdm.mobile.regexp')
                                        }
                                    }
                                },
                                email: {
                                    validators: {
                                        regexp: {
                                            regexp:/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/,
                                            message: atosUtil.getI18nMessage('pdm.email.regexp')
                                        }
                                    }
                                },
                                gender: {
                                    validators: {
                                        notEmpty: {}
                                    }
                                },
                                placeOfBirth: {
                                    validators: {
                                        notEmpty: {}
                                    }
                                },
                                language: {
                                    validators: {
                                        notEmpty: {}
                                    }
                                }
                            }
                        });   
                        $('#fm-master :input.form-control').closest('.form-group, [class*="col-"]').addClass('form-validator has-feedback'); 
                    }
                })
            }
		},
		mounted:function(){
            this.initEvent();
            
		}
	})	
    Vue.component('pdm-master-info',pdmMasterInfo);
});

</script>

