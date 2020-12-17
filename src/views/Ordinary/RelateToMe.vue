<template>
    <div class="relateMe layui-col-lg4"><p class="titleP">有关我的</p><table class="layui-table">
        <!--                    3．填写参会的往返时间、住宿要求及其它情况-->
        <tbody>
        <tr>
            <td>备注</td>
        </tr>
        <tr>
            <td>
                <textarea  v-model.lazy="infoInput" placeholder="会议管理会根据您的需求安排" autocomplete="off" class="area "></textarea>
            </td></tr>
        <tr>
            <td><button class="layui-btn layui-btn-normal">确认提交</button></td>
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
            meetingUser:{

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