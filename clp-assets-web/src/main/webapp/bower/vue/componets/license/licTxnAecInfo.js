require(
  // load libs right now
  ['Vue', 'vueloader'],
  function(Vue, vue){
    // now load our single-file-component app
    // syntax: <vue loader module>!<relative path to .vue file>
    require(['vueloader!vue/componets/license/licTxnAecInfo'], function(theApp){
      // mount app. Voila!
     // theApp.$mount('#app');
    });
  }
);