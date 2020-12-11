import Vue from 'vue'
import Vuex from 'vuex'

/*import SETUSER from "../store/mutations-types"
import SETMEETINGS from "../store/mutations-types"*/
//安装
Vue.use(Vuex);

//模块
const moduleA={
    state:{},
    mutations:{},
    actions:{},
    getters:{}
};
//创建store
const store= new Vuex.Store({
    state:{
        haveLogin:false,
        url:"http://localhost:8080/mine/",
        user:{},
        meetings:{
            join:{
                newMeetings:[],
                overMeetings:[],
                applyMeetings:[]
            },
            manage:{
                newMeetings:[],
                overMeetings:[]
            }
        },
        onTime:0
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
        },
        incOnTime(state){
            state.onTime++;
        }
    },
    actions:{
        computeTime(context){
            setInterval( ()=> {
                context.commit("incOnTime");
            },1000);
        }
    },
    getters:{
        headPath(state){
            return state.url+state.user.headImg;
        }
    },
    modules:{
        aMod:moduleA
    }

});

export default store;