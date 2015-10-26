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

package com.eaero.flights;

import java.sql.Date;
import java.sql.Time;

public class FlightResume {
    
    private int flightId;
    private Time flightHour;
    private Double flightCost;
    private Date flightDate;
    private int aircraftId;
    private String aircraftCode;
    private int aircraftSeats;
    private int aircraftSeatsFistClass;
    private int companyId;
    private String companyName;
    private int itineraryID;
    private String itineraryCode;
    private String itineraryDeparture;
    private String itineraryDestination;
    private Double itineraryDuration;
    private int routineId;
    private String routineDays;
    private int ticketsSale;
    private int ticketsSaleFirstClass;

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Time getFlightHour() {
        return flightHour;
    }

    public void setFlightHour(Time flightHour) {
        this.flightHour = flightHour;
    }

    public Double getFlightCost() {
        return flightCost;
    }

    public void setFlightCost(Double flightCost) {
        this.flightCost = flightCost;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public int getAircraftSeats() {
        return aircraftSeats;
    }

    public void setAircraftSeats(int aircraftSeats) {
        this.aircraftSeats = aircraftSeats;
    }

    public int getAircraftSeatsFistClass() {
        return aircraftSeatsFistClass;
    }

    public void setAircraftSeatsFistClass(int aircraftSeatsFistClass) {
        this.aircraftSeatsFistClass = aircraftSeatsFistClass;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getItineraryID() {
        return itineraryID;
    }

    public void setItineraryID(int itineraryID) {
        this.itineraryID = itineraryID;
    }

    public String getItineraryCode() {
        return itineraryCode;
    }

    public void setItineraryCode(String itineraryCode) {
        this.itineraryCode = itineraryCode;
    }

    public String getItineraryDeparture() {
        return itineraryDeparture;
    }

    public void setItineraryDeparture(String itineraryDeparture) {
        this.itineraryDeparture = itineraryDeparture;
    }

    public String getItineraryDestination() {
        return itineraryDestination;
    }

    public void setItineraryDestination(String itineraryDestination) {
        this.itineraryDestination = itineraryDestination;
    }

    public Double getItineraryDuration() {
        return itineraryDuration;
    }

    public void setItineraryDuration(Double itineraryDuration) {
        this.itineraryDuration = itineraryDuration;
    }

    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routineId) {
        this.routineId = routineId;
    }

    public String getRoutineDays() {
        return routineDays;
    }

    public void setRoutineDays(String routineDays) {
        this.routineDays = routineDays;
    }

    public int getTicketsSale() {
        return ticketsSale;
    }

    public void setTicketsSale(int ticketsSale) {
        this.ticketsSale = ticketsSale;
    }

    public int getTicketsSaleFirstClass() {
        return ticketsSaleFirstClass;
    }

    public void setTicketsSaleFirstClass(int ticketsSaleFirstClass) {
        this.ticketsSaleFirstClass = ticketsSaleFirstClass;
    }
    
    public int getCostInPoints()
    {
        return this.getCostInPoints(this.flightCost);
    }
    
    public int getCostInPoints(double cost)
    {
        return (int) cost * 2;
    }
    
    public double getCostFirstClass()
    {
        return this.getCostFirstClass(this.flightCost);
    }
    
    public double getCostFirstClass(double cost)
    {
        return cost + (cost * 0.4);
    }
    
}
