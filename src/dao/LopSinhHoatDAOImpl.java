
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.SinhVien;

public class LopSinhHoatDAOImpl implements LopSinhHoatDAO {

    @Override
    public List<SinhVien> getList() {
        try {
            Connection cons = (Connection) DBConnect.getConnection();
            String sql =  "SELECT * FROM hoc_vien As s \n where s.ten_lop_hoc='20T2'";
            List<SinhVien> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien hocVien = new SinhVien();
                hocVien.setMa_hoc_vien(rs.getString("ma_hoc_vien"));
                hocVien.setHo_ten(rs.getString("ho_ten"));
                hocVien.setTen_lop_hoc(rs.getString("ten_lop_hoc"));
                hocVien.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                hocVien.setDia_chi(rs.getString("dia_chi"));
                hocVien.setNgay_sinh(rs.getDate("ngay_sinh"));
                hocVien.setGioi_tinh(rs.getBoolean("gioi_tinh"));
                hocVien.setTinh_trang(rs.getBoolean("tinh_trang"));
                list.add(hocVien);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
   
    public static void main(String[] args){
        LopSinhHoatDAO lopSinhHoatDAO = new LopSinhHoatDAOImpl();
        System.out.println(lopSinhHoatDAO.getList());
    }

}