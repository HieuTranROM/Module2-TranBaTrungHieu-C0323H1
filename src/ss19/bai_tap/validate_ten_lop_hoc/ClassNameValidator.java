package ss19.bai_tap.validate_ten_lop_hoc;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ClassNameValidator {
    public static boolean isValidClassName(String className) {
        String regex = "^[CAP][0-9]{4}[GHIKLM]$"; // Regular Expression

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(className);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String validClassName = "C0318G";
        String invalidClassName1 = "M0318G";
        String invalidClassName2 = "P0323A";

        System.out.println(validClassName + " is valid: " + isValidClassName(validClassName));
        System.out.println(invalidClassName1 + " is valid: " + isValidClassName(invalidClassName1));
        System.out.println(invalidClassName2 + " is valid: " + isValidClassName(invalidClassName2));
    }
}

//package controller;
//
//import models.Student;
//import service.StudentService;
//
//import java.time.LocalDate;
//import java.util.List;
//
//public class StudentController {
//    private StudentService studentService = new StudentService();
//
//    public List<Student> getAllStudents() {
//        return studentService.getAllStudents();
//    }
//
//    public void addStudent(String name, LocalDate dob, String gender, String phone, int courseId) {
//        List<Student> students = studentService.getAllStudents();
//        int id = students.isEmpty() ? 1 : students.get(students.size() - 1).getId() + 1;
//        Student student = new Student(id, name, dob, gender, phone, courseId);
//        studentService.addStudent(student);
//    }
//
//    public void removeStudent(int id) {
//        studentService.removeStudent(id);
//    }
//}

