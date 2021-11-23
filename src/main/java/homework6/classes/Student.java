package homework6.classes;

import homework6.customLogger.MyLogger;
import homework6.interfaces.IStudent;
import homework6.exceptions.TooMuchStudyHours;

import java.util.Objects;
import java.util.logging.Logger;

public class Student extends Person implements IStudent{
    private String collegeName;
    private String careerName;
    Logger log = new MyLogger(Student.class.getName()).getInitializedLogger();

    //Constructors
    public Student(){

    }
    public Student(String firstName, String lastName, String gender, int age, String collegeName, String careerName) {
        this(firstName, lastName, gender, collegeName, careerName);
        super.setAge(age);
    }
    public Student(String firstName, String lastName, int age, String collegeName, String careerName) {
        super(firstName, lastName, age);
        changeInfo(collegeName, careerName);
    }
    public Student(String firstName, String lastName, String gender, String collegeName, String careerName) {
        super(firstName, lastName, gender);
        changeInfo(collegeName, careerName);
    }
    public Student(String firstName, String lastName, String collegeName, String careerName) {
        super(firstName, lastName);
        changeInfo(collegeName, careerName);
    }

    //Methods and Functions
    public void changeInfo(String collegeName, String careerName){
        this.collegeName = collegeName;
        this.careerName = careerName;
    }
    public void changeInfo(String firstName, String lastName, String collegeName, String careerName){
        super.setFirstName(firstName);
        super.setLastName(lastName);
        this.collegeName = collegeName;
        this.careerName = careerName;
    }
    public void studyHoursInADay(int hours) throws TooMuchStudyHours {
        if(hours > 24){
            throw new ArithmeticException("This is impossible, a day only have 24 hours");
        }else{
            if(hours > 15){
                throw new TooMuchStudyHours();
            }else{
                log.info("Sounds great! Keep on it!");
            }
        }
    }

    //Overriding Object functions
    @Override
    public String toString() {
        return "Student{" +
                "collegeName='" + collegeName + '\'' +
                ", careerName='" + careerName + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(collegeName, student.collegeName) && Objects.equals(careerName, student.careerName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), collegeName, careerName);
    }

    //Overriding interface methods
    @Override
    public String themeToStudy() {
        return ("Java and Testing");
    }
    @Override
    public void eat() {
        log.info("I eat when I'm not sleeping");
    }
    @Override
    public void drink() {
        log.info("I love drink coffee");
    }
}
