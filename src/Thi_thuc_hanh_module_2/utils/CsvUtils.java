package Thi_thuc_hanh_module_2.utils;

import Thi_thuc_hanh_module_2.models.Student;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {
    private static final String CSV_SEPARATOR = ",";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public List<Student> readStudentsFromCsv(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(CSV_SEPARATOR);
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                LocalDate dob = LocalDate.parse(data[2].trim(), DATE_FORMATTER);
                String gender = data[3].trim();
                String phone = data[4].trim();
                String courseId = data[5].trim();
                Student student = new Student(id, name, dob, gender, phone, courseId);
                students.add(student);
            }
        }
        return students;
    }

    public void writeStudentsToCsv(List<Student> students, String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("ID,Name,DOB,Gender,Phone,CourseID\n");
            for (Student student : students) {
                bw.write(student.getId() + CSV_SEPARATOR +
                        student.getName() + CSV_SEPARATOR +
                        student.getDob().format(DATE_FORMATTER) + CSV_SEPARATOR +
                        student.getGender() + CSV_SEPARATOR +
                        student.getPhone() + CSV_SEPARATOR +
                        student.getCourseId() + "\n");
            }
        }
    }
}
