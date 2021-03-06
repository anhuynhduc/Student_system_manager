
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
import model.LopSinhHoat;
import model.SinhVien;
import service.LopSinhHoatService;
import service.LopSinhHoatServiceImpl;
import service.SinhVienServiceImpl;
import utility.ClassTableModel;
import utility.ClassTableModel1;
import view.SinhVienJFrame;
import view.XoaSinhVienJFrame;

public class QuanLyLopSinhHoatController {
    private JPanel jpnView;
    private JTextField jtfSearch;
    private SinhVien hocVien = null;
    
    private LopSinhHoatService lopSinhHoatService = null;
    
    private String[] listColumn = {"STT", "MLSH", "Tên Lớp Học","Giáo viên chủ nhiệm", "Số lượng sinh viên",
       };
    
    private TableRowSorter<TableModel> rowSorter = null;
    
    public QuanLyLopSinhHoatController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        this.lopSinhHoatService = new LopSinhHoatServiceImpl();
    }
        public void setDataToTable() {
            
        List<LopSinhHoat> listItem = lopSinhHoatService.getList();
        
        DefaultTableModel model = new ClassTableModel1().setTableHocVien(listItem, listColumn);
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
                  
                  LopSinhHoat hocVien = new LopSinhHoat();
                  hocVien.setMa_lop_hoc((String) model.getValueAt(selectedRowIndex,1)) ;
                  hocVien.setTen_lop_hoc(model.getValueAt(selectedRowIndex,2).toString());
                  hocVien.setGiao_vien_chu_nhiem(model.getValueAt(selectedRowIndex,3).toString());
                  hocVien.setSo_luong_sinh_vien(model.getValueAt(selectedRowIndex,5).toString());
                  
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
        scroll.setPreferredSize(new Dimension(1050, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
}
