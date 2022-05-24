
package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.BangDiem;


public class ClassTableModel2 {
    public DefaultTableModel setTableHocVien(List<BangDiem> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 6 ? Boolean.class : String.class;
            }
        };
    
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if(rows > 0){
            for (int i = 0; i < rows; i++) {
            BangDiem bangDiem = listItem.get(i);
            obj = new Object[columns];
            obj[0] = (i + 1);
            obj[1] = bangDiem.getMa_hoc_vien();
            obj[2] = bangDiem.getHo_ten_hoc_vien();
            obj[3] = bangDiem.getHoc_ki();
            obj[4] = bangDiem.getDiem_TBCHT();
            obj[5] = bangDiem.getXep_loai();
            dtm.addRow(obj);
        }
        }
         return dtm;
}
    
}
