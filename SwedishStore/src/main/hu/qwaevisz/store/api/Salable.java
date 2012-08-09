package hu.qwaevisz.store.api;

public interface Salable {

	abstract String sell(int pieces);

	abstract double getPrice();

	abstract String getFancyName();

}
