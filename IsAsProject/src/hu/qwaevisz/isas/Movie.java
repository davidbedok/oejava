package hu.qwaevisz.isas;

public abstract class Movie {

	public Movie(){
				
	}
	
	@Override
	public String toString() {		
		return "This is a movie";
	}
	
	public abstract String toPrint();
	
}
