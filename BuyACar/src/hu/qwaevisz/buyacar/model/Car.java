package hu.qwaevisz.buyacar.model;

import hu.qwaevisz.buyacar.common.CarBrand;

public class Car {

	private final CarBrand	brand;
	private final String	type;
	private final int		vintage;
	private final int		cc;
	private final int		horsePower;

	public Car(CarBrand brand, String type, int vintage, int cc, int horsePower) {
		this.brand = brand;
		this.type = type;
		this.vintage = vintage;
		this.cc = cc;
		this.horsePower = horsePower;
	}

	public CarBrand getBrand() {
		return this.brand;
	}

	public String getType() {
		return this.type;
	}

	public int getVintage() {
		return this.vintage;
	}

	public int getCc() {
		return this.cc;
	}

	public int getHorsePower() {
		return this.horsePower;
	}

}
