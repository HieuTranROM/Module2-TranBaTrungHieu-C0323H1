package Thi_thuc_hanh_module_2.models;

import java.time.LocalDate;

public class Student extends Person {
    private String courseId;

    public Student(int id, String name, LocalDate dob, String gender, String phone, String courseId) {
        super(id, name, dob, gender, phone);
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", dob=" + getDob() +
                ", gender='" + getGender() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }

    @Override
    public String getRole() {
        return "";
    }
}
