
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.BangDiem;

public class BangDiemDAOImpl implements BangDiemDAO {

    @Override
    public List<BangDiem> getList() {
        try {
            Connection cons = (Connection) DBConnect.getConnection();
            String sql =  "SELECT * FROM bang_diem ";
            List<BangDiem> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BangDiem hocVien = new BangDiem();
                hocVien.setMa_hoc_vien(rs.getString("ma_hoc_vien"));
                hocVien.setHo_ten_hoc_vien(rs.getString("ho_ten_hoc_vien"));
                hocVien.setHoc_ki(rs.getString("hoc_ki"));
                hocVien.setDiem_TBCHT(rs.getString("diem_TBCHT"));
                hocVien.setXep_loai(rs.getString("xep_loai"));
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
        BangDiemDAO bangDiemDAO = new BangDiemDAOImpl();
        System.out.println(bangDiemDAO.getList());
    }

}