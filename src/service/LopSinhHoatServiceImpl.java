
package service;

import dao.LopSinhHoatDAOImpl;
import java.util.List;
import model.SinhVien;
import dao.LopSinhHoatDAO;

public class LopSinhHoatServiceImpl implements LopSinhHoatService {

    private LopSinhHoatDAO lopSinhHoatDAO = null;

    public LopSinhHoatServiceImpl() {
        this.lopSinhHoatDAO = new LopSinhHoatDAOImpl();
    }

    @Override
    public List<SinhVien> getList() {
        return lopSinhHoatDAO.getList();
    }
    
    @Override
    public int Find(SinhVien hocVien) {
        return lopSinhHoatDAO.Find(hocVien);
    }

}
