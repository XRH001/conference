<template>
    <div class="createMeeting layui-row"><p class="titleP">创建会议</p>
        <div class="">

            <form class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">会议名</label>
                    <div class="layui-input-block">
                        <input type="text" name="meetingName" id="meetingName" required   placeholder="请输入少于20位的任意字符(必填)" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">开始时间</label>
                    <div class="layui-input-block">
                        <input type="datetime-local" name="startTime" required   value="" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">会议地点</label>
                    <div class="layui-input-block">
                        <input type="text" name="overTime" required   value="" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <EmailCode :email="$store.state.user.userEmail"></EmailCode>
                <div class="layui-form-item layui-row layui-col-space10">
                    <div class="layui-input-block ">
                        <button class="layui-btn" ><i class="layui-icon layui-icon-friends"></i>立即创建</button>
                        <button  type="reset" class="layui-btn layui-btn-primary displayNone"><i class="layui-icon layui-icon-close-fill"></i>重置</button>
                        <a class="layui-btn" @click="history.back()"><i class="layui-icon layui-icon-user"></i>取消</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
    import EmailCode from "../components/EmailCode";
    export default {
        name: "create",
        components: {EmailCode}
    }
</script>

<style scoped>
    .createMeeting{
        width: 60%;
        padding: 20px;
        border: 2px solid #595B5D;
        border-radius: 6px;
        margin: 30px auto auto;
    }
    .titleP{
        font-size: 35px;
        color: #4E5465;
        text-align: center;
        margin-bottom: 25px;
    }
    .checkCodeInput{
        width: 60%;
        float:left;
    }

    .getCodeButton{
        width: 25%;

    }
    @media screen and (max-width: 800px){
        .checkCodeInput{
            width: 100%;
        }

        .getCodeButton{
            width:50%;
        }
        .createMeeting{
            width: 94%;
            padding-left: 0;

        }
        .displayNone{
            display: none;
        }
    }
</style>