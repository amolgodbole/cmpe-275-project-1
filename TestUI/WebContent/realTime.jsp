
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.data.entity.*" %>
<%@page import="com.data.entity.Stockdata"%>
<%@ page import = "java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Real Time Feeds</title>
</head>
<body>
<form>
<center> Hi! Welcome to the Real Time Page </center>
<br>
<br>

<br>
<center> The current Values of Stock are:</center>
<br>
<table align = "center"  border = 1>
<tr><td colspan ="2"><h2 align = "center"><font color="blue">Stock Data</font></h2></td></tr>

<tr>
	<td align = "center" width = "100px"><b>Stock Ticker</b></td>
 	<td align = "center" width = "100px"><b>Current Value</b></td>
 	
 </tr> 
 </table>

<center>
 <table>
<tr>
	<td>
	<table align = "center">
 	<tr>            
 	<%
 					
             		Stockdata[] allStocks = (Stockdata[])request.getAttribute("stockData");
             	 		int count= allStocks.length;
             	 		for(int i=0; i< allStocks.length; i++){
             	%>
 	<td align = "center" width = "100px" height = "50px"><%= allStocks[i].getId().getTicker()%></td>
  	<td align = "center" width = "100px" height = "50px"><%= allStocks[i].getOpen() %></td>
	<% }%>
	</tr>
</table>
</center>
</form>
<a href= "home.jsp">Back</a> </body>
</html>