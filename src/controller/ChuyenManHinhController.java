
package controller;

import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.BangDiemJPanel;
import view.SinhVienJPanel;
import view.LopSinhHoatJPanel;
import view.ThoiKhoaBieuJPanel;
import view.ThongKeJPanel;
import view.TrangChuJPanel;

/**
 *
 * @author Admin
 */
public class ChuyenManHinhController {
    private JPanel root ;
    private String kindSelected = "";
    private List<DanhMucBean> listItem = null;
    
    public ChuyenManHinhController(JPanel jpnRoot){
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
        root.validate();
        root.repaint();
    }
    
  public void setEvent(List<DanhMucBean> listItem) {
     this.listItem = listItem;
     for(DanhMucBean item : listItem){
       item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));  
     }
    }
  
  class LabelEvent implements MouseListener {
      private JPanel node;
      private String kind;

      private JPanel jpnItem;
      private JLabel jlbItem;

      public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
           this.kind = kind;
           this.jpnItem = jpnItem;
           this.jlbItem = jlbItem;
      }
        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TrangChu":
                    node = new TrangChuJPanel();
                    break;
                case "HocVien":
                    node = new SinhVienJPanel();
                    break;
                case "LopSinhHoat":
                    node = new LopSinhHoatJPanel();
                    break;
                case "ThoiKhoaBieu":
                    node = new ThoiKhoaBieuJPanel();
                    break; 
                case "BangDiem":
                    node = new BangDiemJPanel();
                    break; 
                 case "ThongKe":
                    node = new ThongKeJPanel();
                    break;   
                // more ...
                default:
                    node = new TrangChuJPanel();
                    break;
           }
            
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(76, 175, 80));
                jlbItem.setBackground(new Color(76, 175, 80));
          }
        }
    }
        
    private void setChangeBackground(String kind){
        for(DanhMucBean item : listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(96, 100, 191));
                item.getJlb().setBackground(new Color(96, 100, 191));
            }else{
                item.getJpn().setBackground(new Color(76, 175, 80));
                item.getJlb().setBackground(new Color(76, 175, 80));
            }
        }
    }
}
