/*
 * The MIT License
 *
 * Copyright 2015 Eugênio.
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

import com.eaero.flights.Itinerary;
import com.eaero.models.DataAccessObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItineraryDAO extends DataAccessObject{
    private String table = "itineraries";
    
    private ArrayList<Itinerary> toList(ResultSet resultset) throws SQLException{
       ArrayList<Itinerary> list = new ArrayList<>();
       
       while(resultset.next()){
           Itinerary item = new Itinerary();
           
           item.setId(resultset.getInt("id"));
           item.setCode(resultset.getString("code"));
           item.setDeparture(resultset.getString("departure"));
           item.setDestination(resultset.getString("destination"));
           item.setDuration(resultset.getDouble("duration"));
                  
           list.add(item);
       }
        
        resultset.close();
        
        return list;
    }
    
    public void create(Itinerary item) throws SQLException{
        try(PreparedStatement stmt = this.query("INSERT INTO " + this.table + " (code,departure,destination,duration) VALUES (?,?,?,?)"))
        {
            stmt.setString(1,item.getCode());
            stmt.setString(2,item.getDeparture());
            stmt.setString(3,item.getDestination());
            stmt.setDouble(4,item.getDuration());
            
            stmt.execute();
            stmt.close();
        }
    }
    
    public ArrayList<Itinerary> read() throws SQLException {
        ArrayList<Itinerary> list;
        
        try(PreparedStatement stmt = this.query("SELECT * FROM " + this.table))
        {
            ResultSet rs = stmt.executeQuery();
            list = this.toList(rs);
        }
        
        return list;
    }
    
    public void  update(Itinerary item) throws SQLException {
        
        try(PreparedStatement stmt = this.query("UPDATE " + this.table + " SET code = ?, departure = ?, destination =?, duration =? WHERE id = ?"))
        {   
           stmt.setString(1,item.getCode());
           stmt.setString(2,item.getDeparture());
           stmt.setString(3,item.getDestination());
           stmt.setDouble(4,item.getDuration());
           stmt.setInt(5,item.getId());
           
           stmt.execute();
           stmt.close();
           
        }
    }
    
    public void delete(Itinerary item) throws SQLException {
        try(PreparedStatement stmt = this.query("DELETE FROM " + this.table + " WHERE id = ?"))
        {
            stmt.setInt(1, item.getId());
            
            stmt.execute();
            stmt.close();
        }
    }
   
    private ArrayList<Itinerary> find(String query) throws SQLException {
        ArrayList<Itinerary> list;
        
        try(PreparedStatement stmt =  this.query(query))
        {
            ResultSet rs = stmt.executeQuery();
            list = this.toList(rs);
            
            stmt.close();
        }
        return list;
    }
    
    public Itinerary findById(Integer id) throws SQLException {
       return this.find("SELECT * FROM " + this.table + " WHERE id = " + id + " LIMIT 1").get(0);
    }
    
    public Itinerary findByCode(String code) throws SQLException {
        return this.find("SELECT * FROM " + this.table + " WHERE code = '" + code + "' LIMIT 1").get(0);
    }
    
    public ArrayList<Itinerary> findByDestination(String destination) throws SQLException {
        return this.find("SELECT * FROM " + this.table + " WHERE destination = '" + destination + "'");
    }
    
    public ArrayList<Itinerary> findByDeparture(String departure) throws SQLException {
        return this.find("SELECT * FROM " + this.table + " WHERE departure = '" + departure + "'");
    }
}

