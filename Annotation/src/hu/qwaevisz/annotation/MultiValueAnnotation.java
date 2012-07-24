package hu.qwaevisz.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE,ElementType.ANNOTATION_TYPE})
@Documented
public @interface MultiValueAnnotation {
	
	// metodusoknak nem lehet parametere, nem dobhatnak kivetelt
	public String value();	
	public int num();
	public double avg();
	// visszateresi ertekek ezek lehetnek: primitives, String, Class, enum + ezek 1D array valtozata
	
}
