package Thi_thuc_hanh_module_2.service;

import Thi_thuc_hanh_module_2.models.Student;
import Thi_thuc_hanh_module_2.repositories.StudentRepository;
import Thi_thuc_hanh_module_2.exceptions.NotFoundStudentException;

import java.util.List;

public class StudentService {
    private StudentRepository studentRepository;

    public StudentService() {
        this.studentRepository = new StudentRepository();
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void deleteStudent(int id) throws NotFoundStudentException {
        List<Student> students = studentRepository.getAllStudents();
        Student studentToDelete = students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundStudentException("Không tìm thấy sinh viên với ID: " + id));

        studentRepository.deleteStudent(studentToDelete.getId());
    }

    public List<Student> searchStudentByName(String name) {
        return studentRepository.searchStudentByName(name);
    }
}
