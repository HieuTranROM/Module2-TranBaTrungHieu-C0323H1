package ss11.bai_tap.to_chuc_du_lieu_hop_ly_Demerging_su_dung_Queue;

import java.util.*;

class Employee {
    String name;
    String gender;
    String dateOfBirth;

    public Employee(String name, String gender, String dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return name + ", " + gender + ", " + dateOfBirth;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "Female", "1990-03-15"));
        employees.add(new Employee("Bob", "Male", "1985-08-22"));
        employees.add(new Employee("Eve", "Female", "1992-05-10"));
        employees.add(new Employee("John", "Male", "1987-11-05"));
        employees.add(new Employee("Lucy", "Female", "1989-12-30"));
        employees.add(new Employee("Michael", "Male", "1991-06-20"));

        Queue<Employee> femaleQueue = new LinkedList<>();
        Queue<Employee> maleQueue = new LinkedList<>();


        for (Employee employee : employees) {
            if (employee.gender.equals("Female")) {
                femaleQueue.add(employee);
            } else {
                maleQueue.add(employee);
            }
        }


        Queue<Employee> finalQueue = new LinkedList<>();
        finalQueue.addAll(femaleQueue);
        finalQueue.addAll(maleQueue);


        System.out.println("Danh sach nhan vien da sap xep:");
        while (!finalQueue.isEmpty()) {
            System.out.println(finalQueue.poll());
        }
    }
}
