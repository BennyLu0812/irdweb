<template>
    <div>
        <div class="form-group">
            <label class="control-label col-sm-1 required"  v-text="i18n['comp.detail']">公司資料</label>
            <div class="col-sm-10">
                <div>
                    <v-select  @change="changeHandler" @selected="selectedCompCode" v-model="selectParam.compBranchCode" lazy="true" notRequestByValue="true"
                               :url="selectParam.licCompIdUrl" :options="selectParam.compOptions"></v-select>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    define(['jquery',"atosUtil",'Vue','axios', 'axios.config','vueloader','select2.config','vueSelect2',
        'bootstrapValidator','bootstrapValidator.config'],function($,atosUtil,Vue,axios) {
        var compSelect = Vue.extend({
            template: template,
            props: {
                value: Object,
                selectedValue: {
                    type: String
                },
                name: {
                    type: String,
                    default: 'compIdentTypeAndNo',
                },
            },
            data:function(){
                return {
                    i18n:[],
                    goRequest:true,
                    selectParam: {
                        licCompIdUrl: basePath + "/lic/comp/getCompSelectPage",
                        compOptions: [],
                        compBranchCode: ''
                    },
                }
            },

            created:function() {
                var self = this;
                atosUtil.getLocalI18nByModules("comps",function (pdaResponse) {
                    self.i18n = pdaResponse;
                    console.log(self.goRequest)
                });
            },
            methods: {
                changeHandler: function () {
                },
                selectedCompCode: function () {
                    var self = this;
                    self.value.compBranchCode = self.selectParam.compBranchCode;
                    console.log("選中的compBranchCode:"+self.selectParam.compBranchCode);
                }
            },
            watch: {
                value: function (val) {

                }
             }
            }
        )
        Vue.component("lic-comps-select", compSelect)
    })

</script>

<style scoped>

</style>