package com.interview.demoproblemtest.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.interview.demoproblemtest.Model.EventModel;
import com.interview.demoproblemtest.Model.Solution;
import com.interview.demoproblemtest.Repository.EventDao;
import com.interview.demoproblemtest.Repository.SolutionDao;

@RestController
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventModel eventmodel;
	
	@Autowired
	private EventDao eventdao;
	
	@Autowired
	private SolutionDao solutiondao;
	
	@RequestMapping(value="/getallevents", method=RequestMethod.GET)
	public List<EventModel> getAllEvent() {
		
		
		
		return eventdao.findAll();
		
	}
	
	@RequestMapping(value="/postEvent/",method=RequestMethod.POST)
	public EventModel postEvent(@RequestBody EventModel eventmodel) {
		
		
		
		List<Solution> solutions=eventmodel.getSolutions();
		
		eventdao.save(eventmodel);
		for(Solution solution:solutions) {
			solution.setEventmodel(eventmodel);
			solutiondao.save(solution);
		}
		
		return eventmodel;
		
	}
	
	@RequestMapping(value="/geteventbyid/{id}",method=RequestMethod.GET)
	public EventModel getEventById(@PathVariable int id) {
		
		 EventModel eventmodel2=eventdao.findOne(id);
		 System.out.println(eventmodel2);
		return eventdao.findOne(id);
		
		
	}
	
	@RequestMapping(value="/requesttwoevents/{id1}/and/{id2}",method=RequestMethod.GET)
	public List<EventModel> getEventById(@PathVariable int id1,@PathVariable int id2) {
		 
		List<EventModel> twoEvents=new ArrayList<>();
		twoEvents.add(eventdao.findOne(id1));
		twoEvents.add(eventdao.findOne(id2));
		
		return twoEvents;
		
		
	}
	
	
	
	

}
