package it.blog.springmongobookingflight;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import it.blog.springmongobookingflight.entity.Flight;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import static org.hamcrest.Matchers.*;

@WebAppConfiguration
@ContextConfiguration(locations="classpath:mongoBookingFlight-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FlightTest {

	private MockMvc mockMvc;
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
	@Autowired
    private WebApplicationContext webAppContext;
	
	@Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webAppContext).build();        
        if (mongoTemplate.collectionExists(Flight.class)) {
        	mongoTemplate.dropCollection(Flight.class);
            mongoTemplate.createCollection(Flight.class);
        }
    }
	
	@Test
	public void addFlightTest() throws Exception {
		long yourmilliseconds = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");    
		Date resultdate = new Date(yourmilliseconds);
		
		/*
		 * Build the Flight test
		 */
		Flight flight = new Flight();
		
		flight.setFlightCode("U23211");
		flight.setDepartureTime(resultdate);
		flight.setFrom("London Gatwick");
		flight.setTo("Milan Malpensa");
		flight.setGate("22");
		/*
		 * Build the request
		 */
		RequestBuilder request = post("/flight").param("flightCode", flight.getFlightCode())
				.param("from", flight.getFrom())
				.param("to", flight.getTo())
				.param("gate", flight.getGate())
				.param("departureTime", sdf.format(flight.getDepartureTime()))
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		
		/*
		 * Call the page
		 */
		mockMvc.perform(request)
	            .andExpect(status().isOk())
	            .andExpect(model().attribute("flights", hasSize(1)))
	            .andExpect(model().attribute("flights", hasItem(
                        allOf(
                                hasProperty("flightCode", is(flight.getFlightCode()))
                        )
                )))

	            .andDo(print());	   
	            
	}
	
}
