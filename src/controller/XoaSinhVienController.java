
package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import model.SinhVien;
import service.SinhVienServiceImpl;
import service.SinhVienService;



/**
 *
 * @author Admin
 */
public class XoaSinhVienController {
    private JButton btnSubmit1;
    private JTextField jtfMaHocVien;
    private JLabel jlbMsg;
    
    private SinhVien hocVien = null;
    
    private SinhVienService hocVienService = null;
    
    /**
     *
     * @param btnSubmit
     * @param jtfMaHocVien
     * @param jtfHoTen
     * @param jtfTenLopHoc
     */
    public XoaSinhVienController(JButton btnSubmit1, JTextField jtfMaHocVien, JLabel jlbMsg){
        this.btnSubmit1 = btnSubmit1;
        this.jtfMaHocVien = jtfMaHocVien;
        this.jlbMsg = jlbMsg;
        
        this.hocVienService = new SinhVienServiceImpl();
    }
    public XoaSinhVienController(JButton btnSubmit1, JTextField jtfMaHocVien, JTextField jtfHoTen, JTextField jtfTenLopHoc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void setView(SinhVien hocVien) {
        this.hocVien = hocVien;
        jtfMaHocVien.setText(hocVien.getMa_hoc_vien());
        
    }
    
    public void setEvent() {
        btnSubmit1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                         hocVienService.deleteOrUpdate(hocVien);
                        jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit1.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit1.setBackground(new Color(100, 221, 23));
            }

        });
    }
    
}
