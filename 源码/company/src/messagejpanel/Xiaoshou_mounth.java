package messagejpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import company.Test;

public class Xiaoshou_mounth extends JPanel {

	/**
	 * Create the panel.
	 */
	String JDriver = "com.mysql.jdbc.Driver";  // MySQL提供的JDBC驱动，要保证它在CLASSPATH里可见

    String conURL = "jdbc:mysql://localhost/"+Test.database;  // 本地计算机上的MySQL数据库Company的URL
    
	public Xiaoshou_mounth() {
		setBackground(Color.WHITE);
		setBounds(197, 0, 637, 570);
		setLayout(null);
		init();
	}
	public void init(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 
		 for(int i=1;i<=12;i++){
			 dataset.addValue(0, "销售额", i+"");
		 }
		 int money=0;
		 try {
	            Connection con = DriverManager.getConnection(conURL, Test.mysqlname, Test.mysqlpassword);  // 连接数据库

	            Statement s = con.createStatement();  // Statement类用来提交SQL语句

	            ResultSet rs = s.executeQuery("select * from xiaoshou_mounth where time like '"+df.format(new Date())+"%'");  // 提交查询，返回的表格保存在rs中

	            
	            System.out.println(rs.getRow());
	            while(rs.next()) {  // ResultSet指针指向下一个“行”
	            	money+=Integer.parseInt(rs.getString("money"));
	            	String mounth=rs.getString("time").substring(5, 7);
	            	if(mounth.charAt(0)=='0')mounth=mounth.substring(1, 2);
	            	dataset.addValue(Integer.parseInt(rs.getString("money")), "销售额", mounth);
	            	System.out.println(rs.getString("time")+"haha");
	            }
				
	            s.close();     // 释放Statement对象
	            con.close();   // 关闭到MySQL服务器的连接
	        }
	        catch(SQLException sql_e) {     // 都是SQLException
	            System.out.println("xiaoshoumounth"+sql_e);
	        }
		 
		 
		
			// 添加数据
			
			JFreeChart chart = ChartFactory.createLineChart("食品公司年销售额", // 主标题的名称
					"",// X轴的标签
					"金额",// Y轴的标签
					dataset, // 图标显示的数据集合
					PlotOrientation.VERTICAL, // 图像的显示形式（水平或者垂直）
					true,// 是否显示子标题
					true,// 是否生成提示的标签
					false); // 是否生成URL链接
			// 处理图形上的乱码
			// 处理主标题的乱码
			chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
			// 处理子标题乱码
			chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));
			// 获取图表区域对象
			CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
			// 获取X轴的对象
			CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
			// 获取Y轴的对象
			NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
			// 处理X轴上的乱码
			categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
			// 处理X轴外的乱码
			categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
			// 处理Y轴上的乱码
			numberAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
			
			// 处理Y轴外的乱码
			numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
			// 处理Y轴上显示的刻度，以10作为1格
		
			// 获取绘图区域对象
			LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) categoryPlot
					.getRenderer();
			// 在图形上显示数字
			lineAndShapeRenderer
					.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			lineAndShapeRenderer.setBaseItemLabelsVisible(true);
			lineAndShapeRenderer
					.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));
			// 在图形上添加转折点（使用小矩形显示）
			Rectangle shape = new Rectangle(10, 10);
			lineAndShapeRenderer.setSeriesShape(0, shape);
			lineAndShapeRenderer.setSeriesShapesVisible(0, true);

			//在D盘目录下生成图片
			File file = new File("chart1.jpg");
			try {
				ChartUtilities.saveChartAsJPEG(file, chart, 800, 600);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 使用ChartFrame对象显示图像
			
			ChartPanel panel = new ChartPanel(chart);
			panel.setVisible(true);
			panel.setBounds(0, 0, 637, 532);
			add(panel);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
			lblNewLabel.setBounds(260, 542, 176, 28);
			lblNewLabel.setText("今年销售金额："+money+"元");
			add(lblNewLabel);
			
			int d=0,m=money;
			while(m/10!=0){d++;m/=10;}
			NumberTickUnit unit = new NumberTickUnit(Math.pow(10, d));//设置边距
			numberAxis.setTickUnit(unit);
	}

}
