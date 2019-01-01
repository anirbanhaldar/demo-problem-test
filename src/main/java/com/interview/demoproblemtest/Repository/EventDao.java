package com.interview.demoproblemtest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.demoproblemtest.Model.EventModel;

@Repository
public interface EventDao extends JpaRepository<EventModel,Integer>{
	
	public List<EventModel> findAll();
	
	
	
	
	
	

}
