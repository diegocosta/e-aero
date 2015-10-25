/*
 * The MIT License
 *
 * Copyright 2015 Diego.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.eaero.flights.models;

import com.eaero.flights.FlightResume;
import com.eaero.models.DataAccessObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightResumeDAO extends DataAccessObject {
    
    public FlightResume getResume(int flight_id) throws SQLException
    {
        FlightResume resume = new FlightResume();
        
        String superQuery = "SELECT " +
            "flight.id AS flight_id, " +
            "flight.hour  AS flight_hour, " +
            "flight.cost AS flight_cost, " +
            "aircraft.id AS aircraft_id, " +
            "aircraft.code AS aircraft_code, " +
            "aircraft.seats AS aircraft_seats, " +
            "aircraft.seatsFirstClass AS aircraft_firstclass, " +
            "company.id AS company_id, " +
            "company.name AS company_name, " +
            "itinerary.id AS itinerary_id, " +
            "itinerary.code AS itinerary_code, " +
            "itinerary.departure AS itinerary_departure, " +
            "itinerary.destination AS itinerary_destination, " +
            "itinerary.duration AS itinerary_duration, " +
            "routines.id AS routine_id, " +
            "routines.days AS routine_days, " +
            "(SELECT COUNT(*) FROM tickets WHERE tickets.flight_id = flight.id AND tickets.firstClass = 0) AS tickets_sale, " +
            "(SELECT COUNT(*) FROM tickets WHERE tickets.flight_id = flight.id AND tickets.firstClass = 1) AS tickets_sale_firstclass " +
            "FROM flights AS flight " +
            "LEFT JOIN aircrafts AS aircraft ON flight.aircraft_id = aircraft.id " +
            "LEFT JOIN companies AS company ON aircraft.company_id = company.id " +
            "LEFT JOIN itineraries AS itinerary ON flight.itinerary_id = itinerary.id " +
            "LEFT JOIN flights_routines AS routines ON flight.routine_id = routines.id " +
            "WHERE flight.id = " + flight_id +
            ";";
    
       try(PreparedStatement stmt = this.query(superQuery)){
           ResultSet result = stmt.executeQuery();
           
           while(result.next())
           {
               resume.setFlightId(result.getInt("flight_id"));
                resume.setFlightHour(result.getTime("flight_hour"));
                resume.setFlightCost(result.getDouble("flight_cost"));
                resume.setAircraftId(result.getInt("aircraft_id"));
                resume.setAircraftCode(result.getString("aircraft_code"));
                resume.setAircraftSeats(result.getInt("aircraft_seats"));
                resume.setAircraftSeatsFistClass(result.getInt("aircraft_firstclass"));
                resume.setCompanyId(result.getInt("company_id"));
                resume.setCompanyName(result.getString("company_name"));
                resume.setItineraryID(result.getInt("itinerary_id"));
                resume.setItineraryCode(result.getString("itinerary_code"));
                resume.setItineraryDeparture(result.getString("itinerary_departure"));
                resume.setItineraryDestination(result.getString("itinerary_destination"));
                resume.setItineraryDuration(result.getDouble("itinerary_duration"));
                resume.setRoutineId(result.getInt("routine_id"));
                resume.setRoutineDays(result.getString("routine_days"));
                resume.setTicketsSale(result.getInt("tickets_sale"));
                resume.setTicketsSaleFirstClass(result.getInt("tickets_sale_firstclass"));
           }
           
       }
       
       return resume;
    }
    
}
