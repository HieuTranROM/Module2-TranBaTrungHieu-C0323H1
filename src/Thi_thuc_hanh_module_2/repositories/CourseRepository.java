package Thi_thuc_hanh_module_2.repositories;

import Thi_thuc_hanh_module_2.models.Course;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private static final String FILE_PATH = "D:\\CodegymFT\\module2\\src\\Thi_thuc_hanh_module_2\\data\\batchs.csv"; // Đường dẫn tới file CSV để lưu dữ liệu

    private List<Course> courses;

    public CourseRepository() {
        this.courses = new ArrayList<>();

    }

    public void addCourse(Course course) {
        courses.add(course);
        saveCoursesToFile();
    }

    private void saveCoursesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Course course : courses) {
                writer.write(courseToCsv(course));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    private String courseToCsv(Course course) {
        return String.format("%s,%s,%s", course.getCourseId(), course.getCourseName(), course.getTeacherId());
    }

}
