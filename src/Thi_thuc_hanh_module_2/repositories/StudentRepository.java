package Thi_thuc_hanh_module_2.repositories;

import Thi_thuc_hanh_module_2.models.Student;
import Thi_thuc_hanh_module_2.utils.CsvUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRepository {
    private static final String CSV_FILE_PATH = "D:\\CodegymFT\\module2\\src\\Thi_thuc_hanh_module_2\\data\\students.csv";
    private static int nextId = 1;

    private List<Student> students;
    private CsvUtils csvUtils;

    public StudentRepository() {
        students = new ArrayList<>();
        csvUtils = new CsvUtils();
        loadStudentsFromCsv();
    }

    private void loadStudentsFromCsv() {
        try {
            students = csvUtils.readStudentsFromCsv(CSV_FILE_PATH);
            if (!students.isEmpty()) {
                nextId = students.get(students.size() - 1).getId() + 1;
            }
        } catch (IOException e) {
            System.err.println("Lỗi file CSV: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public void addStudent(Student student) {
        student.setId(nextId++);
        students.add(student);
        saveStudentsToCsv();
    }

    public void deleteStudent(int studentId) {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getId() == studentId) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            saveStudentsToCsv();
        } else {
            throw new IllegalArgumentException("Học sinh với id " + studentId + " không có.");
        }
    }

    private void saveStudentsToCsv() {
        try {
            csvUtils.writeStudentsToCsv(students, CSV_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu học sinh vào CSV: " + e.getMessage());
        }
    }

    public List<Student> searchStudentByName(String name) {
        return students.stream()
                .filter(student -> student.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

}
