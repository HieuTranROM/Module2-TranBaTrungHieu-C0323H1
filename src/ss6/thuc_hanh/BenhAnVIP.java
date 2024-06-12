package ss6.thuc_hanh;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BenhAnVIP extends BenhAn {
    private String loaiVIP;
    private Date thoiHanVIP;

    public BenhAnVIP(int soThuTu, String maBenhAn, String maBenhNhan, String tenBenhNhan, Date ngayNhapVien, Date ngayRaVien, String lyDoNhapVien, String loaiVIP, Date thoiHanVIP) {
        super(soThuTu, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.loaiVIP = loaiVIP;
        this.thoiHanVIP = thoiHanVIP;
    }

    @Override
    public String getAdditionalInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return loaiVIP + "," + sdf.format(thoiHanVIP);
    }

    // Getters and Setters
    public String getLoaiVIP() {
        return loaiVIP;
    }

    public void setLoaiVIP(String loaiVIP) {
        this.loaiVIP = loaiVIP;
    }

    public Date getThoiHanVIP() {
        return thoiHanVIP;
    }

    public void setThoiHanVIP(Date thoiHanVIP) {
        this.thoiHanVIP = thoiHanVIP;
    }
}


