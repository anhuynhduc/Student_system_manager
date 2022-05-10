
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
public class SinhVienController {
    private JButton btnSubmit;
    private JTextField jtfMaHocVien;
    private JTextField jtfHoTen;
    private JTextField jtfTenLopHoc;
    private JDateChooser jdcNgaySinh;
    private JTextField jtfSoDienThoai;
    private JRadioButton jtfNam;
    private JRadioButton jtfNu;
    private JTextArea jtaDiaChi;
    private JCheckBox jcbTinhTrang;
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
    public SinhVienController(JButton btnSubmit, JTextField jtfMaHocVien, JTextField jtfHoTen,JTextField jtfTenLopHoc,
            JDateChooser jdcNgaySinh, JTextField jtfSoDienThoai, JRadioButton jtfGioiNam, JRadioButton jtfNu,
            JTextArea jtaDiaChi, JCheckBox jcbTinhTrang, JLabel jlbMsg){
        this.btnSubmit = btnSubmit;
        this.jtfMaHocVien = jtfMaHocVien;
        this.jtfHoTen = jtfHoTen;
        this.jtfTenLopHoc = jtfTenLopHoc;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtfNam = jtfNam;
        this.jtfNu = jtfNu;
        this.jtaDiaChi = jtaDiaChi;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbMsg = jlbMsg;
        
        this.hocVienService = new SinhVienServiceImpl();
    }

    public SinhVienController(JButton btnSubmit, JTextField jtfMaHocVien, JTextField jtfHoTen, JDateChooser jdcNgaySinh, JTextField jtfSoDienThoai, JRadioButton jrdNam, JRadioButton jrdNu, JTextArea jtaDiaChi, JCheckBox jcbTinhTrang, JLabel jlbMsg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public SinhVienController(JButton btnSubmit, JTextField jtfMaHocVien, JTextField jtfHoTen, JTextField jtfTenLopHoc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void setView(SinhVien hocVien) {
        this.hocVien = hocVien;
        jtfMaHocVien.setText("#" + hocVien.getMa_hoc_vien());
        jtfHoTen.setText(hocVien.getHo_ten());
        jtfTenLopHoc.setText(hocVien.getTen_lop_hoc());
        jdcNgaySinh.setDate(hocVien.getNgay_sinh());
        
        //if (hocVien.isGioi_tinh()) {
           // jtfNam.setSelected(true);
           
        //} else {
          
            //jtfNu.setSelected(true);
       // }
        jtfSoDienThoai.setText(hocVien.getSo_dien_thoai());
        jtaDiaChi.setText(hocVien.getDia_chi());
        jcbTinhTrang.setSelected(hocVien.isTinh_trang());
    }
    
    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfHoTen.getText().length() == 0 || jdcNgaySinh.getDate() == null){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                }else{
                        hocVien.setHo_ten(jtfHoTen.getText());
                        hocVien.setTen_lop_hoc(jtfTenLopHoc.getText());
                        hocVien.setNgay_sinh(covertDateToDateSql(jdcNgaySinh.getDate()));
                        hocVien.setSo_dien_thoai(jtfSoDienThoai.getText());
                        hocVien.setDia_chi(jtaDiaChi.getText());
                        //hocVien.setGioi_tinh(jtfNam.isSelected());
                        hocVien.setTinh_trang(jcbTinhTrang.isSelected());
                        int lastId = hocVienService.createOrUpdate(hocVien);
                        if (lastId > 0) {
                        hocVien.setMa_hoc_vien(lastId);
                        jtfMaHocVien.setText("#" + lastId);
                        jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                        }
                }
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }

            private java.sql.Date covertDateToDateSql(Date d) {
                return new java.sql.Date(d.getTime());
            }
        });
        
        btnSubmit.removeMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfHoTen.getText().length() == 0 || jdcNgaySinh.getDate() == null){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                }else{
                        hocVien.setHo_ten(jtfHoTen.getText());
                        hocVien.setTen_lop_hoc(jtfTenLopHoc.getText());
                        hocVien.setNgay_sinh(covertDateToDateSql(jdcNgaySinh.getDate()));
                        hocVien.setSo_dien_thoai(jtfSoDienThoai.getText());
                        hocVien.setDia_chi(jtaDiaChi.getText());
                        //hocVien.setGioi_tinh(jtfNam.isSelected());
                        hocVien.setTinh_trang(jcbTinhTrang.isSelected());
                        int lastId = hocVienService.createOrUpdate(hocVien);
                        if (lastId > 0) {
                        hocVien.setMa_hoc_vien(lastId);
                        jtfMaHocVien.setText("#" + lastId);
                        jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                        }
                }
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }

            private java.sql.Date covertDateToDateSql(Date d) {
                return new java.sql.Date(d.getTime());
            }
        });
    }
    
}
