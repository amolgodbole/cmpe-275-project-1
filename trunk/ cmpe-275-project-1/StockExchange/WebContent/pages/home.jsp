<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Stock data !</title>
</head>
<body>
<f:view>
<h:form id="home">
Please select the type of Request:
<br>
<br>

<h:commandLink action="realTime" value="Get Real Time Data" />
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
<h:commandLink action="download" value="Download Data" />

</h:form>
</f:view>
</body>
</html>