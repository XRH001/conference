<template>
    <div >
        <ul class="layui-nav layui-row ">
        <span>
        <li class="layui-nav-item "><router-link to="/index" :active-class="thisActive" >首页</router-link></li>
<!--        <li class="layui-nav-item  "><router-link to="/search" :active-class="thisActive">查询{{$store.state.onTime}}</router-link></li>&lt;!&ndash;{{$store.state.user.userId}}&ndash;&gt;-->
        <li class="layui-nav-item floatRight"><router-link to="/About" :active-class="thisActive">关于</router-link></li>
          </span>

            <span v-if="$store.state.haveLogin">
        <li class="layui-nav-item floatRight">
            <a href="javascript:void(0)" :active-class="thisActive"  @click="messageShow=true" >
                我的消息<el-badge :value="messageNum" v-show="messageNum!==0" class="item"></el-badge></a></li>
        <li class="layui-nav-item floatRight">
          <router-link to="/personalInfo" :active-class="thisActive">
            <img :src="$store.getters.headPath" class="smallHead" @error="notFindImg()"><!--$store.getters.headPath-->
            <span>{{$store.getters.getName}}</span>
          </router-link></li>
          </span>

            <span v-else>
          <li class="layui-nav-item floatRight"><router-link to="/login" :active-class="thisActive">登录</router-link></li>
          <li class="layui-nav-item floatRight"><router-link to="/Register" :active-class="thisActive">注册</router-link></li>
        </span>
        </ul>

        <keep-alive exclude="index,detail,Manage,create,login,Register,DriverLogin,HotelLogin,personalInfo"><router-view></router-view></keep-alive>
        <el-drawer
                   :visible.sync="messageShow"
                   direction="rtl" size="30%" :show-close="false"
                   >
            <p slot="title" class="msgTitle">消息列表</p>
            <Message v-if="$store.state.identity.toLowerCase()==='common'" :meeting-msg="messageList" @removeMsg="removeMsg"></Message>
            <HotelMessage v-if="$store.state.identity.toLowerCase()==='hotel'" ></HotelMessage>
            <DriverMessage v-if="$store.state.identity.toLowerCase()==='driver'" ></DriverMessage>
        </el-drawer>
    </div>
</template>

<script>
    import Message from "../views/Message";
    import HotelMessage from "../views/Hotel/HotelMessage";
    import DriverMessage from "../views/Driver/DriverMessage";
    export default {
        name: "NavBar",
        components: {DriverMessage, HotelMessage, Message},
        data(){
            return {
                show:true,
                thisActive:'underLine',
                headError:require('assets/defaultHead.png'),
                messageShow:false,
                messageList:[/*{id:21,name:"可真难受",message:"邀请你成为管理员"},{id:1,name:"可真难受",message:"邀请你加入会议"},
                    {id:1,name:"可真难受",message:"邀请你成为管理员"},{id:245231,name:"可真难受",message:"邀请你加入会议"},
                    {id:2,name:"可真难受",message:"邀请你成为管理员"},{id:223671,name:"可真难受",message:"邀请你加入会议"},
                    {id:32,name:"可真难受",message:"邀请你成为管理员"},{id:227831,name:"可真难受",message:"邀请你加入会议"}*/]
            }
        },
        methods:{
            notFindImg(){
                this.$notFind(this.headError);
            },
            searchMsg(){
                //查询新信息
                let meetingIdList=[];
                for(let meetingMsg of this.messageList){
                    meetingIdList.push(meetingMsg.id)
                }
                /*this.$http( "mainServlet?ac=need&apiName=searchMsg3123",*/
                this.$post(this.$url.searchMsg,{
                        userId:this.$store.state.user.id,
                        meetingIdList
                    }
                ).then(res => {
                    let data=res.data;
                    if(data.msg==="success"){
                        let newMsg = data.newMsg;
                        if(newMsg.length>0){
                            this.messageList.push.apply(this.messageList,newMsg);
                            const h = this.$createElement;
                            this.$notify({
                                title: '新消息提醒',
                                message: h('i', { style: 'color: teal'}, '新增了 '+newMsg.length.toString()+'条消息'),
                                offset: 60
                            });
                        }
                    else{
                        console.log("查询新消息失败");
                        }
                    }
                }).catch(err => {
                    console.log(err);
                });
            },
            removeMsg(meetingId){
                this.removeByKey(this.messageList,'id',meetingId);
            },
            removeByKey(list,key,value){
                for(let inx in list){
                    if(list[inx][key]===value)list.splice(inx,1);
                }
            }
        },
        computed:{
            messageNum(){
                return this.messageList.length;
            }
        },
        created() {
            setInterval(()=>{
                if(this.$store.state.haveLogin && this.$store.state.identity.toLowerCase()==="common"){
                    this.searchMsg();
                }
            },60000);
        }
    }
</script>

<style scoped>
    .underLine{
        border-bottom: 5px solid orange;
    }
    /*.item{
        margin-top: 5px;
    }*/
    .smallHead{
        width: 50px;
        height: 50px;
        border-radius: 50%;
    }
    .floatRight{
        float: right;}
    .msgTitle{
        color: #aab7c5;
        font-size: 20px;
        margin: 2px;
    }
</style>