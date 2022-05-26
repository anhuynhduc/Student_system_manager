
package dao;

import bean.KhoaHocBean;
import bean.LopHocBean;
import java.util.List;

/**
 *
 * @author Admin
 */
//thong ke
public interface ThongKeDAO {
       public List<LopHocBean> getListByLopHoc();
       public List<KhoaHocBean> getListByKhoaHoc();
}
