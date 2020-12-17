<template>
    <div class="hotelContainer">
        <div class="layui-tab layui-tab-card">
            <ul class="layui-tab-title layui-row">
                <li class=" layui-col-lg4"  :class="{'layui-this':layShow===0}" @click="layShow=0">预约消息</li>
                <li class="layui-col-lg4" :class="{'layui-this':layShow===1}" @click="layShow=1">已接受</li>
                <li class="layui-col-lg4" :class="{'layui-this':layShow===2}" @click="layShow=2">已完成的订单</li>
            </ul>
            <div class="layui-tab-content" >
                <div :class="{'layui-show':layShow===0}" class="layui-tab-item ">
                    <Reserve></Reserve>
                </div>
                <div :class="{'layui-show':layShow===1}" class="layui-tab-item ">
                    <Accept></Accept>
                </div>
                <div :class="{'layui-show':layShow===2}" class="layui-tab-item ">
                    <Completed></Completed>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import Reserve from "./Reserve";
    import Accept from "./Accept";
    import Completed from "./Completed";
    export default {
        name: "Hotel",
        components: {Completed, Accept, Reserve},
        data(){
            return{
                layShow:0
            }
        },
    }
</script>

<style scoped>
    .layui-tab{
        width: 95%;
        margin: auto;
    }


</style>