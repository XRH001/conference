import Vue from 'vue'
import Vuex from 'vuex'
import {driver} from './driver'
import {hotel} from './hotel'

/*import SETUSER from "../store/mutations-types"
import SETMEETINGS from "../store/mutations-types"*/
//安装
Vue.use(Vuex);


//创建store
const store= new Vuex.Store({
    state:{
        haveLogin:false,
        url:"",//在App中赋值
        identity:"common",
        user:{name:"",
            username:"",
            sex:"",
            birth:"",
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
                overMeetings:[/*{id:"21",name:'样例会议',orderStatus:"5小时后开始",beginTime:"2020年12月6日12:36",address:"信工楼b区"},
                    {id:"32",name:'样例会议',orderStatus:"5小时后开始",beginTime:"2020年12月6日12:36",address:"信工楼b区"}*/]
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
            state.meetings={
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
            };
            state.hotel={
                hotel:{id:23,
                    name:"我是酒店名",
                    phone:"",
                    address:"",
                    username:"",
                    email:"",
                    imgPath:"wad"
                    }   ,
                meetings:{
                    accepted:[],
                    reserve:[],
                    completed:[]
                }};
            state.driver={
                driver:{},
                meetings:{
                    accepted:[],
                    already:[],
                    need:[]
                }};
            state.haveLogin=false;
        },
        //刚刚登录
        setUser(state,user){
            state.user=user;
            //登录状态改为true
            state.haveLogin=true;
        },setLogin(state){
            state.haveLogin=true;
        },
        setMeetings(state,meetings){
            state.meetings=meetings;
        },
        setCreator(state,creator){
            state.meetings.creator=creator;
            for(let create of state.meetings.creator)
                state.meetings.manage.newMeetings.push(create);
        },
        incOnTime(state){
            state.onTime++;
        },
        setURL(state,url){
            state.url=url;
        },
        addCreateMeetings(state,newMeeting){
            state.meetings.manage.newMeetings.push(newMeeting);
            console.log(state.meetings.manage.newMeetings);
        },
        setIdentity(state,identity){
            state.identity=identity;
        },
        updateUser(state,update){
            /*name:"",
                    phone:"",
                    sex:"male",
                    username:"",
                    birthday:""*/
            state.user.name=update.name;
            state.user.phone=update.phone;
            state.user.sex=update.sex;
            state.user.username=update.username;
            state.user.birth=update.birthday;
        },
        addNewMeeting(state,data){
            let meeting=data.meeting;
            let ifManager=data.ifManager;
            //console.log(data);
            if(ifManager)state.meetings.manage.newMeetings.push(meeting);
            else state.meetings.join.newMeetings.push(meeting);
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
            let headPath;
            if(state.identity.toLowerCase()==="driver")headPath=state.url+state.driver.driver.imgPath;
            else if(state.identity.toLowerCase()==="hotel")headPath=state.url+state.hotel.hotel.imgPath;
            else headPath=state.url+state.user.imgPath;
            return headPath;
        },
        getName(state){
            let name;
            if(state.identity.toLowerCase()==="driver")name=state.driver.driver.name;
            else if(state.identity.toLowerCase()==="hotel")name=state.hotel.hotel.name;
            else name=state.user.name;
            return name;
        }
    },
    modules:{
        driver:driver,
        hotel:hotel
    }

});

export default store;