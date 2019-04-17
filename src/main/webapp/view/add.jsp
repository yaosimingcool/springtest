<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head >
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" >
</head>
<body>


<h1>添加商品</h1>
<form action="${pageContext.request.contextPath}/product/add" method="get" >
    商品名称:<input type="text" name="name"><br/>
    商品价格:<input type="text" name="price"><br/>
    商品描述:<input type="text" name="description"><br/>
    <%--商品图片:<input type="file" name="path"><br/>--%>
    商品状态:<input type="text" name="state"><br/>
    <%--商品上产日期:<input type="text" name="bir"><br/>--%>
    商品产地:<input type="text" name="address"><br/>
    <input type="submit" value="提交"><br/>
</form>


</body>
</html>
