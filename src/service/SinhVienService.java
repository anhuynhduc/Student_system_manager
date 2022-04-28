
package service;

import java.util.List;
import model.SinhVien;

public interface SinhVienService {
    
    public List<SinhVien> getList();
    
    public int createOrUpdate(SinhVien hocVien);
}
