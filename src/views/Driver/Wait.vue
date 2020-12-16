<template>
    <div>
    <div class="allContainer">
        <div class="layui-row  meetingContainer">
            <div class="layui-col-lg12 eachMeeting">
                <div>
                    <span class="meetingName">javaWeb如何入土</span>
                    <span class="meetingDetail">会议时间：2020年11月22日00:03 </span>
                    <span class="meetingDetail">会议地点：信工楼e234 </span>
                </div>
                <hr class="layui-bg-green">
                <div><button class="layui-btn" onclick="displayTable('memberMeetingId')"><span class="layui-icon layui-icon-spread-left">折叠名单</span></button></div>
                <table class="layui-table" id="memberMeetingId">
                    <colgroup>
                        <col width="10">
                        <col width="70">
                        <col width="70">
                        <col width="70">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>人员姓名</th>
                        <th>车次/航班号</th>
                        <th>最晚到站时间</th>
                        <th>联系方式</th>
                    </tr>
                    </thead>
                    <!--1给出具体所需要接送的人员名单车次或者航班号、最晚到站时间和相关参会人员电话号码
                        -->
                    <tbody>
                    <tr>
                        <td>妈耶</td>
                        <td>b203路网约车</td>
                        <td>2020年11月21日22:51</td>
                        <td>email:12421@qq.com</td>
                    </tr>
                    <tr>
                        <td>妈耶</td>
                        <td>b203路网约车</td>
                        <td>2020年11月21日22:51</td>
                        <td>email:12421@qq.com</td>
                    </tr><tr>
                        <td>妈耶</td>
                        <td>b203路网约车</td>
                        <td>2020年11月21日22:51</td>
                        <td>email:12421@qq.com</td>
                    </tr>
                    </tbody>
                </table>
                <!--2司机确认、并给出接车时间和地点
                    3接送完成参会人员后确认完成-->
                <div class="pickUpInfo layui-row baseInfo" >
                    <div class=" layui-col-lg5">
                        <div class="layui-form-label"><label>接车地点：</label></div>
                        <div class="layui-input-block">
                            <input type="text" class="layui-input">
                        </div>
                    </div>
                    <div class=" layui-col-lg5">
                        <div class="layui-form-label"><label>接车时间：</label></div>
                        <div class="layui-input-block">
                            <input type="text" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-col-lg1 layui-col-lg-offset1">
                        <button class="addButton layui-btn " onclick="addInputLine()"><span class="layui-icon layui-icon-add-circle"> </span></button>
                    </div>

                </div>
                <div  class="pickUpInfo layui-row inputLineContainer"></div>
                <div class="btnDiv layui-row">
                    <hr class="layui-bg-green">
                    <div class="layui-col-lg2 layui-col-lg-offset4">
                        <button class="layui-btn layui-bg-green">确认提交</button>
                    </div>
                    <div class="layui-col-lg3 ">
                        <button class="layui-btn layui-bg-green">清空所有</button></div>
                </div>
                <hr class="layui-bg-orange">
                <div class="btnDiv layui-row"></div>
                <div class="layui-col-lg2 layui-col-lg-offset4">
                    <button class="layui-btn layui-bg-orange">确认接送完成</button>
                </div>

                <div class="layui-col-lg1 ">
                    <button class="layui-btn layui-bg-red">发出取消请求</button>
                </div>
            </div>
        </div>
    </div>
    </div>
</template>

<script>
    export default {
        name: "Wait"
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
    }
    .allContainer{

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
    }
    .meetingDetail{
        margin-left: 30px;
    }

</style>