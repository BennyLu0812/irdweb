### dialog 使用方法 ###
1.在html裏使用標籤 <auth-dialog :show="isShow" @ok="ok" @cancel="cancel" :auth-Params="authParams"></auth-dialog>
既可顯示出授權dialog **** 注意：属性的大小写敏感  例如  ':authparams'  不能写为 ':authParams' ** 

2.事件
<auth-dialog v-show="show=true" @ok="ok" @cancel="cancel"></auth-dialog>
ok是授權成功後的回調方法
同樣cancel是取消方法的回調方法
<auth-dialog v-show="show=true" @ok="ok" @cancel="cancel"></auth-dialog>

:auth-Params  ( 注意不能写成authParams)提供授權所需要的參數 
:auth-Params至少需要提供authItem,authUser,所以在前端js頁面，最少也需要提供authItem
其中authUser 是已授權用戶（dialog輸入的用戶名）.




其他屬性
<auth-dialog :show="isShow"  @ok="ok" @cancel="cancel" :auth-Params="authParams"
:cancel-Text="cancel" :ok-Text="Ok" :ok-Class="okClass" :cancel-Class="cancelClass"></auth-dialog>

:cancel-Text    cancel按鈕顯示的文字 ，默認為cancel 
:ok-Text="Ok"   ok按鈕的文字 ，默認為Ok,
:ok-Class="okClass" ok按鈕的css樣式
:cancel-Class="cancelClass" 取消按鈕的css樣式