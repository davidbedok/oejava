package hu.qwaevisz.reflectannot;

public class DemoClass {

	@VersionInfo(createDate = "2010.04.02", creater = Developer.KOVACSJ, modifier = Developer.BEDOKD, modifyDate = "2010.08.10")
	@VersionComment("this field must be non-negative")	
	private int demoField;

	@VersionInfo(createDate = "2010.08.06", creater = Developer.BEDOKD, modifier = Developer.BEDOKD, modifyDate = "2010.08.06")
	@VersionComment("default constructor")
	public DemoClass (){
		System.out.println("Demo instance created..");
	}
	
	@VersionInfo(createDate = "2010.08.06", creater = Developer.KOVACSJ, modifier = Developer.BEDOKD, modifyDate = "2010.08.06")
	@VersionComment("other constructor")
	public DemoClass ( int demoField ){
		System.out.println("Demo instance created..");
		this.demoField = demoField;
	}	

	@VersionInfo(createDate = "2010.08.06", creater = Developer.BEDOKD, modifier = Developer.BEDOKD, modifyDate = "2010.08.06")
	@VersionComment("demoField getter method")
	public int getDemoField() {
		return demoField;
	}
 	
	@VersionInfo(createDate = "2010.08.11", creater = Developer.KOVACSJ, modifier = Developer.BEDOKD, modifyDate = "2010.08.12")
	@VersionComment("demoField setter method")
	public void setDemoField(int demoField) {
		this.demoField = 0;
		if ( demoField > 0 ){
			this.demoField = demoField;
		}
	}
		
}
