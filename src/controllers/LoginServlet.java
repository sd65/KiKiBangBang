package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.NormalUser;
import dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String VUE = "/index.jsp";
    public static final String CHAMP_EMAIL = "email";
    public static final String CHAMP_PASS = "pwd";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter(CHAMP_EMAIL);
		String pwd = request.getParameter(CHAMP_PASS);
		NormalUser nu = UserDao.findUserByEmail(email);
		PrintWriter out = response.getWriter();
		out.println("POSTED : ");
		out.println(email);
		out.println(pwd);
		out.println("DAO Reccupéré");
		out.println(nu.getEmail());
		out.println(nu.getPassword());
		if (nu.getEmail()==null){
			//TODO Erreur - utilisateur inexistant
			// TODO verifier admin
			Admin adm = UserDao.findAdminByEmail(email);
			if (adm.getEmail()==null){
				out.println("Erreur - utilisateur inexistant");				
			}
			else if (!adm.getPassword().equals(pwd)){
				//TODO Erreur - wrong admin password
				out.println("Erreur - wrong admin password");
			}
			else {
				//TODO Authentification admin réussie ->/admin
				out.print("redirect Admin accueil");
			}
		}
		else if (!nu.getPassword().equals(pwd)){
			//TODO Erreur - wrong password ->/user
			out.println("Erreur - wrong password");
		}
		else {
			// TODO Authentification réussie
			out.println("redirect NormalUser accueil");
		}
	}

}
