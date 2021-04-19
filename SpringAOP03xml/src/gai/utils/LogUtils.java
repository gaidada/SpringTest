package gai.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

public class LogUtils {
    public static void logStart(JoinPoint joinPoint) {
        System.out.println("springAOP帮你执行" + joinPoint.getSignature().getName() + Arrays.asList(joinPoint.getArgs()));
    }


    public static void logEnd(JoinPoint joinPoint, Object result) {
        System.out.println("springAOP帮你执行完毕" + joinPoint.getSignature().getName() + Arrays.asList(joinPoint.getArgs()) + result);
    }


    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {

        Object[] args = pjp.getArgs();
        //利用反射调用目标方法即可，就是method.invoke
        Object proceed = null;
        try {
            System.out.println("环绕前置" + pjp.getSignature().getName() + "===" + Arrays.asList(pjp.getArgs()));
            proceed = pjp.proceed(args);
            System.out.println("环绕返回了,返回值" + proceed);
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            throwable.printStackTrace();
            throw new RuntimeException();
        } finally {
            System.out.println("后置通知");
        }

        return proceed;
    }
}
