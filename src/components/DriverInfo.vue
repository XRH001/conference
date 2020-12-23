<template>
    <table class="layui-table">
        <colgroup>
            <col width="20%">
            <col width="80%">
        </colgroup>
        <tbody>
        <tr>
            <td colspan="2"><div class="headDiv"><img class="headImg" :src="headPath" @error="notFindImg()"></div>

            </td>
        </tr>
        <tr>
            <td>司机姓名</td><td>{{$store.state.driver.driver.name}}</td>
        </tr>
        <tr>
            <td>邮箱</td><td>{{$store.state.driver.driver.email}}</td>
        </tr>
        <tr>
            <td>联系电话</td><td>{{$store.state.driver.driver.phone}}</td>
        </tr>
        <tr>
            <td>车型</td><td>{{$store.state.driver.driver.type}}</td>
        </tr>
        <tr>
            <td>核载人数</td><td>{{$store.state.driver.driver.maxNum}}</td>
        </tr>
        <tr>
            <td>车牌号</td><td>{{$store.state.driver.driver.carNum}}</td>
        </tr>
        <tr>
            <td>司机编号</td><td>{{$store.state.driver.driver.id}}</td>
        </tr>
        <tr>
            <td>用户名</td><td>{{$store.state.driver.driver.name}}</td>
        </tr>
        <!--<tr>
            <td></td><td>{{$store.state.user.name}}</td>
        </tr>-->

        </tbody>
    </table>
</template>

<script>
    export default {
        name: "DriverInfo",
        methods:{
            notFindImg(){
                this.$notFind(require("assets/defaultHead.png"));
            },
        },
        computed:{
            headPath(){
                return this.$url.baseURL+this.$store.state.driver.driver.imgPath;
            }
        }
    }
</script>

<style scoped>
    .headDiv{
        margin: auto;
        width: 120px;
        text-align: center;
    }
    .headImg{
        border-radius: 50%;
        border:2px solid #46d7ed;
        padding: 3px;
        width: 100px;
        height: 100px;
        margin: auto;
    }
</style>