<template>
    <div>
        <table class="layui-table">
            <colgroup><col width="20%"><col width="80%"></colgroup>
            <tbody>
                <tr><td>出行</td>
                    <td><el-select v-model="selectDriver" placeholder="选择司机">
                        <el-option v-for="driverItem in haveDriverList" :key="driverItem.id"  :label="driverItem.name+'-'+driverItem.carNum" :value="driverItem.id"></el-option>
                    </el-select></td>
                </tr>
                <tr>
                    <td>入住</td>
                    <td>
                        <el-select v-model="selectHotel" placeholder="选择酒店">
                            <el-option v-for="hotelItem in haveHotelList" :key="hotelItem.id"  :label="hotelItem.name+'-'+hotelItem.address" :value="hotelItem.id"></el-option>
                        </el-select>
                        <el-select v-model="roomType" placeholder="选择房间类型">
                            <el-option v-for="roomItem in allRoomType" :label="roomType" :value="roomItem" :key="roomItem"></el-option>
                        </el-select>
                    </td>
                </tr>
                <tr><td colspan="2" class="align-center">
                    <el-button size="small" @click="confirmArrange">确认修改</el-button>
                </td></tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {
        name: "ArrangeOne",
        data(){
            return{
                selectDriver:"",
                selectHotel:"",
                roomType:"",
                allRoomType:["单人间","双人间","三人间","商务间"]
            }
        },methods:{
            confirmArrange(){
                this.$request(this.$url.confirmArrange, {
                        params:{
                            meetingId:this.meetingId,
                            userId:this.userId,
                            driverId:this.driverId,
                            hotelId:this.hotelId,
                            roomType:this.roomType
                        }
                    }).then(res =>{
                        let data = res.data();
                        if(data.msg==="success")this.$message("修改成功");
                        else this.$message("修改失败，存在已拒绝的司机或酒店，或已退出成员");
                }).catch(err =>{
                    console.log(err);
                    this.$message("网络请求错误");
                });
            }
        },
        props:{
            haveDriverList:Array,
            haveHotelList:Array,
            meetingId:Number,
            userId:Number
        }
    }
</script>

<style scoped>

</style>