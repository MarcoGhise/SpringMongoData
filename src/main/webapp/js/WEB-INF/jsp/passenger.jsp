<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Passenger</title>
</head>
<body bgcolor="#ffda95">
	<table cellpadding="0" cellspacing="2" width="800"
		style="font-family: Verdana, Geneva, sans-serif; font-size: 12px; background-color: #ffda95;">
		<tr>
			<td
				style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">Code</td>
			<td
				style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">${flight.flightCode}</td>
		</tr>
		<tr>
			<td
				style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">From</td>
			<td
				style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">${flight.from}</td>
		</tr>
		<tr>
			<td
				style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">To</td>
			<td
				style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">${flight.to}</td>
		</tr>
		<tr>
			<td
				style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">Gate</td>
			<td
				style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">${flight.gate}</td>
		</tr>
		<tr>
			<td
				style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">Departure Time</td>
			<td
				style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">${flight.departureTime}</td>
		</tr>		
	</table>
		
	<form:form method="POST" action="passenger">
		<form:hidden path="flightCode"/>
	
		<table cellpadding="0" cellspacing="2" width="800"
			style="font-family: Verdana, Geneva, sans-serif; font-size: 12px; background-color: #ffda95;">
			<tr>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;"><form:label
						path="name">Name</form:label></td>
				<td
					style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;"><form:input
						path="name" size="30" /></td>
			</tr>
			<tr>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;"><form:label
						path="seat">Seat</form:label></td>
				<td
					style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;"><form:input
						path="seat" size="20" /></td>
			</tr>
			<tr>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;"><form:label
						path="smoker">Smoker</form:label></td>
				<td
					style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">
					<form:checkbox path="smoker" /></td>
			</tr>
			<tr>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;"><form:label
						path="payment">Payment</form:label></td>
				<td
					style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">
					<form:select path="payment"><form:option value="Paypal"/><form:option value="CreditCard"/><form:option value="Check"/><form:option value="BankWire"/></form:select></td>
			</tr>
			<tr>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">&nbsp;</td>
				<td
					style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;"><input
					type="submit" value="Add Passenger" /></td>
			</tr>
		</table>
	</form:form>

		<table cellpadding="0" cellspacing="2" width="800"
			style="font-family: Verdana, Geneva, sans-serif; font-size: 12px; background-color: #ffda95;">
			
			<tr>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">Ticket Number</td>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">Name</td>
				<td
					style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">Seat</td>				
			</tr>	
				
			<c:forEach var="passenger" items="${flight.passenger}">
					
				<tr>					
					<td style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;"><a href="passengerDetail?ticketNumber=${passenger.ticketNumber}&flightCode=${flight.flightCode}">${passenger.ticketNumber}</a></td>
					<td style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">${passenger.name}</td>
					<td style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">${passenger.seat}</td>					
				</tr>
				
			</c:forEach>
		</table>
</body>
