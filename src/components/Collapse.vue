<template>
    <div class="layui-collapse">
        <div  class="layui-colla-item"  >
            <h2 class="layui-colla-title" @click="show=!show">
                <span v-if="show" class="layui-icon layui-icon-down"></span>
                <span v-else class="layui-icon layui-icon-right"></span>
                <slot name="title"></slot>
                <span class="rightMsg">{{rightMsg}}</span>
            </h2>
            <div class="layui-colla-content " :class="{'layui-show':show}">
                <slot name="content"></slot></div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Collapse",
        data(){
            return {
                show:false
            }
        },props:{
            rightMsg:String
        }
    }
</script>

<style scoped>
    .layui-colla-title {
        font-size: 18px ;
        font-family: '微软雅黑 Light';
        padding-left: -10px;
    }
    .rightMsg {
        float:right;
        color: #249312;
        display: block;
    }
</style>