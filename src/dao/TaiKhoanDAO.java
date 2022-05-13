
package dao;

import model.TaiKhoan;

/**
 *
 * @author Admin
 */
public interface TaiKhoanDAO {
    public TaiKhoan login(String tdn, String mk);// tạo tài khoản và mật khẩu
}
