package messagejpanel;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.SwingConstants;

import company.Test;
import company.Testmysql;

public class Kucun_Sykucun extends JPanel {
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTable table;
	public int num=0;
	
	public Kucun_Sykucun() {
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
		
		
		JPanel panel1= new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(113, 385, 450, 159);
		add(panel1);
		panel1.setLayout(null);
		panel1.setVisible(false);
		panel1.setBorder (BorderFactory.createTitledBorder ("修改商品"));
		
		
		
		JLabel label1 = new JLabel("\u79CD\u7C7B\u540D\u79F0\uFF1A");
		label1.setFont(new Font("宋体", Font.PLAIN, 15));
		label1.setBounds(19, 30, 75, 15);
		panel1.add(label1);
		
		JLabel label1_2 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label1_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label1_2.setBounds(19, 52, 75, 30);
		panel1.add(label1_2);
		
		textField1 = new JTextField();
		textField1.setBounds(109, 27, 149, 21);
		panel1.add(textField1);
		textField1.setColumns(10);
		textField1.enable(false);
		
		textField2 = new JTextField();
		textField2.setBounds(109, 57, 149, 21);
		panel1.add(textField2);
		textField2.setColumns(10);
		textField2.enable(false);
		
		textField3 = new JTextField();
		textField3.setBounds(109, 88, 149, 21);
		panel1.add(textField3);
		textField3.setColumns(10);
		
		table = new JTable();
		table.setBounds(0, 0, 438, 250);
		JScrollPane scrollPane1=new JScrollPane();
		String[] columnNames = { "商品类型","商品名称","数量"};
		Vector<String> columnNameV = new Vector<String>();
		for (int column = 0; column < columnNames.length; column++) {
			columnNameV.add(columnNames[column]);
		}
		
		
		
		Vector<Vector<String>> tableValueV = new Vector<Vector<String>>();
		try {
            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

            Statement s = con.createStatement();  // Statement类用来提交SQL语句

            ResultSet rs = s.executeQuery("select * from goods;");  // 提交查询，返回的表格保存在rs中
            
            while(rs.next()) {  // ResultSet指针指向下一个“行”
            		Vector<String> rowV = new Vector<String>();
            		if(!rs.getString("num").equals("0")){
            			rowV.add(rs.getString("lei"));
            			rowV.add(rs.getString("name"));
            			rowV.add(rs.getString("num"));
            			tableValueV.add(rowV);
            			num++;
            		}
        			
            }
			
            s.close();     // 释放Statement对象
            con.close();   // 关闭到MySQL服务器的连接
        }
        catch(SQLException sql_e) {     // 都是SQLExceptionss
            System.out.println(sql_e);
        }
		
	
		
		final DefaultTableModel tableModel = new DefaultTableModel(tableValueV,
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
		scrollPane1.setBounds(110, 56, 438, 250);
		//table.setBounds(0, 0, 438, 250);
		//add(table);
		TableColumnModel   cm   =   table.getColumnModel(); 
		TableColumn   column  = cm.getColumn(0);//得到第i个列对象   
		  column.setPreferredWidth(140);//将此列的首选宽度设置为 preferredWidth。
		  TableColumn   column1  = cm.getColumn(1);//得到第i个列对象   
		  column1.setPreferredWidth(140);//将此列的首选宽度设置为 preferredWidth。
		  TableColumn   column2  = cm.getColumn(2);//得到第i个列对象   
		  column2.setPreferredWidth(140);//将此列的首选宽度设置为 preferredWidth。
		  DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();    
		  r.setHorizontalAlignment(JLabel.CENTER);
		  table.setDefaultRenderer(Object.class, r);
		
		table.addMouseListener(new MouseListener(){

			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int selectedRow = table.getSelectedRow();//获得选中行的索引
				if(selectedRow!= -1)   //是否存在选中行
			    {
			        Object oa = tableModel.getValueAt(selectedRow, 0);
			        Object ob = tableModel.getValueAt(selectedRow, 1);
			        Object oc =tableModel.getValueAt(selectedRow, 2);
			        textField1.setText(oa.toString());  //给文本框赋值
			        textField2.setText(ob.toString());
			        textField3.setText(oc.toString());
			    }
			    else{
			    	textField1.setText("");  //给文本框赋值
			        textField2.setText("");
			        textField3.setText("");
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
			}
		});
		btnNewButton.setBounds(442, 338, 106, 27);
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
					    String c=tableModel.getValueAt(selectedRow, 2).toString();
					    
				     tableModel.setValueAt(textField1.getText(), selectedRow, 0);
				     tableModel.setValueAt(textField2.getText(), selectedRow, 1);
				     tableModel.setValueAt(textField3.getText(), selectedRow, 2);
				     try {
				            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

				            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // Statement类用来提交SQ
				            
				            ResultSet rs = s.executeQuery("select lei,name,num from goods");  // 提交查询，返回的表格保存在rs中
				            while(rs.next()) {  // ResultSet指针指向下一个“行”
				                if(rs.getString("lei").equals(a)&&rs.getString("name").equals(b)&&rs.getString("num").equals(c)){
				                	rs.updateString("num",textField3.getText());
				                	rs.updateRow();
				                	break;
				                }
				            }
						
						Statement s2 = con.createStatement();  // Statement类用来提交SQL语句
			    		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			        		//System.out.println("insert into news(time,news,limit) values('"+df.format(new Date())+"','"+Name+"登入系统"+"','"+limite+"')");
			        		String insert1 = "insert into news(time,news,limite) values('"+df.format(new Date())+"','"+Testmysql.limite+Testmysql.Name+"修改剩余库存"+a+":"+b+" "+c+"成功"+"','"+Testmysql.limite+"')";  
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
			
		});
		button1.setBounds(76, 126, 93, 23);
		panel1.add(button1);
		
		JLabel label = new JLabel("\u6570\u91CF\uFF1A");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(19, 83, 75, 30);
		panel1.add(label);
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object [] options ={"确定","取消"};
				int flag=JOptionPane.showOptionDialog(Test.zhu, "确定删除该供应商信息？","删除",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
				if(flag==0){
					int selectedRow = table.getSelectedRow();//获得选中行的索引
					int rowcount=table.getRowCount();
				    if(selectedRow!=-1&&selectedRow!=rowcount)  //存在选中行
				    {
				    	Object oa = tableModel.getValueAt(selectedRow, 0);
					     Object ob = tableModel.getValueAt(selectedRow, 1);
					     Object oc = tableModel.getValueAt(selectedRow, 2);
				    	tableModel.removeRow(selectedRow);  //删除行
				    	
				    		table.getSelectionModel().setSelectionInterval(selectedRow , selectedRow );   
			    			Rectangle rect = table.getCellRect(selectedRow ,  0 ,  true );
			    			table.scrollRectToVisible(rect);  
				    	
				    	 try {
				             Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

				             Statement s = con.createStatement();  // Statement类用来提交
				             
				 			String delete = "Delete From kucun Where name='"+ob.toString()+"'";
				 			
				 			Statement s2 = con.createStatement();  // Statement类用来提交SQL语句
				    		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				        		//System.out.println("insert into news(time,news,limit) values('"+df.format(new Date())+"','"+Name+"登入系统"+"','"+limite+"')");
				        		String insert1 = "insert into news(time,news,limite) values('"+df.format(new Date())+"','"+Testmysql.limite+Testmysql.Name+"删除剩余库存"+oa.toString()+":"+ob.toString()+" "+oc.toString()+"成功"+"','"+Testmysql.limite+"')";  
				        		s2.executeUpdate(insert1);
				        			
				                  s2.close();     // 释放Statement对象
				 			
				 			s.executeUpdate(delete);
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
		button_2.setBounds(113, 338, 106, 27);
		add(button_2);
	}
}
