package controller.validator;

public class PositiveNumberValidator implements NumberValidator {

    @Override
    public boolean validate(String string) {
        return (string.matches("-\\d+") || // Matches all negative integers, even if they are less than `Long.MIN_VALUE`
                string.equals("0") || // If the string is zero
                string.matches("0+") || // If the string consists of a bunch of zeroes, nothing else, or even better
                string.matches("0*") ||// If the string contains nothing except zeroes, meaning this will also match an empty string
                string.isEmpty());
    }
}
