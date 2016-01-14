package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.DiscussionIdea;
import bean.NormalUser;
import dao.IdeaDao;

/**
 * Servlet implementation class SubmitIdeaServlet
 */
@WebServlet("/SubmitIdeaServlet")
public class SubmitIdeaServlet extends HttpServlet {
	private static Logger LOGGER = Logger.getAnonymousLogger();
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/submitIdea.jsp";
	public static final String CHAMP_TITLE = "title";
	public static final String CHAMP_DESCRIPTION = "description";
	public static final String CHAMP_FUNDINGREQUESTED = "fundingRequested";
	public static final String CHAMP_TERMSOFUSECHECKBOX = "termsOfUseCheckbox";
	public static final String CHECKBOX_COCHEE = "on";
	public static final String CHECKBOX_NONCOCHEE = "null";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitIdeaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter(CHAMP_TITLE);
		String description = request.getParameter(CHAMP_DESCRIPTION);
		String fundingRequested = request.getParameter(CHAMP_FUNDINGREQUESTED);
		String termsOfUseCheckbox = request.getParameter(CHAMP_TERMSOFUSECHECKBOX);

		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		if (termsOfUseCheckbox==null) {
			// TODO MESSAGE D'ERREUR : "You have to accept Terms and conditions."
			out.println("FALSE");
		}
		else if(title.equals("") || description.equals("") || fundingRequested.equals("")){
			// TODO MESSAGE D'ERREUR : "All fields are required."
			out.println("All fields are required.");
		}
		else {
			NormalUser usr = (NormalUser) session.getAttribute("userLogged");
			LOGGER.info("User logged : " + usr.getEmail());
			DiscussionIdea di = new DiscussionIdea();
			di.setCreationDate(new Date());
			di.setFundsRequired(new BigDecimal(Float.parseFloat(fundingRequested)));
			di.setName(title);
			di.setProposer(usr);
			di.setShortDescription(description);
			IdeaDao.insert(di);

			response.sendRedirect("user/myIdeas");
		}
	}

}
