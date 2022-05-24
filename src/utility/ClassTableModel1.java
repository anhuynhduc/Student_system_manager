
package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.LopSinhHoat;
import model.SinhVien;


public class ClassTableModel1 {
    public DefaultTableModel setTableHocVien(List<LopSinhHoat> listItem, String[] listColumn) {
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
            LopSinhHoat lopSinhHoat = listItem.get(i);
            obj = new Object[columns];
            obj[0] = (i + 1);
            obj[1] = lopSinhHoat.getMa_lop_hoc();
            obj[2] = lopSinhHoat.getTen_lop_hoc();
            obj[3] = lopSinhHoat.getGiao_vien_chu_nhiem();
            obj[4] = lopSinhHoat.getSo_luong_sinh_vien();
            dtm.addRow(obj);
        }
        }
         return dtm;
}
    
}
