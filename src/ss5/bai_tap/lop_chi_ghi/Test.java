package ss5.bai_tap.lop_chi_ghi;

public class Test {

    public static void main(String[] args) {
        Student student1 = new Student();
        System.out.println("Name: " + student1.getName());
        System.out.println("Classes: " + student1.getClasses());

        student1.setName("Harry Potter");
        student1.setClasses("Hogwarts");

        System.out.println("Name: " + student1.getName());
        System.out.println("Classes: " + student1.getClasses());
    }
}
