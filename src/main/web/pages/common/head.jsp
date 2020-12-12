<%--
  Created by IntelliJ IDEA.
  User: 25692
  Date: 2020/11/19
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
    pageContext.setAttribute("basePath",basePath);
%>

<!--写base标签，永远固定相对路径跳转的结果-->
<base href="<%=basePath%>">

<!--写base标签，永远固定相对路径跳转的结果-->
<base href="<%=basePath%>">
<link rel="stylesheet" href="static/layui/css/layui.css">
<script src="static/layui/layui.js"></script>
<script src="static/js/jquery-3.3.1.min.js"></script>
