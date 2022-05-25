
package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.LopSinhHoat;
import model.SinhVien;


public class ClassTableModel {
    public DefaultTableModel setTableHocVien(List<SinhVien> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 8 ? Boolean.class : String.class;
            }
        };
    
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if(rows > 0){
            for (int i = 0; i < rows; i++) {
            SinhVien hocVien = listItem.get(i);
            obj = new Object[columns];
            obj[0] = (i + 1);
            obj[1] = hocVien.getMa_hoc_vien();
            obj[2] = hocVien.getHo_ten();
            obj[3] = hocVien.getTen_lop_hoc();
            obj[4] = hocVien.getNgay_sinh();
            obj[5] = hocVien.isGioi_tinh() == true ? "Nam" : "Nữ";
            obj[6] = hocVien.getSo_dien_thoai();
            obj[7] = hocVien.getDia_chi();
            obj[8] = hocVien.isTinh_trang();
            dtm.addRow(obj);
        }
        }
         return dtm;
}

    public DefaultTableModel setTableLopSinhHoat(List<LopSinhHoat> listItem, String[] listColumn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
