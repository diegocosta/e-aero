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
import com.eaero.payments.PaymentStatus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentStatusDAO extends DataAccessObject {
    private String table = "payments_statuses";
    
    private ArrayList<PaymentStatus> toList(ResultSet resultset) throws SQLException{
        ArrayList<PaymentStatus> list = new ArrayList<>();
        
        while(resultset.next()) {
            PaymentStatus item = new PaymentStatus();
            item.setId(resultset.getInt("id"));
            item.setStatus(resultset.getString("status"));
            list.add(item);
        }
        
        resultset.close();
        
        return list;
    }
    
    public ArrayList<PaymentStatus> read() throws SQLException {
        ArrayList<PaymentStatus> item;
        try (PreparedStatement stmt = this.query("SELECT * FROM " + this.table)) 
        {
            ResultSet rs = stmt.executeQuery();
            item = this.toList(rs);
        }
        
        return item;
    }
    
    private ArrayList<PaymentStatus> find(String query) throws SQLException {
        ArrayList<PaymentStatus> results;
        try(PreparedStatement stmt = this.query(query)){
            
            ResultSet rs = stmt.executeQuery();
            results = this.toList(rs);
            stmt.close();
        }
        
        return results;
    }
    
    public PaymentStatus findById(Integer id) throws SQLException {
        return this.find("SELECT * FROM " + this.table + " WHERE id = " + id + " LIMIT 1").get(0);
    }
}
