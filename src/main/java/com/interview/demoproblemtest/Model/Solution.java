package com.interview.demoproblemtest.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
public class Solution implements Serializable {

	@Id
	private Integer solutionId;

	private String solutionDescription;

	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@NotFound(
	        action = NotFoundAction.IGNORE)
	
	@JoinColumn(name="EventModel_id",nullable=false)
	@JsonIgnore
	private EventModel eventmodel;

	public Solution(Integer solutionId, String solutionDescription, EventModel eventmodel) {
		super();
		this.solutionId = solutionId;
		this.solutionDescription = solutionDescription;
		this.eventmodel = eventmodel;
	}
	

	public Solution(Integer solutionId, String solutionDescription) {
		super();
		this.solutionId = solutionId;
		this.solutionDescription = solutionDescription;
	}


	public Solution() {
		
	}

	@Override
	public String toString() {
		return "Solution [solutionId=" + solutionId + ", solutionDescription=" + solutionDescription + "]";
	}

	public Integer getSolutionId() {
		return solutionId;
	}

	public void setSolutionId(Integer solutionId) {
		this.solutionId = solutionId;
	}

	public String getSolutionDescription() {
		return solutionDescription;
	}

	public void setSolutionDescription(String solutionDescription) {
		this.solutionDescription = solutionDescription;
	}

	public EventModel getEventmodel() {
		return eventmodel;
	}

	public void setEventmodel(EventModel eventmodel) {
		this.eventmodel = eventmodel;
	}

}
