package co.simplon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.simplon.model.Pays;

public class PaysDaoImpl extends DAOContext implements DAO<Pays>{
	private DAOContext daoContext;
	Connection connexion = null;	
	
	public PaysDaoImpl( DAOContext daoContext ) {
		this.daoContext = daoContext;
	}
	
	@Override
	public void ajouter( Pays pays ) {
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = DriverManager.getConnection( db_url, db_username, db_password );
			preparedStatement = this.connexion.prepareStatement( "INSERT INTO Pays(nom) VALUES(?);" );
			preparedStatement.setString( 1, pays.getNom() );
			preparedStatement.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Pays> lister() {
		Statement statement = null;
		ResultSet resultset = null;
		List<Pays> Lpays = new ArrayList<Pays>();

		try {	
			connexion = DriverManager.getConnection( db_url, db_username, db_password );
			String strSQL = "SELECT * FROM Pays";
			statement = connexion.createStatement();
			resultset = statement.executeQuery( strSQL );
			while ( resultset.next() ) {
				int idPays = resultset.getInt( 1 );
				String nompays = resultset.getString( 2 );
				Pays pays = new Pays();
				pays.setId( idPays  );
				pays.setNom( nompays  );
				Lpays.add( pays );
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return Lpays;
	}
	
	public void supprimer  (Pays pays ) {
		PreparedStatement preparedStatement = null;

		try {
			connexion = DriverManager.getConnection( db_url, db_username, db_password );
			preparedStatement = connexion.prepareStatement( "DELETE FROM Pays WHERE nom=?;" );
			preparedStatement.setString( 1, pays.getNom() );
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public void modifier ( Pays pays, String nom ) {
		PreparedStatement preparedStatement = null;
		
		try {
		connexion = DriverManager.getConnection( db_url, db_username, db_password );
			preparedStatement = connexion.prepareStatement( "UPDATE Pays SET nom=? WHERE nom=?;" );
			preparedStatement.setString( 1, nom );		
			preparedStatement.setString( 2, pays.getNom() );
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}		

}