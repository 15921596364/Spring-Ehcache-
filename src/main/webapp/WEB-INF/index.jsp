<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <script src="../js/jquery.min.js"></script>
</head>
<body>
<h2>序号：${user.id}</h2>
<h2>名字：${user.name}</h2>
<h2>年龄：${user.age}</h2>
<div>
    <br/>
    <p><button id="insertClick">插入新数据</button></p>
    <br/>
</div>
<br/>
<div>
    <p><button id="countClick">获取数量</button></p>
    <p>数量：<span id="count"></span>    </p>
</div>
<script>
    $("#countClick").click(function () {
        $.ajax({
            url:"<%=request.getContextPath()%>/count",
            type:"post",
            dataType:"json",
            success:function (data) {
                $("#count").html(data.hello);
            },
            error:function () {
                alert("ajax出错");
            }
        })
    });
    $("#insertClick").click(function () {
        $.ajax({
            url:"<%=request.getContextPath()%>/insert",
            type:"post",
            dataType:"json",
            success:function (data) {
                if (data.flag==true){
                    alert("插入成功");
                }else {
                    alert("插入失败");
                }
            },
            error:function () {
                alert("ajax出错");
            }
        })
    });
</script>
</body>
</html>
