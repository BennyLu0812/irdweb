define(['atosUtil'], function(atosUtil) {
    'use strict'; // 使用JS嚴格模式.

    var I18nPlugin = {
        install : function (Vue, options) {
            Vue.loadedI18nModules = []
            Vue.loadedI18n = {}

            // 獲取國際化信息
            Vue.prototype.$i18n = function (code, args) {
                return atosUtil.getMessageByI18n(Vue.loadedI18n, code, args)
            }


            Vue.bindModules = function (modArr) {
                var self = this
                var loadModules = []
                for(var i = 0, len = modArr.length; i < len; i++) {
                    if (this.loadedI18nModules.indexOf(modArr[i]) == -1) {
                        loadModules.push(modArr[i])
                    }
                }
                this.loadedI18nModules = loadModules.concat(this.loadedI18nModules)
                atosUtil.getLocalI18nByModules(loadModules.join(","), function (result) {
                    self.loadedI18n = $.extend(self.loadedI18n, result)
                })
            }

            // 全局i18n組件
            Vue.component('i18n', {
                render: function (createElement) {
                    return createElement(
                        'font',   // 标签名称
                        atosUtil.getMessageByI18n(Vue.loadedI18n, this.$attrs.name) // 子节点数组
                    )
                }
            })
        }
    }

    return I18nPlugin;
})
