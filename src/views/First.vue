<template>
    <div class="firstBack">
        <div class="align-center bigTile">
            <el-popover
                    placement="top-start"
                    title="点击进入登录界面"
                    width="200"
                    trigger="hover"
                    >
            <router-link to="/login" slot="reference" class="centerP">浑元形意 会务管理</router-link>
            </el-popover>
        </div>

        <div class="iconTitle">界面简洁</div>
        <div class="iconTitle">功能齐全</div>
        <div class="iconTitle">平台司机</div>
        <div class="iconTitle">预约酒店</div>
        <div class="iconContent">
            <div class="ButtonBox">

                <a href="javascript:void(0)" @click="show=0">
                    <span class="iconfont icon-table  iconBack back1"> </span>
                    </a>
            </div>
            <div class="ButtonBox">

                <a href="javascript:void(0)" @click="show=1">
                    <span class="iconfont icon-ziyuan173  iconBack back2"> </span>
                    </a>
            </div>
            <div class="ButtonBox">

                <a href="javascript:void(0)" @click="show=2">
                    <span class="iconfont icon-car carIcon iconBack back3"> </span>
                    </a>
            </div>
            <div class="ButtonBox">
                <a href="javascript:void(0)" @click="show=3">
                    <span class="iconfont icon-hotel  iconBack back4"> </span>
                    </a>
            </div>
        </div>
        <div class="align-center">
        <el-popover
                placement="top-start"
                title="点击进入注册页面"
                width="200"
                trigger="hover">
        <el-button class="centerButton" @click="toRegister">立即体验</el-button>
        </el-popover></div>
        <div class="powerContent">
            <div v-show="show===0">
                <meeting-list :meetings="meetings" :router-to="'/Register'" :show-all="true"></meeting-list>
            </div>
            <div v-show="show===1">
                <div>
                    <div class="smallInfo"><RelateToMe :meeting-user="meetingUser"></RelateToMe></div>
                    <div class="smallInfo"><SmallInfo  :person-info="personInfo"></SmallInfo></div>
                    <div class="smallInfo"><ArrangeOne></ArrangeOne></div>
                    <div class="smallInfo"><ReserveDriverForm></ReserveDriverForm></div>
                    <hr class="clearFloat">
                </div>
            </div>
            <div v-show="show===2">
                <ReserveDriver></ReserveDriver>
            </div>
            <div v-show="show===3">
                <ReserveHotel></ReserveHotel>
            </div>
        </div>




    </div>
</template>

<script>
    //初始界面，未登录时的宣传界面，要做的花里胡哨
    import MeetingList from "../components/meetingList";
    import ReserveDriver from "./Ordinary/ReserveDriver";
    import ReserveHotel from "./Ordinary/ReserveHotel";
    import RelateToMe from "./Ordinary/RelateToMe";
    import SmallInfo from "../components/SmallInfo";
    import ArrangeOne from "./Ordinary/ArrangeOne";
    import ReserveDriverForm from "../components/reserveDriverForm";
    export default {
        name: "First",
        components: {ReserveDriverForm, ArrangeOne, SmallInfo, RelateToMe, ReserveHotel, ReserveDriver, MeetingList},
        data(){
            return{
                show:1,
                meetings:[{id:"233",name:'样例会议',orderStatus:"5小时后开始",beginTime:"2020年12月6日12:36",address:"信工楼b区"},
                    {id:"234",name:'仅供参考',orderStatus:"5小时后开始",beginTime:"2020年12月6日12:36",address:"信工楼b区"},
                    {id:"235",name:'没事别点',orderStatus:"5小时后开始",beginTime:"2020年12月6日12:36",address:"信工楼b区"}
                ],
                meetingUser:{

                    ifJoin:true,
                    info:"",
                    journey:{
                        time:"2020年12月17日19:11",
                        origin:"床上",
                        target:"凳子上"
                    },
                    room:{
                    }
                },
                personInfo:{
                    headPath:"../assets/defaultHead.png",
                    username:"杨莉",
                    email:"111111111111@ew.qwe",
                    sex:"男",
                    id:"0000",
                    phone:"1111111111111",
                    name:"样例",
                    birth:"2000/08/05"
                },
            }
        },
        methods:{
            toRegister(){
                this.$router.push("/Register");
            }
        },
        /*created() {
            let baseURL = this.$url.baseURL;
            this.$store.commit("setURL",baseURL);
            var add=0.1;
            setInterval(() =>{
                if(this.topSet<-1000)add=-0.1;
                if(this.topSet>0)add=0.1;
                this.topSet-=add;
                },20)
        }*/
    }
</script>

<style scoped>

    .backgroundImg{height: 450px;overflow: hidden;background-color:white}
    .backgroundImg>img{

        width: 100%;
        opacity: 80%;
    }
    .iconContent{
        width: 100%;
        padding: 0;
        height: 300px;
        background:white;/*linear-gradient(to bottom, white,#7B7B7B);*/
    }
    .firstBack{
        background-color:#7B7B7B;
    }
    .ButtonBox{
        width: 25%;
        margin: 0;
        color: #1e9fff;
        text-align: center;
        float: left;
    }
    .back1{color: #249312 !important;}
    .back2{color: #82a0b7 !important;}
    .back3{color: #00343f !important;}
    .back4{color: #a8c36c !important;}
    .iconBack:hover{color: #c8c7d6 !important;}
    .iconTitle{
        font-size: 30px;
        color: #343235;
        background-color: #f3f3f3;
        width: 25%;
        float: left;
        text-align: center;
    }
    .centerButton{
        width: 200px;
        height: 80px;
        border: 2px solid #86a882;

        border-radius: 10px;
        background-color: transparent;
        font-size: 30px;
        opacity: 70%;
    }
    .centerButton:hover{
        background:linear-gradient(to bottom, #afd3b9, #e4faff);
    }
    .centerP{
        /*position: absolute;
        top:16%;
        left: 30%;*/
        text-align: center;
        font-size: 80px;
        color: #656069;
        font-family: 华文行楷;

        /*border-radius: 20px;*/
    }
    .bigTile{
        background-color: white;
        width: 100%;
    }
    .powerContent{
        background-color: white;
        width: 100%;

    }
    .powerContent> div{
        border: #2E2D3C solid 2px;
        border-radius: 5px;
        width: 80%;
        margin: auto;
        padding: 30px;
    }
    .clearFloat{
        clear: both;
    }
    .smallInfo{
        width: 400px;
        float: left;
        border: 1px solid #4e5465;
        border-radius: 2px;
        margin: 10px;
        padding: 10px;
    }
</style>