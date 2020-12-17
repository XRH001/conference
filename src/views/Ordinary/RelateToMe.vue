<template>
    <div class="relateMe layui-col-lg4"><p class="titleP">有关我的</p><table class="layui-table">
        <!--                    3．填写参会的往返时间、住宿要求及其它情况-->
        <tbody>
        <tr>
            <td>备注</td>
            <td>
                <input  type="text" name="leaveTime" v-model.lazy="meetingUser.info" placeholder="会议管理人员会根据您的需求给您安排住宿或接送" autocomplete="off" class="layui-input">
            </td>
            <td colspan="2">
                <Collapse >
                    <span slot="title">我的行程</span>
                    <div slot="content">
                        出发时间:
                    </div>
                </Collapse>
            </td>
        </tr>

        </tbody>
    </table>
        <button class="layui-btn layui-btn-normal">确认提交</button>
    </div>
</template>

<script>
    export default {
        name: "RelateToMe",
        data(){
            return{

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
</style>