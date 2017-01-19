<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品更新</title>
</head>
<body>
	<div>
		<h1>修改商品信息</h1>
		<form action="xupdate" method="post">
			<!-- name 里面的值，必须带上前缀xGoods.goodName，不然不会自动封装，需要手动去getter和setter -->
			名称:<input type="text" name="goodName" value="${byGoodID.goodName }"> <br>
			价格:<input type="text" name="goodPrice" value="${byGoodID.goodPrice }"> <br>
			数量:<input type="text" name="goodNumber" value="${byGoodID.goodNumber }"> <br>
			信息:<input type="text" name="goodInfo" value="${byGoodID.goodInfo }"> <br>
			<input type="submit" value="提交">
			<!-- <input type="reset" value="重置"><br> -->
			<input type="hidden" name="goodID" value="${byGoodID.goodID }">
	</form>
	</div>
</body>
</html>