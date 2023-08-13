package com.fpoly.thi_test1.DTO;

public class SinhVien {
    private String Masv;
    private String hoten;
    private String email;
    private String diaChi;
    private float diem;
    private String anh;

//    public SinhVien() {
//    }

    public SinhVien(String masv, String hoten, String email, String diaChi, float diem, String anh) {
        Masv = masv;
        this.hoten = hoten;
        this.email = email;
        this.diaChi = diaChi;
        this.diem = diem;
        this.anh = anh;
    }

    public String getMasv() {
        return Masv;
    }

    public void setMasv(String masv) {
        Masv = masv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "Masv='" + Masv + '\'' +
                ", hoten='" + hoten + '\'' +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", diem=" + diem +
                ", anh='" + anh + '\'' +
                '}';
    }
}
