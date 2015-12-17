package titlejpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jframe.Main;

public class Dingdan extends JPanel {

	/**
	 * Create the panel.
	 */
	public static JLabel label_2;
	public static JLabel label_3;
	public static JLabel label_4;
	
	public Dingdan() {
		setBackground(new Color(230, 230, 250));
		setBounds(0, 0, 198, 571);
		setVisible(true);
		setLayout(null);
		
		JPanel panel=new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(0,0,198,217);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{196, 0};
		gbl_panel_2.rowHeights = new int[]{68, 34, 39, 40, 36, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel_2);
		add(panel);
		
		JLabel label_1 = new JLabel("\u8BA2\u5355\u7BA1\u7406");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 0);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 0;
		panel.add(label_1, gbc_label_5);
		
		label_2 = new JLabel("  \u8D2D\u4E70\u8BA2\u5355");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel.add(label_2, gbc_label_1);
		label_2.addMouseListener( new Mouselistener(label_2));
		
		label_3 = new JLabel("  \u9500\u552E\u8BA2\u5355");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		panel.add(label_3, gbc_label_2);
		label_3.addMouseListener( new Mouselistener(label_3));
		
		label_4 = new JLabel("  \u8BA2\u5355\u67E5\u8BE2");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 3;
		panel.add(label_4, gbc_label_3);
		label_4.addMouseListener( new Mouselistener(label_4));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(29, 333, 168, 238);
		ImageIcon prince = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/picture/6.png")));
	    prince.getImage();
		Image img = prince.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT);
		prince=new ImageIcon(img);
		lblNewLabel.setIcon(prince);
		add(lblNewLabel);
	}

}
