<template>
    <div class="hotelManage layui-row">
        <p class="smallTitleP">预约酒店房间</p>
        <el-input v-model="hotelInput" placeholder="输入id、邮箱或名称进行查找">
            <el-button slot="append" icon="el-icon-search" ></el-button>
        </el-input>
        <br><br>
        <table  class="layui-table">
            <colgroup>
                <col width="30%">
                <col width="50%">
                <col width="20%">
            </colgroup>
            <thead>
            <tr>
                <th>店名</th>
                <th>联系方式</th>
                <th>动作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>居家旅馆</td>
                <td>4384381@qq.com</td>
                <td><button class="layui-btn layui-btn-normal  layui-btn-sm">预约</button></td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {
        name: "ReserveHotel",
        data(){
            return{
                hotelInput:""
            }
        }
    }
</script>

<style scoped>
    .hotelManage{
        margin: auto;
    }
    .smallTitleP{
        text-align: center;
        margin: 10px;
        font-size: 20px;
    }
</style>