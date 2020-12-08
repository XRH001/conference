<template>
    <div class="swipeContainer">
        <div :class="{'eachSwipe':nowShow!==0}" style="background-color: #ecffe4"><div class="swipe layui-icon layui-icon-templeate-1 ">欢迎使用易渠会议</div></div>
        <div :class="{'eachSwipe':nowShow!==1}" style="background-color: #ffeae8"><div class="swipe layui-icon layui-icon-tabs">支持所有人创建会议</div></div>
        <div :class="{'eachSwipe':nowShow!==2}" style="background-color: #f8e8ff"><div class="swipe layui-icon layui-icon-app">会议后勤功能完善</div></div>
        <div :class="{'eachSwipe':nowShow!==3}" style="background-color: #abf2ff"><div class="swipe layui-icon layui-icon-slider">操作简单快捷</div></div>
    </div>
</template>

<script>
    export default {
        name:"swiper",
        data(){
            return {
                nowShow:0
            }
        },props:{
            second:{
                type:Number,
                default:3000
            }
        },
        created() {
            setInterval(() =>{
                this.nowShow=++this.nowShow%4;
            },this.second)
        }
    }
</script>

<style scoped>
    .swipe{
        font-size: 50px;
        color: #2E2D3C;
        margin: auto;
        text-align: center;
        font-family: '楷体';
    }
    .swipeContainer{
        overflow: hidden;
        margin: 0;
    }
    .eachSwipe{
        display: none;
    }
</style>