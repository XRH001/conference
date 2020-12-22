import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from "./store"
import {decrypt,format,replaceAll,notFind,getByKey,removeByKey} from "./assets/js/tools"
import {request,http,url,post} from "./network/request";
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';


require("layui-src/dist/css/layui.css");
require("assets/css/fonts.css");


Vue.config.productionTip = false;
Vue.use(ElementUI);
new Vue({
  router,store,
  render: h => h(App)
}).$mount('#app');


Vue.prototype.$request=request;
Vue.prototype.$http=http;
Vue.prototype.$post=post;
Vue.prototype.$decrypt=decrypt;
Vue.prototype.$getBykey=getByKey;
Vue.prototype.$removeByKey=removeByKey;
//图片未找到
Vue.prototype.$notFind=notFind;
//配置所有地址
Vue.prototype.$url=url;
String.prototype.replaceAll = replaceAll;
Date.prototype.format=format;


