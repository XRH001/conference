
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>首页</title>

    <%@ include file="/pages/common/head.jsp" %>
    <link rel="stylesheet" href="pages/index/index.css">
</head>
<body>
<script src="pages/index/index.js"></script>

<%@include file="/pages/common/naviBar.jsp"%>

<div class="container layui-row">

    <div id="joinDiv" class="layui-col-lg6 layui-col-xs11">
        <span  class="divTitle layui-icon layui-icon-form">参与会议</span>
        <hr class="layui-bg-green">
        <div class="layui-tab layui-tab-brief">
            <ul class="layui-tab-title">
                <li class="layui-this">未结束</li>
                <li>已结束</li>
                <li>查找</li>
                <li>申请中</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show"><div class="layui-collapse">
                    <div class="layui-colla-item">
                        <h2 class="layui-colla-title">论怎么当混子最舒服<span class="meetingState">5小时后开始</span></h2>
                        <div class="layui-colla-content "><!--layui-show-->
                            <a class="layui-btn detailButton" href="../detail/detail.html"><i class="layui-icon layui-icon-align-left"> </i>详细信息</a>
                            <br><br>
                            <fieldset class="layui-elem-field ">
                                <legend>会议开始时间</legend>
                                <div class="layui-field-box">
                                    2020年11月19日 上午 11:00
                                </div>
                            </fieldset>
                            <fieldset class="layui-elem-field">
                                <legend>会议地点</legend>
                                <div class="layui-field-box">
                                    南昌大学宿舍
                                </div>
                            </fieldset>
                            <fieldset class="layui-elem-field">
                                <legend>会议人数</legend>
                                <div class="layui-field-box">
                                    463
                                </div>
                            </fieldset>
                            <fieldset class="layui-elem-field ">
                                <legend>预计结束时间</legend>
                                <div class="layui-field-box">
                                    2020年11月19日 下午 13:00
                                </div>
                            </fieldset>
                        </div>
                    </div>
                    <div class="layui-colla-item">
                        <h2 class="layui-colla-title">会议2</h2>
                        <div class="layui-colla-content ">内容区域</div>
                    </div>
                    <div class="layui-colla-item">
                        <h2 class="layui-colla-title">会议3</h2>
                        <div class="layui-colla-content ">内容区域</div>
                    </div>
                </div>
                </div>
                <div class="layui-tab-item">
                    <div class="layui-collapse">
                        <div class="layui-colla-item">
                            <h2 class="layui-colla-title">我是废物<span class="meetingState">3天前结束</span></h2>
                            <div class="layui-colla-content "><!--layui-show-->
                                <a class="layui-btn detailButton" href="../detail/detail.html"><i class="layui-icon layui-icon-align-left"> </i>详细信息</a>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>会议开始时间</legend>
                                    <div class="layui-field-box">
                                        2020年11月19日 上午 11:00
                                    </div>
                                </fieldset>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>会议地点</legend>
                                    <div class="layui-field-box">
                                        南昌大学宿舍
                                    </div>
                                </fieldset>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>会议人数</legend>
                                    <div class="layui-field-box">
                                        463
                                    </div>
                                </fieldset>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>预计结束时间</legend>
                                    <div class="layui-field-box">
                                        2020年11月19日 下午 13:00
                                    </div>
                                </fieldset>
                            </div>
                        </div>
                        <div class="layui-colla-item">
                            <h2 class="layui-colla-title">会议2</h2>
                            <div class="layui-colla-content ">内容区域</div>
                        </div>
                        <div class="layui-colla-item">
                            <h2 class="layui-colla-title">会议3</h2>
                            <div class="layui-colla-content ">内容区域</div>
                        </div>
                    </div>
                </div>
                <div class="layui-tab-item layui-row">
                    <div class="searchInputDiv layui-col-lg10 layui-col-md10 layui-col-xs10">
                        <input class="layui-input" type="text" placeholder="输入会议id或名称进行查找" value="废物">
                    </div>
                    <div class="searchButtonDiv layui-col-lg2 layui-col-md2 layui-col-xs2">
                        <button class="searchButton layui-btn layui-btn"><span class="layui-icon layui-icon-search"></span></button>
                    </div>

                    <div class="layui-col-lg11 layui-col-md11 layui-col-xs11">
                        <br>
                        <table id="searchResultTable" class="layui-table">
                            <colgroup>
                                <col width="300">
                                <col width="300">
                                <col width="100">
                            </colgroup>
                            <thead>
                            <tr>
                                <th>会议名称</th>
                                <th>开始或已结束时间</th>
                                <th>动作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>废物怎么逆袭</td>
                                <td>三天后开始</td>
                                <td><a href="../detail/detail.html" class="layui-btn layui-btn-normal layui-btn-sm">详情</a></td>
                            </tr>
                            <tr>
                                <td>废物就是废物</td>
                                <td>三天后开始</td>
                                <td><a href="../detail/detail.html" class="layui-btn layui-btn-normal   layui-btn-sm">详情</a></td>
                            </tr>
                            </tbody>
                        </table></div>
                </div>
                <div class="layui-tab-item"><div class="layui-collapse">
                    <div class="layui-colla-item">
                        <h2 class="layui-colla-title">混子速成<span class="meetingState">三天后开始</span></h2>
                        <div class="layui-colla-content "><!--layui-show-->
                            <a class="layui-btn" href="../detail/detail.html"><i class="layui-icon detailButton layui-icon-align-left"> </i>详细信息</a>
                            <fieldset class="layui-elem-field layui-field-title">
                                <legend>会议开始时间</legend>
                                <div class="layui-field-box">
                                    2020年11月19日 上午 11:00
                                </div>
                            </fieldset>
                            <fieldset class="layui-elem-field layui-field-title">
                                <legend>会议地点</legend>
                                <div class="layui-field-box">
                                    南昌大学宿舍
                                </div>
                            </fieldset>
                            <fieldset class="layui-elem-field layui-field-title">
                                <legend>会议人数</legend>
                                <div class="layui-field-box">
                                    463
                                </div>
                            </fieldset>
                            <fieldset class="layui-elem-field layui-field-title">
                                <legend>预计结束时间</legend>
                                <div class="layui-field-box">
                                    2020年11月19日 下午 13:00
                                </div>
                            </fieldset>
                        </div>
                    </div>
                    <div class="layui-colla-item">
                        <h2 class="layui-colla-title">会议2</h2>
                        <div class="layui-colla-content ">内容区域</div>
                    </div>
                    <div class="layui-colla-item">
                        <h2 class="layui-colla-title">会议3</h2>
                        <div class="layui-colla-content ">内容区域</div>
                    </div>
                </div></div>
            </div>
        </div>
    </div>
    <div id="managerDiv" class="layui-col-lg5 layui-col-xs11">
        <span  class="divTitle layui-icon layui-icon-chart-screen">管理会议</span>
        <hr class="layui-bg-orange">
        <div class="layui-tab layui-tab-brief">
            <ul class="layui-tab-title">
                <li class="layui-this">未结束</li>
                <li>已结束</li>
                <li>创建</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show"><div class="layui-collapse">
                    <div class="layui-colla-item">
                        <h2 class="layui-colla-title">论怎么当混子最舒服<span class="meetingState">5小时后开始</span></h2>
                        <div class="layui-colla-content "><!--layui-show-->
                            <form action="" method="get" class="layui-form ">
                                <a class="layui-btn detailButton" href="../detail/manager.html"><i class="layui-icon layui-icon-align-left"> </i>详细信息</a>
                                <button type="submit" class="layui-btn"><i class="layui-icon layui-icon-upload-drag"> </i>确认修改</button>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>会议名称</legend>
                                    <div class="layui-field-box">
                                        <div class="layui-form-item">
                                            <!--<label class="layui-form-label ">邮箱/账号</label>-->
                                            <div class=" ">
                                                <input type="text" name="startTime" required  lay-verify="required" value="论怎么当混子最舒服" autocomplete="off" class="layui-input">
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>会议开始时间</legend>
                                    <div class="layui-field-box">
                                        <div class="layui-form-item">
                                            <!--<label class="layui-form-label ">邮箱/账号</label>-->
                                            <div class=" ">
                                                <input type="text" name="startTime" required  lay-verify="required" value="2020年11月19日 11:00" autocomplete="off" class="layui-input startTime">
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>会议地点</legend>
                                    <div class="layui-field-box">
                                        <div class="layui-form-item">
                                            <!--<label class="layui-form-label ">邮箱/账号</label>-->
                                            <div class=" ">
                                                <input type="text" name="meetingPosition" required  lay-verify="required" value="南昌大学宿舍" autocomplete="off" class="layui-input">
                                            </div>
                                        </div>
                                        <!---->
                                    </div>
                                </fieldset>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>预计结束时间</legend>
                                    <div class="layui-field-box">
                                        <div class="layui-form-item">
                                            <!--<label class="layui-form-label ">邮箱/账号</label>-->
                                            <div class=" ">
                                                <input type="text" name="endTime"  required  lay-verify="required" value="2020年11月19日  13:00" autocomplete="off" class="layui-input endTime">
                                            </div>
                                        </div>
                                        <!---->
                                    </div>
                                </fieldset>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>会议人数</legend>
                                    <div class="layui-field-box">
                                        463
                                    </div>
                                </fieldset>

                            </form>
                        </div>
                    </div>
                    <div class="layui-colla-item">
                        <h2 class="layui-colla-title">会议2</h2>
                        <div class="layui-colla-content ">内容区域</div>
                    </div>
                    <div class="layui-colla-item">
                        <h2 class="layui-colla-title">会议3</h2>
                        <div class="layui-colla-content ">内容区域</div>
                    </div>
                </div>
                </div>
                <div class="layui-tab-item">
                    <div class="layui-tab-item layui-show"><div class="layui-collapse">
                        <div class="layui-colla-item">
                            <h2 class="layui-colla-title">我是废物<span class="meetingState">3天前结束</span></h2>
                            <div class="layui-colla-content "><!--layui-show-->
                                <a class="layui-btn"><i class="layui-icon layui-icon-align-left"> </i>详细信息</a>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>会议开始时间</legend>
                                    <div class="layui-field-box">
                                        2020年11月19日 上午 11:00
                                    </div>
                                </fieldset>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>会议地点</legend>
                                    <div class="layui-field-box">
                                        南昌大学宿舍
                                    </div>
                                </fieldset>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>会议人数</legend>
                                    <div class="layui-field-box">
                                        463
                                    </div>
                                </fieldset>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>预计结束时间</legend>
                                    <div class="layui-field-box">
                                        2020年11月19日 下午 13:00
                                    </div>
                                </fieldset>
                            </div>
                        </div>
                        <div class="layui-colla-item">
                            <h2 class="layui-colla-title">会议2</h2>
                            <div class="layui-colla-content ">内容区域</div>
                        </div>
                        <div class="layui-colla-item">
                            <h2 class="layui-colla-title">会议3</h2>
                            <div class="layui-colla-content ">内容区域</div>
                        </div>
                    </div>
                    </div>
                </div>
                <div class="layui-tab-item">
                    <div>
                        <a href="../detail/create.html" id="createMeetingButton" class="layui-btn layui-bg-green"><span class="layui-icon layui-icon-add-circle-fine">创建</span></a>
                        <a href="javascript:void(0)" id="reStartMeetingButton" class="layui-btn layui-bg-green"><span class="layui-icon layui-icon-refresh-1">重启</span></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--    <div id="driverDiv" class="layui-col-lg12">-->

</div>
        <br><br><br>

<script>

</script>
</body>
</html>