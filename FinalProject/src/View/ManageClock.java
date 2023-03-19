package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ClockController;
import Controller.CustomerController;
import Database.DBConnection;
import rojeru_san.complementos.RSTableMetro;
import rojerusan.RSMaterialButtonCircle;
import javax.swing.JScrollPane;
import java.awt.Component;
import rojerusan.RSMaterialButtonRectangle;

public class ManageClock extends JFrame {

	public JPanel contentPane;
	public JTextField txt_old;
	public JTextField txt_new;
	public JTextField txt_month;
	public JTextField txt_clockId;
	public RSTableMetro tableMetro1;
	public ManageClock() {
		setUndecorated(true);
		this.init();
		setCustomerInfoToTable();
		setVisible(true);
	}
	public void setCustomerInfoToTable() {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select * from clock";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String cus_id = rs.getString("cus_id");
				String month = rs.getString("month_id");
				int old_num = rs.getInt("old_num");
				int new_num = rs.getInt("new_num");
				Object[] obj = {cus_id,month,old_num,new_num};
				DefaultTableModel model = (DefaultTableModel) tableMetro1.getModel();
				model.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(214, 66, 986, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		MouseListener ms = new ClockController(this);
		ActionListener ac = new ClockController(this);
		
		JPanel txt_type = new JPanel();
		txt_type.setBackground(new Color(100, 149, 237));
		txt_type.setBounds(0, 0, 333, 634);
		contentPane.add(txt_type);
		txt_type.setLayout(null);
		
		txt_old = new JTextField();
		txt_old.setForeground(new Color(0, 0, 0));
		txt_old.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
		txt_old.setColumns(10);
		txt_old.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txt_old.setBackground(new Color(100, 149, 237));
		txt_old.setBounds(57, 333, 230, 29);
		txt_type.add(txt_old);
		
		JLabel lblNewLabel_3 = new JLabel("Old Number");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3.setBounds(57, 308, 230, 14);
		txt_type.add(lblNewLabel_3);
		
		txt_new = new JTextField();
		txt_new.setForeground(new Color(0, 0, 0));
		txt_new.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
		txt_new.setColumns(10);
		txt_new.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txt_new.setBackground(new Color(100, 149, 237));
		txt_new.setBounds(57, 408, 230, 29);
		txt_type.add(txt_new);
		
		JLabel lblNewLabel_3_1 = new JLabel("New Number");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(57, 383, 197, 14);
		txt_type.add(lblNewLabel_3_1);
		
		txt_month = new JTextField();
		txt_month.setForeground(new Color(0, 0, 0));
		txt_month.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
		txt_month.setColumns(10);
		txt_month.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txt_month.setBackground(new Color(100, 149, 237));
		txt_month.setBounds(57, 268, 230, 29);
		txt_type.add(txt_month);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("Month");
		lblNewLabel_3_2_2.setForeground(Color.WHITE);
		lblNewLabel_3_2_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3_2_2.setBounds(57, 243, 197, 14);
		txt_type.add(lblNewLabel_3_2_2);
		
		txt_clockId = new JTextField();
		txt_clockId.setForeground(new Color(0, 0, 0));
		txt_clockId.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
		txt_clockId.setColumns(10);
		txt_clockId.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txt_clockId.setBackground(new Color(100, 149, 237));
		txt_clockId.setBounds(57, 203, 230, 29);
		txt_type.add(txt_clockId);
		
		JLabel clock_id = new JLabel("Customer_ID");
		clock_id.setForeground(Color.WHITE);
		clock_id.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		clock_id.setBounds(57, 178, 175, 14);
		txt_type.add(clock_id);
		
		JLabel lblNewLabel_4_2_3 = new JLabel("");
		lblNewLabel_4_2_3.setIcon(new ImageIcon(ManageCustomer.class.getResource("/Icon/driver-license.png")));
		lblNewLabel_4_2_3.setBounds(23, 203, 24, 29);
		txt_type.add(lblNewLabel_4_2_3);
		
		RSMaterialButtonCircle button_signup = new RSMaterialButtonCircle();
		button_signup.setText("ADD");
		button_signup.setFont(new Font("Cambria", Font.BOLD, 17));
		button_signup.setBackground(new Color(220, 20, 60));
		button_signup.setBounds(0, 496, 88, 61);
		button_signup.addActionListener(ac);
		txt_type.add(button_signup);
		
		RSMaterialButtonCircle button_signup_1 = new RSMaterialButtonCircle();
		button_signup_1.setText("UPDATE");
		button_signup_1.setFont(new Font("Cambria", Font.BOLD, 17));
		button_signup_1.setBackground(new Color(220, 20, 60));
		button_signup_1.setBounds(235, 496, 88, 61);
		button_signup_1.addActionListener(ac);
		txt_type.add(button_signup_1);
		
		RSMaterialButtonCircle button_signup_1_1 = new RSMaterialButtonCircle();
		button_signup_1_1.setText("DELETE");
		button_signup_1_1.setFont(new Font("Cambria", Font.BOLD, 17));
		button_signup_1_1.setBackground(new Color(220, 20, 60));
		button_signup_1_1.setBounds(119, 496, 88, 61);
		button_signup_1_1.addActionListener(ac);
		txt_type.add(button_signup_1_1);
		
		JLabel lblNewLabel_4_2_3_1 = new JLabel("");
		lblNewLabel_4_2_3_1.setIcon(new ImageIcon(ManageClock.class.getResource("/Icon/calendar.png")));
		lblNewLabel_4_2_3_1.setBounds(23, 268, 24, 29);
		txt_type.add(lblNewLabel_4_2_3_1);
		
		JLabel lblNewLabel_4_2_3_1_1 = new JLabel("");
		lblNewLabel_4_2_3_1_1.setIcon(new ImageIcon(ManageClock.class.getResource("/Icon/number-blocks.png")));
		lblNewLabel_4_2_3_1_1.setBounds(23, 333, 24, 29);
		txt_type.add(lblNewLabel_4_2_3_1_1);
		
		JLabel lblNewLabel_4_2_3_1_1_1 = new JLabel("");
		lblNewLabel_4_2_3_1_1_1.setIcon(new ImageIcon(ManageClock.class.getResource("/Icon/number-blocks.png")));
		lblNewLabel_4_2_3_1_1_1.setBounds(23, 408, 24, 29);
		txt_type.add(lblNewLabel_4_2_3_1_1_1);
		
		RSMaterialButtonRectangle mtrlbtnrctnglBack = new RSMaterialButtonRectangle();
		mtrlbtnrctnglBack.setText("BACK");
		mtrlbtnrctnglBack.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		mtrlbtnrctnglBack.setBounds(0, 0, 68, 45);
		mtrlbtnrctnglBack.addActionListener(ac);
		txt_type.add(mtrlbtnrctnglBack);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(331, 0, 655, 634);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		tableMetro1 = new RSTableMetro();
		tableMetro1.setFuenteHead(new Font("Tahoma", Font.BOLD, 15));
		tableMetro1.setColorSelBackgound(new Color(211, 211, 211));
		tableMetro1.setColorSelForeground(new Color(0, 0, 0));
		tableMetro1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "Month", "Old number", "New number"
			}
		));
		tableMetro1.addMouseListener(ms);
		
		JScrollPane scrollPane1 = new JScrollPane(tableMetro1);
		scrollPane1.setSize(655,548);
		scrollPane1.setLocation(0, 86);
		panel_2.add(scrollPane1);
		
		JLabel lblNewLabel_1 = new JLabel("Clock Infomation");
		lblNewLabel_1.setIcon(new ImageIcon(ManageCustomer.class.getResource("/Icon/info.png")));
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_1.setBounds(111, 11, 412, 64);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(181, 59, 320, 3);
		panel_2.add(panel);
		
	}
}
