package it.blog.springmongobookingflight.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class Flight {

	@Id
	private String flightCode;	
	
	@Indexed(direction = IndexDirection.ASCENDING)
	private String from;
	
	@Indexed(direction = IndexDirection.ASCENDING)
	private String to;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date departureTime;
	
	private String gate;
	
	private List<Passenger> passenger;
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	
	@Override
	public boolean equals(Object other){
		return (this.flightCode == ((Flight)other).flightCode) && 
				(this.from == ((Flight)other).from) &&
				(this.to == ((Flight)other).to) &&
				(this.departureTime == ((Flight)other).departureTime);
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
}
