package Thi_thuc_hanh_module_2.models;

import java.time.LocalDate;

public class Teacher extends Person {
    private String qualification;

    public Teacher(int id, String name, LocalDate dob, String gender, String phone, String qualification) {
        super(id, name, dob, gender, phone);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", dob=" + getDob() +
                ", gender='" + getGender() + '\'' +
                ", phone='" + getPhone() + '\'' +
                "qualification='" + qualification + '\'' +
                '}';
    }

    @Override
    public String getRole() {
        return "Teacher";
    }
}

