
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
import model.ThoiKhoaBieu;
import model.SinhVien;
import service.ThoiKhoaBieuService;
import service.ThoiKhoaBieuServiceImpl;
import service.SinhVienServiceImpl;
import utility.ClassTableModel3;

public class QuanLyThoiKhoaBieuController {
    private JPanel jpnView;
    private JTextField jtfSearch;
    private SinhVien hocVien = null;
    
    private ThoiKhoaBieuService thoiKhoaBieuService = null;
    
    private String[] listColumn = {"STT", "MSV", "Tên lớp học phần","Tên môn học", "thứ","Từ tiết","Đến tiết","Tên giảng viên","Phòng"
       };
    
    private TableRowSorter<TableModel> rowSorter = null;
    private final ThoiKhoaBieuServiceImpl ThoiKhoaBieuService;
    
    public QuanLyThoiKhoaBieuController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        this.ThoiKhoaBieuService = new ThoiKhoaBieuServiceImpl();
    }
        public void setDataToTable() {
            
        List<ThoiKhoaBieu> listItem = ThoiKhoaBieuService.getList();
        
        DefaultTableModel model = new ClassTableModel3().setTableHocVien(listItem, listColumn);
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
                  
                  ThoiKhoaBieu hocVien = new ThoiKhoaBieu();
                  hocVien.setMa_hoc_vien((String) model.getValueAt(selectedRowIndex,1)) ;
                  hocVien.setTen_lop_hoc_phan(model.getValueAt(selectedRowIndex,2).toString());
                  hocVien.setTen_mon_hoc(model.getValueAt(selectedRowIndex,3).toString());
                  hocVien.setThu(model.getValueAt(selectedRowIndex,5).toString());
                  hocVien.setTu_tiet(model.getValueAt(selectedRowIndex,6).toString());
                  hocVien.setDen_tiet(model.getValueAt(selectedRowIndex,6).toString());
                  hocVien.setTen_giang_vien(model.getValueAt(selectedRowIndex,6).toString());
                  hocVien.setPhong(model.getValueAt(selectedRowIndex,6).toString());
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
