
package co.simplon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.simplon.dao.*;
import co.simplon.model.Pays;

/**
 * Servlet implementation class helloworld
 */
@WebServlet(urlPatterns = "/helloworld", loadOnStartup = 1)
public class HelloWorld extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DAO<Pays> paysDao;

	public void init() throws ServletException {
		DAOContext.init( this.getServletContext() );
		DAOContext daoContext = new DAOContext();
		this.paysDao = daoContext.getPaysDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		request.setAttribute( "listePays", paysDao.lister() );
		request.getRequestDispatcher( "/WEB-INF/CountryMenu.jsp" ).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		/* Stocker le contenu du champ de saisie */
		String champPays = request.getParameter( "nomPays" );

		if ( request.getParameter( "btn1" ) != null || request.getParameter( "btn11" ) != null ) {
			if ( champPays != null && champPays != "" ) {
				Pays pays = new Pays();
				pays.setNom( champPays );
				paysDao.ajouter( pays );
			}
			request.setAttribute( "listePays", paysDao.lister() );
			request.getRequestDispatcher( "/WEB-INF/CountryAdd.jsp" ).forward (request, response );
		} else if ( request.getParameter( "btn2" ) != null || request.getParameter( "btn21" ) != null ) {
			String champPaysBis = request.getParameter( "nouvNomPays" );
			if ( champPays != null && champPays != "" && champPaysBis != "" ) {
				Pays pays = new Pays();
				pays.setNom( champPays );
				paysDao.modifier( pays, champPaysBis );
			}
			request.setAttribute( "listePays", paysDao.lister() );
			request.getRequestDispatcher( "/WEB-INF/CountryModify.jsp" ).forward( request, response );
		} else if ( request.getParameter( "btn3" ) != null || request.getParameter( "btn31" ) != null ) {
			if ( champPays != null && champPays != "" ) {
				Pays pays = new Pays();
				pays.setNom( champPays );
				paysDao.supprimer( pays );
			}
			request.setAttribute( "listePays", paysDao.lister() );
			request.getRequestDispatcher( "/WEB-INF/CountryDelete.jsp" ).forward( request, response );
		} else if ( request.getParameter( "btn12" ) != null || request.getParameter( "btn22" ) != null || request.getParameter( "btn32" ) != null) {
			request.setAttribute( "listePays", paysDao.lister() );
			request.getRequestDispatcher( "/WEB-INF/CountryMenu.jsp" ).forward( request, response );
		}
	}
}