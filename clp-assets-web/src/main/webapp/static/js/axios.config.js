/**
 * axios全局配置.
 */
define([ 'jquery', 'axios','Vue','atosUtil','Noty', 'noty.config'], function($, axios,Vue,atosUtil) {

    'use strict'; // 使用JS嚴格模式.
    // axios全局默认值
    axios.defaults.headers['Content-Type'] = 'application/json; charset=UTF-8';
    axios.defaults.headers["X-Requested-With"] = 'XMLHttpRequest';
    axios.defaults.loading = false;
    axios.defaults.showErrorMsg = true;
    axios.defaults.handleResponse = true;

    axios.interceptors.request.use(function(request){
        if (request.loading) atosUtil.showLoading();
        return request;
    },function(error){
        if (request.loading)  atosUtil.hideLoading();
    });

    // http请求拦截 禁用GET方法的緩存。
    axios.interceptors.request.use(function(config) {
        if (config.method == 'get') {
            if (/\?/.test(config.url)) {
                config.url += '&d=' + Math.random();
            } else {
                config.url += '?d=' + Math.random();
            }
        }
        return config;
    });

    // axios 拦截器
    axios.interceptors.response.use(function(response) {
        if (response.config.loading) {
            atosUtil.hideLoading();
        }
        if (response.config.handleResponse) {
            return response.data || response;
        }
        return response;

    }, function(error) {
        if (error.config.loading) {
            atosUtil.hideLoading();
        }
        if (error.response && error.response.data && error.config.showErrorMsg) {
            $.showResult(error.response.data);
        }
        return Promise.reject(error);
    });

});