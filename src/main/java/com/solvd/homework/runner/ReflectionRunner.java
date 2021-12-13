package com.solvd.homework.runner;

import com.solvd.homework.classes.Student;

import java.lang.reflect.*;
import java.util.logging.Logger;

public class ReflectionRunner {
    public static void main(String[] args) throws ClassNotFoundException {
        Logger LOGGER = Logger.getLogger(ReflectionRunner.class.getName());
        //Reflection
        Class studentClassReflection  = Class.forName("com.solvd.homework.classes.Student");
        Field fields[] = studentClassReflection.getDeclaredFields();
        Method method[] = studentClassReflection.getDeclaredMethods();
        Constructor constructor[] = studentClassReflection.getConstructors();

        LOGGER.info("Student class name: "+studentClassReflection.getSimpleName());
        LOGGER.info("SuperClass of Student class: "+studentClassReflection.getSuperclass());

        LOGGER.info("Attributes");
        for (Field individualField : fields) {
            int modifiers = individualField.getModifiers();
            LOGGER.info("Name: " + individualField.getName() + "Class declared: " + individualField.getDeclaringClass() + "Type: " + individualField.getModifiers() + "Modifiers " + Modifier.toString(modifiers) + "\n");
        }

        LOGGER.info("Methods");
        for (Method value : method) {
            LOGGER.info("Name: " + value.toString() + "\n");
        }

        LOGGER.info("Constructors");
        for (int i = 0; i < constructor.length; i++) {
            LOGGER.info(""+constructor[i] + "\n");
        }

        LOGGER.info("Using the constructor and toString method");
        try {
            Constructor<Student> studentConstructor = studentClassReflection.getConstructor(String.class,
                    String.class, String.class, String.class);
            Student newStudent = studentConstructor.newInstance("Ulises", "Moralez","UTN","TUP");
            LOGGER.info("Number of parameters: " + studentConstructor.getParameterCount());

            Method toString = studentClassReflection.getMethod("toString");
            LOGGER.info(""+toString.invoke(newStudent));
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
