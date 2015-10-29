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
import com.eaero.payments.Payment;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDAO extends DataAccessObject
{
    private String table = "payments";
    
    public void create(Payment item) throws SQLException
    {
        try (PreparedStatement stmt = this.query("INSERT INTO " + this.table + " (ticket_id, method_id, status_id) VALUES (?,?,?)")) 
        {
            stmt.setInt(1, item.getTicketId());
            stmt.setInt(2, item.getMethodId());
            stmt.setInt(3, item.getStatus());
            stmt.execute();
            stmt.close();
        } 
    }
}
