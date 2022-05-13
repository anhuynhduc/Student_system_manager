
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
            String sql =  "SELECT * FROM hoc_vien ";
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
    
    @Override
    public int Find(SinhVien hocVien) {
    try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM hoc_vien where ten_lop_hoc like ?" ;
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, hocVien.getMa_hoc_vien());
            ps.setString(2, hocVien.getHo_ten());
            ps.setString(3, hocVien.getTen_lop_hoc());
            ps.setDate(4, hocVien.getNgay_sinh());
            ps.setBoolean(5, hocVien.isGioi_tinh());
            ps.setString(6, hocVien.getSo_dien_thoai());
            ps.setString(7, hocVien.getDia_chi());
            ps.setBoolean(8, hocVien.isTinh_trang());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
   
    public static void main(String[] args){
        LopSinhHoatDAO lopSinhHoatDAO = new LopSinhHoatDAOImpl();
        System.out.println(lopSinhHoatDAO.getList());
    }

}