package com.gai.proxy;

import com.gai.impl.MyMathCalculator;
import com.gai.inter.Calculator;
import com.gai.utils.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//生成代理对象的类
public class CalculatorProxy {

    //为传入的参数对象创建一个动态代理对象
    public static Calculator getProxy(final Calculator calculator) {

        //方法执行器，帮我们目标对象执行目标方法
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //利用反射执行方法
                LogUtils.logStart(method, args);
                Object result = method.invoke(calculator, args);
                LogUtils.logEnd(method, args);
                return result;
            }
        };
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        ClassLoader loader = calculator.getClass().getClassLoader();
        //Proxy为目标对象创建代理对象
        Object o = Proxy.newProxyInstance(loader, interfaces, h);
        return (Calculator) o;
    }
}
