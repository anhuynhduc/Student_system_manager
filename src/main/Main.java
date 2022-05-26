
package main;

import view.DangNhapJDialog;
import view.MainJFrame;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        //new MainJFrame().setVisible();
        DangNhapJDialog dialog = new DangNhapJDialog(null, true);
        // loggin
        dialog.setTitle("Đăng nhập hệ thống");
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
