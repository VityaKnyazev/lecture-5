package by.itacademy.javaenterprise.knyazev.validators;

public class StringRequestValidator extends AbstractValidator<String, Integer>{
	
	public StringRequestValidator(int minValue, int maxValue) {
		super(Integer.valueOf(minValue), Integer.valueOf(maxValue));
	}

	@Override
	public boolean validate(String value) {
		if (isNull(value)) return false;
		
		if (value.equals("")) return false;
		
		if ((value.length() <= maxValue) && (value.length() >= minValue)) {
			return true;
		}

		return false;
	}
	
	
}
