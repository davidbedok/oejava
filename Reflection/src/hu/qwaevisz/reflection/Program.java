package hu.qwaevisz.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {

	public static void reflectionTest(){
		System.out.println("# Reflection Test");		
		
		Demo d = null;
		Object o = null;
		
		System.out.println("\n# Dynamic class creation..");
		
		String className = "hu.qwaevisz.reflection.Demo";
		try {
			o = Class.forName(className).newInstance();			
			System.out.println(o.toString());					
		} catch (InstantiationException e) {			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
						
		try {
		
			System.out.println("# Cast..");
			
			if (o instanceof Demo){
				d = (Demo)o;
			}	
			d.setPrivateField(42);
			System.out.println(o.toString());
							
			System.out.println("\n# List all methods..");
			
			int methodIndex = -1;
			Method[] methods = o.getClass().getDeclaredMethods();
			for ( int i = 0; i < methods.length; i++ ){
				System.out.println(methods[i]);
				
				if ( methods[i].getName().equalsIgnoreCase("setPrivateField") ){
					methodIndex = i;
				}
			}
			
			System.out.println("\n# Dynamic method call..");
			
			try {
				methods[methodIndex].invoke(d, 30);
				System.out.println(d.toString());
			} catch (IllegalArgumentException e) {				
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
			System.out.println("\n# Dynamic method call by name..");
			
			try {
				// Method mPrivate = o.getClass().getMethod("privateMethod", String.class); // NoSuchMethodException (private)
				
				Method mPublic = o.getClass().getMethod("publicMethod", String.class);				
				mPublic.invoke(o, "alma");
				
			} catch (SecurityException e) {				
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {				
				e.printStackTrace();
			} catch (IllegalAccessException e) {				
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
						
		} catch (NullPointerException e){
			e.printStackTrace();
		}		
	}
	
	public static void printArray( String name, int[] a ){
		System.out.println(">>" + name);
		for (int i = 0; i < a.length; i++){
			System.out.print("["+i+"] "+a[i]+" ");
		}
		System.out.println();
		
		Class type = a.getClass();
	    if (type.isArray()) {
	        Class dataType = type.getComponentType();
	        System.out.println("DataType: " + dataType);
	        System.out.println("Length: " + Array.getLength(a));
	    }		
	}
	
	public static void print2DArray( String name, int[][] a ){
		System.out.println(">>" + name);
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < a[i].length; j++){
				System.out.print("["+i+"]["+j+"] "+a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		Class type = a.getClass();
	    if (type.isArray()) {
	        Class dataType = type.getComponentType();
	        System.out.println("DataType: " + dataType);
	        System.out.println("Length: " + Array.getLength(a));
	    }		
	}	
	
	public static void createArray(){
		System.out.println("# createArray()");
		
		int[] normalWay = new int[2];
		normalWay[0] = 42;
		normalWay[1] = 30;
		Program.printArray("normalWay",normalWay);
		
		// java.lang.reflect.Array.newInstance() letre tud hozni array-t, constructor parameterek kellenek hozza
		// mik a constructor parameterek? int[2] --> int alaptipusu 2 elemu tomb
		// a visszakapott Object-tet castolni kell
		
		// newInstance( componentType class, int.. )
		// componentType class --> alaptipus
		// int.. --> int[] --> dimenziok tombje (multi params..)
		int[] reflectWay = (int[]) Array.newInstance(int.class, 2);
		reflectWay[0] = 42;
		reflectWay[1] = 30;		 
		Program.printArray("reflectWay",reflectWay);

		int[] dims = { 2 }; // egy elem -> egy dimenzio, 2 --> elso dimenzio darabszama
		int[] reflectWay2 = (int[]) Array.newInstance(int.class, dims);
		reflectWay2[0] = 42;
		reflectWay2[1] = 30;		 
		Program.printArray("reflectWay2",reflectWay2);
				
		int[][] normal2DWay = new int[2][3];		
		normal2DWay[0][0] = 1;
		normal2DWay[0][1] = 2;
		normal2DWay[0][2] = 3;
		normal2DWay[1][0] = 4;
		normal2DWay[1][1] = 5;
		normal2DWay[1][2] = 6;		
		Program.print2DArray("normal2DWay",normal2DWay);
				
		int[][] reflect2DWay = (int[][]) Array.newInstance(int.class, 2, 3 );
		reflect2DWay[0][0] = 1;
		reflect2DWay[0][1] = 2;
		reflect2DWay[0][2] = 3;
		reflect2DWay[1][0] = 4;
		reflect2DWay[1][1] = 5;
		reflect2DWay[1][2] = 6;	
		Program.print2DArray("reflect2DWay",reflect2DWay);
		
		int[][] reflect2DWay2 = (int[][]) Array.newInstance(int.class, new int[] { 2, 3 });
		reflect2DWay2[0][0] = 1;
		reflect2DWay2[0][1] = 2;
		reflect2DWay2[0][2] = 3;
		reflect2DWay2[1][0] = 4;
		reflect2DWay2[1][1] = 5;
		reflect2DWay2[1][2] = 6;	
		Program.print2DArray("reflect2DWay2",reflect2DWay2);

		int[][] normal2DUndefWay = new int[2][];
		normal2DUndefWay[0] = new int[3];
		normal2DUndefWay[0][0] = 1;
		normal2DUndefWay[0][1] = 2;
		normal2DUndefWay[0][2] = 3;
		normal2DUndefWay[1] = new int[3];
		normal2DUndefWay[1][0] = 4;
		normal2DUndefWay[1][1] = 5;
		normal2DUndefWay[1][2] = 6;		
		Program.print2DArray("normal2DUndefWay",normal2DUndefWay);
		
		// int[] alaptipus, 2 elem
		int[][] reflect2DUndefWay = (int[][]) Array.newInstance(int[].class, 2);
		reflect2DUndefWay[0] = new int[3];
		reflect2DUndefWay[0][0] = 1;
		reflect2DUndefWay[0][1] = 2;
		reflect2DUndefWay[0][2] = 3;
		reflect2DUndefWay[1] = new int[3];
		reflect2DUndefWay[1][0] = 4;
		reflect2DUndefWay[1][1] = 5;
		reflect2DUndefWay[1][2] = 6;		
		Program.print2DArray("reflect2DUndefWay",reflect2DUndefWay);
	}
	
	public static void main(String[] args) {
		Program.reflectionTest();
		Program.createArray();		
	}

}
