package hu.qwaevisz.demo;

public enum AbstractEdgeType {

	NORMAL(3.14) {
		@Override
		public double execute() {
			return 1;
		}
	}, //
	INHIBITOR(42.0) {
		@Override
		public double execute() {
			return 2;
		}
	}, //
	RESET(12.3) {
		@Override
		public double execute() {
			return 3;
		}
	};

	private double field;

	private AbstractEdgeType(double field) {
		this.field = field;
	}

	public double getField() {
		return this.field;
	}

	public void setField(double field) {
		this.field = field;
	}

	public abstract double execute();

	public double doIt() {
		return this.execute() * this.field;
	}

}