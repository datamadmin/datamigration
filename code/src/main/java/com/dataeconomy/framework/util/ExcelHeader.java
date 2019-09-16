package com.dataeconomy.framework.util;

@java.lang.annotation.Target(value = { java.lang.annotation.ElementType.FIELD })
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface ExcelHeader {

	abstract java.lang.String name() default "";

	boolean isExport() default true;
}
