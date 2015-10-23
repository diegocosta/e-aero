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

import com.eaero.tickets.Note;
import com.eaero.models.DataAccessObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoteDAO extends DataAccessObject {
    private String table = "notes";
    
    private ArrayList<Note> toList(ResultSet resultset) throws SQLException{
        ArrayList<Note> list = new ArrayList<>();
        
        while(resultset.next()) {
            Note item = new Note();
            item.setCategoryId(resultset.getInt("category_id"));
            item.setText(resultset.getString("text"));
            item.setTicketId(resultset.getInt("ticket_id"));
            
            list.add(item);
        }
        
        resultset.close();
        
        return list;
    }

    public void create(Note item)  throws SQLException{
        try (PreparedStatement stmt = this.query("SELECT INTO " + this.table + " (category_id, text, ticket_id) values (?,?,?)")) 
        {
            stmt.setInt(1, item.getCategoryId());
            stmt.setString(2, item.getText());
            stmt.setInt(3, item.getTicketId());
            
            stmt.execute();
            stmt.close();
        } 
    }

    public ArrayList<Note> read() throws SQLException {
        ArrayList<Note> list;
        try (PreparedStatement stmt = this.query("SELECT * FROM " + this.table)) 
        {
            ResultSet rs = stmt.executeQuery();
            list = this.toList(rs);
        }
        
        return list;
    }

    public void update(Note item) throws SQLException {
        try(PreparedStatement stmt = this.query("UPDATE " + this.table + " SET category_id = ?, text = ?, ticket_id = ? WHERE id=?")) 
        {
            stmt.setInt(1, item.getCategoryId());
            stmt.setString(2, item.getText());
            stmt.setInt(3, item.getTicketId());
            stmt.setInt(4, item.getId());
            
            stmt.execute();
            stmt.close();
        }
    }

    public void delete(Note item) throws SQLException {
        try(PreparedStatement stmt = this.query("DELETE FROM " + this.table + " WHERE id=?")) 
        {
            stmt.setInt(1, item.getId());
            
            stmt.execute();
            stmt.close();
        }
    }
    
    private ArrayList<Note> find(String query) throws SQLException {
        ArrayList<Note> list;
        try(PreparedStatement stmt = this.query(query))
        {
            ResultSet rs = stmt.executeQuery();
            list = this.toList(rs);
            
            stmt.close();
        }
        
        return list;
    }
    
    public Note findById(Integer id) throws SQLException {
        return this.find("SELECT * FROM " + this.table + " WHERE id = " + id + " LIMIT 1").get(0);
    }
    
    public ArrayList<Note> findByTicketId(int ticket_id) throws SQLException {
        return this.find("SELECT * FROM " + this.table + " WHERE ticket_id = " + ticket_id);
    }
}
