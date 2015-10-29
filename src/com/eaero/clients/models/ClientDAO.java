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

package com.eaero.clients.models;

import com.eaero.clients.Client;
import com.eaero.DataAccessObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAO extends DataAccessObject 
{
    private String table = "clients";
    
    private ArrayList<Client> toList(ResultSet resultset) throws SQLException
    {
        ArrayList<Client> list = new ArrayList<>();
        
        while(resultset.next()) 
        {
            Client item = new Client();
            
            item.setId(resultset.getInt("id"));
            item.setEmail(resultset.getString("email"));
            item.setFirstName(resultset.getString("firstName"));
            item.setLastName(resultset.getString("lastName"));
            item.setBirthdate(resultset.getDate("birthdate"));
            item.setDocument(resultset.getString("document"));
            item.setFidelity(resultset.getInt("fidelity"));
           
            list.add(item);
        }
        
        resultset.close();
        
        return list;
    }

    public void create(Client item)  throws SQLException
    {
        try (PreparedStatement stmt = this.query("INSERT INTO " + this.table + " (email, firstName, lastName, birthdate, document, fidelity) VALUES (?,?,?,?,?,?)")) 
        {
            stmt.setString(1, item.getEmail());
            stmt.setString(2, item.getFirstName());
            stmt.setString(3, item.getLastName());
            stmt.setDate(4, item.getBirthdate());
            stmt.setString(5, item.getDocument());
            stmt.setInt(6, item.getFidelity());
            stmt.execute();
            stmt.close();
        } 
    }

    public ArrayList<Client> read() throws SQLException 
    {
        ArrayList<Client> list;
        
        try (PreparedStatement stmt = this.query("SELECT * FROM " + this.table)) 
        {
            ResultSet rs = stmt.executeQuery();
            list = this.toList(rs);
        }
        
        return list;
    }

    public void update(Client item) throws SQLException 
    {
        try(PreparedStatement stmt = this.query("UPDATE " + this.table + " SET email=?, firstName=?, lastName=?, birthdate=?, document=?, fidelity=? WHERE id=?")) 
        {
            stmt.setString(1, item.getEmail());
            stmt.setString(2, item.getFirstName());
            stmt.setString(3, item.getLastName());
            stmt.setDate(4, item.getBirthdate());
            stmt.setString(5, item.getDocument());
            stmt.setInt(6, item.getFidelity());
            stmt.setInt(7, item.getId());
            stmt.execute();
            stmt.close();
        }
    }

    public void delete(Client item) throws SQLException 
    {
        try(PreparedStatement stmt = this.query("DELETE FROM " + this.table + " WHERE id=?")) 
        {
            stmt.setInt(1, item.getId());
            stmt.execute();
            stmt.close();
        }
    }
    
    private ArrayList<Client> find(String query) throws SQLException 
    {
        ArrayList<Client> list;
        
        try(PreparedStatement stmt = this.query(query))
        {
            ResultSet rs = stmt.executeQuery();
            list = this.toList(rs);
            stmt.close();
        }
        
        return list;
    }
    
    public Client findById(Integer id) throws SQLException 
    {
        ArrayList<Client> result = this.find("SELECT * FROM " + this.table + " WHERE id = " + id + " LIMIT 1");
        
        return (result.size() > 0) ? result.get(0) : null;
    }
    
    public Client findByEmail(String email) throws SQLException 
    {
        ArrayList<Client> result = this.find("SELECT * FROM " + this.table + " WHERE email = '" + email + "' LIMIT 1");
        
        return (result.size() > 0) ? result.get(0) : null;
    }
    
    public int fetchFidelityPoints(int client_id) throws SQLException
    {
        int points = 0;
        
        try(PreparedStatement stmt = this.query("SELECT fidelity FROM " + this.table + " WHERE id =? LIMIT 1"))
        {
            stmt.setInt(1, client_id);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                points = rs.getInt("fidelity");
            }
            
        }
        
        return points;
    }
    
    public void updateFidelityPoints(int client_id, int points) throws SQLException
    {
        try(PreparedStatement stmt = this.query("UPDATE " + this.table + " SET fidelity=? WHERE id=?"))
        {
            stmt.setInt(1, points);
            stmt.setInt(2, client_id);
            
            stmt.execute();
            stmt.close();
        }
    }
    
    public void addFidelityPoints(int client_id, int points) throws SQLException
    {
        int p = this.fetchFidelityPoints(client_id) + points;
        this.updateFidelityPoints(client_id, p);
    }
    
    public void removeFidelityPoints(int client_id, int points) throws SQLException
    {
        int p = this.fetchFidelityPoints(client_id) - points;
        this.updateFidelityPoints(client_id, p);
    }
    
}
