
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
import service.LopSinhHoatServiceImpl;
import service.LopSinhHoatService;



/**
 *
 * @author Admin
 */
public class LopSinhHoatController {
    private JButton btnSubmit;
    private JTextField jtfSearch;
    
    private SinhVien hocVien = null;
    
    private LopSinhHoatService lopSinhHoatService = null;
    
    /**
     *
     * @param btnSubmit
     * @param jtfMaHocVien
     * @param jtfHoTen
     * @param jtfTenLopHoc
     */
    public LopSinhHoatController(JButton btnSubmit, JTextField jtfSearch){
        this.btnSubmit = btnSubmit;
        this.jtfSearch = jtfSearch;

        
        this.lopSinhHoatService = new LopSinhHoatServiceImpl();
    }
   
    
    public void setView(SinhVien hocVien) {
        this.hocVien = hocVien;
        jtfSearch.setText(hocVien.getTen_lop_hoc());
        
    }
    
    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
            lopSinhHoatService.Find(hocVien);
                       
            }
            
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
