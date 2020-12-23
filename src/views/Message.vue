<template>
    <div class="messageContent">

        <div class="oneMessage" v-for="meetingItem in meetingMsg" :key="meetingItem.id">
            <p class="title">会议邀请</p>
            <hr class="borderLine">
            <div class="content">
                <p>会议:{{meetingItem.name}} --{{meetingItem.message}}</p>
                <router-link :to="{path:'detail',query:{meetingId:meetingItem.id}}" >会议详情<i class="el-icon-view el-icon--right"></i></router-link>
                <br><br>
                <el-button size="small" type="success" @click="acceptClick(meetingItem.id)">同意</el-button>
                <el-popconfirm title="拒绝后将无法看到此会议，确认拒绝？" @confirm="rejectClick(meetingItem.id)">
                    <el-button slot="reference" size="small" type="danger" >拒绝</el-button>
                </el-popconfirm>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Message",
        data(){
            return {
            }
        },
        props:{
            meetingMsg:Array
        },
        methods:{
            acceptClick(meetingId){
                /*this.$http("mainServlet?ac=need&apiName=acceptInvite2"*/
                this.$post(this.$url.acceptInvite,{
                        meetingId,
                        memberId:this.$store.state.user.id
                }).then(res => {
                    let data=res.data;
                    //console.log(data);
                    if(data.msg==="fail"){
                        this.$message("请求失败，对方可能已取消邀请");
                        return ;
                    }
                    if(data.msg==="success"){
                        //将会议添加到主页
                        console.log(data);
                        this.$store.commit("addNewMeeting",{meeting:data.newMeeting,ifManager:data.ifManager});
                        this.$message("同意成功，已加入会议");
                        this.$emit("removeMsg",meetingId);
                    }
                    else this.$message("发生错误，对方可能已取消邀请")
                }).catch(err =>{
                    console.log(err);
                    this.$message("网络请求异常");
                });
            },
            rejectClick(meetingId){
                /*this.$http("mainServlet?ac=need&apiName=returnSuccess"*/
                this.$request(this.$url.deleteMember,{
                    params:{
                        meetingId,
                        memberId:this.$store.state.user.id
                    }
            }).then(res => {
                    if(res.data==="success"){this.$emit("removeMsg",meetingId);this.$message("已拒绝");}
                    else if(res.data==="fail")this.$message("拒绝失败，对方可能已取消邀请");
                    else this.$message("服务器错误");
                }).catch(err =>{
                    console.log(err);
                    this.$message("网络请求异常");
                });
            }
    }
    }
</script>

<style scoped>
    .oneMessage{
        background-color: #daf5ff;
        margin: 20px;
        padding: 10px;
        border-radius: 5px;
    }
    .title{
        color: #35a2a4;
        font-size: 19px;
    }
    .content{
        color: #aa8773;
        font-size: 17px;
    }
    .messageContent{
        max-height: calc(90vh);
        overflow-y: scroll;
    }
</style>