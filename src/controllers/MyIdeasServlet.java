package controllers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Idea;
import bean.NormalUser;
import dao.IdeaDao;

/**
 * Servlet implementation class MyIdeas
 */
@WebServlet("/MyIdeas")
public class MyIdeasServlet extends HttpServlet {
	private static Logger LOGGER = Logger.getAnonymousLogger();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyIdeasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// Récupérer la liste des idées de l'user connecté.
		HttpSession session = request.getSession();
		NormalUser usr = (NormalUser) session.getAttribute("userLogged");
		LOGGER.info("User logged : " + usr.getEmail());
		
		List<Idea> l = IdeaDao.findMyIdeas(usr);
		LOGGER.info("taille " + l.size());
		LOGGER.info(l.get(0).getName());
		request.setAttribute("ideaList", l);
		response.sendRedirect("myIdeas.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
