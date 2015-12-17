package titlejpanel;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import jframe.Login;
import jframe.Main;

import javax.swing.JButton;

import company.Test;
import company.Testmysql;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Log extends JPanel {

	/**
	 * Create the panel.
	 */
	
private JTable table;
	
	DefaultTableModel tableModel;
	Vector<Vector<String>> tableValueV;
	Vector<String> columnNameV;
	
	
	public Log() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 834, 572);
		setVisible(true);
		setLayout(null);
		
		
		String JDriver = "com.mysql.jdbc.Driver";  // MySQL提供的JDBC驱动，要保证它在CLASSPATH里可见

        String conURL = "jdbc:mysql://localhost/"+Test.database;  // 本地计算机上的MySQL数据库Company的URL

        try {
            Class.forName(JDriver);
        }
        catch(ClassNotFoundException cnf_e) {  // 如果找不到驱动类
            System.out.println("Driver Not Found: " + cnf_e);
        }
        
		table = new JTable();
		table.setBounds(0, 0, 438, 250);
		JScrollPane scrollPane1=new JScrollPane();
		String[] columnNames = { "时间","内容" };
		columnNameV = new Vector<String>();
		for (int column = 0; column < columnNames.length; column++) {
			columnNameV.add(columnNames[column]);
		}
		
		tableValueV = new Vector<Vector<String>>();
		try {
            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

            Statement s = con.createStatement();  // Statement类用来提交SQL语句

            String a="";
            if(!Login.limite.getSelectedItem().equals("管理员")){
            	a="where limite != '管理员'";
            }
            ResultSet rs = s.executeQuery("select * from news "+a+" order by time DESC");  // 提交查询，返回的表格保存在rs中

            while(rs.next()) {  // ResultSet指针指向下一个“行”
            	
            		Vector<String> rowV = new Vector<String>();
        			rowV.add(rs.getString("time"));
        			rowV.add(rs.getString("news"));
        			tableValueV.add(rowV);

            }
			
            s.close();     // 释放Statement对象
            con.close();   // 关闭到MySQL服务器的连接
        }
        catch(SQLException sql_e) {     // 都是SQLExceptionss
            System.out.println(sql_e);
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
		scrollPane1.setBounds(110, 47, 633, 443);
		
		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				table.removeAll();
				tableValueV.removeAllElements();
				tableModel = new DefaultTableModel(tableValueV,
						columnNameV);
				try {
		            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

		            Statement s = con.createStatement();  // Statement类用来提交SQL语句

		           
					String delete = "Delete From news";  
					s.executeUpdate(delete);
					repaint();
		            s.close();     // 释放Statement对象
		            con.close();   // 关闭到MySQL服务器的连接
		        }
		        catch(SQLException sql_e) {     // 都是SQLException
		            System.out.println(sql_e);
		        }
			}
		});
		button.setBounds(389, 515, 93, 23);
		if(Testmysql.limite.equals("管理员"))add(button);
		//table.setBounds(0, 0, 438, 250);
		//add(table);
		TableColumnModel   cm   =   table.getColumnModel(); 
		TableColumn   column  = cm.getColumn(0);//得到第i个列对象   
		  column.setPreferredWidth(173);//将此列的首选宽度设置为 preferredWidth。
		  TableColumn   column1  = cm.getColumn(1);//得到第i个列对象   
		  column1.setPreferredWidth(440);//将此列的首选宽度设置为 preferredWidth。
		  DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();    
		  r.setHorizontalAlignment(JLabel.CENTER);
		  table.setDefaultRenderer(Object.class, r);
	}
}
