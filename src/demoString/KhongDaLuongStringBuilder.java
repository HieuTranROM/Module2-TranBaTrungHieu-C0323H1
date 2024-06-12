package demoString;

public class KhongDaLuongStringBuilder {
    public static void main(String[] args) {
        StringBuilder sbd = new StringBuilder("0");
        for (int i = 0; i < 100; i++) {
            sbd.append(", " + i);
        }
        String result = sbd.toString();
        System.out.println(result);
    }
}
