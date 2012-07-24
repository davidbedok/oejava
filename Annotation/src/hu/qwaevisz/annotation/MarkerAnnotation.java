package hu.qwaevisz.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//SOURCE - csak a java forrasban szamit
//CLASS (default) - belekerul a class allomanyba is
//RUNTIME - JVM szamara is elerheto lesz

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE,ElementType.ANNOTATION_TYPE})
@Documented /* javadoc-ba belekeruljon-e vagy sem */
public @interface MarkerAnnotation {

}
