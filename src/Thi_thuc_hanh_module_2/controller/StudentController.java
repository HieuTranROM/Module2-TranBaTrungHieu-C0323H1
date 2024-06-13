package Thi_thuc_hanh_module_2.controller;

import Thi_thuc_hanh_module_2.models.Student;
import Thi_thuc_hanh_module_2.repositories.StudentRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StudentController {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private StudentRepository studentRepository;

    public StudentController() {
        studentRepository = new StudentRepository();
    }

    public void addStudent(String name, LocalDate dob, String gender, String phone, String courseId) {
        Student student = new Student(0, name, dob, gender, phone, courseId);
        studentRepository.addStudent(student);
    }

    public void deleteStudent(int studentId) {
        studentRepository.deleteStudent(studentId);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public List<Student> searchStudentByName(String name) {
        return studentRepository.searchStudentByName(name);
    }
}
