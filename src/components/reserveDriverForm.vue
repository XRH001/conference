<template>
    <div class="reserveForm">
        <table class="layui-table">
            <colgroup>
                <col width="20%">
                <col width="80%">
            </colgroup>
            <tbody>
            <tr><td>始发地</td><td><input type="text" v-model.lazy="origin" class="layui-input"></td></tr>
            <tr><td>终点</td><td><input type="text" v-model.lazy="target" class="layui-input"></td></tr>
            <tr><td>出发时间</td><td><el-date-picker v-model.lazy="startTime" type="datetime"></el-date-picker></td></tr>
            <tr><td colspan="2" class="align-center"><el-button size="small" @click="reserveDriverClick">确认预约</el-button> </td></tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {
        name: "reserveDriverForm",
        data(){
            return{
                origin:"",
                target:"",
                startTime:""
            }
        },
        props:{
            meetingId:Number,
            driverId:Number,
            action:{
                type:Number,
                default:1//1表示预约司机，给司机安排行程
                            //2表示给成员安排行程
                            //3表示查看，修改司机行程
            }
        },
        methods:{
            reserveDriverClick(){
                console.log("预约司机")
                //this.$request()
            }
        }
    }
</script>

<style scoped>

</style>