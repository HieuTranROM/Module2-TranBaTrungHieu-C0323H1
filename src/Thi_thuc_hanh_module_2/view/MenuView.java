package Thi_thuc_hanh_module_2.view;

import Thi_thuc_hanh_module_2.controller.StudentController;
import Thi_thuc_hanh_module_2.controller.TeacherController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MenuView {
    private Scanner scanner = new Scanner(System.in);
    private StudentController studentController = new StudentController();
    private TeacherController teacherController = new TeacherController();

    public void displayMenu() {
        int choice = 0;
        do {
            System.out.println("----------Quản lý sinh viên và giáo viên----------");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Xem danh sách sinh viên");
            System.out.println("4. Tìm kiếm sinh viên");
            System.out.println("5. Thêm mới giáo viên");
            System.out.println("6. Xem danh sách giáo viên");
            System.out.println("7. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline character after nextInt()

            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    displayAllStudent();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    addNewTeacher();
                    break;
                case 6:
                    displayTeacherInfo();
                    break;
                case 7:
                    System.out.println("Đã thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại");
            }
        } while (choice != 7);
    }

    public void addNewStudent() {
        System.out.println("Nhập thông tin sinh viên mới:");
        System.out.print("Tên sinh viên: ");
        String name = scanner.nextLine();
        LocalDate dob = null;
        boolean validDate = false;
        while (!validDate) {
            System.out.print("Ngày sinh (dd/MM/yyyy): ");
            String dobStr = scanner.nextLine();
            try {
                dob = LocalDate.parse(dobStr, StudentController.DATE_FORMATTER);
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng ngày sinh không hợp lệ. Vui lòng nhập lại.");
            }
        }
        System.out.print("Giới tính (Nam/Nữ): ");
        String gender = scanner.nextLine();
        System.out.print("Số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.print("Mã lớp học: ");
        String courseId = scanner.nextLine();
        studentController.addStudent(name, dob, gender, phone, courseId);
    }

    private void deleteStudent() {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character in the buffer
        studentController.deleteStudent(studentId);
    }

    private void displayAllStudent() {
        System.out.println("Danh sách sinh viên: ");
        studentController.getAllStudents().forEach(System.out::println);
    }

    private void searchStudent() {
        System.out.print("Nhập tên sinh viên cần tìm kiếm: ");
        String name = scanner.nextLine();
        studentController.searchStudentByName(name).forEach(System.out::println);
    }

    private void addNewTeacher() {
        System.out.println("Nhập thông tin giáo viên mới:");
        System.out.print("Tên giáo viên: ");
        String name = scanner.nextLine();
        LocalDate dob = null;
        boolean validDate = false;
        while (!validDate) {
            System.out.print("Ngày sinh (dd/MM/yyyy): ");
            String dobStr = scanner.nextLine();
            try {
                dob = LocalDate.parse(dobStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng ngày sinh không hợp lệ. Vui lòng nhập lại.");
            }
        }
        System.out.print("Giới tính (Nam/Nữ): ");
        String gender = scanner.nextLine();
        System.out.print("Số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.print("Trình độ học vấn: ");
        String qualification = scanner.nextLine();
        teacherController.addTeacher(name, dob, gender, phone, qualification);
    }

    private void displayTeacherInfo() {
        System.out.println("Danh sách giáo viên:");
        teacherController.getAllTeachers().forEach(System.out::println);
    }
}
