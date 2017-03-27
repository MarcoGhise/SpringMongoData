package it.blog.springmongobookingflight.controller;

import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;

import java.util.ArrayList;
import java.util.List;

import it.blog.springmongobookingflight.entity.Flight;
import it.blog.springmongobookingflight.entity.Passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MongoFlightController {

	@Autowired
    private MongoTemplate mongoTemplate;
	
	@RequestMapping(value = "/flight")
    public ModelAndView addFlight(@ModelAttribute Flight newFlight, Model model) {
        
		if (newFlight.getFlightCode() != null)
			/*
			 * Insert Flight
			 */
	        mongoTemplate.insert(newFlight);
        
        /*
         * Load all the flights
         */
        List<Flight> flights = mongoTemplate.findAll(Flight.class);
        
        model.addAttribute("flights", flights);        
        /*
         * Load the template
         */
        return new ModelAndView("flight", "command", new Flight());
        
    }
	
	@RequestMapping(value = "/passenger")
    public ModelAndView addPassenger(@ModelAttribute Passenger newPassenger, Model model) {
        
		/*
		 * Look for the flight
		 */
		Query querySelect = new Query();
		querySelect.addCriteria(Criteria.where("flightCode").is(newPassenger.getFlightCode()));
    	
		Flight flight = mongoTemplate.findOne(querySelect, Flight.class);
		/*
		 * Check the existence 
		 */
		if (flight != null && newPassenger.getName()!=null)
		{
			List<Passenger> passengers = flight.getPassenger();			
			/*
			 * New one if list is empty 
			 */
			if (passengers == null)
				passengers = new ArrayList<Passenger>();
			
			/*
			 * Generate the ticketNumber
			 */
			newPassenger.setTicketNumber(randomAlphanumeric(5));
			/*
			 * Insert passenger 
			 */
			mongoTemplate.insert(newPassenger);
			
			passengers.add(newPassenger);	
			flight.setPassenger(passengers);			
	    	/*
			 * Insert passenger on the flight
			 */
	    	mongoTemplate.save(flight);	    	
		}
		/*
		 * Show the flight
		 */
        model.addAttribute("flight", flight);        
        /*
         * Load the template
         */
        return new ModelAndView("passenger", "command", new Passenger(flight.getFlightCode()));
        
    }
	
	@RequestMapping(value = "/passengerDetail")
    public String viewPassenger(@ModelAttribute Passenger requestPassenger, Model model) {
        
		/*
		 * Look for the Passenger
		 */
		Query querySelect = new Query();
		querySelect.addCriteria(Criteria.where("flightCode").is(requestPassenger.getFlightCode()));
		querySelect.addCriteria(Criteria.where("ticketNumber").is(requestPassenger.getTicketNumber()));
    	
		Passenger passenger = mongoTemplate.findOne(querySelect, Passenger.class);
		
		/*
		 * Show the Passenger details
		 */
        model.addAttribute("passenger", passenger);        
        /*
         * Load the template
         */
        return "passengerDetail";
        
    }

}
