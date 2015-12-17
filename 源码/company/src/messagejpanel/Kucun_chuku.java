package messagejpanel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jframe.Main;
import company.Test;
import company.Testmysql;

public class Kucun_chuku extends JPanel {

	/**
	 * Create the panel.
	 */
	public static JTextField chukudanhao;
	public static JTextField time;
	public static JTextField operator;
	public static JTextField price;
	public static JTextField num;
	public static JTextField textField;
	public static JComboBox fenlei;
	public static JComboBox name;
	public static JLabel num1;
	public static JLabel price1;
	public static JFrame frame;
	public static JButton chuku;
	private JTextField jingshouren;
	private JTextField textField_2;
	
	String JDriver = "com.mysql.jdbc.Driver";  // MySQL提供的JDBC驱动，要保证它在CLASSPATH里可见

    String conURL = "jdbc:mysql://localhost/"+Test.database;  // 本地计算机上的MySQL数据库Company的URL
	
	public Kucun_chuku() {
		System.out.println("new");
		setBackground(Color.WHITE);// 绘制组件界面的方法   
		setBounds(197, 0, 637, 570);
		setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(21, 24, 588, 153);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 25, 541, 107);
		panel_1.add(panel);
		panel.setBackground(Color.WHITE);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{80, 130, 23, 100, 130, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{40, 40, 37, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		panel_1.setBorder (BorderFactory.createTitledBorder ("基本信息"));
		
		JLabel label_4 = new JLabel(" \u51FA\u5E93\u5355\u53F7\uFF1A");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.fill = GridBagConstraints.VERTICAL;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 0;
		panel.add(label_4, gbc_label_4);
		
		chukudanhao = new JTextField();
		GridBagConstraints gbc_chukudanhao = new GridBagConstraints();
		gbc_chukudanhao.insets = new Insets(0, 0, 5, 5);
		gbc_chukudanhao.fill = GridBagConstraints.HORIZONTAL;
		gbc_chukudanhao.gridx = 1;
		gbc_chukudanhao.gridy = 0;
		panel.add(chukudanhao, gbc_chukudanhao);
		chukudanhao.setColumns(10);
		
		JLabel label_1 = new JLabel("\u51FA\u5E93\u65E5\u671F\uFF1A");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 0;
		panel.add(label_1, gbc_label_1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		
		time = new JTextField();
		GridBagConstraints gbc_time = new GridBagConstraints();
		gbc_time.insets = new Insets(0, 0, 5, 5);
		gbc_time.fill = GridBagConstraints.HORIZONTAL;
		gbc_time.gridx = 4;
		gbc_time.gridy = 0;
		panel.add(time, gbc_time);
		time.setColumns(10);
		time.setText(df.format(new Date()));
		
		JLabel label = new JLabel("\u7ECF\u624B\u4EBA\uFF1A");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.fill = GridBagConstraints.VERTICAL;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);
		
		jingshouren = new JTextField();
		GridBagConstraints gbc_jingshouren = new GridBagConstraints();
		gbc_jingshouren.insets = new Insets(0, 0, 5, 5);
		gbc_jingshouren.fill = GridBagConstraints.HORIZONTAL;
		gbc_jingshouren.gridx = 1;
		gbc_jingshouren.gridy = 1;
		panel.add(jingshouren, gbc_jingshouren);
		jingshouren.setColumns(10);
		
		JLabel label_2 = new JLabel("\u64CD\u4F5C\u5458\uFF1A");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 1;
		panel.add(label_2, gbc_label_2);
		
		operator = new JTextField();
		GridBagConstraints gbc_operator = new GridBagConstraints();
		gbc_operator.insets = new Insets(0, 0, 5, 5);
		gbc_operator.fill = GridBagConstraints.HORIZONTAL;
		gbc_operator.gridx = 4;
		gbc_operator.gridy = 1;
		panel.add(operator, gbc_operator);
		operator.setColumns(10);
		operator.setText(Testmysql.Name);
		
		JButton button = new JButton("\u786E\u5B9A");//确定
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chukudanhao.setEditable(false);
				time.setEditable(false);
				jingshouren.setEditable(false);
				operator.setEditable(false);
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.EAST;
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 2;
		panel.add(button, gbc_button);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chukudanhao.setText("");
				operator.setText("");
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");//修改
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 2;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chukudanhao.setEditable(true);
				time.setEditable(true);
				jingshouren.setEditable(true);
				operator.setEditable(true);
			}
		});
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(21, 195, 594, 182);
		add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBorder (BorderFactory.createTitledBorder ("商品信息"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("");
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 39, 557, 120);
		panel_3.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{80, 130, 23, 100, 130, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{40, 40, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel label_3 = new JLabel("\u98DF\u54C1\u5206\u7C7B\uFF1A");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 0;
		panel_2.add(label_3, gbc_label_3);
		
		fenlei = new JComboBox();
		GridBagConstraints gbc_fenlei = new GridBagConstraints();
		gbc_fenlei.fill = GridBagConstraints.HORIZONTAL;
		gbc_fenlei.insets = new Insets(0, 0, 5, 5);
		gbc_fenlei.gridx = 1;
		gbc_fenlei.gridy = 0;
		panel_2.add(fenlei, gbc_fenlei);
		
		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 1;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		Iterator it=Main.leiset.iterator();
		while(it.hasNext()){
			String s=it.next().toString();
			fenlei.addItem(s);
			//Chuku.
		}
		
		name = new JComboBox();
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.gridx = 4;
		gbc_name.gridy = 0;
		panel_2.add(name, gbc_name);
		//name.setModel(new DefaultComboBoxModel(new String[] {"\u66F2\u5947\u997C\u5E72", "\u5C0F\u718A\u997C\u5E72"}));
		if(!Main.leiset.isEmpty()){
			String start_lei=fenlei.getItemAt(0).toString();
			try {//插入
	            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库
	            Statement s = con.createStatement();  // Statement类用来提交SQL语句
	            String select="select name from goods where lei='"+start_lei+"'"; 
	            ResultSet rs = s.executeQuery(select);  // 提交查询，返回的表格保存在rs中
	            while(rs.next()){
	            	name.addItem(rs.getString("name"));
	            }
	            
	            if(name.getSelectedItem()!=null){
	            	String select1="select num from goods where lei='"+start_lei+"' and name='"+name.getSelectedItem().toString()+"'"; 
		            ResultSet rs1 = s.executeQuery(select1);  // 提交查询，返回的表格保存在rs中
		            while(rs1.next()){
		            	lblNewLabel.setText(rs1.getString("num"));
		            	break;
		            }
	            }
	            
	            s.close();     // 释放Statement对象
	            con.close();   // 关闭到MySQL服务器的连接
			}catch(SQLException sql_e) {     // 都是SQLExceptionss
	            System.out.println("chuku1"+sql_e);
	        }
			
		}
		
		
		fenlei.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String lei=fenlei.getSelectedItem().toString();
				name.removeAllItems();
				try {//插入
					
		            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库
		            Statement s = con.createStatement();  // Statement类用来提交SQL语句
		            String select="select name from goods where lei='"+lei+"'"; 
		            ResultSet rs = s.executeQuery(select);  // 提交查询，返回的表格保存在rs中
		            while(rs.next()){
		            	name.addItem(rs.getString("name"));
		            }
		            s.close();     // 释放Statement对象
		            con.close();   // 关闭到MySQL服务器的连接
				}catch(SQLException sql_e) {     // 都是SQLExceptionss
		            System.out.println("chuku2"+sql_e);
		        }
			}
			
		});
		
		name.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String select_lei=fenlei.getSelectedItem().toString();
				String select_name;
				if(name.getSelectedItem()!=null){
					select_name=name.getSelectedItem().toString();
					try {//插入
			            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库
			            Statement s = con.createStatement();  // Statement类用来提交SQL语句
			            String select="select num from goods where lei='"+select_lei+"' and name='"+select_name+"'"; 
			            ResultSet rs = s.executeQuery(select);  // 提交查询，返回的表格保存在rs中
			            while(rs.next()){
			            	lblNewLabel.setText(rs.getString("num"));
			            	break;
			            }
			            s.close();     // 释放Statement对象
			            con.close();   // 关闭到MySQL服务器的连接
					}catch(SQLException sql_e) {     // 都是SQLExceptionss
			            System.out.println("chuku3"+sql_e);
			        }
				}
				
			}
			
		});
		JLabel label_5 = new JLabel("\u98DF\u54C1\u540D\u79F0\uFF1A");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 3;
		gbc_label_5.gridy = 0;
		panel_2.add(label_5, gbc_label_5);
		
		
		
		JLabel label_6 = new JLabel("\u5355\u4EF7\uFF1A");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 1;
		panel_2.add(label_6, gbc_label_6);
		
		price = new JTextField();
		GridBagConstraints gbc_price = new GridBagConstraints();
		gbc_price.fill = GridBagConstraints.HORIZONTAL;
		gbc_price.insets = new Insets(0, 0, 5, 5);
		gbc_price.gridx = 1;
		gbc_price.gridy = 1;
		panel_2.add(price, gbc_price);
		price.setColumns(10);
		
		price1 = new JLabel("");
		price1.setBounds(0,0,20,20);
		price1.setToolTipText("new");
		GridBagConstraints gbc_price1 = new GridBagConstraints();
		gbc_price1.insets = new Insets(0, 0, 5, 5);
		gbc_price1.gridx = 2;
		gbc_price1.gridy = 1;
		panel_2.add(price1, gbc_price1);
		
		JLabel label_7 = new JLabel("\u6570\u91CF\uFF1A");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 3;
		gbc_label_7.gridy = 1;
		panel_2.add(label_7, gbc_label_7);
		
		num = new JTextField();
		GridBagConstraints gbc_num = new GridBagConstraints();
		gbc_num.fill = GridBagConstraints.HORIZONTAL;
		gbc_num.insets = new Insets(0, 0, 5, 5);
		gbc_num.gridx = 4;
		gbc_num.gridy = 1;
		panel_2.add(num, gbc_num);
		num.setColumns(10);
		
		
		
		num1 = new JLabel("");
		GridBagConstraints gbc_num1 = new GridBagConstraints();
		gbc_num1.insets = new Insets(0, 0, 5, 0);
		gbc_num1.gridx = 6;
		gbc_num1.gridy = 1;
		panel_2.add(num1, gbc_num1);
		
		JLabel label_8 = new JLabel("\u98DF\u54C1\u6709\u6548\u671F\u81F3\uFF1A");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.EAST;
		gbc_label_8.insets = new Insets(0, 0, 0, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 2;
		panel_2.add(label_8, gbc_label_8);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel label_9 = new JLabel("\u5408\u8BA1\uFF1A");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.EAST;
		gbc_label_9.insets = new Insets(0, 0, 0, 5);
		gbc_label_9.gridx = 3;
		gbc_label_9.gridy = 2;
		panel_2.add(label_9, gbc_label_9);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 2;
		panel_2.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		chuku= new JButton("\u51FA\u5E93");
		chuku.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				String a= fenlei.getSelectedItem().toString();
				String b=name.getSelectedItem().toString();
				String c=num.getText();
				String d=price.getText();
				String e=time.getText();
				String f=chukudanhao.getText();
				String g=jingshouren.getText();
				String h=operator.getText();
				int sum=Integer.parseInt(c)*Integer.parseInt(d);
				SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
				SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM");//设置日期格式
				if(Integer.parseInt(c)>Integer.parseInt(lblNewLabel.getText())){
					JOptionPane.showMessageDialog(Test.zhu, "库存不足","警告",2);
				}
				else {
					
					JOptionPane.showMessageDialog(Test.zhu, "出库成功","出库成功",1);
					try {//日销售
			            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

			            Statement s = con.createStatement();  // Statement类用来提交SQL语句
			            Statement s1 = con.createStatement();  // Statement类用来提交SQL语句
			            
			           String insert = "insert into chuku(lei,name,num,price,time,danhao,jingshouren,operator) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"')";  
			           s.executeUpdate(insert);
			            
			           ResultSet rs = s.executeQuery("select * from xiaoshou_day where time like '"+e.substring(0, 10)+"%'");  // 提交查询，返回的表格保存在rs中
			           System.out.println(e.substring(0, 10)+"dkfdl");
			           boolean flag=false;
			            while(rs.next()) {  // ResultSet指针指向下一个“行”
			            	if(rs.getString("lei").equals(a)&&rs.getString("name").equals(b)){
			            		int money=Integer.parseInt(rs.getString("money"))+sum;
			            		String update = "Update xiaoshou_day Set money='"+money+"' Where lei='"+a+"' and name = '"+b+"' and time like '"+e.substring(0, 10)+"%'";
			            		s1.executeUpdate(update);
			            		flag=true;
			            		System.out.println(rs.getString("time")+"    "+money+"   "+sum);
			            		break;
			            	}

			            }
			            if(!flag){
			            	String insert1 = "insert into xiaoshou_day(lei,name,money,time) values('"+a+"','"+b+"','"+sum+"','"+e+"')";  
					           s.executeUpdate(insert1);
					           System.out.println("update"+sum);
					           
			            }
			            Statement s2 = con.createStatement();  // Statement类用来提交SQL语句
			    		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			        		//System.out.println("insert into news(time,news,limit) values('"+df.format(new Date())+"','"+Name+"登入系统"+"','"+limite+"')");
			        		String insert1 = "insert into news(time,news,limite) values('"+df.format(new Date())+"','"+Testmysql.limite+Testmysql.Name+"出库"+a+":"+b+" "+c+"成功"+"','"+Testmysql.limite+"')";  
			        		s2.executeUpdate(insert1);
			        			
			                  s2.close();     // 释放Statement对象
			            s.close();     // 释放Statement对象
			            con.close();   // 关闭到MySQL服务器的连接
			        }
			        catch(SQLException sql_e) {     // 都是SQLException
			            System.out.println("chukuha"+sql_e);
			        }
				 
				 
				 
				 try{//月销售
					 Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

			            Statement s = con.createStatement();  // Statement类用来提交SQL语句
			            
					 ResultSet rs1 = s.executeQuery("select * from xiaoshou_mounth where time like '"+e.substring(0, 7)+"%'");  // 提交查询，返回的表格保存在rs中

			           boolean flag1=false;
			            while(rs1.next()) {  // ResultSet指针指向下一个“行”
			            	System.out.println(rs1.getString("time").substring(0, 7)+"  "+e.substring(0, 7));
			            	if(rs1.getString("time").substring(0, 7).equals(e.substring(0, 7))){
			            		int money=Integer.parseInt(rs1.getString("money"))+sum;
				            	String update = "Update xiaoshou_mounth Set money='"+money+"' Where time like '"+e.substring(0, 7)+"%'";
				            	s.executeUpdate(update);
				            	flag1=true;
				            	System.out.println("第一次添加"+money);
				            	break;
			            	}
			            	
			            }
			            if(!flag1){
			            	System.out.println("bu第一次添加");
			            	String insert1 = "insert into xiaoshou_mounth(money,time) values('"+sum+"','"+e.substring(0, 7)+"')";  
					           s.executeUpdate(insert1);
			            }
			            s.close();     // 释放Statement对象
			            con.close();   // 关闭到MySQL服务器的连接
				 }catch(SQLException sql_e){
					 System.out.println("chukuhaxx"+sql_e);
				 }
				 
				 try{//删除
					 Connection con = DriverManager.getConnection(conURL,Test.mysqlname, Test.mysqlpassword);  // 连接数据库

			            Statement s = con.createStatement();  // Statement类用来提交SQL语句
			            
					 ResultSet rs1 = s.executeQuery("select * from goods where lei='"+a+"' and name = '"+b+"'");  // 提交查询，返回的表格保存在rs中

			            while(rs1.next()) {  // ResultSet指针指向下一个“行”
			            		int num=Integer.parseInt(rs1.getString("num"))-Integer.parseInt(c);
				            	String update = "Update goods Set num='"+num+"' Where lei='"+a+"' and name='"+b+"'";
				            	s.executeUpdate(update);
				            	break;
			            	}
			            s.close();     // 释放Statement对象
			            con.close();   // 关闭到MySQL服务器的连接
				 }catch(SQLException sql_e){
					 System.out.println("chukuhaaa"+sql_e);
				 }
				 
				 
				}
 
			}
			
		});
		chuku.setBounds(204, 408, 93, 23);
		add(chuku);
		
		JButton button_3 = new JButton("\u91CD\u7F6E");
		button_3.setBounds(409, 408, 93, 23);
		add(button_3);
		repaint();
	}
	
}
