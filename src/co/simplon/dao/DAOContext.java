package co.simplon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;

public class DAOContext {
	/*
	 * static String driver = "com.mysql.cj.jdbc.Driver"; static String url =
	 * "jdbc:mysql://localhost:3306/testjdbc?serverTimezone=Europe/Paris"; static
	 * String login = "root"; static String password = "root";
	 */

	public static String db_url;
	public static String db_username;
	public static String db_password;

	public static void init( ServletContext context ) {
		try {
			Class.forName(context.getInitParameter( "JDBC_DRIVER" ) );
			db_url = context.getInitParameter( "JDBC_URL" );
			db_username = context.getInitParameter( "JDBC_LOGIN" );
			db_password = context.getInitParameter( "JDBC_PASSWORD" );
		} catch ( Exception exception ) {
			exception.printStackTrace();
		}
	}

	/*
	 * public static Connection getConnection() { Connection connexion = null; try {
	 * Class.forName( driver ); connexion = DriverManager.getConnection( db_url,
	 * db_username, db_password ); } catch (SQLException e) {
	 * System.out.println(("Erreur !")); e.printStackTrace(); } return connexion; }
	 */

	public PaysDaoImpl getPaysDao() {
		return new PaysDaoImpl (this );
	}

}
