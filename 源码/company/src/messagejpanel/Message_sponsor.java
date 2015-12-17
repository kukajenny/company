package messagejpanel;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import company.Test;
import company.Testmysql;

import javax.swing.JTextPane;

import titlejpanel.Message;
import jframe.Main;

public class Message_sponsor extends JPanel {

	/**
	 * Create the panel.
	 */
			private JTextField add_textField;
			private JTextField modify_textField;
			private JTable table;
			private JTextField add_textField_1;
			private JTextField modify_textField_1;
			private JTextField search_textField;
			private JTextField search_textField_1;
			private JTextField search_textField_2;
			String JDriver = "com.mysql.jdbc.Driver";  // MySQL提供的JDBC驱动，要保证它在CLASSPATH里可见

	        String conURL = "jdbc:mysql://localhost/"+Test.database;  // 本地计算机上的MySQL数据库Company的URL
	        DefaultTableModel tableModel;
	        Vector<Vector<String>> tableValueV;
	        Vector<String> columnNameV;
			
			/**
			 * Create the panel.
			 */
			public Message_sponsor() {
				setBackground(Color.WHITE);
				
				
				setBounds(197, 0, 637, 570);
				setLayout(null);
				
				initgui();
				
				
		        
				
		}
			public void initgui(){
				
				
		        
		        
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				panel.setBounds(110, 372, 450, 171);
				add(panel);
				panel.setLayout(null);
				panel.setVisible(false);
				panel.setBorder (BorderFactory.createTitledBorder ("添加供应商"));
				
				JPanel panel1= new JPanel();
				panel1.setBounds(110, 372, 450, 171);
				add(panel1);
				panel1.setBackground(Color.WHITE);
				panel1.setLayout(null);
				panel1.setVisible(false);
				panel1.setBorder (BorderFactory.createTitledBorder ("修改供应商"));
				
				JPanel panel2= new JPanel();
				panel2.setBounds(110, 372, 450, 171);
				add(panel2);
				panel2.setBackground(Color.WHITE);
				panel2.setLayout(null);
				panel2.setVisible(false);
				panel2.setBorder (BorderFactory.createTitledBorder ("查询供应商"));
				
				
				JLabel label = new JLabel("\u4F9B\u5E94\u5546\u7C7B\u522B:");
				label.setFont(new Font("宋体", Font.PLAIN, 15));
				label.setBounds(19, 30, 107, 15);
				panel.add(label);
				
				JLabel label_2 = new JLabel("\u4F9B\u5E94\u5546\u540D\u79F0\uFF1A");
				label_2.setFont(new Font("宋体", Font.PLAIN, 15));
				label_2.setBounds(19, 52, 107, 30);
				panel.add(label_2);
				
				JComboBox add_comboBox = new JComboBox();
				add_comboBox.setBounds(141, 27, 149, 21);
				panel.add(add_comboBox);

				add_textField = new JTextField();
				add_textField.setBounds(141, 57, 149, 21);
				panel.add(add_textField);
				add_textField.setColumns(10);
				
				add_textField_1 = new JTextField();
				add_textField_1.setBounds(141, 90, 149, 21);
				panel.add(add_textField_1);
				add_textField_1.setColumns(10);
				
				table = new JTable();
				table.setBounds(0, 0, 438, 250);
				JScrollPane scrollPane1=new JScrollPane();
				String[] columnNames = { "供应商类别","供应商名称","供应商联系方式" };
				columnNameV = new Vector<String>();
				for (int column = 0; column < columnNames.length; column++) {
					columnNameV.add(columnNames[column]);
				}
				
				
				JComboBox modify_comboBox_1 = new JComboBox();
				modify_comboBox_1.setBounds(141, 27, 149, 21);
				panel1.add(modify_comboBox_1);
				modify_comboBox_1.setEditable(false);
				
				modify_textField = new JTextField();
				modify_textField.setBounds(141, 57, 149, 21);
				panel1.add(modify_textField);
				modify_textField.setColumns(10);
				
				modify_textField_1 = new JTextField();
				modify_textField_1.setBounds(141, 93, 149, 21);
				panel1.add(modify_textField_1);
				modify_textField_1.setColumns(10);
				
				search_textField = new JTextField();
				search_textField.setBounds(141, 27, 149, 21);
				panel2.add(search_textField);
				
				search_textField_1 = new JTextField();
				search_textField_1.setBounds(141, 57, 149, 21);
				panel2.add(search_textField_1);
				
				search_textField_2 = new JTextField();
				search_textField_2.setBounds(141, 93, 149, 21);
				panel2.add(search_textField_2);
				
				
				
				JLabel lblNewLabel_1 = new JLabel("\u4F9B\u5E94\u5546\u7C7B\u522B\uFF1A");
				lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(19, 30, 107, 15);
				panel2.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("\u4F9B\u5E94\u5546\u540D\u79F0\uFF1A");
				lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_2.setBounds(19, 52, 107, 30);
				panel2.add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel("\u4F9B\u5E94\u5546\u8054\u7CFB\u65B9\u5F0F\uFF1A");
				lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_3.setBounds(19, 85, 120, 30);
				panel2.add(lblNewLabel_3);
				
				
				
				

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
		        
				
				
				
				HashSet set1=new HashSet();
				tableValueV = new Vector<Vector<String>>();
				try {
		            Connection con = DriverManager.getConnection(conURL,Test.mysqlname, Test.mysqlpassword);  // 连接数据库

		            Statement s = con.createStatement();  // Statement类用来提交SQL语句

		            ResultSet rs = s.executeQuery("select * from sponsor;");  // 提交查询，返回的表格保存在rs中

		            while(rs.next()) {  // ResultSet指针指向下一个“行”
		         
		            	if(set1.contains(rs.getString("lei")+rs.getString("name")+rs.getString("tel"))==false){
		            		Vector<String> rowV = new Vector<String>();
		        			rowV.add(rs.getString("lei"));
		        			rowV.add(rs.getString("name"));
		        			rowV.add(rs.getString("tel"));
		        			tableValueV.add(rowV);
		        			set1.add(rs.getString("lei")+rs.getString("name")+rs.getString("tel"));
		            	}
		            	
		            	
		            	
		            }
					
		            s.close();     // 释放Statement对象
		            con.close();   // 关闭到MySQL服务器的连接
		        }
		        catch(SQLException sql_e) {     // 都是SQLExceptionss
		            System.out.println(sql_e);
		        }
				
				
				Iterator it=Main.leiset.iterator();
				System.out.println(Main.leiset.size()+"sponsor");
				while(it.hasNext()){
					String s=it.next().toString();
					add_comboBox.addItem(s);
					modify_comboBox_1.addItem(s);
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
				scrollPane1.setBounds(110, 61, 438, 250);
				//table.setBounds(0, 0, 438, 250);
				//add(table);
				TableColumnModel   cm   =   table.getColumnModel(); 
				TableColumn   column  = cm.getColumn(0);//得到第i个列对象   
				  column.setPreferredWidth(140);//将此列的首选宽度设置为 preferredWidth。
				  TableColumn   column1  = cm.getColumn(1);//得到第i个列对象   
				  column1.setPreferredWidth(140);//将此列的首选宽度设置为 preferredWidth。
				  TableColumn   column2  = cm.getColumn(2);//得到第i个列对象   
				  column2.setPreferredWidth(140);
				  DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();    
				  r.setHorizontalAlignment(JLabel.CENTER);
				  table.setDefaultRenderer(Object.class, r);
				
				JButton button_1 = new JButton("\u6DFB\u52A0");
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(panel.isVisible()==false)panel.setVisible(true);
						else panel.setVisible(false);
						panel1.setVisible(false);
						panel2.setVisible(false);
					}
				});
				button_1.setFont(new Font("宋体", Font.PLAIN, 15));
				button_1.setBounds(197, 321, 106, 27);
				add(button_1);
				
				JButton button = new JButton("\u786E\u5B9A");//添加
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String a=(String) add_comboBox.getSelectedItem(),b=add_textField.getText(),c=add_textField_1.getText();
							//txtOut.append(a+"      "+b+"\n");
							if(set1.contains(a+b+c)==false){
								set1.add(a+b+c);
								try {//插入
						            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

						            Statement s = con.createStatement();  // Statement类用来提交SQL语句

						            String insert = "insert into sponsor(lei,name,tel) values('"+a+"','"+b+"','"+c+"')";  
									s.executeUpdate(insert);
									Vector<String> rowV = new Vector<String>();
					    			rowV.add(a);
					    			rowV.add(b);
					    			rowV.add(c);
					    			tableValueV.add(rowV);
					    			tableModel.setDataVector(tableValueV,columnNameV); 
					    			int  rowCount = table.getRowCount();   
					    			table.getSelectionModel().setSelectionInterval(rowCount-1 , rowCount- 1 );   
					    			Rectangle rect = table.getCellRect(rowCount-1 ,  0 ,  true );
					    			table.scrollRectToVisible(rect);  
						            s.close();     // 释放Statement对象
						               // 关闭到MySQL服务器的连接
						            TableColumnModel   cm   =   table.getColumnModel(); 
						    		TableColumn   column  = cm.getColumn(0);//得到第i个列对象   
						    		  column.setPreferredWidth(140);//将此列的首选宽度设置为 preferredWidth。
						    		  TableColumn   column1  = cm.getColumn(1);//得到第i个列对象   
						    		  column1.setPreferredWidth(140);//将此列的首选宽度设置为 preferredWidth。
						    		  TableColumn   column2  = cm.getColumn(2);
						    		  column2.setPreferredWidth(140);
						    		  
						    		  Statement s2 = con.createStatement();  // Statement类用来提交SQL语句
						    		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
						        		//System.out.println("insert into news(time,news,limit) values('"+df.format(new Date())+"','"+Name+"登入系统"+"','"+limite+"')");
						        		String insert1 = "insert into news(time,news,limite) values('"+df.format(new Date())+"','"+Testmysql.limite+Testmysql.Name+"添加供应商"+a+":"+b+"成功"+"','"+Testmysql.limite+"')";  
						        		s2.executeUpdate(insert1);
						        			
						                  s2.close();     // 释放Statement对象
						                  con.close();
						    		  
						        }
						        catch(SQLException sql_e) {     // 都是SQLExceptionss
						            System.out.println(sql_e);
						        }
							}
						
				        
					}
				});
				button.setBounds(89, 138, 93, 23);
				panel.add(button);
				
				JLabel label_1 = new JLabel("\u4F9B\u5E94\u5546\u8054\u7CFB\u65B9\u5F0F\uFF1A");
				label_1.setFont(new Font("宋体", Font.PLAIN, 15));
				label_1.setBounds(19, 85, 120, 30);
				panel.add(label_1);
				
				
				
				table.addMouseListener(new MouseListener(){

					
					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						int selectedRow = table.getSelectedRow();//获得选中行的索引
						if(selectedRow!= -1)   //是否存在选中行
					    {
					        Object oa = tableModel.getValueAt(selectedRow, 0);
					        Object ob = tableModel.getValueAt(selectedRow, 1);
					        Object oc = tableModel.getValueAt(selectedRow, 2);
					       /* modify_comboBox_1.setText(oa.toString());
					        modify_comboBox_1*/
					        modify_comboBox_1.setSelectedItem(oa.toString());
					        modify_textField.setText(ob.toString());
					        modify_textField_1.setText(oc.toString());
					    }
					    else{
					    	modify_textField_1.setText("");  //给文本框赋值
					        modify_textField.setText("");
					    }
					}

					private void setText(String string) {
						// TODO Auto-generated method stub
						
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
				
			    
			    
				JButton btnNewButton = new JButton("\u4FEE\u6539");//修改
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
				btnNewButton.setBounds(337, 321, 106, 27);
				add(btnNewButton);
				
				JButton button_2 = new JButton("\u5220\u9664");
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Object [] options ={"确定","取消"};
						int flag=JOptionPane.showOptionDialog(Test.zhu, "确定删除该供应商信息？","删除",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
						System.out.println(flag+"");
						if(flag==0){
							int selectedRow = table.getSelectedRow();//获得选中行的索引
							int rowcount=table.getRowCount();
						    if(selectedRow!=-1&&!set1.isEmpty()&&selectedRow!=rowcount)  //存在选中行
						    {
						    	Object oa = tableModel.getValueAt(selectedRow, 0);
							     Object ob = tableModel.getValueAt(selectedRow, 1);
							     Object oc = tableModel.getValueAt(selectedRow, 2);
							     set1.remove(oa.toString()+ob.toString());
						    	tableModel.removeRow(selectedRow);  //删除行
						    	
						    	table.getSelectionModel().setSelectionInterval(selectedRow , selectedRow );   
				    			Rectangle rect = table.getCellRect(selectedRow ,  0 ,  true );
				    			table.scrollRectToVisible(rect);  
						    	 try {
						             Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

						             Statement s = con.createStatement();  // Statement类用来提交
						             
						 			String delete = "Delete From sponsor Where lei='"+oa.toString()+"'and name='"+ob.toString()+"'and tel='"+oc.toString()+"'";
						 			
						 			s.executeUpdate(delete);
						 			 Statement s2 = con.createStatement();  // Statement类用来提交SQL语句
						    		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
						        		//System.out.println("insert into news(time,news,limit) values('"+df.format(new Date())+"','"+Name+"登入系统"+"','"+limite+"')");
						        		String insert1 = "insert into news(time,news,limite) values('"+df.format(new Date())+"','"+Testmysql.limite+Testmysql.Name+"删除供应商"+oa.toString()+":"+ob.toString()+"成功"+"','"+Testmysql.limite+"')";  
						        		s2.executeUpdate(insert1);
						        			
						                  s2.close();     // 释放Statement对象
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
				button_2.setBounds(66, 321, 106, 27);
				add(button_2);
				
				
				
				JLabel label1 = new JLabel("\u4F9B\u5E94\u5546\u79CD\u7C7B\uFF1A");
				label1.setFont(new Font("宋体", Font.PLAIN, 15));
				label1.setBounds(19, 30, 93, 15);
				panel1.add(label1);
				
				JLabel label1_2 = new JLabel("\u4F9B\u5E94\u5546\u540D\u79F0\uFF1A");
				label1_2.setFont(new Font("宋体", Font.PLAIN, 15));
				label1_2.setBounds(19, 52, 93, 30);
				panel1.add(label1_2);
				
				
				
				JButton button1 = new JButton("\u786E\u5B9A");//修改
				button1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						// TODO Auto-generated method stub
						 int selectedRow = table.getSelectedRow();//获得选中行的索引
						 
						 	String a=tableModel.getValueAt(selectedRow, 0).toString();
						    String b=tableModel.getValueAt(selectedRow, 1).toString();
						    String c=tableModel.getValueAt(selectedRow, 2).toString();
						    
						    if(selectedRow!= -1)   //是否存在选中行
						    {
						     //修改指定的值：
						    tableModel.setValueAt(modify_comboBox_1.getSelectedItem().toString(),selectedRow,0);
						     tableModel.setValueAt(modify_textField.getText(), selectedRow, 1);
						     tableModel.setValueAt(modify_textField_1.getText(), selectedRow, 2);
						     
						     //table.setValueAt(arg0, arg1, arg2)
						     
						     try {
						            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

						            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // Statement类用来提交SQL语句
						            
						            ResultSet rs = s.executeQuery("select lei,name,tel from sponsor");  // 提交查询，返回的表格保存在rs中

						            while(rs.next()) {  // ResultSet指针指向下一个“行”
						                if(rs.getString("lei").equals(a)&&rs.getString("name").equals(b)&&rs.getString("tel").equals(c)){
						                	rs.updateString("lei", modify_comboBox_1.getSelectedItem().toString());
						                	rs.updateString("name", modify_textField.getText());
						                	rs.updateString("tel", modify_textField_1.getText());
						                	rs.updateRow();
						                	
						                	 Statement s2 = con.createStatement();  // Statement类用来提交SQL语句
								    		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
								        		//System.out.println("insert into news(time,news,limit) values('"+df.format(new Date())+"','"+Name+"登入系统"+"','"+limite+"')");
								        		String insert1 = "insert into news(time,news,limite) values('"+df.format(new Date())+"','"+Testmysql.limite+Testmysql.Name+"修改供应商"+a+":"+b+"成功"+"','"+Testmysql.limite+"')";  
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
						    }
						    
					}
					
				});
				button1.setBounds(97, 139, 93, 23);
				panel1.add(button1);
				
				JLabel lblNewLabel = new JLabel("\u4F9B\u5E94\u5546\u8054\u7CFB\u65B9\u5F0F\uFF1A");
				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel.setBounds(19, 88, 120, 30);
				panel1.add(lblNewLabel);
				
				JButton button_3 = new JButton("\u67E5\u8BE2");//查询
				button_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(panel2.isVisible()==false){
							panel2.setVisible(true);
						}
						else panel2.setVisible(false);
						panel.setVisible(false);
						panel1.setVisible(false);
					}
				});
				button_3.setBounds(470, 321, 106, 27);
				add(button_3);
				
				JButton btnNewButton_1 = new JButton("\u786E\u5B9A");//确定查询
				btnNewButton_1.setBounds(89, 138, 93, 23);
				panel2.add(btnNewButton_1);
				btnNewButton_1.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String a=search_textField.getText();
						String b=search_textField_1.getText();
						String c=search_textField_2.getText();
						
						if(a.equals(""))a="any(select lei from sponsor)";
						else a="'"+a+"'";
						if(b.equals(""))b="any(select name from sponsor)";
						else b="'"+b+"'";
						if(c.equals(""))c="any(select tel from sponsor)";
						else c="'"+c+"'";
						
						int num=tableModel.getRowCount();
						while(num--!=0){tableModel.removeRow(0);}
						try {//插入
							
				            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

				            Statement s = con.createStatement();  // Statement类用来提交SQL语句

				     
				            String select="select * from sponsor where lei="+a+" and name ="+b+" and tel = "+c; 
				            ResultSet rs = s.executeQuery(select);  // 提交查询，返回的表格保存在rs中
				            
				            while(rs.next()) {  // ResultSet指针指向下一个“行”
				            	
				            	Vector<String> rowV = new Vector<String>();
				            	rowV.add(rs.getString("lei"));
				    			rowV.add(rs.getString("name"));
				    			rowV.add(rs.getString("tel"));
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
				    		  column.setPreferredWidth(140);//将此列的首选宽度设置为 preferredWidth。
				    		  TableColumn   column1  = cm.getColumn(1);//得到第i个列对象   
				    		  column1.setPreferredWidth(140);//将此列的首选宽度设置为 preferredWidth。
				    		  TableColumn   column2  = cm.getColumn(2);
				    		  column2.setPreferredWidth(140);
				    		  
				        }
				        catch(SQLException sql_e) {     // 都是SQLExceptionss
				            System.out.println(sql_e);
				        }
						
					}
					
				});
				
				JButton canel = new JButton("\u53D6\u6D88");
				canel.setBounds(220, 138, 93, 23);
				canel.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						search_textField.setText("");
						search_textField_1.setText("");
						search_textField_2.setText("");
						int num=tableModel.getRowCount();
						while(num--!=0){tableModel.removeRow(0);}
						
						try {//插入
							
				            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

				            Statement s = con.createStatement();  // Statement类用来提交SQL语句

				            ResultSet rs = s.executeQuery("select * from sponsor");  // 提交查询，返回的表格保存在rs中
				            
				            while(rs.next()) {  // ResultSet指针指向下一个“行”
				            	
				            	Vector<String> rowV = new Vector<String>();
				            	rowV.add(rs.getString("lei"));
				    			rowV.add(rs.getString("name"));
				    			rowV.add(rs.getString("tel"));
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
				    		  column.setPreferredWidth(140);//将此列的首选宽度设置为 preferredWidth。
				    		  TableColumn   column1  = cm.getColumn(1);//得到第i个列对象   
				    		  column1.setPreferredWidth(140);//将此列的首选宽度设置为 preferredWidth。
				    		  TableColumn   column2  = cm.getColumn(2);
				    		  column2.setPreferredWidth(140);
				    		  
				        }
				        catch(SQLException sql_e) {     // 都是SQLExceptionss
				            System.out.println(sql_e);
				        }
						
					}
					
				});
				panel2.add(canel);
				
				
				
				
			}
			
			
}

