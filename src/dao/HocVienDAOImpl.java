
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.HocVien;

public class HocVienDAOImpl implements HocVienDAO {

    @Override
    public List<HocVien> getList() {
        try {
            Connection cons = (Connection) DBConnect.getConnection();
            String sql = "SELECT * FROM hoc_vien";
            List<HocVien> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HocVien hocVien = new HocVien();
                hocVien.setMa_hoc_vien(rs.getString("ma_hoc_vien"));
                hocVien.setHo_ten(rs.getString("ho_ten"));
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
    public int createOrUpdate(HocVien hocVien) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "MERGE INTO hoc_vien AS t\n" +
"USING \n" +
"(SELECT ma_hoc_vien=?, ho_ten=?, ngay_sinh=?, gioi_tinh=?, so_dien_thoai=?, dia_chi=?, tinh_trang=?) AS s\n" +
"ON t.ma_hoc_vien = s.ma_hoc_vien\n" +
"WHEN MATCHED THEN\n" +
"UPDATE SET ma_hoc_vien=s.ma_hoc_vien, ho_ten=s.ho_ten, ngay_sinh=s.ngay_sinh, gioi_tinh=s.gioi_tinh, so_dien_thoai=s.so_dien_thoai, dia_chi=s.dia_chi, tinh_trang=s.tinh_trang\n" +
"WHEN NOT MATCHED THEN\n" +
"INSERT(ma_hoc_vien, ho_ten, ngay_sinh, gioi_tinh, so_dien_thoai, dia_chi, tinh_trang)\n" +
"VALUES(s.ma_hoc_vien, s.ho_ten, s.ngay_sinh, s.gioi_tinh, s.so_dien_thoai, s.dia_chi, s.tinh_trang);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, hocVien.getMa_hoc_vien());
            ps.setString(2, hocVien.getHo_ten());
            ps.setDate(3, hocVien.getNgay_sinh());
            ps.setBoolean(4, hocVien.isGioi_tinh());
            ps.setString(5, hocVien.getSo_dien_thoai());
            ps.setString(6, hocVien.getDia_chi());
            ps.setBoolean(7, hocVien.isTinh_trang());
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
        HocVienDAO hocVienDAO = new HocVienDAOImpl();
        System.out.println(hocVienDAO.getList());
    }

}