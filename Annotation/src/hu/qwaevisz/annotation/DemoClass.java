package hu.qwaevisz.annotation;

public class DemoClass {

	private int demoField;
	private int demoField2;
	private int demoField3;
	
	@MarkerAnnotation
	public DemoClass (){
		System.out.println("Demo instance created..");
	}

	@SingleElementAnnotation(value = "alma")
	public int getDemoField() {
		return demoField;
	}
 	
	@SingleElementAnnotation("korte")
	public void setDemoField(int demoField) {
		this.demoField = demoField;
	}

	@SingleElementWithDefaultAnnotation
	public int getDemoField2() {
		return demoField2;
	}

	@SingleElementWithDefaultAnnotation(value = "barack")
	public void setDemoField2(int demoField2) {
		this.demoField2 = demoField2;
	}

	@MultiValueAnnotation(avg = 3.14, num = 42, value = "alma")
	public int getDemoField3() {
		return demoField3;
	}
	
	@MultiValueWithDefaultAnnotation("alma")
	public void setDemoField3(int demoField3) {
		this.demoField3 = demoField3;
	}	
		
}
