
package controller;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.TaiKhoan;
import service.TaiKhoanService;
import service.TaiKhoanServiceImpl;
import view.MainJFrame;

/**
 *
 * @author Admin
 */
public class TaiKhoanController {
    private Dialog dialog;
    private JButton btnSubmit;
    private JTextField jtfTenDangNhap;
    private JPasswordField jtfMatKhau;
    private JLabel jlbMsg;
    
    private TaiKhoanService taiKhoanService = null;


    public TaiKhoanController(Dialog dialog, JButton btnSubmit,
            JTextField jtfTenDangNhap, JPasswordField jtfMatKhau, JLabel jlbMsg) {
        this.dialog = dialog;
        this.btnSubmit = btnSubmit;
        this.jtfTenDangNhap = jtfTenDangNhap;
        this.jtfMatKhau = jtfMatKhau;
        this.jlbMsg = jlbMsg;
        
        taiKhoanService = new TaiKhoanServiceImpl();
    }
    
    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfTenDangNhap.getText().length() == 0 || jtfMatKhau.getText().length() == 0){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                }else{
                        TaiKhoan taiKhoan = taiKhoanService.login(jtfTenDangNhap.getText(), jtfMatKhau.getText());
                        if (taiKhoan == null) {
                            jlbMsg.setText("Tên đăng nhập và mật khẩu không đúng!");
                        } else {
                            if (!taiKhoan.isTinh_trang()) {
                                jlbMsg.setText("Tài khoản của bạn đang bị tạm khóa!");
                            } else {
                                dialog.dispose();
                                MainJFrame frame = new MainJFrame();
                                frame.setTitle("Quản lý học viên");
                                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                frame.setVisible(true);
                            }
                }
            }
            
            
        };
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }
    });
}
}
