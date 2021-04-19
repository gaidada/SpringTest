package gai.test;

import gai.impl.MyMathCalculator;
import gai.inter.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test1() {
        //一定要用接口类型，不要用他本类
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(2, 1);
        System.out.println(bean);
        //AOP的底层就是动态代理，容器中保存的组件时他的代理对象
        System.out.println(bean.getClass());

        Calculator bean1 = (Calculator) ioc.getBean("myMathCalculator");
        System.out.println(bean1.getClass());
    }

    /*
     * 通知方法的执行顺序
     * 正常执行：@Before->@After->@AfterReturning
     * 异常执行：@Before->@After->@AfterThrowing
     * 环绕通知优先于普通通知执行
     * */
    @Test
    public void test2() {
        Calculator bean = ioc.getBean(Calculator.class);
        bean.mul(1, 1);
        System.out.println("test");
    }

    @Test
    public void test3(){
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(1, 1);
        System.out.println("test");
    }
}
