
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.ThoiKhoaBieu;

public class ThoiKhoaBieuDAOImpl implements ThoiKhoaBieuDAO {

    @Override
    public List<ThoiKhoaBieu> getList() {
        try {
            Connection cons = (Connection) DBConnect.getConnection();
            String sql =  "SELECT * FROM thoi_khoa_bieu ";
            List<ThoiKhoaBieu> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThoiKhoaBieu hocVien = new ThoiKhoaBieu();
                hocVien.setMa_hoc_vien(rs.getString("ma_hoc_vien"));
                hocVien.setTen_lop_hoc_phan(rs.getString("ten_lop_hoc_phan"));
                hocVien.setTen_mon_hoc(rs.getString("ten_mon_hoc"));
                hocVien.setThu(rs.getString("thu"));
                hocVien.setTu_tiet(rs.getString("tu_tiet"));
                hocVien.setDen_tiet(rs.getString("den_tiet"));
                hocVien.setTen_giang_vien(rs.getString("ten_giang_vien"));
                hocVien.setPhong(rs.getString("phong"));
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
        ThoiKhoaBieuDAO thoiKhoaBieuDAO = new ThoiKhoaBieuDAOImpl();
        System.out.println(thoiKhoaBieuDAO.getList());
    }

}