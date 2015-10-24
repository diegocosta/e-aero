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

import com.eaero.flights.FlightResult;
import com.eaero.models.DataAccessObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FlightResultDAO extends DataAccessObject {
    
    private ArrayList<FlightResult> toList(ResultSet resultset) throws SQLException{
        ArrayList<FlightResult> list = new ArrayList<>();
        
        while(resultset.next()) {
            FlightResult item = new FlightResult();
            item.setId(resultset.getInt("id"));
            item.setCost(resultset.getDouble("cost"));
            item.setHour(resultset.getTime("hour"));
            item.setCompanyName(resultset.getString("company_name"));
            item.setRoutineDay(resultset.getString("routine_day"));
            item.setAircraftCode(resultset.getString("aircraft_code"));
            item.setDeparture(resultset.getString("departure"));
            item.setDestination(resultset.getString("destination"));
            list.add(item);
        }
        
        resultset.close();
        
        return list;
    }
    
    private ArrayList<FlightResult> find(String query) throws SQLException {
        ArrayList<FlightResult> list;
        try(PreparedStatement stmt = this.query(query))
        {    
            ResultSet rs = stmt.executeQuery();
            list = this.toList(rs);
            stmt.close();
        }
        
        return list;
    }
    
    public ArrayList<FlightResult> search(String departure, String destination, String date)  throws SQLException
    {
        ArrayList<FlightResult> result;
        
        String superQuery = "SELECT " +
                            "flights.id," +
                            "flights.hour," +
                            "flights.cost, " +
                            "routines.days AS routine_day," +
                            "company.name AS company_name," +
                            "aircraft.code as aircraft_code, " +
                            "itinerary.departure AS departure, " +
                            "itinerary.destination AS destination " +
                            "FROM flights AS flights " +
                            "LEFT JOIN flights_routines AS routines ON flights.routine_id = routines.id " +
                            "LEFT JOIN itineraries AS itinerary ON flights.itinerary_id = itinerary.id " +
                            "LEFT JOIN aircrafts AS aircraft ON flights.aircraft_id = aircraft.id " +
                            "LEFT JOIN companies AS company ON aircraft.company_id = company.id " +
                            "WHERE itinerary.departure LIKE '%" + departure + "%' " +
                            "AND itinerary.destination LIKE '%" + destination + "%' " +
                            "AND routines.days LIKE '%"+ date +"%';";
        
        result = this.find(superQuery);
        
        return result;
    }
}
