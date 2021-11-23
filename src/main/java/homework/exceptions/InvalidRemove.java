package homework.exceptions;

public class InvalidRemove extends Exception{
    @Override
    public String getMessage() {
        return "Invalid operation: Operation it's not valid because there is not an item to remove";
    }
}
