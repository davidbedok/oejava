package hu.qwaevisz.generic;

public class GenericPrintArray {
	
	public static <E> void printArray( E[] inputArray ) {
	   for ( E element : inputArray ) {
	      System.out.printf( "%s ", element );
	   }
	} 
	
}

