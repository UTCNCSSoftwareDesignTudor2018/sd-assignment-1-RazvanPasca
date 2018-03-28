package controller.validator;

public class GradeAndGroupValidator implements Validator {
    @Override
    public boolean validate(String target) {
        return ((target.matches("[0-9]")) || (target.matches("10")));
    }
}
