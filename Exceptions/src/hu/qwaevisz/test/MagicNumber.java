package hu.qwaevisz.test;

import hu.qwaevisz.exception.checked.TooHighException;
import hu.qwaevisz.exception.checked.TooLowException;
import hu.qwaevisz.exception.checked.WrongValueException;
import hu.qwaevisz.exception.unchecked.UTooHighException;
import hu.qwaevisz.exception.unchecked.UTooLowException;

public class MagicNumber {

	public static final int TOOHIGHMAGICNUMBER = 8;
	public static final int TOOLOWMAGICNUMBER = 6;

	private int magicNumber;

	public MagicNumber() {
		System.out.println("MagicNumber instance created.");
	}

	public int getMagicNumber() {
		return magicNumber;
	}

	// metodus, mely checked kivetelt dobhat
	public void setMagicNumberWithCheckedExceptions(int magicNumber) throws WrongValueException {
		System.out.println("setMagicNumber(" + magicNumber + ")");
		if (magicNumber >= MagicNumber.TOOHIGHMAGICNUMBER) {
			throw new TooHighException("Must under " + MagicNumber.TOOHIGHMAGICNUMBER);
		}
		if (magicNumber <= MagicNumber.TOOLOWMAGICNUMBER) {
			throw new TooLowException("Must above " + MagicNumber.TOOLOWMAGICNUMBER);
		}
		this.magicNumber = magicNumber;
	}

	// a 'throws UWrongValueException' szerepeltetese nem szukseges, mert unchecked kivetel
	// metodus, mely unchecked kivetelt dobhat
	public void setMagicNumberWithUnCheckedExceptions(int magicNumber) {
		System.out.println("setMagicNumber(" + magicNumber + ")");
		if (magicNumber >= MagicNumber.TOOHIGHMAGICNUMBER) {
			throw new UTooHighException();
		}
		if (magicNumber <= MagicNumber.TOOLOWMAGICNUMBER) {
			throw new UTooLowException();
		}
		this.magicNumber = magicNumber;
	}

}
