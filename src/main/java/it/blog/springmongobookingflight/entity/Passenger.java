package it.blog.springmongobookingflight.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Passenger {

	@Id
	private String ticketNumber;
	
	@Indexed(direction = IndexDirection.ASCENDING)
	private String name;
	
	private String seat;
	
	private boolean smoker;
	
	private Payment payment;
	
	private String flightCode;
	
	public Passenger(){}
	
	public Passenger(String flightCode)
	{
		this.flightCode = flightCode;
	}
	
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	public boolean isSmoker() {
		return smoker;
	}
	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public String getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
}
