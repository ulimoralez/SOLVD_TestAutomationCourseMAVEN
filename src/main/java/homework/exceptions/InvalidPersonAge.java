package homework.exceptions;

public class InvalidPersonAge extends RuntimeException {
    @Override
    public String getMessage() {
        return "Wrong age: You can't be that older or that young!";
    }
}
