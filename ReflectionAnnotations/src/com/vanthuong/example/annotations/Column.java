package com.vanthuong.example.annotations;

/*
 * Official blog: http://www.vanthuong.com
 * Learn and share your java knowledge
 */

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
  String name() default "";
}
