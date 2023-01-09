####考試日曆配額查看使用方法:
#####1.在HTML中添加`<quota-info v-show = "showVehRegDateQuota" :quota-Params ="quotaParams"></quota-info>`標籤
> *注意*： 既可顯示出授權dialog **** 注意：属性的大小写敏感  例如  ':quotaparams'  不能写为 ':quotaParams' ** <br/>
> 參數qootaParams
        quotaParams:{
                    examDetailId:"",
                    examDate : "",
                    examSubType :"",
                    examType : "",
                    isDSLABus : "",
                    operationType : "",
                    sessionQuota : null
                }
其中:
   如果是examDetailId不為空,examDate不為空，operationType為M，表示為後天改期，否則就服務界面通過”考試日曆“打開頁面查看配額
 必傳參數：examType 需要判斷是否為空論
       examSubType 考試種類
       examDate 考試日期
       isDSLABus 是否是勞工巴士

   可選參數: operationType 如果是改期相關功能需要傳M ;
        sessionQuota 如需要獲取正常配額情況可添加該參數，不需要則不用添加
    