package by.itacademy.javaenterprise.knyazev.validators;

public abstract class AbstractValidator<T, K> implements Validator<T> {
	protected final K minValue;
	protected final K maxValue;

	public AbstractValidator(K minValue, K maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	@Override
	public boolean validate(T value) {
		return false;
	}

	public boolean isNull(String value) {
		if (value == null) {
			return true;
		}
		return false;
	}

}
