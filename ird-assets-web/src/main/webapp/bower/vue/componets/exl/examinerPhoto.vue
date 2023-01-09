<template>
    <div v-if="isupload">
        <div class="form-group col-sm-3" style="position:absolute; right: 65px;">
            <div class="col-sm-10">
                <center>
                    <!--<img id="photo" @click="editPhoto()" style="cursor:pointer;height:160px;vertical-align:middle;" src="dls/web/static/img/usered.png">-->
                    <img id="photo" @click="" style="cursor:pointer;height:160px;vertical-align:middle;" >
                </center>

                <center style="display:block" id="selectImage">
                    <button class="btn btn-sm btn-primary" type="button" style="margin-top:10px;" @click="selectPhoto">
                        <i class="glyphicon glyphicon-edit"></i> <span th:text="#{examiner.header.editPhoto}" id="editPhoto"></span>
                    </button>
                    <input type="file" name="file" id="image" style="display:none"/>
                </center>

                <center style="display:none" id="uploadImage">
                    <button class="btn btn-sm btn-primary" style="margin-top:10px;" @click="uploadPhoto">
                        <i class="glyphicon glyphicon-edit"></i> <span th:text="#{examiner.button.uploadPhoto}" id="uploadPhoto"></span>
                    </button>
                </center>

                <!-- <center >
                    <button class="btn btn-sm btn-primary" style="margin-top:10px;" type="button" @click="doEdit();">
                        <i class="glyphicon glyphicon-edit"></i> <span th:text="#{pdm.editInfo}">資料修改</span>
                    </button>
                </center> -->
            </div>
        </div>
    </div>

    <div v-else>
        <div class="form-group col-sm-3" style="position:absolute; right: 65px;">
            <div class="col-sm-10">
                <center>
                    <!--<img id="photo" @click="editPhoto()" style="cursor:pointer;height:160px;vertical-align:middle;" src="dls/assets/static/img/usered.png">-->
                    <img id="photo" @click="" style="cursor:pointer;height:160px;vertical-align:middle;">
                </center>
            </div>
        </div>
    </div>

</template>

<script>
    define(['jquery','Vue','axios','atosUtil','vueloader','axios.config','datatables.config'],function($,Vue,axios,atosUtil){
        var examPhoto = Vue.extend({
            template:template,
            props:{
                isupload:{
                    type:Boolean,
                    default:false
                },
                examinerno:{
                    type:String,
                },
                uploadflag:{
                    type:Boolean,
                    default:true
                },
                filePostfix :{
                    type:Array,
                    default:["JPG","JPEG","PNG"]
                }
            },

            created:function(){


            },
            methods: {
                initEvent : function () {
                    this.initPhoto();
                    this.fileChnage();
                    if ($("#editPhoto").length > 0) {
                        $("#editPhoto").html(atosUtil.getI18nMessage("examiner.header.editPhoto"));
                    }
                    if ($("#uploadPhoto").length > 0) {
                        $("#uploadPhoto").html(atosUtil.getI18nMessage("examiner.button.uploadPhoto"));
                    }
                },
                initPhoto: function () {
                    var examinerno = this.examinerno;
                    if (examinerno !== null) {
                        //回顯頭像
                        axios.get(basePath+'/exl/examiner/isExaminerPhotoExist/'+examinerno).then(function(response){
                            if(response === true){
                                $('#photo').attr('src',basePath+'/exl/examiner/showPhoto/'+examinerno + '?d=' + Math.random());
                            }else{
                                $('#photo').attr('src',webPrefix + "/assets/static/img/usered.png");
                            }
                        });
                    }
                },
                initButton : function() {
                    $("#selectImage").find("button").attr("disabled",false);
                },
                //選擇圖片
                selectPhoto : function () {
                    var self = this;
                    var examinerno = self.examinerno;
                    // $.fancybox.open({
                    //     href: basePath+'/exl/examiner/examinerEditPhoto.html?examinerNo=' + examinerno,
                    //     width: '100%',
                    //     height: '100%',
                    //     type: 'iframe',
                    //     padding: 5
                    // });
                    //沒有考試員no不能上傳頭像
                    if (examinerno === null) {
                        $.message(atosUtil.getI18nMessage('examiner.button.unableUploadPhoto'),false);
                        return false;
                    }
                    self.cleanInputFile();

                    $("#image").click();

                },
                //上傳圖片
                uploadPhoto : function () {
                    var self = this;
                    var formdata = new FormData();
                    //formdata.append('name', 'uploadImage');
                    formdata.append('uploadImage',$('#image').get(0).files[0]);
                    formdata.append('examinerNo', self.examinerno);
                    $("#uploadImage").find("button").attr("disabled",true);
                    $.ajax({
                        url : basePath + '/exl/examiner/uploadPhoto',
                        type:'post',
                        data:formdata,
                        processData:false,
                        contentType: false,
                        cache: false,
                        success:function(info) {
                            $("#selectImage").css("display", "block");
                            $("#uploadImage").css("display", "none");
                            $("#uploadImage").find("button").attr("disabled",false);
                            $.message(atosUtil.getI18nMessage("examiner.photo.uploadSuccess"));
                        },
                        error:function(err){
                            console.log(err)
                        }
                    });

                },
                //预览图片URL
                getUrl: function (file) {
                    var url = null ;
                    if (window.createObjectURL !== undefined) { // basic
                        url = window.createObjectURL(file) ;
                    } else if (window.URL !== undefined) { // mozilla(firefox)
                        url = window.URL.createObjectURL(file) ;
                    } else if (window.webkitURL !== undefined) { // webkit or chrome
                        url = window.webkitURL.createObjectURL(file) ;
                    }
                    return url;
                },
                /**
                 * 清空input file 中的内容
                 */
                cleanInputFile : function(){
                    $("#image")[0].value='';
                },
                //圖像校驗
                fileChnage : function() {
                    var self = this;

                    $("#image").on("change", function() {
                        console.log(this.files);
                        self.fileType(this.files[0]);
                        self.fileSize(this.files[0]);
                        if (self.uploadflag) {
                            //通過校驗則顯示出上傳按鈕，隱藏選擇按鈕
                            $("#selectImage").css("display", "none");
                            $("#uploadImage").css("display", "block");
                            var url = self.getUrl(this.files[0]);
                            if (url !== null) {
                                $("#photo").attr("src",url);
                            }
                        }
                    });
                },
                //图片后缀名
                fileType : function(file) {
                    var postfix = file.name.substr((file.name).lastIndexOf(".")+1);
                    var postfixBool = false;
                    for (var j = 0; j < this.filePostfix.length; j++) {
                        if (postfix.toUpperCase() === this.filePostfix[j].toUpperCase()) {
                            //后缀名是规定的其中一个
                            postfixBool = true;
                            break;
                        }
                    }
                    //后缀名不符合要求
                    if(!postfixBool){
                        $.message(atosUtil.getI18nMessage("examiner.photo.typeWrong"),false);
                        //设置为不符合条件
                        this.uploadflag = false;
                        //清空文件内容
                        this.cleanInputFile();
                    }
                },
                //圖像大小
                fileSize : function(file) {
                    //判断大小
                    if(file.size > 2*1024*1024){
                        $.message(atosUtil.getI18nMessage("examiner.photo.sizeWrong"),false);
                        //清空文件内容
                        this.cleanInputFile();
                        this.uploadflag = false;
                    }
                },
            },
            mounted : function(){
                this.initEvent();
            }

        });
        Vue.component('examiner-photo',examPhoto);
    });
</script>
<style scoped>

</style>
