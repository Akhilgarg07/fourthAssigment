package com.nagarro.assignmentFour.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.assignmentFour.entity.Flight;

@Repository
public interface FlightRepo extends CrudRepository<Flight, Integer> {

}