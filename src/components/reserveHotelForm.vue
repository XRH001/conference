<template>
    <div class="reserveForm">
        <table class="layui-table">
            <thead>
            <tr><th>房间类型</th><th>房间数</th><th>入住时间</th><th>退房时间</th><td>删除</td></tr>
            </thead>
            <tbody>
            <tr v-for="(roomItem,index) in bookRoom" :key="index"><td>
                <el-select v-model="roomItem.type" placeholder="请选择房间类型">
                    <el-option label="单人间" value="1"></el-option>
                    <el-option label="双人间" value="2"></el-option>
                    <el-option label="三人间" value="3"></el-option>
                </el-select></td><td>
                <el-input-number v-model="roomItem.num"  :min="1" :max="20" label="描述文字"></el-input-number></td>
                <td><el-date-picker class="setWidth" v-model.lazy="roomItem.beginTime" type="date"></el-date-picker></td>
                <td><el-date-picker class="setWidth" v-model.lazy="roomItem.endTime" type="date"></el-date-picker></td>
                <td><el-button class="el-icon-remove-outline" @click="removeThisLine(index)" size="small"></el-button></td>
            </tr>
            <tr ><td colspan="5" class="align-center"><el-button @click="addRoomList" size="small" class="el-icon-circle-plus-outline"></el-button></td></tr>
            <tr v-if="action===1"><td colspan="5" class="align-center"><el-button size="small" @click="reserveDriverClick">确认预约</el-button> </td></tr>
            <tr v-if="action===3"><td colspan="5" class="align-center">
                <el-button size="small" @click="reserveDriverClick">修改</el-button>
                <el-button size="small" @click="cancelReserveClick" type="danger">取消预约</el-button>
            </td></tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {
        name: "reserveHotelForm",
        data(){
            return{
                bookRoom:[
                    {
                        type:"",
                        num:0,
                        beginTime:"",
                        endTime:"",
                    },

                ]
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
            removeThisLine(index){
                this.bookRoom.splice(index,1)
            },
            addRoomList(){
                this.bookRoom.push({
                    type:"",
                    num:0,
                    beginTime:"",
                    endTime:""
                });
            },
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
            },
            handleChange(){

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
.setWidth{
    width: 150px;
}
</style>