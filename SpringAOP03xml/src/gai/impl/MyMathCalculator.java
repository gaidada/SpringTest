package gai.impl;


import gai.inter.Calculator;
import org.springframework.stereotype.Service;

public class MyMathCalculator implements Calculator {
    @Override
    public int add(int i, int j) {
        int res = i + j;
        return res;
    }

    @Override
    public int sub(int i, int j) {
        int res = i - j;
        return res;
    }

    @Override
    public int mul(int i, int j) {
        int res = i * j;
        return res;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("除法");
        int res = i / j;
        return res;
    }
}
