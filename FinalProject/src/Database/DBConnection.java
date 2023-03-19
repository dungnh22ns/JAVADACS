package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
		private static DBConnection dbconnection = null; 
		public DBConnection() {
			getConnection();
		}
		// hàm dùng để kết nối với sql
		public static Connection getConnection() {
			Connection c = null;
			// đây là đoạn để viết code kết nối

			try {
				// đăng kí Mysql Driver với DriverManager
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				// các thông số
				String url = "jdbc:mySQL://localhost:3306/water_system";
				String username = "root";
				String password = "";
				// tạo kết nối
				c = DriverManager.getConnection(url, username, password);
				

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return c;
		}

		// hàm đùng để ngắt kết nối với sql
		public static void closeConnection(Connection c) {
			try {
				if (c != null) {
					c.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
