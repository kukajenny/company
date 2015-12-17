package messagejpanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import jframe.Main;
import company.Test;
import company.Testmysql;
public class Message_goods extends JPanel {
	private JTextField textField;
	private JTextField textField2;
	private JTextField search_textField1;
	private JTextField search_textField2;
	private JTable table;
	
	DefaultTableModel tableModel;
	Vector<Vector<String>> tableValueV;
	Vector<String> columnNameV;
	/**
	 * Create the panel.
	 */
	public Message_goods() {
		setBackground(Color.WHITE);
		
		
		setBounds(197, 0, 637, 570);
		setLayout(null);
		
		String JDriver = "com.mysql.jdbc.Driver";  // MySQL提供的JDBC驱动，要保证它在CLASSPATH里可见

        String conURL = "jdbc:mysql://localhost/"+Test.database;  // 本地计算机上的MySQL数据库Company的URL

        try {
            Class.forName(JDriver);
        }
        catch(ClassNotFoundException cnf_e) {  // 如果找不到驱动类
            System.out.println("Driver Not Found: " + cnf_e);
        }
	
		/*JTextArea txtOut=new JTextArea();
		txtOut.setBackground(new Color(255, 255, 255));
		txtOut.setLineWrap(true);
		//txtOut.setPreferredSize(new Dimension(x*19+30,y*3-25));//去掉这一句
		JScrollPane scrollPaneOut=new JScrollPane(txtOut);
		scrollPaneOut.setSize(438, 250);
		scrollPaneOut.setLocation(110, 90);
		//scrollPaneOut.setPreferredSize(new Dimension(100,50));//这里加一句
		add(scrollPaneOut);
		*/
        
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(113, 391, 450, 128);
		add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		panel.setBorder (BorderFactory.createTitledBorder ("添加商品"));
		
		JLabel label = new JLabel("\u79CD\u7C7B\u540D\u79F0\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(19, 30, 80, 15);
		panel.add(label);
		
		JLabel label_2 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(19, 52, 80, 30);
		panel.add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(109, 27, 149, 21);
		panel.add(comboBox);
		comboBox.setEditable(true);

		textField = new JTextField();
		textField.setBounds(109, 57, 149, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		
		JPanel panel1= new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(113, 391, 450, 128);
		add(panel1);
		panel1.setLayout(null);
		panel1.setVisible(false);
		panel1.setBorder (BorderFactory.createTitledBorder ("修改商品"));
		
		
		
		JLabel label1 = new JLabel("\u79CD\u7C7B\u540D\u79F0\uFF1A");
		label1.setFont(new Font("宋体", Font.PLAIN, 15));
		label1.setBounds(19, 30, 80, 15);
		panel1.add(label1);
		
		JLabel label1_2 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label1_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label1_2.setBounds(19, 52, 80, 30);
		panel1.add(label1_2);
		
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(113, 391, 450, 128);
		add(panel2);
		panel2.setLayout(null);
		panel2.setVisible(false);
		panel2.setBorder (BorderFactory.createTitledBorder ("查询商品"));
		
		
		textField2 = new JTextField();
		textField2.setBounds(109, 57, 149, 21);
		panel1.add(textField2);
		textField2.setColumns(10);
		
		search_textField1 = new JTextField();
		search_textField1.setBounds(109, 27, 149, 21);
		panel2.add(search_textField1);
		search_textField1.setColumns(10);
		
		search_textField2 = new JTextField();
		search_textField2.setBounds(109, 57, 149, 21);
		panel2.add(search_textField2);
		search_textField2.setColumns(10);
		
		
		
		JLabel label_1 = new JLabel("\u79CD\u7C7B\u540D\u79F0\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(19, 30, 80, 15);
		panel2.add(label_1);
		
		JLabel label_3 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(19, 52, 80, 30);
		panel2.add(label_3);
		
		
		
		table = new JTable();
		table.setBounds(0, 0, 438, 250);
		JScrollPane scrollPane1=new JScrollPane();
		String[] columnNames = { "商品类型","商品名称" };
		columnNameV = new Vector<String>();
		for (int column = 0; column < columnNames.length; column++) {
			columnNameV.add(columnNames[column]);
		}
		
		HashSet set1=new HashSet();
		tableValueV = new Vector<Vector<String>>();
		try {
            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

            Statement s = con.createStatement();  // Statement类用来提交SQL语句

            ResultSet rs = s.executeQuery("select * from goods;");  // 提交查询，返回的表格保存在rs中

            while(rs.next()) {  // ResultSet指针指向下一个“行”
            	if(set1.contains(rs.getString("lei")+rs.getString("name"))==false){
            		Vector<String> rowV = new Vector<String>();
        			rowV.add(rs.getString("lei"));
        			rowV.add(rs.getString("name"));
        			tableValueV.add(rowV);
        			set1.add(rs.getString("lei")+rs.getString("name"));
            	}
            }
			
            s.close();     // 释放Statement对象
            con.close();   // 关闭到MySQL服务器的连接
        }
        catch(SQLException sql_e) {     // 都是SQLExceptionss
            System.out.println(sql_e);
        }
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(109, 27, 149, 21);
		panel1.add(comboBox_1);
		comboBox_1.setEditable(false);
		
		Iterator it=Main.leiset.iterator();
		while(it.hasNext()){
			String s=it.next().toString();
			comboBox.addItem(s);
			comboBox_1.addItem(s);
			//Chuku.
		}
		
		tableModel = new DefaultTableModel(tableValueV,
				columnNameV);
		final JTable table = new JTable(tableModel);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>(tableModel));
		scrollPane1.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		TableColumnModel tableColumnModel = table.getColumnModel();
		ListSelectionModel listSelectionModel = tableColumnModel
				.getSelectionModel();
		add(scrollPane1);
		scrollPane1.setBounds(110, 65, 438, 250);
		//table.setBounds(0, 0, 438, 250);
		//add(table);
		TableColumnModel   cm   =   table.getColumnModel(); 
		TableColumn   column  = cm.getColumn(0);//得到第i个列对象   
		  column.setPreferredWidth(210);//将此列的首选宽度设置为 preferredWidth。
		  TableColumn   column1  = cm.getColumn(1);//得到第i个列对象   
		  column1.setPreferredWidth(210);//将此列的首选宽度设置为 preferredWidth。
		  DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();    
		  r.setHorizontalAlignment(JLabel.CENTER);
		  table.setDefaultRenderer(Object.class, r);
		
		JButton button_1 = new JButton("\u6DFB\u52A0\u5546\u54C1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(panel.isVisible()==false)panel.setVisible(true);
				else panel.setVisible(false);
				panel1.setVisible(false);
				panel2.setVisible(false);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		button_1.setBounds(216, 338, 106, 27);
		add(button_1);
		
		JButton button = new JButton("\u786E\u5B9A");//添加
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=(String) comboBox.getSelectedItem(),b=textField.getText();
					if(Main.leiset.contains(a)==false){
						comboBox.addItem(a);
						Main.leiset.add(a);
						System.out.println(Main.leiset.size()+"goods");
						Connection con;
						try {
							con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);
							Statement s = con.createStatement();  // Statement类用来提交
							String insert = "insert into fenlei(lei) values('"+a+"')";  
							s.executeUpdate(insert);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  // 连接数据库

			            
					}
					
					//txtOut.append(a+"      "+b+"\n");
					if(set1.contains(a+b)==false){
						set1.add(a+b);
						try {//插入
				            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

				            Statement s = con.createStatement();  // Statement类用来提交SQL语句

				            String insert = "insert into goods(lei,name,num) values('"+a+"','"+b+"','0')";  
							s.executeUpdate(insert);
							Vector<String> rowV = new Vector<String>();
			    			rowV.add(a);
			    			rowV.add(b);
			    			tableValueV.add(rowV);
			    			tableModel.setDataVector(tableValueV,columnNameV); 
			    			int  rowCount = table.getRowCount();   
			    			table.getSelectionModel().setSelectionInterval(rowCount-1 , rowCount- 1 );   
			    			Rectangle rect = table.getCellRect(rowCount-1 ,  0 ,  true );
			    			table.scrollRectToVisible(rect);  
				           
				            TableColumnModel   cm   =   table.getColumnModel(); 
				    		TableColumn   column  = cm.getColumn(0);//得到第i个列对象   
				    		  column.setPreferredWidth(210);//将此列的首选宽度设置为 preferredWidth。
				    		  TableColumn   column1  = cm.getColumn(1);//得到第i个列对象   
				    		  column1.setPreferredWidth(210);//将此列的首选宽度设置为 preferredWidth。
				    		  
				    		  Statement s2 = con.createStatement();  // Statement类用来提交SQL语句
				    		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				        		//System.out.println("insert into news(time,news,limit) values('"+df.format(new Date())+"','"+Name+"登入系统"+"','"+limite+"')");
				        		String insert1 = "insert into news(time,news,limite) values('"+df.format(new Date())+"','"+Testmysql.limite+Testmysql.Name+"添加商品"+a+":"+b+"成功"+"','"+Testmysql.limite+"')";  
				        		s2.executeUpdate(insert1);
				        			
				                  s2.close();     // 释放Statement对象
				                  s.close();     // 释放Statement对象
						            con.close();   // 关闭到MySQL服务器的连接
				        }
				        catch(SQLException sql_e) {     // 都是SQLExceptionss
				            System.out.println(sql_e);
				        }
					}
				
		        
			}
		});
		button.setBounds(86, 95, 93, 23);
		panel.add(button);
		
		
		
		table.addMouseListener(new MouseListener(){

			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int selectedRow = table.getSelectedRow();//获得选中行的索引
				if(selectedRow!= -1)   //是否存在选中行
			    {
			        Object oa = tableModel.getValueAt(selectedRow, 0);
			        Object ob = tableModel.getValueAt(selectedRow, 1);
			        comboBox_1.setSelectedItem(oa.toString());
			        textField2.setText(ob.toString());
			    }
			    else{
			        textField2.setText("");
			    }
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	    
	    
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(panel1.isVisible()==false){
					panel1.setVisible(true);
					
				}
				else panel1.setVisible(false);
				panel.setVisible(false);
				panel2.setVisible(false);
			}
		});
		btnNewButton.setBounds(354, 338, 106, 27);
		add(btnNewButton);
        
		JButton button1 = new JButton("\u786E\u5B9A");//修改
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 int selectedRow = table.getSelectedRow();//获得选中行的索引
				    if(selectedRow!= -1)   //是否存在选中行
				    {
				     //修改指定的值：
				    String a=tableModel.getValueAt(selectedRow, 0).toString();
				    String b=tableModel.getValueAt(selectedRow, 1).toString();
				     
				    tableModel.setValueAt(comboBox_1.getSelectedItem(), selectedRow, 0);
				     tableModel.setValueAt(textField2.getText(), selectedRow, 1);
				     
				        try {
				            Connection con = DriverManager.getConnection(conURL,Test.mysqlname, Test.mysqlpassword);  // 连接数据库

				            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // Statement类用来提交SQL语句
				            
				            ResultSet rs = s.executeQuery("select lei,name from goods");  // 提交查询，返回的表格保存在rs中

				            while(rs.next()) {  // ResultSet指针指向下一个“行”
				                if(rs.getString("lei").equals(a)&&rs.getString("name").equals(b)){
				                	rs.updateString("lei", comboBox_1.getSelectedItem().toString());
				                	rs.updateString("name", textField2.getText());
				                	rs.updateRow();
				                	 Statement s2 = con.createStatement();  // Statement类用来提交SQL语句
						    		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
						        		//System.out.println("insert into news(time,news,limit) values('"+df.format(new Date())+"','"+Name+"登入系统"+"','"+limite+"')");
						        		String insert1 = "insert into news(time,news,limite) values('"+df.format(new Date())+"','"+Testmysql.limite+Testmysql.Name+"修改商品信息"+a+":"+b+"成功"+"','"+Testmysql.limite+"')";  
						        		s2.executeUpdate(insert1);
						        			
						                  s2.close();     // 释放Statement对象
				                	break;
				                }
				            }
				            
				           
				            s.close();     // 释放Statement对象
				            con.close();   // 关闭到MySQL服务器的连接
				        }
				        catch(SQLException sql_e) {     // 都是SQLException
				            System.out.println(sql_e);
				        }
				     //table.setValueAt(arg0, arg1, arg2)
				    }
				    
			}
			
		});
		button1.setBounds(86, 95, 93, 23);
		panel1.add(button1);
		
		
		
		JButton button_2 = new JButton("\u5220\u9664");//删除
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object [] options ={"确定","取消"};
				int flag=JOptionPane.showOptionDialog(Test.zhu, "确定删除该供应商信息？","删除",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
				if(flag==0){
					int selectedRow = table.getSelectedRow();//获得选中行的索引
					int rowcount=table.getRowCount();
				    if(selectedRow!=-1&&!set1.isEmpty()&&selectedRow!=rowcount)  //存在选中行
				    {
				    	Object oa = tableModel.getValueAt(selectedRow, 0);
					     Object ob = tableModel.getValueAt(selectedRow, 1);
					     set1.remove(oa.toString()+ob.toString());
				    	tableModel.removeRow(selectedRow);  //删除行
				    	
				    	table.getSelectionModel().setSelectionInterval(selectedRow , selectedRow );   
		    			Rectangle rect = table.getCellRect(selectedRow ,  0 ,  true );
		    			table.scrollRectToVisible(rect);
		    			
				    	 try {
				             Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

				             Statement s = con.createStatement();  // Statement类用来提交
				             
				 			String delete = "Delete From goods Where lei='"+oa.toString()+"' and name='"+ob.toString()+"'";
				 			s.executeUpdate(delete);
				 			
				 			ResultSet rs = s.executeQuery("select * from goods;");  // 提交查询，返回的表格保存在rs中

				 			boolean flag1=false;
				            while(rs.next()) {  // ResultSet指针指向下一个“行”
				                if(rs.getString("lei").equals(oa.toString())) {flag1=true;break;}
				            }
							if(!flag1){
								Main.leiset.remove(oa.toString());
								String delete1 = "Delete From fenlei Where lei='"+oa.toString()+"'";
					 			s.executeUpdate(delete1);
					 			comboBox.removeItem(oa.toString());
					 			
					 			Statement s2 = con.createStatement();  // Statement类用来提交SQL语句
					    		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					        		//System.out.println("insert into news(time,news,limit) values('"+df.format(new Date())+"','"+Name+"登入系统"+"','"+limite+"')");
					        		String insert1 = "insert into news(time,news,limite) values('"+df.format(new Date())+"','"+Testmysql.limite+Testmysql.Name+"删除商品"+oa.toString()+":"+ob.toString()+"成功"+"','"+Testmysql.limite+"')";  
					        		s2.executeUpdate(insert1);
					        			
					                  s2.close();     // 释放Statement对象
							}
							
							
				             s.close();     // 释放Statement对象
				             con.close();   // 关闭到MySQL服务器的连接
				         }
				         catch(SQLException sql_e) {     // 都是SQLException
				             System.out.println(sql_e);
				         }
				    }
				}
				
			}
		});
		button_2.setBounds(83, 338, 106, 27);
		add(button_2);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(panel2.isVisible()==false)panel2.setVisible(true);
				else panel2.setVisible(false);
				panel1.setVisible(false);
				panel.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(487, 338, 106, 27);
		add(btnNewButton_2);
        
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");//确定查询
		btnNewButton_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String a=search_textField1.getText();
				String b=search_textField2.getText();
				
				if(a.equals(""))a="any(select lei from goods)";
				else a="'"+a+"'";
				if(b.equals(""))b="any(select name from goods)";
				else b="'"+b+"'";
				
				table.removeAll();
				tableValueV.removeAllElements();
				try {//插入
					
		            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

		            Statement s = con.createStatement();  // Statement类用来提交SQL语句

		     
		            String select="select * from goods where lei="+a+" and name ="+b; 
		            ResultSet rs = s.executeQuery(select);  // 提交查询，返回的表格保存在rs中
		            
		            while(rs.next()) {  // ResultSet指针指向下一个“行”
		            	
		            	Vector<String> rowV = new Vector<String>();
		            	rowV.add(rs.getString("lei"));
		    			rowV.add(rs.getString("name"));
		    			tableValueV.add(rowV);
		    			System.out.println(rs.getString("lei"));
		    			
		            }
		            tableModel.setDataVector(tableValueV,columnNameV); 
	    			int  rowCount = table.getRowCount();   
	    			table.getSelectionModel().setSelectionInterval(rowCount-1 , rowCount- 1 );   
	    			Rectangle rect = table.getCellRect(rowCount-1 ,  0 ,  true );
	    			table.scrollRectToVisible(rect);  
		            s.close();     // 释放Statement对象
		            con.close();   // 关闭到MySQL服务器的连接
		            TableColumnModel   cm   =   table.getColumnModel(); 
		    		TableColumn   column  = cm.getColumn(0);//得到第i个列对象   
		    		  column.setPreferredWidth(210);//将此列的首选宽度设置为 preferredWidth。
		    		  TableColumn   column1  = cm.getColumn(1);//得到第i个列对象   
		    		  column1.setPreferredWidth(210);//将此列的首选宽度设置为 preferredWidth。
		    		  
		        }
		        catch(SQLException sql_e) {     // 都是SQLExceptionss
		            System.out.println(sql_e);
		        }
				
			}
			
		});
		btnNewButton_1.setBounds(86, 95, 93, 23);
		panel2.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("\u53D6\u6D88");//取消
		btnNewButton_3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				search_textField1.setText("");
				search_textField2.setText("");
				int num=tableModel.getRowCount();
				while(num--!=0){tableModel.removeRow(0);}
				
				try {//插入
					
		            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

		            Statement s = con.createStatement();  // Statement类用来提交SQL语句

		            ResultSet rs = s.executeQuery("select * from goods");  // 提交查询，返回的表格保存在rs中
		            
		            while(rs.next()) {  // ResultSet指针指向下一个“行”
		            	
		            	Vector<String> rowV = new Vector<String>();
		            	rowV.add(rs.getString("lei"));
		    			rowV.add(rs.getString("name"));
		    			tableValueV.add(rowV);
		            }
		            tableModel.setDataVector(tableValueV,columnNameV); 
	    			int  rowCount = table.getRowCount();   
	    			table.getSelectionModel().setSelectionInterval(rowCount-1 , rowCount- 1 );   
	    			Rectangle rect = table.getCellRect(rowCount-1 ,  0 ,  true );
	    			table.scrollRectToVisible(rect);  
		            s.close();     // 释放Statement对象
		            con.close();   // 关闭到MySQL服务器的连接
		            TableColumnModel   cm   =   table.getColumnModel(); 
		    		TableColumn   column  = cm.getColumn(0);//得到第i个列对象   
		    		  column.setPreferredWidth(210);//将此列的首选宽度设置为 preferredWidth。
		    		  TableColumn   column1  = cm.getColumn(1);//得到第i个列对象   
		    		  column1.setPreferredWidth(210);//将此列的首选宽度设置为 preferredWidth。
		    		  
		    		  
		        }
		        catch(SQLException sql_e) {     // 都是SQLExceptionss
		            System.out.println(sql_e);
		        }
			}
			
		});
		btnNewButton_3.setBounds(200, 95, 93, 23);
		panel2.add(btnNewButton_3);
		
	}
}


