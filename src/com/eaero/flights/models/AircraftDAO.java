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

import com.eaero.flights.Aircraft;
import com.eaero.DataAccessObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AircraftDAO extends DataAccessObject {
    private final String table = "aircrafts";
    
    private ArrayList<Aircraft> toList(ResultSet resultset) throws SQLException{
        ArrayList<Aircraft> list = new ArrayList<>();
        
        while(resultset.next()) {
            Aircraft item = new Aircraft();
            
            item.setId(resultset.getInt("id"));
            item.setCode(resultset.getString("code"));
            item.setSeats(resultset.getInt("seats"));
            item.setCompanyId(resultset.getInt("company_id"));
            item.setSeatsFirstClass(resultset.getInt("seatsFirstClass"));
            
            list.add(item);
        }
        
        resultset.close();
        
        return list;
    }

    public void create(Aircraft item)  throws SQLException{
        try (PreparedStatement stmt = this.query("INSERT INTO " + this.table + " (code,seats,company_id,seatsFirstClass) values (?,?,?,?)")) 
        {
            stmt.setString(1, item.getCode());
            stmt.setInt(2,item.getSeats());
            stmt.setInt(3, item.getCompanyId());
            stmt.setInt(4, item.getSeatsFirstClass());

            stmt.execute();
        } 
    }

    public ArrayList<Aircraft> read() throws SQLException {
        ArrayList<Aircraft> list;
        try (PreparedStatement stmt = this.query("SELECT * FROM " + this.table)) 
        {
            ResultSet rs = stmt.executeQuery();
            list = this.toList(rs);
        }
        
        return list;
    }

    public void update(Aircraft item) throws SQLException {
        try(PreparedStatement stmt = this.query("UPDATE " + this.table + " code=?, seats=?, company_id=?, seatsFirstClass=? WHERE id = ?")) 
        {
            stmt.setString(1, item.getCode());
            stmt.setInt(2,item.getSeats());
            stmt.setInt(3, item.getCompanyId());
            stmt.setInt(4, item.getSeatsFirstClass());
            stmt.setInt(5, item.getId());
                
            stmt.execute();
            stmt.close();
        }
    }

    public void delete(Aircraft aircraft) throws SQLException {
        try(PreparedStatement stmt = this.query("DELETE FROM " + this.table + " WHERE id=?")) 
        {
            stmt.setInt(1, aircraft.getId());
            
            stmt.execute();
            stmt.close();
        }
    }
    
    private ArrayList<Aircraft> find(String query) throws SQLException {
        ArrayList<Aircraft> list;
        try(PreparedStatement stmt = this.query(query))
        {    
            ResultSet rs = stmt.executeQuery();
            list = this.toList(rs);
            stmt.close();
        }
        
        return list;
    }
    
    public Aircraft findById(Integer id) throws SQLException {
        return this.find("SELECT * FROM " + this.table + " WHERE id = " + id + " LIMIT 1").get(0);
    }
    
    public Aircraft findByCode(String code) throws SQLException {
        ArrayList<Aircraft> result = this.find("SELECT * FROM " + this.table + " WHERE code= '" + code + "' LIMIT 1");
        return (result.size() > 0) ? result.get(0) : null;
    }
    
    public ArrayList<Aircraft> findByCompany(Integer company_id) throws SQLException {
        return this.find("SELECT * FROM " + this.table + " WHERE company_id = " + company_id);
    }
}
