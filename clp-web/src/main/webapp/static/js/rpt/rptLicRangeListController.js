require(
        [ 'jquery', 'atosBaseController', 'moment.config', 'axios', 'atosUtil', 'axios.config', 'jquery.config','bootstrapValidator.config',
                'datatables', 'datatables.config', 'fancybox', 'fancybox.config', 'Noty', 'noty.config', 'select2',
                'select2.config' ],
        function($, atosBaseController, momentConfig, axios, atosUtil) {
            'use strict'; // 使用JS嚴格模式.
            var i = 1;
            var deletedLicNoList = [];
            var queryConditions = {licType : '0', licStatus : 'A'};
            var controller = atosBaseController(
                    momentConfig,
                    {
                        // 統一定義變量.
                        variables : {
                            datatable : null
                        },
                        init : function() {
                            var self = this;
                            atosUtil.getI18nByModules('global,rpt,lic', function() {
                                self.initEvent();
                                self.initSelect2();
                                $('#table-lic').DataTable();
                            });
                        },
                        initDatatables : function() {
                            this.variables.datatable = $('#table-lic').DataTable({
                                serverSide: true,
                                processing: true,
                                paging: true,
                                info: true,
                                ajax: {
                                    url: basePath + "/lic/license/licenseRangeList",
                                    type: "POST",
                                    data: function (data, settings) {
                                        var formData = $('#fm-search').serializeObject();
                                        var licNoObjectList = controller.getLicNoMapList();
                                        if(licNoObjectList.length > 0){
                                            formData.licNoMapList = licNoObjectList;
                                        }
                                        if(deletedLicNoList.length > 0){
                                            var newDeletedLicNoList = [];
                                            for(var i=0;i<deletedLicNoList.length;i++){
                                                if(newDeletedLicNoList.indexOf(deletedLicNoList[i]) == -1){
                                                    newDeletedLicNoList.push(deletedLicNoList[i]);
                                                }
                                            }
                                            formData.deletedLicNoList = newDeletedLicNoList;
                                        }
                                        formData.licNoList = $("#licNoList").val();
                                        return JSON.stringify($.extend({}, data, formData));
                                    },
                                    contentType: "application/json; charset=utf-8",
                                    dataType: "json"
                                },
                                select: {
                                    style: 'single',
                                    selector: 'td'
                                },
                                columns: [
                                    { "data": "licTypeDescCN"},
                                    { "data": "licNo"},
                                    { "data": "identFullNameCn"},
                                    { "data": "identFullNameEn"},
                                    { "data": "firstIssueDate"},
                                    { "data": "lastIssueDate"},
                                    { "data": "validDate"},
                                    { "data": "licCat"},
                                    { "data": "action"}
                                ],
                                columnDefs : [{
                                    render : function(data, type, row) {
                                        return '<a id="deleteBtn" href="javascript:controller.removeResultSet(\''+
                                                   row.licNo+'\',\''+row.licType+'\')" class="btn btn-sm btn-danger">'+
                                                   '<i class="glyphicon glyphicon-remove"></i><span>&nbsp;'+atosUtil.getI18nMessage('global.delete')+'</span>'+
                                               '</a>';
                                    },
                                    targets : 8
                                }],
                                fnDrawCallback: function(){
                                    var api = this.api();
                                    if(api.data().length > 0){
                                        $("#printExcel").attr("disabled",false);
                                        $("#printEnvelope").attr("disabled",false);
                                    }else{
                                        $("#printExcel").attr("disabled",true);
                                        $("#printEnvelope").attr("disabled",true);
                                    }
                                }
                            });
                        },
                        // 初始化綁定事件
                        initEvent : function() {
                            var self = this;
                            $("#licType").append('<option value="0">0 - Macau - 澳門</option>');
                            $("#licStatus").val("A")
                            $("#licType").change(function(){
                                var licType = $(this).val();
                                if(licType){
                                    $('#fm-validator').hide();
                                }
                                var oldLicType = $(this).attr("hook");
                                $(this).attr("hook", licType);
                                var validatorObject = {
                                        fields: {
                                            licType:{
                                                validators : {
                                                    notEmpty : { }
                                                }
                                            }
                                        }
                                    };
                                if(oldLicType == '8' && licType != '8'){
                                    $("#fm-search").data('bootstrapValidator').destroy();
                                    
                                    $("#parentDiv .form-group").each(function(index){
                                        var licNoStartName = $(this).find("#licNoStart").attr("name");
                                        var licNoEndName = $(this).find("#licNoEnd").attr("name");
                                        validatorObject.fields[licNoStartName] = {
                                                validators : {
                                                    digits: {
                                                        message: '该值只能包含数字'
                                                    },
                                                    callback : {
                                                       callback : function(value, validator, $field) {
                                                           var licNoStart = value;
                                                           var licNoList =$("#licNoList").val();
                                                           var $licNoEnd = $field.parent().children('input[id="licNoEnd"]');
                                                           var licNoEnd = $licNoEnd.val();
                                                           if(value){
                                                               licNoStart = parseInt(value);
                                                           }
                                                           if(licNoEnd){
                                                               licNoEnd = parseInt(licNoEnd);
                                                           }
                                                           if(licNoEnd && !licNoStart){
                                                               validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                               validator.updateMessage($field.attr('name'),'callback','請再輸入一個開始編號');
                                                               return false;
                                                           }else if(!licNoEnd && licNoStart){
                                                               validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                               validator.updateMessage($field.attr('name'),'callback','請再輸入一個結束編號');
                                                               return false;
                                                           }else if(licNoEnd && licNoStart && !licNoList){
                                                               validator.updateStatus('licNoList','NOT_VALIDATED');
                                                               if(licNoStart>licNoEnd) {
                                                                   validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                                   validator.updateMessage($field.attr('name'), 'callback', '開始號碼不能大於結束號碼');
                                                                   return false;
                                                               }
                                                               validator.updateStatus($licNoEnd.attr('name'), 'VALID');
                                                               return true;
                                                           } else{
                                                              validator.updateStatus($licNoEnd.attr('name'), 'VALID');
                                                              return true;
                                                           }
                                                       },
                                                       message : '開始號碼不能大於結束號碼'
                                                    }                          
                                                }
                                               
                                            };
                                        validatorObject.fields[licNoEndName] = {
                                                validators : {
                                                    digits: {
                                                        message: '该值只能包含数字'
                                                                   },
                                                    callback : {
                                                        callback : function(value, validator, $field) {
                                                            var licNoEnd = value;
                                                            var $licNoStart = $field.parent().children('input[id="licNoStart"]');
                                                            var licNoStart = $licNoStart.val();
                                                            var licNoList =$("#licNoList").val();
                                                            if(licNoStart){
                                                                licNoStart = parseInt(licNoStart);
                                                            }
                                                            if(value){
                                                                licNoEnd = parseInt(value);
                                                            }
                                                            if(licNoEnd && !licNoStart){
                                                                validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                                validator.updateMessage($field.attr('name'),'callback','請再輸入一個開始編號');
                                                                return false;
                                                            }else if(!licNoEnd && licNoStart){
                                                                validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                                validator.updateMessage($field.attr('name'),'callback','請再輸入一個結束編號');
                                                                return false;
                                                            }else if(licNoEnd && licNoStart && !licNoList){
                                                                validator.updateStatus('licNoList','NOT_VALIDATED');
                                                                if(licNoEnd < licNoStart) {
                                                                    validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                                    validator.updateMessage($field.attr('name'), 'callback', '開始號碼不能大於結束號碼');
                                                                    return false;
                                                                }
                                                                validator.updateStatus($licNoStart.attr('name'), 'VALID');
                                                                return true;
                                                            } else{
                                                               validator.updateStatus($licNoStart.attr('name'), 'VALID');
                                                               return true;
                                                            }
                                                        },
                                                        message : '開始號碼不能大於結束號碼'
                                                    }
                                                }
                                                
                                            };
                                    });
                                    
                                }else if(oldLicType != '8' && licType == '8'){
                                    $("#fm-search").data('bootstrapValidator').destroy();
                                    $("#parentDiv .form-group").each(function(index){
                                        var licNoStartName = $(this).find("#licNoStart").attr("name");
                                        var licNoEndName = $(this).find("#licNoEnd").attr("name");
                                        validatorObject.fields[licNoStartName] = {
                                                validators : {
                                                    callback : {
                                                        callback : function(value, validator, $field) {
                                                            var licNoStart = value;
                                                            var licNoList =$("#licNoList").val();
                                                            var $licNoEnd = $field.parent().children('input[id="licNoEnd"]');
                                                            var licNoEnd = $licNoEnd.val();
                                                            if(licNoEnd && !licNoStart){
                                                                validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                                validator.updateMessage($field.attr('name'),'callback','請再輸入一個開始編號');
                                                                return false;
                                                            }else if(!licNoEnd && licNoStart){
                                                                validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                                validator.updateMessage($field.attr('name'),'callback','請再輸入一個結束編號');
                                                                return false;
                                                            }else if(licNoEnd && licNoStart && !licNoList){
                                                                validator.updateStatus('licNoList','NOT_VALIDATED');
                                                                if(licNoStart>licNoEnd) {
                                                                    validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                                    validator.updateMessage($field.attr('name'), 'callback', '開始號碼不能大於結束號碼');
                                                                    return false;
                                                                }
                                                                validator.updateStatus($licNoEnd.attr('name'), 'VALID');
                                                                return true;
                                                            } else{
                                                                validator.updateStatus($licNoEnd.attr('name'), 'VALID');
                                                                return true;
                                                            }
                                                        },
                                                        message : '開始號碼不能大於結束號碼'
                                                    }                          
                                                },
                                                
                                            };
                                        validatorObject.fields[licNoEndName] = {
                                                validators : {
                                                    callback : {
                                                        callback : function(value, validator, $field) {
                                                            var licNoEnd = value;
                                                            var $licNoStart = $field.parent().children('input[id="licNoStart"]');
                                                            var licNoStart = $licNoStart.val();
                                                            var licNoList =$("#licNoList").val();
                                                            if(licNoEnd && !licNoStart){
                                                                validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                                validator.updateMessage($field.attr('name'),'callback','請再輸入一個開始編號');
                                                                return false;
                                                            }else if(!licNoEnd && licNoStart){
                                                                validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                                validator.updateMessage($field.attr('name'),'callback','請再輸入一個結束編號');
                                                                return false;
                                                            }else if(licNoEnd && licNoStart && !licNoList){
                                                                validator.updateStatus('licNoList','NOT_VALIDATED');
                                                                if(licNoEnd < licNoStart) {
                                                                    validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                                    validator.updateMessage($field.attr('name'), 'callback', '開始號碼不能大於結束號碼');
                                                                    return false;
                                                                }
                                                                validator.updateStatus($licNoStart.attr('name'), 'VALID');
                                                                return true;
                                                            } else{
                                                                validator.updateStatus($licNoStart.attr('name'), 'VALID');
                                                                return true;
                                                            }
                                                        },
                                                        message : '開始號碼不能大於結束號碼'
                                                    }
                                                }
                                            
                                            };
                                    });
                                }
                                $('#fm-search').bootstrapValidator(validatorObject);
                            });
                            $("#btn-search").click(function() {
                                self.doSearch();
                                var formData = $('#fm-search').serializeObject();
                                formData.licNoList = $("#licNoList").val();
                                var licNoObjectList = controller.getLicNoMapList();
                                if(licNoObjectList.length > 0){
                                    formData.licNoMapList = licNoObjectList;
                                }
                                queryConditions = formData;
                            });
                            $("#btn-reset").click(function(){
                                $("#licType").empty().trigger("change");
                                $("#licStatus").val("").trigger("change");
                                $("#licNoList").val("").trigger("change");
                            });
                            
                            $("#btn-create").click(function(){
                                var licType = $("#licType").val();
                                if(!licType){
                                    $('#msg').text(atosUtil.getI18nMessage('請先選擇一個駕照類型'));
                                    $('#fm-validator').show();
                                    return false;
                                }
                                var childDiv = '<div class="form-group">'+
                                                    '<label class="control-label col-sm-1_5">'+atosUtil.getI18nMessage('rptLicPdmList.licNo')+'</label>'+
                                                    '<div class="col-sm-4 form-validator has-feedback">'+
                                                        '<div class="input-group">'+
                                                        '<input id="licNoStart" name="licNoStart'+i+'" value="" class="form-control"  placeholder="開始編號">'+
                                                            '<span class="input-group-addon">-</span>'+
                                                            '<input id="licNoEnd" name="licNoEnd'+i+'" value="" class="form-control"  placeholder="結束編號">'+
                                                        '</div>'+
                                                    '</div>'+
                                                    '<div class="col-sm-1">'+
                                                        '<button id="btn-delete" type="button" class="btn btn-sm btn-danger">'+
                                                            '<i class="glyphicon glyphicon-remove"></i><span>&nbsp;'+atosUtil.getI18nMessage('global.delete')+'</span>'+
                                                        '</button>'+
                                                    '</div>'+
                                                '</div>';
                                $("#parentDiv").append(childDiv);
                                if(licType != '8'){
                                    $("#fm-search").data('bootstrapValidator').addField('licNoStart'+i,{  
                                        validators : {
                                            digits: {
                                                message: '该值只能包含数字'
                                            },
                                            callback : {
                                                callback : function(value, validator, $field) {
                                                    var licNoStart,licNoEnd;
                                                    var $licNoEnd = $field.parent().children('input[id="licNoEnd"]');
                                                    var licNoList =$("#licNoList").val();
                                                    
                                                    if(value){
                                                        licNoStart = parseInt(value);
                                                    }
                                                    if($licNoEnd.val()){
                                                        licNoEnd = parseInt($licNoEnd.val());
                                                    }
                                                    if(licNoEnd && !licNoStart){
                                                        validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                        validator.updateMessage($field.attr('name'),'callback','請再輸入一個開始編號');
                                                        return false;
                                                    }else if(!licNoEnd && licNoStart){
                                                        validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                        validator.updateMessage($field.attr('name'),'callback','請再輸入一個結束編號');
                                                        return false;
                                                    }else if(licNoEnd && licNoStart && !licNoList ){
                                                        validator.updateStatus('licNoList','NOT_VALIDATED');
                                                        if(licNoEnd < licNoStart) {
                                                            validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                            validator.updateMessage($field.attr('name'), 'callback', '開始號碼不能大於結束號碼');
                                                            return false;
                                                        }
                                                        validator.updateStatus($licNoEnd.attr('name'), 'VALID');
                                                        return true;
                                                    }else{
                                                        validator.updateStatus($licNoEnd.attr('name'), 'VALID');
                                                        return true;
                                                    }
                                                },
                                                message : '開始號碼不能大於結束號碼'
                                            }                          
                                        } 
                                    });  
                                    $("#fm-search").data('bootstrapValidator').addField('licNoEnd'+i,{  
                                        validators : {
                                            digits: {
                                                message: '该值只能包含数字'
                                            },
                                            callback : {
                                                callback : function(value, validator, $field) {
                                                    var licNoStart,licNoEnd;
                                                    var $licNoStart = $field.parent().children('input[id="licNoStart"]');
                                                    var licNoList =$("#licNoList").val();
                                                    if($licNoStart.val()){
                                                        licNoStart = parseInt($licNoStart.val());
                                                    }
                                                    if(value){
                                                        licNoEnd = parseInt(value);
                                                    }
                                                    if(licNoEnd && !licNoStart){
                                                        validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                        validator.updateMessage($field.attr('name'),'callback','請再輸入一個開始編號');
                                                        return false;
                                                    }else if(!licNoEnd && licNoStart){
                                                        validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                        validator.updateMessage($field.attr('name'),'callback','請再輸入一個結束編號');
                                                        return false;
                                                    }else if(licNoEnd && licNoStart && !licNoList){
                                                        validator.updateStatus('licNoList','NOT_VALIDATED');
                                                        if(licNoEnd < licNoStart){
                                                            validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                            validator.updateMessage($field.attr('name'),'callback','開始號碼不能大於結束號碼');
                                                            return false;
                                                        }
                                                        validator.updateStatus($licNoStart.attr('name'), 'VALID');
                                                        return true;
                                                    }else{
                                                        validator.updateStatus($licNoStart.attr('name'), 'VALID');
                                                        return true;
                                                    }
                                                },
                                                message : '開始號碼不能大於結束號碼'
                                            }
                                        }  
                                    });
                                }else{
                                    $("#fm-search").data('bootstrapValidator').addField('licNoStart'+i,{  
                                        validators : {
                                            callback : {
                                                callback : function(value, validator, $field) {
                                                    var licNoStart = value;
                                                    var licNoList =$("#licNoList").val();
                                                    var $licNoEnd = $field.parent().children('input[id="licNoEnd"]');
                                                    var licNoEnd = $licNoEnd.val();
                                                    if(licNoEnd && !licNoStart){
                                                        validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                        validator.updateMessage($field.attr('name'),'callback','請再輸入一個開始編號');
                                                        return false;
                                                    }else if(!licNoEnd && licNoStart){
                                                        validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                        validator.updateMessage($field.attr('name'),'callback','請再輸入一個結束編號');
                                                        return false;
                                                    }else if(licNoEnd && licNoStart && !licNoList ){
                                                        validator.updateStatus('licNoList','NOT_VALIDATED');
                                                        if(licNoEnd < licNoStart) {
                                                            validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                            validator.updateMessage($field.attr('name'), 'callback', '開始號碼不能大於結束號碼');
                                                            return false;
                                                        }
                                                        validator.updateStatus($licNoEnd.attr('name'), 'VALID');
                                                        return true;
                                                    }else{
                                                        validator.updateStatus($licNoEnd.attr('name'), 'VALID');
                                                        return true;
                                                    }
                                                },
                                                message : '開始號碼不能大於結束號碼'
                                            }                          
                                        } 
                                    });  
                                    $("#fm-search").data('bootstrapValidator').addField('licNoEnd'+i,{  
                                        validators : {
                                            callback : {
                                                callback : function(value, validator, $field) {
                                                    var licNoEnd = value;
                                                    var $licNoStart = $field.parent().children('input[id="licNoStart"]');
                                                    var licNoStart = $licNoStart.val();
                                                    var licNoList =$("#licNoList").val();
                                                    if(licNoEnd && !licNoStart){
                                                        validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                        validator.updateMessage($field.attr('name'),'callback','請再輸入一個開始編號');
                                                        return false;
                                                    }else if(!licNoEnd && licNoStart){
                                                        validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                        validator.updateMessage($field.attr('name'),'callback','請再輸入一個結束編號');
                                                        return false;
                                                    }else if(licNoEnd && licNoStart && !licNoList){
                                                        validator.updateStatus('licNoList','NOT_VALIDATED');
                                                        if(licNoEnd < licNoStart){
                                                            validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                            validator.updateMessage($field.attr('name'),'callback','開始號碼不能大於結束號碼');
                                                            return false;
                                                        }
                                                        validator.updateStatus($licNoStart.attr('name'), 'VALID');
                                                        return true;
                                                    }else{
                                                        validator.updateStatus($licNoStart.attr('name'), 'VALID');
                                                        return true;
                                                    }
                                                },
                                                message : '開始號碼不能大於結束號碼'
                                            }
                                        }  
                                    });
                                }
                                i++;
                            });
                            
                            $("#fm-search").on('click','#btn-delete',function(){
                                $(this).parent().parent().remove();
                            });
                            
                            $("#printExcel").click(function() {
                                if(deletedLicNoList.length > 0){
                                    var newDeletedLicNoList = [];
                                    for(var i=0;i<deletedLicNoList.length;i++){
                                        if(newDeletedLicNoList.indexOf(deletedLicNoList[i]) == -1){
                                            newDeletedLicNoList.push(deletedLicNoList[i]);
                                        }
                                    }
                                    queryConditions.deletedLicNoList = newDeletedLicNoList;
                                }
                                var params = encodeURIComponent(JSON.stringify(queryConditions), 'utf-8');
                                window.open(basePath + "/rpt/license/pdmListPrintExcel?params=" + params);
                                 /*axios({
                                            method:'post',
                                            url:basePath+"/rpt/license/pdmListPrintExcel",
                                            responseType: 'blob',
                                            loading:true,
                                            contentType: 'application/json',
                                            data:queryConditions
                                 }).then(function(response){
                                     if (!response) {
                                         return false;
                                     }
                                     atosUtil.downloadPDF(response,'RPT-LIC-RANGE-LIST_.xls');
                                 })*/
                            });
                            
                            $("#printEnvelope").click(function() {
                                if(deletedLicNoList.length > 0){
                                    var newDeletedLicNoList = [];
                                    for(var i=0;i<deletedLicNoList.length;i++){
                                        if(newDeletedLicNoList.indexOf(deletedLicNoList[i]) == -1){
                                            newDeletedLicNoList.push(deletedLicNoList[i]);
                                        }
                                    }
                                    queryConditions.deletedLicNoList = newDeletedLicNoList;
                                }
                                var params = encodeURIComponent(JSON.stringify(queryConditions), 'utf-8');
                                //window.open(basePath + "/rpt/license/printEnvelopeSticker?params=" + params);
                                window.location.href = basePath + "/rpt/license/printEnvelopeSticker?params=" + params;
                                /*axios({
                                    method:'post',
                                    url:basePath+"/rpt/license/printEnvelopeSticker",
                                    responseType: 'blob',
                                    loading:true,
                                    contentType: 'application/json',
                                    data:queryConditions
                                }).then(function(response){
                                    if (!response) {
                                        return false;
                                    }
                                    atosUtil.downloadPDF(response,"RPT-ENVELOPE-STICKER_" + new Date().getTime() + ".doc");
                                })*/
                            });
                            document.onkeydown = function(e){
                               
                            };
                            //查詢條件部分點回車鍵，立刻查詢
                            $('input, select').bind('keypress', function(event){
                                if (event.keyCode == "13") {            
                                    event.preventDefault(); 
                                    self.doSearch();
                                    var formData = $('#fm-search').serializeObject();
                                    formData.licNoList = $("#licNoList").val();
                                    var licNoObjectList = controller.getLicNoMapList();
                                    if(licNoObjectList.length > 0){
                                        formData.licNoMapList = licNoObjectList;
                                    }
                                    queryConditions = formData;
                                }
                            });
                            $(".reset").click(function() {
                                $("#licNoStart").val("");
                                $("#licNoEnd").val("");
                            });
                            
                            self.initBootstrapValidator();
                            
                        },    
                        
                        initBootstrapValidator : function(){
                            $('#fm-search').bootstrapValidator({
                                fields: {
                                    licType:{
                                        validators : {
                                            notEmpty : { }
                                        }
                                    },
                                    licNoStart:{
                                        validators : {
                                            digits: {
                                                message: '该值只能包含数字'
                                            },
                                            callback : {
                                               callback : function(value, validator, $field) {
                                                   var licNoStart = value;
                                                   var licNoList =$("#licNoList").val();
                                                   var $licNoEnd = $field.parent().children('input[id="licNoEnd"]');
                                                   var licNoEnd = $licNoEnd.val();
                                                   if(value){
                                                       licNoStart = parseInt(value);
                                                   }
                                                   if(licNoEnd){
                                                       licNoEnd = parseInt(licNoEnd);
                                                   }
                                                   if(licNoEnd && !licNoStart){
                                                       validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                       validator.updateMessage($field.attr('name'),'callback','請再輸入一個開始編號');
                                                       return false;
                                                   }else if(!licNoEnd && licNoStart){
                                                       validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                       validator.updateMessage($field.attr('name'),'callback','請再輸入一個結束編號');
                                                       return false;
                                                   }else if(licNoEnd && licNoStart && !licNoList){
                                                       validator.updateStatus('licNoList','NOT_VALIDATED');
                                                       if(licNoStart>licNoEnd) {
                                                           validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                           validator.updateMessage($field.attr('name'), 'callback', '開始號碼不能大於結束號碼');
                                                           return false;
                                                       }
                                                       validator.updateStatus($licNoEnd.attr('name'), 'VALID');
                                                       return true;
                                                   } else{
                                                      validator.updateStatus($licNoEnd.attr('name'), 'VALID');
                                                      return true;
                                                   }
                                               },
                                               message : '開始號碼不能大於結束號碼'
                                            }                          
                                        },
                                       
                                    },
                                    licNoEnd:{
                                        validators : {
                                            digits: {
                                                message: '该值只能包含数字'
                                                           },
                                            callback : {
                                                callback : function(value, validator, $field) {
                                                    var licNoEnd = value;
                                                    var $licNoStart = $field.parent().children('input[id="licNoStart"]');
                                                    var licNoStart = $licNoStart.val();
                                                    var licNoList =$("#licNoList").val();
                                                    if(licNoStart){
                                                        licNoStart = parseInt(licNoStart);
                                                    }
                                                    if(value){
                                                        licNoEnd = parseInt(value);
                                                    }
                                                    if(licNoEnd && !licNoStart){
                                                        validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                        validator.updateMessage($field.attr('name'),'callback','請再輸入一個開始編號');
                                                        return false;
                                                    }else if(!licNoEnd && licNoStart){
                                                        validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                        validator.updateMessage($field.attr('name'),'callback','請再輸入一個結束編號');
                                                        return false;
                                                    }else if(licNoEnd && licNoStart && !licNoList){
                                                        validator.updateStatus('licNoList','NOT_VALIDATED');
                                                        if(licNoEnd < licNoStart) {
                                                            validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                            validator.updateMessage($field.attr('name'), 'callback', '開始號碼不能大於結束號碼');
                                                            return false;
                                                        }
                                                        validator.updateStatus($licNoStart.attr('name'), 'VALID');
                                                        return true;
                                                    } else{
                                                       validator.updateStatus($licNoStart.attr('name'), 'VALID');
                                                       return true;
                                                    }
                                                },
                                                message : '開始號碼不能大於結束號碼'
                                            }
                                        }
                                        
                                    }
                                }
                            });
                        },
                        
                        initBootstrapValidatorForAec : function(){
                            $('#fm-search').bootstrapValidator({
                                fields: {
                                    licType:{
                                        validators : {
                                            notEmpty : { }
                                        }
                                    },
                                    licNoStart:{
                                        validators : {
                                            callback : {
                                                callback : function(value, validator, $field) {
                                                    var licNoStart = value;
                                                    var licNoList =$("#licNoList").val();
                                                    var $licNoEnd = $field.parent().children('input[id="licNoEnd"]');
                                                    var licNoEnd = $licNoEnd.val();
                                                    if(licNoEnd && !licNoStart){
                                                        validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                        validator.updateMessage($field.attr('name'),'callback','請再輸入一個開始編號');
                                                        return false;
                                                    }else if(!licNoEnd && licNoStart){
                                                        validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                        validator.updateMessage($field.attr('name'),'callback','請再輸入一個結束編號');
                                                        return false;
                                                    }else if(licNoEnd && licNoStart && !licNoList){
                                                        validator.updateStatus('licNoList','NOT_VALIDATED');
                                                        if(licNoStart>licNoEnd) {
                                                            validator.updateStatus($licNoEnd.attr('name'), 'NOT_VALIDATED');
                                                            validator.updateMessage($field.attr('name'), 'callback', '開始號碼不能大於結束號碼');
                                                            return false;
                                                        }
                                                        validator.updateStatus($licNoEnd.attr('name'), 'VALID');
                                                        return true;
                                                    } else{
                                                        validator.updateStatus($licNoEnd.attr('name'), 'VALID');
                                                        return true;
                                                    }
                                                },
                                                message : '開始號碼不能大於結束號碼'
                                            }                          
                                        },
                                        
                                    },
                                    licNoEnd:{
                                        validators : {
                                            callback : {
                                                callback : function(value, validator, $field) {
                                                    var licNoEnd = value;
                                                    var $licNoStart = $field.parent().children('input[id="licNoStart"]');
                                                    var licNoStart = $licNoStart.val();
                                                    var licNoList =$("#licNoList").val();
                                                    if(licNoEnd && !licNoStart){
                                                        validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                        validator.updateMessage($field.attr('name'),'callback','請再輸入一個開始編號');
                                                        return false;
                                                    }else if(!licNoEnd && licNoStart){
                                                        validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                        validator.updateMessage($field.attr('name'),'callback','請再輸入一個結束編號');
                                                        return false;
                                                    }else if(licNoEnd && licNoStart && !licNoList){
                                                        validator.updateStatus('licNoList','NOT_VALIDATED');
                                                        if(licNoEnd < licNoStart) {
                                                            validator.updateStatus($licNoStart.attr('name'), 'NOT_VALIDATED');
                                                            validator.updateMessage($field.attr('name'), 'callback', '開始號碼不能大於結束號碼');
                                                            return false;
                                                        }
                                                        validator.updateStatus($licNoStart.attr('name'), 'VALID');
                                                        return true;
                                                    } else{
                                                        validator.updateStatus($licNoStart.attr('name'), 'VALID');
                                                        return true;
                                                    }
                                                },
                                                message : '開始號碼不能大於結束號碼'
                                            }
                                        }
                                    
                                    }
                                }
                            });
                        },
                        
                        initSelect2 : function() {
                            $('.sysselect').select2Remote({
                                url : basePath + '/select2/page'
                            });
                            $(".simpleselect").select2();
                            $('#licNoList').select2Remote({
                                url: basePath + '/select2/getLicNoList',
                                data: function (params) {
                                    return {
                                        'licType': $("#licType").val() || '',
                                        'licStatus': $("#licStatus").val() || '',
                                        'keyword': params && params.term? ($(this).attr("codeTypeFilter") == 'true')? params.term+'%':'%' + params.term + '%' : '',
                                                'pageNumber': params.page || 1,
                                                'codeTypeFilter':$(this).attr("codeTypeFilter"),
                                                'includeCancel':$(this).attr("includeCancel"),
                                                'licCatType':$(this).attr('licCatType'),
                                                'initCoachId':$(this).attr('initCoachId'), 
                                                'pageSize': 30
                                    };
                                },
                                minimumInputLength : 2
                            });
                        },
                        doSearch : function() {
                            if (!$.formValidator('.bv-form')) {
                                return false;
                            }
                              var licNoObjectList = controller.getLicNoMapList();
                              var licNoList =$("#licNoList").val();
                              if((licNoObjectList.length==0)&&(licNoList==null||licNoList=="")){
                                  $('#msg').text(atosUtil.getI18nMessage('lic.licNoOneMustBeFilledIn'));
                                  $('#fm-validator').show();
                                  return false;
                              } else {
                                  $('#fm-validator').hide();
                                  deletedLicNoList = [];
                                  var datatable = this.variables.datatable;
                                  // 默認不顯示任何數據，因此第一次點擊查詢按鈕時，需要destroy datatable；再重新init
                                  if (datatable == null) {
                                      $("#table-lic").DataTable().destroy();
                                      this.initDatatables();
                                  } else {
                                      
                                      datatable.ajax.reload();
                                  }
                              }
                            
                        }, 
                        // 操作提醒
                        showResult : function showResult(result) {
                            $.showResult(result);
                        },
                        //把該記錄移出結果集
                        removeResultSet : function(licNo, licType){
                            var self = this;
                            var options = {text : ''};
                            options.text = atosUtil.getI18nMessage('rptLicPdmList.confirmRemoveResultSet', [licNo,licType]);
                            $.confirm(options, function(yes){
                                if(yes){
                                    deletedLicNoList.push(licNo);
                                    self.variables.datatable.ajax.reload();
                                }
                            });
                        },
                        
                        getLicNoMapList : function(){
                            var licNoObjectList = [];
                            $("#parentDiv .form-group").each(function(index){
                                var licNoStart = $(this).find("#licNoStart").val();
                                var licNoEnd = $(this).find("#licNoEnd").val();
                                var licType = $("#licType").val();
                                if(licType != '8'){
                                    if(licNoStart){
                                        licNoStart = parseInt(licNoStart);
                                    }
                                    if(licNoEnd){
                                        licNoEnd = parseInt(licNoEnd);
                                    }
                                }
                                if(licNoStart && licNoEnd && licNoEnd >= licNoStart){
                                    var licNoObject = {};
                                    licNoObject.licNoStart = licNoStart;
                                    licNoObject.licNoEnd = licNoEnd;
                                    licNoObjectList.push(licNoObject);
                                }
                            });
                            return licNoObjectList;
                        }
                    });
            controller.init();
            window.controller = controller;
        });
