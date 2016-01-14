package controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.DiscussionIdea;
import bean.Idea;
import bean.NormalUser;
import bean.Question;
import bean.RedactionIdea;
import dao.IdeaDao;

/**
 * Servlet implementation class IdeaServlet
 */
@WebServlet("/IdeaServlet")
public class IdeaServlet extends HttpServlet {
	private static Logger LOGGER = Logger.getAnonymousLogger();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdeaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ideaID = Integer.parseInt(request.getParameter("id"));
		
		
		Idea idea = IdeaDao.find(ideaID);
		request.setAttribute("idea", idea);
		
		request.getRequestDispatcher("idea.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int ideaID = Integer.parseInt(request.getParameter("id"));
		Idea idea = IdeaDao.find(ideaID);
		NormalUser usr = (NormalUser) session.getAttribute("userLogged");
		
		
		if (request.getParameter("newQuestion") != null)
		{
			DiscussionIdea di = (DiscussionIdea) idea;
			usr.askQuestion(di,request.getParameter("newQuestion"));
			
		} else if (request.getParameter("vote") != null)
		{
			DiscussionIdea di = (DiscussionIdea) idea;
			if(request.getParameter("vote").equals("up"))
				usr.thumbUp(di);
			else
				usr.thumbDown(di);
			
		} else if (request.getParameter("redactionEnrich") != null)
		{
			RedactionIdea ri = (RedactionIdea) idea;
			ri.setRedactionEnrich(request.getParameter("redactionEnrich"));
			IdeaDao.update(ri);
		}  else if (request.getParameter("newComment") != null)
		{
			RedactionIdea ri = (RedactionIdea) idea;
			usr.doComment(ri, request.getParameter("newComment"));
		}
		
		doGet(request, response);
	}

}
