package com.gai.test;

import com.gai.impl.MyMathCalculator;
import com.gai.inter.Calculator;
import com.gai.proxy.CalculatorProxy;
import org.junit.Test;

public class AOPTest {



    @Test
    public void test11() {
        MyMathCalculator calculator = new MyMathCalculator();
        calculator.add(1, 2);

        Calculator proxy = CalculatorProxy.getProxy(calculator);
        proxy.add(2,1);
        proxy.div(2,1);
    }

    @Test
    public void test2(){

    }
}
