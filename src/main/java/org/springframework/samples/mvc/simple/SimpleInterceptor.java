package org.springframework.samples.mvc.simple;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class SimpleInterceptor {

    @Around("@annotation(AnotherValue)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        AnotherValue value = getAnnotation(joinPoint, AnotherValue.class);
        Object result = value.value();
        if (!"H2".equals(result)) {
            result = joinPoint.proceed(joinPoint.getArgs());
        }
        return result;
    }

    private <T extends Annotation> T getAnnotation(ProceedingJoinPoint jp, Class<T> clazz) {
        MethodSignature sign = (MethodSignature) jp.getSignature();
        Method method = sign.getMethod();
        return method.getAnnotation(clazz);
    }


}
