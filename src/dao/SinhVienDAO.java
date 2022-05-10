
package dao;

import java.util.List;
import model.SinhVien;


public interface SinhVienDAO {

    public List<SinhVien> getList();
    
     public int createOrUpdate(SinhVien hocVien);
     public int deleteOrUpdate(SinhVien hocVien);
}
