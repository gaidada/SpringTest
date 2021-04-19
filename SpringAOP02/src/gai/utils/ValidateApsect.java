package gai.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(1)
public class ValidateApsect {
    @Before(value = "execution(* gai..MyMathCalculator.add(..))")
    public void logStart(JoinPoint joinPoint) {
        System.out.println("springAOP2号帮你执行" + joinPoint.getSignature().getName() + Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "execution(* gai.impl.MyMathCalculator.add(int, int))", returning = "result")
    public static void logEnd(JoinPoint joinPoint, Object result) {
        System.out.println("springAOP2号帮你执行完毕" + joinPoint.getSignature().getName() + Arrays.asList(joinPoint.getArgs()) + result);
    }
}
