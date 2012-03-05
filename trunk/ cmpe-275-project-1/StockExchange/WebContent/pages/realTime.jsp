<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Real Time Feeds</title>
</head>
<body>
<f:view>
<h:form id="realTime">
Hi! Welcome to the Real Time Page
<br>
<br>
<h:commandButton value="Get Data" action="#{stockDataMB.}" />
<br>
The current Values of Stock are:
<br>
<h:dataTable border="1" value="#{stockData.}" var="var">
	<h:column id="column1">
		<f:facet name="header">
			<h:outputText value="Ticker"></h:outputText>
		</f:facet>
		<h:outputText value="#{var.}"></h:outputText>
	</h:column>

	<h:column id="column3">
		<f:facet name="header">
			<h:outputText value="Open"></h:outputText>
		</f:facet>
		<h:outputText value="#{var}"></h:outputText>
	</h:column>
	<h:column id="column3">
		<f:facet name="header">
			<h:outputText value="High"></h:outputText>
		</f:facet>
		<h:outputText value="#{var}"></h:outputText>
	</h:column>
	<h:column id="column4">
		<f:facet name="header">
			<h:outputText value="Low"></h:outputText>
		</f:facet>
		<h:outputText value="#{var}"></h:outputText>
	</h:column>
	<h:column id="column5">
		<f:facet name="header">
			<h:outputText value="Close"></h:outputText>
		</f:facet>
		<h:outputText value="#{var}"></h:outputText>
	</h:column>
		<h:column id="column6">
		<f:facet name="header">
			<h:outputText value="Volume"></h:outputText>
		</f:facet>
		<h:outputText value="#{var}"></h:outputText>
	</h:column>
	
	</h:dataTable>


<h:commandLink value="Back" action="home">
</h:commandLink>
</h:form>
</f:view>
</body>
</html>