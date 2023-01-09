###个人资料组件使用方法

####一、使用場景:

#####1、根據docId顯示個人有效證件信息

    `<pdm-info v-show="show" v-model="docId"></pdm-info>`

#####2、根據docId 和 docSeq顯示個人指定證件信息

    `<pdm-info v-show="show" v-model="docId" :docseq="docSeq"></pdm-info>`

> **注意** ：属性的大小写敏感  例如:docseq  不能写为 docSeq

####二、使用方法：
#####1 . 首先在对应模块的js文件里引入 'pdmInfo'
        在html里使用标签`<pdm-info></pdm-info>`

#####2 . 标签属性说明
    `<pdm-info v-show="pdmShow" v-model="docId" :titleshow="titleShow" :docseq="docSeq" ></pdm-info>`
   
其中
- v-show 控制这个组件显示或者隐藏。默认为true。
- v-model **必须** 传递docId给组件 此docId为必须，不然显示的空内容。
- :titleshow  控制显示title是否显示，title 为 "个人资料" 
- :docseq  传递docseq数据 给组件

#####3 . html頁面使用組件示例

在頁面對應區域寫入<pdm-info></pdm-info>標籤:

    `<pdm-info v-show="show" v-model="docId" :docseq="docSEQ"></pdm-info>`
    
> **注意:**
- v-model : 將docId傳遞給組件，該docId為必須的，不然拋出異常，不顯示數據.
- :docseq : 傳遞docseq數據給組件，非必須的.
    


  