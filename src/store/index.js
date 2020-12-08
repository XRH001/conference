import Vue from 'vue'
import Vuex from 'vuex'
//安装
Vue.use(Vuex);
//创建store
const store= new Vuex.Store({
    state:{
        haveLogin:false,
        url:"http://localhost:8080/mine/",
        user:{},
        meetings:{}
        /*userId:"3213",
        username:"混元",
        headImg:"assets/headImg.jpg",
        userEmail:"2569277820@qq.com"*/
    },
    mutations:{
        //退出登录
        exitCount(state){
            state.user={};
            state.haveLogin=false;
        },
        //刚刚登录
        setUser(state,user){
            state.user=user;
        },
        setMeetings(state,meetings){
            state.meetings=meetings;
        }
    },actions:{
        login(){

        }
    },
    getters:{
        headPath(state){
            return state.url+state.user.headImg;
        }
    }


});

export default store;