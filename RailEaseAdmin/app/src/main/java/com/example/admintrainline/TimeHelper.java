package com.example.admintrainline;

public class TimeHelper {


    String Time,Number,Start,End;

    public TimeHelper(){

    }

    public TimeHelper(String time, String number, String start, String end) {
        Time = time;
        Number = number;
        Start = start;
        End = end;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
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
}
