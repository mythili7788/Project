package main_package.airlineInterface;

import java.util.List;

import main_package.model.Airline;



public interface AirlineMethods {
	Airline createAirlineDetails(Airline details);
	List<Airline> displayAllAirlineDetails();
	Airline  displayByAirlineId(int  airline_id);
	Airline updateByAirlineId(Airline update_details, int airline_id);
	String deleteByAirlineId( int airline_id);
}
