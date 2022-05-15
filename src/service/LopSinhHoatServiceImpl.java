
package service;

import dao.LopSinhHoatDAOImpl;
import java.util.List;
import model.SinhVien;
import model.LopSinhHoat;
import dao.LopSinhHoatDAO;

public class LopSinhHoatServiceImpl implements LopSinhHoatService {

    private LopSinhHoatDAO lopSinhHoatDAO = null;

    public LopSinhHoatServiceImpl() {
        this.lopSinhHoatDAO = new LopSinhHoatDAOImpl();
    }

    @Override
    public List<LopSinhHoat> getList() {
        return lopSinhHoatDAO.getList();
    }

}
