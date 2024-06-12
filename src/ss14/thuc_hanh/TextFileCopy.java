package ss14.thuc_hanh;
import java.io.*;
public class TextFileCopy {

        public static void main(String[] args) {
            // Đường dẫn tệp nguồn và tệp đích
            String sourceFilePath = "duong_dan_tep_nguon.txt";   // Thay đổi đường dẫn cho tệp nguồn
            String targetFilePath = "duong_dan_tep_dich.txt";    // Thay đổi đường dẫn cho tệp đích

            try {
                // Tạo luồng đầu vào và luồng đầu ra
                FileReader reader = new FileReader(sourceFilePath);
                FileWriter writer = new FileWriter(targetFilePath);

                // Sao chép nội dung từ tệp nguồn đến tệp đích
                int character;
                int charCount = 0;
                while ((character = reader.read()) != -1) {
                    writer.write(character);
                    charCount++;
                }

                // Đóng luồng sau khi sao chép
                reader.close();
                writer.close();

                // Hiển thị số ký tự đã sao chép
                System.out.println("Sao chép thành công. Số ký tự trong tệp: " + charCount);
            } catch (FileNotFoundException e) {
                System.out.println("Lỗi: Tệp nguồn không tồn tại.");
            } catch (IOException e) {
                System.out.println("Lỗi khi đọc/ghi tệp: " + e.getMessage());
            }
        }
    }


