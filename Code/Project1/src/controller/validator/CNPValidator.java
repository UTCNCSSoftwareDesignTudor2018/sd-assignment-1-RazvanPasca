package controller.validator;

public class CNPValidator implements Validator {

    @Override
    public boolean validate(String target) {
        return (target.matches("[0-9]+") && target.length() == 13);
    }
}
