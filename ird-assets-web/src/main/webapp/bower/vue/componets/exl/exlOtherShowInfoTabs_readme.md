## 組件用法
HTML : 
<!-- 其他信息模塊Tab標籤 -->
FOR EXAMPLE --- 
<exl-other-show-tabs v-model="pdmParam.docId" :docSeq="pdmParam.docSeq" :tabs="tabs"></exl-other-show-tabs>

JS : Vue實例中 定義pdmParam,及tabs
FOR EXAMPLE --- 
new Vue({
    ...,
    data : {
        pdmParam : {
            moduleShow : true,
            docId : '299503',
            docSeq : '1',
            titleshow : true
        },
        tabs : {
                            // 組件格式
                            "restriction" : {
                                "href" : "examservice-restriction-tab",
                                "isVueCompoment" : true,
                                "compomentInfo" : {
                                    componentName : "lic-restriction",
                                    compomentProp : {
                                        show : true,
                                        value : {
                                            spNo: 'SP001-180004118',
                                            licNo: '',
                                            licType: ''
                                        }
                                    }
                                },
                                "text" : atosUtil.getI18nMessage("exam.tab.restriction")
                            },
                            // 通過url嵌入DIV格式
                            "exam" : {
                                "href" : "examservice-exam-tab",
                                "dataHref" : "/dls/web/exl/exam/examDetail/service_list.html",
                                "text" : atosUtil.getI18nMessage("exam.tab.examRecord")
                            },
       }
   },
   ...,
});

## 如果以組件形式嵌入,需 定義 'vueloader'中組件的位置
FOR EXAMPLE --- 
lic組件  => require(['vueloader!vue/componets/license/restriction/licRestriction']