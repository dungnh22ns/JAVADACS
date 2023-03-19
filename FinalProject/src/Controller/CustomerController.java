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
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.xdevapi.Table;

import Database.DBConnection;
import View.ManageCustomer;

public class CustomerController implements ActionListener,MouseListener{
	private ManageCustomer manageCustomer;
	public CustomerController(ManageCustomer manageCustomer) {
		this.manageCustomer = manageCustomer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("ADD")) {
			if (addCustomer() == true) {
				JOptionPane.showMessageDialog(manageCustomer, "Customer Added");
				clearTable();
				setCustomerInfoToTable();
			} else {
				JOptionPane.showMessageDialog(manageCustomer, "Customer Addition Failed");
			}
		}else if (action.equals("UPDATE")) {
			if (updateCustomer() == true) {
				JOptionPane.showMessageDialog(manageCustomer, "Customer Updated");
				clearTable();
				setCustomerInfoToTable();
			} else {
				JOptionPane.showMessageDialog(manageCustomer, "Customer Updation Failed");
			} 
		}else if (action.equals("DELETE")) {
			if (deleteCustomer() == true) {
				JOptionPane.showMessageDialog(manageCustomer, "Customer Deleted");
				clearTable();
				setCustomerInfoToTable();
			} else {
				JOptionPane.showMessageDialog(manageCustomer, "Customer Deletion Failed");
			} 
		}
		if (action.equals("BACK")) {
			manageCustomer.dispose();
		}
		
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
				DefaultTableModel model = (DefaultTableModel) manageCustomer.tableMetro1.getModel();
				model.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean addCustomer() {
		int cus_Id = Integer.parseInt(manageCustomer.txt_id.getText());
		String cus_Name = manageCustomer.txt_name.getText();
		String cus_Address = manageCustomer.txt_address.getText();
		String cus_Contact = manageCustomer.txt_contact.getText();
		Date rgDate = Date.valueOf(manageCustomer.txt_registdate.getText());
		String tof = manageCustomer.cb_tof.getSelectedItem().toString();
		boolean isAdd = false;
		
		try {
			Connection con = DBConnection.getConnection();
			String sql = "insert into customer values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cus_Id);
			ps.setString(2, cus_Name);
			ps.setString(3, cus_Address);
			ps.setString(4, cus_Contact);
			ps.setDate(5, rgDate);
			ps.setString(6, tof);
			
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
		DefaultTableModel model = (DefaultTableModel) manageCustomer.tableMetro1.getModel();
		model.setRowCount(0);
	}
	public boolean updateCustomer() {
		int cus_Id = Integer.parseInt(manageCustomer.txt_id.getText());
		String cus_Name = manageCustomer.txt_name.getText();
		String cus_Address = manageCustomer.txt_address.getText();
		String cus_Contact = manageCustomer.txt_contact.getText();
		Date rgDate = Date.valueOf(manageCustomer.txt_registdate.getText());
		String tof = manageCustomer.cb_tof.getSelectedItem().toString();
		boolean isUpdate = false;
		
		try {
			Connection con = DBConnection.getConnection();
			String sql = "update customer set cus_name = ?, cus_address = ?,cus_contact = ? , rg_date = ?,tof = ? where cus_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cus_Name);
			ps.setString(2, cus_Address);
			ps.setString(3, cus_Contact);
			ps.setDate(4, rgDate);
			ps.setString(5, tof);
			ps.setInt(6, cus_Id);
			
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
		int cus_Id = Integer.parseInt(manageCustomer.txt_id.getText());
		try {
			Connection con = DBConnection.getConnection();
			String sql = "delete from customer where cus_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cus_Id);
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
		int rowNo = manageCustomer.tableMetro1.getSelectedRow();
		TableModel model = manageCustomer.tableMetro1.getModel();
		
		manageCustomer.txt_id.setText(model.getValueAt(rowNo, 0).toString());
		manageCustomer.txt_name.setText(model.getValueAt(rowNo, 1).toString());
		manageCustomer.txt_address.setText(model.getValueAt(rowNo, 2).toString());
		manageCustomer.txt_contact.setText(model.getValueAt(rowNo, 3).toString());
		manageCustomer.txt_registdate.setText(model.getValueAt(rowNo, 4).toString());
		manageCustomer.cb_tof.setSelectedItem(model.getValueAt(rowNo, 5).toString());

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
