package com.example.admintrainline;

public class weektimehelper {
    String Date,Start,End,Arrival,Departure;

    public weektimehelper(){

    }

    public weektimehelper(String date, String start, String end, String arrival, String departure) {
        Date = date;
        Start = start;
        End = end;
        Arrival = arrival;
        Departure = departure;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    public String getArrival() {
        return Arrival;
    }

    public void setArrival(String arrival) {
        Arrival = arrival;
    }

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = departure;
    }
}
