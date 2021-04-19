package gai.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
@Order(2)//改变切面顺序
public class LogUtils {

    /*
     * 切入点表达式的写法：固定格式execution(访问权限符 返回值类型 方法全类型(参数))
     * 通配符：*， ..
     * */
    @Before(value = "execution(* gai..MyMathCalculator.add(..))")
    public static void logStart(JoinPoint joinPoint) {
        System.out.println("springAOP帮你执行" + joinPoint.getSignature().getName() + Arrays.asList(joinPoint.getArgs()));
    }


    @AfterReturning(value = "execution(* gai.impl.MyMathCalculator.add(int, int))", returning = "result")
    public static void logEnd(JoinPoint joinPoint, Object result) {
        System.out.println("springAOP帮你执行完毕" + joinPoint.getSignature().getName() + Arrays.asList(joinPoint.getArgs()) + result);
    }

    @Pointcut(value = "execution(* gai.impl.MyMathCalculator.mul(..))")
    public void myPoint() {

    }

    /*
     * 环绕通知，spring最强大的通知，四合一
     * */
    @Around(value = "myPoint()")
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

        //反射调用后的返回值也一定返回出去
        return proceed;
    }
}
