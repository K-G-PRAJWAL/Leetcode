package com.kgprajwal.leetcodejavasolutions;

public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String num1, String num2) {
        String x[] = num1.split("\\+|i");
        String y[] = num2.split("\\+|i");
        int num1Real = Integer.parseInt(x[0]);
        int num1Img = Integer.parseInt(x[1]);
        int num2Real = Integer.parseInt(y[0]);
        int num2Img = Integer.parseInt(y[1]);
        return (num1Real * num2Real
                - num1Img * num2Img)
                + "+"
                + (num1Real * num2Img
                + num1Img * num2Real)
                + "i";
    }
}
