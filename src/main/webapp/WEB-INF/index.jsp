<%--
  Created by IntelliJ IDEA.
  User: shiyongxiang
  Date: 16/10/21
  Time: 上午10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
首页欢迎您！
<form action="/add" method="POST">
    <h4>添加用户表单</h4>
    <div>
        <label>id</label>
        <input name="id" type="text">
    </div>
    <div>
        <label>username</label>
        <input name="username" type="text">
    </div>
    <div>
        <label>password</label>
        <input name="password" type="password">
    </div>
    <div>
        <label>age</label>
        <input name="age" type="text">
    </div>
    <input type="submit" value="添加">
</form>
<form action="/get" method="get">
    <h4>查询用户表单</h4>
    <div>
        <label>id</label>
        <input name="id">
    </div>
    <input type="submit" value="查询">
</form>
<form action="/cache" method="get">
    <h4>设置一个缓存</h4>
    <div>
        <label>key</label>
        <input name="key">
    </div>
    <div>
        <label>value</label>
        <input name="value">
    </div>
    <div>
        <label>有效时间</label>
        <input name="timeout">
    </div>
    <input type="submit" value="缓存">
</form>
<form action="/getCache" method="get">
    <h4>读取缓存</h4>
    <div>
        <label>key</label>
        <input name="key">
    </div>
    <input type="submit" value="读取">
</form>
</body>
</html>
