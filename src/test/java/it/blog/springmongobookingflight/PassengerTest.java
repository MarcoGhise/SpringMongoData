package it.blog.springmongobookingflight;

　
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import it.blog.springmongobookingflight.entity.Passenger;
import it.blog.springmongobookingflight.entity.Payment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.apache.commons.lang.RandomStringUtils.*;
import static org.hamcrest.Matchers.*;

@WebAppConfiguration
@ContextConfiguration(locations="classpath:mongoBookingFlight-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PassengerTest {

	private MockMvc mockMvc;
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
	@Autowired
    private WebApplicationContext webAppContext;
	
	@Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webAppContext).build();                
    }
	
	@Test
	public void addPassengerTest() throws Exception {
		
		/*
		 * Build the Passenger test
		 */
		Passenger passenger = new Passenger();
		
		passenger.setFlightCode("U23211");
		passenger.setName(randomAlphabetic(6) + " " + randomAlphabetic(6));
		passenger.setPayment(Payment.CreditCard);
		passenger.setSeat(randomNumeric(1) + randomAlphabetic(1));
		passenger.setSmoker(false);
		passenger.setTicketNumber(randomAlphanumeric(5));
		
		/*
		 * Build the request
		 */
		RequestBuilder request = post("/passenger")
				.param("flightCode", passenger.getFlightCode())
				.param("name", passenger.getName())
				.param("payment",passenger.getPayment().toString())
				.param("seat", passenger.getSeat())
				.param("smoker", String.valueOf(passenger.isSmoker()))
				.param("ticketNumber", passenger.getTicketNumber())
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		
		/*
		 * Call the page
		 */
		mockMvc.perform(request)
	            .andExpect(status().isOk())
	            .andExpect(model().attribute("flight", hasProperty("code", is(passenger.getFlightCode()))))
	            .andDo(print());	   
	            
	}
	
}
