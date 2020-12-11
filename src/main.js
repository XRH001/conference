import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from "./store"
import {request} from "./network/request"

require("layui-src/dist/css/layui.css");

Vue.config.productionTip = false;
new Vue({
  router,store,
  render: h => h(App)
}).$mount('#app');
Vue.prototype.$request=request;
request({
  url:"swipeServlet?action=getImgPathJson"}
).then(res =>{
  console.log(res);
}).catch(err =>{
  console.log(err);
});

