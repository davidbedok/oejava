package hu.qwaevisz.bank.event;

public interface AccountChangeEvent {

	public abstract void add(final String accountNumber, boolean addResult);

	public abstract void delete(final String accountNumber);

}
