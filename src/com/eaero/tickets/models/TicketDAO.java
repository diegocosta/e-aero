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
package com.eaero.tickets.models;

import com.eaero.models.DataAccessObject;
import com.eaero.tickets.Ticket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TicketDAO extends DataAccessObject {
    private String table = "tickets";
    
    private ArrayList<Ticket> toList(ResultSet resultset) throws SQLException{
        ArrayList<Ticket> list = new ArrayList<>();
        
        while(resultset.next()) {
            Ticket item = new Ticket();
            item.setId(resultset.getInt("id"));
            item.setClientId(resultset.getInt("client_id"));
            item.setFirstClass(resultset.getBoolean("firstClass"));
            item.setNumber(resultset.getString("number"));
            item.setFlightId(resultset.getInt("flight_id"));
            
            list.add(item);
        }
        
        resultset.close();
        
        return list;
    }

    public void create(Ticket item)  throws SQLException{
        try (PreparedStatement stmt = this.query("INSERT INTO " + this.table + " (number, firstClass, flight_id, client_id) VALUES (?,?,?,?)")) 
        {
            stmt.setString(1, item.getNumber());
            stmt.setBoolean(2, item.getFirstClass());
            stmt.setInt(3, item.getFlightId());
            stmt.setInt(4, item.getClientId());
                
            stmt.execute();
            stmt.close();
        } 
    }

    public ArrayList<Ticket> read() throws SQLException {
        ArrayList<Ticket> item;
        try (PreparedStatement stmt = this.query("SELECT * FROM " + this.table)) 
        {
            ResultSet rs = stmt.executeQuery();
            item = this.toList(rs);
        }
        
        return item;
    }

    public void update(Ticket item) throws SQLException {
        try(PreparedStatement stmt = this.query("UPDATE " + this.table + " SET number=?, firstClass=?, flight_id=?, client_id=? WHERE id=?")) 
        {
            stmt.setString(1, item.getNumber());
            stmt.setBoolean(2, item.getFirstClass());
            stmt.setInt(3, item.getFlightId());
            stmt.setInt(4, item.getClientId());
            stmt.setInt(5, item.getId());
            
            stmt.execute();
            stmt.close();
        }
    }

    public void delete(Ticket item) throws SQLException {
        try(PreparedStatement stmt = this.query("DELETE FROM " + this.table + " WHERE id=?")) 
        {
            stmt.setInt(1, item.getId());
            
            stmt.execute();
            stmt.close();
        }
    }
    
    private ArrayList<Ticket> find(String query) throws SQLException {
        ArrayList<Ticket> results;
        try(PreparedStatement stmt = this.query(query)){
            
            ResultSet rs = stmt.executeQuery();
            results = this.toList(rs);
            stmt.close();
        }
        
        return results;
    }
    
    public Ticket findById(Integer id) throws SQLException {
        return this.find("SELECT * FROM " + this.table + " WHERE id = " + id + " LIMIT 1").get(0);
    }
    
    public Ticket findByFlight(Integer flight_id) throws SQLException {
        return this.find("SELECT * FROM " + this.table + " WHERE flight_id = " + flight_id + " LIMIT 1").get(0);
    }
   
}
