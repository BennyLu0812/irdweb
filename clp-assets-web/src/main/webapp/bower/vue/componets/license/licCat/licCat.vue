<template>
  <div v-show="show">
  	<div class="form-group">
        <div class="col-sm-12">
            <h4>可取消駕駛類別</h4>
        </div>
    </div>
    
    <div class="form-group">
        <div class="col-sm-12">
                    
	    <table id="table-lic-cat" class="table table-bordered table-hover table-condensed dataTable no-footer" role="grid" 
	        style="width: 100%;" width="100%" cellspacing="0">
	       <thead>
	            <tr role="row">
	                <th></th>
	                <th>{{label.licCat}}</th>
	                <th>{{label.gearboxType}}</th>
	                <th>
						<div>{{label.examNo}}</div>
						<div class="text text-muted">{{label.lawNo}}</div>
					</th>
	                <th>{{label.acquiredDate}}</th>
	                <th>{{label.licExchange}}</th>
	                <th>{{label.licCatStatus}}</th>
	                <th class="sorting_disabled">
	                    <div>{{label.obtainLicCat}}</div>
	                    <div>{{label.identNo}}</div>
	                    <div class="text text-muted">{{label.identType}}</div>
	                </th>
	                <th>
	                    <div>{{label.lastUpdDate}}</div>
	                    <div class="text text-muted">{{label.lastUpdUser}}</div>
	                </th>
	                <th style="width:90px">
	                    <div>{{label.action}}</div>
	                </th>
	            </tr>
	        </thead>
	    </table>
	    
    	</div>
    </div>
  </div>	        
</template>

<script>
define(['jquery',"atosUtil",'Vue','vueloader','bootstrapValidator','bootstrapValidator.config'],function($,atosUtil,Vue){
	var licCat = Vue.extend({
		template:template,
		 props: {
	            show: {
	                type: Boolean,
	                default: false
	            },
	            value:{type:Object}
	        },
	        created:function(){
                this.initData();
            },
	        data:function(){
                return {
                    licCat: {
                        restrictionCodeDesc: '',
                        gearboxType: '',
                        restrictionStatus: '',
                        createDate: ''
                    },
                    label: {
                        licCat: '',
                        gearboxType: '',
                        examNo: '',
                        lawNo: '',
                        acquiredDate: '',
                        licExchange: '',
                        licCatStatus: '',
                        obtainLicCat: '',
                        identNo: '',
                        identType: '',
                        lastUpdUser: '',
                        lastUpdDate: '',
                        action: ''
                    },
                    licCatTable: null
                }
            },
            methods:{
            	reloadTable:function(){
                	licCatTable.ajax.reload();
                },
                doPendLicCat : function(licCatId, licCat, gearboxType){
                    var self = this;
	                var options = {
	                        text: '確定失效當前駕駛類別:['+licCat+']<br/>變速箱類別:['+gearboxType+']?'
	                };
	                $.confirm(options, function(yes){
	                    if(yes){
	                        $.ajax({
                                type: "get",
                                url: basePath + '/lic/cat/pendLicCatStatus?spNo='+vModel.spNo+"&licCatId="+licCatId,
                                async:false,
                                contentType: "application/json",
                                success: function(data){
                                	if(data==''){
                                		var pdaResponse = {status : 200};
                                		$.showResult(pdaResponse);
                                	}
                                    self.reloadTable();
                                },error:function (error) {
                                    $.showResult(error);
								}
                            });
	                    }
	                });
	            },
                initData:function(){
                  this.label.licCat = atosUtil.getI18nMessage('license.licCat');
                  this.label.gearboxType = atosUtil.getI18nMessage('license.gearboxType');
                  this.label.examNo = atosUtil.getI18nMessage('license.examNo');
                  this.label.lawNo = atosUtil.getI18nMessage('license.lawNo');
                  this.label.acquiredDate = atosUtil.getI18nMessage('license.acquiredDate');
                  this.label.licExchange = atosUtil.getI18nMessage('license.licExchange');
                  this.label.licCatStatus = atosUtil.getI18nMessage('license.licCatStatus');
                  this.label.obtainLicCat = atosUtil.getI18nMessage('license.obtainLicCat');
                  this.label.identNo = atosUtil.getI18nMessage('license.identNo');
                  this.label.identType = atosUtil.getI18nMessage('license.identType');
                  this.label.lastUpdUser = atosUtil.getI18nMessage('global.lastUpdUser');
                  this.label.lastUpdDate = atosUtil.getI18nMessage('global.lastUpdDate');
                  this.label.action = atosUtil.getI18nMessage('global.action');
                  this.label.confirmInvalidCurrent = atosUtil.getI18nMessage('license.confirmInvalidCurrent');                  
                }, 
                loadData:function(){
                    var self = this;
                    licCatTable = $('#table-lic-cat').DataTable({
                        serverSide: true,
                        processing: true,
                        paging: false,
                        select: false,
                        info: false,
                        ajax: {
                            url: basePath + "/lic/cat/lic_cat_in_txn",
	                        type: "POST",
	                        contentType: "application/json; charset=utf-8",
	                        data: function (data, settings) {
	                        	var formData = {
	                                    spNo: self.value.spNo
	                            };
	                            return JSON.stringify($.extend({}, formData));
	                        },
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
                        columns: [{
	                        data: '',
	                        render: function (data, type, row) {
	                            if(row.licPrinted == 'Y'){
	                                return '<span style="color:red" class="glyphicon glyphicon-ok"></span>';
	                            }else{
	                                return '';
	                            }
	                        }
	                    }, {
	                        data: 'licCat',
	                        "width" : "22%",
	                        render: function (data, type, row) {
                                var html = '';
                                if (row.licCatDesc != null && row.licCatDesc != "") {
                                    html = row.licCatDesc;
                                    if (row.cylinderVolDisplay != null && row.cylinderVolDisplay != "") {
                                        html += '<br>' + row.cylinderVolDisplay + '</span>';
                                    }
                                } else {
                                    html = row.licCat;
                                }
                                return html;
	                        }
	                    }, {
	                        data: 'gearboxTypeDesc',
	                        render: function (data, type, row) {
	                            return row.gearboxTypeDesc=null?row.gearboxType:row.gearboxTypeDesc;
	                        }
	                    }, {
	                        data: '',
	                        render: function (data, type, row) {
                                var html = '';
                                if (!atosUtil.isEmpty(row.examNo)) {
                                    html += atosUtil.trimToEmpty(row.examNo);
                                }
                                if(!atosUtil.isEmpty(row.examYear)){
                                    html += '/' + atosUtil.trimToEmpty(row.examYear);
                                }
                                if (!atosUtil.isEmpty(row.lawNoDesc)) {
                                    html += "<br/><span class='text text-muted'>" + row.lawNoDesc + "</span>";
                                }
                                return html;
	                        }
	                    }, {
	                        data: 'acquiredDate'
	                    }, {
	                        data: 'foreignLicenseId',
	                        render: function (data, type, row) {
	                            return '<span title="'+row.foreignLicTypeDesc+'">'+
	                            (row.foreignLicType?row.foreignLicType:"")+(row.foreignLicType && row.exchangeLicNo?" - ":"")
	                            +(row.exchangeLicNo?row.exchangeLicNo:"")+'</span>';
	                        }
	                    }, {
	                        data: 'licCatStatus',
	                        render: function (data, type, row) {
	                            if(row.licCatStatus=='A'){
	                                return '<span class="text green-highlight">'+row.licCatStatusDesc+'</span>';
	                            }else if(row.licCatStatus=='C'){
	                                return '<span class="text orange-highlight">'+row.licCatStatusDesc+'</span>';
	                            }else{
	                                return row.licCatStatusDesc;
	                            }
	                        }
	                    }, {
	                        data: 'personalIdentType',
	                        render: function (data, type, row) {
	                            return (row.personalIdentNo?row.personalIdentNo:"")
	                            +"<br/><span class='text text-muted' title='"+row.personalIdentTypeDesc+"'>"+(row.personalIdentType?row.personalIdentType:"")+"</span>";
	                        }
	                    }, {
	                        data: '',
	                        render: function (data, type, row) {
	                            return row.lastUpdDate+"<br/><span class='text text-muted'>"+row.lastUpdUser+"</span>";
	                        }
	                    }, {
	                        data: 'action',
	                        width: '8%',
	                        render: function (data, type, row) {
	                            if(row.licCatStatus == 'A'){
	                                return '<a href="javascript:controller.variables.vue.$refs.licCat.doPendLicCat(\''+row.licCatId+'\',\''+row.licCat+'\',\''+(row.gearboxType?row.gearboxType:"--")+'\')" class="btn btn-sm btn-default">'+
	                                atosUtil.getI18nMessage('global.cancelled')+'</a>';
	                            }
	                            else if(row.licCatStatus == 'P'){
	                                return '<a href="javascript:controller.doReactivateLicCat(\''+row.licCatId+'\',\''+row.licCat+'\',\''+(row.gearboxType?row.gearboxType:"--")+'\')" class="btn btn-sm btn-default">'+
	                                atosUtil.getI18nMessage('global.reactivate')+'</a>';
	                            }
	                            else{
	                                return '';
	                            }
	                            
	                            $("a[name=btn_cancel]").click(function(){
			                    	alert(1);
			                    });
	                        }
	                    }]
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
        
                        licCatTable.ajax.reload();
                    }
                    
                }
            },
            mounted: function () {
                this.loadData();
            }
	})	
    Vue.component('lic-cat', licCat);
});

</script>

