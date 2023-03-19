package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import rojeru_san.complementos.RSTableMetro;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import Controller.HomeController;
import Database.DBConnection;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Cursor;
import javax.swing.DropMode;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import rojerusan.RSMaterialButtonRectangleBeanInfo;
import rojerusan.RSMaterialButtonRectangle;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	public JTextField txt_cusid;
	public JLabel lbl_name;
	public JLabel lbl_tof;
	public JLabel lbl_aoc;
	public JLabel lbl_money;
	public JLabel lbl_cusid;
	public JLabel lbl_month;
	public JLabel lbl_oldnum;
	public JLabel lbl_newnum;
	public RSTableMetro tableMetro1;
	public Home() {
		this.init();
		setStatus();
		this.setVisible(true);
	}
	public void setStatus() {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "select cus_id,status from bill";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int cus_id = rs.getInt("cus_id");
				boolean status = rs.getBoolean("status");
				Object[] obj = {cus_id,status};
				DefaultTableModel model = (DefaultTableModel) tableMetro1.getModel();
				model.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		setUndecorated(true);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		MouseListener ms = new HomeController(this);
		ActionListener ac = new HomeController(this);
		FocusListener fc = new HomeController(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 1200, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(24, 11, 48, 46);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/Icon/icons8_menu_48px_1.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(82, 7, 4, 50);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Water Management System");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblNewLabel_1.setBounds(93, 11, 258, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome, Admin");
		lblNewLabel_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/Icon/male_user_50px.png")));
		lblNewLabel_2.setBounds(873, 11, 191, 46);
		panel.add(lblNewLabel_2);
		
		JLabel lbl_exit = new JLabel("X");
		lbl_exit.setForeground(new Color(255, 255, 255));
		lbl_exit.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		lbl_exit.setBounds(1162, 21, 28, 25);
		lbl_exit.addMouseListener(ms);
		panel.add(lbl_exit);
		
		JLabel lblNewLabel_1_1 = new JLabel("D A W A C O for a better life");
		lblNewLabel_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Segoe UI Symbol", Font.ITALIC, 17));
		lblNewLabel_1_1.setBounds(131, 32, 224, 25);
		panel.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 224));
		panel_2.setBounds(0, 66, 216, 634);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(165, 42, 42));
		panel_3.setBounds(0, 46, 216, 48);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel(" Home");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblNewLabel_4.setIcon(new ImageIcon(Home.class.getResource("/Icon/icons8_Home_26px_2.png")));
		lblNewLabel_4.setBounds(32, 0, 184, 48);
		panel_3.add(lblNewLabel_4);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setForeground(new Color(255, 255, 255));
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBackground(new Color(255, 165, 0));
		panel_3_1_1.setBounds(0, 137, 216, 48);
		panel_2.add(panel_3_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Features");
		lblNewLabel_4_1_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblNewLabel_4_1_1.setBounds(32, 0, 184, 48);
		panel_3_1_1.add(lblNewLabel_4_1_1);
		
		JPanel panel_3_1_1_1_1_1_1_2 = new JPanel();
		panel_3_1_1_1_1_1_1_2.setLayout(null);
		panel_3_1_1_1_1_1_1_2.setBackground(new Color(255, 255, 224));
		panel_3_1_1_1_1_1_1_2.setBounds(0, 182, 216, 48);
		panel_2.add(panel_3_1_1_1_1_1_1_2);
		
		JLabel lbl_managecustomer = new JLabel("Manage Customer");
		lbl_managecustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageCustomer customer = new ManageCustomer();
				customer.setVisible(true);
				
			}
		});
		lbl_managecustomer.setForeground(Color.BLACK);
		lbl_managecustomer.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lbl_managecustomer.setBounds(32, 0, 184, 48);
		panel_3_1_1_1_1_1_1_2.add(lbl_managecustomer);
		
		JPanel panel_3_1_1_1_1_1_1_3 = new JPanel();
		panel_3_1_1_1_1_1_1_3.setLayout(null);
		panel_3_1_1_1_1_1_1_3.setBackground(new Color(255, 255, 224));
		panel_3_1_1_1_1_1_1_3.setBounds(0, 229, 216, 48);
		panel_2.add(panel_3_1_1_1_1_1_1_3);
		
		JLabel lbl_manageclock = new JLabel("Manage Clock");
		lbl_manageclock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageClock clock = new ManageClock();
				clock.setVisible(true);
			}
		});
		lbl_manageclock.setForeground(Color.BLACK);
		lbl_manageclock.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lbl_manageclock.setBounds(32, 0, 184, 48);
		panel_3_1_1_1_1_1_1_3.add(lbl_manageclock);
		
		JPanel panel_3_1_1_1 = new JPanel();
		panel_3_1_1_1.setLayout(null);
		panel_3_1_1_1.setBackground(new Color(255, 255, 224));
		panel_3_1_1_1.setBounds(0, 91, 216, 48);
		panel_2.add(panel_3_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Home");
		lblNewLabel_4_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblNewLabel_4_1_1_1.setBounds(32, 0, 184, 48);
		panel_3_1_1_1.add(lblNewLabel_4_1_1_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(214, 66, 986, 634);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_5_4 = new JLabel("Customer Details");
		lblNewLabel_5_4.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_5_4.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblNewLabel_5_4.setBounds(10, 11, 161, 32);
		panel_4.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_4_1 = new JLabel("Clock Details");
		lblNewLabel_5_4_1.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_5_4_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblNewLabel_5_4_1.setBounds(519, 11, 161, 32);
		panel_4.add(lblNewLabel_5_4_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(100, 149, 237));
		panel_5.setBounds(10, 54, 412, 278);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Amount Of Consumption");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 150, 230, 14);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Money");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(10, 214, 197, 14);
		panel_5.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("TypeOfUse");
		lblNewLabel_3_2_2.setForeground(Color.WHITE);
		lblNewLabel_3_2_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3_2_2.setBounds(10, 88, 197, 14);
		panel_5.add(lblNewLabel_3_2_2);
		
		JLabel clock_id = new JLabel("Name");
		clock_id.setForeground(Color.WHITE);
		clock_id.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		clock_id.setBounds(10, 26, 175, 14);
		panel_5.add(clock_id);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(Color.WHITE);
		panel_3_2.setBounds(10, 73, 255, 4);
		panel_5.add(panel_3_2);
		
		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setBackground(Color.WHITE);
		panel_3_1_2.setBounds(10, 135, 255, 4);
		panel_5.add(panel_3_1_2);
		
		JPanel panel_3_2_1 = new JPanel();
		panel_3_2_1.setBackground(Color.WHITE);
		panel_3_2_1.setBounds(10, 199, 255, 4);
		panel_5.add(panel_3_2_1);
		
		JPanel panel_3_1_1_2 = new JPanel();
		panel_3_1_1_2.setBackground(Color.WHITE);
		panel_3_1_1_2.setBounds(10, 263, 255, 4);
		panel_5.add(panel_3_1_1_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("VNĐ");
		lblNewLabel_2_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(233, 234, 32, 28);
		panel_5.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Kwh");
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(233, 163, 32, 28);
		panel_5.add(lblNewLabel_2_1_1);
		
		lbl_name = new JLabel("");
		lbl_name.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		lbl_name.setBounds(10, 49, 255, 28);
		panel_5.add(lbl_name);
		
		lbl_tof = new JLabel("");
		lbl_tof.setFont(new Font("Arial", Font.PLAIN, 16));
		lbl_tof.setBounds(10, 111, 255, 28);
		panel_5.add(lbl_tof);
		
		lbl_aoc = new JLabel("");
		lbl_aoc.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		lbl_aoc.setBounds(10, 175, 255, 28);
		panel_5.add(lbl_aoc);
		
		lbl_money = new JLabel("");
		lbl_money.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_money.setBounds(10, 239, 255, 28);
		panel_5.add(lbl_money);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBackground(new Color(100, 149, 237));
		panel_5_1.setBounds(519, 54, 412, 278);
		panel_4.add(panel_5_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Old Number");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(10, 150, 230, 14);
		panel_5_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("New Number");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBounds(10, 214, 197, 14);
		panel_5_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_2_2_1 = new JLabel("Month");
		lblNewLabel_3_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_3_2_2_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblNewLabel_3_2_2_1.setBounds(10, 88, 197, 14);
		panel_5_1.add(lblNewLabel_3_2_2_1);
		
		JLabel clock_id_1 = new JLabel("Customer ID");
		clock_id_1.setForeground(Color.WHITE);
		clock_id_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		clock_id_1.setBounds(10, 26, 175, 14);
		panel_5_1.add(clock_id_1);
		
		JPanel panel_3_2_2 = new JPanel();
		panel_3_2_2.setBackground(Color.WHITE);
		panel_3_2_2.setBounds(10, 73, 255, 4);
		panel_5_1.add(panel_3_2_2);
		
		JPanel panel_3_1_2_1 = new JPanel();
		panel_3_1_2_1.setBackground(Color.WHITE);
		panel_3_1_2_1.setBounds(10, 135, 255, 4);
		panel_5_1.add(panel_3_1_2_1);
		
		JPanel panel_3_2_1_1 = new JPanel();
		panel_3_2_1_1.setBackground(Color.WHITE);
		panel_3_2_1_1.setBounds(10, 199, 255, 4);
		panel_5_1.add(panel_3_2_1_1);
		
		JPanel panel_3_1_1_2_1 = new JPanel();
		panel_3_1_1_2_1.setBackground(Color.WHITE);
		panel_3_1_1_2_1.setBounds(10, 263, 255, 4);
		panel_5_1.add(panel_3_1_1_2_1);
		
		lbl_cusid = new JLabel("");
		lbl_cusid.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		lbl_cusid.setBounds(10, 49, 255, 28);
		panel_5_1.add(lbl_cusid);
		
		lbl_month = new JLabel("");
		lbl_month.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		lbl_month.setBounds(10, 111, 255, 28);
		panel_5_1.add(lbl_month);
		
		lbl_oldnum = new JLabel("");
		lbl_oldnum.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		lbl_oldnum.setBounds(10, 175, 255, 28);
		panel_5_1.add(lbl_oldnum);
		
		lbl_newnum = new JLabel("");
		lbl_newnum.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		lbl_newnum.setBounds(10, 239, 255, 28);
		panel_5_1.add(lbl_newnum);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(100, 149, 237));
		panel_6.setBounds(10, 360, 188, 32);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		txt_cusid = new JTextField();
		txt_cusid.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
		txt_cusid.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(100, 149, 237)));
		txt_cusid.setBounds(0, 0, 188, 32);
		txt_cusid.addFocusListener(fc);
		panel_6.add(txt_cusid);
		txt_cusid.setColumns(10);
		
		JLabel clock_id_1_1 = new JLabel("Customer ID");
		clock_id_1_1.setForeground(new Color(100, 149, 237));
		clock_id_1_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		clock_id_1_1.setBounds(10, 343, 175, 14);
		panel_4.add(clock_id_1_1);
		
		RSMaterialButtonRectangle mtrlbtnrctnglSEA = new RSMaterialButtonRectangle();
		mtrlbtnrctnglSEA.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		mtrlbtnrctnglSEA.setText("P A Y");
		mtrlbtnrctnglSEA.setHorizontalTextPosition(SwingConstants.CENTER);
		mtrlbtnrctnglSEA.setIcon(new ImageIcon(Home.class.getResource("/Icon/loupe.png")));
		mtrlbtnrctnglSEA.setBounds(10, 471, 188, 70);
		mtrlbtnrctnglSEA.addActionListener(ac);
		panel_4.add(mtrlbtnrctnglSEA);
		
		RSMaterialButtonRectangle mtrlbtnrctnglSEA_1 = new RSMaterialButtonRectangle();
		mtrlbtnrctnglSEA_1.setText("S E A R C H");
		mtrlbtnrctnglSEA_1.setHorizontalTextPosition(SwingConstants.CENTER);
		mtrlbtnrctnglSEA_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		mtrlbtnrctnglSEA_1.setBounds(10, 403, 188, 70);
		mtrlbtnrctnglSEA_1.addActionListener(ac);
		panel_4.add(mtrlbtnrctnglSEA_1);
		
		tableMetro1 = new RSTableMetro();
		tableMetro1.setFuenteHead(new Font("Tahoma", Font.BOLD, 15));
		tableMetro1.setColorSelBackgound(new Color(211, 211, 211));
		tableMetro1.setColorSelForeground(new Color(0, 0, 0));
		tableMetro1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "Status"
			}
		));
		
		JScrollPane scrollPane1 = new JScrollPane(tableMetro1);
		scrollPane1.setSize(296,291);
		scrollPane1.setLocation(221, 343);
		panel_4.add(scrollPane1);
		
//		JPanel panelPiechar = new JPanel();
//		panelPiechar.setBounds(568, 167, 408, 404);
//		panelPiechar.setLayout(new BorderLayout());
//		panel_4.add(panelPiechar);
//		
//		barDataset = new DefaultPieDataset( );
//	      barDataset.setValue( "IPhone 5s" , new Double( 20 ) );  
//	      barDataset.setValue( "SamSung Grand" , new Double( 20 ) );   
//	      barDataset.setValue( "MotoG" , new Double( 40 ) );    
//	      barDataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
//	      
//	      //create chart
//	      piechart = ChartFactory.createPieChart("mobile sales",barDataset, false,true,false);//explain
//	      
//	        piePlot =(PiePlot) piechart.getPlot();
//	      
//	       //changing pie chart blocks colors
//	       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
//	        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
//	        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
//	        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
//	      
//	       
//	        piePlot.setBackgroundPaint(Color.white);
//	        
//	        //create chartPanel to display chart(graph)
//	        barChartPanel = new ChartPanel(piechart);
//	        panelPiechar.removeAll();
//	        panelPiechar.add(barChartPanel, BorderLayout.CENTER);
//	        panelPiechar.validate();
	}
}
