package ss15.bai_tap.su_dung_lop_IllegalTriangleException;

public class IllegalRightTriangleException extends Exception{
    private String message = "";
    public IllegalRightTriangleException() {
    }

    public IllegalRightTriangleException(String message) {
        this.message = message;
        System.out.println(message);
    }

    public String getMessage(){
        return message;
    }
}