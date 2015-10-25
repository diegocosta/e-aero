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
import com.eaero.tickets.TicketResume;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TicketResumeDAO extends DataAccessObject 
{
    public ArrayList<TicketResume> search(String email, String code) throws SQLException
    {
        ArrayList<TicketResume> list = new ArrayList<>();
        
        String superQuery = "SELECT " +
                    "ticket.id AS id, " +
                    "ticket.number AS ticket_code, " +
                    "ticket.firstClass AS firstClass, " +
                    "client.firstName AS firstName, " +
                    "client.lastName AS lastName, " +
                    "client.email AS email, " +
                    "flight.hour AS hour, " +
                    "routines.days AS date, " +
                    "itinerary.departure AS departure, " +
                    "itinerary.destination AS destination, " +
                    "itinerary.duration AS duration, " +
                    "aircraft.code AS aircraft, " +
                    "company.name AS company " +
                    "FROM tickets AS ticket " +
                    "LEFT JOIN clients AS client ON client.id = ticket.client_id " +
                    "LEFT JOIN flights AS flight ON flight.id = ticket.flight_id " +
                    "LEFT JOIN flights_routines AS routines ON flight.routine_id = routines.id " +
                    "LEFT JOIN itineraries AS itinerary ON flight.itinerary_id = itinerary.id " +
                    "LEFT JOIN aircrafts AS aircraft ON flight.aircraft_id = aircraft.id " +
                    "LEFT JOIN companies AS company ON aircraft.company_id = company.id " +
                    "WHERE client.email LIKE '%" + email + "%' AND ticket.number LIKE '%"+ code +"%';";
        
            try(PreparedStatement stmt = this.query(superQuery)){
               ResultSet result = stmt.executeQuery();

               while(result.next())
               {
                   TicketResume resume = new TicketResume();
                   resume.setId(result.getInt("id"));
                   resume.setTicketCode(result.getString("ticket_code"));
                   resume.setFirstClass(result.getBoolean("firstClass"));
                   resume.setFirstName(result.getString("firstName"));
                   resume.setLastName(result.getString("lastName"));
                   resume.setEmail(result.getString("email"));
                   resume.setHour(result.getTime("hour"));
                   resume.setDate(result.getString("date"));
                   resume.setDeparture(result.getString("departure"));
                   resume.setDestination(result.getString("destination"));
                   resume.setDuration(result.getDouble("duration"));
                   resume.setAircraft(result.getString("aircraft"));
                   resume.setCompany(result.getString("company"));
                   
                   list.add(resume);
               }

           }
       
       return list;
    }
    
    public TicketResume getResume(String code) throws SQLException
    {  
        TicketResume resume = new TicketResume();
        
        String superQuery = "SELECT " +
                    "ticket.id AS id, " +
                    "ticket.number AS ticket_code, " +
                    "ticket.firstClass AS firstClass, " +
                    "client.firstName AS firstName, " +
                    "client.lastName AS lastName, " +
                    "client.email AS email, " +
                    "flight.hour AS hour, " +
                    "routines.days AS date, " +
                    "itinerary.departure AS departure, " +
                    "itinerary.destination AS destination, " +
                    "itinerary.duration AS duration, " +
                    "aircraft.code AS aircraft, " +
                    "company.name AS company " +
                    "FROM tickets AS ticket " +
                    "LEFT JOIN clients AS client ON client.id = ticket.client_id " +
                    "LEFT JOIN flights AS flight ON flight.id = ticket.flight_id " +
                    "LEFT JOIN flights_routines AS routines ON flight.routine_id = routines.id " +
                    "LEFT JOIN itineraries AS itinerary ON flight.itinerary_id = itinerary.id " +
                    "LEFT JOIN aircrafts AS aircraft ON flight.aircraft_id = aircraft.id " +
                    "LEFT JOIN companies AS company ON aircraft.company_id = company.id " +
                    "WHERE ticket.number = '" + code + "'";
        
            try(PreparedStatement stmt = this.query(superQuery)){
               ResultSet result = stmt.executeQuery();

               while(result.next())
               {
                   resume.setId(result.getInt("id"));
                   resume.setTicketCode(result.getString("ticket_code"));
                   resume.setFirstClass(result.getBoolean("firstClass"));
                   resume.setFirstName(result.getString("firstName"));
                   resume.setLastName(result.getString("lastName"));
                   resume.setEmail(result.getString("email"));
                   resume.setHour(result.getTime("hour"));
                   resume.setDate(result.getString("date"));
                   resume.setDeparture(result.getString("departure"));
                   resume.setDestination(result.getString("destination"));
                   resume.setDuration(result.getDouble("duration"));
                   resume.setAircraft(result.getString("aircraft"));
                   resume.setCompany(result.getString("company"));
               }

           }
       
       return resume;
    }
}
