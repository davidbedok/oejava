package hu.qwaevisz.generic;

public class GenericClass <E> {

	private E variable;
	
	public GenericClass( E variable ){
		this.variable = variable;
	}

	public E getVariable() {
		return variable;
	}

	public void setVariable(E variable) {
		this.variable = variable;
	}
	
	public void add( E value ) {
		if (variable instanceof String){
			String s = ((String)this.variable);
			s += (String)value;
			variable = (E) s;
		}
		if (variable instanceof Integer){
			Integer s = ((Integer)this.variable);
			s += (Integer)value;
			variable = (E) s;
		}		
	}
	
	@Override
	public String toString() {
		return variable.toString();
	}
	
}
