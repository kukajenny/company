package messagejpanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JTable;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.SpinnerNumberModel;

import company.Test;
import company.Testmysql;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import jframe.Main;

public class Kucun_ruku extends JFrame {

	private JPanel contentPane;
	public static JButton ruku;
	int windowwidth=800;
	int windowheight=380;
	public static JTextField rukudanhao;
	public static JTextField rukutime;
	public static JTextField operator;
	public static JTextField caigouhao;
	public static JTextField price;
	public static JTextField num;
	public static JTextField time;
	public static JComboBox fenlei;
	public static JComboBox name;
	public static JLabel num1;
	public static JLabel price1;
	public static JFrame frame;
	public static JTextField jingshouren;
	
	String JDriver = "com.mysql.jdbc.Driver";  // MySQL提供的JDBC驱动，要保证它在CLASSPATH里可见

    String conURL = "jdbc:mysql://localhost/"+Test.database;  // 本地计算机上的MySQL数据库Company的URL
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ruku frame = new Ruku();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public Kucun_ruku() {
		setResizable(false);
		setTitle("\u91C7\u8D2D\u5165\u5E93\u7BA1\u7406");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(windowwidth,windowheight);
    	int screenWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().width;
    	int screenHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().height;
    	setLocation((screenWidth-windowwidth)/2,(screenHeight-windowheight)/2);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(21, 24, 753, 112);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 25, 733, 80);
		panel_1.add(panel);
		panel.setBackground(Color.WHITE);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{80, 130, 23, 100, 130, 0, 95, 130, 0};
		gbl_panel.rowHeights = new int[]{40, 40, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		panel_1.setBorder (BorderFactory.createTitledBorder ("基本信息"));
		
		JLabel label_4 = new JLabel("\u5165\u5E93\u5355\u53F7\uFF1A");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.fill = GridBagConstraints.VERTICAL;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 0;
		panel.add(label_4, gbc_label_4);
		
		rukudanhao = new JTextField();
		GridBagConstraints gbc_rukudanhao = new GridBagConstraints();
		gbc_rukudanhao.insets = new Insets(0, 0, 5, 5);
		gbc_rukudanhao.fill = GridBagConstraints.HORIZONTAL;
		gbc_rukudanhao.gridx = 1;
		gbc_rukudanhao.gridy = 0;
		panel.add(rukudanhao, gbc_rukudanhao);
		rukudanhao.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5165\u5E93\u65E5\u671F\uFF1A");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 0;
		panel.add(label_1, gbc_label_1);
		
		rukutime = new JTextField();
		GridBagConstraints gbc_rukutime = new GridBagConstraints();
		gbc_rukutime.insets = new Insets(0, 0, 5, 5);
		gbc_rukutime.fill = GridBagConstraints.HORIZONTAL;
		gbc_rukutime.gridx = 4;
		gbc_rukutime.gridy = 0;
		panel.add(rukutime, gbc_rukutime);
		rukutime.setColumns(10);
		rukutime.setText(df.format(new Date()));
		//textField_1.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("\u91C7\u8D2D\u8BA2\u5355\u53F7\uFF1A");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 6;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		caigouhao = new JTextField();
		GridBagConstraints gbc_caigouhao = new GridBagConstraints();
		gbc_caigouhao.insets = new Insets(0, 0, 5, 0);
		gbc_caigouhao.fill = GridBagConstraints.HORIZONTAL;
		gbc_caigouhao.gridx = 7;
		gbc_caigouhao.gridy = 0;
		panel.add(caigouhao, gbc_caigouhao);
		caigouhao.setColumns(10);
		
		JLabel label = new JLabel("\u7ECF\u624B\u4EBA\uFF1A");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.fill = GridBagConstraints.VERTICAL;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);
		//jingshouren.setModel(new DefaultComboBoxModel(new String[] {"\u5F20\u7ECF\u7406", "\u9648\u7ECF\u7406"}));
		String [] s=new String[100];
		
		jingshouren = new JTextField();
		GridBagConstraints gbc_jingshouren = new GridBagConstraints();
		gbc_jingshouren.insets = new Insets(0, 0, 0, 5);
		gbc_jingshouren.fill = GridBagConstraints.HORIZONTAL;
		gbc_jingshouren.gridx = 1;
		gbc_jingshouren.gridy = 1;
		panel.add(jingshouren, gbc_jingshouren);
		jingshouren.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel();
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 1;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		/*ImageIcon add = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Ruku.class.getResource("/picture/4.png")));
		add.getImage();
		Image img1 = add.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		add=new ImageIcon(img1);
		lblNewLabel_4.setIcon(add);
		*/
		
		JLabel label_2 = new JLabel("\u64CD\u4F5C\u5458\uFF1A");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 1;
		panel.add(label_2, gbc_label_2);
		
		operator = new JTextField();
		GridBagConstraints gbc_operator = new GridBagConstraints();
		gbc_operator.insets = new Insets(0, 0, 0, 5);
		gbc_operator.fill = GridBagConstraints.HORIZONTAL;
		gbc_operator.gridx = 4;
		gbc_operator.gridy = 1;
		panel.add(operator, gbc_operator);
		operator.setColumns(10);
		operator.setText(Testmysql.Name);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rukudanhao.setEditable(false);
				rukutime.setEditable(false);
				caigouhao.setEditable(false);
				jingshouren.setEditable(false);
				operator.setEditable(false);
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.EAST;
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 6;
		gbc_button.gridy = 1;
		panel.add(button, gbc_button);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setLayout(null);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 7;
		gbc_panel_4.gridy = 1;
		panel.add(panel_4, gbc_panel_4);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rukudanhao.setText("");
				caigouhao.setText("");
				operator.setText("");
			}
		});
		btnNewButton.setBounds(2, 6, 64, 28);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rukudanhao.setEditable(true);
				rukutime.setEditable(true);
				caigouhao.setEditable(true);
				jingshouren.setEditable(true);
				operator.setEditable(true);
			}
		});
		btnNewButton_1.setBounds(72, 6, 63, 28);
		panel_4.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(21, 146, 753, 119);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBorder (BorderFactory.createTitledBorder ("商品信息"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("");
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 25, 733, 85);
		panel_3.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{80, 130, 23, 100, 130, 0, 95, 130, 0};
		gbl_panel_2.rowHeights = new int[]{40, 40, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
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
		//fenlei.setModel(new DefaultComboBoxModel(new String[] {"\u997C\u5E72\u7C7B", "\u85AF\u7247\u7C7B", "\u9999\u80A0\u7C7B", "\u5DE7\u514B\u529B", "\u5176\u4ED6"}));
		//fenlei.setEditable(true);
		Iterator it=Main.leiset.iterator();
		while(it.hasNext()){
			String s1=it.next().toString();
			fenlei.addItem(s1);
		}
		
		name = new JComboBox();
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.gridx = 4;
		gbc_name.gridy = 0;
		panel_2.add(name, gbc_name);
		//name.setEditable(true);
		if(!Main.leiset.isEmpty()){
			String start=fenlei.getItemAt(0).toString();
			try {//插入
	            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库
	            Statement s1 = con.createStatement();  // Statement类用来提交SQL语句
	            String select="select name from goods where lei='"+start+"'"; 
	            ResultSet rs = s1.executeQuery(select);  // 提交查询，返回的表格保存在rs中
	            while(rs.next()){
	            	name.addItem(rs.getString("name"));
	            }
			}catch(SQLException sql_e) {     // 都是SQLExceptionss
	            System.out.println(sql_e);
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
				}catch(SQLException sql_e) {     // 都是SQLExceptionss
		            System.out.println(sql_e);
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
		
		
		
		JLabel label_8 = new JLabel("\u98DF\u54C1\u6709\u6548\u671F\u81F3\uFF1A");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.EAST;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 6;
		gbc_label_8.gridy = 0;
		panel_2.add(label_8, gbc_label_8);
		
		time = new JTextField();
		GridBagConstraints gbc_time = new GridBagConstraints();
		gbc_time.fill = GridBagConstraints.HORIZONTAL;
		gbc_time.insets = new Insets(0, 0, 5, 0);
		gbc_time.gridx = 7;
		gbc_time.gridy = 0;
		panel_2.add(time, gbc_time);
		time.setColumns(10);
		
		JLabel label_6 = new JLabel("\u5355\u4EF7\uFF1A");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 0, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 1;
		panel_2.add(label_6, gbc_label_6);
		
		price = new JTextField();
		GridBagConstraints gbc_price = new GridBagConstraints();
		gbc_price.fill = GridBagConstraints.HORIZONTAL;
		gbc_price.insets = new Insets(0, 0, 0, 5);
		gbc_price.gridx = 1;
		gbc_price.gridy = 1;
		panel_2.add(price, gbc_price);
		price.setColumns(10);
		
		price1 = new JLabel("");
		price1.setBounds(0,0,20,20);
		price1.setToolTipText("new");
		GridBagConstraints gbc_price1 = new GridBagConstraints();
		gbc_price1.insets = new Insets(0, 0, 0, 5);
		gbc_price1.gridx = 2;
		gbc_price1.gridy = 1;
		panel_2.add(price1, gbc_price1);
		
		JLabel label_7 = new JLabel("\u6570\u91CF\uFF1A");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.insets = new Insets(0, 0, 0, 5);
		gbc_label_7.gridx = 3;
		gbc_label_7.gridy = 1;
		panel_2.add(label_7, gbc_label_7);
		
		num = new JTextField();
		GridBagConstraints gbc_num = new GridBagConstraints();
		gbc_num.fill = GridBagConstraints.HORIZONTAL;
		gbc_num.insets = new Insets(0, 0, 0, 5);
		gbc_num.gridx = 4;
		gbc_num.gridy = 1;
		panel_2.add(num, gbc_num);
		num.setColumns(10);
		
		num1 = new JLabel("");
		GridBagConstraints gbc_num1 = new GridBagConstraints();
		gbc_num1.insets = new Insets(0, 0, 0, 5);
		gbc_num1.gridx = 5;
		gbc_num1.gridy = 1;
		panel_2.add(num1, gbc_num1);
		
		JLabel label_9 = new JLabel("\u5408\u8BA1\uFF1A");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.EAST;
		gbc_label_9.insets = new Insets(0, 0, 0, 5);
		gbc_label_9.gridx = 6;
		gbc_label_9.gridy = 1;
		panel_2.add(label_9, gbc_label_9);
		
		ruku= new JButton("\u5165\u5E93");
		ruku.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String a=rukudanhao.getText();
				String b=rukutime.getText();
				String d=jingshouren.getText();
				String c=rukudanhao.getText();
				String e=operator.getText();
				String f=(String)fenlei.getSelectedItem();
				String g=(String)name.getSelectedItem();
				String h=time.getText();
				String i=price.getText();
				String j=num.getText();
				
				ImageIcon right = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Kucun_ruku.class.getResource("/picture/2.png")));
				right.getImage();
				Image img = right.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				right=new ImageIcon(img);
				
				ImageIcon wrong = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Kucun_ruku.class.getResource("/picture/1.png")));
				wrong.getImage();
				Image img1 = wrong.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				wrong=new ImageIcon(img1);
				Boolean flag=false;
				Kucun_ruku.price1.setIcon(right);
				Kucun_ruku.num1.setIcon(right);
				try{
					Double.parseDouble(i);
				}catch(Exception e2){
					flag=true;
					Kucun_ruku.price1.setIcon(wrong);
				}
				try{
					Integer.parseInt(j);
				}catch(Exception e2){
					flag=true;
					Kucun_ruku.num1.setIcon(wrong);
				}
				/*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式k
				try {
					Date time= df.parse(df.format(new Date()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				*/
				 String JDriver = "com.mysql.jdbc.Driver";  // MySQL提供的JDBC驱动，要保证它在CLASSPATH里可见

			        String conURL = "jdbc:mysql://localhost/"+Test.database;  // 本地计算机上的MySQL数据库Company的URL

			        try {
			            Class.forName(JDriver);
			        }
			        catch(ClassNotFoundException cnf_e) {  // 如果找不到驱动类
			            System.out.println("Driver Not Found: " + cnf_e);
			        }
			        if(!flag){
			        	 try {//插入kucun
					            Connection con = DriverManager.getConnection(conURL,Test.mysqlname, Test.mysqlpassword);  // 连接数据库
					            Statement s = con.createStatement();  // Statement类用来提交SQL语句
					            String insert = "insert into kucun(danhao,time,caigouhao,jingshouren,operator,lei,name,endtime,price,num) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"')";  
					            //String insert = "insert into kucun(jingshouren) values('d')";
					            s.executeUpdate(insert);
					            Kucun_ruku.price1.setIcon(right);
					            Kucun_ruku.num1.setIcon(right);
					            JOptionPane.showMessageDialog(Main.rukuframe, "入库成功","入库成功",1);
					            s.close();     // 释放Statement对象
					            con.close();   // 关闭到MySQL服务器的连接
					        }
					        catch(SQLException sql_e) {     // 都是SQLException
					            System.out.println(sql_e);
					        }
			        	 
			        	 try {//插入goods
					            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库
					            Statement s = con.createStatement();  // Statement类用来提交SQL语句
					            ResultSet rs = s.executeQuery("select * from goods;");  // 提交查询，返回的表格保存在rs中
					            while(rs.next()) {  // ResultSet指针指向下一个“行”
					                if(rs.getString("lei").equals(f)&&rs.getString("name").equals(g)){
					                	System.out.println(rs.getString("num")+" "+j);
					                	int num=Integer.parseInt(rs.getString("num"))+Integer.parseInt(j);
					                	String update = "Update goods Set num='"+num+"' Where lei='"+f+"' and name = '"+g+"'";
					            		s.executeUpdate(update);
					            		break;
					                }
					            }
					            s.close();     // 释放Statement对象
					            con.close();   // 关闭到MySQL服务器的连接
					        }
					        catch(SQLException sql_e) {     // 都是SQLException
					            System.out.println(sql_e);
					        }
			        	 
			        	 try {//插入ruku_mounth
					            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库
					            Statement s = con.createStatement();  // Statement类用来提交SQL语句
					            Statement s1 = con.createStatement();  // Statement类用来提交SQL语句
					            ResultSet rs = s.executeQuery("select * from ruku_mounth where time like '"+b.substring(0, 7)+"%'");  // 提交查询，返回的表格保存在rs中
					            boolean flag1=false;
					            int sum=Integer.parseInt(i)*Integer.parseInt(j);
					            while(rs.next()) {  // ResultSet指针指向下一个“行”
					                if(rs.getString("time").equals(b.substring(0, 7))){
					                	int money=Integer.parseInt(rs.getString("money"))+sum;
					                	String update = "Update ruku_mounth Set money='"+money+"' Where time='"+b.substring(0, 7)+"'";
					            		s1.executeUpdate(update);
					            		flag1=true;
					            		break;
					                }
					            }
					            if(!flag1){
					            	String insert = "insert into ruku_mounth(money,time) values('"+sum+"','"+b.substring(0, 7)+"')";  
					    			s1.executeUpdate(insert);
					            }
					            
					            Statement s2 = con.createStatement();  // Statement类用来提交SQL语句
					    		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					        		//System.out.println("insert into news(time,news,limit) values('"+df.format(new Date())+"','"+Name+"登入系统"+"','"+limite+"')");
					        		String insert1 = "insert into news(time,news,limite) values('"+df.format(new Date())+"','"+Testmysql.limite+Testmysql.Name+"入库"+f+":"+g+" "+j+"成功"+"','"+Testmysql.limite+"')";  
					        		s2.executeUpdate(insert1);
					        			
					                  s2.close();     // 释放Statement对象
					            s.close();     // 释放Statement对象
					            con.close();   // 关闭到MySQL服务器的连接
					        }
					        catch(SQLException sql_e) {     // 都是SQLException
					            System.out.println("ruku_mounth  "+sql_e);
					        }
			        	 
			        }
			}
			
		});
		ruku.setBounds(193, 289, 93, 23);
		contentPane.add(ruku);
		
		JButton button_3 = new JButton("\u91CD\u7F6E");
		button_3.setBounds(338, 289, 93, 23);
		contentPane.add(button_3);
		
	}
}
