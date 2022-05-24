
package service;

import dao.BangDiemDAOImpl;
import java.util.List;
import model.BangDiem;
import dao.BangDiemDAO;

public class BangDiemServiceImpl implements BangDiemService {

    private BangDiemDAO bangDiemDAO = null;

    public BangDiemServiceImpl() {
        this.bangDiemDAO  = new BangDiemDAOImpl();
    }

    @Override
    public List<BangDiem> getList() {
        return bangDiemDAO .getList();
    }

}

