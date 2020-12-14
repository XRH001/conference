import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from "./store"
//import axios from 'axios'
import {request} from "./network/request";

require("layui-src/dist/css/layui.css");

Vue.config.productionTip = false;
new Vue({
  router,store,
  render: h => h(App)
}).$mount('#app');

Vue.prototype.$request=request;
Vue.prototype.$decrypt=function (code) {
  let str = "";
  for(let i=0;i<code.length/2;i++){
    str += String.fromCharCode(parseInt(code[i*2]+code[i*2+1], 16));
  }
  console.log(str);
  return str;

};
String.prototype.replaceAll = function(s1, s2) {
  return this.replace(new RegExp(s1, "gm"), s2);
};
/*request({
  url:"swipeServlet?action=getImgPathJson"}
).then(res =>{
  console.log(res);
}).catch(err =>{
  console.log(err);
});*/

