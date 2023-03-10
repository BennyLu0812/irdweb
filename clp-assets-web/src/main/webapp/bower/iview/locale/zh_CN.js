(function webpackUniversalModuleDefinition(root, factory) {
	if(typeof exports === 'object' && typeof module === 'object')
		module.exports = factory();
	else if(typeof define === 'function' && define.amd)
		define("iview/locale", [], factory);
	else if(typeof exports === 'object')
		exports["iview/locale"] = factory();
	else
		root["iview/locale"] = factory();
})(this, function() {
return /******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "/dist/locale/";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 13);
/******/ })
/************************************************************************/
/******/ ({

/***/ 13:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
    value: true
});
exports.default = {
    i: {
        locale: 'zh-CN',
        select: {
            placeholder: '?????????',
            noMatch: '???????????????',
            loading: '?????????'
        },
        table: {
            noDataText: '????????????',
            noFilteredDataText: '??????????????????',
            confirmFilter: '??????',
            resetFilter: '??????',
            clearFilter: '??????'
        },
        datepicker: {
            selectDate: '????????????',
            selectTime: '????????????',
            startTime: '????????????',
            endTime: '????????????',
            clear: '??????',
            ok: '??????',
            datePanelLabel: '[yyyy???] [m???]',
            month: '???',
            month1: '1 ???',
            month2: '2 ???',
            month3: '3 ???',
            month4: '4 ???',
            month5: '5 ???',
            month6: '6 ???',
            month7: '7 ???',
            month8: '8 ???',
            month9: '9 ???',
            month10: '10 ???',
            month11: '11 ???',
            month12: '12 ???',
            year: '???',
            weekStartDay: '0',
            weeks: {
                sun: '???',
                mon: '???',
                tue: '???',
                wed: '???',
                thu: '???',
                fri: '???',
                sat: '???'
            },
            months: {
                m1: '1???',
                m2: '2???',
                m3: '3???',
                m4: '4???',
                m5: '5???',
                m6: '6???',
                m7: '7???',
                m8: '8???',
                m9: '9???',
                m10: '10???',
                m11: '11???',
                m12: '12???'
            }
        },
        transfer: {
            titles: {
                source: '?????????',
                target: '????????????'
            },
            filterPlaceholder: '?????????????????????',
            notFoundText: '????????????'
        },
        modal: {
            okText: '??????',
            cancelText: '??????'
        },
        poptip: {
            okText: '??????',
            cancelText: '??????'
        },
        page: {
            prev: '?????????',
            next: '?????????',
            total: '???',
            item: '???',
            items: '???',
            prev5: '?????? 5 ???',
            next5: '?????? 5 ???',
            page: '???/???',
            goto: '??????',
            p: '???'
        },
        rate: {
            star: '???',
            stars: '???'
        },
        tree: {
            emptyText: '????????????'
        }
    }
};

/***/ })

/******/ });
});