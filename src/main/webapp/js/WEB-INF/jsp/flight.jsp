<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
<script src="http://mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.js" type="text/javascript"></script>
<link href="http://mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
		$(function(){
			$('*[name=departureTime]').appendDtpicker();
		});
  </script>
<title>Flight</title>
</head>
<body bgcolor="#ffda95">
	<form:form method="POST" action="flight">
		<table cellpadding="0" cellspacing="2" width="800"
			style="font-family: Verdana, Geneva, sans-serif; font-size: 12px; background-color: #ffda95;">
			<tr>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;"><form:label
						path="flightCode">Code</form:label></td>
				<td
					style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;"><form:input
						path="flightCode" size="10" /></td>
			</tr>
			<tr>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;"><form:label
						path="from">From</form:label></td>
				<td
					style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;"><form:input
						path="from" size="20" /></td>
			</tr>
			<tr>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;"><form:label
						path="to">To</form:label></td>
				<td
					style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;"><form:input
						path="to" size="20" /></td>
			</tr>
			<tr>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;"><form:label
						path="gate">Gate</form:label></td>
				<td
					style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;"><form:input
						path="gate" size="20" /></td>
			</tr>
			<tr>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;"><form:label
						path="departureTime">Departure Time</form:label></td>
				<td
					style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;"><form:input
						path="departureTime" size="20" /></td>
			</tr>
			<tr>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">&nbsp;</td>
				<td
					style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;"><input
					type="submit" value="Add Fligth" /></td>
			</tr>
		</table>
	</form:form>

		<table cellpadding="0" cellspacing="2" width="800"
			style="font-family: Verdana, Geneva, sans-serif; font-size: 12px; background-color: #ffda95;">
			
			<tr>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">Code</td>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">From</td>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">To</td>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">Departure Time</td>
			</tr>	
				
			<c:forEach var="flight" items="${flights}">
					
				<tr>					
					<td style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;"><a href="passenger?flightCode=${flight.flightCode}">${flight.flightCode}</a></td>
					<td style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">${flight.from}</td>
					<td style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">${flight.to}</td>
					<td style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">${flight.departureTime}</td>
				</tr>
				
			</c:forEach>
		</table>
</body>
