package com.vanthuong.example.annotations;

import com.vanthuong.example.enums.UserRole;

import java.lang.annotation.*;

/**
 * Official blog: http://www.vanthuong.com
 * Learn and share your java knowledge
 */

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
  UserRole[] value();
}
