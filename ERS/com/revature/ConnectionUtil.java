package com.revature.util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static final String ORCL_DRIVER_CLASS="driver";
	private static final String ORCL_USERNAME="username";
	private static final String ORCL_PASSWORD="password";
	private static final String ORCL_URL ="url";
	private static Connection connection = null;
	private static Properties properties = null;

	public static Connection getConnection() throws SQLException, IOException {
		Properties prop = new Properties();
		InputStream in = ConnectionUtil.class.getClassLoader().getResourceAsStream("database.properties");
		prop.load(in);
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			}
			catch(ClassNotFoundException ex) {
			   System.out.println("ERROR");
			}
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	}
}
