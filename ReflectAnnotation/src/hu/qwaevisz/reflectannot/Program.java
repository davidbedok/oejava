package hu.qwaevisz.reflectannot;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
	
	public static void printAllVersionInfo( Annotation[] iAnnotations ){
		for (Annotation a : iAnnotations ){				
			if (a instanceof VersionInfo ){
				VersionInfo vi = (VersionInfo)a;				
				System.out.println("Create: "+vi.creater()+" ("+vi.createDate()+")");				
				System.out.println("Modify: "+vi.modifier()+" ("+vi.modifyDate()+")");				
			}
			if (a instanceof VersionComment ){
				VersionComment vc = (VersionComment)a;
				System.out.println("Comment: "+vc.value());									
			}								
		}
	}	
	
	public static void collectStatistic( Annotation[] iAnnotations ){
		for (Annotation a : iAnnotations ){				
			if (a instanceof VersionInfo ){
				VersionInfo vi = (VersionInfo)a;				
				StatisticData.getInstance().addDeveloperWork(vi.creater());
				StatisticData.getInstance().addDeveloperWork(vi.modifier());
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("# Reflect Annotation application");
							
		// Constructor<DemoClass>[] iConstructor = (Constructor<DemoClass>[]) DemoClass.class.getConstructors();
		Constructor[] iConstructorsTmp = DemoClass.class.getConstructors();			
		for (Constructor c : iConstructorsTmp ){
			System.out.println("- Constructor name: "+c.getName());
			Program.printAllVersionInfo(c.getAnnotations());					
		}		
		
		System.out.println();
		
		Member[] iMembers = DemoClass.class.getDeclaredMethods();
		for (Member m : iMembers ){
			System.out.println("- Member name: "+m.getName());
		}
		
		System.out.println();
		
		AccessibleObject[] iAccessibleObjectTmp = DemoClass.class.getDeclaredMethods();
		for (AccessibleObject ao : iAccessibleObjectTmp ){		
			System.out.println("- Method name: "+((Method)ao).getName());
			Program.printAllVersionInfo(ao.getAnnotations());		
		}		

		AccessibleObject[] iAccessibleObject = null;
		
		Constructor[] iConstructors = DemoClass.class.getConstructors();
		Method[] iMethods = DemoClass.class.getDeclaredMethods();
		Field[] iFields = DemoClass.class.getDeclaredFields();
						
	    List<AccessibleObject> iAO = new ArrayList<AccessibleObject>();
	    iAO.addAll(Arrays.asList(iConstructors));
	    iAO.addAll(Arrays.asList(iMethods));
	    iAO.addAll(Arrays.asList(iFields));	    
	    iAccessibleObject = iAO.toArray(new AccessibleObject[iAO.size()]);
	    
		for (AccessibleObject c : iAccessibleObject ){			
			Program.collectStatistic(c.getAnnotations());			
		}	    
	    	    
		System.out.println(StatisticData.getInstance());		
	}

}
