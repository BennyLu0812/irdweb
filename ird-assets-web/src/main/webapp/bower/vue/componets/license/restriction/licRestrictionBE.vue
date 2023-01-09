<template>
  <div v-show="show">
  	<div class="form-group">
        <div class="col-sm-12">
	    <table id="table-lic-restriction" class="table table-bordered table-hover table-condensed dataTable" cellspacing="0" width="100%">
	        <thead>
	            <tr>
	                <th>
	                    <button id="btn-showAllRestriction" class="btn btn-default btn-sm" type="button" title="顯示所有限制">
	                        <span class="glyphicon glyphicon-menu-down"></span>
	                    </button>
	                    <button id="btn-hideCancelledRestriction" class="btn btn-default btn-sm" type="button" title="僅顯示有效的限制" style="display:none">
	                        <span class="glyphicon glyphicon-menu-up"></span>
	                    </button ><span v-text="label.restriction">限制</span><br/>
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
	                    <a v-if="label.addStatus=='0' && showAddBtn" 
	                    id="btn-add-restriction" class="btn btn-primary btn-sm" v-text="label.create">新增</a>
	                </th>
	            </tr>
	        </thead>
	    </table>
    	</div>
    </div>
  </div>	  
</template>

<script>
define(['jquery','atosUtil','Vue','axios','vueloader','datatables', 'datatables.config', 'bootstrapValidator','bootstrapValidator.config'],function($,atosUtil,Vue,axios){
	var licRestrictionComps = Vue.extend({
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
	            },
			 	url:{
	                type:String,
					default:basePath + "/lic/licRestriction/data",
				},
	            showAction:{
	                type:Boolean,
                    default: true
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
                        createUser: '',
                        addStatus:''
                    },
                    restrictionTable: null,
                    showAddBtn:true
                }
            },
            methods:{
            	reloadTable:function(){
                	restrictionTable.ajax.reload();
                },  
                doInvalidRestriction: function (restrictionId, restrictionCode) {
                	var self = this;
	                var options = {
	                        text: '確定失效當前限制['+restrictionCode+']?'
	                };

	                $.confirm(options, function(yes){
	                    if(yes){
	                        $.ajax({
                                type: "put",
                                url: basePath + '/lic/licRestriction/invalid/'+restrictionId,
                                async:false,
                                contentType: "application/json",
                                success: function(data){
                                	$.showResult({status : 200});
                                    self.reloadTable();
                                },
                                error:function(data){
                                	$.showResult(data);
                                }
                            });
	                    }
	                });
	            },
	            doReactivateRestriction: function (restrictionId, restrictionCode) {
                	var self = this;
	                var options = {
	                        text: '確定復原當前限制['+restrictionCode+']?'
	                };
	                $.confirm(options, function(yes){
	                    if(yes){
	                        $.ajax({
                                type: "put",
                                url: basePath + '/lic/licRestriction/reactivate/'+restrictionId,
                                async:false,
                                contentType: "application/json",
                                success: function(data){
                                	$.showResult({status : 200});
                                    self.reloadTable();
                                },
                                error:function(data){
                                	$.showResult(data);
                                }
                            });
	                    }
	                });
	            },
	            doDeleteRestriction: function (restrictionId, restrictionCode) {
                    var self = this;
                    var options = {
                        text: '確定刪除當前限制['+restrictionCode+']?'
                    };
                    $.confirm(options, function(yes){
                        if(yes){
                            axios.get(basePath + '/lic/licRestriction/clear?restrictionId='+restrictionId).then(function(response) {
                                controller.showResult(response);
                                self.reloadTable();
                            });
                        }
                    });
                },
	            doErrorDeleteRestriction: function (restrictionId, restrictionCode) {
                    var self = this;
                    var options = {
                        text: '確定刪除當前限制['+restrictionCode+']? 刪除後的數據將不能復原'
                    };
                    $.confirm(options, function(yes){
                        if(yes){
                            if(yes){
                            $.ajax({
                                type: "put",
                                url: basePath + '/lic/licRestriction/errorDelete/'+restrictionId,
                                async:false,
                                contentType: "application/json",
                                success: function(data){
                                    $.showResult({status : 200});
                                    self.reloadTable();
                                },
                                error:function(data){
                                    $.showResult(data);
                                }
                            });
                        }
                        }
                    });
                },
                initData:function(){
                    this.label.license= atosUtil.getI18nMessage('license.license');
                    this.label.restrictionStatus= atosUtil.getI18nMessage('licenseRestriction.restrictionStatus');
                    this.label.createDate= atosUtil.getI18nMessage('global.createDate');
                    this.label.createUser= atosUtil.getI18nMessage('global.createUser');
                    this.label.create = atosUtil.getI18nMessage('global.create');
                    this.label.spNo = atosUtil.getI18nMessage('global.spNo');
                    this.label.restriction= atosUtil.getI18nMessage('licenseRestriction.restriction');
                    if(atosUtil.hasFuncPromission("DLS-LIC-REST-ADD")){
                        this.label.addStatus = '0';
                    }
                },
                loadData:function(){
                    var self = this;
                    restrictionTable = $('#table-lic-restriction').DataTable({
                        serverSide: true,
                        processing: true,
                        paging: false,
                        select: true,
                        info: false,
                        destroy:true,
                        ajax: {
                            url: self.url,
                            type: "POST",
                            data : function(data, settings) {
                                var formData = {
                                        licNo: self.value.licNo,
                                        licType: self.value.licType,
                                        spNo: self.value.spNo,
										docId:self.value.docId,
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
                            { "data": "restrictionCodeDesc"},
                            { "data": "licNo","width" : "15%", "visible":true},
                            { "data": "restrictionStatus","width" : "10%"},
                            { "data": "createDate","width" : "10%" },
                            { "data": "action","width" : "10%" }
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
                                	var html = row.spNo?"<br><span class='text text-muted'>"+row.spNo+"</span>":"";
                                    if(row.restrictionStatus=='T'){
                                        //T狀態不顯示駕照編號
                                    }else{
                                        if(row.licNo != null && row.licType != null){
                                            html = "<span class='cursor_pointer' title='"+row.licTypeDesc+"'>" + (row.licStatus == 'T'?'':row.licNo) + " (" + row.licType + ")</span>"
                                            	+html;
                                        }else if (!row.licNo && row.licType) {
                                            html = "<span class='cursor_pointer' title='"+row.licTypeDesc+"'>" + " (" + row.licType + ")</span>"
                                                +html;
										}
                                    }
                                    return html;
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
                                     var html = '<div class="btn-group">';
                                     if(row.licStatus == 'A' || row.licStatus == 'T'){
                                        if(row.restrictionStatus=='A'){
                                            if(atosUtil.hasFuncPromission("DLS-LIC-REST-INVALID")){
                                                html += '<a class="btn btn-default btn-sm" ';
                                                html += 'href="javascript:controller.variables.vue.$refs.restriction.doInvalidRestriction(\''+row.restrictionId+'\',\''+row.restrictionCode+'\')">';
                                                html += '失效</a>'; 
                                            }
                                            if(atosUtil.hasFuncPromission("DLS-LIC-REST-DELETE")){
                                                html += '<a class="btn btn-default btn-sm" ';
                                                html += 'href="javascript:controller.variables.vue.$refs.restriction.doErrorDeleteRestriction(\''+row.restrictionId+'\',\''+row.restrictionCode+'\')">';
                                                html += '刪除</a>'; 
                                            }                                    
                                        }else if((row.restrictionStatus=='I' || row.restrictionStatus=='D') && atosUtil.hasFuncPromission("DLS-LIC-REST-RESUME")){
                                            html += '<a class="btn btn-default btn-sm" ';
                                            html += 'href="javascript:controller.variables.vue.$refs.restriction.doReactivateRestriction(\''+row.restrictionId+'\',\''+row.restrictionCode+'\')">';
                                            html += '復原</a>';
                                        }else if(row.restrictionStatus=='T'){
                                            html += '<a class="btn btn-default btn-sm" ';
                                            html += 'onclick="javascript:controller.variables.vue.$refs.restriction.doDeleteRestriction(\''+row.restrictionId+'\',\''+row.restrictionCode+'\')">';
                                            html += '刪除</a>';
                                        }
                                     }else { // 當限制未關聯上lic_no,此時licStatus = null
                                         if(atosUtil.hasFuncPromission("DLS-LIC-REST-DELETE")) {
                                             html += '<a class="btn btn-default btn-sm" ';
                                             html += 'onclick="javascript:controller.variables.vue.$refs.restriction.doErrorDeleteRestriction(\'' + row.restrictionId + '\',\'' + row.restrictionCode + '\')">';
                                             html += '刪除</a>';
                                         }
									 }
                                     html += '</div>';
                                    return html;
                                },
                                visible: self.showAction,
                                targets: 4
                            }
                        ]
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
                        if (!self.value.restrictionStatus) {
                            self.value.restrictionStatus = 'A';
						}
                        var url = basePath + '/lic/licRestriction/form.html?licNo='+self.value.licNo+'&licType='
                            +self.value.licType+'&restrictionStatus='+self.value.restrictionStatus+'&spNo='+self.value.spNo+'&docId='+self.value.docId;
                        $.fancybox.open({
                            href : url,
                            type : 'iframe',
                            padding : 5,
                            width : '70%',
                            height : '50%'
                        });
                    });
                }
            },
            watch:{
                value:function(val,oldVal){
                    if (val.licNo && val.licType && (oldVal.licNo!= val.licNo || oldVal.licType != val.licType)) {
                        this.loadData();
                    }
                },
                "value.licStatus":function(val){
                    var self = this;
                    if(val && (val == 'A' || val == 'T')){
                        self.showAddBtn = true;
                    }else{
                        self.showAddBtn = false;
                    }
                }
            },
            mounted: function () {
                if (this.value.licNo && this.value.licType) {
                    this.loadData();
                }else{
                    $('#table-lic-restriction').DataTable();
                }
            }
	})
    licRestrictionComps.restrictionDataReload = function() {
       	 new licRestrictionComps().reloadTable();
	}
    licRestrictionComps.closeFancybox = function() {
        $.fancybox.close();
    },
	licRestrictionComps.showResult = function(pdaResponse) {
		$.showResult(pdaResponse);
	},
	window.licRestriction = licRestrictionComps;
    Vue.component('lic-restriction-be', licRestrictionComps);
});

</script>

