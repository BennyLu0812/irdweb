<template>
  <div v-show="show">
  	<div class="form-group">
        <div class="col-sm-12">
	    <table id="table-lic-restriction" class="table table-bordered table-hover table-condensed dataTable" cellspacing="0" width="100%">
	        <thead>
	            <tr>
	                <th>
	             <!--       <button id="btn-showAllRestriction" class="btn btn-default btn-sm" type="button" title="顯示所有限制">
	                        <span class="glyphicon glyphicon-menu-down"></span>
	                    </button>
	                    <button id="btn-hideCancelledRestriction" class="btn btn-default btn-sm" type="button" title="僅顯示有效的限制" style="display:none">
	                        <span class="glyphicon glyphicon-menu-up"></span>
	                    </button >-->
	                    <span v-text="label.restriction">限制</span><br/>
	                </th>
	                <th>
						<span class='text' v-text="label.license">駕駛執照</span><br>
						<span class='text text-muted' v-text="label.spNo">申請編號</span>
					</th>
	                <th v-text="label.restrictionStatus">限制狀態</th>

	                <th>
	                	<span class='text' v-text="label.createDate">創建日期</span><br>
	                    <span class='text text-muted' v-text="label.createUser">創建用戶</span>
	                </th>
	                <th>
	                    <a id="btn-add-restriction" class="btn btn-primary" v-text="label.create">新增</a>
	                </th>
	            </tr>
	        </thead>
	    </table>
    	</div>
    </div>
  </div>	        
</template>

<script>
define(['jquery',"atosUtil", 'Vue', 'vueloader', 'vueloader!vue/componets/license/restriction/LicOpeButton', 'datatables', 'datatables.config', 'bootstrapValidator','bootstrapValidator.config'],function($,atosUtil,Vue, licOpeButton){
	var licRestriction = Vue.extend({
		template:template,
		 props: {
	            show: {
	                type: Boolean,
	                default: false
	            },
	            value:{type:Object},
	            reloadTable: {
	                type: Boolean,
	                default: false
	            }
	        },
	        created:function(){
                this.initData();
            },
	        data:function(){
                return {
                    licRestriction: {
                        restrictionCodeDesc: '',
                        licNo: '',
                        restrictionStatus: '',
                        createDate: ''
                    },
                    label: {
                        license: '',
                        restrictionStatus: '',
                        createDate: '',
                        restriction: '',
                        create: '',
                        createUser: ''
                    },
                    restrictionTable: null,
                    // 按鈕操作文字
                    restrictionButtonLabel : {
                        // 按鈕點擊后提示文字
                        alert : {}
                    }
                }
            },
            methods:{
            	reloadTable:function(){
                	restrictionTable.ajax.reload();
                },
                initData : function(){
                    this.label.license= atosUtil.getI18nMessage('license.license');
                    this.label.restrictionStatus= atosUtil.getI18nMessage('licenseRestriction.restrictionStatus');
                    this.label.createDate= atosUtil.getI18nMessage('global.createDate');
                    this.label.createUser= atosUtil.getI18nMessage('global.createUser');
                    this.label.create= atosUtil.getI18nMessage('global.create');
                    this.label.restriction= atosUtil.getI18nMessage('licenseRestriction.restriction');
                    this.label.spNo=atosUtil.getI18nMessage('global.spNo');
                    
                    // 按鈕操作文字及提示
                    this.restrictionButtonLabel.cancel = atosUtil.getI18nMessage('license.button.cancelRestriction');
                    this.restrictionButtonLabel.reactivate = atosUtil.getI18nMessage('license.button.reactivateRestriction');
                    this.restrictionButtonLabel.delete = atosUtil.getI18nMessage('license.button.deleteRestriction');
                    this.restrictionButtonLabel.alert.cancel = atosUtil.getI18nMessage('license.confirm.InvalidCurrent.limit');
                    this.restrictionButtonLabel.alert.reactivate = atosUtil.getI18nMessage('license.confirm.ReactivateCurrent.limit');
                    this.restrictionButtonLabel.alert.delete = atosUtil.getI18nMessage('license.confirm.DeleteCurrent.limit');
                },
                createRestrictionOperateInfo : function (data){
                    var self = this;
                    var restrictionOperateInfo = {
                        buttonText : '',
                        alertText : '',
                        requestUrl : ''
                    };
                    if(data.restrictionStatus=='A'){
                        restrictionOperateInfo.buttonText = self.restrictionButtonLabel.cancel;
                        restrictionOperateInfo.alertText = self.restrictionButtonLabel.alert.cancel.format([data.restrictionCode]);
                        restrictionOperateInfo.requestUrl = basePath + '/lic/licRestriction/cancelInTxn?spNo='+self.value.spNo+"&restrictionId="+data.restrictionId;
                    }else if(data.restrictionStatus=='I'){
                        restrictionOperateInfo.buttonText = self.restrictionButtonLabel.reactivate;
                        restrictionOperateInfo.alertText = self.restrictionButtonLabel.alert.reactivate.format([data.restrictionCode]);
                        restrictionOperateInfo.requestUrl = basePath + '/lic/licRestriction/reactivateInTxn?spNo='+self.value.spNo+"&restrictionId="+data.restrictionId;
                    }else if(data.restrictionStatus=='T'){
                        restrictionOperateInfo.buttonText = self.restrictionButtonLabel.delete;
                        restrictionOperateInfo.alertText = self.restrictionButtonLabel.alert.delete.format([data.restrictionCode]);;
                        restrictionOperateInfo.requestUrl = basePath + '/lic/licRestriction/cancelInTxn?spNo='+self.value.spNo+"&restrictionId="+data.restrictionId;
                    }    
                    return restrictionOperateInfo;
                },
                loadData : function(){
                    var self = this;
                    restrictionTable = $('#table-lic-restriction').DataTable({
                        serverSide: true,
                        processing: true,
                        paging: false,
                        select: false,
                        info: false,
                        ajax: {
                            url: basePath + (self.value.dataHref || "/lic/licRestriction/data_in_txn"),
                            type: "POST",
                            data : function(data, settings) {
                                var formData = {
                                        spNo: self.value.spNo,
                                        licType: self.value.licType,
                                        restrictionStatus: self.licRestriction.restrictionStatus
                                };
                                return JSON.stringify($.extend({}, formData));
                            },
                            contentType: "application/json; charset=utf-8",
                            dataType: "json",
                            dataFilter: function (pdaResponse, type) {
                                // 對Ajax返回的原始數據進行預處理
                                if(pdaResponse!=null && pdaResponse!='')
                                    return JSON.stringify($.parseJSON(pdaResponse));
                                else{
                                    var data = [];
                                    return data;
                                }
                            },
                            dataSrc: function (data) {
                                return data;
                            }
                        },
                        columns: [
                            { "data": "restrictionCodeDesc","width" : "60%"},
                            { "data": "licNo","width" : "10%", "visible":true},
                            { "data": "restrictionStatus","width" : "10%"},
                            { "data": "createDate","width" : "10%" },
                            { "data": "action","width" : "8%" }
                        ],
                        columnDefs: [
                            {
                                render: function (data, type, row) {
                                    var html = row.restrictionCodeDesc;
                                    
                                    if(row.restrictionRemark != null){
                                        html += "<br><span class='text text-muted'>&nbsp;&nbsp;&nbsp;&nbsp;"+atosUtil.getI18nMessage('global.remark')+": "+row.restrictionRemark+"</span>";
                                    }
                                    return html;
                                },
                                targets: 0
                            },{
                                render: function (data, type, row) {
                                    var html = '';
                                    if (row.licNo) {
                                        html += row.licNo;
									}
									if (row.licType) {
                                        html += "<span title='"+ row.licTypeDesc+"'>("+row.licType+")</span>";
									}
									if (row.spNo) {
                                        html += "<br><span class='text text-muted'>"+row.spNo+"</span>";
									}
									return html;
                                 /*   var licNoTemp = row.licNo != null?row.licNo:"";
                                    var licTypeTemp = row.licType != null?row.licType:"";   
                                    var licTypeDescTemp = row.licTypeDesc != null?row.licTypeDesc:"";

                                    return "<span title='"+ licTypeDescTemp +"'>" + licNoTemp + " (" + licTypeTemp + ")</span>";*/
                                },
                                targets: 1
                            }, {
                                render: function (data, type, row) {
	                                if(row.restrictionStatus=='A'){
		                                return '<span class="text green-highlight">'+row.restrictionStatusDesc+'</span>';
		                            }else{
		                                return '<span class="text orange-highlight">'+row.restrictionStatusDesc+'</span>';
		                            }
                                },
                                targets: 2
                            },{
                                render: function (data, type, row) {
                                    return row.createDate+"<br/><span class='text text-muted'>"+row.createUser+"</span>";
                                },
                                targets: 3
                            }, {
                                render: function (data, type, row) {
                                    var html = "<div id='licOpe" + row.restrictionId + "'></div>";
                                    return html;
                                },
                                targets: 4
                            }
                        ],
                        // 行創建回調
                        createdRow : function ( row, data, index ) {
                            var buttonProps = self.createRestrictionOperateInfo(data);
                            var MyComponent = Vue.component('lic-ope-button');
                            var licOpeComponent = new MyComponent({
                                propsData : buttonProps
                            }).$mount();
                            licOpeComponent.$on("sucessChange",function(){
                                self.reloadTable();
                            });
                            $('#licOpe' + data.restrictionId, row).append(licOpeComponent.$el);
                        }
                    });
                    
                    
                        
                    $("#btn-showAllRestriction").click(function(){
                        doSearchDatatable('ALL');
                    });
                    $("#btn-hideCancelledRestriction").click(function(){
                        doSearchDatatable('A');
                    });
                    
                    function doSearchDatatable(status) {
                        self.licRestriction.restrictionStatus = status;
                        if(status=='ALL'){
                            $("#btn-hideCancelledRestriction").show();
                            $("#btn-showAllRestriction").hide(); 
                        }else{
                            $("#btn-hideCancelledRestriction").hide();
                            $("#btn-showAllRestriction").show(); 
                        }
        
                        restrictionTable.ajax.reload();
                    }
                    
                    $("#btn-add-restriction").click(function(){
                        $.fancybox.open({
                            href : basePath + '/lic/licRestriction/formInTxn.html?licNo='+self.value.licNo+'&licType='+self.value.licType+'&spNo='+self.value.spNo+'&docId='+self.value.docId,
                            type : 'iframe',
                            padding : 5,
                            width : '70%',
                            height : '50%'
                        });
                    });
                }
            },
            mounted: function () {
                this.loadData();
            }
	})
    licRestriction.restrictionDataReload = function() {
        new licRestriction().reloadTable();
    }
    licRestriction.closeFancybox = function() {
        $.fancybox.close();
    }
    licRestriction.showResult = function(pdaResponse) {
		$.showResult(pdaResponse);
    },
	window.licRestriction = licRestriction;
    Vue.component('lic-restriction', licRestriction);
});

</script>

