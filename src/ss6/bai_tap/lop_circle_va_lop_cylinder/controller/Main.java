package ss6.bai_tap.lop_circle_va_lop_cylinder.controller;
import ss6.bai_tap.lop_circle_va_lop_cylinder.service.CircleService;
import ss6.bai_tap.lop_circle_va_lop_cylinder.service.CylinderService;

public class Main {
    private static CircleService circleService = new CircleService();
    private static CylinderService cylinderService = new CylinderService();

    public static void main(String[] args) {
        // Test class Circle
        circleService.add();
        circleService.display();
        circleService.getArea();
        circleService.getPerimeter();

        // Test class Cylinder
        cylinderService.add();
        cylinderService.display();
        cylinderService.getVolume();
    }
}