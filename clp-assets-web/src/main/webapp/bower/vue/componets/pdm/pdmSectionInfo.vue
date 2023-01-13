<template>
  <div v-show="show">
                <div class="form-group">
                    <label class="control-label col-sm-1" v-text="label.nameCN"> </label>
                    <div class="col-sm-1_5"><span class="text-readonly" v-text="license.identFullNameCn"></span></div>
                    <label class="control-label col-sm-1" v-text="label.NameEn"></label>
                    <div class="col-sm-5_5"><span class="text-readonly" v-text="license.identFullNameEn"></span></div>
                    <label class="control-label col-sm-1" v-text="label.birthDate"> </label>
                    <div class="col-sm-2">
                        <span class="text-readonly" style="width:auto" v-text="license.birthDate"></span>&nbsp;
                        <span style="font-weight:bold; display:inline" v-if="license.age!=null">({{license.age}} 歲)</span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-1" v-text="label.personalIdentNo"> </label>
                    <div class="col-sm-1_5"><span class="text-readonly" v-text="license.personalIdentNo"></span></div>
                    <label class="control-label col-sm-1" v-text="label.identType"></label>
                    <div class="col-sm-5_5"><span class="text-readonly" style="padding-right:0px" v-text="license.personalIdentTypeDesc"></span></div>
                    <label class="control-label col-sm-1" v-text="label.identStatus"> </label>
                    <div class="col-sm-2">
                        <span v-if="license.identStatus=='A'" class="green-highlight text-readonly" v-text="license.identStatusDesc"></span>
                        <span v-else class="orange-highlight text-readonly" v-text="license.identStatusDesc"></span>
                    </div>
                </div>
                <div class="form-group" v-if="license.licType=='2'">
                    <label class="control-label col-sm-1" v-text="label.parentCompCode">母公司代碼</label>
                    <div v-if="license.parentCompBranchCode">
                    <div class="col-sm-1_5"><span class="text-readonly" v-text="license.parentCompBranchCode"></span></div>
                        <label class="control-label col-sm-1" v-text="label.compName"></label>
                    <div class="col-sm-8"><span class="text-readonly" style="padding-right:0px">{{license.parentCompCname}} / {{license.parentCompPname}}</span></div>
                    </div>
                    <div v-else>
                        <div class="col-sm-1_5"><span class="text-readonly">-</span></div>
                        <label class="control-label col-sm-1" v-text="label.compName"></label>
                        <div class="col-sm-8"><span class="text-readonly" style="padding-right:0px">- / -</span></div>
                    </div>
                </div>
              <div class="form-group" v-if="license.licType=='2'">
                  <label class="control-label col-sm-1" v-text="label.childCompCode">子公司代碼</label>
                  <div v-if="license.childCompBranchCode">
                      <div class="col-sm-1_5"><span class="text-readonly" v-text="license.childCompBranchCode"></span></div>
                      <label class="control-label col-sm-1" v-text="label.compName"></label>
                      <div class="col-sm-8"><span class="text-readonly" style="padding-right:0px" v-text="license.compCname+'  /  '+license.compPname"></span></div>
                  </div>
                  <div v-else>
                      <div class="col-sm-1_5"><span class="text-readonly"> - </span></div>
                      <label class="control-label col-sm-1" v-text="label.compName">公司名稱</label>
                      <div class="col-sm-8"><span class="text-readonly" style="padding-right:0px">- / -</span></div>
                  </div>

              </div>
                <div class="form-group" v-if="license.licType=='7'">
                    <label class="control-label col-sm-1" v-text="label.compCode"> </label>
                    <div class="col-sm-1_5"><span class="text-readonly cursor_pointer">
                        <span id="compIdentTypeDesc"  v-text="license.compIdentType"></span>
                        <span >-</span>
                        <span  v-text="license.compIdentNo">-</span>
                        <br></span></div>
                    <label class="control-label col-sm-1" v-text="label.compCname"></label>
                    <div class="col-sm-2_5"><span class="text-readonly" style="padding-right:0px" v-text="license.compCname"><br></span></div>
                    <label class="control-label col-sm-1" v-text="label.compPname"></label>
                    <div class="col-sm-5"><span class="text-readonly" v-text="license.compPname"></span></div>
                </div>
              <div v-if="license.licType=='8'">
                  <div class="form-group">
                  <label class="control-label col-sm-1" v-text="label.compBranchCodeShortcut ">公司代碼</label>
                  <div class="col-sm-1_5"><span class="text-readonly cursor_pointercompBranchCode">
                                <span   v-text="license.compBranchCode"></span>
                                </span>
                  </div>
                  <label class="control-label col-sm-1" v-text="label.compIdentType ">公司類型</label>
                  <div class="col-sm-1_5"><span class="text-readonly cursor_pointer">
                                <span  v-text="license.compIdentType">-</span>
                                <br></span>
                  </div>
                  <label class="control-label col-sm-1" v-text="label.compIdentNo ">登記編號</label>
                  <div class="col-sm-1_5"><span class="text-readonly cursor_pointer">
                                <span  v-text="license.compIdentNo">-</span>
                                <br></span>
                  </div>
                  </div>
                  <div class="form-group">
                      <label class="control-label col-sm-1" v-text="label.compCname"></label>
                      <div class="col-sm-4"><span class="text-readonly" style="padding-right:0px" v-text="license.compCname"><br></span></div>
                      <label class="control-label col-sm-1" v-text="label.compPname"></label>
                      <div class="col-sm-5"><span class="text-readonly" v-text="license.compPname"></span></div>
                  </div>
              </div>

  </div>
</template>

<script>
define(['jquery',"atosUtil",'Vue', 'axios',,'axios.config','vueloader','bootstrapValidator','bootstrapValidator.config'],function($,atosUtil,Vue,axios){
    var pdmSectionInfo = Vue.extend({
        template:template,
         props: {
                show: {
                    type: Boolean,
                    default: false
                },
                value:{type:Object},
            },
            created:function(){
                this.initData();
            },
            data:function(){
                return {
                    license: {
                        licType:'',
                        nameCN: '',
                        NameEn: '',
                        birthDate:'',
                        personalIdentNo: '',
                        identType:'',
                        identStatus: '',
                        compBranchCode: '',
                        compCnameAndPname:'',
                        compCname: '',
                        compPname:'',
                        compIdentNo:'',
                        compIdentType:'',
                        compIdentTypeDesc:''

                    },
                    label: {
                        nameCN: '',
                        NameEn: '',
                        birthDate:'',
                        personalIdentNo: '',
                        identType:'',
                        identStatus: '',
                        compCode: '',
                        compBranchCode:'',
                        compCname: '',
                        compName:'',
                        compPname:'',
                        parentCompCode:'',
                        childCompCode:''
                    }
                }
            },
            methods:{
                initData:function(){
                    this.label.nameCN= atosUtil.getI18nMessage('license.nameCN');
                    this.label.NameEn= atosUtil.getI18nMessage('license.NameEn');
                    this.label.birthDate= atosUtil.getI18nMessage('license.birthDate');
                    this.label.personalIdentNo= atosUtil.getI18nMessage('license.personalIdentNo');
                    this.label.identType= atosUtil.getI18nMessage('license.identType');
                    this.label.identStatus= atosUtil.getI18nMessage('license.identStatus');
                    this.label.compCode= atosUtil.getI18nMessage('license.compCode');
                    this.label.compBranchCode = atosUtil.getI18nMessage('comp.compBranchCode');
                    this.label.compBranchCodeShortcut = atosUtil.getI18nMessage('comp.compBranchCodeShortcut');
                    this.label.compCname= atosUtil.getI18nMessage('license.compCname');
                    this.label.compName= atosUtil.getI18nMessage('license.compName');
                    this.label.compPname= atosUtil.getI18nMessage('license.compPname');
                    this.label.parentCompBranchCode = atosUtil.getI18nMessage('comp.parentCompBranchCode');
                    this.label.parentCompCname= atosUtil.getI18nMessage('comp.parentCompCname');
                    this.label.parentCompPname= atosUtil.getI18nMessage('comp.parentCompPname');
                    this.label.parentCompCode = atosUtil.getI18nMessage("comp.parentCompBranchCode");
                    this.label.childCompCode = atosUtil.getI18nMessage("comp.childCompBranchCode");
                    this.label.compIdentType = atosUtil.getI18nMessage("comp.identType");
                    this.label.compIdentNo = atosUtil.getI18nMessage("comp.identNo");
                },
                loadData:function(){
                    var self = this;
                    if(self.value){
                        self.license = self.value;
                        if (self.license.childCompany) {
                            self.license.childCompBranchCode = self.license.compBranchCode;
                        }else{
                            if (self.license.compBranchCode) {
                                self.license.parentCompBranchCode = self.license.compBranchCode;
                                self.license.parentCompPname = self.license.compPname;
                                self.license.parentCompCname = self.license.compCname;
                                self.license.compCnameAndPname = self.license.compCname+' / '+self.license.compPname;
                            }
                        }
                    }
                    if(self.license.licType == '7' ){
                        $("#compIdentTypeDesc").attr("title",self.license.compIdentTypeDesc);
                    }
                }
            },
            watch:{
                value:function(val){
                    if (val) {
                        this.loadData();
                    }
                },
                "value.docSeq": function(docSeq,oldSeq) {
                    var self = this;
                    if (oldSeq && docSeq != oldSeq && self.license.licNo && self.license.licType) {
                        axios.post(basePath+"/lic/license/lic_detail",self.license).then(function (pdaResponse){
                            self.license = pdaResponse;
                        })
                    }
                }

            },
            mounted: function () {
                this.loadData();
            }
    })
    Vue.component('pdm-section-info', pdmSectionInfo);
});

</script>

