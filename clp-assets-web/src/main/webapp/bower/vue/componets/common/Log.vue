<template>
    <div>
        <table class="table table-bordered table-hover table-condensed" cellspacing="0" width="100%" ref = "auditTable">
            <thead>
                <tr>
                    <th th:text="#{audit.funcCode}">功能名稱</th>
                    <th th:text="#{audit.operatorId}">創建用戶</th>
                    <th th:text="#{audit.operationTime}">創建日期</th>
                    <th th:text="#{audit.remark}">備註</th>
                    <th th:text="#{audit.service}">服務</th>
                    <th th:text="#{audit.process}">操作 </th>
                    <th th:text="#{audit.hostIP}">主機IP</th>
                    <th th:text="#{global.action}">操作</th>
                </tr>
            </thead>
        </table>
    </div>
</template>

<script>
    define(['Vue', 'jquery', 'axios', 'atosUtil', 'axios.config', 'datatables', 'datatables.config'],function(Vue, $, axios, atosUtil){
        var log = Vue.extend({
            template:template,
            props : {
                mode : {
                    type : String
                },
                readQueryParam : {
                    type : Object
                }
            },
            data:function(){
                return {
                    datatable : null,
                    formData : null
                }
            },
            created: function() {
            },
            mounted: function() {
                this.initDatatable()
                if (this.mode == 'read') {
                    this.datatable.ajax.reload()
                }
            },
            methods : {
                getQueryParam: function () {
                    if (this.mode == 'read') {
                        return this.readQueryParam
                    }
                    return this.formData
                },
                loadLog : function (formData) {
                    this.formData = formData
                    if (!this.datatable) {
                        this.initDatatable()
                    } else {
                        this.datatable.ajax.reload()
                    }
                },
                initDatatable : function () {
                    var self = this

                    this.datatable = $(this.$refs.auditTable).DataTable({
                        processing : true,
                        deferLoading: 0,
                        searching : true,
                        serverSide : true,
                        ajax : {
                            url : basePath + "/sys/auditlog/getAuditMasterPage",
                            type : "POST",
                            data : function(data, settings) {
                                var queryParam = self.getQueryParam()
                                return JSON.stringify($.extend({}, data, queryParam));
                            },
                            contentType : "application/json; charset=utf-8",
                            dataType : "json"
                        },
                        select : {
                            style : 'single',
                            selector : 'td'
                        },
                        columns : [ {
                            "data" : "sysFuncDesc",
                            "width" : "15%",
                            "render": function(data, type, row, meta){
                                var html = row.sysFuncDesc ? row.sysFuncDesc : row.sysFuncCode;
                                return html;
                            }
                        }, {
                            "data" : "sysOperatorId",
                            "width" : "8%"
                        }, {
                            "data" : "sysOperationTime",
                            "width" : "10%",
                            "render" : function(data, type, row, meta) {
                                return row.sysOperationTimeDesc;
                            }
                        }, {
                            "data" : "sysRemark",
                            "width" : "14%"
                        } , {
                            "data" : "serviceId",
                            "width" : "20%",
                            "render": function(data,type,row, meta){
                                var html = row.serviceId ? row.serviceCname : '';
                                return html;
                            }
                        }, {
                            "data" : "processId",
                            "width" : "15%",
                            "render": function(data,type,row,meta){
                                var html = row.processId ? row.processCname : '';
                                return html;
                            }
                        }, {
                            "data" : "hostIP",
                            "width" : "10%",

                        }, {
                            "data" : "action",
                            "width" : "5%",

                        }],
                        columnDefs : [
                            {
                                render : function(data, type, row) {
                                    //詳情按鈕添加權限控制
                                    var html = '';
                                    if(atosUtil.hasFuncPromission("HZM-ENQ-AUDIT-DETAIL")){
                                        html += ('<a href="{0}/sys/auditlog/auditDetailList.html?auditMasterId={1}&appCdMo={2}" class="btn btn-sm btn-default fancybox fancybox.iframe" data-fancybox-width="100%" data-fancybox-height="100%" >'
                                            +'<i class="glyphicon glyphicon-detail"></i>詳情</a>').format([basePath, row.auditMasterId, self.readQueryParam.appCdMo]);
                                    }
                                    return html;
                                },
                                targets: 7
                            }
                        ]
                    })
                }
            }
        });

        Vue.component('log', log);
    })
</script>

<style scoped>

</style>