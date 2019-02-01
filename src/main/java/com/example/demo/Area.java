package com.example.demo;

public class Area {
    private double radius;
    private double length;
    private double width;
    private String type;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private double getArea() {
        switch (type) {
            case "circle":
                return Math.PI * Math.pow(radius, 2);
            case "rectangle":
                return length * width;
        }
        return 0;
    }

    boolean isValid() {
        switch (type) {
            case "circle":
                return radius > 0.0 && length == 0.0 && width == 0.0;
            case "rectangle":
                return radius == 0.0 && length > 0.0 && width > 0.0;
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return String.format("Area is %.2f", getArea());
    }
}
