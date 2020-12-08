<template>
    <div class="detailContainer layui-row">
        <div class="baseInfo layui-col-lg8"><p class="titleP">基本信息</p>
            <table class="layui-table">
                <tbody>
                <tr>
                    <td>会议名</td>
                    <td>
                        <input disabled type="text" name="meetingName" required  lay-verify="required" :value="meetingInfo.name" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议编号</td>
                    <td>
                        <input disabled type="text" name="meetingID" required  lay-verify="required" :value="meetingId" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议开始时间</td>
                    <td>
                        <input disabled type="text" name="startTime" required  lay-verify="required" :value="meetingInfo.startTime" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议预计结束时间</td>
                    <td>
                        <input disabled type="text" name="overTime" required  lay-verify="required" :value="meetingInfo.endTime" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议地点</td>
                    <td>
                        <input disabled type="text" name="meetingPosition" required  lay-verify="required" :value="meetingInfo.position" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议状态</td>
                    <td>
                        <input disabled type="text" name="meetingStatus" required  lay-verify="required" :value="meetingInfo.state" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>创建时间</td>
                    <td>
                        <input disabled type="text" name="createTime" required  lay-verify="required" :value="meetingInfo.createTime" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议人数</td>
                    <td>
                        <input disabled type="text" name="memberCount" required  lay-verify="required" :value="meetingInfo.memBerNum" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                </tbody>
            </table>
            <hr class="layui-bg-cyan">
            <div class="layui-collapse">
                <p class="titleP">人员信息</p><br><br>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title" @click="managerShow=!managerShow">
                        <span v-if="managerShow" class="layui-icon layui-icon-down"></span>
                        <span v-else class="layui-icon layui-icon-right"></span>
                        管理员名单</h2>
                    <div class="layui-colla-content" :class="{'layui-show':managerShow}">
                        <table class="layui-table">
                            <thead><tr><th>姓名</th><th>联系方式</th></tr></thead>
                            <tbody>
                            <tr><td>金城山</td><td>2312@qq.com</td></tr>
                            <tr><td>程世峰</td><td>321312@qq.com</td></tr>
                            <tr><td>关婷楼</td><td>4124112@qq.com</td></tr>
                            </tbody>
                        </table></div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title" @click="memberShow=!memberShow">
                        <span v-if="memberShow" class="layui-icon layui-icon-down"></span>
                        <span v-else class="layui-icon layui-icon-right"></span>
                        普通成员名单</h2>
                    <div class="layui-colla-content" :class="{'layui-show':memberShow}">
                        <table class="layui-table">
                            <thead><tr><th>姓名</th><th>联系方式</th></tr></thead>
                            <tbody>
                            <tr><td>金城山</td><td>2312@qq.com</td></tr>
                            <tr><td>程世峰</td><td>321312@qq.com</td></tr>
                            <tr><td>关婷楼</td><td>4124112@qq.com</td></tr>
                            <tr><td>金城山</td><td>2312@qq.com</td></tr>
                            <tr><td>程世峰</td><td>321312@qq.com</td></tr>
                            <tr><td>关婷楼</td><td>4124112@qq.com</td></tr>
                            </tbody>
                        </table></div>
                </div>
            </div>
        </div>
        <div class="relateMe layui-col-lg4"><p class="titleP">有关我的</p><table class="layui-table">
            <!--                    3．填写参会的往返时间、住宿要求及其它情况-->
            <tbody>
            <tr>
                <td colspan="2"><h2>{{$store.getters.headPath}}</h2></td>
            </tr>
            <tr>
                <td>我的邮箱</td>
                <td>{{$store.state.userEmail}}</td>
            </tr>
            <tr>
                <td>往返时间</td>
                <td><input  type="text" name="leaveTime" required  lay-verify="required" value="2020年11月20日20:56-2020年11月23日20:56" autocomplete="off" class="layui-input"></td>
            </tr>
            <tr>
                <td>住宿要求</td>
                <td><input  type="text" name="stayRequire" required  lay-verify="required" value="单人间" autocomplete="off" class="layui-input"></td>
            </tr>
            <tr><td>其他要求</td><td><input  type="text" name="memberCount" required  lay-verify="required" value="住宿能报销吗，不能的话我睡大街。" autocomplete="off" class="layui-input"></td></tr>
            </tbody>
        </table>
            <button class="layui-btn layui-btn-normal">确认提交</button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "detail",
        data(){
            return {
                memberShow:false,
                managerShow:false,
                meetingId:"",
                userId:""
            }
        },
        computed:{
            meetingInfo(){return {
                name:"五分钟，我要全部信息",
                id:"3213",
                startTime:"2020年12月6日20:47",
                endTime:"2020年12月6日20:47",
                position:"信工楼b区303",
                state:"未开始",
                createTime:"2020年12月6日20:48:33",
                memBerNum:321,
                managerInfo:[{},{}],
                memberInfo:[{}]
            }}
        },
        created() {
            this.meetingId=this.$route.query.meetingId;
            this.userId=this.$route.query.userId;
        }
    }
</script>

<style scoped>
    .detailContainer{
        margin: 20px;
        border:2px solid #4E5465;
        border-radius: 5px;
    }
    .titleP{
        font-size: 35px;
        color: #4E5465;
        text-align: center;
    }
    .baseInfo{
        border-right: #999999 solid 2px;
        padding: 15px;
    }
    .relateMe{
        padding: 15px;
    }
</style>