package controller.validator;

public class GeneralStringValidator implements Validator {
    @Override
    public boolean validate(String target) {
        return (target.matches("[a-zA-Z \\. ,]+"));
    }
}
