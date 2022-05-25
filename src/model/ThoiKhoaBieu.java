
package model;

import java.io.Serializable;

public class ThoiKhoaBieu implements Serializable {

    private String ma_hoc_vien;
    private String ten_lop_hoc_phan;
    private String ten_mon_hoc;
    private String thu;
    private String tu_tiet;
    private String den_tiet;
    private String ten_giang_vien;
    private String phong;
    
    public String getMa_hoc_vien() {
        return ma_hoc_vien;
    }

    public void setMa_hoc_vien(String ma_hoc_vien) {
        this.ma_hoc_vien = ma_hoc_vien;
    }

    public String getTen_lop_hoc_phan() {
        return ten_lop_hoc_phan;
    }

    public void setTen_lop_hoc_phan(String ten_lop_hoc_phan) {
        this.ten_lop_hoc_phan = ten_lop_hoc_phan;
    }
    
    public String getTen_mon_hoc() {
        return ten_mon_hoc;
    }

    public void setTen_mon_hoc(String ten_mon_hoc) {
        this.ten_mon_hoc = ten_mon_hoc;
    }
    
    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }
    
    public String getTu_tiet() {
        return tu_tiet;
    }

    public void setTu_tiet(String tu_tiet) {
        this.tu_tiet = tu_tiet;
    }
    
    public String getDen_tiet() {
        return den_tiet;
    }

    public void setDen_tiet(String den_tiet) {
        this.den_tiet = den_tiet;
    }
    
    public String getTen_giang_vien() {
        return ten_giang_vien;
    }

    public void setTen_giang_vien(String ten_giang_vien) {
        this.ten_giang_vien = ten_giang_vien;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }


    @Override
    public String toString(){
        return ma_hoc_vien + " - " + ten_lop_hoc_phan;
    }

    public void setMa_hoc_vien(int lastId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
