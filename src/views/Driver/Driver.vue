<template>
    <div class="layui-tab layui-tab-card">
        <ul class="layui-tab-title layui-row">
            <li class=" layui-col-lg4 layui-col-md4" :class="{'layui-this':layShow===0}" @click="layShow=0">待接送</li>
            <li class="layui-col-lg4 layui-col-md4" :class="{'layui-this':layShow===1}" @click="layShow=1">预约消息</li>
            <li class="layui-col-lg4 layui-col-md4" :class="{'layui-this':layShow===2}" @click="layShow=2">已接送</li>
<!--            <li class="layui-col-lg3" :class="{'layui-this':layShow===3}" @click="layShow=3">司机信息</li>-->
        </ul>
        <div class="layui-tab-content" >
            <div  :class="{'layui-show':layShow===0}" class="layui-tab-item">
                <Wait></Wait>
            </div>

            <div :class="{'layui-show':layShow===1}" class="layui-tab-item">
                <Need></Need>
            </div>
            <div :class="{'layui-show':layShow===2}" class="layui-tab-item">
                <Already></Already>
            </div>

        </div>
    </div>
</template>

<script>
    import Wait from "./Wait";
    import Already from "./Already";
    import Need from "./Need";

    export default {
        name: "Driver",
        components: { Need, Already, Wait},
        data(){
            return{
                layShow:0
            }
        },
        created() {
            /*this.$http("",{
                params:{
                    email:this.$store.state.user.email
                }
            }).then(res => {
                /!*res.data.driver*!/
            })*/
        }
    }
</script>

<style scoped>


</style>