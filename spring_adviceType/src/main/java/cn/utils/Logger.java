package cn.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于
 */
public class Logger {
    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知logeer类中的printLog方法记录日志");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("后置通知logeer类中的printLog方法记录日志");
    }


    /**
     * 异常通知
     */
    public void afterThrowingPrintLog(){
        System.out.println("异常通知logeer类中的printLog方法记录日志");
    }


    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("最终通知logeer类中的printLog方法记录日志");
    }

    /**
     * 环绕通知
     *      当配置了环绕通知后
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtvalue = null;
        try {
            Object[] args = pjp.getArgs();  //得到方法执行所需的参数
            System.out.println("环绕通知logeer类中的printLog方法记录日志 前置");
            rtvalue = pjp.proceed(args); //明确调用业务层方法(切入点方法)
            System.out.println("环绕通知logeer类中的printLog方法记录日志 后置");
            int i = 1/0;
            return rtvalue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知logeer类中的printLog方法记录日志 异常");
            throwable.printStackTrace();
        }finally {
            System.out.println("环绕通知logeer类中的printLog方法记录日志 最终");
        }
        return rtvalue;
    }
}
