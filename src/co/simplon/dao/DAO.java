package co.simplon.dao;

import java.util.List;

import co.simplon.model.Pays;

public interface DAO<T> {
	public abstract void ajouter( T t );
	public abstract List<T> lister();
	public abstract void supprimer ( T t );
	public abstract void modifier ( T t, String tnom );	
}