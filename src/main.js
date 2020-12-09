import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from "./store"
import axios from "axios"


require("layui-src/dist/css/layui.css");

Vue.config.productionTip = false;
new Vue({
  router,store,
  render: h => h(App)
}).$mount('#app');
Vue.prototype.$http = axios;

/*.create({
  baseURL:"http://localhost:8080/mine/",
  timeout:5000
});*/


