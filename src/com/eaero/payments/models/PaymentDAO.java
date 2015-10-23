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
package com.eaero.payments.models;

import com.eaero.models.DataAccessObject;
import com.eaero.payments.Payment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAO extends DataAccessObject {
    private String table = "payments";
    
    private ArrayList<Payment> toList(ResultSet resultset) throws SQLException{
        ArrayList<Payment> list = new ArrayList<>();
        
        while(resultset.next()) {
            Payment item = new Payment();
            item.setId(resultset.getInt("id"));
            item.setMethodId(resultset.getInt("method_id"));
            item.setStatusId(resultset.getInt("status_id"));
            item.setTicketId(resultset.getInt("ticket_id"));
            list.add(item);
        }
        
        resultset.close();
        
        return list;
    }

    public void create(Payment item)  throws SQLException{
        try (PreparedStatement stmt = this.query("INSERT INTO " + this.table + " (method_id, status_id, ticket_id) VALUES (?,?,?)")) 
        {
            stmt.setInt(1, item.getMethodId());
            stmt.setInt(2, item.getStatusId());
            stmt.setInt(3, item.getTicketId());
                
            stmt.execute();
            stmt.close();
        } 
    }

    public ArrayList<Payment> read() throws SQLException {
        ArrayList<Payment> item;
        try (PreparedStatement stmt = this.query("SELECT * FROM " + this.table)) 
        {
            ResultSet rs = stmt.executeQuery();
            item = this.toList(rs);
        }
        
        return item;
    }

    public void update(Payment item) throws SQLException {
        try(PreparedStatement stmt = this.query("UPDATE " + this.table + " SET method_id=?, ticket_id=?, status_id=? WHERE id=?")) 
        {
            stmt.setInt(1, item.getMethodId());
            stmt.setInt(2, item.getTicketId());
            stmt.setInt(3, item.getStatusId());
            stmt.setInt(4, item.getId());
            
            stmt.execute();
            stmt.close();
        }
    }

    public void delete(Payment item) throws SQLException {
        try(PreparedStatement stmt = this.query("DELETE FROM " + this.table + " WHERE id=?")) 
        {
            stmt.setInt(1, item.getId());
            
            stmt.execute();
            stmt.close();
        }
    }
    
    private ArrayList<Payment> find(String query) throws SQLException {
        ArrayList<Payment> results;
        try(PreparedStatement stmt = this.query(query)){
            
            ResultSet rs = stmt.executeQuery();
            results = this.toList(rs);
            stmt.close();
        }
        
        return results;
    }
    
    public Payment findById(Integer id) throws SQLException {
        return this.find("SELECT * FROM " + this.table + " WHERE id = " + id + " LIMIT 1").get(0);
    }
    
    public Payment findByTicket(Integer ticket_id) throws SQLException {
        return this.find("SELECT * FROM " + this.table + " WHERE ticket_id = " + ticket_id + " LIMIT 1").get(0);
    }
   
}
