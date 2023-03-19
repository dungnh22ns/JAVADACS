package Test;

import javax.swing.UIManager;

import View.Bill;
import View.Home;
import View.Login;
import View.ManageClock;
import View.ManageCustomer;
import View.Signup;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Login();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
