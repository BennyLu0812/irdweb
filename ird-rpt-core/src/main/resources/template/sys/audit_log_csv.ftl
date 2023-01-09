功能名稱,創建用戶,創建時間,備註,服務,操作,主機IP,操作
<#list list as item>
${item.sysFuncDesc},${item.sysOperatorId},${item.sysOperationTime},${item.sysRemark!''},${item.serviceCname!''},${item.processCname},${item.hostIP}
</#list>