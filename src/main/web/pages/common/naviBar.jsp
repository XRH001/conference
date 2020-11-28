<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="pages/common/common.js"></script>
<ul class="layui-nav layui-row ">
    <li class="layui-nav-item layui-this "><a href="pages/index/index.html">首页</a></li>
    <li class="layui-nav-item  "><a href="pages/detail/detail.html">详情</a></li>
    <li class="layui-nav-item "><a href="pages/driver/driver.html">车队</a></li>
    <li class="layui-nav-item "><a href="pages/hotel/hotel.html">酒店</a></li>
    <li class="layui-nav-item  layui-col-lg-offset6"><a href="">系统管理</a></li>
    <li class="layui-nav-item "><a href="">我的消息</a></li>
    <c:if test="${not empty requestScope.user}">
    <li class="layui-nav-item ">
        <a href=""><img src="img/defaultHead.png" class="layui-nav-img">我</a>
        <dl class="layui-nav-child">
            <dd><a href="javascript:;">个人信息</a></dd>
            <dd><a href="javascript:;">安全管理</a></dd>
            <dd><a href="javascript:;">退出登陆</a></dd>
        </dl>
    </li>
    </c:if>
    <c:if test="${empty requestScope.user}">
    <li class="layui-nav-item "><a href="pages/login/login.html">登录</a></li>
        <li class="layui-nav-item"><a href="pages/register/register.html">注册</a></li>
    </c:if>
</ul>
