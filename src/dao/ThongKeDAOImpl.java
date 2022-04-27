
package dao;

import bean.KhoaHocBean;
import bean.LopHocBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Admin
 */
public class ThongKeDAOImpl implements ThongKeDAO{

  @Override
    public List<LopHocBean> getListByLopHoc() {
        try {
        Connection cons = (Connection) DBConnect.getConnection();
        String sql = "SELECT ngay_dang_ky, COUNT(*) AS so_luong FROM lop_hoc GROUP BY ngay_dang_ky";
        List<LopHocBean> list = new ArrayList<>();
        PreparedStatement ps = cons.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LopHocBean lopHocBean = new LopHocBean();
                lopHocBean.setNgay_dang_ky(rs.getString("ngay_dang_ky"));
                lopHocBean.setSo_luong_hoc_vien(rs.getInt("so_luong"));
                list.add(lopHocBean);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
     @Override
    public List<KhoaHocBean> getListByKhoaHoc() {
        try {
        Connection cons = (Connection) DBConnect.getConnection();
        String sql = "SELECT ten_khoa_hoc, ngay_bat_dau, ngay_ket_thuc FROM khoa_hoc WHERE tinh_trang = TRUE";
        List<KhoaHocBean> list = new ArrayList<>();
        PreparedStatement ps = cons.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhoaHocBean khoaHocBean = new KhoaHocBean();
                KhoaHocBean.setTenKhoaHoc(rs.getString("ten_khoa_hoc"));
                KhoaHocBean.setNgayBatDau(rs.getString("ngay_bat_dau"));
                KhoaHocBean.setNgayKetThuc(rs.getString("ngay_ket_thuc"));
                list.add(khoaHocBean);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
