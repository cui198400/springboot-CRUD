<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品操作页面</title>
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<style type="text/css">
	td{
		width: 40px;
	}
</style>

<script type="text/javascript">
function update(){
	 //$("p").Toggle();
}
</script>
</head>
<body>
		<h1>显示商品信息</h1>
		<table>
			<tr>
				<td>ID</td>
				<td>名称</td>
				<td>价格</td>
				<td>数量</td>
				<td>信息</td>
				<td>操作</td>
			</tr>
			
				<c:forEach items="${goods}" var="good">
				<tr>
				<td>${good.goodID}</td>
				<td>${good.goodName}</td>
				<td>${good.goodPrice}</td>
				<td>${good.goodNumber}</td>
				<td>${good.goodInfo}</td>
				<td>
					<a href="/delete?goodID=${good.goodID}">删除</a>
					<a href="/findByGoodID?goodID=${good.goodID}">修改</a>
					<!-- <span onclick="update">修改</span> -->
				</td>
				</tr>
				</c:forEach>
		
		</table><!-- 不能放大括号后面，不然不运算 -->
			<a href="findAll?currentPage=${currentPage-1}">上一页</a>
        	<a href="findAll?currentPage=${currentPage+1}">下一页</a>
	
	<div class="add">
	<h1>添加商品信息</h1>
	<form id="add" action="save" method="post">
		名称:<input type="text" name=goodName> <br> 
		价格:<input type="text" name="goodPrice"> <br>
		数量:<input type="text" name="goodNumber"><br>
		信息:<input type="text" name="goodInfo"><br>
		<input type="submit" value="提交" class="submit"><br>
	</form>
	</div>
	
	<div class="select">
		<h1>查询商品信息</h1>
		<form action="findByKey" method="post">
			<select name="key">  
	  			<option value ="goodName">名称</option>  
	  			<option value ="goodPrice">价格</option>  
	  			<option value="goodNumber">数量</option>
	  			<option value="goodInfo">信息</option>
	  			
			</select>
			<input type="text" name="xvalue"><br>
			<input type="submit" value="确定" class="submit"><br>
		</form> 
	</div>
	
	
	
	
</body>
</html>