package com.example.admintrainline;

public class PriceHelper {
    String Train,First,Second,Thired;

    public PriceHelper(){

    }

    public PriceHelper(String train, String first, String second, String thired) {
        Train = train;
        First = first;
        Second = second;
        Thired = thired;
    }

    public String getTrain() {
        return Train;
    }

    public void setTrain(String train) {
        Train = train;
    }

    public String getFirst() {
        return First;
    }

    public void setFirst(String first) {
        First = first;
    }

    public String getSecond() {
        return Second;
    }

    public void setSecond(String second) {
        Second = second;
    }

    public String getThired() {
        return Thired;
    }

    public void setThired(String thired) {
        Thired = thired;
    }
}
