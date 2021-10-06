package by.itacademy.javaenterprise.knyazev.validators;

public interface Validator<T> {
	
	boolean validate(T value);
	
}
