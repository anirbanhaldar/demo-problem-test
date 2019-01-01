package com.interview.demoproblemtest.Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Component
@Entity
public class EventModel implements Serializable {
	
	@Id
	private Integer id;
	
	private String name;
	
	@JsonIgnore
	private Date time;
	
	private String description;
	
	@OneToMany(mappedBy="eventmodel")
	@NotFound(
	        action = NotFoundAction.IGNORE)
	private List<Solution> solutions;
	

	public EventModel() {
		
	}

	public EventModel(Integer id,String name, Date time, String description, List<Solution> solutions) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.description = description;
		this.solutions = solutions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}
	

	
	
	
	
	
	

}
