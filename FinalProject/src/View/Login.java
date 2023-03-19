package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Controller.LoginController;
import Controller.SignupController;
import rojerusan.RSMaterialButtonCircle;
import javax.swing.JPasswordField;

public class Login extends JFrame {
	private JPanel contentPane;
	public JTextField txt_username;
	public JPasswordField txt_password;

	public Login() {
		this.init();
		setUndecorated(true);
		this.setVisible(true);
	}

	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 459);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener ac = new LoginController(this);
		FocusListener fc = new LoginController(this);
		MouseListener ms = new LoginController(this);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel.setBounds(0, 0, 431, 461);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome To");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		lblNewLabel.setBounds(156, 11, 122, 48);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 250, 205));
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Icon/watercompany.png")));
		lblNewLabel_1.setBounds(74, 92, 276, 315);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("D A W A C O");
		lblNewLabel_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(255, 140, 0));
		lblNewLabel_2.setBounds(147, 57, 142, 29);
		panel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 3, 1, (Color) new Color(255, 255, 255)));
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(430, 0, 314, 461);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblSignupPage_1 = new JLabel("Login Page");
		lblSignupPage_1.setBounds(99, 11, 118, 23);
		lblSignupPage_1.setForeground(Color.WHITE);
		lblSignupPage_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		panel_1.add(lblSignupPage_1);

		JLabel lblSignupPage = new JLabel("Welcome , Login To your Account");
		lblSignupPage.setBounds(32, 37, 272, 23);
		lblSignupPage.setForeground(new Color(255, 255, 255));
		lblSignupPage.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		panel_1.add(lblSignupPage);

		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3.setBounds(74, 131, 96, 14);
		panel_1.add(lblNewLabel_3);

		txt_username = new JTextField();
		txt_username.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		txt_username.setText("Enter Username ....");
		txt_username.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txt_username.setBackground(new Color(100, 149, 237));
		txt_username.setForeground(Color.GRAY);
		txt_username.setBounds(74, 156, 230, 29);
		txt_username.addFocusListener(fc);
		panel_1.add(txt_username);
		txt_username.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/Icon/icons8_Account_50px.png")));
		lblNewLabel_4.setBounds(10, 142, 50, 43);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(74, 209, 96, 14);
		panel_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(Login.class.getResource("/Icon/icons8_Secure_50px.png")));
		lblNewLabel_4_1.setBounds(10, 217, 50, 46);
		panel_1.add(lblNewLabel_4_1);

		RSMaterialButtonCircle button_signup = new RSMaterialButtonCircle();
		button_signup.setFont(new Font("Cambria", Font.BOLD, 17));
		button_signup.setText("SIGNUP");
		button_signup.setBackground(new Color(220, 20, 60));
		button_signup.setBounds(57, 356, 200, 56);
		button_signup.addActionListener(ac);
		panel_1.add(button_signup);

		RSMaterialButtonCircle button_login = new RSMaterialButtonCircle();
		button_login.setFont(new Font("Cambria", Font.BOLD, 17));
		button_login.setText("LOGIN");
		button_login.setBackground(new Color(65, 105, 225));
		button_login.setBounds(57, 292, 200, 56);
		button_login.addFocusListener(fc);
		button_login.addActionListener(ac);
		panel_1.add(button_login);
		
		JLabel lable_exit = new JLabel("X");
		lable_exit.setForeground(new Color(255, 255, 255));
		lable_exit.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lable_exit.setBounds(291, 11, 13, 14);
		lable_exit.addMouseListener(ms);
		panel_1.add(lable_exit);
		
		txt_password = new JPasswordField();
		txt_password.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		txt_password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txt_password.setBackground(new Color(100, 149, 237));
		txt_password.setBounds(74, 234, 230, 29);
		panel_1.add(txt_password);
	}
}
