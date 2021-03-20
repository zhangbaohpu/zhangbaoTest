//package com.zhangbao.zhangbaoTest.core.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//
///**
// * @author zhangbao
// * @date 2021/2/19 22:07
// **/
//@Aspect
//@Component
//@Slf4j
//public class LogAspect {
//    /**
//     * 切入点
//     */
//    @Pointcut("execution(public * com.zhangbao.zhangbaoTest..*.*(..))")
//    public void pointcut(){}
//
//    /**
//     * 在切入点执行之前要做的事
//     * @param joinPoint
//     */
//    @Before("pointcut()")
//    public void before(JoinPoint joinPoint){
//        //这个RequestContextHolder是Springmvc提供来获得请求的东西
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
//
//        // 记录下请求内容
//        log.info("################URL : " + request.getRequestURL().toString());
//        log.info("################HTTP_METHOD : " + request.getMethod());
//        log.info("################IP : " + request.getRemoteAddr());
//        log.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));
//
//    }
//
//}
