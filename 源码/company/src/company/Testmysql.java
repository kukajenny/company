package company;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import jframe.Login;
import jframe.Main;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import company.Test;

public class Testmysql {
	public static String Name;
	public static String limite;
	public Testmysql(){
		Name=Login.yonghu.getText();
		limite=Login.limite.getSelectedItem().toString();
		String s2=Login.passwordField.getText();
		String s3=Login.limite.getSelectedItem().toString();
		String JDriver = "com.mysql.jdbc.Driver";  // MySQL提供的JDBC驱动，要保证它在CLASSPATH里可见

	    String conURL = "jdbc:mysql://localhost/"+Test.database;  // 本地计算机上的MySQL数据库Company的URL

	    try {
	        Class.forName(JDriver);
	    }
	    catch(ClassNotFoundException cnf_e) {  // 如果找不到驱动类
	        System.out.println("Driver Not Found: " + cnf_e);
	    }
	    try {
	        Connection con = (Connection) DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库
	        Connection con1 = (Connection) DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

	        Statement s = (Statement) con.createStatement();  // Statement类用来提交SQL语句
	        Statement s1 = (Statement) con1.createStatement();  // Statement类用来提交SQL语句

	        ResultSet rs = s.executeQuery("select * from users ");  // 提交查询，返回的表格保存在rs中
	        boolean flag=false;
	        while(rs.next()) {  // ResultSet指针指向下一个“行”
	        	if(rs.getString("name").equals(Name) && rs.getString("password").equals(s2)&&rs.getString("limite").equals(s3)){
	        		flag=true;
	        		Test.zhu=new Main();
	        		JOptionPane.showMessageDialog(Test.frame, Name+"登陆成功","登陆成功",1);
	        		Test.frame.dispose();//点击按钮时frame1销毁,new一个frame2
	        		Test.zhu.setVisible(true);

	        		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	        		//System.out.println("insert into news(time,news,limit) values('"+df.format(new Date())+"','"+Name+"登入系统"+"','"+limite+"')");
	        		String insert = "insert into news(time,news,limite) values('"+df.format(new Date())+"','"+limite+Name+"登入系统"+"','"+limite+"')";  
	        		s1.executeUpdate(insert);
	        			
	                  s1.close();     // 释放Statement对象
	                   con1.close();   // 关闭到MySQL服务器的连接
	        		break;
	        	}
	        }
	        if(!flag){
	        	JOptionPane.showMessageDialog(Test.frame, Name+s2+"用户名或密码错误！请重新输入","错误",2);
	        	Login.yonghu.setText("");
	        	Login.passwordField.setText("");
	        	return;
	        }
	        s.close();
	        con.close();
	    }
	    catch(SQLException sql_e) {     // 都是SQLException
	        System.out.println("testmyql  "+sql_e);
	    }
	    return;
	}
}
