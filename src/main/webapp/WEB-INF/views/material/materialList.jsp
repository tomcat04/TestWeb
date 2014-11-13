<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="<c:url value="/js/libs/jquery/jquery.js" />"></script>
        <script type="text/javascript" src="<c:url value="/js/libs/jqueryui/jquery-ui.js" />"></script>
        <title>Insert title here1666</title>
    </head>
    <body>
        <h1>hello world</h1>
        ${s}
        <br>
        <div id="state"></div>
        <script type="text/javascript">
            $(function () {
                var t = 0;
                (function longPolling() {
                    var _self = arguments.callee;
                    $.ajax({
                        url: "${pageContext.request.contextPath}/async/response-body",
                        data: {"timed": new Date().getTime()},
                        dataType: "text",
                        timeout: 10000,
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            $("#state").text("[state: " + textStatus + ", error: " + errorThrown + " ]<br/>");
                            if (textStatus == "timeout") { // 请求超时
                                $("#state").text("请求超时");
                                longPolling(); // 递归调用
                            } else if(textStatus == "error"){
                                $("#state").text("服务器出错了");
                            } else { // 其他错误，如网络错误等
                                longPolling();
                            }
                        },
                        success: function(data, textStatus) {
                            $("#state").text("[state: " + textStatus + ", data: { " + data + "} ]<br/>");
                            if (textStatus == "success") { // 请求成功
                                //longPolling();
                                t ++;
                                if(t>10){
                                    location.reload();
                                }
                                _self();
                            }
                        }
                    });
                })();

            });
        </script>
    </body>
</html>