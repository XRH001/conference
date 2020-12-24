<template>
    <div class="relateMe "><p class="titleP">与我有关</p>
        <table class="layui-table" v-if="meetingUser.ifJoin">
        <tbody>
        <tr>
            <td>备注</td>
        </tr>
        <tr>
            <td>
                <textarea  v-model.lazy="infoInput" @blur="emitInput()" placeholder="会议管理人员会根据您的需求安排酒店和住宿" autocomplete="off" class="area "></textarea>
            </td></tr>
        <tr>
            <td><button class="layui-btn layui-btn-normal" @click="commitInfo()" :disabled="flag.commitDisabled">确认提交</button></td>
            </tr>
        <tr>
            <td colspan="3">
                <Collapse >
                    <span slot="title">我的行程</span>
                    <el-card class="box-card" slot="content">
                        <div slot="header" >
                            <span>司机:{{meetingUser.driver.name}} </span>
                            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
                        </div>
                        <div>
                            <div>
                                车牌号:{{meetingUser.driver.carNum}}<br>
                                联系方式:{{meetingUser.driver.phone}}<br>
                                出发时间:{{meetingUser.driver.journey.time}}<br>
                                出发地点:{{meetingUser.driver.journey.origin}}<br>
                                目的地:{{meetingUser.driver.journey.target}}
                            </div>
                        </div>
                    </el-card>
                </Collapse>
                <Collapse >
                    <span slot="title">入住安排</span>
                    <el-card class="box-card" slot="content">
                        <div slot="header" >
                            <span>酒店:{{meetingUser.driver.name}} </span>
                            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
                        </div>
                        <div>
                            <div>
                                酒店地址:{{meetingUser.driver.carNum}}<br>
                                酒店联系电话:{{meetingUser.driver.phone}}<br>
                                房间类型:{{meetingUser.driver.journey.time}}<br>
                            </div>
                        </div>
                    </el-card>
                </Collapse>
            </td>
        </tr>
        </tbody>
    </table>
    <div v-if="!meetingUser.ifJoin">
        <el-button v-show="!meetingUser.ifApplied" @click="apply" type="success" :disabled="flag.applyDisabled">申请加入</el-button>
        <p v-show="meetingUser.ifApplied" class="message">加入请求已发送，等待管理员同意...</p>
    </div>

    </div>
</template>

<script>
    import Collapse from "components/Collapse";
    export default {
        name: "RelateToMe",
        components:{
            Collapse
        },
        data(){
            return{
                infoInput:this.meetingUser.info,
                flag:{
                    applyDisabled:false,
                    commitDisabled:false
                }
            }
        },
        props:{
            meetingUser:Object,
            meetingId:Number
        },
        methods:{
            emitInput(){
                this.$emit("infoChange",this.infoInput);
            },
            commitInfo(){
                if(this.infoInput===""){this.$message("不可为空");return;}
                if(this.infoInput.length>100){this.$message("长度请小于100字");return;}
                this.flag.commitDisabled=true;
                this.$request(this.$url.remarks,{
                    params:{
                        userId:this.$store.state.user.id,
                        meetingId:this.meetingId,
                        remark:this.infoInput
                    }
                }).then(res => {
                    if(res.data==="success")this.$message("修改成功");
                    else this.$message("修改失败");
                    this.flag.commitDisabled=false;
                }).catch(err => {
                    console.log(err);
                    this.$message("网络请求出现错误");
                    this.flag.commitDisabled=false;
                });
            },
            apply(){
                this.flag.applyDisabled=true;
                this.$request(this.$url.applyJoin,{
                    params:{
                        userId:this.$store.state.user.id,
                        meetingId:this.meetingId
                    }
                }).then(res => {
                    if(res.data==="success")this.$message("申请已发送");
                    else this.$message("申请失败，该会议可能不允许申请");
                    this.flag.applyDisabled=false;
                }).catch(err => {
                    console.log(err);
                    this.$message("网络请求出现错误");
                    this.flag.applyDisabled=false;
                });
            }
        }
    }
</script>

<style scoped>
    .relateMe{
        padding: 15px;
    }
    .titleP{
        font-size: 35px;
        color: #4E5465;
        text-align: center;
    }
    .el-textarea{
        height: 150px;
    }
    .message{
        font-size: 25px;
        color: #68b468;
        text-align: center;
    }
</style>