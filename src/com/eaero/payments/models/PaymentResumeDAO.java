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
import com.eaero.payments.PaymentResume;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentResumeDAO extends DataAccessObject
{
    private String table = "payments";
    
    public ArrayList<PaymentResume> getResume(int status) throws SQLException 
    {
        ArrayList<PaymentResume> list = new ArrayList<>();
        
        try(PreparedStatement stmt = this.query("SELECT  payment.id AS payment_id," + 
                " payment.status AS payment_status, method.label AS method_name, " +
                " status.label AS status_name, ticket.id AS ticket_id, " + 
                " ticket.number AS ticket_number, ticket.firstClass AS ticket_firstClass, " + 
                "flight.cost AS flight_cost, flight.date AS flight_date, flight.hour AS flight_hour, " + 
                "client.firstName AS client_firstname, client.lastName AS client_lastname, itinerary.departure AS departure, " + 
                "itinerary.destination AS destination FROM aeroapp.payments AS payment " + 
                "LEFT JOIN payments_methods AS method ON method.id =  payment.method_id " + 
                "LEFT JOIN payments_statuses AS status ON status.id = payment.status " + 
                "LEFT JOIN tickets AS ticket ON ticket.id = payment.ticket_id " + 
                "LEFT JOIN flights AS flight ON flight.id = ticket.flight_id " + 
                "LEFT JOIN clients AS client ON client.id = ticket.client_id " + 
                "LEFT JOIN itineraries AS itinerary ON itinerary.id = flight.itinerary_id " +
                "WHERE payment.status = " + status + ";")){
            
                ResultSet rs = stmt.executeQuery();

                while(rs.next())
                {
                    PaymentResume resume = new PaymentResume();
                    resume.setId(rs.getInt("payment_id"));
                    resume.setStatus(rs.getInt("payment_status"));
                    resume.setStatusName(rs.getString("status_name"));
                    resume.setClientFirstName(rs.getString("client_firstname"));
                    resume.setClientLastName(rs.getString("client_lastname"));
                    resume.setDeparture(rs.getString("departure"));
                    resume.setDestination(rs.getString("destination"));
                    resume.setFlightCost(rs.getDouble("flight_cost"));
                    resume.setFlightDate(rs.getDate("flight_date"));
                    resume.setFlightHour(rs.getTime("flight_hour"));
                    resume.setMethodName(rs.getString("method_name"));
                    resume.setTicketFirstClass(rs.getInt("ticket_firstClass"));
                    resume.setTicketId(rs.getInt("ticket_id"));
                    resume.setTicketNumber(rs.getString("ticket_number"));
                    
                    list.add(resume);
                }
            
                stmt.close();
        }
        
        return list;
    }
    
    public void changeStatusById(Integer id, Integer status) throws SQLException
    {
        try(PreparedStatement stmt = this.query("UPDATE " + this.table + " SET status=? WHERE id=?"))
        {
            stmt.setInt(1, status);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
        }
    }
}
