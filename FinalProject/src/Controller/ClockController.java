package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.xdevapi.Table;

import Database.DBConnection;
import View.ManageClock;
import View.ManageCustomer;

public class ClockController implements ActionListener,MouseListener{
	private ManageClock manageClock;

	public ClockController(ManageClock manageClock) {
		this.manageClock = manageClock;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("ADD")) {
			if (addCustomer() == true) {
				JOptionPane.showMessageDialog(manageClock, "Clock Added");
				clearTable();
				setCustomerInfoToTable();
			} else {
				JOptionPane.showMessageDialog(manageClock, "Clock Addition Failed");
			} 
		}else if (action.equals("UPDATE")) {
			if (updateCustomer() == true) {
				JOptionPane.showMessageDialog(manageClock, "Clock Updated");
				clearTable();
				setCustomerInfoToTable();
			} else {
				JOptionPane.showMessageDialog(manageClock, "Clock Updation Failed");
			} 
		}else if (action.equals("DELETE")) {
			if (deleteCustomer() == true) {
				JOptionPane.showMessageDialog(manageClock, "Clock Deleted");
				clearTable();
				setCustomerInfoToTable();
			} else {
				JOptionPane.showMessageDialog(manageClock, "Clock Deletion Failed");
			} 
		}
		if (action.equals("BACK")) {
			manageClock.dispose();
		}
		
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
				DefaultTableModel model = (DefaultTableModel) manageClock.tableMetro1.getModel();
				model.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean addCustomer() {
		int cus_id = Integer.parseInt(manageClock.txt_clockId.getText());
		String month = manageClock.txt_month.getText();
		int old_num = Integer.parseInt(manageClock.txt_old.getText());
		int new_num = Integer.parseInt(manageClock.txt_new.getText());
		boolean isAdd = false;
		
		try {
			Connection con = DBConnection.getConnection();
			String sql = "insert into clock values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cus_id);
			ps.setString(2, month);
			ps.setInt(3, old_num);
			ps.setInt(4, new_num);
			
			int rowCount = ps.executeUpdate();
			if (rowCount > 0) {
				isAdd = true;
			}else {
				isAdd = false;
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAdd;
	}
	public void clearTable() {
		DefaultTableModel model = (DefaultTableModel) manageClock.tableMetro1.getModel();
		model.setRowCount(0);
	}
	public boolean updateCustomer() {
		int cus_id = Integer.parseInt(manageClock.txt_clockId.getText());
		String month = manageClock.txt_month.getText();
		int old_num = Integer.parseInt(manageClock.txt_old.getText());
		int new_num = Integer.parseInt(manageClock.txt_new.getText());
		boolean isUpdate = false;
		
		try {
			Connection con = DBConnection.getConnection();
			String sql = "update clock set month_id = ?, old_num = ?, new_num = ? where cus_id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,month);
			ps.setInt(2, old_num);
			ps.setInt(3, new_num);
			ps.setInt(4, cus_id);

			
			int rowCount = ps.executeUpdate();
			if (rowCount > 0) {
				isUpdate = true;
			}else {
				isUpdate = false;
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdate;
	}
	public boolean deleteCustomer() {
		boolean isDelete = false;
		int cus_id = Integer.parseInt(manageClock.txt_clockId.getText());
		try {
			Connection con = DBConnection.getConnection();
			String sql = "delete from clock where cus_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cus_id);
			int rowCount = ps.executeUpdate();
			if (rowCount > 0 ) {
				isDelete = true;
			}else {
				isDelete = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDelete;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int rowNo = manageClock.tableMetro1.getSelectedRow();
		TableModel model = manageClock.tableMetro1.getModel();
		
		manageClock.txt_clockId.setText(model.getValueAt(rowNo, 0).toString());
		manageClock.txt_month.setText(model.getValueAt(rowNo, 1).toString());
		manageClock.txt_old.setText(model.getValueAt(rowNo, 2).toString());
		manageClock.txt_new.setText(model.getValueAt(rowNo, 3).toString());

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
	
	

}
