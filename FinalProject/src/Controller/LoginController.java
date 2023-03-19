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
import View.Home;
import View.Login;
import View.Signup;

public class LoginController implements ActionListener,FocusListener,MouseListener {
	private Login login;

	public LoginController(Login login) {
		this.login = login;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if (action.equals("LOGIN")) {
			if (validateLogin() == true) {
				login();
			} 
		}else if (action.equals("SIGNUP")) {
			Signup signup = new Signup();
			signup.setVisible(true);
			login.dispose();
		}
	}
	public boolean validateLogin() {
		String name = login.txt_username.getText();
		String pwd = login.txt_password.getText();
		
		if (name.equals("")) {
			JOptionPane.showMessageDialog(login, "Please enter username");
			return false;
		}
		if (pwd.equals("")) {
			JOptionPane.showMessageDialog(login, "Please enter password");
			return false;
		}
		return true;
	}
	public void login() {
		String name = login.txt_username.getText();
		String pwd = login.txt_password.getText();
		
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select * from users where name = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(login, "Login success");
				Home home = new Home();
				home.setVisible(true);
				login.dispose();
			}else {
				JOptionPane.showMessageDialog(login, "Incorrect username or password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (this.login.txt_username.getForeground() == Color.GRAY) {
			this.login.txt_username.setText("");
			this.login.txt_username.setForeground(null);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (this.login.txt_username.getText().isEmpty()) {
			this.login.txt_username.setText("Enter Username ....");
			this.login.txt_username.setForeground(Color.GRAY);
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
	

}
