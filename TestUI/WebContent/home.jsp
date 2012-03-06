<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Please select the type of Request:
<br>
<br>

<p>
<form id="form3" method="post" action="DownloadLink"> 
	<div class="form-row">
		<center>
            <input name ="Download" class="submit" type="submit" value="Download data">
        </center>
	</div>  
</form>
<form id ="form4" method="post" action="RealTimeData">
	<div class="form">
		<center>
            <input name ="RealTimeFeeds" class="submit" type="submit" value="Real Time Feeds">
        </center>
	</div>  
</form>

</body>
</html>