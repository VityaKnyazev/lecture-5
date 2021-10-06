package by.itacademy.javaenterprise.knyazev.validators;

public class IntegerRequestValidator extends AbstractValidator<String, Integer> {

	public IntegerRequestValidator(int minValue, int maxValue) {
		super(Integer.valueOf(minValue), Integer.valueOf(maxValue));
	}

	@Override
	public boolean validate(String value) {
		if (isNull(value)) return false;

		int requestValue = 0;

		try {
			requestValue = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return false;
		}

		if ((requestValue <= maxValue) && (requestValue >= minValue)) {
			return true;
		}

		return false;
	}

}
