<template>
    <div class="layui-tab layui-tab-card">
        <ul class="layui-tab-title layui-row">
            <li class="layui-this layui-col-lg3">待接送</li>
            <li class="layui-col-lg3">已接送</li>
            <li class="layui-col-lg3">有需求的会议</li>
            <li class="layui-col-lg3">司机信息</li>
        </ul>
        <div class="layui-tab-content" >
            <div class="layui-tab-item layui-show">
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
                            <div></div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="layui-tab-item">
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

                <div class="layui-tab-item">3</div>
            </div>
            <div class="layui-tab-item">
                <div class="meetingContainer layui-row">
                    <div class="layui-card  ">
                        <div class="layui-card-header">怎么写bug不被发现</div>
                        <div class="layui-card-body">
                            <div class="meetingDetailCard">
                                会议开始时间：2020年11月22日21:14<br>
                                会议地点：安徽小岗村。<br>
                                会议人数：300
                            </div>
                            <div class="">
                                <button class="layui-btn layui-btn-normal">接收请求</button>
                                <button class="layui-btn layui-btn-normal">详细信息</button>
                            </div>
                        </div>
                    </div>

                    <div class="layui-card ">
                        <div class="layui-card-header">怎么发现喜欢写bug的人</div>
                        <div class="layui-card-body">
                            <div class="meetingDetailCard">
                                会议开始时间：2020年11月22日21:14<br>
                                会议地点：安徽小岗村。<br>
                                会议人数：200
                            </div>
                            <div class="">
                                <button class="layui-btn layui-btn-normal">接收请求</button>
                                <button class="layui-btn layui-btn-normal">详细信息</button>
                            </div>
                        </div>
                    </div>
                    <div class="layui-card ">
                        <div class="layui-card-header">怎么消除写bug的人</div>
                        <div class="layui-card-body">
                            <div class="meetingDetailCard">
                                会议开始时间：2020年11月22日21:14<br>
                                会议地点：安徽小岗村。<br>
                                会议人数：300
                            </div>
                            <div class="">
                                <button class="layui-btn layui-btn-normal">接收请求</button>
                                <button class="layui-btn layui-btn-normal">详细信息</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-tab-item ">
                <div class=" hotelMessage ">
                    <div class="hotelForm">
                        <div class="signUpper">在此修改您的车队信息</div><br>
                        <!--                    <hr class="layui-bg-cyan">-->
                        <form action="" method="get" class="layui-form ">
                            <div class="layui-form-item">
                                <label class="layui-form-label ">司机</label>
                                <div class="layui-input-block ">
                                    <input type="text" name="driverName" required  lay-verify="required" placeholder="请输入司机姓名" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label ">联系方式</label>
                                <div class="layui-input-block ">
                                    <input type="text" name="contact" required  lay-verify="required" placeholder="请输入邮箱或电话号码" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label ">车型</label>
                                <div class="layui-input-block ">
                                    <input type="text" name="carType" required  lay-verify="required" placeholder="请输入驾车类型" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label ">限载人数</label>
                                <div class="layui-input-block ">
                                    <input type="text" name="maxCount" required  lay-verify="required" placeholder="请输入最大载客数量" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label ">车牌号码</label>
                                <div class="layui-input-block ">
                                    <input type="text" name="licenseNumber" required  lay-verify="required" placeholder="请输入车牌号" autocomplete="off" class="layui-input">
                                </div>
                            </div><br><br>
                            <div class="layui-form-item">
                                <div class="layui-input-block layui-col-space30">
                                    <button class="layui-btn" lay-submit lay-filter="formDemo">确认修改</button>
                                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Driver"
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
    .layui-tab{
        width: 95%;
        margin: auto;
    }
    .meetingName{
        font-size:25px ;
        text-align: center;
        width: 100%;
    }
    .pickUpInfo{
        width: 80%;
        margin: auto;
    }
    .addButton{
        float: left;
    }
    .btnDiv{
        width: 100%;
    }
    .meetingDetail{
        margin-left: 30px;
    }
    .layui-card-header{
        font-size: 25px;
    }
    .layui-card{
        border: 2px solid #4E5465;
        width: 46%;
        margin: 20px;
        float: left;
    }
    @media screen and (max-width: 1200px) {
        .layui-card{
            width: 40% !important;
        }
    }
    @media screen and (max-width: 900px) {
        .layui-card{
            width: 92% !important;
        }
    }

    /*
    @media screen and(max-width: 700px){
        .layui-card{
            width: 94%;
        }
    }*/
    .hotelMessage{
        border: 2px solid #4E5465;
        width: 80%;
        margin: auto;
    }
    .signUpper{
        text-align: center;
        font-size: 25px;
        color: #4E5465;
    }
    .hotelForm{
        width: 80%;
        margin:30px auto;
    }

</style>