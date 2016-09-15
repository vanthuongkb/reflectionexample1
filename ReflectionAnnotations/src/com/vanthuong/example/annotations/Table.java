package com.vanthuong.example.annotations;

/**
 * Official blog: http://www.vanthuong.com
 * Learn and share your java knowledge
 */

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
  String name() default "";
}