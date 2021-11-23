package homework.exceptions;

public class TooMuchStudyHours extends Exception {
    @Override
    public String getMessage() {
        return "Wrong StudyHours: Physically and mentally impossible to be tath much";
    }
}
