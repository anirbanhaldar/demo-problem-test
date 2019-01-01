package com.interview.demoproblemtest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.demoproblemtest.Model.Solution;

@Repository
public interface SolutionDao extends JpaRepository<Solution,Integer> {

	public List<Solution> findAll();
}
