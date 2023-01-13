<template>
    <div>
        <table id="table_aec_details" class="table table-bordered table-hover table-condensed dataTable no-footer"
               role="grid" style="width: 100%;"
               width="100%" cellspacing="0" :class="tableCls">
            <thead>
            <tr>
                <th>
                    <div v-text="licAec.spNo">申請編號</div>
                    <div v-text="licAec.serviceTypeDesc" class="text text-muted">服務操作</div>
                </th>
                <th>
                    <div v-text="licAec.compBranchCode">公司代碼</div>
                </th>
                <th>
                    <div v-text="licAec.nameCN">中文名</div>
                    <div class='text text-muted' v-text="licAec.NameEn">葡文名</div>
                </th>
                <th>
                    <div v-text="licAec.driverIdentNo">駕駛員證件編號</div>
                    <div class='text text-muted' v:text="licAec.driverIdentType">駕駛員證件類型</div>
                </th>
                <th>
                    <div v:text="licAec.foreignLicNo">外國駕照編號</div>
                    <div class='text text-muted' v:text="licAec.driverLicIssuePlace">駕照發出地</div>
                </th>
                <th>
                    <div v:text="licAec.officialLetterNo">批示編號</div>
                    <div class='text text-muted' v:text="licAec.officialLetterDate">批示日期</div>
                </th>
                <th v-text="licAec.activePlateNos">可駕駛的車牌編號</th>
                <th>
                    <div v:text="licAec.createDate">創建日期</div>
                    <div class='text text-muted' v:text="licAec.createUser">創建用戶</div>
                </th>
                <th>
                    <div v:text="licAec.lastUpdDate">最後更新日期</div>
                    <div class='text text-muted' th:text="licAec.lastUpdUser">最後更新用戶</div>
                </th>
                <th>
                    <button v-if="showCreateBtn" id="btn-create" type="button" @click="doCreate"
                            class="btn btn-sm btn-primary" v:text="#{lce.applyService}">錄入簽發資料
                    </button>
                    <button v-if="showExtendBtn && showExtendBtnLic" id="btn-extend" type="button" @click="doExtend"
                            class="btn btn-sm btn-primary" v:text="#{lce.extendService}">錄入續期<br>申請資料
                    </button>
                </th>
            </tr>
            </thead>
        </table>
    </div>
</template>
<style scoped>
    .hideFirstCol td:first-child {
        display: none;
    }

    .hideFirstCol th:first-child {
        display: none;
    }

    .hideFirstTh th:first-child {
        display: none;
    }
</style>
<script>
    define(['jquery', "atosUtil", 'Vue', 'axios', 'axios.config', 'vueloader', 'datatables', 'datatables.config', 'bootstrapValidator', 'bootstrapValidator.config'], function ($, atosUtil, Vue, axios) {
        var licAec = Vue.extend({
            template: template,
            props: {
                value: Object,
                paging: {
                    type: Boolean,
                    default: true
                },
                showLicDetail: {
                    type: Boolean,
                    default: true
                },
                showExtendBtnLic: {
                    type:Boolean,
                    default:false
                },
                showAction: {
                    type: Boolean,
                    default: true
                },
                pageInfo: {
                    type: Boolean,
                    default: true
                }
            },
            data: function () {
                return {
                    hasData: false,
                    showExtendBtn: false,
                    showCreateBtn: false,
                    licAec: {
                        licTxnId: "",
                        spNo: "",
                        validDate: '',
                        nameCN: "",
                        NameEn: "",
                        serviceTypeDesc: "",
                        driverIdentNo: "",
                        driverLicNo: "", // 中國駕駛執照
                        driverLicIssuePlaceDesc: "",
                        licTxnCat: '',
                        officialLetterNo: '',
                        officialLetterDate: '',
                        activePlateNos: '',
                        identStatus: ''

                    },
                    aecDataTable: null,
                    tableCls: ""
                }
            },
            created: function () {
                this.initLabel();
                console.log(this.value);
            },
            mounted: function () {
                var self = this;
                //self.initDatatables();

            },
            watch: {
                "value.licStatus": function (val) {
                    var self = this;
                    var a=self.value.licStatus;
                    if (val && val === 'A' && atosUtil.hasFuncPromission("DLS-AEC-EXTEND-ADD")) {
                        self.showExtendBtn = true;
                    } else {
                        self.showExtendBtn = false;
                    }
                },
                'value.identStatus': function () {
                    if (this.value.identStatus !== '') {
                        this.initDatatables();
                    }
                }
            },
            methods: {
                doCreate: function () {
                    $.fancybox.open({
                        href: basePath + '/lic/aec/aec_txn_form.html?processId=900602',
                        type: 'iframe',
                        padding: 8,
                        width: '80%',
                        height: '70%'
                    });
                },
                doExtend: function () {
                    $.fancybox.open({
                        href: basePath + '/lic/aec/aec_txn_form.html?processId=900601&licNo=' + this.value.licNo + "&licType=" + this.value.licType+"&compBranchCode="+this.value.compBranchCode,
                        type: 'iframe',
                        padding: 8,
                        width: '80%',
                        height: '70%'
                    });
                },
                initLabel: function () {
                    this.licAec.compBranchCode = atosUtil.getI18nMessage('lic.aec.compBranchCode');//公司代碼
                    this.licAec.licNo = atosUtil.getI18nMessage('lic.aec.licNo');//AEC編號
                    this.licAec.spNo = atosUtil.getI18nMessage('global.spNo');
                    this.licAec.validDate = atosUtil.getI18nMessage("license.validDate");//駕照有效期
                    this.licAec.nameCN = atosUtil.getI18nMessage('lic.aec.nameCN');//中文名
                    this.licAec.NameEn = atosUtil.getI18nMessage('lic.aec.NameEn');//葡文名
                    this.licAec.serviceTypeDesc = atosUtil.getI18nMessage('lic.aec.serviceTypeDesc');//服務操作
                    this.licAec.driverIdentNo = atosUtil.getI18nMessage('lic.aec.driverIdentNo');//通行證編號
                    this.licAec.driverIdentType = atosUtil.getI18nMessage("lic.aec.driverIdentType")
                    this.licAec.driverLicNo = atosUtil.getI18nMessage('lic.aec.driverLicNo');// 外國駕駛編號
                    this.licAec.driverLicIssuePlace = atosUtil.getI18nMessage('lic.aec.driverLicIssuePlace'); //駕照發出地
                    this.licAec.licTxnCat = atosUtil.getI18nMessage('lic.aec.licTxnCat');//公函記錄的駕駛類別
                    this.licAec.officialLetterNo = atosUtil.getI18nMessage('lic.aec.officialLetterNo');//中聯辦編號
                    this.licAec.officialLetterDate = atosUtil.getI18nMessage("lic.aec.officialLetterDate"); // 批示日期
                    this.licAec.activePlateNos = atosUtil.getI18nMessage("lic.aec.activePlateNos"); //可駕駛車牌編號
                    this.licAec.createDate = atosUtil.getI18nMessage("global.createDate");
                    this.licAec.createUser = atosUtil.getI18nMessage("global.createUser");
                    this.licAec.lastUpdDate = atosUtil.getI18nMessage("global.lastUpdDate");
                    this.licAec.lastUpdUser = atosUtil.getI18nMessage("global.lastUpdUser");
                },
                reloadTable: function () {
                    aecDataTable.ajax.reload();
                },
                initDatatables: function () {
                    var self = this;
                    var index = 0;
                    aecDataTable = $('#table_aec_details').DataTable(
                        {
                            serverSide: true,
                            processing: true,
                            paging: self.paging,
                            info: self.pageInfo,
                            ajax: {
                                url: basePath + "/lic/aec/data",
                                type: "POST",
                                data: function (data, settings) {
                                    var formData = {
                                        licNo: self.value.licNo,

                                    };
                                    return JSON.stringify($.extend({}, data, formData));
                                },
                                contentType: "application/json; charset=utf-8",
                                dataType: "json"
                            },
                            columns: [{
                                "data": "spNo",
                                "width": "16%"
                            }, {
                                "data": "compBranchCode",
                                "width": "8%"
                            }, {
                                "data": "driverCname",
                                "width": "12%"
                            }, {
                                "data": "driverIdentNo",
                                className: 'dt-nowrap',
                                "width": "12%"
                            }, {
                                "data": "driverLicNo",
                                className: 'dt-nowrap',
                                "width": "10%"
                            }, {
                                "data": "officialLetterNo",
                                "width": "12%"
                            }, {
                                "data": "activePlateNos"
                            }, {
                                "data": "",
                                "width": "10%"
                            }, {
                                "data": "",
                                "width": "10%"
                            }, {
                                "data": "",
                                "width": "8%"

                            }],
                            columnDefs: [{
                                render: function (data, type, row) {
                                    var html = row.spNo == null ? "" : row.spNo;
                                    if (row.serviceProcessDesc) {
                                        html += '<br><span class="text text-muted">' + row.serviceProcessDesc + '</span>';
                                    }
                                    return html;
                                },
                                targets: 0
                            }, {
                                render: function (data, type, row) {
                                    var html = "";
                                    if (row.compBranchCode) {
                                        html = '<span class="cursor_pointer" title="' + row.compBranchCode + ' - ' + row.compCname + ' - ' + row.compPname + '">' + row.compBranchCode + '</span>';

                                    }
                                    return html;
                                },
                                targets: 1
                            }, {
                                render: function (data, type, row) {
                                    var html = "";
                                    if (row.driverCname) {
                                        html = row.driverCname;

                                    }
                                    if (row.driverPname) {
                                        html += '<br><span class="text text-muted">' + row.driverPname + '</span>';
                                    }
                                    return html;
                                },
                                targets: 2
                            },
                                {
                                    render: function (data, type, row) {
                                        var html = row.driverIdentNo ? row.driverIdentNo : '';
                                        if (row.driverIdentTypeDesc) {
                                            html += '<br><span class="text text-muted" title="' + row.driverIdentTypeDesc + '">' + row.driverIdentType + '</span>';
                                        }
                                        return html;
                                    },
                                    targets: 3
                                },
                                {
                                    render: function (data, type, row) {
                                        var html = row.driverLicNo;
                                        if (row.driverLicIssuePlaceDesc) {
                                            html += '<br><span class="text text-muted" title="' + row.driverLicIssuePlaceDesc + '">' + row.driverLicIssuePlace + '</span>';
                                        }
                                        return html;
                                    },
                                    targets: 4
                                }, {
                                    render: function (data, type, row) {
                                        var html = row.officialLetterNo;
                                        if (row.officialLetterDate) {
                                            html += '<br><span class="text text-muted">' + row.officialLetterDate + '</span>';
                                        }
                                        return html;
                                    },
                                    targets: 5
                                }, {
                                    render: function (data, type, row) {
                                        var html = row.createDate;
                                        if (row.createUser) {
                                            html += '<br><span class="text text-muted">' + row.createUser + '</span>';
                                        }
                                        return html;
                                    },
                                    targets: 7
                                }, {
                                    render: function (data, type, row) {
                                        var html = "";
                                        if (row.activePlateNos && row.activePlateNos.length > 0) {
                                            var arr = row.activePlateNos;
                                            for (var i = 0; i < arr.length; i++) {
                                                html += arr[i] + "<br>";
                                            }
                                        }
                                        return html;
                                    },
                                    targets: 6
                                }, {
                                    render: function (data, type, row) {
                                        var html = row.lastUpdDate;
                                        if (row.lastUpdUser) {
                                            html += '<br><span class="text text-muted">' + row.lastUpdUser + '</span>';
                                        }
                                        return html;
                                    },
                                    targets: 8
                                }, {
                                    render: function (data, type, row) {
                                        var mark = 0;
                                        if(self.value.licStatus == 'A' || self.value.licStatus=='T') {
                                            var html = '<div class="btn-group"> <a href="#" class="btn btn-sm btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">'
                                                + atosUtil.getI18nMessage('global.action') + '<span class="caret"></span></a>' + '<ul class="ulCss dropdown-menu" role="menu">';
                                            if (atosUtil.hasFuncPromission("DLS-AEC-TXN-UPDATE")) {
                                                html += '<li role="presentation"><a href="javascript:licAec.doUpdate(' + row.licTxnId + ',' + mark + ')">修改</a></li>';
                                            }
                                            if (atosUtil.hasFuncPromission("AEC_SWITCH_COMP")) {
                                                if (self.value.licStatus == 'A' && row.txnStatus == 'F' && row.markUpAEC) {
                                                    mark++;
                                                    html += String.format("<li role='presentation'><a href='#' onclick='licAec.doUpdate({0}, {1}, \"{2}\",\"{3}\")'>公司變更</a></li>", row.licTxnId, mark, self.value.licNo, self.value.compBranchCode)

                                                }
                                            }
                                            if (row.spNo == null) {
                                                if (row.txnStatus == 'A' && self.value.licStatus == 'A') {
                                                    if (atosUtil.hasFuncPromission("DLS-AEC-TXN-CANCEL")) {
                                                        html += '<li role="presentation"><a href="javascript:licAec.doInvalid(' + row.licTxnId + ')">失效</a></li>';
                                                    }
                                                }
                                            } else {
                                                if (row.licNo == null) {
                                                    html += '<li role="presentation"><a href="/dls/web/lic/license/addLicense.html/' + row.spNo + '">新增駕照</a></li>';
                                                } else if (self.showLicDetail) {
                                                    html += '<li role="presentation"><a href="/dls/web/lic/license/lic_detail.html?licNo=' + row.licNo + '&licType=' + row.licType + '">駕照詳情</a></li>';
                                                }
                                            }
                                            if (atosUtil.hasFuncPromission("DLS-AEC-VEH-LIST")) {
                                                html += '<li role="presentation"><a  href="javascript:licAec.plateInput(' + row.licTxnId + ')">車牌資料</a></li>';
                                            }
                                            html += '</ul></div>';
                                            if (!$(html).find("li").html()) {
                                                $(".ulCss").hide()
                                            }
                                            return html;
                                        }else{
                                            return "";
                                        }
                                    },
                                    visible: self.showAction,
                                    targets: 9
                                }]
                        });
                }
            }// end of methods
        })

        licAec.doUpdate = function (licTxnId, mark,licNo,compBranchCode) {
            $.fancybox.open({
                href: basePath + '/lic/aec/aec_txn_form.html?&processId=900602&compBranchCode=' +compBranchCode + "&licTxnId=" + licTxnId + "&mark=" + mark+"&licNo="+licNo,
                type: 'iframe',
                padding: 8,
                width: '80%',
                height: '70%'
            });
        }
        licAec.plateInput = function (licTxnId) {
            $.fancybox.open({
                href: basePath + '/lic/aec/aec_plate_form.html?licTxnId=' + licTxnId,
                type: 'iframe',
                padding: 8,
                width: '80%',
                height: '70%'
            });
        };
        licAec.doInvalid = function (txnId) {
            var self = this;
            var options = {
                text: '確定讓該記錄失效？'
            };
            $.confirm(options, function (yes) {
                if (yes) {
                    axios.post(basePath + "/lic/aec/cancel?licTxnId=" + txnId).then(function (response) {
                        $.showResult(response);
                        self.doSearch();
                    })
                }
            })
        };

        licAec.showResult = function (pdaResponse) {
            $.showResult(pdaResponse);
        };

        licAec.closeFancybox = function () {
            $.fancybox.close();
        };

        licAec.doSearch = function () {
            new licAec().reloadTable();
        }
        window.licAec = licAec;
        Vue.component("lic-aec", licAec)
    })
</script>