(function (global, factory) {
    typeof exports === 'object' && typeof module !== 'undefined' ? module.exports = factory() :
        typeof define === 'function' && define.amd ? define(factory) :
            (global.tinyImgUpload = factory());
}(this, (function () {
    'use strict';

    /**
 * tinyImgUpload
 * @param el [string] [生成组件的元素的选择器]
 * @param options [Object] [对组件设置的基本参数]
 * options具体参数如下
 * path 图片上传的地址路径 必需
 * onSuccess(res) 文件上传成功后的回调 参数为返回的文本 必需
 * onFailure(res) 文件上传失败后的回调 参数为返回的文本 必需
 * @return [function] [执行图片上传的函数]
 * 调用方法
 * tinyImgUpload('div', options)
 */
    function tinyImgUpload(options) {
        var el = options.el,
            // 圖片限制上傳個數
            limit = options.limit,
            currentFileNumber = 0;
        // 判断容器元素合理性并且添加基础元素
        var eleList = document.querySelectorAll(el);
        if (eleList.length == 0) {
            console.log('绑定的元素不存在');
            return;
        } else if (eleList.length > 1) {
            console.log('请绑定唯一元素');
            return;
        } else {

            eleList[0].innerHTML = '<div id="img-container" >' +
                '<div class="img-up-add img-item"> <span class="img-add-icon">+</span> <span class="img-text-tip">點擊上傳證件照</span> </div>' +
                '<input type="file" name="files" id="img-file-input" multiple>' +
                '</div>';
            var el = eleList[0].querySelector('#img-container');
            el.files = [];   // 当前上传的文件数组
        }

        // 为添加按钮绑定点击事件，设置选择图片的功能
        var addBtn = document.querySelector('.img-up-add');
        addBtn.addEventListener('click', function () {
            document.querySelector('#img-file-input').value = null;
            document.querySelector('#img-file-input').click();
            return false;
        }, false)

        // 预览图片
        //处理input选择的图片
        function handleFileSelect(evt) {
            var files = evt.target.files;

            for (var i = 0, f; f = files[i]; i++) {
                // 过滤掉非图片类型文件
                if (!f.type.match('image.*')) {
                    continue;
                }
                // 过滤掉重复上传的图片
                var tip = false;
                for (var j = 0; j < (el.files).length; j++) {
                    if ((el.files)[j].name == f.name) {
                        tip = true;
                        break;
                    }
                }
                if (!tip) {
                    currentFileNumber++;
                    //儅達到最大上傳限制時，隱藏上傳控件
                    if (currentFileNumber >= limit) {
                        addBtn.style.display = 'none';
                    }
                    // 图片文件绑定到容器元素上
                    el.files.push(f);

                    var reader = new FileReader();
                    reader.onload = (function (theFile) {
                        return function (e) {
                            var oDiv = document.createElement('div');
                            oDiv.className = 'img-thumb img-item';
                            // 向图片容器里添加元素
                            oDiv.innerHTML = '<img class="thumb-icon" src="' + e.target.result + '" />' +
                                '<a href="javscript:;" class="img-remove">x</a>'

                            el.insertBefore(oDiv, addBtn);
                        };
                    })(f);

                    reader.readAsDataURL(f);
                }
            }
        }
        document.querySelector('#img-file-input').addEventListener('change', handleFileSelect, false);

        // 删除图片
        function removeImg(evt) {
            if (evt.target.className.match(/img-remove/)) {
                console.log('3', el.files);
                // 获取删除的节点的索引
                function getIndex(el) {

                    if (el && el.nodeType && el.nodeType == 1) {
                        var oParent = el.parentNode;
                        var oChilds = oParent.children;
                        for (var i = 0; i < oChilds.length; i++) {
                            if (oChilds[i] == el)
                                return i;
                        }
                    } else {
                        return -1;
                    }
                }
                // 根据索引删除指定的文件对象
                var index = getIndex(evt.target.parentNode);
                el.removeChild(evt.target.parentNode);
                if (index < 0) {
                    return;
                } else {
                    el.files.splice(index, 1);
                }
                console.log('4', el.files);

                currentFileNumber--;
                if (currentFileNumber < limit) {
                    addBtn.style.display = 'table';
                }
            }
        }
        el.addEventListener('click', removeImg, false);

        // 上传图片
        function uploadImg() {
            console.log(el.files);

            var xhr = new XMLHttpRequest();
            var formData = new FormData();

            for (var i = 0, f; f = el.files[i]; i++) {
                formData.append('files', f);
            }

            console.log('1', el.files);
            console.log('2', formData);

            xhr.onreadystatechange = function (e) {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        options.onSuccess(xhr.responseText);
                    } else {
                        options.onFailure(xhr.responseText);
                    }
                }
            }

            xhr.open('POST', options.path, true);
            xhr.send(formData);

        }
        return uploadImg;
    }


    return tinyImgUpload;

})));
