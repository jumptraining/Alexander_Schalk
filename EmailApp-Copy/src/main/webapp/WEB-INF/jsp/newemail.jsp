<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/style.css" rel="stylesheet">
<link href="myText.css" rel="stylesheet" type="text/css">

<HTML>
<head>
<title>ToDo App</title>
</head>
<body>

Create a new email:<br>

<form:form method = "post" modelAttribute = "newemail">
	<fieldset class = "form-group">
		Email address:<br>
		<input type = "text" name = "emailAddress" required = "required"/> <br>
		<form:errors path = "email" 
		cssClass = "text=warning"/>

		Subject:<br>
		<input type = "text" name = "emailSubject" required = "required"/> <br>
		<form:errors path = "email" 
		cssClass = "text=warning"/>

		Message:<br>
		<textarea rows="6" cols="80" type = "text" name = "emailMessage" required = "required">
		<form:errors path = "email" 
		cssClass = "text=warning"/>
		</textarea> <br>

  		Attachment:<br>
  		<input type = "file" name = "emailAttachment"><br>
		<form:errors path = "email" 
		cssClass = "text=warning"/>	

	</fieldset>
	<input type = "submit"/>
</form:form>

<%@ include file="common/footer.jspf" %>

</body>
</HTML>