package com.myssm.paul.pojo;

public class Map {
    private double x;
    private double y;
    private String content;

    public Map(double x,double y,String content){
        this.x=x;
        this.y=y;
        this.content=content;
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
