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
    <script type="text/javascript" src="${pageContext.request.contextPath }/dwr/interface/ChatService.js"></script>
    <script type="text/javascript">
    
        function send() {
        	var title = dwr.util.getValue("title");
        	var body = dwr.util.getValue("body");alert(body);
            var msg = encodeURIComponent(title + body);alert(msg);
            ChatService.sendMessage(msg);
        }
 
        function showMessage(data) {
            dwr.util.setValue("info",data);
        }
    </script>
  </head>
  
  <body onload="dwr.engine.setActiveReverseAjax(true);">
      <textarea rows="20" cols="60" id="info" readonly="readonly"></textarea>
      <hr/>
        
消息头： <input type="text" id="title"/><br/>
消息体：  <textarea rows="5" cols="30" id="body"></textarea>
      <input type="button" value=" Send " onclick="send()" style="height: 85px; width: 85px;"/>
  </body>
</html>