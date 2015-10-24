/*
 * The MIT License
 *
 * Copyright 2015 Jeferson.
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

import com.eaero.flights.Flight;
import com.eaero.models.DataAccessObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FlightDAO extends DataAccessObject {
    private String table = "flights";
    
    private ArrayList<Flight> toList(ResultSet resultset) throws SQLException{
        ArrayList<Flight> list = new ArrayList<>();
        
        while(resultset.next()) {
            Flight item= new Flight();
            item.setId(resultset.getInt("id"));
            item.setCost(resultset.getDouble("cost"));
            item.setHour(resultset.getTime("hour"));
            item.setItineraryId(resultset.getInt("itinery_id"));
              item.setAircraftId(resultset.getInt("aircraft_id"));
            item.setRoutineId(resultset.getInt("routine_id"));
            
            list.add(item);
        }
        
        resultset.close();
        
        return list;
    }

    public void create(Flight item)  throws SQLException{
        try (PreparedStatement stmt = this.query("INSERT INTO " + this.table + " (cost, hour, itinerary_id,aircraft_id, routine_id) values (?,?,?,?,?)")) 
        {
            stmt.setDouble(1, item.getCost());
            stmt.setTime(2,item.getHour());
            stmt.setInt(3, item.getItineraryId());
            stmt.setInt(4, item.getAircraftId());
            stmt.setInt(5, item.getRoutineId());
                
            stmt.execute();
        } 
    }

    public ArrayList<Flight> read() throws SQLException {
        ArrayList<Flight> flights;
        try (PreparedStatement stmt = this.query("SELECT * FROM " + this.table)) 
        {
            ResultSet rs = stmt.executeQuery();
            flights = this.toList(rs);
        }
        
        return flights;
    }

    public void update(Flight item) throws SQLException {
        try(PreparedStatement stmt = this.query("UPDATE " + this.table + " SET cost=?, hour=?, itinerary_id=?, aircraft_id=?, routine_id=? WHERE id=?")) 
        {
            stmt.setDouble(1, item.getCost());
            stmt.setTime(2,item.getHour());
            stmt.setInt(3, item.getItineraryId());
            stmt.setInt(4, item.getAircraftId());
            stmt.setInt(5, item.getRoutineId());
            stmt.setInt(6, item.getId());
                
            stmt.execute();
            stmt.close();
        }
    }

    public void delete(Flight item) throws SQLException {
        try(PreparedStatement stmt = this.query("DELETE FROM " + this.table + " WHERE id=?")) 
        {
            stmt.setInt(1, item.getId());
            
            stmt.execute();
            stmt.close();
        }
    }
    
    private ArrayList<Flight> find(String query) throws SQLException {
        ArrayList<Flight> list;
        try(PreparedStatement stmt = this.query(query))
        {    
            ResultSet rs = stmt.executeQuery();
            list = this.toList(rs);
            stmt.close();
        }
        
        return list;
    }
    
    public Flight findById(Integer id) throws SQLException {
        return this.find("SELECT * FROM " + this.table + " WHERE id = " + id + " LIMIT 1").get(0);
    }
    
    public Flight findByItineraryId(Integer itineraryId) throws SQLException {
        return this.find("SELECT * FROM " + this.table + " WHERE itinerary_id= '" + itineraryId + "' LIMIT 1").get(0);
    }
    
}
