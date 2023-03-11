package main_package.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import main_package.airlineInterface.AirlineMethods;
import main_package.model.Airline;
import main_package.repository.AirlineRepository;

@Service
public class AirlineMethodsDefinitions implements AirlineMethods {
	 AirlineRepository airlineReposit;

	 public AirlineMethodsDefinitions( AirlineRepository airlineReposit) {
			this.airlineReposit=airlineReposit;
			
		}
	 
	 public Airline createAirlineDetails(Airline details) {
		 return  airlineReposit.save(details);
	 }
	 
	public List<Airline>   displayAllAirlineDetails(){
		return  airlineReposit.findAll();
		}
	
	public	 Airline  displayByAirlineId(int airline_id) {
		Optional<Airline> airline_detail = airlineReposit. findById(airline_id);
		if(airline_detail.isPresent()) {
			return airline_detail.get();
		}
		else {
			return null;
		}
	}

		
		public Airline updateByAirlineId(Airline  update_details, int airline_id) {
			Optional<Airline> updateAirline_detail  = airlineReposit.findById(airline_id);
			if(updateAirline_detail.isPresent()) {
				Airline existingAirline = updateAirline_detail.get(); 

				 existingAirline.setSource(update_details.getSource());
				 existingAirline. setDestination(update_details.getDestination());
				 existingAirline. setSeatingCapacity(update_details.getSeatingCapacity());
				 existingAirline.setCost (update_details.getCost());
				 airlineReposit.save( existingAirline);
				return  existingAirline;
			}
			else {
				return null;
			}
		}
		public String  deleteByAirlineId( int airline_id) {
			Optional<Airline> deleteAirline_detail =  airlineReposit.findById(airline_id);
			if(deleteAirline_detail .isPresent()) {
				 airlineReposit.deleteById( airline_id);
		           return "deleted successfully";
			
			}	
			else {
				return "not found";
			}
		}
}
