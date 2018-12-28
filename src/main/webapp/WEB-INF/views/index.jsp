<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 引入 jquery 脚本 -->
<script type="text/javascript" src="js/jquery.min.js">
    </script>
<!-- 使用表单提交 delete 请求 -->
<script type="text/javascript">
        $(function(){
            $(".delete").click(function(){
                var action = $(this).attr("href");
                $("#formdelete").attr("action",action).submit();
                return false;
            });
        });
    </script>

<div align="center"></div>

<div style="width: 500px; margin: 20px auto; text-align: center">
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
				<!-- 这里可以将数据传到代码端去 -->
				<td><a href="categories/${c.id}">编辑</a></td>
				<td><a class="delete" href="categories/${c.id}">删除</a></td>
			</tr>
		</c:forEach>

	</table>
	<br>
	<div>
		<a href="?start=1">[首 页]</a> <a href="?start=${page.pageNum-1}">[上一页${page.pageNum-1}]</a>
		<a href="?start=${page.pageNum+1}">[下一页${page.pageNum+1}]</a> <a
			href="?start=${page.pages}">[末 页${page.pages}]</a>
	</div>
	<br>
	<form action="categories" method="post">

		name: <input name="name"> <br>
		<button type="submit">添加</button>

	</form>

	<form id="formdelete" action="" method="POST">
		<input type="hidden" name="_method" value="DELETE">
	</form>
</div>