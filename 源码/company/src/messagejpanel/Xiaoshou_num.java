package messagejpanel;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import company.Test;

public class Xiaoshou_num extends JPanel {

	/**
	 * Create the panel.
	 */
	String JDriver = "com.mysql.jdbc.Driver";  // MySQL提供的JDBC驱动，要保证它在CLASSPATH里可见

    String conURL = "jdbc:mysql://localhost/"+Test.database;  // 本地计算机上的MySQL数据库Company的URL
    
	public Xiaoshou_num() {
		setBackground(Color.WHITE);
		setBounds(197, 0, 637, 570);
		setLayout(null);
		init();
	}

	public void init(){
		//设置数据源   
		DefaultPieDataset mDataset = new DefaultPieDataset();   
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		 try {
	            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

	            Statement s = con.createStatement();  // Statement类用来提交SQL语句
	            Statement s1 = con.createStatement();  // Statement类用来提交SQL语句

	            ResultSet rs = s.executeQuery("select * from goods;");  // 提交查询，返回的表格保存在rs中

	            while(rs.next()) {  // ResultSet指针指向下一个“行”
	            	ResultSet rs1 = s1.executeQuery("select * from chuku where lei='"+rs.getString("lei")+"' and name = '"+rs.getString("name")+"'");  // 提交查询，返回的表格保存在rs中
	            	int num=0;
	            	while(rs1.next()){
	            		if(rs1.getString("time").substring(0, 4).equals(df.format(new Date()))){
	            			num+=Integer.parseInt(rs1.getString("num"));
	            		}
	            	}
	            	 mDataset.setValue(rs.getString("lei")+":"+rs.getString("name"), new Double(num));   
	            }
				
	            s.close();     // 释放Statement对象
	            con.close();   // 关闭到MySQL服务器的连接
	        }
	        catch(SQLException sql_e) {     // 都是SQLException
	            System.out.println(sql_e);
	        }
	
        //建立图表  
        JFreeChart mChart = ChartFactory.createPieChart("项目进度分布", mDataset, true, true, false);  
        //设置图表标题  
        mChart.setTitle(new TextTitle("项目状态分布", new Font("黑体",Font.CENTER_BASELINE, 20)));  
        //设置Legend字体  
        mChart.getLegend().setItemFont(new Font("宋体", Font.ROMAN_BASELINE, 15));  
          
        PiePlot mPiePlot = (PiePlot)mChart.getPlot();  
        //以默认方式显示百分比  
        //mPiePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(StandardPieToolTipGenerator.DEFAULT_TOOLTIP_FORMAT));  
        // 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位  
        mPiePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));  
        // 底部图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例   
        mPiePlot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})"));  
        //设置饼图标签字体  
        mPiePlot.setLabelFont(new Font("宋体", Font.PLAIN, 15));  
        //内置对象显示图表  
        ChartPanel panel = new ChartPanel(mChart);
		panel.setVisible(true);
		panel.setBounds(0, 0, 637, 532);
		add(panel);
	}
}
