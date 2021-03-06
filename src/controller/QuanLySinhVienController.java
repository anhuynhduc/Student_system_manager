
package controller;

import java.util.List;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.SinhVien;
import service.SinhVienServiceImpl;
import utility.ClassTableModel;
import view.SinhVienJFrame;
import service.SinhVienService;
import view.XoaSinhVienJFrame;

public class QuanLySinhVienController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private SinhVienService hocVienService = null;
    
    private String[] listColumn = {"STT", "MSV", "Tên Sinh Viên","Tên Lớp Học", "Ngày sinh",
        "Giới tính", "Số điện thoại", "Địa chỉ", "Trạng thái"};
    
    private TableRowSorter<TableModel> rowSorter = null;
    
    public QuanLySinhVienController(JPanel jpnView, JButton btnAdd , JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.hocVienService = new SinhVienServiceImpl();
    }
    
    public void setDataToTable() {
        List<SinhVien> listItem = hocVienService.getList();
        
        DefaultTableModel model = new ClassTableModel().setTableHocVien(listItem, listColumn);
        JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                 String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
            });
        // design
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        
        table.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
              if(e.getClickCount() == 2 && table.getSelectedRow()!= -1 ){
                  DefaultTableModel model = (DefaultTableModel) table.getModel();
                  int selectedRowIndex = table.getSelectedRow();
                  selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                  System.out.println(selectedRowIndex);
                  
                  SinhVien hocVien = new SinhVien();
                  hocVien.setMa_hoc_vien((String) model.getValueAt(selectedRowIndex,1)) ;
                  hocVien.setHo_ten(model.getValueAt(selectedRowIndex,2).toString());
                  hocVien.setTen_lop_hoc(model.getValueAt(selectedRowIndex,3).toString());
                  //hocVien.setNgay_sinh(ngay_sinh);
                  hocVien.setGioi_tinh(model.getValueAt(selectedRowIndex,5).toString().equalsIgnoreCase("Nam"));
                  hocVien.setSo_dien_thoai(model.getValueAt(selectedRowIndex,6) != null ?
                          model.getValueAt(selectedRowIndex, 6).toString() : "");
                  hocVien.setDia_chi(model.getValueAt(selectedRowIndex,7).toString() != null ?
                          model.getValueAt(selectedRowIndex, 7).toString() : "");
                  hocVien.setTinh_trang((Boolean) model.getValueAt(selectedRowIndex,8));
                  
                  SinhVienJFrame frame = new SinhVienJFrame(hocVien);
                  frame.setTitle("Thông tin học viên");
                  frame.setResizable(false);
                  frame.setLocationRelativeTo(null);
                  frame.setVisible(true);
                  
                  XoaSinhVienJFrame frame1 = new XoaSinhVienJFrame(hocVien);
                  frame1.setTitle("Thông tin học viên Cần Xoá");
                  frame1.setResizable(false);
                  frame1.setLocationRelativeTo(null);
                  frame1.setVisible(true);
                  
              }
        }    
        });
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
        
        public void setEvent(){
            btnAdd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                SinhVienJFrame frame = new SinhVienJFrame(new SinhVien());
                frame.setTitle("Thông Tin Sinh Viên");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(100, 221, 23));
            }
        });
        
}
}
