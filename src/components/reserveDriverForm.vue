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
            <tr><td>出发时间</td><td><el-date-picker v-model.lazy="time" type="datetime"></el-date-picker></td></tr>
            <tr v-if="action===1"><td colspan="2" class="align-center"><el-button size="small" @click="reserveDriverClick">确认预约</el-button> </td></tr>
            <tr v-if="action===3"><td colspan="2" class="align-center">
                <el-button size="small" @click="reserveDriverClick">修改</el-button>
                <el-button size="small" @click="cancelReserveClick" type="danger">取消预约</el-button>
            </td></tr>
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
                time:""//出发时间
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
                // console.log("预约司机")
                this.$request(this.$url.reserveDriver,{
                    params:{
                        meetingId:this.meetingId,
                        driverId:this.driverId,
                        origin:this.origin,
                        target:this.target,
                        time:this.time
                    }
                }).then(res =>{
                    let data=res.data;
                    if(data.msg==="success"){
                        if(this.action===1) this.$message("预约成功");
                        else if(this.action===2) this.$message("修改成功");
                    }
                    else this.$message("预约失败");
                })
            },
            findDriverJourney(){
                this.$request(this.$url.findDriverJourney,{
                    params:{
                        meetingId:this.meetingId,
                        driverId:this.driverId
                    }
                }).then(res =>{
                    let data=res.data;
                    if(data.msg==="success"){
                        this.origin=data.origin;
                        this.target=data.target;
                        this.time=data.time;
                    }
                    else/* if(data.msg==="fail")*/{
                        this.$message("查找司机行程失败")
                    }
                }).catch(err =>{
                    console.log(err);
                    console.log("司机行程网络请求错误");
                });
            },
            cancelReserveClick(){
                this.$message("暂不支持取消");
            }
        },
        created() {
            if(this.action===3){
                this.findDriverJourney();
            }
        }
    }
</script>

<style scoped>

</style>