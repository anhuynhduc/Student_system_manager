
package model;

import java.io.Serializable;

public class LopSinhHoat implements Serializable {

    private String ma_lop_hoc;
    private String ten_lop_hoc;
    private String giao_vien_chu_nhiem;
    private int so_luong_sinh_vien;

    public String getMa_lop_hoc() {
        return ma_lop_hoc;
    }

    public void setMa_lop_hoc(String ma_lop_hoc) {
        this.ma_lop_hoc = ma_lop_hoc;
    }

    public String getTen_lop_hoc() {
        return ten_lop_hoc;
    }

    public void setTen_lop_hoc(String ten_lop_hoc) {
        this.ten_lop_hoc = ten_lop_hoc;
    }
    
    public String getGiao_vien_chu_nhiem() {
        return giao_vien_chu_nhiem;
    }

    public void setGiao_vien_chu_nhiem(String giao_vien_chu_nhiem) {
        this.giao_vien_chu_nhiem = giao_vien_chu_nhiem;
    }
    
    public int getSo_luong_sinh_vien() {
        return so_luong_sinh_vien;
    }

    public void setSo_luong_sinh_vien(int so_luong_sinh_vien) {
        this.so_luong_sinh_vien = so_luong_sinh_vien;
    }

    @Override
    public String toString(){
        return ma_lop_hoc + " - " + ten_lop_hoc;
    }

    public void setMa_hoc_vien(int lastId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
