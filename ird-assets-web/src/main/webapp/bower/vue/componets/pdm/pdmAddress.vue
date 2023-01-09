<template>
    <div>
        <form class="form-horizontal row-sm margin-top-10" id="form">
            <fieldset>
                <div>
                    <div class="col-sm-1_5">
                        <div class="pull-right">
                            <div class="control-radio float-left">
                                <input id="addrType1" name="addrType" value="O" type="radio" data-fieldset="fs-o">
                            </div>
                            <label class="control-label" v-text="pdmI18NList.MacauAddress">本澳地址-t</label>
                        </div>
                    </div>
                </div>
            </fieldset>
            
            <fieldset id="fs-o">
                <div class="form-group">
                    <label class="control-label col-sm-1_5" v-text="pdmI18NList.language">語言-t</label>
                    <div class="col-sm-4 atosFocus">
                        <select id="addrLang1" name="addrLang1" class="form-control select2" data-codeType="60101" selectAddress></select>
                    </div>
                    <label class="control-label col-sm-1_5" for="region1" v-text="pdmI18NList.region">地區-t</label>
                    <div class="col-sm-4 atosFocus">
                        <select id="region1" name="region1" class="form-control select2" selectAddress></select>
                    </div>
                </div>  
                
                <div class="form-group">
                    <label class="control-label col-sm-1_5" for="streetName1" v-text="pdmI18NList.streetName">街道名稱-t</label>
                    <div class="col-sm-4 atosFocus">
                        <select id="streetName1" name="streetName1" class="form-control select2" selectAddress></select>
                    </div>
                    <label class="control-label col-sm-1_5" for="bldingName1" v-text="pdmI18NList.bldingName">大廈名稱-t</label>
                    <div class="col-sm-4 atosFocus">
                        <select id="bldingName1" name="bldingName1" class="form-control select2" selectAddress></select>
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="control-label col-sm-1_5" v-text="pdmI18NList.bldingNo">門牌號碼-t</label>
                    <div class="col-xs-12 col-sm-4">
                        <input autocomplete="off" id="bldingNo1" maxLength="10" class="form-control" :placeholder="pdmI18NList.bldingNo" selectAddress>
                    </div>
                    <label class="control-label col-sm-1_5" for="bldingPhase1" v-text="pdmI18NList.bldingPhase">大廈期數-t</label>
                    <div class="col-xs-12 col-sm-2">
                        <input autocomplete="off" id="bldingPhase1" maxLength="10" class="form-control" :placeholder="pdmI18NList.bldingPhase" selectAddress>
                    </div>
                    <div class="col-xs-12 col-sm-2">
                        <select id="bldingPhaseUnit1" class="form-control select2" data-codeType="50003" selectAddress></select>
                    </div>
                </div>  
                
                <div class="form-group">
                    <label class="control-label col-sm-1_5" for="bldingFloor1" v-text="pdmI18NList.bldingFloor">大廈樓層-t</label>
                    <div class="col-xs-12 col-sm-4">
                        <input autocomplete="off" id="bldingFloor1" maxLength="10" class="form-control" :placeholder="pdmI18NList.bldingFloor" selectAddress>
                    </div>
                    <label class="control-label col-sm-1_5" for="bldingBlock1" v-text="pdmI18NList.bldingBlock">大廈樓座-t</label>
                        <div class="col-xs-12 col-sm-2">
                            <input autocomplete="off" id="bldingBlock1" maxLength="10" class="form-control" :placeholder="pdmI18NList.bldingBlock" selectAddress>
                        </div>
                    <label class="control-label col-sm-0_5" for="bldingSuite1" v-text="pdmI18NList.bldingSuite">室-t</label>
                    <div class="col-xs-12 col-sm-1_5">
                        <input autocomplete="off" id="bldingSuite1" maxLength="10" class="form-control" :placeholder="pdmI18NList.bldingSuite" selectAddress>
                    </div>
                </div>  
                
                <div class="form-group">
                    <label class="control-label col-sm-1_5" for="compAddrCN1" v-text="pdmI18NList.ownerAddrCn1">中文地址-t</label>
                    <div class="col-xs-12 col-sm-9_5">
                        <input id="ownerAddrCn1" name="ownerAddrCn1" class="form-control" maxLength="200" disabled :placeholder="pdmI18NList.ownerAddrCn1" selectAddress>
                    </div>
                </div> 
                
                <div class="form-group">
                    <label class="control-label col-sm-1_5" for="compAddrPT1" v-text="pdmI18NList.ownerAddrPt1">葡文地址-t</label>
                    <div class="col-xs-12 col-sm-9_5">
                        <input id="ownerAddrPt1" name="ownerAddrPt1" class="form-control" maxLength="200" disabled :placeholder="pdmI18NList.ownerAddrPt1" selectAddress>
                    </div>
                </div>         
            </fieldset>
            
            <fieldset id="fs-u">
                <div class="form-group">
                    <div class="col-sm-1_5" style="padding-right:0px">
                        <div class="pull-right">
                            <div class="control-radio float-left">
                                <input id="addrType2" name="addrType" value="U" type="radio" data-fieldset="fs-u">
                            </div>
                                <label class="control-label" for="addrType2" v-text="pdmI18NList.MacauManualAddress" style="padding-left:0px">本澳手動地址-t</label>
                        </div>
                    </div>
                 </div>
            
                 <div class="form-group">
                    <label class="control-label col-sm-1_5" v-text="pdmI18NList.language">語言-t</label>
                    <div class="col-sm-8 atosFocus" style="width:79.16666667%">
                        <select id="addrLang2" name="addrLang2" class="form-control select2"  data-codeType="60101" selectAddress></select>
                    </div>
                 </div> 







                 <div class="form-group">
                    <label class="control-label col-sm-1_5" for="compAddrCN2" v-text="pdmI18NList.ownerAddrCn2">中文詳細地址-t</label>
                    <div class="col-xs-12 col-sm-9_5 atosFocus">
                        <input type="text" id="ownerAddrCn2" name="ownerAddrCn2" class="form-control" :placeholder="pdmI18NList.ownerAddrCn2" selectAddress>
                    </div>
                 </div>
                 
                 <div class="form-group">
                    <label class="control-label col-sm-1_5" for="compAddrPT2" v-text="pdmI18NList.ownerAddrPt2">葡文詳細地址-t</label>
                    <div class="col-xs-12 col-sm-9_5 atosFocus">
                        <input type="text" id="ownerAddrPt2" name="ownerAddrPt2" class="form-control" :placeholder="pdmI18NList.ownerAddrPt2" selectAddress>
                    </div>
                </div>
            </fieldset>
            
            <fieldset id="fs-f">
                <div class="form-group">
                    <div class="col-sm-1_5">
                        <div class="pull-right">
                            <div class="control-radio float-left">
                                <input id="addrType3" name="addrType" value="F" type="radio" data-fieldset="fs-f">
                            </div>
                            <label class="control-label" for="addrType3" v-text="pdmI18NList.NotMacauAddress" style="padding-left:0px">非本澳地址-t</label>
                         </div>
                    </div>
            
                    <div class="col-xs-12 col-sm-9_5 atosFocus">
                        <input type="text" id="ownerAddrCn3" name="ownerAddrCn3" class="form-control" maxLength="200" :placeholder="pdmI18NList.NotMacauAddress" selectAddress>
                    </div>
                </div>
            </fieldset>
        </form>         
    </div>
</template>
<script>
define(['jquery','Vue','atosUtil','vueloader','select2','select2.config',],function($,Vue,atosUtil){
	var pdmAddress = Vue.extend({
        template:template,
        props:{
            usevalidator: {
	            type: Boolean,
	            default: false
			},
        },
        data:function(){
            return {
                pdmAddressInfoList:{
                    
                },
                pdmI18NList:{
                    MacauAddress:atosUtil.getI18nMessage('pdm.MacauAddress'),
                    bldingNo:atosUtil.getI18nMessage('pdm.bldingNo'),
                    bldingPhase:atosUtil.getI18nMessage('pdm.bldingPhase'),
                    bldingFloor:atosUtil.getI18nMessage('pdm.bldingFloor'),
                    bldingBlock:atosUtil.getI18nMessage('pdm.bldingBlock'),
                    bldingSuite:atosUtil.getI18nMessage('pdm.bldingSuite'),
                    ownerAddrCn1:atosUtil.getI18nMessage('pdm.ownerAddrCn1'),
                    ownerAddrPt1:atosUtil.getI18nMessage('pdm.ownerAddrPt1'),
                    ownerAddrCn2:atosUtil.getI18nMessage('pdm.ownerAddrCn2'),
                    ownerAddrPt2:atosUtil.getI18nMessage('pdm.ownerAddrPt2'),
                    NotMacauAddress:atosUtil.getI18nMessage('pdm.NotMacauAddress'),
                    language:atosUtil.getI18nMessage('pdm.language'),
                    region:atosUtil.getI18nMessage('pdm.region'),
                    streetName:atosUtil.getI18nMessage('pdm.streetName'),
                    bldingName:atosUtil.getI18nMessage('pdm.bldingName'),
                    MacauManualAddress:atosUtil.getI18nMessage('pdm.MacauManualAddress')
                }   
            }
        },
		methods:{
    		initEvent:function(){

                var useValidator = this.usevalidator;//是否使用校驗
                var self = this;

                $("#bldingPhaseUnit1").on('change', function () {
                    var data =  $(this).val();
                    self.pdmAddressInfoList.bldingPhaseUnit = data;
                });
                
                $("#bldingNo1").on('change', function () {
                    self.pdmAddressInfoList.bldingNo = $(this).val();
                });

                $("#bldingPhase1").on('change', function () {
                    self.pdmAddressInfoList.bldingPhase = $(this).val();
                });

                $("#bldingSuite1").on('change', function () {
                    self.pdmAddressInfoList.bldingSuite = $(this).val();
                });

                $("#bldingFloor1").on('change', function () {
                    self.pdmAddressInfoList.bldingFloor = $(this).val();
                });

                $("#bldingBlock1").on('change', function () {
                    self.pdmAddressInfoList.bldingBlock = $(this).val();
                });

                $('#ownerAddrCn2').on('change',function(){
                    self.pdmAddressInfoList.personalAddrCn = $('#ownerAddrCn2').val();
                });
                
                $('#ownerAddrPt2').on('change',function(){
                    self.pdmAddressInfoList.personalAddrPt = $('#ownerAddrPt2').val();
                });
                
                $('#ownerAddrCn1').on('change',function(){
                    self.pdmAddressInfoList.personalAddrCn = $('#ownerAddrCn1').val();
                });
                
                $('#ownerAddrPt1').on('change',function(){
                    self.pdmAddressInfoList.personalAddrPt = $('#ownerAddrPt1').val();
                });
                
                $('#ownerAddrCn3').on('change',function(){
                    self.pdmAddressInfoList.personalAddrCn = $('#ownerAddrCn3').val();
                });
                
                
                
                
                

                $("#addrLang2").on('change', function () {
                    var data =  $(this).val();
                    self.pdmAddressInfoList.addrLang = data;
                    if(data){
                        if(data=='C'){//中文
                            $('#ownerAddrPt2').removeAttr("disabled");//啟用葡文 
                            if(useValidator){
                                if($('#form').data('bootstrapValidator')!=undefined) {
                                    $('#form').data('bootstrapValidator').updateStatus("ownerAddrPt2","NOT_VALIDATED",null);//重置葡文校驗
                                }
                            }
                              
                            $('#ownerAddrCn2').removeAttr("disabled");//啟用中文
                            $('#ownerAddrPt2').attr('disabled', 'disabled').val('').empty().trigger('change');//禁用葡文 
                        }else if(data=='P'){//葡文
                            $('#ownerAddrCn2').removeAttr("disabled");//啟用中文
                            if(useValidator){
                                if($('#form').data('bootstrapValidator')!=undefined) {
                                    $('#form').data('bootstrapValidator').updateStatus("ownerAddrCn2","NOT_VALIDATED",null);//重置中文校驗
                                } 
                            }
                            $('#ownerAddrPt2').removeAttr("disabled");//啟用葡文
                            $('#ownerAddrCn2').attr('disabled', 'disabled').val('').empty().trigger('change');//禁用中文
                        }
                    }else{
                        $('#ownerAddrPt2').removeAttr("disabled");//啟用葡文
                        $('#ownerAddrCn2').removeAttr("disabled");//啟用中文 
                        if(useValidator){
                            if($('#form').data('bootstrapValidator')!=undefined) {
                                $('#form').data('bootstrapValidator').updateStatus("ownerAddrPt2","NOT_VALIDATED",null);//重置葡文校驗
                                $('#form').data('bootstrapValidator').updateStatus("ownerAddrCn2","NOT_VALIDATED",null);//重置中文校驗
                            }  
                        }
                        $('#ownerAddrPt2').attr('disabled', 'disabled').val('').empty().trigger('change');//禁用葡文
                        $('#ownerAddrCn2').attr('disabled', 'disabled').val('').empty().trigger('change');//禁用中文
                    }                  
                });


                $('input[name="addrType"]').on('change', function () {
                    $('#form input[selectAddress],select[selectAddress]').removeAttr("disabled");//取消禁用選中的標籤
                    if(useValidator){
                        if($('#form').data('bootstrapValidator')!=undefined) {//清除校驗
                            $('#form').data('bootstrapValidator').updateStatus("addrLang1","NOT_VALIDATED",null);
                            $('#form').data('bootstrapValidator').updateStatus("region1","NOT_VALIDATED",null);
                            $('#form').data('bootstrapValidator').updateStatus("streetName1","NOT_VALIDATED",null);
                            $('#form').data('bootstrapValidator').updateStatus("bldingName1","NOT_VALIDATED",null);
                            $('#form').data('bootstrapValidator').updateStatus("addrLang2","NOT_VALIDATED",null);
                            $('#form').data('bootstrapValidator').updateStatus("ownerAddrCn2","NOT_VALIDATED",null);
                            $('#form').data('bootstrapValidator').updateStatus("ownerAddrPt2","NOT_VALIDATED",null);                      
                            $('#form').data('bootstrapValidator').updateStatus("ownerAddrCn3","NOT_VALIDATED",null);   
                        }
                    }
                    $('#form input[selectAddress],select[selectAddress]').attr('disabled', 'disabled').val('').empty().trigger('change');//禁用選中標籤以及清除數據

                    //var val = $(this).val();
                    var val = this. defaultValue;
                    self.pdmAddressInfoList.addrType = val;
                    if(val == 'O') {
                        $('#addrLang1').removeAttr("disabled"); 
                        $("#addrLang1").select2Remote({
                            url: basePath + '/select2/page'
                        });
                        var $language1 = $('#addrLang1');
                        var address = {
                        language: 'cname',
                        languageMap: { 'P': 'pname', 'C': 'cname' }
                        };
                
                        $("#addrLang1").on('change', function () {
                            var addrLang = $language1 || '';
                            if (addrLang) {
                                address.language = address.languageMap[addrLang.val()];
                            }
                        });

                        var processParams = function (params, data) {
                            return $.extend({}, {
                                'keyword': params && params.term ? '%' + params.term + '%' : '',
                                'pageNumber': params.page || 1,
                                'pageSize': 30
                            }, data);
                        };
                        
                        var processResults = function (pdaResponse, params) {
                            var results = [];
                            $.each(pdaResponse.data, function (index, obj) {
                                results.push({ id: obj.id, text: obj[address.language] || obj.text });
                            });
                            return {
                                results: results,
                                pagination: {
                                    more: (params.page || 1) * 30 < (pdaResponse['totalElements'] || 10)
                                }
                            };
                        };

                        $("#addrLang1").on('change', function () {
                            if(useValidator){
                                if($('#form').data('bootstrapValidator')!=undefined){
                                    $('#form').data('bootstrapValidator').updateStatus("region1","NOT_VALIDATED",null);
                                }  
                            }
                            var data =  $(this).val();
                            self.pdmAddressInfoList.addrLang = data;//綁定值 
                            if(data!='' && data!=null) {
                                $('#region1').removeAttr("disabled").val('').empty().trigger('change');
                                $("#region1").select2Remote({
                                    url: basePath + '/select2/selectLocation',
                                    processResults: function (pdaResponse, params) {
                                        return processResults(pdaResponse, params);
                                    }
                                });
                            } else {
                                $('#region1').attr('disabled', 'disabled').val('').empty().trigger('change');
                                $('#region1').select2();
                            }
                        });

                        $("#region1").on('change', function () {

                            if(useValidator){
                                if($('#form').data('bootstrapValidator')!=undefined){//重置本澳地址-街道的校驗
                                    $('#form').data('bootstrapValidator').updateStatus("streetName1","NOT_VALIDATED",null);
                                }  
                            }
                                                
                            var region1 = $(this).val();
                            self.pdmAddressInfoList.region = region1;
                            if(region1){
                                $('#streetName1').removeAttr("disabled").val('').empty().trigger('change');//清除街道+啟用街道
                                $("#streetName1").select2Remote({
                                    url:basePath + '/select2/selectStreet',
                                    data: function(params){
                                        return processParams(params, {
                                            'locationCode': region1
                                        });
                                    },
                                    processResults: function(pdaResponse, params){
                                        return processResults(pdaResponse, params);
                                    }
                                });
                            }else {
                                $('#streetName1').attr('disabled', 'disabled').val('').empty().trigger('change');//清除街道+禁用街道
                                $('#streetName1').select2();
                            }
                        });

                        $("#streetName1").on('change', function () {

                            if(useValidator){
                                if($('#form').data('bootstrapValidator')!=undefined){//重置大廈名稱的校驗
                                    $('#form').data('bootstrapValidator').updateStatus("bldingName1","NOT_VALIDATED",null);
                                }  
                            }
                            var street = $(this).val();
                            self.pdmAddressInfoList.streetName = street;//綁定值
                            if(street) {
                                $('#bldingName1').removeAttr("disabled").val('').empty().trigger('change');//清除大廈名稱+啟用大廈名稱
                                $("#bldingName1").select2Remote({
                                    url: basePath + '/select2/selectBuilding',
                                    data: function (params) {
                                        return processParams(params, {
                                            'streetCode': street
                                        });
                                    },
                                    processResults: function (pdaResponse, params) {
                                        return processResults(pdaResponse, params);
                                    }
                                });
                            } else {
                                $('#bldingName1').attr('disabled', 'disabled').val('').empty().trigger('change');
                                $('#bldingName1').select2();
                            }
                        });

                        $("#bldingName1").on('change', function () {
                            var data =  $(this).val();
                            self.pdmAddressInfoList.bldingName = data;

                            if(useValidator){
                                if($('#form').data('bootstrapValidator')!=undefined){//重置大廈名稱的校驗
                                    $('#form').data('bootstrapValidator').validateField('addrLang1'); 
                                    $('#form').data('bootstrapValidator').validateField('region1'); 
                                    $('#form').data('bootstrapValidator').validateField('streetName1'); 
                                }  
                            }

                            
                            if(data !=''&& data !=null) {
                                $("#bldingPhaseUnit1").select2Remote({
                                    url: basePath + '/select2/page',
                                    processResults: function (pdaResponse, params) {
                                        return processResults(pdaResponse, params);
                                    }
                                });  
                                $('#bldingNo1').removeAttr("disabled").val('').empty().trigger('change');//清除門牌號碼+啟用門牌號碼
                                $('#bldingPhase1').removeAttr("disabled").val('').empty().trigger('change');//清除大廈期數+啟用大廈期數
                                $('#bldingPhaseUnit1').removeAttr("disabled").empty().val('').trigger('change');//清除單位+啟用單位
                                $('#bldingFloor1').removeAttr("disabled").val('').empty().trigger('change');//清除樓層+啟用樓層
                                $('#bldingBlock1').removeAttr("disabled").val('').empty().trigger('change');//清除樓座+啟用樓座
                                $('#bldingSuite1').removeAttr("disabled").val('').empty().trigger('change');//清除室+啟用室
                            } else {
                                $('#bldingNo1').attr('disabled', 'true').val('').empty().trigger('change');//清除門牌號碼+禁用門牌號碼
                                $('#bldingPhase1').attr('disabled', 'disabled').val('').empty().trigger('change');//清除大廈期數+禁用大廈期數
                                $('#bldingPhaseUnit1').attr('disabled', 'disabled').val('').empty().trigger('change');//清除單位+禁用單位
                                $('#bldingPhaseUnit1').select2();
                                $('#bldingFloor1').attr('disabled', 'disabled').val('').empty().trigger('change');//清除樓層+禁用樓層
                                $('#bldingBlock1').attr('disabled', 'disabled').val('').empty().trigger('change');//清除樓座+禁用樓座
                                $('#bldingSuite1').attr('disabled', 'disabled').val('').empty().trigger('change');//清除室+禁用室
                                }
                        });

                        $('#addrLang2').select2();
                    }else if(val== 'U') {
                        $('#addrLang2').removeAttr("disabled");
                        $("#addrLang2").select2Remote({
                            url: basePath + '/select2/page'
                        }); 
                        $('#addrLang1').select2();
                        $('#region1').select2();
                        $('#streetName1').select2();
                        $('#bldingName1').select2();
                    }else if(val== 'F') {
                        $('#ownerAddrCn3').removeAttr("disabled");
                        $('#addrLang1').select2();
                        $('#addrLang2').select2();
                        $('#region1').select2();
                        $('#streetName1').select2();
                        $('#bldingName1').select2();
                    }        
                });

                $("#fs-o").find('select').change(function(){
                    editAddr();
                });

                $("#fs-o").bind('input propertychange',function(){
                    editAddr();
                });

                function editAddr(){
                    var language = $("#addrLang1").val();
                    if(language){
                        var $region =$("#region1").find('option:selected').text();
                        var $street = $("#streetName1").find('option:selected').text();
                        var $buildingNo = $("#bldingNo1").val();
                        var $buildingName =$("#bldingName1").find('option:selected').text();
                        var $buildingPhase =$("#bldingPhase1").val();
                        var $bldingPhaseUnit =$("#bldingPhaseUnit1").find('option:selected').text();
                        var $bldingFloor =$("#bldingFloor1").val(); 
                        var $bldingBlock =$("#bldingBlock1").val(); 
                        var $bldingSuite =$("#bldingSuite1").val(); 
                        
                        if(language=='P'){
                            $("#ownerAddrCn1").val('');
                            self.pdmAddressInfoList.personalAddrCn = '';
                            if($buildingNo){
                                $buildingNo="No."+$buildingNo+" ";
                            }
                            if($bldingFloor){
                                $bldingFloor=" "+$bldingFloor+" Andar";
                            }

                            if($street!=''){
                                $region = " "+$region;    
                            }
                            if($buildingName!=''){
                                $street = $street+" ";
                            }
                            if($buildingPhase!=''){
                                $buildingPhase = " "+$buildingPhase;
                            }
                            if($bldingPhaseUnit!=''){
                                $bldingPhaseUnit = " "+$bldingPhaseUnit;
                            }
                            if($bldingBlock!=''){
                                $bldingBlock = " "+$bldingBlock;
                            }
                            if($bldingSuite!=''){
                                $bldingSuite = " "+$bldingSuite;
                            }
                            $("#ownerAddrPt1").val(
                                    $street+//街道
                                    $buildingNo+//門牌號
                                    $buildingName+//大廈名稱
                                    $bldingPhaseUnit+//單位
                                    $buildingPhase+//期數
                                    $bldingFloor+//樓層
                                    $bldingBlock+//樓座
                                    $bldingSuite+//室
                                    $region//地區
                                    );
                            self.pdmAddressInfoList.personalAddrPt=$("#ownerAddrPt1").val();
                        }else if(language=='C'){
                            $("#ownerAddrPt1").val('');
                            self.pdmAddressInfoList.personalAddrPt = '';
                            var reg=/^[0-9]{1,10}$/;/*定义验证表达式*/   
                            //alert(reg.test($buildingNo))
                            if(reg.test($buildingNo))//进行正则校验
                            {
                                $buildingNo = $buildingNo+"號";
                            }
                            if(reg.test($bldingFloor))
                            {
                                $bldingFloor = $bldingFloor+"樓";
                            }
                            if(reg.test($bldingBlock))
                            {
                                $bldingBlock = $bldingBlock+"座";
                            }
                            if(reg.test($bldingSuite))
                            {
                                $bldingSuite = $bldingSuite+"室";
                            }
                            //拼接屬性，獲取中文地址
                            $("#ownerAddrCn1").val(
                                    $region+
                                    $street+
                                    $buildingNo+
                                    $buildingName+
                                    $buildingPhase+
                                    $bldingPhaseUnit+
                                    $bldingFloor+
                                    $bldingBlock+
                                    $bldingSuite);
                            self.pdmAddressInfoList.personalAddrCn=$("#ownerAddrCn1").val();
                        }
                    }else{
                        $("#ownerAddrCn1").val('');
                        self.pdmAddressInfoList.personalAddrCn = '';
                        $("#ownerAddrPt1").val('');
                        self.pdmAddressInfoList.personalAddrPt = '';
                    }
                }




                //$("#addrType1").attr("checked","checked").trigger('change');//默認選中本澳地址

                
                if(this.usevalidator){
                    $('#form').bootstrapValidator({
                        fields: {
                            addrLang1: {
                                validators: {
                                    notEmpty: {}
                                }
                            },
                            region1: {
                                validators: {
                                    notEmpty: {}
                                }
                            },
                            streetName1: {
                                validators: {
                                    notEmpty: {}
                                }
                            },
                            bldingName1: {
                                validators: {
                                    notEmpty: {}
                                }
                            },
                            ownerAddrCn3: {
                                validators: {
                                    notEmpty: {}
                                }
                            },
                            ownerAddrCn2: {
                                validators: {
                                    notEmpty: {}
                                }
                            },
                            ownerAddrPt2: {
                                validators: {
                                    notEmpty: {}
                                }
                            },
                            addrLang2: {
                                validators: {
                                    notEmpty: {}
                                }
                            }
                            
                        }
                    });
                    $('#form :input.form-control').closest('.form-group, [class*="col-"]').addClass('form-validator has-feedback');
                }

                



                
                
            },
		},
		mounted:function(){
            this.initEvent();  
		}
	})	
    Vue.component('pdm-address',pdmAddress);
});

</script>

