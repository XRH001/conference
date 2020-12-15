<template>
    <div class="swipeContainer">
        <div :class="{'eachSwipe':nowShow!==0}" style="background-color: #ecffe4">
            <slot name="t1"> <div class="swipe layui-icon layui-icon-templeate-1 ">欢迎使用浑元形意会务管理</div></slot></div>
        <div :class="{'eachSwipe':nowShow!==1}" style="background-color: #ffeae8">
            <slot name="t2"> <div class="swipe layui-icon layui-icon-tabs">支持所有人创建会议</div></slot></div>
        <div :class="{'eachSwipe':nowShow!==2}" style="background-color: #f8e8ff">
            <slot name="t3"> <div class="swipe layui-icon layui-icon-app">会议后勤功能完善</div></slot></div>
        <div :class="{'eachSwipe':nowShow!==3}" style="background-color: #abf2ff">
            <slot name="t4"> <div class="swipe layui-icon layui-icon-slider">操作简单快捷</div></slot></div>
    </div>
</template>

<script>
    export default {
        name:"Swiper",
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