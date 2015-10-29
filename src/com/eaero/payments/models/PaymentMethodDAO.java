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

import com.eaero.DataAccessObject;
import com.eaero.payments.PaymentMethod;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentMethodDAO extends DataAccessObject {
     private String table = "payments_methods";
    
    private ArrayList<PaymentMethod> toList(ResultSet resultset) throws SQLException{
        ArrayList<PaymentMethod> list = new ArrayList<>();
        
        while(resultset.next()) {
            PaymentMethod item = new PaymentMethod();
            item.setId(resultset.getInt("id"));
            item.setLabel(resultset.getString("label"));
            list.add(item);
        }
        
        resultset.close();
        
        return list;
    }
    
    public ArrayList<PaymentMethod> read() throws SQLException {
        ArrayList<PaymentMethod> item;
        try (PreparedStatement stmt = this.query("SELECT * FROM " + this.table)) 
        {
            ResultSet rs = stmt.executeQuery();
            item = this.toList(rs);
        }
        
        return item;
    }
    
    private ArrayList<PaymentMethod> find(String query) throws SQLException {
        ArrayList<PaymentMethod> results;
        try(PreparedStatement stmt = this.query(query)){
            
            ResultSet rs = stmt.executeQuery();
            results = this.toList(rs);
            stmt.close();
        }
        
        return results;
    }
    
    public PaymentMethod findById(Integer id) throws SQLException {
        ArrayList<PaymentMethod> result =  this.find("SELECT * FROM " + this.table + " WHERE id = " + id + " LIMIT 1");
        return (result.size() > 0) ? result.get(0) : null;
    }
}
