
package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.ThoiKhoaBieu;


public class ClassTableModel3 {
    public DefaultTableModel setTableHocVien(List<ThoiKhoaBieu> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 9 ? Boolean.class : String.class;
            }
        };
    
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if(rows > 0){
            for (int i = 0; i < rows; i++) {
            ThoiKhoaBieu thoiKhoaBieu = listItem.get(i);
            obj = new Object[columns];
            obj[0] = (i + 1);
            obj[1] = thoiKhoaBieu.getMa_hoc_vien();
            obj[2] = thoiKhoaBieu.getTen_lop_hoc_phan();
            obj[3] = thoiKhoaBieu.getTen_mon_hoc();
            obj[4] = thoiKhoaBieu.getThu();
            obj[5] = thoiKhoaBieu.getTu_tiet();
            obj[6] = thoiKhoaBieu.getDen_tiet();
            obj[7] = thoiKhoaBieu.getTen_giang_vien();
            obj[8] = thoiKhoaBieu.getPhong();
            dtm.addRow(obj);
        }
        }
         return dtm;
}
    
}
