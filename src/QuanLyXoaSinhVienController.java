


import controller.*;
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

public class QuanLyXoaSinhVienController {
    private JPanel jpnView;
    private JButton btnRemove;
    
    private SinhVienService hocVienService = null;
    
    private String[] listColumn = {"STT", "MSV", "Tên Sinh Viên","Tên Lớp Học", "Ngày sinh",
        "Giới tính", "Số điện thoại", "Địa chỉ", "Trạng thái"};
    
    private TableRowSorter<TableModel> rowSorter = null;
    
    public QuanLyXoaSinhVienController(JPanel jpnView,JButton btnRemove) {
        this.jpnView = jpnView;
        this.btnRemove = btnRemove;
        this.hocVienService = new SinhVienServiceImpl();
    }
    
    public void setDataToTable() {
        List<SinhVien> listItem = hocVienService.getList();
        
        DefaultTableModel model = new ClassTableModel().setTableHocVien(listItem, listColumn);
        JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
       
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
                  
                  XoaSinhVienJFrame frame1 = new XoaSinhVienJFrame(hocVien);
                  frame1.setTitle("Thông tin học viên cần xoá");
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
            
            btnRemove.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                XoaSinhVienJFrame frame1 = new XoaSinhVienJFrame(new SinhVien());
                frame1.setTitle("Thông Tin Học Viên Cần Xoá");
                frame1.setLocationRelativeTo(null);
                frame1.setResizable(false);
                frame1.setVisible(true);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                btnRemove.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnRemove.setBackground(new Color(100, 221, 23));
            }
        });
        
}
}
