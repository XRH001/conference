<template>
    <div class="layui-row  meetingContainer">
        <div class="layui-col-lg12 eachMeeting">
            <div>
                <span class="meetingName">javaWeb如何入土</span>
                <span class="meetingDetail">会议时间：2020年11月22日00:03 </span>
                <span class="meetingDetail">会议地点：信工楼e234 </span>
            </div>
            <hr class="layui-bg-green">
            <div><button class="layui-btn" onclick="displayTable('alreadyTable')"><span class="layui-icon layui-icon-spread-left">折叠名单</span></button></div>
            <table class="layui-table" id="alreadyTable">
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
            </table></div></div>
</template>

<script>
    export default {
        name: "Already"
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

    .meetingName{
        font-size:25px ;
        text-align: center;
        width: 100%;
    }

    .meetingDetail{
        margin-left: 30px;
    }

</style>