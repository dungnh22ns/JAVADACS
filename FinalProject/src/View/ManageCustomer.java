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

import Controller.CustomerController;
import Database.DBConnection;
import rojeru_san.complementos.RSTableMetro;
import rojerusan.RSMaterialButtonCircle;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import rojerusan.RSMaterialButtonRectangle;

public class ManageCustomer extends JFrame {

	public JPanel contentPane;
	public JTextField txt_address;
	public JTextField txt_contact;
	public JTextField txt_registdate;
	public JTextField txt_name;
	public JTextField txt_id;
	public RSTableMetro tableMetro1;
	public JComboBox cb_tof;
	public ManageCustomer() {
		setUndecorated(true);
		this.init();
		setCustomerInfoToTable();
		setVisible(true);
	}
	public void setCustomerInfoToTable() {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select * from Customer";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String cus_Id = rs.getString("cus_id");
				String cus_Name = rs.getString("cus_name");
				String cus_Address = rs.getString("cus_address");
				String cus_Contact = rs.getString("cus_contact");
				Date rg_Date = rs.getDate("rg_date");
				String tof = rs.getString("tof");
				
				Object[] obj = {cus_Id,cus_Name,cus_Address,cus_Contact,rg_Date,tof};
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
		
		ActionListener ac = new CustomerController(this);
		MouseListener ms = new CustomerController(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel txt_type = new JPanel();
		txt_type.setBackground(new Color(100, 149, 237));
		txt_type.setBounds(0, 0, 333, 634);
		contentPane.add(txt_type);
		txt_type.setLayout(null);
		
		txt_address = new JTextField();
		txt_address.setForeground(new Color(0, 0, 0));
		txt_address.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
		txt_address.setColumns(10);
		txt_address.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txt_address.setBackground(new Color(100, 149, 237));
		txt_address.setBounds(40, 221, 230, 29);
		txt_type.add(txt_address);
		
		JLabel lblNewLabel_3 = new JLabel("Customer Address");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3.setBounds(40, 196, 230, 14);
		txt_type.add(lblNewLabel_3);
		
		txt_contact = new JTextField();
		txt_contact.setForeground(new Color(0, 0, 0));
		txt_contact.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
		txt_contact.setColumns(10);
		txt_contact.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txt_contact.setBackground(new Color(100, 149, 237));
		txt_contact.setBounds(40, 296, 230, 29);
		txt_type.add(txt_contact);
		
		JLabel lblNewLabel_3_1 = new JLabel("Customer Contact");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(40, 271, 197, 14);
		txt_type.add(lblNewLabel_3_1);
		
		txt_registdate = new JTextField();
		txt_registdate.setForeground(new Color(0, 0, 0));
		txt_registdate.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
		txt_registdate.setColumns(10);
		txt_registdate.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txt_registdate.setBackground(new Color(100, 149, 237));
		txt_registdate.setBounds(40, 372, 230, 29);
		txt_type.add(txt_registdate);
		
		JLabel lblNewLabel_3_2 = new JLabel("Registration Date");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(40, 347, 175, 14);
		txt_type.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Type Of Use");
		lblNewLabel_3_2_1.setForeground(Color.WHITE);
		lblNewLabel_3_2_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3_2_1.setBounds(40, 423, 148, 14);
		txt_type.add(lblNewLabel_3_2_1);
		
		txt_name = new JTextField();
		txt_name.setForeground(new Color(0, 0, 0));
		txt_name.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
		txt_name.setColumns(10);
		txt_name.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txt_name.setBackground(new Color(100, 149, 237));
		txt_name.setBounds(40, 156, 230, 29);
		txt_type.add(txt_name);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("Customer Name");
		lblNewLabel_3_2_2.setForeground(Color.WHITE);
		lblNewLabel_3_2_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3_2_2.setBounds(40, 131, 197, 14);
		txt_type.add(lblNewLabel_3_2_2);
		
		txt_id = new JTextField();
		txt_id.setForeground(new Color(0, 0, 0));
		txt_id.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
		txt_id.setColumns(10);
		txt_id.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txt_id.setBackground(new Color(100, 149, 237));
		txt_id.setBounds(40, 91, 230, 29);
		txt_type.add(txt_id);
		
		JLabel lblNewLabel_3_2_3 = new JLabel("Customer ID");
		lblNewLabel_3_2_3.setForeground(Color.WHITE);
		lblNewLabel_3_2_3.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3_2_3.setBounds(40, 66, 175, 14);
		txt_type.add(lblNewLabel_3_2_3);
		
		JLabel lblNewLabel_4_2_3 = new JLabel("");
		lblNewLabel_4_2_3.setIcon(new ImageIcon(ManageCustomer.class.getResource("/Icon/driver-license.png")));
		lblNewLabel_4_2_3.setBounds(6, 91, 24, 29);
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
		lblNewLabel_4_2_3_1.setIcon(new ImageIcon(ManageCustomer.class.getResource("/Icon/signature.png")));
		lblNewLabel_4_2_3_1.setBounds(6, 156, 24, 29);
		txt_type.add(lblNewLabel_4_2_3_1);
		
		JLabel lblNewLabel_4_2_3_1_1 = new JLabel("");
		lblNewLabel_4_2_3_1_1.setIcon(new ImageIcon(ManageCustomer.class.getResource("/Icon/location.png")));
		lblNewLabel_4_2_3_1_1.setBounds(6, 221, 24, 29);
		txt_type.add(lblNewLabel_4_2_3_1_1);
		
		JLabel lblNewLabel_4_2_3_1_1_1 = new JLabel("");
		lblNewLabel_4_2_3_1_1_1.setIcon(new ImageIcon(ManageCustomer.class.getResource("/Icon/phone-call.png")));
		lblNewLabel_4_2_3_1_1_1.setBounds(6, 296, 24, 29);
		txt_type.add(lblNewLabel_4_2_3_1_1_1);
		
		JLabel lblNewLabel_4_2_3_1_1_1_1 = new JLabel("");
		lblNewLabel_4_2_3_1_1_1_1.setIcon(new ImageIcon(ManageCustomer.class.getResource("/Icon/calendar.png")));
		lblNewLabel_4_2_3_1_1_1_1.setBounds(6, 372, 24, 29);
		txt_type.add(lblNewLabel_4_2_3_1_1_1_1);
		
		JLabel lblNewLabel_4_2_3_1_1_1_1_1 = new JLabel("");
		lblNewLabel_4_2_3_1_1_1_1_1.setIcon(new ImageIcon(ManageCustomer.class.getResource("/Icon/types.png")));
		lblNewLabel_4_2_3_1_1_1_1_1.setBounds(6, 448, 24, 29);
		txt_type.add(lblNewLabel_4_2_3_1_1_1_1_1);
		
		cb_tof = new JComboBox();
		cb_tof.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cb_tof.setModel(new DefaultComboBoxModel(new String[] {"Sinh Hoạt", "Kinh Doanh", "Hành Chính", "Sản Xuất"}));
		cb_tof.setBounds(40, 448, 230, 29);
		txt_type.add(cb_tof);
		
		RSMaterialButtonRectangle mtrlbtnrctnglBack = new RSMaterialButtonRectangle();
		mtrlbtnrctnglBack.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		mtrlbtnrctnglBack.setText("BACK");
		mtrlbtnrctnglBack.setIcon(new ImageIcon(ManageCustomer.class.getResource("/Icon/icons8_Rewind_48px.png")));
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
				"ID", "Name", "Address", "Contact", "Registration Date", "TypeOfUse"
			}
		));
		tableMetro1.addMouseListener(ms);
		
		JScrollPane scrollPane1 = new JScrollPane(tableMetro1);
		scrollPane1.setSize(655,548);
		scrollPane1.setLocation(0, 86);
		panel_2.add(scrollPane1);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Infomation");
		lblNewLabel_1.setIcon(new ImageIcon(ManageCustomer.class.getResource("/Icon/info.png")));
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_1.setBounds(87, 11, 502, 64);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(161, 61, 394, 3);
		panel_2.add(panel);
		
	}
}
