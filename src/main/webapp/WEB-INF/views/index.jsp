<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>解析excell文件</title>
</head>
<body>
    hello 2018
           现在时间：${now}
    <table align='center' border='1' cellspacing='0'>
       <tr>
            <td>id</td>
            <td>name</td>
       </tr>
       <c:forEach items="${cs}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
                
        </tr>
    </c:forEach>
    
   <%--  <c:forEach items="${cs}" var="c" varStatus="st" >
           <td>${c.id} </td>
           <td>${c.name} </td>
    </c:forEach> --%>
    </table>
    
    <div align="center">
  
</div>
  
<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="editCategory?id=${c.id}">编辑</a></td>
                <td><a href="deleteCategory?id=${c.id}">删除</a></td>
            </tr>
        </c:forEach>
          
    </table>
    <br>
    <div>
                <a href="?start=1">[首  页]</a>
            <a href="?start=${page.pageNum-1}">[上一页]</a>
            <a href="?start=${page.pageNum+1}">[下一页]</a>
            <a href="?start=${page.pages}">[末  页]</a>
    </div>
    <br>
    <form action="addCategory" method="post">
      
    name: <input name="name"> <br>
    <button type="submit">提交</button>
      
    </form>
</div>
</body>
</html>