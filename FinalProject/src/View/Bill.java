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

public class Bill extends JFrame {
	private ManageCustomer customer;
	public JPanel contentPane;
	public RSTableMetro tableMetro1;
	public Bill() {
		setUndecorated(true);
		this.init();
		setBill();
		setVisible(true);
	}
	public void setBill() { 
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select * from Bill";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String bill_id = rs.getString("cus_id");
				String cus_name = rs.getString("cus_name");
				String cus_id = rs.getString("cus_id");
				String tof = rs.getString("tof");
				int aof = rs.getInt("aof");
				int money = rs.getInt("money");
				Object[] obj = {bill_id,cus_name,cus_id,cus_id,tof,aof,money};
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
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel txt_type = new JPanel();
		txt_type.setBackground(new Color(100, 149, 237));
		txt_type.setBounds(0, 0, 288, 634);
		contentPane.add(txt_type);
		txt_type.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(139, 0, 0));
		panel_1.setBounds(0, 0, 98, 41);
		txt_type.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BACK");
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 0, 98, 41);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(ManageCustomer.class.getResource("/Icon/icons8_Rewind_48px.png")));
		
		JLabel lblNewLabel_3 = new JLabel("Amount Of Consumption");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3.setBounds(23, 214, 230, 14);
		txt_type.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Money");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(23, 278, 197, 14);
		txt_type.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("Month");
		lblNewLabel_3_2_2.setForeground(Color.WHITE);
		lblNewLabel_3_2_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3_2_2.setBounds(23, 152, 197, 14);
		txt_type.add(lblNewLabel_3_2_2);
		
		JLabel clock_id = new JLabel("Name");
		clock_id.setForeground(Color.WHITE);
		clock_id.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		clock_id.setBounds(23, 90, 175, 14);
		txt_type.add(clock_id);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(23, 137, 255, 4);
		txt_type.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(23, 199, 255, 4);
		txt_type.add(panel_3_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(Color.WHITE);
		panel_3_2.setBounds(23, 263, 255, 4);
		txt_type.add(panel_3_2);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(Color.WHITE);
		panel_3_1_1.setBounds(23, 327, 255, 4);
		txt_type.add(panel_3_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("VNĐ");
		lblNewLabel_2.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblNewLabel_2.setBounds(246, 298, 32, 28);
		txt_type.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Kwh");
		lblNewLabel_2_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(246, 227, 32, 28);
		txt_type.add(lblNewLabel_2_1);
		
		JLabel lbl_name = new JLabel("");
		lbl_name.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		lbl_name.setBounds(23, 113, 255, 28);
		txt_type.add(lbl_name);
		
		JLabel lbl_month = new JLabel("");
		lbl_month.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		lbl_month.setBounds(23, 175, 255, 28);
		txt_type.add(lbl_month);
		
		JLabel lbl_aoc = new JLabel("");
		lbl_aoc.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		lbl_aoc.setBounds(23, 239, 255, 28);
		txt_type.add(lbl_aoc);
		
		JLabel lbl_money = new JLabel("");
		lbl_money.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		lbl_money.setBounds(23, 303, 255, 28);
		txt_type.add(lbl_money);
		
		RSMaterialButtonCircle mtrlbtncrclPay = new RSMaterialButtonCircle();
		mtrlbtncrclPay.setForeground(new Color(100, 149, 237));
		mtrlbtncrclPay.setFont(new Font("Segoe UI Symbol", Font.BOLD, 30));
		mtrlbtncrclPay.setText("Pay");
		mtrlbtncrclPay.setBackground(new Color(255, 255, 255));
		mtrlbtncrclPay.setBounds(23, 369, 255, 100);
		txt_type.add(mtrlbtncrclPay);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(287, 0, 699, 634);
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
				"Bill ID", "Name", "ID", "Month", "TypeOfUse", "Aof","Money"
			}
		));
		
		JScrollPane scrollPane1 = new JScrollPane(tableMetro1);
		scrollPane1.setSize(699,548);
		scrollPane1.setLocation(0, 86);
		panel_2.add(scrollPane1);
		
		JLabel lblNewLabel_1 = new JLabel("Bill");
		lblNewLabel_1.setIcon(new ImageIcon(ManageCustomer.class.getResource("/Icon/info.png")));
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_1.setBounds(272, 11, 163, 64);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(336, 62, 59, 2);
		panel_2.add(panel);
		
	}
}
