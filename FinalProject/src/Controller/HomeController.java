package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.DBConnection;
import View.Home;
import View.Login;
import View.ManageCustomer;

public class HomeController implements ActionListener, MouseListener ,FocusListener{
	private Home home;

	public HomeController(Home home) {
		this.home = home;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.exit(0);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("S E A R C H")) {
			setBillDetails();
			clearTable();
			getStatus();
		}else if (action.equals("P A Y")) {
			setPay();
			clearTable();
			getStatus();
		}
	}

	public void getCustomerDetails() {
		int cus_id = Integer.parseInt(home.txt_cusid.getText());
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select cus_name,tof from customer where cus_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cus_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				home.lbl_name.setText(rs.getString("cus_name"));
				home.lbl_tof.setText(rs.getString("tof"));
				home.lbl_cusid.setText(home.txt_cusid.getText());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void getClockDetails() {
		int cus_id = Integer.parseInt(home.txt_cusid.getText());
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select * from clock where cus_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cus_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				home.lbl_month.setText(rs.getString("month_id"));
				home.lbl_oldnum.setText(rs.getString("old_num"));
				home.lbl_newnum.setText(rs.getString("new_num"));
				int old_num = Integer.parseInt(home.lbl_oldnum.getText());
				int new_num = Integer.parseInt(home.lbl_newnum.getText());
				int aoc = new_num-old_num;
				home.lbl_aoc.setText(String.valueOf(aoc));
//				Locale locale = new Locale("vi","VN");
//				NumberFormat vn = NumberFormat.getInstance(locale);
				if (home.lbl_tof.getText().equals("Sinh Hoạt")) {
					aoc*=4500;
//					String money =vn.format(aoc);
					home.lbl_money.setText(aoc+"");
				}else if (home.lbl_tof.getText().equals("Hành Chính")) {
					aoc *= 7500;
//					String money = vn.format(aoc);
					home.lbl_money.setText(aoc+"");
				}else if (home.lbl_tof.getText().equals("Sản Xuất")) {
					aoc *= 10700;
//					String money = vn.format(aoc);
					home.lbl_money.setText(aoc+"");
				}else if (home.lbl_tof.getText().equals("Kinh Doanh")) {
					aoc *= 16300;
//					String money = vn.format(aoc);
					home.lbl_money.setText(aoc+"");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setBillDetails() {
		String cus_name = home.lbl_name.getText();
		int cus_id = Integer.parseInt(home.lbl_cusid.getText());
		String tof = home.lbl_tof.getText();
		int aof = Integer.parseInt(home.lbl_aoc.getText());
		String money = home.lbl_money.getText();
		Boolean status = false;
		
		try {
			Connection con = DBConnection.getConnection();
			String sql = "insert into bill(cus_name,cus_id,tof,aof,money,status) values(?,?,?,?,?,?) ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cus_name);
			ps.setInt(2, cus_id);
			ps.setString(3, tof);
			ps.setInt(4, aof);
			ps.setString(5, money);
			ps.setBoolean(6, status);
			int updatedRowCount = ps.executeUpdate();
			if (updatedRowCount > 0) {
			} else {
				JOptionPane.showMessageDialog(home, "Failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setPay() {
		int cus_id = Integer.parseInt(home.txt_cusid.getText());
		boolean status = true;
		try {
			Connection con = DBConnection.getConnection();
			String sql ="update bill set status = ? where cus_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBoolean(1, status);
			ps.setInt(2, cus_id);
			int updatedRowCount = ps.executeUpdate();
			if (updatedRowCount > 0) {
				JOptionPane.showMessageDialog(home, "Success");
			} else {
				JOptionPane.showMessageDialog(home, "Failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getStatus() {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select cus_id,status from bill ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int cus_id = rs.getInt("cus_id");
				boolean status = rs.getBoolean("status");
				Object[] obj = {cus_id,status};
				DefaultTableModel model = (DefaultTableModel) home.tableMetro1.getModel();
				model.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clearTable() {
		DefaultTableModel model = (DefaultTableModel) home.tableMetro1.getModel();
		model.setRowCount(0);
	}
//	public boolean checkStatus() {
//			int cus_id = Integer.parseInt(home.txt_cusid.getText());
//			boolean isExist = false;
//			try {
//				Connection con = DBConnection.getConnection();
//				String sql = "select status from bill where cus_id = ?";
//				PreparedStatement ps = con.prepareStatement(sql);
//				ps.setInt(1, cus_id);
//				ResultSet rs = ps.executeQuery();
//				if (rs.next()) {
//					if (isExist == rs.getBoolean("status")) {
//						isExist = false;
//					}
//				} else {
//					isExist = true;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return false;
//		}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		getCustomerDetails();
		getClockDetails();
		
	}

}
