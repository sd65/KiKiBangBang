package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.NormalUser;
import dao.UserDao;

/**
 * Servlet implementation class inscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String CHAMP_EMAIL = "email";
    public static final String CHAMP_PASS = "motdepasse";
    public static final String CHAMP_CONF = "confirmation";
    public static final String CHAMP_FAMILYNAME = "familyName";
    public static final String CHAMP_FIRSTNAME = "firstName";
    public static final String CHAMP_ADDRESS = "address";
    public static final String CHAMP_PHONE = "phone";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'inscription */
        //this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* R�cup�ration des champs du formulaire. */
        String email = request.getParameter( CHAMP_EMAIL );
        String motDePasse = request.getParameter( CHAMP_PASS );
        String confirmation = request.getParameter( CHAMP_CONF );
        String familyName = request.getParameter( CHAMP_FAMILYNAME );
        String firstName = request.getParameter(CHAMP_FIRSTNAME);
        String address = request.getParameter(CHAMP_ADDRESS);
        String phone = request.getParameter(CHAMP_PHONE);
        
        NormalUser nu = new NormalUser();
        nu.setEmail(email);
        nu.setPassword(motDePasse);
        nu.setFamilyName(familyName);
        nu.setFirstName(firstName);
        nu.setAddress(address);
        nu.setTelephone(phone);
        
        int i = UserDao.insert(nu);

        request.setAttribute("result", i);
        request.setAttribute("email", email);
        
        if(i == 1) {
        	response.sendRedirect("index.jsp?justSignIn=true");
        }
        else {
        	response.sendRedirect("signIn.jsp?error=true");
        }
	}

}
