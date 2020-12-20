<template>
    <div class="container">
        <div id="joinDiv" class="layui-col-lg6 layui-col-xs11">
            <span  class="divTitle layui-icon layui-icon-form">参与会议</span>
            <hr class="layui-bg-green">
            <div class="layui-tab layui-tab-brief">
                <ul class="layui-tab-title">
                    <li  :class="{'layui-this':joinDiv.show===1}" @click="joinDiv.show=1">未结束</li>
                    <li  :class="{'layui-this':joinDiv.show===2}" @click="joinDiv.show=2">已结束</li>
                    <li  :class="{'layui-this':joinDiv.show===3}" @click="joinDiv.show=3">查找</li>
                    <li  :class="{'layui-this':joinDiv.show===4}" @click="joinDiv.show=4">申请中</li>
                </ul>
                <div class="layui-tab-content">
                    <div :class="{'layui-show':joinDiv.show===1}" class="layui-tab-item " >
                        <p class="emptyWarming" v-if="joinDiv.newMeetings.length===0">您的未结束会议为空，可立即
                            <a href="javascript:void(0)"><i @click="joinDiv.show=3">查找新的会议</i></a>加入哦</p>
                        <meeting-list :meetings="joinDiv.newMeetings"></meeting-list>
                    </div>
                    <div :class="{'layui-show':joinDiv.show===2}" class="layui-tab-item">
                        <p class="emptyWarming" v-if="joinDiv.overMeetings.length===0">您的已结束会议为空，可立即
                            <a href="javascript:void(0)"><i @click="joinDiv.show=3">查找新的会议</i></a>加入哦</p>
                        <meeting-list :meetings="joinDiv.overMeetings"></meeting-list>
                    </div>
                    <div :class="{'layui-show':joinDiv.show===3}" class="layui-tab-item layui-row">
                        <div class="searchInputDiv layui-col-lg11 layui-col-md11 layui-col-xs10">
                            <input v-model.lazy="joinDiv.search" class="layui-input" type="text" placeholder="输入会议id或名称进行查找" value="废物">
                        </div>
                        <div class="searchButtonDiv layui-col-lg1 layui-col-md1 layui-col-xs2">
                            <button @click="searchClick" class="searchButton layui-btn layui-btn-primary"><span class="layui-icon layui-icon-search"></span></button>
                        </div><br><br><br>
                        <p class="emptyWarming" v-if="joinDiv.searchMeetings.length===0">未查找到。。。</p>
                        <meeting-list :meetings="joinDiv.searchMeetings"></meeting-list>
                    </div>
                    <div :class="{'layui-show':joinDiv.show===4}" class="layui-tab-item">
                        <p class="emptyWarming" v-if="joinDiv.applyMeetings.length===0">您所申请的会议为空，可立即
                            <a href="javascript:void(0)"><i @click="joinDiv.show=3">查找新的会议</i></a>加入哦</p>
                        <meeting-list :meetings="joinDiv.applyMeetings"></meeting-list>
                    </div>
                </div>
            </div>
        </div>
        <div id="managerDiv" class="layui-col-lg5 layui-col-xs11">
            <span  class="divTitle layui-icon layui-icon-chart-screen">管理会议</span>
            <hr class="layui-bg-orange">
            <div class="layui-tab layui-tab-brief">
                <ul class="layui-tab-title">
                    <li :class="{'layui-this':managerDiv.show===1}" @click="managerDiv.show=1">未结束</li>
                    <li :class="{'layui-this':managerDiv.show===2}" @click="managerDiv.show=2">已结束</li>
                    <li :class="{'layui-this':managerDiv.show===3}" @click="managerDiv.show=3">创建</li>
                </ul>
                <div class="layui-tab-content">
                    <div :class="{'layui-show':managerDiv.show===1}" class="layui-tab-item">
                        <p class="emptyWarming" v-if="managerDiv.newMeetings.length===0">您的所管理的未结束会议为空，可立即
                            <a href="javascript:void(0)"><i @click="managerDiv.show=3">创建新的会议</i></a></p>
                        <meeting-list :meetings="managerDiv.newMeetings" router-to="/manage"></meeting-list>
                    </div>
                    <div :class="{'layui-show':managerDiv.show===2}" class="layui-tab-item">
                        <p class="emptyWarming" v-if="managerDiv.overMeetings.length===0">您的所管理的已结束会议为空，可立即
                            <a href="javascript:void(0)"><i @click="managerDiv.show=3">创建新的会议</i></a></p>
                        <meeting-list :meetings="managerDiv.overMeetings" router-to="/manage"></meeting-list>
                    </div>
                    <div :class="{'layui-show':managerDiv.show===3}" class="layui-tab-item ">
                        <div class="managerButtonBox">
                            <router-link to="/create" id="createMeetingButton" >
                                <span class="iconfont icon-hexagon  buttonBack"></span>
                                <div class="sixBorder layui-icon layui-icon-add-circle-fine">创建</div></router-link>
                        </div>
                        <div class="managerButtonBox">
                            <a @click="restart()" id="restartMeetingButton">
                                <span class="buttonBack layui-icon layui-icon-circle-dot"></span>
                                <div class="sixBorder layui-icon layui-icon-add-circle-fine">重启</div></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <Popup ref="popup1"></Popup>
    </div>
</template>

<script>
    import MeetingList from "components/meetingList";
    import Popup from "../../components/Popup";
    const meetingList = ()=> import("components/meetingList");
    export default {
        name: "Ordinary",
        components: {Popup, MeetingList},
        comments:{
            meetingList
        },
        data(){
            return{
                joinDiv:{
                    newMeetings:[
                    ],
                    overMeetings:[
                    ],
                    searchMeetings:[
                        {id:"233",name:'样例会议',orderStatus:"5小时后开始",beginTime:"2020年12月6日12:36",address:"信工楼b区"},
                        {id:"234",name:'仅供参考',orderStatus:"5小时后开始",beginTime:"2020年12月6日12:36",address:"信工楼b区"},
                        {id:"235",name:'没事别点',orderStatus:"5小时后开始",beginTime:"2020年12月6日12:36",address:"信工楼b区"}
                    ],
                    applyMeetings:[
                    ],search:"",
                    show:1
                },
                managerDiv:{
                    newMeetings:[],
                    overMeetings:[],
                    creator:[],
                    show:1
                }
            }
        },
        methods:{
            restart(){
                alert("这个时候可以选择曾经创建的会议填充到下个页面");
                this.$router.push("/create");
            },
            setJoinMeetings(){
                let join=this.$store.state.meetings.join;
                //console.log(this.joinDiv);
                this.joinDiv.newMeetings=join.newMeetings;
                this.joinDiv.overMeetings=join.overMeetings;
                this.joinDiv.applyMeetings=join.applyMeetings;
            },
            setManageMeetings(){
                let manage=this.$store.state.meetings.manage;
                this.managerDiv.newMeetings=manage.newMeetings;
                // this.managerDiv.newMeetings=[ {id:"2369",name:'样例会议',orderStatus:"5小时后开始",beginTime:"2020年12月6日12:36",address:"信工楼b区"}];
                this.managerDiv.overMeetings=manage.overMeetings;
            },
            searchClick(){
                /*this.$http("mainServlet?ac=need&apiName=searchMeetings")*/
                if(this.joinDiv.search==="")return;
                this.$request(this.$url.searchMeetings,{
                        params:{
                            search:this.joinDiv.search
                    }
                }).then(
                    res =>{
                        let resp=res.data;
                        console.log(resp);
                        if(resp.msg==="success")
                            this.joinDiv.searchMeetings=resp.searchMeetings;
                        else if(resp.msg==="empty")this.joinDiv.searchMeetings=[];
                        else this.$refs.popup1.showMsg("查询失败");
                    }
                ).catch(err =>{
                    console.log(err);
                    this.$refs.popup1.showMsg("查询异常");
                });
            }
        },
        created() {
            if(this.$store.state.meetings){
                this.setJoinMeetings();
                this.setManageMeetings();
                if(this.$store.state.meetings.join.newMeetings.length===0)this.joinDiv.show=3;
                if(this.$store.state.meetings.manage.newMeetings.length===0)this.managerDiv.show=3;
            }
            setInterval(()=>{
                if(this.$store.state.meetings){
                    this.setJoinMeetings();
                    this.setManageMeetings();
                    console.log("更新一次");
            }},5000);


        }
    }

</script>

<style >

    #joinDiv,#managerDiv{
        border-radius: 10px;
        padding: 15px;
        margin: 15px;
        border: 2px #4E5465 solid;
    }
    /*#joinDiv{
        background-color: #f7f3ff;
    }
    #managerDiv{
        background-color: #ebfffa;
    }*/
    .divTitle{
        font-size: 30px !important;
        color: #393D49;
    }
    .layui-elem-field{
        border-radius: 5px;
    }

    .searchButtonDiv{
        width: 19%;
    }
    .searchInputDiv{
        width: 79%;
    }
    #searchResultTable{
        text-align: center;
    }
    .layui-table th{
        text-align: center !important;
    }
    li{
        font-size: 15px !important;
        font-family: 微软雅黑;
    }

    .emptyWarming{
        width: 100%;
        font-size: 20px;
        color: #464955;
    }
    .emptyWarming >a> i{
        color: #007ddb;
    }




</style>