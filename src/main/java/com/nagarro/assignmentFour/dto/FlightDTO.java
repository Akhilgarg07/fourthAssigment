package com.nagarro.assignmentFour.dto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.assignmentFour.entity.Flight;


@Repository
public interface FlightDTO extends CrudRepository<Flight,Integer>{

}