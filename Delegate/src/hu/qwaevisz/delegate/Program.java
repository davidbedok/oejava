package hu.qwaevisz.delegate;

public class Program {
		
	public static Integer[] sortInteger( Integer[] a, Comparator<? super Integer> c ){				
		for ( int i = 0; i < a.length-1; i++ ){
			Integer prop = a[i];
			int propPos = i;				
			for ( int j = i+1; j < a.length; j++ ){
				if ( c.compare(a[j],prop) ){
					prop = a[j];
					propPos = j;
				}				
			}
			Integer tmp = a[i];
			a[i] = a[propPos];
			a[propPos] = tmp;			
		}					
		return a;
	}
	
	public static <T> T[] sort( T[] a, Comparator<? super T> c ){				
		for ( int i = 0; i < a.length-1; i++ ){
			T prop = a[i];
			int propPos = i;				
			for ( int j = i+1; j < a.length; j++ ){
				if ( c.compare(a[j],prop) ){
					prop = a[j];
					propPos = j;
				}				
			}
			T tmp = a[i];
			a[i] = a[propPos];
			a[propPos] = tmp;			
		}					
		return a;
	}
	
	public static <T> void print( T[] a ){
		for ( int i = 0; i < a.length; i++ ){
			System.out.print(a[i]+" ");			
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("Delegate");

		Integer[] ia = {4,2,7,9,4,12,32,1,5}; 
		
		Program.print(ia);
		
		Integer[] iaDec = ia.clone();
		iaDec = Program.sort(iaDec, new IntegerCompareDecrease());
		Program.print(iaDec);

		Integer[] iaInc = ia.clone();
		iaInc = Program.sort(iaInc, new IntegerCompareIncrement());
		Program.print(iaInc);
		
		String[] ib = {"korte", "szilva", "alma", "barack", "birsalma", "dio", "mandula"};
		Program.print(ib);
		ib = Program.sort(ib, new StringLengthCompare());
		Program.print(ib);
	}

}
