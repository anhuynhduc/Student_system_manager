
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.SinhVien;
import model.LopSinhHoat;

public class LopSinhHoatDAOImpl implements LopSinhHoatDAO {

    @Override
    public List<LopSinhHoat> getList() {
        try {
            Connection cons = (Connection) DBConnect.getConnection();
            String sql =  "SELECT * FROM lop_sinh_hoat ";
            List<LopSinhHoat> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LopSinhHoat hocVien = new LopSinhHoat();
                hocVien.setMa_lop_hoc(rs.getString("ma_lop_hoc"));
                hocVien.setTen_lop_hoc(rs.getString("ten_lop_hoc"));
                hocVien.setGiao_vien_chu_nhiem(rs.getString("giao_vien_chu_nhiem"));
                hocVien.setSo_luong_sinh_vien(rs.getString("so_luong_sinh_vien"));
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