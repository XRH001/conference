import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from "./store"
import {decrypt,format,replaceAll,notFind} from "./assets/js/tools"
import {request,http,url} from "./network/request";

require("layui-src/dist/css/layui.css");
require("assets/css/fonts.css");
Vue.config.productionTip = false;
new Vue({
  router,store,
  render: h => h(App)
}).$mount('#app');


Vue.prototype.$request=request;
Vue.prototype.$http=http;

Vue.prototype.$decrypt=decrypt;
//图片未找到
Vue.prototype.$notFind=notFind;
//配置所有地址
Vue.prototype.$url=url;
String.prototype.replaceAll = replaceAll;
Date.prototype.format=format;


