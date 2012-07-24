package hu.qwaevisz.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE,ElementType.ANNOTATION_TYPE})
@Documented
public @interface MultiValueWithDefaultAnnotation {
	
	public String value();	
	public int num() default 42;
	public double avg() default 3.1415;
	
}
