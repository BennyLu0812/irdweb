/**
 * 客戶端工具类.
 * Copyright (c) 2018 Atos Information Technology HK Limited. All Rights Reserved.
 * author: raysely 
 * date: 2018-05-22
 * note: 
 */
var dlsI18n;


String.prototype.format = function (args) {
    if (args.length == 0)
        return this;
    for (var s = this, i = 0; i < args.length; i++)
        s = s.replace(new RegExp("\\{" + i + "\\}", "g"), args[i]);
    return s;
};

Array.prototype.contains = function (val) {
    for (var i = 0; i < this.length; i++) {
        if (this[i] == val) {
            return true;
        }
    }
    return false;
};


Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

define(['jquery','moment'], function ($,moment) {
    'use strict'; // 使用JS嚴格模式.

    /**
     * 自定義Map對象.
     */
    var AtosMap = function () {
        // 數組
        var _list = new Array();
        // 添加map键值对.
        this.put = function (key, value) {
            _list.push({
                key: key,
                value: value
            });
        };
        // 根据key获取value.  
        this.get = function (key) {
            try {
                for (var i = 0; i < _list.length; i++) {
                    if (_list[i].key == key) {
                        return _list[i].value;
                    }
                }
            } catch (e) {
                return null;
            }
        };
        // 根据key删除.
        this.remove = function (key) {
            var flag = false;
            try {
                for (var i = 0; i < _list.length; i++) {
                    if (_list[i].key == key) {
                        _list.splice(i, 1);
                        return true;
                    }
                }
            } catch (e) {
                flag = false;
            }
            return flag;
        };
        // 判断MAP中是否含有指定KEY的元素.
        this.containsKey = function (key) {
            var flag = false;
            try {
                for (var i = 0; i < _list.length; i++) {
                    if (_list[i].key == key) {
                        flag = true;
                    }
                }
            } catch (e) {
                flag = false;
            }
            return flag;
        };
        // 获取map键值对个数.
        this.size = function () {
            return _list.length;
        };
        // 判断map是否为空.
        this.isEmpty = function () {
            return (_list.length < 1);
        };
        // 删除MAP所有元素.
        this.clear = function () {
            _list = new Array();
        };
        // 获取MAP中所有VALUE的数组（ARRAY）. 
        this.getAll = function () {
            var list = [];
            try {
                for (var i = 0; i < _list.length; i++) {
                    list.push(_list[i].value);
                }
                return list;
            } catch (e) {
                return null;
            }
        }
    };

    return {

        /**
         * 是否为空. 
         * @see this.isNotEmpty
         * @param {Object} value 判断的值
         * @param {String} path 层级关系
         * @returns {Boolean}
         */
        isEmpty: function (value, path) {
            //return (value == null || value === "");
            return !this.isNotEmpty(value, path);
        },

        /**
         * 是否不为空.
         * @param {Object} value 判断的值
         * @param {String} path 层级关系
         * @returns {Boolean}
         */
        isNotEmpty: function (value, path) {
            var re = true;
            if (value == null || value === "") {
                re = false;
            } else if (typeof value === "object") {
                if (this.isArray(value)) {
                    re = value.length > 0;
                } else {
                    re = false;
                    for (var key in value) {
                        re = true;
                        break;
                    }
                }
            }
            return re;
        },

        findItem : function(array, field, value) {
            if (!this.isArray(array) || !field) {
                return null;
            }
            var searchItem;
            $.each(array, function (idx, item) {
                if (item[field] == value) {
                    searchItem = item;
                    return false;
                }
            })
            return searchItem;
        },

        /**
         * 判断对象是不是数组.
         */
        isArray: function (obj) {
            return /\[object array\]/gi.test(Object.prototype.toString.call(obj));
        },

        /**
         * 获取url中的参数.
         * @param paramName 参数名称
         * @return 参数值
         */
        getUrlParam: function (paramName) {
            var reg = new RegExp("(^|&)" + paramName + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
            if (r != null) return unescape(r[2]); return null; //返回参数值
        },

        /**
         * 構建下拉控件單個項目.
         * @param id 下拉數據的ID
         * @param text 下拉數據的Text
         * @return 下拉數據對象
         */
        createDropdownSingleOption: function (id, text) {
            return [{ id: id, text: text }];
        },
        
        trimToEmpty: function(value) {
            if (this.isEmpty(value)) {
                return '';
            } else {
                return value;
            }
        },

        /**
         * 取得指定模組的i18n國際化資源消息的key-value對
         * @param moduleCodes 模組簡稱，多個模組用逗號隔開，如'global,lic,dis', 實際上取的是resources/i18n/目錄下的文件夾名稱
         * @param callback 回調函數
         */
        getI18nByModules: function (moduleCodes, callback) {
            $.ajax({
                url: basePath + '/sys/i18n/getByModules?moduleCodes=' + moduleCodes,
                type: 'GET',
                async: false,
                data: '',
                success: function (result) {
                    dlsI18n = result;
                    if (callback) {
                        callback(result);
                    }
                }
            });
        },

        /**
             * 取得指定模組的i18n局部变量的國際化資源消息的key-value對
             * @param moduleCodes 模組簡稱，多個模組用逗號隔開，如'global,lic,dis', 實際上取的是resources/i18n/目錄下的文件夾名稱
             * @param callback 回調函數
             */
        getLocalI18nByModules: function (moduleCodes, callback) {
            var localI18n = [];
            $.ajax({
                url: basePath + '/sys/i18n/getByModules?moduleCodes=' + moduleCodes,
                type: 'GET',
                async: false,
                data: '',
                success: function (result) {
                    localI18n = result;
                    if (callback) {
                        callback(result);
                    }
                }
            });
        },

        /**
         * 根據模組簡稱及參數（可選），格式化國際化資源消息
         * @param code 模組簡稱
         * @param args 數組參數，比如確定刪除{0}嗎？，args代表佔位符{0}
         */
        getI18nMessage: function (code, args) {
            var message = dlsI18n[code];
            if (message) {
                if (!args) {
                    return message;
                }
                return message.format(args);
            } else {
                return code;
            }
        },

        getMessageByI18n: function (i18n, code, args) {
            var message = i18n[code];
            if (message) {
                if (!args) {
                    return message;
                }
                return message.format(args);
            } else {
                return code;
            }
        },


        /**
         * 根據code取得枚舉數組的text
         * @param enumItems 枚舉數組
         * @param code 枚舉類的code
         */
        getEnumText: function (enumItems, code) {
            if (!code) {
                return '';
            }
            for (var i = 0; i < enumItems.length; i++) {
                if (enumItems[i].code == code) {
                    return enumItems[i].text;
                }
            }
            return code;
        },

        /**
         * 格式化指定id的HTML元素的內部元素
         * @param tagId 標籤id
         * @param args 數組參數，args代表佔位符{0}
         */
        formatHtml: function (tagId, args) {
            if ($('#' + tagId).size() > 0) {
                return $('#' + tagId).html().format(args);
            } else {
                return '';
            }
        },
        
        /**
         * Howl加的- -。
         * button的onclick事件传参中传了String对象，String对象包含了特殊字符
         * agrs[0]为String对象，所以要进行encode之后才能传值。
         */
        formatHtmlAndEncodeArgs0: function (tagId, args) {
            if ($('#' + tagId).size() > 0) {
                if(this.isNotEmpty(args[0])){
                    args[0] = encodeURI(args[0]);
                }else{
                    args[0] = encodeURI('');
                }
                
                return $('#' + tagId).html().format(args);
            } else {
                return '';
            }
        },
        
        
        

        /**
         * 創建MAP實例.
         */
        createMapInstance: function () {
            return new AtosMap();
        },

        /**
         * Object Deep Clone.
         * @param obj
         * @return clone obj
         */
        clone: function (obj) {
            // Handle the 3 simple types, and null or undefined or function
            if (null == obj || "object" != typeof obj) return obj;

            // Handle Date
            if (obj instanceof Date) {
                var copy = new Date();
                copy.setTime(obj.getTime());
                return copy;
            }
            // Handle Array or Object
            if (obj instanceof Array | obj instanceof Object) {
                var copy = (obj instanceof Array) ? [] : {};
                for (var attr in obj) {
                    if (obj.hasOwnProperty(attr))
                        copy[attr] = this.clone(obj[attr]);
                }
                return copy;
            }
            throw new Error("Unable to clone obj! Its type isn't supported.");
        },
        dateToDate: function (date) {
            var sDate = new Date();
            if (typeof date == 'object'
                && typeof new Date().getMonth == "function"
            ) {
                sDate = date;
            }
            else if (typeof date == "string") {
                var arr = date.split('/')
                if (arr.length == 3) {
                    sDate = new Date(arr[1] + '/' + arr[0] + '/' + arr[2]);
                }
            }

            return sDate;
        },
        
        dateCompare:function(date1,date2){
            /**
             * 两个日期比较大小，如果date1>date2,返回G,G代表Greater
             * 如果date1==date2,返回E,E代表Equals
             * 如果date1<date2,返回L,L代表Less Than
             * example:
             * 01/01/1900<01/01/1901
             * 
             */
            
            var currentDate1 = date1.getDate();
            var currentDate2 =  date2.getDate();
            var currentMonth1 = date1.getMonth()+1;
            var currentMonth2 = date2.getMonth()+1;
            var currentYear1 = date1.getFullYear();
            var currentYear2 = date2.getFullYear();
                              
            if(currentYear1>currentYear2){
                return "G";
            }else if(currentYear1<currentYear2){
                return "L";
            }else if(currentYear1==currentYear2){
                if(currentMonth1>currentMonth2){
                    return "G";
                }else if(currentMonth1<currentMonth2){
                    return "L";
                }else if(currentMonth1==currentMonth2){
                    if(currentDate1>currentDate2){
                        return "G";
                    }else if(currentDate1<currentDate2){
                        return "L";
                    }else if(currentDate1==currentDate2){
                        return "E";
                    }
                }
            }                        
        },

        addDay: function(date,days) {
            if (!days) {
                days  = 1;
            }
            var date = this.dateToDate(date);
            date.setDate(date.getDate() + days);
            return date.format('dd/MM/yyyy');
        },

        addMonth: function (date, num) {
            num = parseInt(num);
            var sDate = this.dateToDate(date);
            return moment(sDate).add(num,'M').format('DD/MM/YYYY');
        },
        getSysDate: function(){
            var sysDate;
            $.ajax({
                url: basePath + "/sys/service/getSysDate",
                async: false,
                type: 'GET',
                success: function(result) {
                    sysDate = result; // 系統時間
                }
            });
            return sysDate;
        },
        getSysYear: function(){
            var sysDate = this.getSysDate();
            if (this.isNotEmpty(sysDate)) {
                return sysDate.substring(6, 10);
            }
            return sysDate;
        },
        getDate19000101:function(){
            var date19000101 = new Date();
            date19000101.setFullYear(1900,0,1);
            return date19000101;
        },
        getDate99991231:function(){
            var date99991231 = new Date();
            date99991231.setFullYear(9999,11,31);
            return date99991231;
        },
        getSysDateTime: function(){
            var sysDate;
            $.ajax({
                url: basePath + "/sys/service/getSysDateTime",
                async: false,
                type: 'GET',
                success: function(result) {
                    sysDate = result; // 系統時間
                }
            });
            return sysDate;
        },
        /**
         * 顯示loading效果
         * html元素在head.html裏
         */
        showLoading: function () {
            this.hideLoading();
            $("#fullScreenLoading").css('display', 'block');
        },
        /**
         * 隱藏loading效果
         * html元素在head.html裏
         */
        hideLoading: function () {
            $("#fullScreenLoading").css('display', 'none');
        },
        // 異步請求下載回調函數
        download : function(response) {
            var fileName = window.decodeURI(response.headers['content-disposition'].split('=')[1]);
            var blob = new Blob([response.data]);
            if (window.navigator && window.navigator.msSaveOrOpenBlob) {
                navigator.msSaveBlob(blob, fileName);
            }else{
                var  link = document.createElement("a");
                link.href = window.URL.createObjectURL(new Blob([response.data], {type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"}));
                link.target = "_blank";
                link.download = fileName;
                document.body.appendChild(link);
                link.click();
                document.body.removeChild(link);
            }
        },
        downloadPDF: function (fileData, fileName, fileTypeSuffix) {
            var ie = navigator.userAgent.match(/MSIE\s([\d.]+)/),
                ie11 = navigator.userAgent.match(/Trident\/7.0/) && navigator.userAgent.match(/rv:11/),
                ieEDGE = navigator.userAgent.match(/Edge/g),
                ieVer = (ie ? ie[1] : (ie11 ? 11 : (ieEDGE ? 12 : -1)));
            // blob 文件不支持IE10 以下
            if (ie && ieVer < 10) {
                console.log("No blobs on IE ver<10");
                return;
            }
            if (!fileName) {
                fileTypeSuffix = ".pdf";
                fileName = 'download' + new Date().getTime() + fileTypeSuffix;
            }
            var pdfFileAsBlob = new Blob([fileData]);
            if (ieVer > -1) {
                window.navigator.msSaveBlob(pdfFileAsBlob, fileName);
            } else {
                var downloadLink = document.createElement("a");
                downloadLink.download = fileName;
                downloadLink.href = window.URL.createObjectURL(pdfFileAsBlob);
                downloadLink.onclick = function (e) { document.body.removeChild(e.target); };
                downloadLink.style.display = "none";
                document.body.appendChild(downloadLink);
                downloadLink.click();
                window.URL.revokeObjectURL(downloadLink.href);
            }
        },

        DTFormColmunInfo: function (ele, paramArr) {
            var dataFields = [];
            // 需要格式化的類型
            var formatType = ["radioInput", "checkedInput"];
            // 處理表單 返回格式化后的 DT(datatables)所需格式
            $('#' + ele + ' th').each(function (idx, item) {
                var colInfo = {};
                colInfo.renderField = [];
                colInfo.isRender = false;
                colInfo.filtersReg = [];
                colInfo.isFilter = false;
                colInfo.specialStyleFormat = false;

                var param = paramArr[idx];
                // 參數項遍歷       
                $.each(param, function (paramIdx, paramItem) {
                    if(paramItem.prefix){
                        colInfo.isRender = true;
                    }
                    if(paramItem.filterReg){
                        colInfo.isFilter = true;
                    }
                    var renderStr = colInfo.isRender?paramItem.prefix:'';
                    var filterStr = colInfo.isFilter ? paramItem.filterReg : '';
                    colInfo.renderField.push(renderStr);
                    colInfo.filtersReg.push(filterStr);
                    colInfo.data = colInfo.data ? colInfo.data+"_" + paramItem.field : paramItem.field;
                });
                colInfo.width = $(item).attr("row-data-width");
                colInfo.visible = $(item).attr("row-visible");
                colInfo.style = $(item).attr("row-data-style");
                colInfo.index = idx;
                if (formatType.contains(colInfo.rowDataStyle)) {
                    colInfo.specialStyleFormat = true;
                }
                dataFields.push(colInfo);
            });
            return dataFields;
        },
        // 返回列定義信息
        DTFormColmuns: function (dataFields) {
            var dataColumns = [];
            $.each(dataFields, function (idx, item) {
                var dataCol = {width:"8%",visible:true};
                // 狀態發生變化時 取反
                dataCol.visible = item.visible!=undefined&&dataCol.visible!=item.visible ? !dataCol.visible : dataCol.visible;
                // 賦值寬度
                dataCol.width = item.width ? item.width : dataCol.width;
                dataCol.data = item.data;
                dataColumns.push(dataCol);
            });
            return dataColumns;
        },
        // 返回渲染結果處理 定義
        DTFormColmunDefsI18n: function (dataFields,i18n) {
            var dataColumnDefs = [];
            var self = this;
            $.each(dataFields, function (idx, item) {
                var dataColumndef = {};
                // 具有系統定義樣式的才需特殊處理
                if (item.style) {
                    dataColumndef.render = function (data, type, row) {
                        var params = [];
                        var renderData = item.data.split("_");
                        if (item.specialStyleFormat) {
                            var formatStr = i18n ? self.getMessageByI18n(i18n,"style."+item.style,renderData) : self.getI18nMessage("style."+item.style,renderData);
                            return formatStr;
                        }
                        $.each(renderData, function (renderIdx, renderItem) {
                            var regs = item.filtersReg;
                            var reg = item.filtersReg[renderIdx];
                            var type = typeof reg;
                            if (item.isFilter && (typeof reg)!="string"&&!reg.test(row[renderItem])){
                                params.push('');
                                return true;
                            }
                            // hasRowData 返回數據是否有字段數據 useRender 使用渲染從國際化文件取模板  renderFieldExist
                            var hasRowData = row[renderItem],useRender = item.isRender,renderFieldExist = item.renderField[renderIdx];
                            // 如何處理參數
                            var handleParam = hasRowData&&useRender&&renderFieldExist;
                            var resultParam = handleParam ? self.getMessageByI18n(i18n,item.renderField[renderIdx] + "." + row[renderItem]) : row[renderItem];
                            resultParam = resultParam ? resultParam : '';
                            params.push(resultParam);
                        });
                        var formatStr = i18n ? self.getMessageByI18n(i18n,"style."+item.style,params) : self.getI18nMessage("style."+item.style,params);
                        return formatStr;
                    }
                    dataColumndef.targets = item.index;
                }
                dataColumnDefs.push(dataColumndef);
            });
            return dataColumnDefs;
        },
        // 當頁面無嵌入時可使用此方法, 避免axios未及時返回造成數據覆蓋
        DTFormColmunDefs:function(dataFields){
            return this.DTFormColmunDefsI18n(dataFields,dlsI18n);
        },

        /**
         * 根据用户id获取按钮级别权限List .
         */
        getRolefuncList : function() {
            var cache = sessionStorage.getItem("roleFuncList");
            if (cache) {
                return $.parseJSON(cache);
            }
            var userId = sessionStorage.getItem("userId");
            var funcList = new Array();
            $.ajax({
                url: basePath + '/sys/user/getButtonPermission',
                dataType:"JSON",
                async:false,
                type: 'POST',
                data : {"userId":userId},
                success: function(result){
                    if(result){
                        funcList = result;
                    }
                },
                error: function(result){
                }
            });
            sessionStorage.setItem("roleFuncList", JSON.stringify(funcList));
            return funcList;
        },

        /**
         * 获取按钮级别权限Map.
         */
        getRoleFunsMap : function() {
            var cacheRoleFuncList = sessionStorage.getItem("roleFuncList");
            if (cacheRoleFuncList) {
                return  this.roleFuncListToAtosMap(JSON.parse(cacheRoleFuncList));
            }
            var funcList = this.getRolefuncList();
            var funcMap = this.roleFuncListToAtosMap(funcList);
            return funcMap;
        },
        roleFuncListToAtosMap :function(funcList) {
            var atosMap = this.createMapInstance();
            if (!funcList instanceof Array) {
                return atosMap;
            }
            for(var i=0;i<funcList.length;i++){
                atosMap.put(funcList[i].funcCode,funcList[i]);
            }
            return atosMap;
        },
        /**
         * 根据传入code判断是否有权限.
         */
        hasFuncPromission : function(funcCode) {
            var funcMap = this.getRoleFunsMap();
            if(funcMap.get(funcCode)){
                return true;
            }else if(funcCode == ""){
                return true;
            }else{
                return false;
            }
        },
        /**
         * 禁用按鈕幾秒
         */
        disableButton: function(btn,timeout) {
            btn.attr("disabled",true);
            setTimeout(function () {
                btn.attr("disabled",false);
            },timeout)
        },
        
        //日期加上天数后的新日期.
        addDays : function(date,days){
            var nd = new Date(date.split("/")[2] + "-" + date.split("/")[1] + "-" + date.split("/")[0]);
               nd = nd.valueOf();
               nd = nd + days * 24 * 60 * 60 * 1000;
               nd = new Date(nd);
               //alert(nd.getFullYear() + "年" + (nd.getMonth() + 1) + "月" + nd.getDate() + "日");
            var y = nd.getFullYear();
            var m = nd.getMonth()+1;
            var d = nd.getDate();
            if(m <= 9) m = "0"+m;
            if(d <= 9) d = "0"+d; 
            var cdate = d+"/"+m+"/"+y;
            return cdate;
        },
        
        //vue 組件
        createdComponent : function(){
           var str = 
            '<div class="form-group">' +
            '<label class="col-sm-12 h4" ' +
            ' th:text="#{examParams.detail.period}"> 考期申請最少相隔天數：</label>' +
                '<label class="control-label col-sm-1" ' +
                    'th:text="#{examParams.detail.period.newCode}"> 新考理論</label>' + 
                '<div class="col-sm-2">' +
                    '<span id="periodNewCode" class="text-readonly">{{periodNewCode}}&nbsp(<span id="periodNewCodeDate">{{periodNewCodeDate}})</span></span>' +  
                    
                '</div>' +
                '<label class="control-label col-sm-1" ' +
                   ' th:text="#{examParams.detail.period.newBus}"> 新考D/E</label>' +
                '<div class="col-sm-2">                            ' +
                    '<span id="periodNewBus" class="text-readonly">{{periodNewBus}}&nbsp(<span id="periodNewBusDate">{{periodNewBusDate}})</span></span> ' +                              
                '</div>' +
                '<label class="control-label col-sm-1" ' +
                    'th:text="#{examParams.detail.period.new}"> 其他新考</label>' +
               '<div class="col-sm-2">                            ' +
                    '<span id="periodNew" class="text-readonly">{{periodNew}}&nbsp(<span id="periodNewDate">{{periodNewDate}})</span></span> ' +                      
                '</div>' +
                '<label class="control-label col-sm-1" ' +
                    'th:text="#{examParams.detail.period.repeat}"> 覆考</label>' +
                '<div class="col-sm-2">                            ' +
                    '<span id="periodRepeat" class="text-readonly">{{periodRepeat}}&nbsp(<span id="periodRepeatDate">{{periodRepeatDate}})</span></span> ' +              
                '</div>' +
                '<label class="control-label col-sm-1" ' +
                    'th:text="#{examParams.detail.period.specialRepeat}"> 特許覆考</label>' +
                '<div class="col-sm-2">' +                            
                    '<span id="periodSpecialRepeat" class="text-readonly">{{periodSpecialRepeat}}&nbsp(<span id="periodSpecialRepeatDate">{{periodSpecialRepeatDate}})</span></span> ' +            
                '</div>' +
            '</div>'
                return str;
        },
        
        /**
         * 校驗續期年份是否同傳入年份一致.
         */
        isSameYearByCoachYear : function(coachId, examYear) {
            var isSame;
            $.get({
                url: basePath + "/exl/exam/isSameYearByCoachYear?coachId=" + coachId + "&examYear=" + examYear,
                type : "GET", 
                async: false,
                success:function(res){
                    isSame = res;
                }
            });
            return isSame;
        },

        /**
         * 獲取系統參數
         *
         * @param 參數名稱
         */
        getSysParam : function (paramName) {
            var sysParam = "";
            $.get({
                url: basePath + '/sys/params/' + paramName,
                type : "GET",
                async: false,
                success:function(res){
                    if (res != null && res.paramValue != null) {
                        sysParam = res.paramValue;
                    }
                }
            });
            return sysParam;
        }
    }
});