<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Passenger Detail</title>
</head>
<body bgcolor="#ffda95">
	<table cellpadding="0" cellspacing="2" width="800"
		style="font-family: Verdana, Geneva, sans-serif; font-size: 12px; background-color: #ffda95;">

		<tr>
			<td
				style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">Flight Code</td>
			<td
				style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">Ticket
				Number</td>
			<td
				style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">Name</td>
			<td
				style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">Seat</td>
			<td
				style="background-color: #fe9901; color: #FFF; height: 20px; border: 1px solid #666; padding: 0 5px 0 10px;">Smoker</td>
		</tr>
		<tr>
			<td
				style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">${passenger.flightCode}</td>
			<td
				style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">${passenger.ticketNumber}</td>
			<td
				style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">${passenger.name}</td>
			<td
				style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">${passenger.seat}</td>
			<td
				style="background-color: #fff; height: 20px; border: 1px solid #333; padding: 0 5px 0 10px;">${passenger.smoker}</td>
		</tr>

　
	</table>
</body>
