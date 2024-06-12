package ss6.thuc_hanh;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class QuanLyBenhAn {
    private static final String FILE_PATH = "data/medical_records.csv";
    private static List<BenhAn> danhSachBenhAn = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Load existing records from file
        loadDanhSachBenhAn();

        do {
            System.out.println("1. Thêm mới bệnh án");
            System.out.println("2. Xóa bệnh án");
            System.out.println("3. Xem danh sách bệnh án");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    themMoiBenhAn(scanner);
                    break;
                case 2:
                    xoaBenhAn(scanner);
                    break;
                case 3:
                    xemDanhSachBenhAn();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    private static void themMoiBenhAn(Scanner scanner) {
        int soThuTu = danhSachBenhAn.size() + 1;
        String maBenhAn = ""; // Khởi tạo maBenhAn với giá trị mặc định

        while (true) {
            System.out.print("Nhập mã bệnh án (định dạng BA-XXX): ");
            maBenhAn = scanner.nextLine();
            if (!maBenhAn.matches("BA-\\d{3}")) {
                System.out.println("Mã bệnh án không đúng định dạng.");
                continue;
            }
            String finalMaBenhAn = maBenhAn; // Biến tạm thời để sử dụng trong lambda
            boolean exists = danhSachBenhAn.stream().anyMatch(ba -> ba.getMaBenhAn().equals(finalMaBenhAn));
            if (exists) {
                System.out.println("Bệnh án đã tồn tại.");
            } else {
                break;
            }
        }

        System.out.print("Nhập mã bệnh nhân (định dạng BN-XXX): ");
        String maBenhNhan = scanner.nextLine();
        System.out.print("Nhập tên bệnh nhân: ");
        String tenBenhNhan = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date ngayNhapVien = null;
        while (true) {
            try {
                System.out.print("Nhập ngày nhập viện (dd/MM/yyyy): ");
                ngayNhapVien = sdf.parse(scanner.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println("Ngày không đúng định dạng.");
            }
        }

        Date ngayRaVien = null;
        while (true) {
            try {
                System.out.print("Nhập ngày ra viện (dd/MM/yyyy): ");
                ngayRaVien = sdf.parse(scanner.nextLine());
                if (!ngayRaVien.before(ngayNhapVien)) {
                    break;
                } else {
                    System.out.println("Ngày ra viện phải sau hoặc bằng ngày nhập viện.");
                }
            } catch (ParseException e) {
                System.out.println("Ngày không đúng định dạng.");
            }
        }

        System.out.print("Nhập lý do nhập viện: ");
        String lyDoNhapVien = scanner.nextLine();

        System.out.println("Chọn loại bệnh án: ");
        System.out.println("1. Bệnh án thường");
        System.out.println("2. Bệnh án VIP");
        int loaiBenhAn = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (loaiBenhAn == 1) {
            System.out.print("Nhập phí nằm viện: ");
            double phiNamVien = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            BenhAnThuong benhAnThuong = new BenhAnThuong(soThuTu, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien, phiNamVien);
            danhSachBenhAn.add(benhAnThuong);
        } else if (loaiBenhAn == 2) {
            System.out.print("Nhập loại VIP (VIP I, VIP II, VIP III): ");
            String loaiVIP = scanner.nextLine();
            Date thoiHanVIP = null;
            while (true) {
                try {
                    System.out.print("Nhập thời hạn VIP (dd/MM/yyyy): ");
                    thoiHanVIP = sdf.parse(scanner.nextLine());
                    break;
                } catch (ParseException e) {
                    System.out.println("Ngày không đúng định dạng.");
                }
            }
            BenhAnVIP benhAnVIP = new BenhAnVIP(soThuTu, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien, loaiVIP, thoiHanVIP);
            danhSachBenhAn.add(benhAnVIP);
        } else {
            System.out.println("Loại bệnh án không hợp lệ.");
        }

        luuDanhSachBenhAn();
        System.out.println("Thêm mới bệnh án thành công.");
    }
    
    private static void xoaBenhAn(Scanner scanner) {
        System.out.print("Nhập mã bệnh án cần xóa: ");
        String maBenhAn = scanner.nextLine();
        BenhAn benhAn = danhSachBenhAn.stream()
                .filter(ba -> ba.getMaBenhAn().equals(maBenhAn))
                .findFirst()
                .orElse(null);
        if (benhAn == null) {
            System.out.println("Không tìm thấy bệnh án với mã này.");
            return;
        }
        System.out.print("Bạn có chắc chắn muốn xóa bệnh án này không? (Yes/No): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Yes")) {
            danhSachBenhAn.remove(benhAn);
            luuDanhSachBenhAn();
            System.out.println("Xóa bệnh án thành công.");
        } else {
            System.out.println("Hủy xóa bệnh án.");
        }
    }

    private static void xemDanhSachBenhAn() {
        for (BenhAn benhAn : danhSachBenhAn) {
            System.out.println(benhAn);
        }
    }

    private static void luuDanhSachBenhAn() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (BenhAn benhAn : danhSachBenhAn) {
                writer.write(benhAn.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu danh sách bệnh án: " + e.getMessage());
        }
    }

    private static void loadDanhSachBenhAn() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int soThuTu = Integer.parseInt(parts[0]);
                String maBenhAn = parts[1];
                String maBenhNhan = parts[2];
                String tenBenhNhan = parts[3];
                Date ngayNhapVien = sdf.parse(parts[4]);
                Date ngayRaVien = sdf.parse(parts[5]);
                String lyDoNhapVien = parts[6];
                if (parts.length == 8) {
                    double phiNamVien = Double.parseDouble(parts[7]);
                    BenhAnThuong benhAnThuong = new BenhAnThuong(soThuTu, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien, phiNamVien);
                    danhSachBenhAn.add(benhAnThuong);
                } else if (parts.length == 9) {
                    String loaiVIP = parts[7];
                    Date thoiHanVIP = sdf.parse(parts[8]);
                    BenhAnVIP benhAnVIP = new BenhAnVIP(soThuTu, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien, loaiVIP, thoiHanVIP);
                    danhSachBenhAn.add(benhAnVIP);
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Lỗi khi tải danh sách bệnh án: " + e.getMessage());
        }
    }
}

