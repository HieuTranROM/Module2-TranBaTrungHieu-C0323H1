package ss16.bai_tap.copy_file_text;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập đường dẫn tập tin nguồn:");
        String pathSourceFile = scanner.nextLine();
        System.out.println("Nhập đường dẫn tập tin đích:");
        String pathTargetFile = scanner.nextLine();

        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<String> strings = readAndWriteFile.readFile(pathSourceFile);
        if (strings.size() > 0) {
            readAndWriteFile.writeFile(pathTargetFile, strings);
        }
    }
}