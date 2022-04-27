
package service;

import dao.HocVienDAO;
import dao.HocVienDAOImpl;
import java.util.List;
import model.HocVien;

public class HocVienServiceImpl implements HocVienService {

    private HocVienDAO hocVienDAO = null;

    public HocVienServiceImpl() {
        this.hocVienDAO = new HocVienDAOImpl();
    }

    @Override
    public List<HocVien> getList() {
        return hocVienDAO.getList();
    }

    @Override
    public int createOrUpdate(HocVien hocVien) {
        return hocVienDAO.createOrUpdate(hocVien);
    }

}
