package Thi_thuc_hanh_module_2.controller;

import Thi_thuc_hanh_module_2.models.Teacher;
import Thi_thuc_hanh_module_2.service.TeacherService;

import java.util.List;
import java.time.LocalDate;

public class TeacherController {
    private TeacherService teacherService = new TeacherService();

    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeacher();
    }

    public void addTeacher(String name, LocalDate dob, String gender, String phone, String qualification) {
        List<Teacher> teachers = teacherService.getAllTeacher();
        int id = teachers.isEmpty() ? 1 : teachers.get(teachers.size() - 1).getId() + 1;
        Teacher teacher = new Teacher(id, name, dob, gender, phone, qualification);
        teacherService.addTeacher(teacher);
    }
}

