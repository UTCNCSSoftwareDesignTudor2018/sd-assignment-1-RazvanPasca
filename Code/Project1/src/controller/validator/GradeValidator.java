package controller.validator;

public class GradeValidator implements NumberValidator {
    @Override
    public boolean validate(String target) {
        return ((target.matches("[0-9]")) || (target.matches("10")));
    }
}
