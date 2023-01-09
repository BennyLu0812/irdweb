(function(global, factory) {

    if (typeof module === "object" && typeof module.exports === "object") {
        module.exports = factory();
    } else {
        factory();
    }
}(typeof window !== "undefined" ? window : this, function() {
    
    var i18n = {};
    
    if (typeof define === "function" && define.amd) {
        define([], function() {
            return i18n;
        });
    }
    
    return i18n;
}));