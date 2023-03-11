package main_package.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import main_package.model.Airline;
import main_package.service.AirlineMethodsDefinitions;

@RestController
public class AirlineController {
  public 	AirlineMethodsDefinitions airline_defined;
  public AirlineController(AirlineMethodsDefinitions airline_defined) {
	  this.airline_defined= airline_defined;
  }
	@PostMapping("/saveDetails")
	public ResponseEntity<Airline> saveAirlineDetails(@RequestBody Airline details){
		return new ResponseEntity<Airline>(airline_defined.createAirlineDetails( details), HttpStatus.CREATED);
	}
	
	@GetMapping("/readAllDetails")
	public List<Airline> getAllAirlineDetails(){
		return  airline_defined.displayAllAirlineDetails();
	}
	

	@GetMapping("/readDetails/{id}")
	public ResponseEntity<Airline>  getByAirlineId(@PathVariable("id")  int airlineId){
		return new ResponseEntity<Airline>( airline_defined.displayByAirlineId(airlineId), HttpStatus.OK);
	}
	
	@PutMapping("/updateDetails/{id}")
	public ResponseEntity<Airline> updateDetails(@PathVariable("id") int airlineId,
			@RequestBody Airline details){
		return new ResponseEntity<Airline>(airline_defined.  updateByAirlineId(details,airlineId), HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteDetails/{id}")
	public ResponseEntity <String> deleteDetails(@PathVariable("id")  int airlineId){
		airline_defined. deleteByAirlineId(airlineId);
		return new ResponseEntity<String>(airline_defined. deleteByAirlineId(airlineId), HttpStatus.OK);
	}
}


