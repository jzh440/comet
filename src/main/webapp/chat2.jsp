<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Chat</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <script type="text/javascript" src="${pageContext.request.contextPath }/dwr/engine.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/dwr/util.js"></script>
    <script type="text/javascript">
        function showMessage(data) {
            dwr.util.setValue("info",data);
        }
    </script>
  </head>
  
  <body onload="dwr.engine.setActiveReverseAjax(true);">
      <textarea rows="20" cols="60" id="info" readonly="readonly"></textarea>
      <hr/>
  </body>
</html>