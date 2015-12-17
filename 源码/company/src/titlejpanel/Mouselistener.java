package titlejpanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import company.Test;
import messagejpanel.Control;
import messagejpanel.Dingdan_chaxun;
import messagejpanel.Dingdan_chuku;
import messagejpanel.Dingdan_goumai;
import messagejpanel.Dingdan_ruku;
import messagejpanel.Kucun_Sykucun;
import messagejpanel.Kucun_chuku;
import messagejpanel.Kucun_ruku;
import messagejpanel.Message_employee;
import messagejpanel.Message_goods;
import messagejpanel.Message_sponsor;
import messagejpanel.Xiaoshou_day;
import messagejpanel.Xiaoshou_lirun;
import messagejpanel.Xiaoshou_mounth;
import messagejpanel.Xiaoshou_num;
import jframe.Login;
import jframe.Main;

public class Mouselistener implements MouseListener {
	JLabel jlabel;
	//JPanel []panels ={Main.message_goods,Main.message_sponsor,Main.kucun_chuku,Main.kucun_sykucun,Main.xiaoshou_day,Main.xiaoshou_lirun,Main.xiaoshou_mounth,Main.xiaoshou_num,Main.dingdan_chuku,Main.dingdan_goumai};
	
	public Mouselistener(JLabel e){
		jlabel=e;
	}
		public void mouseEntered(MouseEvent e) {
		// 处理鼠标移入
			jlabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jlabel.setForeground(new Color(0, 0, 255));
		}
		public void mouseExited(MouseEvent e) {
		// 处理鼠标离开
			jlabel.setForeground(new Color(0, 0, 0));
		}
		public void mousePressed(MouseEvent e) {
			
			if(e.getSource()!=Kucun.label_3&&e.getSource()!=Main.control){
				if(Main.message_goods!=null)Main.message_goods.setVisible(false);
				if(Main.kucun_chuku!=null)Main.kucun_chuku.setVisible(false);
				if(Main.kucun_sykucun!=null)Main.kucun_sykucun.setVisible(false);
				if(Main.xiaoshou_day!=null)Main.xiaoshou_day.setVisible(false);
				if(Main.xiaoshou_mounth!=null)Main.xiaoshou_mounth.setVisible(false);
				if(Main.xiaoshou_lirun!=null)Main.xiaoshou_lirun.setVisible(false);
				if(Main.xiaoshou_num!=null)Main.xiaoshou_num.setVisible(false);
				if(Main.dingdan_ruku!=null)Main.dingdan_ruku.setVisible(false);
				if(Main.dingdan_chuku!=null)Main.dingdan_chuku.setVisible(false);
				if(Main.message_sponsor!=null)Main.message_sponsor.setVisible(false);
				if(Main.dingdan_chaxun!=null)Main.dingdan_chaxun.setVisible(false);
				if(Main.message_employee!=null)Main.message_employee.setVisible(false);
				Main.lblNewLabel_3.setVisible(false);
				Main.log.setVisible(false);
			}
			
			
		// 处理鼠标按下
			
			if(e.getSource()==Message.label_2){
				if(Main.message_sponsor!=null)Main.panel_4.remove(Main.message_sponsor);
				Main.message_sponsor=new Message_sponsor();
				Main.message_sponsor.setVisible(true);
				Main.message_sponsor.setBounds(197, 0, 637, 570);
				Main.panel_4.add(Main.message_sponsor);
				
				
			}
			if(e.getSource()==Message.label_3){
				if(Main.message_employee!=null)Main.panel_4.remove(Main.message_employee);
				Main.message_employee=new Message_employee();
				Main.message_employee.setVisible(true);
				Main.message_employee.setBounds(197, 0, 637, 570);
				Main.panel_4.add(Main.message_employee);
			}
			if(e.getSource()==Message.label_4){
				if(Main.message_goods!=null)Main.panel_4.remove(Main.message_goods);
				Main.message_goods=new Message_goods();
				Main.message_goods.setVisible(true);
				Main.message_goods.setBounds(197, 0, 637, 570);
				Main.panel_4.add(Main.message_goods);
				
			}
			
			
			
			
			if(e.getSource()==Kucun.label_3){
				Main.rukuframe=new Kucun_ruku();
				Main.rukuframe.setVisible(true);
			}
			if(e.getSource()==Kucun.label_4){
				if(Main.kucun_chuku!=null)Main.panel_4.remove(Main.kucun_chuku);
				Main.kucun_chuku=new Kucun_chuku();
				Main.kucun_chuku.setVisible(true);
				Main.kucun_chuku.setBounds(197, 0, 637, 570);
				Main.panel_4.add(Main.kucun_chuku);
				
			}
			if(e.getSource()==Kucun.label_5){
				if(Main.kucun_sykucun!=null)Main.panel_4.remove(Main.kucun_sykucun);
				Main.kucun_sykucun=new Kucun_Sykucun();
				Main.kucun_sykucun.setVisible(true);
				Main.kucun_sykucun.setBounds(197, 0, 637, 570);
				Main.panel_4.add(Main.kucun_sykucun);
				
			}
			
			
			if(e.getSource()==Xiaoshou.label_2){
				if(Main.xiaoshou_day!=null)Main.panel_4.remove(Main.xiaoshou_day);
				Main.xiaoshou_day=new Xiaoshou_day();
				Main.xiaoshou_day.setVisible(true);
				Main.xiaoshou_day.setBounds(197, 0, 637, 570);
				Main.panel_4.add(Main.xiaoshou_day);
				
			}
			if(e.getSource()==Xiaoshou.label_3){
				if(Main.xiaoshou_mounth!=null)Main.panel_4.remove(Main.xiaoshou_mounth);
				Main.xiaoshou_mounth=new Xiaoshou_mounth();
				Main.xiaoshou_mounth.setVisible(true);
				Main.xiaoshou_mounth.setBounds(197, 0, 637, 570);
				Main.panel_4.add(Main.xiaoshou_mounth);
				
			}
			if(e.getSource()==Xiaoshou.label_4){
				if(Main.xiaoshou_lirun!=null)Main.panel_4.remove(Main.xiaoshou_lirun);
				Main.xiaoshou_lirun=new Xiaoshou_lirun();
				Main.xiaoshou_lirun.setVisible(true);
				Main.xiaoshou_lirun.setBounds(197, 0, 637, 570);
				Main.panel_4.add(Main.xiaoshou_lirun);
				
			}
			if(e.getSource()==Xiaoshou.label_5){
				if(Main.xiaoshou_num!=null)Main.panel_4.remove(Main.xiaoshou_num);
				Main.xiaoshou_num=new Xiaoshou_num();
				Main.xiaoshou_num.setVisible(true);
				Main.xiaoshou_num.setBounds(197, 0, 637, 570);
				Main.panel_4.add(Main.xiaoshou_num);
				
			}
			
			
			if(e.getSource()==Dingdan.label_2){
				if(Main.dingdan_ruku!=null)Main.panel_4.remove(Main.dingdan_ruku);
				Main.dingdan_ruku=new Dingdan_ruku();
				Main.dingdan_ruku.setVisible(true);
				Main.dingdan_ruku.setBounds(197, 0, 637, 570);
				Main.panel_4.add(Main.dingdan_ruku);
				
			}
			if(e.getSource()==Dingdan.label_3){
				if(Main.dingdan_chuku!=null)Main.panel_4.remove(Main.dingdan_chuku);
				Main.dingdan_chuku=new Dingdan_chuku();
				Main.dingdan_chuku.setVisible(true);
				Main.dingdan_chuku.setBounds(197, 0, 637, 570);
				Main.panel_4.add(Main.dingdan_chuku);
			
			}
			if(e.getSource()==Dingdan.label_4){
				if(Main.dingdan_chaxun!=null)Main.panel_4.remove(Main.dingdan_chaxun);
				Main.dingdan_chaxun=new Dingdan_chaxun();
				Main.dingdan_chaxun.setVisible(true);
				Main.dingdan_chaxun.setBounds(197, 0, 637, 570);
				Main.panel_4.add(Main.dingdan_chaxun);
			}
			
			
			/*if(e.getSource()==Zijin.label_2){
				System.out.println("dgd");
			}
			if(e.getSource()==Zijin.label_3){
				System.out.println("dgd");
			}
			if(e.getSource()==Zijin.label_4){
				System.out.println("dgd");
			}
			if(e.getSource()==Zijin.label_5){
				System.out.println("dgd");
			}*/
			
			if(e.getSource()==Main.exit){
				Test.frame.setVisible(true);
				Test.zhu.dispose();
			}
			if(e.getSource()==Main.control){
				Control frame=new Control();
				frame.setVisible(true);
			}
		}
		
		/*public void setpanel(JPanel p){
			for(int i=0;i<panels.length;i++){
				if(p.equals(panels[i]))continue;
				panels[i].setVisible(false);
			}
		}*/
		
		public void mouseReleased(MouseEvent e) {
		// 处理鼠标释放
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
}
