package com.example.demo;

public class Calculate {
    private Integer x;
    private Integer y;
    private String operation = "add";

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        StringBuilder equation = new StringBuilder();
        int answer = 0;
        equation.append(x);
        switch (operation){
            case "add":
                equation.append(" + ");
                answer = x + y;
                break;
            case "subtract":
                equation.append(" - ");
                answer = x - y;
                break;
            case  "multiply":
                equation.append(" * ");
                answer = x * y;
                break;
            case  "divide":
                equation.append(" / ");
                answer = x / y;
                break;
        }
        equation.append(y);
        equation.append(" = ");
        equation.append(answer);
        return equation.toString();
    }
}
