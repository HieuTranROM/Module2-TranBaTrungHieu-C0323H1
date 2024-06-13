package Thi_thuc_hanh_module_2.repositories;

import Thi_thuc_hanh_module_2.models.Teacher;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {
    private static final String FILE_PATH = "D:\\CodegymFT\\module2\\src\\Thi_thuc_hanh_module_2\\data\\teacher.csv";

    public List<Teacher> getAllTeacher() {
        List<Teacher> teachers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Teacher teacher = new Teacher(
                        Integer.parseInt(data[0]),
                        data[1],
                        LocalDate.parse(data[2]),
                        data[3],
                        data[4],
                        data[5]
                );
                teachers.add(teacher);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(teacher.getId() + "," + teacher.getName() + "," + teacher.getDob() + "," + teacher.getGender() + "," + teacher.getPhone() + "," + teacher.getQualification());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
