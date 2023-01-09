<template>
    <div>
        <div style="margin-top:10px;">
            <input id="input-pr-rev" name="certInfoPhotoList" type="file" multiple>
        </div>
    
        <div class="form-group" style="margin-top:10px;" v-if="isupload">
            <div class="alert alert-info alert-dismissible">
                <strong><span v-text="pdmI18NList.photoUploadAlert"> 警告:每張圖片大小不能超過4MB！</span> </strong> <span id="msg"></span>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> 
            </div>
        </div>
    </div>
</template>
<script>
define(['jquery','Vue','axios','atosUtil','vueloader','axios.config','bootstrap'],function($,Vue,axios,atosUtil){
    var pdmCertInfoPhotoList = Vue.extend({
        template:template,
        props:{
            isupload:{
                type:Boolean,
                default:false
            }
        },
        data:function(){
            return {
                pdmI18NList:{
                    photoUploadAlert:atosUtil.getI18nMessage('pdm.photoUploadAlert')
                }
            }
        },
        methods:{
            initEvent:function(){
                var isUpload = this.isupload;
                var preList = new Array();  
                var initPreviewConfig = new Array();  
                var docId = vModel.docId;
                var docSeq = vModel.docSeq; 
                $.get({
                    async:false,
                    url:'onloadIdentPhotoList?docId='+docId+'&docSeq='+docSeq+'&'+Math.random(),
                    success:function(pdaResponse){
                        for(var i =0;i<pdaResponse.length;i++){
                            preList[i] = '<img style="width:auto;height:auto;max-width:100%;max-height:100%;" src="data:image/png;base64,'+pdaResponse[i].img+'" />';
                            var tjson = {
                                caption: '用户'+pdaResponse[i].createUser+'<br/>创建于'+pdaResponse[i].createDate, // 展示的文件名
                                width:'120px',
                                url:'deleteCertainIdentPhoto', // 删除url 
                                key:pdaResponse[i].docIndex,
                            };
                            initPreviewConfig[i] = tjson;
                        }
                    }
                });
                
                if(isUpload){
                    $('#input-pr-rev').fileinput({
                        uploadUrl:'uploadIdentPhotoList',
                        uploadAsync:false,
                        overwriteInitial: false,
                        maxFileSize :0,
                        maxFileCount:5,
                        previewZoomSettings:{
                            image: {width: "auto", height: "auto", 'max-width': "100%",'max-height': "100%"},
                            html: {width: "100%", height: "100%", 'min-height': "480px"},
                            text: {width: "100%", height: "100%", 'min-height': "480px"},
                            video: {width: "auto", height: "100%", 'max-width': "100%"},
                            audio: {width: "100%", height: "30px"},
                            flash: {width: "auto", height: "480px"},
                            object: {width: "auto", height: "100%", 'min-height': "480px"},
                            pdf: {width: "100%", height: "100%", 'min-height': "480px"},
                            other: {width: "auto", height: "100%", 'min-height': "480px"}
                        },
                        showClose:false,//不顯示關閉按鈕
                        showBrowse:true,//文件瀏覽按鈕
                        initialPreview:preList,
                        initialPreviewConfig: initPreviewConfig,
                        layoutTemplates:{
                            actionUpload:''
                        },
                        uploadExtraData: function () { return {docId:vModel.docId,docSeq:vModel.docSeq}; },
                        deleteExtraData: function () { return {docId:vModel.docId,docSeq:vModel.docSeq};},
                        allowedFileExtensions: ["jpg", "png"]
                    }).on("filebatchuploadcomplete", function(event, data) {
                        $("#input-pr-rev").fileinput('disable');
                    });
                }
            
                if(!isUpload){
                    $('#input-pr-rev').fileinput({
                        uploadUrl:'uploadIdentPhotoList',
                        uploadAsync: false,
                        overwriteInitial: false,
                        
                        maxFileSize :0,
                        maxFileCount:5,
                        showClose:false,//不顯示關閉按鈕
                        showBrowse:false,//文件瀏覽按鈕
                        initialPreviewShowDelete:false,//是否為縮略圖創建刪除按鈕
                        showCaption:false,//是否顯示標題 
                        dropZoneEnabled: false,//是否显示拖拽区域
                        showRemove:false,
                        showUpload:false,
                        initialPreview:preList,
                        initialPreviewConfig: initPreviewConfig,
                        uploadExtraData: function () {//額外上傳的數據
                            return {docId:vModel.docId,docSeq:vModel.docSeq};
                        },
                        layoutTemplates:{
                            actionUpload:''
                        },
                        deleteExtraData: function (){
                            return {docId:vModel.docId,docSeq:vModel.docSeq};
                        },
                        allowedFileExtensions: ["jpg", "png"]
                    }).on("filebatchuploadcomplete", function(event, data) {
                        $("#input-pr-rev").fileinput('disable');
                    });
                }
               
            }
        },
        mounted:function(){
            this.initEvent();
        }

    })  
    Vue.component('pdm-cert-info-photo-list',pdmCertInfoPhotoList);
});

</script>
