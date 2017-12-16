package org.springframework.samples.mvc.simple;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnotherValue {
    String value() default "";
}