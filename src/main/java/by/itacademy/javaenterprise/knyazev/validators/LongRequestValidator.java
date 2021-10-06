package by.itacademy.javaenterprise.knyazev.validators;

public class LongRequestValidator extends AbstractValidator<String, Long> {

	public LongRequestValidator(long minValue, long maxValue) {
		super(Long.valueOf(minValue), Long.valueOf(maxValue));
	}

	@Override
	public boolean validate(String value) {
		if (isNull(value))
			return false;

		long requestValue = 0L;

		try {
			requestValue = Long.parseLong(value);
		} catch (NumberFormatException e) {
			return false;
		}

		if ((requestValue <= maxValue) && (requestValue >= minValue)) {
			return true;
		}

		return false;
	}

}
