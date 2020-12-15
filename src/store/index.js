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
        url:"",//在App中赋值
        user:{name:"",
            username:"",
            sex:"",
            birth:"",
            identity:"",
            email:"",
            imgPath:"",
            phone:"",
            id:""
        },
        meetings:{
            join:{
                newMeetings:[],
                overMeetings:[],
                applyMeetings:[]
            },
            manage:{
                newMeetings:[],
                overMeetings:[]
            },
            creator:[]
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
            //登录状态改为true
            state.haveLogin=true;
        },
        setMeetings(state,meetings){
            state.meetings=meetings;
        },
        incOnTime(state){
            state.onTime++;
        },
        setURL(state,url){
            state.url=url;
        },
        addCreateMeetings(state,newMeeting){
            //{
            //                 id:newMeeting.id,
            //                 name:newMeeting.name,
            //                 address:newMeeting.position,
            //                 beginTime:newMeeting.beginTime,
            //                 orderStatus:newMeeting.orderStatus
            //             }
            state.meetings.manage.newMeetings.push(newMeeting);
            console.log(state.meetings.manage.newMeetings);
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
        headPath(state){//记得加上baseURL
            return state.url+state.user.imgPath;
        }
    },
    modules:{
        aMod:moduleA
    }

});

export default store;