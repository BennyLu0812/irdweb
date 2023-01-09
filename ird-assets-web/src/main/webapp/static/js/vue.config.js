/**
 * vue全局配置.
 */
define(['jquery','Vue', 'atosUtil', 'axios', 'I18nPlugin', 'axios.config'], function ($, Vue, atosUtil, axios, I18nPlugin) {
    Vue.use(I18nPlugin)
    /**
     * 權限指令.
     * sample => v-authorize="'hasPermission(\'HZM-ENQ-INFO-TAB\')'"
     */
    // 注册一个全局自定义指令 `v-focus`
    Vue.directive('authorize', {
        // 当被绑定的元素插入到 DOM 中时……
        bind : function (el, binding) {
            var authExp = binding.value
            if (!authExp || authExp == '') {
                return;
            }
            el.style.display = "none"
            console.log('[%s] authorize權限驗證表達式 : %s', el.nodeName.toLowerCase(), authExp)

            auth(authExp, function() {
                el.style.display = ""
            }, function(){})
        }
    })

    /**
     * 附加權限.
     * sample : v-additional-authorize="{showCondition: status == 'D', hideCondition: status == 'D', permission: 'PERMISSION-A'}"
     */
    Vue.directive('additional-authorize', {
        bind : function (el, binding) {
            var isDisplay = true
            if (binding && binding.value.showCondition === false) {
                isDisplay = false
            } else if(binding && binding.value.hideCondition === true) {
                isDisplay = false
            }
            if (isDisplay) {
                return;
            }
            el.style.display = "none"
            var authExp = "hasPermission('" + binding.value.permission + "')"

            console.log('[%s] authorize權限驗證表達式 : %s', el.nodeName.toLowerCase(), authExp)

            auth(authExp,  function() {
                el.style.display = ""
            }, function() {})
        }
    })

    /**
     * 應用於 <input v-reset>
     * 重置按鈕觸發事件 ===>> vm.$emit('formReset').
     */
    Vue.directive('reset', {
        bind: function (el, binding, vnode) {
            vnode.context.$on('formReset',function() {
                var event = document.createEvent("HTMLEvents");
                event.initEvent("input", false, false);

                el.value = null;
                el.dispatchEvent(event);
            })
        }
    })

    /**
     * 應用於 <v-select v-reset-select></v-select>
     * 重置按鈕觸發事件 ===>> vm.$emit('formReset').
     */
    Vue.directive('reset-select', {
        bind: function (el, binding, vnode) {
            vnode.context.$on('formReset', function() {
                vnode.componentInstance.clearField()
            })
        }
    })

    function auth(authExp, successCallback, errorCallback) {
        // 使用axios 異步請求, 無法保證指令的順序性,
        // sample => v-authorize="'hasPermission(\'HZM-ENQ-INFO-TAB\')'" v-additional-authorize="{hideCondition:status == 'D', permission: 'HZM-ENQ-INFO-TAB1'}"
        // 例子中應該先驗證 v-authorize 再驗證 v-additional-authorize
        $.ajax({
            url: basePath + '/sys/auth/' + authExp,
            type:'GET', //GET
            async:false, //或false,是否异步
            timeout : 1000, //超时时间
            dataType:'json', //返回的数据格式：
            success:function(data,textStatus,jqXHR){
                if (data) {
                    successCallback()
                } else {
                    errorCallback()
                }
            }
        })
    }

    //  注册一个全局自定义指令 `v-i18n`
    Vue.directive('i18n', {
        // bind 只调用一次，指令第一次绑定到元素时调用。在这里可以进行一次性的初始化设置。
        // el：指令所绑定的元素，可以用来直接操作 DOM。
        // binding：一个对象，包含property
        bind: function (el, binding, vnode) {
            var expression = binding.expression;
            var msg = atosUtil.getI18nMessage(expression);
            el.innerHTML = msg;
        }
    })
})