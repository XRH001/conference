<template>
    <div class="layui-collapse">
        <div class="layui-colla-item" v-for="(meetingItem,inx) in meetings" :key="meetingItem.id" >
            <h2 class="layui-colla-title" @click="show.splice(inx,1,!show[inx])">
                <span v-if="show[inx]" class="layui-icon layui-icon-down"></span>
                <span v-else class="layui-icon layui-icon-right"></span>
                {{meetingItem.name}}
                <span class="meetingState">{{meetingItem.state}}</span></h2>
            <div class="layui-colla-content " :class="{'layui-show':show[inx]}"><!--layui-show-->
                    <router-link class="layui-btn detailButton" :to="{path:routerTo,query:{meetingId:meetingItem.id}}">
                        <i class="layui-icon layui-icon-align-left"> </i>详细信息</router-link>
                <br><br>
                <fieldset class="layui-elem-field ">
                    <legend>会议开始时间</legend>
                    <div class="layui-field-box">
                        {{meetingItem.startTime}}
                    </div>
                </fieldset>
                <fieldset class="layui-elem-field">
                    <legend>会议地点</legend>
                    <div class="layui-field-box">
                        {{meetingItem.position}}
                    </div>
                </fieldset>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "meetingList",
        props:{
            meetings:Array,
            routerTo:{
                type:String,
                default:"/detail"
            }
        },
        data(){
            return {
                show:[]

            }
        },created() {

            if(this.meetings)
            {
                let length = this.meetings.length;
                for(let inx; inx< length; inx++){
                                this.show.push(false);
                            }
            }
        }
    }
</script>

<style scoped>
    .layui-colla-title{
        font-size: 17px !important;
        font-family: '微软雅黑 Light';
        padding-left: 10px;

    }
    .layui-field-box{
        text-align: center;
        font-size: 20px;
        font-family: '楷体';
        color: #595B5D;
    }
    .meetingState{
        float:right;
        color: #249312;
    }
</style>