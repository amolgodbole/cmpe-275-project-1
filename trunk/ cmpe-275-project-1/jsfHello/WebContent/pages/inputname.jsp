<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript">
   function fnsubmit() {
	document. forms[0].submit();
  }
</script>
<script type="text/javascript">
function mandatoryvalidate(){
	var len1=document.getElementById("form1:#####").value;
	var len2=document.getElementById("form1:#####").value;
		
	if(len1.length<1){
		alert(" id is mandatory");
		return false;
	}
	else if(len2.length<1){
		alert(" is mandatory");
		return false;
	}


	var rad=document.forms[0]["form1:$$$$$$"];
	var flag=false;
	var size=rad.length;
	for(var i=0;i<size;i++){
		if(rad[i].checked==true)
		flag=true;
		break;
	}
	if(flag==false){
		alert("is mandatory");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<f:view>
<h:form id="greeting">
Please enter a name:
<h:inputText id="name" value="#{personBean.name}"/>
<h:commandButton value=" Say Hello " action="greeting"/>
</h:form>
<br>
<h:form id="stock">

<br>
 We can Dynamically Populate using the below code:

<h:selectOneMenu value="#{stockBean.stockId}" onchange="fnsubmit()" valueChangeListener="#{stockBean.stockReport}">
<f:selectItem itemLabel="-select-"/>
<f:selectItems value="#{stockBean.stockList}"/>
</h:selectOneMenu>

<h:commandButton action="someBean.submitButton" value="Get Live Feed"/>
<br>
The value of the stock <h:outputText value="#{stockBean.stockName}"/> is: <h:outputText value="#{stockBean.stockPrice}"/>
<br>
To Display the Stock Values:
<br>
<h:dataTable border="1" value="#{}" var="var">
	<h:column id="column1">
		<f:facet name="header">
			<h:outputText value="Date"></h:outputText>
		</f:facet>
		<h:outputText value="#{var}"></h:outputText>
	</h:column>
	<h:column id="column2">
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
	
	Select the type of Data you want: 
	<h:selectOneRadio value="#{stockFormat.type}" required="true" id="radio">
		<f:selectItem itemLabel="Daily" itemValue="daily" />
		<br>
		<f:selectItem itemLabel="Monthly" itemValue="monthly" />
		<br>
		<f:selectItem itemLabel="Historical" itemValue="history" />
		<br>
		<h:message for="radio">Some Error Message if not selected</h:message>
	</h:selectOneRadio>
	
	Select the Format of Data you want: 
	<h:selectOneRadio value="#{stockFormat.type}" required="true" id="radio">
		<f:selectItem itemLabel="JSON" itemValue="json" />
		<br>
		<f:selectItem itemLabel="CSV" itemValue="csv" />
		<br>
		<f:selectItem itemLabel="XML" itemValue="xml" />
		<br>
		<h:message for="radio">Some Error Message if not selected</h:message>
	</h:selectOneRadio>
	
	
   <div align="right">
   Stupid Login Module: Ignore if not needed:
<h:form>
<h:panelGrid border="0" columns="2">
	<h:outputText value="UserName"></h:outputText>
	<h:inputText value="" required="true" requiredMessage=""></h:inputText>
	
	<h:outputText value="Password"></h:outputText>
	<h:inputSecret value="" required="true" requiredMessage=""></h:inputSecret>
	
	<h:outputText value="Some Text"></h:outputText>
	<h:inputText value="" required="true" requiredMessage=""></h:inputText>
</h:panelGrid>
</h:form>
</div>


</h:form>
</f:view>
</body>
</html>