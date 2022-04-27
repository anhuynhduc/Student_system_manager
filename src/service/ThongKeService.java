
package service;

import bean.KhoaHocBean;
import bean.LopHocBean;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ThongKeService {
    
    public List<LopHocBean> getListByLopHoc();
    public List<KhoaHocBean> getListByKhoaHoc();

}
