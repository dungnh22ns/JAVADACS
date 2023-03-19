package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Database.DBConnection;
import View.Login;
import View.Signup;

public class SignupController implements ActionListener, FocusListener, MouseListener {
	private Signup signup;

	public SignupController(Signup signup) {
		this.signup = signup;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("SIGNUP")) {
			String name = signup.txt_username.getText();
			String pwd = signup.txt_password.getText();
			String email = signup.txt_email.getText();
			String contact = signup.txt_contact.getText();
			if (validateSignup() == true) {
				if (checkDuplicateUser() == false) {
					try {
						Connection con = DBConnection.getConnection();
						String sql = "insert into users(name,password,email,contact) values(?,?,?,?)";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, name);
						ps.setString(2, pwd);
						ps.setString(3, email);
						ps.setString(4, contact);
						int updatedRowCount = ps.executeUpdate();
						if (updatedRowCount > 0) {
							JOptionPane.showMessageDialog(signup, "Success");
							Login login = new Login();
							login.setVisible(true);
							signup.dispose();
						} else {
							JOptionPane.showMessageDialog(signup, "Failure");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(signup, "This username already exist");
				}

			} 
		}else if (action.equals("LOGIN")) {
			Login login = new Login();
			login.setVisible(true);
			signup.dispose();
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (this.signup.txt_username.getForeground() == Color.GRAY) {
			this.signup.txt_username.setText("");
			this.signup.txt_username.setForeground(null);
		}
		if (this.signup.txt_password.getForeground() == Color.GRAY) {
			this.signup.txt_password.setText("");
			this.signup.txt_password.setForeground(null);
		}
		if (this.signup.txt_email.getForeground() == Color.GRAY) {
			this.signup.txt_email.setText("");
			this.signup.txt_email.setForeground(null);
		}
		if (signup.txt_contact.getForeground() == Color.GRAY) {
			this.signup.txt_contact.setText("");
			this.signup.txt_contact.setForeground(null);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (this.signup.txt_username.getText().isEmpty()) {
			this.signup.txt_username.setText("Enter Username ....");
			this.signup.txt_username.setForeground(Color.GRAY);
		}
		if (this.signup.txt_password.getText().isEmpty()) {
			this.signup.txt_password.setText("Enter Password ....");
			this.signup.txt_password.setForeground(Color.GRAY);
		}
		if (this.signup.txt_email.getText().isEmpty()) {
			this.signup.txt_email.setText("Enter Email ....");
			this.signup.txt_email.setForeground(Color.GRAY);
		}
		if (this.signup.txt_contact.getText().isEmpty()) {
			this.signup.txt_contact.setText("Enter Contact ....");
			this.signup.txt_contact.setForeground(Color.GRAY);
		}
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

	public boolean validateSignup() {
		String name = signup.txt_username.getText();
		String pwd = signup.txt_password.getText();
		String email = signup.txt_email.getText();
		String contact = signup.txt_contact.getText();
		if (name.equals("")|| name.matches("^.+@.+\\..+$")) {
			JOptionPane.showMessageDialog(signup, "please enter username");
			return false;
		}
		if (pwd.equals("")) {
			JOptionPane.showMessageDialog(signup, "please enter password");
			return false;
		}
		if (email.equals("")) {
			JOptionPane.showMessageDialog(signup, "please enter email");
			return false;
		}
		if (contact.equals("")|| contact.matches("^.+@.+\\..+$")) {
			JOptionPane.showMessageDialog(signup, "please enter contact number");
			return false;
		}
		return true;
	}

	public boolean checkDuplicateUser() {
		String name = signup.txt_username.getText();
		boolean isExist = false;
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select * from users where name = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				isExist = true;
			} else {
				isExist = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isExist;
	}
}
