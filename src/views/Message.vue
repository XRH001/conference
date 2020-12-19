<template>
    <div class="messageContent">

        <div class="oneMessage" v-for="meetingItem in meetingMsg" :key="meetingItem.id">
            <p class="title">会议邀请</p>
            <hr class="borderLine">
            <div class="content">
                <p>会议:{{meetingItem.name}} --{{meetingItem.message}}</p>
                <router-link :to="{path:'detail',query:{meetingId:meetingItem.id}}" >会议详情<i class="el-icon-view el-icon--right"></i></router-link>
                <br><br>
                <el-button size="small" type="success">同意</el-button>
                <el-button size="small" type="danger">拒绝</el-button>
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