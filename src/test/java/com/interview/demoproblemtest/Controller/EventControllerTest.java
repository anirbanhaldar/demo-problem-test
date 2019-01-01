package com.interview.demoproblemtest.Controller;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.hamcrest.text.IsEqualIgnoringCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.demoproblemtest.Model.EventModel;
import com.interview.demoproblemtest.Model.Solution;
import com.interview.demoproblemtest.Repository.EventDao;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EventDao eventdao;
	
	
	@Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

	
	
	@Test
	public void getEventbyId() throws Exception {
		
		Solution mocksolution=new Solution(100,"Say Hello");
		Solution mocksolution2=new Solution(101,"Welcome World");
		List<Solution> mocksolutions=new ArrayList<>();
		mocksolutions.add(mocksolution);
		mocksolutions.add(mocksolution2);
		
		EventModel mockEvent=new EventModel(1001,"Hello World",new Date(),"Hello",mocksolutions);
		//String example= "{\"id\":1001,\"name\":\"Hello World\",\"description\":\"Hello\",\"solutions\":[{\"solutionId\":100,\"solutionDescription\":\"Say Hello\"},{\"solutionId\":101,\"solutionDescription\":\"Welcome World\"}]},{\"id\":1002,\"name\":\"Hello My Music World\",\"description\":\"Music\",\"solutions\":[{\"solutionId\":102,\"solutionDescription\":\"Microphone\"},{\"solutionId\":103,\"solutionDescription\":\"walkman\"},{\"solutionId\":104,\"solutionDescription\":\"headphone\"}]}";
		
		Mockito.when(eventdao.findOne(Mockito.anyInt())).thenReturn(mockEvent);
		String expectedjson= this.maptoJson(mockEvent);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/event/geteventbyid/1001").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=  mockMvc.perform(requestBuilder).andReturn();
		String outputjson=result.getResponse().getContentAsString();
		
		
		assertThat(outputjson,equalTo(expectedjson));
		
		
		
	//	JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), false);
		
		
		 
	
	
	
	

}
	
	private String maptoJson(Object object) throws JsonProcessingException {
		ObjectMapper objectmapper=new ObjectMapper();
		return objectmapper.writeValueAsString(object);
		
	}
}
