
package service;

import dao.SinhVienDAOImpl;
import java.util.List;
import model.SinhVien;
import dao.SinhVienDAO;

public class SinhVienServiceImpl implements SinhVienService {

    private SinhVienDAO hocVienDAO = null;

    public SinhVienServiceImpl() {
        this.hocVienDAO = new SinhVienDAOImpl();
    }

    @Override
    public List<SinhVien> getList() {
        return hocVienDAO.getList();
    }

    @Override
    public int createOrUpdate(SinhVien hocVien) {
        return hocVienDAO.createOrUpdate(hocVien);
    }
    
    @Override
    public int deleteOrUpdate(SinhVien hocVien) {
        return hocVienDAO.deleteOrUpdate(hocVien);
    }

}
