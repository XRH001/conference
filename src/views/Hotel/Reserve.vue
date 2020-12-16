<template>
    <div>
        <fieldset class="layui-elem-field eachReserve">
            <legend>会议名：怎么把酒店整垮</legend>
            <div class="layui-field-box">
                <!--会议时间：2020年11月23日11:26-2020年11月23日11:26<br>
                会议地点：你家酒店附近<br>
                会议人数：200<br>-->
                <div class="customer">预约人：badGuy<br>
                    联系方式：21312371829@qq.com<br></div>
                <hr class="layui-bg-orange">
                <div class="layui-collapse">
                    <div class="layui-colla-item">
                        <div class="layui-colla-title">预约房间</div>
                        <div class="layui-colla-content">
                            <table class="layui-table">
                                <colgroup></colgroup>
                                <thead>
                                <tr>
                                    <th>房间类型</th>
                                    <th>预定数量</th>
                                    <th>预定时间段</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>单人间</td>
                                    <td>5</td>
                                    <td>2020年12月2日-2020年12月5日</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div></div>
                <hr class="layui-bg-orange">
                <div class="btnDiv layui-row">
                    <div class="layui-col-lg2 layui-col-lg-offset4">
                        <button class="layui-btn layui-bg-orange">接受预约</button>
                    </div>
                    <div class="layui-col-lg3 ">
                        <button class="layui-btn ">会议详情</button></div>
                </div>
            </div>
        </fieldset>
        <fieldset class="layui-elem-field eachReserve">
            <legend>会议名：怎么把酒店整垮</legend>
            <div class="layui-field-box">
                <!--会议时间：2020年11月23日11:26-2020年11月23日11:26<br>
                会议地点：你家酒店附近<br>
                会议人数：200<br>-->
                <div class="customer">预约人：badGuy<br>
                    联系方式：21312371829@qq.com<br></div>
                <hr class="layui-bg-orange">
                <div class="layui-collapse">
                    <div class="layui-colla-item">
                        <div class="layui-colla-title">预约房间</div>
                        <div class="layui-colla-content">
                            <table class="layui-table">
                                <colgroup></colgroup>
                                <thead>
                                <tr>
                                    <th>房间类型</th>
                                    <th>预定数量</th>
                                    <th>预定时间段</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>单人间</td>
                                    <td>5</td>
                                    <td>2020年12月2日-2020年12月5日</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div></div>
                <hr class="layui-bg-orange">
                <div class="btnDiv layui-row">
                    <div class="layui-col-lg2 layui-col-lg-offset4">
                        <button class="layui-btn layui-bg-orange">接受预约</button>
                    </div>
                    <div class="layui-col-lg3 ">
                        <button class="layui-btn ">会议详情</button></div>
                </div>
            </div>
        </fieldset>
        <fieldset class="layui-elem-field eachReserve">
            <legend>会议名：怎么把酒店整垮</legend>
            <div class="layui-field-box">
                <!--会议时间：2020年11月23日11:26-2020年11月23日11:26<br>
                会议地点：你家酒店附近<br>
                会议人数：200<br>-->
                <div class="customer">预约人：badGuy<br>
                    联系方式：21312371829@qq.com<br></div>
                <hr class="layui-bg-orange">
                <div class="layui-collapse">
                    <div class="layui-colla-item">
                        <div class="layui-colla-title">预约房间</div>
                        <div class="layui-colla-content">
                            <table class="layui-table">
                                <colgroup></colgroup>
                                <thead>
                                <tr>
                                    <th>房间类型</th>
                                    <th>预定数量</th>
                                    <th>预定时间段</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>单人间</td>
                                    <td>5</td>
                                    <td>2020年12月2日-2020年12月5日</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div></div>
                <hr class="layui-bg-orange">
                <div class="btnDiv layui-row">
                    <div class="layui-col-lg2 layui-col-lg-offset4">
                        <button class="layui-btn layui-bg-orange">接受预约</button>
                    </div>
                    <div class="layui-col-lg3 ">
                        <button class="layui-btn ">会议详情</button></div>
                </div>
            </div>
        </fieldset>
        <div style="clear: both"></div>
    </div>
</template>

<script>
    export default {
        name: "Reserve"
    }
</script>

<style scoped>

    .customer{
        font-size: 16px;
        margin-left: 15px;
        margin-top: 10px;
    }
    .eachReserve{
        border: 2px solid #4E5465;
        width: 46%;
        margin: 20px;
        float: left;
    }

    @media screen and (max-width: 1200px) {
        .eachReserve{
            width: 40% !important;
        }
    }
    @media screen and (max-width: 900px) {
        .eachReserve{
            width: 92% !important;
        }
    }
</style>