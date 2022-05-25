
package service;

import dao.ThoiKhoaBieuDAOImpl;
import java.util.List;
import model.ThoiKhoaBieu;
import dao.ThoiKhoaBieuDAO;

public class ThoiKhoaBieuServiceImpl implements ThoiKhoaBieuService {

    private ThoiKhoaBieuDAO thoiKhoaBieuDAO= null;

    public ThoiKhoaBieuServiceImpl() {
        this.thoiKhoaBieuDAO = new ThoiKhoaBieuDAOImpl();
    }

    @Override
    public List<ThoiKhoaBieu> getList() {
        return thoiKhoaBieuDAO .getList();
    }

}

