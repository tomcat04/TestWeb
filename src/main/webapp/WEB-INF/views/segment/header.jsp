<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/views/segment/scriptbox.jsp"></jsp:include>
<link href="<%=request.getContextPath()%>/static/images/wms.ico" rel="icon" type="image/x-icon" />
<body>
页眉<br/>
<a href="<%=request.getContextPath()%>/">主页</a><br>
<a href="<%=request.getContextPath()%>/materials/">物料</a><br>
</body>
</html>