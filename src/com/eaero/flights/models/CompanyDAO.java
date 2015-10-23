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

import com.eaero.flights.Company;
import com.eaero.models.DataAccessObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyDAO extends DataAccessObject {
    private String table = "companies";
    
    private ArrayList<Company> toList(ResultSet resultset) throws SQLException{
       ArrayList<Company> list = new ArrayList<>();
       
       while(resultset.next()){
           Company item = new Company();
           
           item.setId(resultset.getInt("id"));
           item.setName(resultset.getString("name"));
           item.setDocument(resultset.getString("document"));
           
           list.add(item);
       }
        
        resultset.close();
        
        return list;
    }
    
    public void create(Company item) throws SQLException{
        try(PreparedStatement stmt = this.query("INSERT INTO " + this.table + " (name,document) VALUES (?,?)"))
        {
            stmt.setString(1,item.getName());
            stmt.setString(2,item.getDocument());
            
            stmt.execute();
            stmt.close();
        }
    }
    
    public ArrayList<Company> read() throws SQLException {
        ArrayList<Company> list;
        
        try(PreparedStatement stmt = this.query("SELECT * FROM " + this.table))
        {
            ResultSet rs = stmt.executeQuery();
            list = this.toList(rs);
        }
        
        return list;
    }
    
    public void  update(Company item) throws SQLException {
        
        try(PreparedStatement stmt = this.query("UPDATE " + this.table + "SET name = ?, document = ? WHERE id = ?"))
        {
           stmt.setString(1,item.getName());
           stmt.setString(2,item.getDocument());
           stmt.setInt(3,item.getId());
           stmt.execute();
           stmt.close();
           
        }
    }
    
    public void delete(Company item) throws SQLException {
        try(PreparedStatement stmt = this.query("DELETE FROM " + this.table + " WHERE id = ?"))
        {
            stmt.setInt(1, item.getId());
            stmt.execute();
            stmt.close();
        }
    }
   
    private ArrayList<Company> find(String query) throws SQLException {
        ArrayList<Company> list;
        
        try(PreparedStatement stmt =  this.query(query))
        {
            ResultSet rs = stmt.executeQuery();
            list = this.toList(rs);
            
            stmt.close();
        }
        return list;
    }
    
    public Company findById(Integer id) throws SQLException {
       return this.find("SELECT * FROM " + this.table + " WHERE id = " + id + " LIMIT 1").get(0);
    }
    
}
