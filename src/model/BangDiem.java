
package model;

import java.io.Serializable;

public class BangDiem implements Serializable {

    private String ma_hoc_vien;
    private String ho_ten_hoc_vien;
    private String hoc_ki;
    private String diem_TBCHT;
    private String xep_loai;
    
    public String getMa_hoc_vien() {
        return ma_hoc_vien;
    }

    public void setMa_hoc_vien(String ma_hoc_vien) {
        this.ma_hoc_vien = ma_hoc_vien;
    }

    public String getHo_ten_hoc_vien() {
        return ho_ten_hoc_vien;
    }

    public void setHo_ten_hoc_vien(String ho_ten_hoc_vien) {
        this.ho_ten_hoc_vien = ho_ten_hoc_vien;
    }
    
    public String getHoc_ki() {
        return hoc_ki;
    }

    public void setHoc_ki(String hoc_ki) {
        this.hoc_ki = hoc_ki;
    }
    
    public String getDiem_TBCHT() {
        return diem_TBCHT;
    }

    public void setSo_luong_sinh_vien(String diem_TBCHT) {
        this.diem_TBCHT = diem_TBCHT;
    }
    
    public String getXep_loai() {
        return xep_loai;
    }

    public void setXep_loai(String xep_loai) {
        this.xep_loai = xep_loai;
    }

    @Override
    public String toString(){
        return ma_hoc_vien + " - " + ho_ten_hoc_vien;
    }

    public void setMa_hoc_vien(int lastId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
