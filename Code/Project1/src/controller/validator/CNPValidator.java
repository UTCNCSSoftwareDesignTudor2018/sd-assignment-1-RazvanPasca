package controller.validator;

public class CNPValidator implements NumberValidator {

    @Override
    public boolean validate(String target) {
        return (target.matches("[0-9]+") && target.length() == 14);
    }
}
