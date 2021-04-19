package com.gai.utils;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogUtils {
    public static void logStart(Method method,Object... args){
        System.out.println("动态代理将要帮你执行" + method.getName() + "方法" + Arrays.asList(args));
    }
    public static void logEnd(Method method,Object... args){
        System.out.println("动态代理帮你执行完毕" + method.getName() + "方法" + Arrays.asList(args));
    }
}
