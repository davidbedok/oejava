package hu.qwaevisz.reflectannot;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE,ElementType.ANNOTATION_TYPE})
@Documented
public @interface VersionInfo {

	public String createDate();
	public String modifyDate();
	public Developer creater();
	public Developer modifier();	
	
}
