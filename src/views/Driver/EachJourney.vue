<template>
    <div class="layui-row meetingContainer ">

        <div class="layui-col-lg6 layui-col-md12 outDiv"
         v-for="pickItem in meetingJourney" :key="pickItem.id">
            <div class="eachMeeting ">
                <div>
                    <span class="meetingName">{{pickItem.name}}</span>
                    <span class="meetingDetail">会议时间：{{pickItem.beginTime}} </span>
                    <span class="meetingDetail">会议地点：{{pickItem.address}}</span>
                </div>
                <hr class="layui-bg-green">

                <Collapse>
                    <span slot="title">接送名单</span>
                    <div slot="content">
                        <table class="layui-table">
                            <thead><th>姓名</th><th>联系方式</th></thead>
                            <tbody>
                            <tr v-for="passenger in pickItem.passenger" :key="passenger.userId">
                                <td>{{passenger.username}}</td>
                                <td>{{passenger.contact}}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </Collapse>

                <!--2司机确认、并给出接车时间和地点
                    3接送完成参会人员后确认完成-->
                <div class=" layui-row " >
                    <div class=" layui-col-lg12">
                        <div class="layui-form-label"><label>出发地点：</label></div>
                        <div class="layui-input-block">
                            <input type="text" class="layui-input" disabled :value="pickItem.journey.origin">
                        </div>
                    </div>
                    <div class=" layui-col-lg12">
                        <div class="layui-form-label"><label>目的地：</label></div>
                        <div class="layui-input-block">
                            <input type="text" class="layui-input" disabled :value="pickItem.journey.target">
                        </div>
                    </div>

                    <div class="layui-col-lg12">
                        <div class="layui-form-label"><label>出发时间：</label></div>
                        <div class="layui-input-block">
                            <input type="text" class="layui-input" disabled :value="pickItem.journey.time">
                        </div>
                    </div>

                </div>
                <div  class="pickUpInfo layui-row inputLineContainer"></div>
                <hr class="layui-bg-orange">


                <div class="btnDiv" v-if="action===0">
                    <button class="layui-btn layui-bg-orange" @click="leftClick(pickItem)">确认接送完成</button>
                    <el-popconfirm title="是否确定拒绝预约？" @confirm="rightClick(pickItem.id)">
                        <button slot="reference" class="layui-btn layui-bg-red" >发出取消请求</button>
                    </el-popconfirm>
                </div>
                <div class="btnDiv" v-if="action===1">
                    <br><br>
                </div>
                <div class="btnDiv" v-if="action===2">
            <button class="layui-btn layui-bg-orange" @click="leftClick(pickItem)">接收预约</button>
            <el-popconfirm title="是否确定拒绝预约？" @confirm="rightClick(pickItem.id)">
                <button slot="reference" class="layui-btn layui-bg-red" >拒绝预约</button>
            </el-popconfirm>
        </div>
            </div>
    </div>

    </div>
</template>

<script>
    import Collapse from "../../components/Collapse";
    export default {
        name: "EachJourney",
        components:{
            Collapse
        },
        props:{
            meetingJourney:Array,
            action: {
                type:Number,//0:待接送
                //1:已接送
                //2:预约消息
                default:0
            }
            },
        methods:{
            leftClick(pickItem){
                this.$emit("leftClick",pickItem);
            },
            rightClick(itemId){
                this.$emit("rightClick",itemId);
            }
        }
    }
</script>

<style scoped>
    .eachMeeting{
        border: 2px solid #4E5465;
        padding: 15px;
        margin-top: 20px;
        border-radius: 5px;
    }
    .meetingContainer{
        margin: 20px auto;
        width: 94%;
        padding: 0;
    }
    .outDiv{
        margin: 0;
        padding: 10px;
        float: left;
    }
    *{
        font-family: '微软雅黑';
    }

    .meetingName{
        font-size:25px ;
        text-align: center;
        width: 100%;
    }
    .pickUpInfo {
        width: 80%;
        margin: auto;
    }
    .addButton {
        float: left;
    }
    .btnDiv{
        width: 100%;
        text-align: center;
    }
    .meetingDetail{
        margin-left: 30px;
    }
    .layui-col-lg12{
        margin: 6px;
    }
</style>