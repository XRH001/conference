<template>
    <div class="hotelManage layui-row">
        <p class="smallTitleP">预约司机接送</p>
        <el-input v-model="driverInput" placeholder="输入id、邮箱或名称进行查找">
            <el-button slot="append" icon="el-icon-search" ></el-button>
        </el-input>
        <br><br>
        <table  class="layui-table">
            <thead>
            <tr>
                <th>司机</th>
                <th>联系方式</th>
                <th>车型</th>
                <th>核载人数</th>
                <th>车牌号</th>
                <th>预约</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="driverItem in driverList" :key="driverItem.id"><td>{{driverItem.name}}</td><td>{{driverItem.phone}}</td>
                <td>{{driverItem.type}}</td><td>{{driverItem.maxNum}}</td>
                <td>{{driverItem.carNum}}</td>
                <td><button class="layui-btn layui-btn-normal  layui-btn-sm">预约</button></td>
            </tr>
            </tbody>
        </table>
        <div class="align-center">
            <el-pagination
                layout="prev, pager, next"
                :total="1000">
            </el-pagination>
        </div>
    </div>
</template>

<script>
    export default {
        name: "ReserveDriver",
        data(){
            return{
                driverInput:"",
                driverList:[
                    {id:1232,name:"马师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231"},
                    {id:1132,name:"马师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231"}
                    ]
            }
        },
        props:{
            meetingId:Number
        },
        created() {

        }

    }
</script>

<style scoped>
    .hotelManage{
        margin: auto;
        border:1px solid #4e5465;
        border-radius: 2px;
        padding: 10px;
    }
    .smallTitleP{
        text-align: center;
        margin: 10px;
        font-size: 20px;
    }
    .align-center{
        text-align: center;
    }
</style>