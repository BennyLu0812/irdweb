<template>
    <div>

        <div id="wxImg" style="z-index:10;width:400px;height:600px;position:absolute;display:none">
            <img style="float:right;display:none;height:600px;vertical-align:middle;" id="img" src="">
        </div>

        <form class="form-horizontal form-group-sm margin-top-10">
            <div class="row">
                <label class="control-label col-sm-1_5 " v-text="pdmI18NList.birthDate">出生日期-t </label>
                <div class="col-sm-3">
                    <span class="text-readonly"><span v-text="customerInfo.birthDate"></span>&nbsp;<span style="font-weight: bold;">(<span v-text="customerInfo.age"></span><span v-text="pdmI18NList.ageUnit"></span>)</span></span>
                </div>

                <label class="control-label col-sm-1_5 " v-text="pdmI18NList.gender">性別-t </label>
                <div class="col-sm-2">
                    <span class="text-readonly"><span v-text="customerInfo.genderDesc"></span></span>
                </div>

                <div v-if="isupload==true">
                    <div class="form-group col-sm-3" style="position:absolute; right: 65px;">
                    <div class="col-sm-10">
                            <center>
                                <img v-if="editPhoto" id="photo" @click="editPdmPhoto()" style="z-index:9;cursor:pointer;height:160px;vertical-align:middle;">
                                <img v-if="!editPhoto" id="photo" style="z-index:9;height:160px;vertical-align:middle;">
                            </center>

                            <center>
                                <button v-if="editButton" id="editPdmInfo" class="btn btn-sm btn-primary" style="margin-top:10px;" type="button" @click="doEdit();">
                                    <i class="glyphicon glyphicon-edit"></i> <span v-text="pdmI18NList.editInfo">資料修改</span>
                                </button>
                            </center>
                        </div>
                    </div>
                </div>

                <div v-if="isupload==false">
                    <div class="form-group col-sm-3" style="position:absolute; right: 65px;">
                    <div class="col-sm-10">
                            <center>
                                <img id="photo" style="cursor:pointer;height:160px;vertical-align:middle;">
                            </center>
                        </div>
                    </div>
                </div>

            </div>
            <div class="row">
                <label class="control-label col-sm-1_5"v-text="pdmI18NList.birthPlace">出生地 </label>
                <div class="col-sm-3">
                    <span class="text-readonly"><span v-text="customerInfo.birthPlaceCodeDesc"></span></span>
                </div>

                <label class="control-label col-sm-1_5 " v-text="pdmI18NList.language">使用語言</label>
                <div class="col-sm-2">
                    <span class="text-readonly"><span v-text="customerInfo.languageDesc"></span></span>
                </div>
            </div>

            <div class="row">
                <label class="control-label col-sm-1_5 " v-text="pdmI18NList.mobile">本澳流動電話</label>
                <div class="col-sm-3">
                    <span class="text-readonly" v-text="customerInfo.mobile"></span>
                </div>
                <label class="control-label col-sm-1_5" v-text="pdmI18NList.tel">其他電話</label>
                <div class="col-sm-2">
                    <span class="text-readonly" v-text="customerInfo.tel"></span>
                </div>
            </div>

            <div class="row">
                <label class="control-label col-sm-1_5 " v-text="pdmI18NList.fax">傳真號碼</label>
                <div class="col-sm-3">
                    <span class="text-readonly" v-text="customerInfo.fax"></span>
                </div>
                <label class="control-label col-sm-1_5 " v-text="pdmI18NList.email">電子郵件</label>
                <div class="col-sm-2">
                    <span class="text-readonly" v-text="customerInfo.email"></span>
                </div>
             </div>

            <div class="row">
                <label class="control-label col-sm-1_5" v-text="pdmI18NList.ownerAddrCn2">中文詳細地址</label>
                <div class="col-sm-3">
                    <span class="text-readonly" v-text="customerInfo.personalAddrCn"></span>
                </div>

                <label class="control-label col-sm-1_5" v-text="pdmI18NList.disabled">傷健人士 </label>
                <div class="col-sm-1 margin-top-5">
                    <input id="pdmDisabled" type="checkbox" disabled>
                </div>
            </div>

            <div class="row">
                <label class="control-label col-sm-1_5 " v-text="pdmI18NList.ownerAddrPt2">葡文詳細地址</label>
                <div class="col-sm-3">
                    <span class="text-readonly" v-text="customerInfo.personalAddrPt"></span>
                </div>

                <label class="control-label col-sm-1_5 " v-text="pdmI18NList.masterId">主檔Id:</label>
                <div class="col-sm-2">
                    <span class="text-readonly" v-text="customerInfo.docId"></span>
                </div>
            </div>

            <div class="row">
                <label class="control-label col-sm-1_5 " v-text="pdmI18NList.remark">備注</label>
                <div class="col-sm-6">
                    <span class="text-readonly" v-text="customerInfo.remark"></span>
                </div>
            </div>
        </form>

        <div class="panel-group margin-top-10" id="accordion">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse-cert-info" v-text="pdmI18NList.certInfo"> 證件信息 <i class="fa fa-arrow"></i></a>
                    </h4>
                </div>
                <div id="collapse-cert-info" class="panel-collapse collapse in">
                    <div class="panel-body">
                        <table id="table" class="table table-bordered table-hover table-condensed dataTable" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>
                                        <div v-text="pdmI18NList.personalIdentNo">證件編號</div>
                                        <div class="text-muted" v-text="pdmI18NList.personalIdentType">證件類型</div>
                                    </th>
                                    <th>
                                        <div>
                                            <span v-text="pdmI18NList.fullNameCn">中文全名</span>
                                        </div>
                                        <div class="text-muted">
                                            <span v-text="pdmI18NList.fullNameEn">葡文全名</span>
                                        </div>
                                    </th>
                                    <th>
                                        <div v-text="pdmI18NList.validDate">有效期</div>
                                        <div class="text-muted" v-text="pdmI18NList.issueDate">簽發日期</div>
                                    </th>

                                    <th v-text="pdmI18NList.identRecordStatus">證件記錄狀態</th>

                                    <th>
                                        <div v-text="pdmI18NList.searchNumber">查詢編號</div>
                                        <div class="text-muted" v-text="pdmI18NList.lastService">最後辦理服務</div>
                                    </th>

                                    <th>
                                        <div>
                                            <span v-text="pdmI18NList.createDate">創建日期</span>
                                        </div>
                                        <div class="text-muted">
                                            <span v-text="pdmI18NList.createUser">創建用戶</span>
                                        </div>
                                    </th>

                                    <th>
                                        <div>
                                            <span v-text="pdmI18NList.lastUpdDate">最後更新日期</span>
                                        </div>
                                        <div class="text-muted">
                                            <span v-text="pdmI18NList.lastUpdUser">最後更新用戶</span>
                                        </div>
                                    </th>



                                    <th>
                                        <div>
                                            <span v-text="pdmI18NList.action">操作</span>
                                        </div>
                                    </th>

                                </tr>
                            </thead>
                        </table>
                    </div><!-- end of panel-body -->
                </div><!-- end of collapse -->
            </div>
        </div>
        <!-- <div v-if="isupload==true">
            <div style="margin-left:-10px">
                <div class="col-sm-12" sytle="margin-top:25px;">
                    <div class="btn-group" role="group">
                        <button id="backBtn" type="button" class="btn btn-default" onclick="javascript:controller.doBack()">
                            <i class="fa fa-reply"></i> <span v-text="pdmI18NList.back">返回</span>
                        </button>
                        <button th:text="#{pdm.showPhotoList}" onclick="javascript:controller.showPhotoList();" class="btn btn-default" >
                            <span v-text="pdmI18NList.showPhotoList">查看相片列表</span>
                        </button>
                        <button sec:authorize="hasPermission('DLS-PDM-SHOW-ALERT')"  onclick="javascript:controller.showAlert();" class="btn btn-default" type="button"><span v-text="pdmI18NList.caution">警示</span> <span id="altCount" class="badge hidden" style="background:red"></span></button>
                        <button class="btn btn-default" type="button" onclick="javascript:controller.backToCompQuery()"><span v-text="pdmI18NList.returnDevSearch">返回綜合查詢</span></button>
                    </div>
                </div>
            </div>
        </div> -->

        <div v-if="isupload==false&&showback==true">
            <div id="showBackDiv">

            </div>
        </div>

        <!-- <div v-if="isupload==false&&showback==true">
            <div style="margin-left:-10px">
                <div class="col-sm-12" sytle="margin-top:25px;">
                    <div class="btn-group" role="group">
                         <button id="backBtn" type="button" class="btn btn-default" onclick="javascript:controller.doBack()">
                            <i class="fa fa-reply"></i> <span v-text="pdmI18NList.back">返回</span>
                        </button>
                    </div>
                </div>
            </div>
        </div> -->
    </div>
</template>
<script>
define(['jquery','Vue','axios','atosUtil','vueloader','axios.config','datatables.config'],function($,Vue,axios,atosUtil){
	var pdmDriverDetail = Vue.extend({
        template:template,
        props:{
            isupload:{
                type:Boolean,
                default:false
            },
            showback:{
                type:Boolean,
                default:false
            },
            docid:{
                type:Number
            },
            editButton:{
                type:Boolean,
                default:false
            },
            editPhoto:{
                type:Boolean,
                default:false
            }
        },
        data:function(){
            return {
                customerInfo:{},
                pdmI18NList:{
                    birthDate:atosUtil.getI18nMessage('pdm.birthDate'),
                    gender:atosUtil.getI18nMessage('pdm.gender'),
                    editInfo:atosUtil.getI18nMessage('pdm.editInfo'),
                    birthPlace:atosUtil.getI18nMessage('pdm.birthPlace'),
                    language:atosUtil.getI18nMessage('pdm.language'),
                    mobile:atosUtil.getI18nMessage('pdm.mobile'),
                    tel:atosUtil.getI18nMessage('pdm.tel'),
                    fax:atosUtil.getI18nMessage('pdm.fax'),
                    email:atosUtil.getI18nMessage('pdm.email'),
                    ownerAddrCn2:atosUtil.getI18nMessage('pdm.ownerAddrCn2'),
                    disabled:atosUtil.getI18nMessage('pdm.disabled'),
                    ownerAddrPt2:atosUtil.getI18nMessage('pdm.ownerAddrPt2'),
                    remark:atosUtil.getI18nMessage('pdm.remark'),
                    certInfo:atosUtil.getI18nMessage('pdm.certInfo'),
                    personalIdentNo:atosUtil.getI18nMessage('pdm.personalIdentNo'),
                    personalIdentType:atosUtil.getI18nMessage('pdm.personalIdentType'),
                    fullNameCn:atosUtil.getI18nMessage('pdm.fullNameCn'),
                    fullNameEn:atosUtil.getI18nMessage('pdm.fullNameEn'),
                    expiryDate:atosUtil.getI18nMessage('pdm.expiryDate'),
                    issueDate:atosUtil.getI18nMessage('pdm.issueDate'),
                    validDate:atosUtil.getI18nMessage('pdm.validDate'),
                    identRecordStatus:atosUtil.getI18nMessage('pdm.identRecordStatus'),
                    searchNumber:atosUtil.getI18nMessage('pdm.searchNumber'),
                    lastService:atosUtil.getI18nMessage('pdm.lastService'),
                    createDate:atosUtil.getI18nMessage('global.createDate'),
                    createUser:atosUtil.getI18nMessage('global.createUser'),
                    lastUpdDate:atosUtil.getI18nMessage('global.lastUpdDate'),
                    lastUpdUser:atosUtil.getI18nMessage('global.lastUpdUser'),
                    action:atosUtil.getI18nMessage('global.action'),
                    back:atosUtil.getI18nMessage('global.back'),
                    caution:atosUtil.getI18nMessage('pdm.caution'),
                    returnDevSearch:atosUtil.getI18nMessage('pdm.returnDevSearch'),
                    back:atosUtil.getI18nMessage('global.back'),
                    showPhotoList:atosUtil.getI18nMessage('pdm.showPhotoList'),
                    ageUnit:atosUtil.getI18nMessage('pdm.ageUnit'),
                    masterId:atosUtil.getI18nMessage('pdm.masterId'),
                }
            }
        },
        created:function(){
            var docId = this.docid;
            var self = this;
            if(docId){
                axios.post(basePath + '/pdm/driver/getMasterInfoByDocId',{'docId':docId}).then(function(response){
                    if(response.pdmDisabled=='Y'){
                        $('#pdmDisabled').removeAttr('disabled');
                        $('#pdmDisabled').attr('checked','checked');
                        $('#pdmDisabled').attr('disabled','disabled');
                    }
                    self.customerInfo = response;
                    if(response.birthPlaceCode=='X'){
                        self.customerInfo.birthPlaceCodeDesc = response.birthPlaceCodeDesc+'('+response.birthPlaceManual+')';
                    }
                })
            }




        },
        methods:{
            formatJsonData:function(newData){
                for(var i =0;i<newData.data.length;i++){
                    var pdaResponse = newData.data[i];
                    for (var val in pdaResponse) {
                        if(pdaResponse[val]==null){
                            pdaResponse[val] = "";
                        }
                    }
                }
                return newData;
            },
            dateCompare:function(currentDate1,currentDate2,currentMonth1,currentMonth2,currentYear1,currentYear2){
                //比較兩個日期
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
            },
            initEvent:function(){
                this.initPhoto();
            },
            initPhoto:function(){
                var docId = this.docid;
                axios.get(basePath + '/pdm/img/onloadLastPhoto?docId=' + docId, {responseType: 'blob'}).then(function(response) {
                    if(response.size > 0) {
                        $('#photo').attr('src',window.URL.createObjectURL(response));
                    }else{
                        $('#photo').attr('src',webPrefix + "/assets/static/img/usered.png");
                    }
                });

            },
            editPdmPhoto:function(){
                var docId = this.docid;
                $.fancybox.open({
                    href: basePath+'/pdm/img/editPdmPhoto.html?docId='+docId,
                    width: '80%',
                    height: '80%',
                    type: 'iframe',
                    padding: 5
                });
            },
            doEdit:function(){
                var docId = this.docid;
                var url =basePath+'/pdm/driver/editDriver.html?docId='+docId;
                window.location.href = url;
                // var id = new Date().getTime();
                // $('<a id="' + id + '" href="' + url + '"></a>').appendTo('body');
                // setTimeout(function () {
                //     $('#' + id)[0].click();
                // }, 200);
            },
            initDatatables:function(){
                var self = this;
                var isUpload = this.isupload;
                var docId = this.docid;
                window.table = $('#table').DataTable({
                    processing : true,
                    destroy:true,
                    info:true,
                    paging:true,
                    serverSide : true,
                    ajax:{
                        url:basePath + "/pdm/driverCertInfo/getIdentInfoListByDTO",
                        type:"POST",
                        data:function(data,settings){
                            var param = {docId :docId};
                            return JSON.stringify($.extend({}, data, param));
                        },
                        contentType : "application/json; charset=utf-8",
                        dataType : "json",
                        "dataSrc":function(json){
                            var newJson = self.formatJsonData(json);
                            return newJson.data;
                       }
                    },
                    columns:[
                        {
                            "data":"personalIdentNo",
                            "render": function ( data, type, row,   meta ) {
                                if(meta.row==0){
                                    window.personalIdentType = row.personalIdentType;
                                    window.personalIdentNo = row.personalIdentNo;
                                }
                                return "<td>"+data+"<br><span class='text text-muted' style='cursor:pointer' title='"+row.personalIdentTypeDesc+"'>"+row.personalIdentType+"</span></td>"
                            },
                            "width":"auto"
                        },
                        {
                            "data" : "identFullNameCn",
                            "render": function ( data, type, row,   meta ) {
                                var printFullNameCn = row.printFullNameCn;//中文列印名
                                var printfullNameEn = row.printfullNameEn;//葡文列印名
                                if(printFullNameCn!='')
                                    printFullNameCn = '('+printFullNameCn+')';
                                if(printfullNameEn!='')
                                    printfullNameEn = '('+printfullNameEn+')';
                                return '<div style="cursor:pointer;">'+data+printFullNameCn+'<br/><span class="text text-muted">'+row.identfullNameEn+printfullNameEn+'</span></div>';
                            },
                            width : 'auto'
                        },
                        {
                            "data" :null,
                            "render": function ( data, type, row,   meta ) {
                                var today = new Date();
                                var todayDate = today.getDate();
                                var todayMonth = today.getMonth()+1;
                                var todayYear = today.getFullYear();//获取完整的年份(4位,1970)
                                var array = row.validDate.split('/');
                                var issueCurrentDate = array[0];
                                var issueCurrentMonth = array[1];
                                var issueCurrentYear = array[2];
                                var dataStatus = self.dateCompare(issueCurrentDate,todayDate,issueCurrentMonth,todayMonth,issueCurrentYear,todayYear);
                                if(dataStatus=='-1'){
                                    return "<div style='cursor:pointer'><span style='color:orange'>"+row.validDate+"</span><br><span class=''>"+row.issueDate+"</span></div>";
                                }else{
                                    return "<div style='cursor:pointer'>"+row.validDate+"<br><span class='text text-muted'>"+row.issueDate+"</span></div>"
                                }
                            },
                            width :'auto'
                        },
                        {
                            "data" : "identStatus",
                            "render": function ( data, type, row,meta ) {
                                if(data=='A') {
                                    return "<td><span style='color: green'>"+row.identStatusDesc+"</span></td>"
                                }else if(data=='I') {
                                    return "<td><span style='color: orange'>"+row.identStatusDesc+"</span></td>"
                                }else{
                                    return "<td><span>"+row.identStatusDesc+"</span></td>"
                                }
                            },
                            width : 'auto'
                        },
                        {
                            "data" :"lastSpNo",
                            "render":function(data,type,row,meta){
                                //alert(data);
                                if(data!='')
                                    return "<td>"+data+"<br>"+row.lastSpProcessName+"-"+row.lastSpServiceName+"</td>";
                                return '';
                            },
                            width : 'auto'
                        },
                        {
                            "data" :null,//創建日期
                            "render": function ( data, type, row,   meta ) {
                                return "<td><div>"+row.createDate+"<br/>"+"</div><div class='text-muted'>"+row.createUser+"</div></td>"
                            },
                            "width":"auto"
                        },
                        {
                            "data" : "lastUpdDate",//最後更新日期
                            "render": function ( data, type, row,   meta ) {
                                return "<td><div>"+data+"<br/>"+"</div><div class='text-muted'>"+row.lastUpdUser+"</div></td>"
                            },
                            "width":"auto"
                        },
                        {
                            "data" : null,
                            "render" : function(row,data){
                                if(isUpload){
                                    if(row.maxNum>0){
                                        var html = atosUtil.formatHtml('pdmPhotoNumGreaterThanZeroUpdate',[row.docId,row.docSeq,row.maxNum]);
                                        return html;
                                    }else{
                                        var html = atosUtil.formatHtml('pdmPhotoNumEqualsZeroUpdate',[row.docId,row.docSeq]);
                                        return html;
                                    }
                                }
                                if(!isUpload){
                                    if(row.maxNum>0){
                                        var html = atosUtil.formatHtml('pdmPhotoNumGreaterThanZeroDetail',[row.docId,row.docSeq,row.maxNum]);
                                        return html;
                                        // return "<td><button style='width:120px;' onmouseleave='javascript:controller.hideImg()' onmouseenter='javascript:controller.showImg("+row.maxNum+','+row.docId+','+row.docSeq+",this)' type='button' class='btn btn-default ' onclick='javascript:controller.showPhoto("+row.docId+','+row.docSeq+");'>"+atosUtil.getI18nMessage('pdm.certInfoPhotoList')+"<span class='badge' style='background-color:#777777;margin-left:3px;border-radius:15px;display:inline'>"+row.maxNum+"</span></button>"+
                                        // "<button style='margin-left:2px;' type='button' class='btn btn-default ' onclick='javascript:controller.showDetail("+row.docId+','+row.docSeq+");'>"+atosUtil.getI18nMessage('global.detail')+"</button></td>";
                                    }else{
                                        var html = atosUtil.formatHtml('pdmPhotoNumEqualsZeroDetail',[row.docId,row.docSeq]);
                                        return html;
                                    }
                                }

                            },
                            visible : self.hideAction,
                            width : '12%'
                        }
                    ]
                });


            }
        },
        mounted:function(){
            var self = this;
            this.initEvent();
            this.initDatatables();

            if(atosUtil.hasFuncPromission('DLS-PDM-MODIFY')){
                self.editButton = true;
                self.editPhoto = true;
            }

            if(this.showback){
                var html = atosUtil.formatHtml('showBack',[]);
                $("#showBackDiv").html(html);
                //$('#showBackDiv').innerHtml(html);
            }
        }

	})
    Vue.component('pdm-driver-detail',pdmDriverDetail);
});

</script>
