<template>
    <div class="relateMe layui-col-lg4"><p class="titleP">与我有关</p>
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
            <td><button class="layui-btn layui-btn-normal" @click="commitInfo()">确认提交</button></td>
            </tr>
        <tr>
            <td colspan="3">
                <Collapse >
                    <span slot="title">我的行程</span>
                    <div slot="content">
                        出发时间:{{meetingUser.journey.time}}<br>
                        出发地点:{{meetingUser.journey.origin}}<br>
                        目的地:{{meetingUser.journey.target}}
                    </div>
                </Collapse>
            </td>
        </tr>
        </tbody>
    </table>
    <div v-else>
        <el-button @click="apply" type="success">申请加入</el-button>
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
                infoInput:this.meetingUser.info
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
                this.$request(this.$url.remarks,{
                    params:{
                        userId:this.$store.state.user.id,
                        meetingId:this.meetingId,
                        remark:this.infoInput
                    }
                }).then(res => {
                    if(res.data==="success")this.$message("修改成功");
                    else this.$message("修改失败");
                }).catch(err => {
                    console.log(err);
                    this.$message("网络请求出现错误");
                });
            },
            apply(){
                this.$request(this.$url.applyJoin,{
                    params:{
                        userId:this.$store.state.user.id,
                        meetingId:this.meetingId
                    }
                }).then(res => {
                    if(res.data==="success")this.$message("申请已发送");
                    else this.$message("申请失败，该会议可能不允许申请");
                }).catch(err => {
                    console.log(err);
                    this.$message("网络请求出现错误");
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
</style>