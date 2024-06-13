package Thi_thuc_hanh_module_2.service;

import Thi_thuc_hanh_module_2.models.Teacher;
import Thi_thuc_hanh_module_2.repositories.TeacherRepository;

import java.util.List;

public class TeacherService {
    private TeacherRepository teacherRepository = new TeacherRepository();

    public List<Teacher> getAllTeacher() {
        return teacherRepository.getAllTeacher();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.addTeacher(teacher);
    }
}
