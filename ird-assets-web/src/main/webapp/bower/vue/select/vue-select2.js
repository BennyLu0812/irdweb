define(['jquery','Vue'],function($,Vue){
    var select2Componet = Vue.extend({
        // props: ['options','placeholder', 'value', 'url',
        // 'multiple',"lazy","name",'disabled'],
        props:{
            options:{
                 type:Array,
                 default:[]
            },
            placeholder:{
                type:String,
                default:''
            },
            value:{
                type:Object,
            },
            url:{
                type:String
            },
            multiple:{
                type:Boolean,
                default:false
            },
            lazy:{
                type:Boolean,
                default:false
            },
            name:{
                type:String
            },
            disabled:{
                type:Boolean,
                default:false
            },
            codetype:{
                type:String
            },
            append:{
                type:Boolean,
                default:false
            },
            clear:{
                type:Boolean,
                default:false
            },
            // 啟用bootstrapValidate
            validate:{
            	type:Boolean,
            	default:true
            },
            appendoption:{type:Object},
            licCatType:{ // lic-Cat-Type
                type:String
            },
            coachLicStatus:{ // coachLicStatus
                type:String
            },
            qualifyStatus:{ // qualifyStatus
                type:String
            },
            initCoachId:{
                type:String
            },
            instantLoad:{
                type:Boolean,
                default:true
            },
            codeTypeFilter:{
                type:Boolean,
                default:false
            },
            includeCancel:{
                type:Boolean,
                default:false
            }


        },
        
        template: '<select name="" ><slot></slot></select>',
        data:function(){
            return {
                manualChanged:false,
                multipleChange:false,
                lastChangeField:''
            }
        },
        created: function(){
        	 this.setupProps();
        },
        mounted: function () {
            this.initCommon();
            var vm = this;

            if ($(vm.$el).attr("sys-code-type")) {// 如果是設置了sysCode不需要每次都去發請求
                vm.instantLoad = false;
            }
            if ($(vm.$el).attr("notRequestByValue")) {// 設置了notRequestByValue屬性為true，則不會每次更改value都發請求
                vm.instantLoad = false;
            }

            // 如果在使用頁面沒有做OPTIONS的處理且定義了sys-code-type，並且sys-code-type为不为空。
            if ( (!vm.url && $(vm.$el).attr("sys-code-type") && this.options.length == 0) || vm.codetype ) {
                // 使用根據sys-code動態加載回來的options數據
                this.select2LazyLoad(vm);
            } else if (!vm.url && this.options.length > 0) {// 使用本地自定義options數據
                this.select2Load(vm,vm.options);
            } else if (vm.url && this.options.length == 0){// 使用從ajax請求回來的options數據
                if (this.lazy) {
                 this.select2LazyLoad(vm);
                } else {
                    this.loadFormUrl(vm.url)
                }
        
            }
        },
        methods: {
            loadFormUrl:function(url){
                vm = this;
                $.ajax({
                    url: url,
                    type: 'get',
                    async:false,
                    dataType: 'json',
                    success: function (response) {
                        vm.options = vm.convertData(response);
                        // 由於ajax的異步機制，獲取到的最新的結果需要再次填充到下拉組件裏
                        vm.select2Load(vm, vm.options);
                    }
                })
            },
            clearField:function(){
                $(this.$el).select2('val','all');
            },
            validateSelect:function(val){              
            	var isValidate = '';
            	if(!val) {
            		isValidate = 'NOT_VALIDATED';
            	}else{
            		isValidate = 'VALID';
            	}
            	$(this.$el).closest("form").bootstrapValidator('updateStatus', this.name, isValidate);
            },
            convertData: function (options) {
                var results = [];
                var tmp = {};
                if (options.data){
                    tmp = options.data;
                }else{
                    tmp = options;
                }
                $.each(tmp, function (index, obj) {
                    var text = obj.text;
                    if (text && text.length > 0) {
                    } else {
                        text = obj.description;
                    }
                    if (!(obj.id)) {
                        obj.id = obj.code;
                    }
                    results.push({ id: obj.id, text: text });
                });
                return results;
            },
            select2LazyLoad:function(vm){
                vm.lazy = true;
                if ($(vm.$el).attr("sys-code-type") || vm.url || vm.codetype){
                    if(!vm.url){
                        vm.url = basePath + '/select2/page';
                    }
                    var options = {};
                    options.url = vm.url;
                    options.multiple = vm.multiple;
                    options.placeholder = vm.placeholder;
                    if (vm.licCatType){
                        $(this.$el).attr('licCatType',vm.licCatType);
                    }
                    if (vm.coachLicStatus){
                        $(this.$el).attr('coachLicStatus',vm.coachLicStatus);
                    }
                    if (vm.qualifyStatus){
                        $(this.$el).attr('qualifyStatus',vm.qualifyStatus);
                    }
                    if (vm.initCoachId) {
                        $(this.$el).attr('initCoachId',vm.initCoachId);
                    }
                    /*if (vm.codetype){*/
                    	$(this.$el).attr('sys-code-type',vm.codetype);
                    /*}*/
                    $(vm.$el).select2Remote(options).val(this.value).trigger('change').on('change', function () {
                        if (vm.multiple) {
                            vm.$emit('input', $(this).val())
                        } else {
                            vm.$emit('input', this.value);
                        }
                        vm.$emit('change');
                    });
                   this.bindEvents(vm);
                }
            },
            select2Load:function(vm,data){
                data = this.convertData(data);
                $(vm.$el).empty().select2(
                    { data: data, multiple: vm.multiple,placeholder:vm.placeholder }
                    ).val(this.value).trigger('change').on('change', function () {
                            // emit event on change.
                        if(vm.multiple){
                            vm.$emit('input', $(this).val())
                        }else{
                            vm.$emit('input', this.value);
                        }
                        vm.$emit('change');
                    });
                this.bindEvents(vm);
            },
            bindEvents :function(vm){
                var self = this;
                $(vm.$el).on('select2:select',function () {
                    self.manualChanged = true; // 选中事件触发，必定是手动选择的
                  //  self.selectValidatorEnable(true);
                    vm.$emit('selected');
                });
                $(vm.$el).on('select2:selecting',function () {
                    vm.$emit('selecting');
                });
                $(vm.$el).on('select2:unselect',function () {
                    //self.selectValidatorEnable(true);
                    vm.$emit('unselect');
                });
                $(vm.$el).on('select2:unselecting',function () {
                    vm.$emit('unselecting');
                });
                $(vm.$el).on('select2:open', function () {
                    vm.$emit('open');
                });
                $(vm.$el).on('select2:opening', function () {
                    vm.$emit('opening');
                });
                $(vm.$el).on('select2:closing', function () {
                    vm.$emit('closing');
                });
                $(vm.$el).on('select2:close', function () {
                    vm.$emit('close');
                });

            },
            initCommon: function(){
                var self = this;
                self.setupProps();
                $(self.$el).closest("form").on('reset',function(){
                    // 重置處理 清空
                    if (self.lazy) {
                        $(self.$el).empty();
                    }else 
                    $(self.$el).select("val",'all');
                   // $(self.$el).closest("form").data('bootstrapValidator').resetForm();
                })
                if (self.disabled){
                	 $(this.$el).attr("disabled",self.disabled);
                }
            },
            selectValidatorEnable: function(enabled) {
                var bootstrapValidator = $(this.$el).closest("form").data("bootstrapValidator")
                if (bootstrapValidator) {
                    if (bootstrapValidator.options && bootstrapValidator.options.fields[this.name]) {
                        bootstrapValidator.options.fields[this.name].enabled = enabled;
                    }
                }
              // $(this.$el).closest("form").bootstrapValidator('enableFieldValidators', this.name, enabled);
            },
            setupProps: function () {
                if(this.name){
                    $(this.$el).attr("name",this.name);
                }
                
                if (!this.multiple) {
                    this.multiple = false;
                }
                if ($(this.$el).attr("multiple") == 'multiple') {
                    this.multiple = true;
                }
                if (!this.lazy) {
                    this.lazy = false;
                }
                if ($(this.$el).attr("lazy") == 'true') {
                    this.lazy = true;
                }
                if ($(this).attr("codeTypeFilter") == 'true') {
                    this.codeTypeFilter = true;
                }
                if ($(this).attr("includeCancel") == 'true') {
                    this.includeCancel = true;
                }
                if ($(this.$el).attr("placeholder")){
                	this.placeholder = $(this.$el).attr("placeholder");
                }
            }, 
            selectedValue:function(options,value){
            	  var self = this;
            	  options = self.convertData(options);
            	  if (options.length > 0) {
                      for (var i in options) {
                           if (self.multiple){
                               for (var j in value){
                                   if (value[j] == options[i].id){
                                       if ([].concat(value).sort().join(",") !== [].concat($(self.$el).val()).sort().join(",")) {
                                                var newOption = new Option(options[i].text, options[i].id, true, true);
                                                 $(self.$el).append(newOption).trigger('change');
                                         }
                                      
                                   }
                               }
                           }else if (self.value == options[i].id) {
                              var newOption = new Option(options[i].text, options[i].id, true, true);
                              $(self.$el).append(newOption).trigger('change');
                          }
                      }
                  }
            },
            changeOptions: function(options) {
                var that = this
                $(that.$el).empty();
                $.each(options, function (i, item) {
                    $(that.$el).append(new Option(item.id, item.text, false, true));
                })
                $(that.$el).select2('val', 'all');
            }
        },
        watch: {
            disabled:function(val){
                $(this.$el).attr("disabled",val);
            },
            clear:function(val){
                if (val){
                    //clear 
                    $(this.$el).select2('val','all');
                }
            },
            validate: function(val){
            	var isValidate = '';
            	if(!val) {
            		isValidate = 'NOT_VALIDATED';
            	}else{
            		isValidate = 'VALID';
            	}
            	$(this.$el).closest("form").bootstrapValidator('updateStatus', this.name, isValidate);
            },
            value: function (value) {
                var self = this;
                if (!value) {
                    return;
                }
                if (!self.instantLoad && !self.multiple) {
                    if (self.manualChanged) {
                        $(self.$el).val(value).trigger('change'); // 手動的選擇觸發 bootstrapValidator驗證
                        return; // 若为手动选择，不去匹配选中,直接返回
                    }else{
                        //self.selectValidatorEnable(false); // 非手動的選擇關閉bootstrapValidator驗證
                    }
                }
                if (self.options.length == 0 && (!self.url || (self.url && self.lazy))) {// 默認值選中邏輯
                    $.ajax({
                        url: self.url ? self.url : (basePath + '/select2/data'),
                        type: 'GET',
                        async: false,
                        data: {
                            codeType: $(self.$el).attr("sys-code-type") ? $(self.$el).attr("sys-code-type") : self.codetype,
                            queryString: value,
                            initCoachId: $(self.$el).attr("initCoachId")
                        },
                        success: function (response) {
                            self.options = response;
                            self.selectedValue(self.options, value);
                            if (self.appendoption && self.append) {
                                if (self.appendoption.text) {
                                    var item = new Option(self.appendoption.text, self.appendoption.id, false, false);
                                    $(self.$el).append(item);
                                }

                            }
                        }
                    });
                } else {
                    if (self.multiple) {
                        //self.selectedValue(self.options,value);
                        if ([].concat(value).sort().join(",") !== [].concat($(self.$el).val()).sort().join(",")) {
                            $(self.$el).val(value).trigger('change');
                        }
                    } else
                        $(self.$el).val(value).trigger('change');
                }
            },
            url: function (val) {
                // url變為空或undefined,直接返回
                if (!val) return;
                if(this.lazy){
                    this.select2LazyLoad(this);
                }else{
                    this.loadFormUrl(val);
                }
            },
            codetype:function(codetype){
                this.select2LazyLoad(this);
            },
            licCatType:function(licCatType){
                this.select2LazyLoad(this);
            },
            coachLicStatus:function(coachLicStatus){
                this.select2LazyLoad(this);
            },
            qualifyStatus:function(qualifyStatus){
                this.select2LazyLoad(this);
            },
            initCoachId: function(initCoachId){
                this.select2LazyLoad(this);
            }, 
            options: function (options) {
              // $(this.$el).empty().select2({ data: options })
               // this.select2Load(this, options);
            },
            
        },
        destroyed: function () {
            $(this.$el).off().select2('destroy')
        }
    })
    Vue.component('v-select', select2Componet);
    return {
        getComponent:function(){
            return new select2Componet();
        },
        /**
         * 返回select 对象的jquery对象
         */
        getJQueryObject:function(){
        	
        }
    	
        
    }
});

