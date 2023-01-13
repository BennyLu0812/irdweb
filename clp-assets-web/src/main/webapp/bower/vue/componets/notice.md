**开发vue 组件注意事项**
- 
 - 当使用 `{{}}` 表达式时,会在渲染元素时闪现{{}} ，比较影响用户体验，
  _解决方法：
  统一使用 v-text 来代替，有一些不好使用v-text可以用v-cloak 来代替,
  
  样例代码_
  >` <label class="control-label col-sm-1">{{label.licSubstituteNo}}</label>
     <label class="control-label col-sm-1">{{label.applyDate}}</label>`
     <br>
 >    - 应该改为:
     `<label class="control-label col-sm-1" v-text="label.licSubstituteNo "></label>
                   <label class="control-label col-sm-1" v-text="label.applyDate></label>`'
>                   
     <label class="control-label  col-sm-1" v-cloak >{{label.applyDate}}</label>     
     
* 引用问题

> 之前的版本使用，都是一个vue文件，对应一个js文件，在require.config.js加入js的引入配置，
虽然在使用时看起来简便了，但是经常出现组件不加载的情况
所以现在统一直接通过vueloader来加载vue组件
形式为vueloader!vue组件存放基于basePath的相对路径
如 vueloader!vue/component/pdm/pdmAddress
     
              
             