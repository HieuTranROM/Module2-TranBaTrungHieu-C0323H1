package ss6.bai_tap.lop_point_va_moveable_point.controller;
import ss6.bai_tap.lop_point_va_moveable_point.model.MoveablePoint;
import ss6.bai_tap.lop_point_va_moveable_point.service.MoveablePointService;
import ss6.bai_tap.lop_point_va_moveable_point.service.PointService;

public class Main {

    private static PointService pointService = new PointService();
    private static MoveablePointService moveablePointService = new MoveablePointService();

    public static void main(String[] args) {
        // Test class Point
        pointService.add();
        pointService.display();

        // Test class MoveablePoint
        moveablePointService.add();
        moveablePointService.display();
        System.out.println("After move:");
        moveablePointService.move();
    }
}

