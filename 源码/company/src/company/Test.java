package company;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import messagejpanel.Kucun_ruku;
import jframe.Login;
import jframe.Main;
import company.Testmysql;

public class Test implements ActionListener{
	
	public static Login frame;
	public static Main zhu;
	public static String mysqlname="root";
	public static String mysqlpassword="";
	public static String database="company";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
					//zhu =new Main();
					//zhu.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
	}
	
	public void actionPerformed(ActionEvent e1) {
		// TODO Auto-generated method stub
		if(e1.getSource()==Login.denglu)
		{
			new Testmysql();
		}
		if(e1.getSource()==Kucun_ruku.ruku){
			//连接数据库ruku；
			
		       
		}
	}

}
