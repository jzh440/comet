<html>
<head>
<title>starting page</title>
<script type="text/javascript" src="./dwr/engine.js"></script>
<script type="text/javascript" src="./dwr/util.js"></script>
<script type="text/javascript" src="./dwr/interface/Message.js"></script>
<script type="text/javascript">
	function sendMessage() {
		var message = $("message").value;
		Message.addMessage(message);
	}
	function receiveMessages(messages) {
		var chatlog = "";
		for ( var data in messages) {
			chatlog = "<div>" + dwr.util.escapeHtml(messages[data]) + "</div>" + chatlog;
		}
		dwr.util.setValue("list", chatlog, {
			escapeHtml : false
		});
	}
</script>
</head>
<body onload="dwr.engine.setActiveReverseAjax(true);">
	input message:
	<input id="message" type="text" />
	<input type="button" value="send" onclick="sendMessage()" />
	<br>
	<div id="list"></div>
</body>
</html>