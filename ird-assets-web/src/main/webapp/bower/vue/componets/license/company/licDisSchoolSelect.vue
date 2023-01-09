<template xmlns:th="http://www.w3.org/1999/xhtml">
    <div v-show="show">
        <div class="modal fade" tabindex="-1" role="dialog" ref="queryFilterPage" data-backdrop="static">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title">請選擇您想要查詢的學校</h4>
                    </div>
                    <div class="modal-body">
                        <table id="table" class="table table-hover table-condensed" cellspacing="0" width="100%">
                            <thead>
                                <th><div></div></th>
                                <th><div th:text="#{school.schoolLicNo}">學校執照編號</div></th>
                                <th><div th:text="#{school.schoolCname}">學校中文名稱</div></th>
                                <th><div th:text="#{school.schoolPname}">學校葡文名稱</div></th>
                                <th><div th:text="#{school.schoolLicStatus}">學校執照狀態</div></th>
                            </thead>
                            <tbody>
                                <template v-for="items in schoolGroup">
                                <tr v-for="(item, idx) in items">
                                    <td><input type="radio" name = "schoolId" v-bind:value="item.schoolId" v-model="selectedItemId" v-if="idx == 0"></td>
                                    <td>{{item.schoolLicNo}}</td>
                                    <td>{{item.schoolCname}}</td>
                                    <td>{{item.schoolPname}}</td>
                                    <td>{{item.schoolLicStatus}}</td>
                                </tr>
                                </template>
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">關閉</button>
                        <button type="button" class="btn btn-primary" @click="selectItem">確定</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div>
</template>

<script>
    define(['Vue', 'atosUtil'],function(Vue, atosUtil){
        var licDisSchoolSelect = Vue.extend({
            template: template,
            props : {
                show : Boolean,
                disSchoolResult : Object
            },
            data : function () {
                return {
                    selectedItemId : null
                }
            },
            computed : {
                schoolGroup: function () {
                    // 数据按照schoolId进行归类
                    var schoolIdG = {}; // 针对键schoolId进行归类的容器
                    if (!this.disSchoolResult) {
                        return schoolIdG;
                    }
                    this.disSchoolResult.forEach(function (item) {
                        schoolIdG[item.schoolId] = schoolIdG[item.schoolId] || [];
                        if(item.schoolLicStatus =='A'){
                            item.schoolLicStatus=atosUtil.getI18nMessage('global.statusA')
                        }
                        if(item.schoolLicStatus =='C'){
                            item.schoolLicStatus=atosUtil.getI18nMessage('global.statusC')
                        }
                        schoolIdG[item.schoolId].push(item);
                    })
                    return schoolIdG;
                }
            },
            methods : {
                selectItem : function() {
                    var pdaResponse = atosUtil.findItem(this.disSchoolResult, "schoolId", this.selectedItemId)
                    this.selectedItemId = null
                    this.$emit('select-pdaResponse', pdaResponse)
                },
            },
            mounted : function () {
                var self = this;
                $(this.$refs.queryFilterPage).on('hidden.bs.modal', function () {
                    self.$emit('select-close')
                })
            },
            created : function () {
                console.log('enq-query-pdaResponse-filter in creating!');
            },
            watch : {
                show : function (val, oldVal) {
                    var modalStatus = val ? 'show' : 'hide'
                    $(this.$refs.queryFilterPage).modal(modalStatus)
                }
            }
        })
        Vue.component('lic-dis-school-select',licDisSchoolSelect);
    })
</script>

<style scoped>
    @media (min-width: 992px) {
        .modal-lg {
            width: 1024px;
        }
    }
</style>